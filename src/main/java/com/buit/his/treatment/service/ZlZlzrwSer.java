package com.buit.his.treatment.service;


import com.buit.commons.BaseManagerImp;
import com.buit.constans.TableName;
import com.buit.his.treatment.dao.ZlZlzrwDao;
import com.buit.his.treatment.enums.SpecialTaskEnum;
import com.buit.his.treatment.enums.ZlRwZtEnum;
import com.buit.his.treatment.model.ZlZlzrw;
import com.buit.his.treatment.request.*;
import com.buit.his.treatment.response.*;
import com.buit.utill.DateUtils;
import com.buit.utill.RedisFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author jiangwei
 * @Date 2021-21-22
 */
@Service
public class ZlZlzrwSer extends BaseManagerImp<ZlZlzrw, Integer> {

    static final Logger logger = LoggerFactory.getLogger(ZlZlzrwSer.class);

    @Autowired
    private ZlZlzrwDao zlZlzrwDao;
    @Autowired
    private RedisFactory redisFactory;

    @Override
    public ZlZlzrwDao getEntityMapper() {
        return zlZlzrwDao;
    }

    /**
     * 生成子任务
     *
     * @param pcJlxh 治疗批次记录序号
     * @param rwmb   子任务模板
     * @param zxrq   执行日期
     */
    public void create(Integer pcJlxh, ZlRwmbResp rwmb, String zxrq) {
        ZlZlzrw entry = new ZlZlzrw();
        entry.setJlxh(redisFactory.getTableKey(TableName.DB_NAME, TableName.ZL_ZLZRW));
        entry.setZlrwfpid(rwmb.getZlrwfpid());
        entry.setRwmbJlxh(rwmb.getJlxh());
        entry.setZlpcJlxh(pcJlxh);
        entry.setZxzt(ZlRwZtEnum.NOT.getValue());
        entry.setZxgh(rwmb.getZxgh());
        entry.setBjzcs(0);

        String zxsjStr = zxrq + " " + rwmb.getZxsj() + ":00";
        entry.setZxsj(DateUtils.parseToDateTime(zxsjStr));

        zlZlzrwDao.create(entry);
    }

    /**
     * 查询治疗执行患者列表
     */
    public List<ExecutePatientResp> queryExecutePatientPage(ExecuteQueryReq req) {
        List<ExecutePatientResp> list = zlZlzrwDao.queryExecutePatientPage(req);
        for (ExecutePatientResp resp : list) {
            StringBuffer sb = new StringBuffer("");
            if (resp.isNew()) {
                sb.append(SpecialTaskEnum.IS_NEW.getText() + ";");
            }
            if (resp.isNeedSummary()) {
                sb.append(SpecialTaskEnum.IS_NEED_SUMMARY.getText() + ";");
            }
            if (resp.isNew() || resp.isNeedSummary()) {
                sb.setLength(sb.length() - 1);
            }
            resp.setHzqk(sb.toString());
        }
        return list;
    }

    /**
     * 查询患者当天子任务
     */
    public List<ZlZlzrwResp> findList(ExecuteZlZrwQueryReq req) {
        return zlZlzrwDao.findList(req);
    }

    /**
     * 查询勾选的子任务中需要操作的记录
     *
     * @param jlxhList 子任务记录序号
     * @param zxzt     执行状态
     */
    public List<ZlZlzrw> findListByIds(List<Integer> jlxhList, Integer zxzt) {
        return zlZlzrwDao.findListByIds(jlxhList, zxzt);
    }

    /**
     * 查询勾选的子任务
     *
     * @param zrwIdList 子任务记录序号
     */
    public List<ZlZlzrw> findListByIds(List<Integer> zrwIdList) {
        return zlZlzrwDao.findListByJlxh(zrwIdList);
    }

    /* *//**
     * 查询勾选的患者当天可以进行执行的记录
     *
     * @param zlsdm  治疗师代码
     * @param zlksdm 治疗科室代码
     * @param zyh    住院号
     * @param zxrq   执行日期
     * @param zllb   诊疗类别
     *//*
    public List<ZlZlzrw> findNotExecuteListByZyh(Integer zlsdm, Integer zlksdm, Integer zyh, String zxrq, Integer zllb) {
        return zlZlzrwDao.findNotExecuteListByZyh(zlsdm, zlksdm, zyh, zxrq, zllb);
    }*/

    /**
     * 查询该模板尚未执行的子任务
     *
     * @param rwmbId 任务模板id
     */
    public List<ZlZlzrw> findNotExecuteByRwmbIs(Integer rwmbId) {
        ZlZlzrw query = new ZlZlzrw();
        query.setRwmbJlxh(rwmbId);
        query.setZxzt(ZlRwZtEnum.NOT.getValue());
        return zlZlzrwDao.findByEntity(query);
    }

    /**
     * 子任务批量执行
     *
     * @param zrwList 子任务集合
     * @param zlsdm   治疗师代码
     */
    public void batchExecute(List<ZlZlzrw> zrwList, Integer zlsdm) {
        for (ZlZlzrw e : zrwList) {
            e.setJzgh(zlsdm);
            zlZlzrwDao.execute(e);
        }
    }

    /**
     * 根据治疗批次查询已执行的子任务
     */
    public List<ZlZlzrw> getExecutedByZlpc(List<Integer> zlpcList) {
        return zlZlzrwDao.getExecutedByZlpc(zlpcList);
    }

    /**
     * 取消执行
     *
     * @param list   需要取消执行的子任务
     * @param userId 取消工号
     */
    public void cancel(List<ZlZlzrw> list, Integer userId) {
        zlZlzrwDao.cancel(list, userId);
    }

    /**
     * 科室治疗工作量统计
     */
    public List<DeptWorkloadReportResp> queryDeptWorkloadReportPage(DeptWorkloadReportReq req) {
        return zlZlzrwDao.queryDeptWorkloadReportPage(req);
    }

    /**
     * 医生治疗工作量统计
     */
    public List<DoctorWorkloadReportResp> queryDoctorWorkloadReportPage(DoctorWorkloadReportReq req) {
        return zlZlzrwDao.queryDoctorWorkloadReportPage(req);
    }

    /**
     * 治疗工作量统计 - 工作量明细
     */
    public List<WorkloadDetailResp> queryWorkloadReportDetailPage(WorkloadDetailReq req) {
        return zlZlzrwDao.queryWorkloadReportDetailPage(req);
    }

    /**
     * 根据子任务模板主键查询
     *
     * @param rwmbId 任务模板Id
     */
    public List<ZlZlzrw> findListByRwmbId(Integer rwmbId) {
        ZlZlzrw query = new ZlZlzrw();
        query.setRwmbJlxh(rwmbId);
        return findByEntity(query);
    }

    /**
     * 根据子任务模板主键查询
     *
     * @param rwmbIds 任务模板Id
     */
    public List<ZlZlzrw> findListByRwmbIds(List<Integer> rwmbIds) {
        return zlZlzrwDao.findListByRwmbIds(rwmbIds);
    }

    /**
     * 子任务批量删除
     */
    public void batchRwmove(List<Integer> zrwIds) {
        zlZlzrwDao.batchRwmove(zrwIds);
    }

    /**
     * 子任务批量删除
     */
    public void batchRemove(List<ZlZlzrw> list) {
        zlZlzrwDao.batchRemove(list);
    }

    /**
     * 重新分配（修改治疗师，批次id,模板id）
     */
    public void reRwfp(ZlZlzrw zlZlzrw) {
        zlZlzrwDao.reRwfp(zlZlzrw);
    }

    /**
     * 查找该模板最近一次的执行记录
     *
     * @param rwmbId 任务模板id
     */
    public ZlZlzrw getLastTask(Integer rwmbId) {
        return zlZlzrwDao.getLastTask(rwmbId);
    }

    /**
     * 通过治疗批次主键查找
     */
    public List<ZlZlzrw> findListByZlpcIds(List<Integer> zlpcIds) {
        return zlZlzrwDao.findListByZlpcIds(zlpcIds);
    }

    /**
     * 查找该日期之后 的执行任务
     *
     * @param dailyStartTime
     */
    public List<ZlZlzrw> findListOutRange(Integer zlrwfpId, String dailyStartTime) {
        return zlZlzrwDao.findListOutRange(zlrwfpId, dailyStartTime);
    }

    /**
     * 通过任务分配主键查询
     *
     * @param zlrwfpid 任务分配主键
     */
    public List<ZlZlzrw> findListByRwfpId(Integer zlrwfpid) {
        ZlZlzrw query = new ZlZlzrw();
        query.setZlrwfpid(zlrwfpid);
        query.setSortColumns("zxsj");
        return zlZlzrwDao.findByEntity(query);
    }

    /**
     * 拆分之后将原补记账次数归0
     *
     * @param jlxh 子任务记录序号
     */
    public void updateBjzcs(Integer jlxh) {
        zlZlzrwDao.updateBjzcs(jlxh);
    }

    /**
     * 同一时间模板的所有子任务
     *
     * @param zlrwfpid 治疗任务分配id
     * @param zxsj
     */
    public List<ZlZlzrw> findListByRwfpIdAndZxsj(Integer zlrwfpid, String zxsj) {
        return zlZlzrwDao.findListByRwfpIdAndZxsj(zlrwfpid, zxsj);
    }

    /**
     * 主键删除
     */
    public void deleteById(Integer jlxh) {
        zlZlzrwDao.deleteById(jlxh);
    }

    /**
     * 出院证检查 - 未确费列表
     *
     * @param zyh 住院号
     */
    public List<ZlrwCheckFailedResp> dischargeCheckList(Integer zyh) {
        return zlZlzrwDao.dischargeCheckList(zyh);
    }
}
