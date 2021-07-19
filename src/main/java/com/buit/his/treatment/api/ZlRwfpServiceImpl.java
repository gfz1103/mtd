package com.buit.his.treatment.api;


import cn.hutool.core.collection.CollectionUtil;
import com.buit.aop.lock.Locked;
import com.buit.commons.BaseException;
import com.buit.his.sams.service.SsGlbzSer;
import com.buit.his.treatment.ResultsUtil;
import com.buit.his.treatment.enums.PrescriptionTypeEnum;
import com.buit.his.treatment.enums.ZlRwZtEnum;
import com.buit.his.treatment.model.*;
import com.buit.his.treatment.service.*;
import com.buit.utill.BeanUtil;
import org.apache.dubbo.config.annotation.DubboService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.*;
import java.util.stream.Collectors;

/**
 * jiangwei
 * 康复治疗任务相关（医嘱状态改变后调用）实现
 */
@DubboService(timeout = 10000)
@Service
public class ZlRwfpServiceImpl implements ZlRwfpService {

    static final Logger logger = LoggerFactory.getLogger(SsGlbzSer.class);

    @Autowired
    private ZlRwfpSer zlRwfpSer;
    @Autowired
    private ZlZlzrwSer zlZlzrwSer;
    @Autowired
    private ZlRwmbSer zlRwmbSer;
    @Autowired
    private ZlZlpcSer zlZlpcSer;
    @Autowired
    private ZlZljlSer zlZljlSer;

    /**
     * 查询已经开始执行的治疗任务
     *
     * @param zyh 住院号
     */
    @Override
    public List<ZlRwfpModel> findStartExecutedList(Integer zyh) {
        List<ZlRwfp> rwfpList = zlRwfpSer.findStartExecutedList(zyh);
        if (CollectionUtil.isNotEmpty(rwfpList)) {
            List<ZlRwfpModel> results = BeanUtil.toBeans(rwfpList, ZlRwfpModel.class);
            return results;
        }
        return null;
    }

    /**
     * 电子病历 - 查询治疗记录
     *
     * @param zlrwfpid 治疗任务分配id
     */
    @Override
    public List<ZlZljlModel> findTreatmentRecords(Integer zlrwfpid) {
        List<ZlZljl> zljlList = zlZljlSer.findTreatmentRecords(zlrwfpid);
        if (CollectionUtil.isNotEmpty(zljlList)) {
            List<ZlZljlModel> results = BeanUtil.toBeans(zljlList, ZlZljlModel.class);
            return results;
        }
        return null;
    }

    /**
     * 增加治疗任务
     * 护士站复核康复治疗医嘱后调用
     *
     * @param yzList 医嘱集合
     */
    @Override
    @Transactional(rollbackFor = Exception.class)
    @Locked(value = {"repeatCreate_#[*yzList.yzJlxh]"})
    public void add(List<ZlRwfpUpdateReq> yzList) {
        List<Integer> yzjlxhList = yzList.stream().map(ZlRwfpUpdateReq::getYzJlxh).collect(Collectors.toList());
        List<ZlRwfp> exists = zlRwfpSer.findByYzjlxhList(yzjlxhList);
        //去除已生成过任务的医嘱记录序号

        if (CollectionUtil.isNotEmpty(exists)) {//该医嘱已有任务生成
            for (ZlRwfp r : exists) {
                if (yzjlxhList.contains(r.getYzJlxh())) {
                    yzjlxhList.remove(r.getYzJlxh());
                }
            }
        }
        //重新搜集需要生成任务的医嘱记录序号
        if (CollectionUtil.isNotEmpty(yzjlxhList)) {
            List<ZlRwfpUpdateReq> left = new ArrayList<>(yzjlxhList.size());
            for (ZlRwfpUpdateReq req : yzList) {
                if (yzjlxhList.contains(req.getYzJlxh())) {
                    left.add(req);
                }
            }

            zlRwfpSer.batchInsert(left);
        }
    }

    /**
     * 取消复核
     *
     * @param yzJlxhList 医嘱记录序号集合
     */
    @Override
    @Transactional(rollbackFor = Exception.class)
    @Locked(value = "repeatDelete_#[*yzJlxhList]")
    public void deleteByYzJlxh(List<Integer> yzJlxhList) {
        List<ZlRwfp> exists = zlRwfpSer.findByYzjlxhList(yzJlxhList);
        if (CollectionUtil.isEmpty(exists)) {
            return;
        }
        //任务分配主键
        List<Integer> rwfpIds = exists.stream().map(ZlRwfp::getZlrwfpid).collect(Collectors.toList());
        //子任务模板
        List<ZlRwmb> zlRwmbList = zlRwmbSer.findListByRwfpIds(rwfpIds);
        if (CollectionUtil.isNotEmpty(zlRwmbList)) {
            List<Integer> rwmbIds = zlRwmbList.stream().map(ZlRwmb::getJlxh).collect(Collectors.toList());
            //子任务主键
            List<ZlZlzrw> zrwList = zlZlzrwSer.findListByRwmbIds(rwmbIds);
            if (CollectionUtil.isNotEmpty(zrwList)) {
                for (ZlZlzrw zrw : zrwList) {
                    if (ZlRwZtEnum.DONE.equals(zrw.getZxzt())) {
                        throw BaseException.create("ERROR_ZL_00029");
                    }
                }
                List<Integer> zrwIds = zrwList.stream().map(ZlZlzrw::getJlxh).collect(Collectors.toList());
                //治疗批次主键
                Set<Integer> zlpcIds = zrwList.stream().map(ZlZlzrw::getZlpcJlxh).collect(Collectors.toSet());
                zlZlzrwSer.batchRwmove(zrwIds);
                zlZlpcSer.batchRemove(zlpcIds);
            }
            zlRwmbSer.batchRemove(rwmbIds);
        }
        zlRwfpSer.batchRemove(yzJlxhList);
    }

    /**
     * 停嘱
     */
    @Override
    @Transactional(rollbackFor = Exception.class)
    @Locked(value = "repeatDelete_#[*zlHzyzList.jlxh]")
    public ResultsUtil stopByYzJlxh(List<ZlHzyz> zlHzyzList, Integer jgid) {
        if (CollectionUtil.isNotEmpty(zlHzyzList)) {
            List<String> errorMessages = new ArrayList<>();
            boolean isSuccess = true;
            Map<Integer, String> errors = new HashMap<>();
            for (ZlHzyz zlHzyz : zlHzyzList) {
                if (PrescriptionTypeEnum.TEMPORARY.equals(zlHzyz.getLsyz())) {
                    continue;
                }
                ZlRwfp rwfp = zlRwfpSer.findByYzjlxh(zlHzyz.getJlxh());
                if (rwfp != null) {
                    ResultsUtil result = zlRwfpSer.lockAndFinish(rwfp, zlHzyz, jgid);
                    if (!result.isOk()) {
                        isSuccess = false;
                        errors.put(zlHzyz.getJlxh(), result.getString());
                        errorMessages.add(result.getString());
                    }
                }
            }
            if (!isSuccess) {
                return ResultsUtil.fail(CollectionUtil.join(errorMessages, ","), errors);
            }
        }
        return ResultsUtil.ok();
    }

    /**
     * 出院证检查
     */
    @Locked(value = {"isAllowedDischarge_#[zyh]"})
    public ResultsUtil dischargeCheck(Integer zyh) {
        return zlRwfpSer.lockAndCheck(zyh);
    }
}
