package com.buit.his.treatment.scheduled;

import cn.hutool.core.collection.CollectionUtil;
import com.buit.aop.lock.Locked;
import com.buit.his.treatment.enums.ZlRwZtEnum;
import com.buit.his.treatment.model.DicSypc;
import com.buit.his.treatment.model.ZlRwmb;
import com.buit.his.treatment.model.ZlZlpc;
import com.buit.his.treatment.response.ZlRwfpResp;
import com.buit.his.treatment.response.ZlRwmbResp;
import com.buit.his.treatment.service.*;
import com.buit.system.service.SysXtcsCacheSer;
import com.buit.utill.DateUtils;
import com.buit.utill.MtdmsUtil;
import com.buit.utill.RedisFactory;
import org.apache.dubbo.config.annotation.DubboReference;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

@Component
public class TreatmentTaskScheduled {

    static final Logger logger = LoggerFactory.getLogger(TreatmentTaskScheduled.class);

    @Autowired
    private ZlRwfpSer zlRwfpSer;
    @Autowired
    private ZlRwmbSer zlRwmbSer;
    @Autowired
    private ZlZlzrwSer zlZlzrwSer;
    @Autowired
    private ZlZlpcSer zlpcSer;
    @Autowired
    private DicSypcSer dicSypcSer;
    @Autowired
    private RedisFactory redisFactory;
    @DubboReference
    private SysXtcsCacheSer sysXtcsCacheSer;

    /**
     * 康复治疗计划自动生成 - 定时任务
     */
    @Scheduled(cron = "1 0 0 * * ?")
    public void autoCreate() {
        logger.info("康复治疗计划定时任务开始[" + DateUtils.formatToDateTime(DateUtils.getNow()) + "]");
        System.out.println("------------------------------------");
        List<ZlRwfpResp> tasks = zlRwfpSer.findTaskList();
        if (CollectionUtil.isEmpty(tasks)) {
            return;
        }

        String today = DateUtils.getToday();
        List<String> sypcList = tasks.stream().map(ZlRwfpResp::getSypc).distinct().collect(Collectors.toList());
        List<DicSypc> dicSypcList = dicSypcSer.findListByIds(sypcList);
        Map<String, DicSypc> sypcMap = dicSypcList.stream().collect(Collectors.toMap(DicSypc::getPcbm, Function.identity()));

        for (ZlRwfpResp task : tasks) {
            String max = today;//能生成的最大的日期
            if (task.getTzsj() != null) {//已停嘱
                //停嘱日期
                String tzrq = DateUtils.formatToDate(task.getTzsj());
                if (tzrq.compareTo(max) < 0) {
                    max = tzrq;
                }
            }
            if (task.getXczxrq() == null || task.getXczxrq().compareTo(max) > 0) {//下次执行日期在最大日期之后
                continue;
            }
            lockAndCreate(task, sypcMap, today, max);
        }
        logger.info("康复治疗计划定时任务结束[" + DateUtils.formatToDateTime(DateUtils.getNow()) + "]");
    }

    /**
     * 生成治疗任务
     *
     * @param task
     */
    @Transactional
    @Locked(value = "repeatDelete_#[task.yzJlxh]")
    public void lockAndCreate(ZlRwfpResp task, Map<String, DicSypc> sypcMap, String today, String max) {
        DicSypc sypc = sypcMap.get(task.getSypc());
        String[] zxsjList = sypc.getZxsj().split("-");
        //正在使用的子任务模板
        List<ZlRwmb> rwmbList = zlRwmbSer.findListByRwfpAndZxsj(task.getZlrwfpid(), Arrays.asList(zxsjList));
        if (CollectionUtil.isEmpty(rwmbList)) {
            return;
        }
        //该任务的所有模板是否均已预约
        boolean isAppointed = true;
        for (ZlRwmb mb : rwmbList) {
            if (ZlRwZtEnum.NOT.equals(mb.getYyzt())) {
                isAppointed = false;
            }
        }
        if (!isAppointed) {
            logger.info("任务模板未预约：{zlrwfpid:" + task.getZlrwfpid() + ",zyh:" + task.getZyh() + ", sfxmmc:" + task.getSfxmmc() + ",lsyz:" + task.getLsyz() + ",kssj:" + task.getKssj() + "}");
            return;
        }
        List<ZlRwmbResp> resps = rwmbList.stream().map(r -> new ZlRwmbResp(r, task.getZlksdm())).collect(Collectors.toList());


        //下次执行日期
        String nextDate = task.getXczxrq();
        //本次是否生成过任务
        boolean isCreated = false;
        for (; nextDate.compareTo(max) <= 0; ) {
            for (ZlRwmbResp resp : resps) {
                //生成下一次的批次和子任务
                ZlZlpc zlpc = zlpcSer.create(resp, nextDate, resp.getKssj(), resp.getJssj());
                zlZlzrwSer.create(zlpc.getJlxh(), resp, nextDate);
            }

            //更新下次执行日期
            if (sypc.getZxzq() == 1) {//每天执行
                nextDate = DateUtils.getTomorrow(nextDate);
            } else if (sypc.getRlz() == 1) {//日历周
                nextDate = MtdmsUtil.getNextExecuteDateByWeek(sypc.getRzxzq(), DateUtils.getTomorrow(nextDate));
            } else {//非日历周且非每天执行
                nextDate = MtdmsUtil.getNextExecuteDateByDays(sypc.getZxzq(), sypc.getRzxzq(), nextDate);
            }

            isCreated = true;
        }
        if (isCreated) {
            zlRwfpSer.updateExecuteDay(task.getZlrwfpid(), nextDate);
        }
    }
}
