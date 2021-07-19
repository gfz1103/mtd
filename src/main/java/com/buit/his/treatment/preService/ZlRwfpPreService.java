package com.buit.his.treatment.preService;

import cn.hutool.core.collection.CollectionUtil;
import com.buit.aop.lock.Locked;
import com.buit.commons.BaseException;
import com.buit.constans.TableName;
import com.buit.his.treatment.enums.PrescriptionTypeEnum;
import com.buit.his.treatment.enums.ZlRwZtEnum;
import com.buit.his.treatment.model.*;
import com.buit.his.treatment.request.ZlRwfpReq;
import com.buit.his.treatment.service.*;
import com.buit.utill.DateUtils;
import com.buit.utill.MtdmsUtil;
import com.buit.utill.RedisFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service
public class ZlRwfpPreService {
    @Autowired
    private CisHzyzSer cisHzyzSer;
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

    /**
     * 任务分配
     *
     * @param req
     */
    @Transactional(rollbackFor = Exception.class)
    @Locked(value = {"saveTreatmentTask_#[req.zlrwfpid]"})
    public void rwfp(ZlRwfpReq req) {
        //数据验证
        ZlRwfp rwfp = zlRwfpSer.getById(req.getZlrwfpid());
        CisHzyz hzyz = cisHzyzSer.getById(rwfp.getYzJlxh());

        if (hzyz == null) {//医嘱不存在
            throw BaseException.create("ERROR_ZL_00032");
        }
        if (rwfp.getZllb() == null) {
            throw BaseException.create("ERROR_ZL_00028");
        }
        DicSypc sypc = dicSypcSer.getById(hzyz.getSypc());
        //第一次分配
        if (ZlRwZtEnum.NOT.equals(rwfp.getFpzt())) {
            //分配治疗师
            rwfp.setZlzid(req.getZlzid());
            rwfp.setZlsdm(req.getZlsdm());
            //首次执行日期
            String sczxrq = null;
            //下次执行日期
            String xczxrq = null;
            if (PrescriptionTypeEnum.TEMPORARY.equals(hzyz.getLsyz())) {//临时医嘱, 啥时候开啥时候执行
                sczxrq = DateUtils.formatToDate(hzyz.getKssj());
            } else if (PrescriptionTypeEnum.LONG_TERM.equals(hzyz.getLsyz())) {//长期医嘱, 则从开嘱日期的第二天开始准备执行
                sczxrq = DateUtils.getTomorrow(DateUtils.formatToDate(hzyz.getKssj()));
                if (sypc.getZxzq() == 1) {//每天执行
                    xczxrq = sczxrq;
                } else if (sypc.getRlz() == 1) {//日历周
                    xczxrq = MtdmsUtil.getNextExecuteDateByWeek(sypc.getRzxzq(), sczxrq);
                } else {//非日历周且非每天执行
                    xczxrq = sczxrq;
                }
            }
            rwfp = zlRwfpSer.rwfp(rwfp, sczxrq, xczxrq);
            //拆分任务模板
            List<ZlRwmb> list = zlRwmbSer.split(rwfp, hzyz, sypc);
            zlRwmbSer.batchInsert(list);
        } else {
            //重新分配分配治疗师
            rwfp.setZlzid(req.getZlzid());
            rwfp.setZlsdm(req.getZlsdm());
            rwfp = zlRwfpSer.rwfp(rwfp);
            //拆分任务模板
            List<ZlRwmb> list = zlRwmbSer.split(rwfp, hzyz, sypc);

            List<ZlRwmb> newRwmbs = new ArrayList<>(list.size());
            for (ZlRwmb rwmb : list) {
                ZlRwmb old = zlRwmbSer.getByRwfpAndZxsj(req.getZlrwfpid(), rwmb.getZxsj());
                if (old == null) {//没有正在使用的模板
                    newRwmbs.add(rwmb);
                } else {
                    //作废现有模板，空出治疗师的时间段
                    zlRwmbSer.cancelAppoint(old.getJlxh());
                    //生成新模板
                    ZlRwmb newRwmb = new ZlRwmb();
                    BeanUtils.copyProperties(old, newRwmb);
                    newRwmb.setJlxh(redisFactory.getTableKey(TableName.DB_NAME, TableName.ZL_RWMB));
                    newRwmb.setZxgh(rwfp.getZlsdm());
                    newRwmbs.add(newRwmb);

                    //还未执行的子任务
                    List<ZlZlzrw> notExectued = zlZlzrwSer.findNotExecuteByRwmbIs(old.getJlxh());
                    if (CollectionUtil.isNotEmpty(notExectued)) {
                        for (ZlZlzrw r : notExectued) {
                            //删除子任务所在批次
                            String zxrq = DateUtils.formatToDate(r.getZxsj());
                            zlpcSer.removeIfNotAppointed(r.getZlpcJlxh());
                            //创建新的治疗批次
                            ZlZlpc pc = zlpcSer.create(newRwmb, rwfp.getZlksdm(), zxrq);
                            //未执行的子任务更新执行工号，批次，模板主键
                            r.setZxgh(rwfp.getZlsdm());
                            r.setZlpcJlxh(pc.getJlxh());
                            r.setRwmbJlxh(newRwmb.getJlxh());
                            zlZlzrwSer.reRwfp(r);
                        }
                    }
                }
            }

            if (CollectionUtil.isNotEmpty(newRwmbs)) {
                zlRwmbSer.batchInsert(newRwmbs);
            }
        }

    }
}
