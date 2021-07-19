package com.buit.his.treatment.preService;

import cn.hutool.core.bean.BeanUtil;
import cn.hutool.core.collection.CollectionUtil;
import com.buit.aop.lock.Locked;
import com.buit.his.treatment.enums.PrescriptionTypeEnum;
import com.buit.his.treatment.enums.ZlRwZtEnum;
import com.buit.his.treatment.model.*;
import com.buit.his.treatment.request.AppointmentSaveReq;
import com.buit.his.treatment.response.ZlRwmbResp;
import com.buit.his.treatment.service.*;
import com.buit.system.service.SysXtcsCacheSer;
import com.buit.utill.DateUtils;
import com.buit.utill.MtdmsUtil;
import org.apache.dubbo.config.annotation.DubboReference;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class AppointmentPreService {
    @Autowired
    private ZlRwmbSer zlRwmbSer;

    @Autowired
    private ZlZlpcSer zlZlpcSer;

    @Autowired
    private ZlZlzrwSer zlZlzrwSer;

    @Autowired
    private ZlRwfpSer zlRwfpSer;

    @Autowired
    private CisHzyzSer cisHzyzSer;

    @Autowired
    private DicSypcSer dicSypcSer;


    @DubboReference
    private SysXtcsCacheSer sysXtcsCacheSer;

    @Transactional(rollbackFor = Exception.class)
    @Locked(value = {"saveTreatmentTask_#[*rwfpIds]", "repeatAssigning_#[req.*jlxhList]"})
    public void save(AppointmentSaveReq req, Integer jgid, List<Integer> rwfpIds) {
        String today = DateUtils.getToday();
        //2021-05-06 预约时间段冲突校验取消
/*        //病人是否在这个时间段预约了其他医生
        boolean isAppointedOthers = zlRwmbSer.isAppointedOthers(req);
        if (isAppointedOthers) {
            throw BaseException.create("ERROR_ZL_00023");
        }*/
        List<ZlRwmbResp> rwmbList = zlRwmbSer.findListByIds(req.getJlxhList());

        List<ZlRwmbResp> newRwmbList = new ArrayList<>();//首次预约
        List<ZlRwmbResp> oldRwmbList = new ArrayList<>();//重新预约

        for (ZlRwmbResp rwmb : rwmbList) {
            if (ZlRwZtEnum.DONE.equals(rwmb.getYyzt())) {
                oldRwmbList.add(rwmb);
            } else if (ZlRwZtEnum.NOT.equals(rwmb.getYyzt())) {
                newRwmbList.add(rwmb);
            }
        }

        //保存新预约
        if (CollectionUtil.isNotEmpty(newRwmbList)) {
            //当天全部执行参数，小于此时间点默认该天的任务全部执行
//            String csz = sysXtcsCacheSer.getCsz(jgid, SysXtcsCsmcCts.QBZXSJ);
            zlRwmbSer.save(req.getKssj(), req.getJssj(), newRwmbList);

            Map<Integer, String> zxrqs = new HashMap<>();// key - 任务分配id，value - 下次执行时间（定时任务）

            for (ZlRwmbResp insert : newRwmbList) {
                //预备首次执行日期(临时医嘱当天，长期医嘱第二天)
                String sczxrq = insert.getSczxrq();
                ZlRwfp rwfp = zlRwfpSer.getById(insert.getZlrwfpid());
                CisHzyz cisHzyz = cisHzyzSer.getById(rwfp.getYzJlxh());
                DicSypc dicSypc = dicSypcSer.getById(insert.getPc());

                //首次预约生成的任务日期范围最大为今天或者停嘱日期当天（取较小值）
                String maxDate = today;
                if (cisHzyz.getTzsj() != null) {
                    maxDate = DateUtils.formatToDate(cisHzyz.getTzsj());
                }
                if (maxDate.compareTo(today) > 0) {
                    maxDate = today;
                }

                if (PrescriptionTypeEnum.TEMPORARY.equals(insert.getLsyz())) {//临时医嘱
                    //生成批次
                    ZlZlpc zlpc = zlZlpcSer.create(insert, sczxrq, req.getKssj(), req.getJssj());
                    //创建子任务
                    zlZlzrwSer.create(zlpc.getJlxh(), insert, sczxrq);
                } else if (PrescriptionTypeEnum.LONG_TERM.equals(insert.getLsyz())) {//长期医嘱
                    if (sczxrq.compareTo(maxDate) > 0) {//首次执行日期大于今天
                        continue;
                    }
                    //子任务执行日期（按执行周期查找）
                    String zxrq = sczxrq;

                    if (dicSypc.getZxzq() == 1) {//频次为每天都执行
                        for (; zxrq.compareTo(maxDate) <= 0; zxrq = DateUtils.getTomorrow(zxrq)) {
                            ZlZlpc zlpc = zlZlpcSer.create(insert, zxrq, req.getKssj(), req.getJssj());
                            zlZlzrwSer.create(zlpc.getJlxh(), insert, zxrq);
                        }
                    } else if (dicSypc.getRlz() == 1) {//日历周
                        zxrq = MtdmsUtil.getNextExecuteDateByWeek(dicSypc.getRzxzq(), sczxrq);
                        for (; zxrq.compareTo(maxDate) <= 0; zxrq = MtdmsUtil.getNextExecuteDateByWeek(dicSypc.getRzxzq(), DateUtils.getTomorrow(zxrq))) {
                            ZlZlpc zlpc = zlZlpcSer.create(insert, zxrq, req.getKssj(), req.getJssj());
                            zlZlzrwSer.create(zlpc.getJlxh(), insert, zxrq);
                        }
                    } else {//非日历周且非每天执行
                        zxrq = sczxrq;
                        for (; zxrq.compareTo(maxDate) < 0; zxrq = MtdmsUtil.getNextExecuteDateByDays(dicSypc.getZxzq(), dicSypc.getRzxzq(), zxrq)) {
                            ZlZlpc zlpc = zlZlpcSer.create(insert, zxrq, req.getKssj(), req.getJssj());
                            zlZlzrwSer.create(zlpc.getJlxh(), insert, zxrq);
                        }
                    }
                    //设定定时任务下次执行时间
                    zxrqs.put(insert.getZlrwfpid(), zxrq);
                }

            }

            for (Map.Entry<Integer, String> rwZxrq : zxrqs.entrySet()) {
                zlRwfpSer.updateExecuteDay(rwZxrq.getKey(), rwZxrq.getValue());
            }
        }

        //重新预约
        if (CollectionUtil.isNotEmpty(oldRwmbList)) {

            Map<ZlZlzrw, ZlRwmbResp> map = new HashMap<>(oldRwmbList.size());
            for (ZlRwmbResp update : oldRwmbList) {
                //作废原模板
                zlRwmbSer.cancelAppoint(update.getJlxh());

                //生成新的任务模板
                ZlRwmb newRwmb = zlRwmbSer.reAppoint(update, req.getKssj(), req.getJssj());
                ZlRwmbResp entry = BeanUtil.toBean(newRwmb, ZlRwmbResp.class);
                entry.setZlksdm(update.getZlksdm());
                //该任务同时间点模板的子任务
                List<ZlZlzrw> zrwList = zlZlzrwSer.findListByRwfpIdAndZxsj(update.getZlrwfpid(), update.getZxsj() + ":00");
                //所有子任务已删除
                if (CollectionUtil.isEmpty(zrwList)) {
                    //2021-05-24 已改为定时任务
/*                    String sczxrq = update.getSczxrq();
                    //临时
                    if (PrescriptionTypeEnum.TEMPORARY.equals(newRwmb.getLsyz())) {
                        //生成批次
                        ZlZlpc zlpc = zlZlpcSer.create(entry, sczxrq, req.getKssj(), req.getJssj());
                        //创建子任务
                        zlZlzrwSer.create(zlpc.getJlxh(), entry, sczxrq, 0);
                    } else {//长期
                        DicSypc dicSypc = dicSypcSer.getById(update.getPc());
                        //当天全部执行参数，小于此时间点默认该天的任务全部执行
                        String csz = sysXtcsCacheSer.getCsz(jgid, SysXtcsCsmcCts.QBZXSJ);
                        //下一次执行任务的时间及补记账次数
                        ZlZlzrw nextTask = MtdmsUtil.getNext(dicSypc, sczxrq, csz, update.getZxsj());
                        //生成批次
                        ZlZlpc zlpc = zlZlpcSer.create(entry, DateUtils.formatToDate(nextTask.getZxsj()), req.getKssj(), req.getJssj());
                        //创建子任务
                        zlZlzrwSer.create(zlpc.getJlxh(), entry, DateUtils.formatToDate(nextTask.getZxsj()), nextTask.getBjzcs());
                    }*/
                } else {
                    for (ZlZlzrw zrw : zrwList) {
                        if (ZlRwZtEnum.DONE.equals(zrw.getZxzt())) {
                            continue;
                        }
                        String zxrq = DateUtils.formatToDate(zrw.getZxsj());
                        //生成新批次
                        ZlZlpc zlpc = zlZlpcSer.create(entry, zxrq, req.getKssj(), req.getJssj());
                        //未执行任务修改模板id和批次id
                        zrw.setRwmbJlxh(newRwmb.getJlxh());
                        zrw.setZlpcJlxh(zlpc.getJlxh());
                        zlZlzrwSer.reRwfp(zrw);
                    }
                }

            }
        }
    }

}
