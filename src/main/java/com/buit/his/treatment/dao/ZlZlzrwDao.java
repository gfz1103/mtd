package com.buit.his.treatment.dao;

import com.buit.commons.EntityDao;
import com.buit.his.treatment.model.ZlZlzrw;
import com.buit.his.treatment.request.*;
import com.buit.his.treatment.response.*;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author jiangwei
 * @Date 2021-21-22
 */
@Mapper
@Repository
public interface ZlZlzrwDao extends EntityDao<ZlZlzrw, Integer> {

    /**
     * 查询治疗执行患者列表
     */
    List<ExecutePatientResp> queryExecutePatientPage(ExecuteQueryReq req);

    /**
     * 查询患者当天子任务
     */
    List<ZlZlzrwResp> findList(ExecuteZlZrwQueryReq req);

    /**
     * 查询勾选的子任务中可以进行执行的记录
     *
     * @param list 子任务记录序号
     * @param zxzt 需要操作的子任务
     */
    List<ZlZlzrw> findListByIds(@Param("list") List<Integer> list, @Param("zxzt") Integer zxzt);

    /**
     * 查询勾选的子任务中
     *
     * @param zrwIdList 子任务记录序号
     */
    List<ZlZlzrw> findListByJlxh(@Param("list") List<Integer> zrwIdList);

    /**
     * 查询勾选的患者当天可以进行执行的记录
     *
     * @param zlsdm  治疗师代码
     * @param zlksdm 治疗科室代码
     * @param zyh    住院号
     * @param zxrq   执行日期
     * @param zllb   诊疗类别
     */
//    List<ZlZlzrw> findNotExecuteListByZyh(@Param("zlsdm") Integer zlsdm, @Param("zlksdm") Integer zlksdm, @Param("zyh") Integer zyh, @Param("zxrq") String zxrq, @Param("zllb") Integer zllb);

    /**
     * 根据治疗批次查询已执行的子任务
     */
    List<ZlZlzrw> getExecutedByZlpc(@Param("zlpcIds") List<Integer> zlpcIds);

    /**
     * 取消执行
     *
     * @param list 需要取消的子任务
     * @param qxgh 取消工号
     */
    void cancel(@Param("list") List<ZlZlzrw> list, @Param("qxgh") Integer qxgh);

    /**
     * 科室治疗工作量统计
     */
    List<DeptWorkloadReportResp> queryDeptWorkloadReportPage(DeptWorkloadReportReq req);

    /**
     * 医生治疗工作量统计
     */
    List<DoctorWorkloadReportResp> queryDoctorWorkloadReportPage(DoctorWorkloadReportReq req);

    /**
     * 治疗工作量统计 - 工作量明细
     */
    List<WorkloadDetailResp> queryWorkloadReportDetailPage(WorkloadDetailReq req);

    /**
     * 根据子任务模板主键查询
     *
     * @param rwmbIds 任务模板Id
     */
    List<ZlZlzrw> findListByRwmbIds(@Param("rwmbIds") List<Integer> rwmbIds);

    /**
     * 子任务批量删除
     */
    void batchRwmove(@Param("zrwIds") List<Integer> zrwIds);

    /**
     * 子任务批量删除
     */
    void batchRemove(@Param("list") List<ZlZlzrw> list);

    /**
     * 重新分配（修改批次，模板，执行工号）
     */
    void reRwfp(ZlZlzrw zlzrw);

    /**
     * 查找该模板最近一次的执行记录
     *
     * @param rwmbId 任务模板id
     */
    ZlZlzrw getLastTask(Integer rwmbId);

    /**
     * 创建子任务（同一天同一个模板只能有一条任务）
     */
    void create(ZlZlzrw entry);

    /**
     * 通过治疗批次主键查找
     */
    List<ZlZlzrw> findListByZlpcIds(@Param(value = "zlpcIds") List<Integer> zlpcIds);

    /**
     * 查找该日期之后 的执行任务
     *
     * @param tomorrow 第二天的开始时间
     */
    List<ZlZlzrw> findListOutRange(@Param("zlrwfpId") Integer zlrwfpId, @Param("tomorrow") String tomorrow);

    /**
     * 补记账次数归0
     */
    void updateBjzcs(@Param(value = "jlxh") Integer jlxh);

    /**
     * 同一时间模板的所有子任务
     *
     * @param zlrwfpid 治疗任务分配id
     * @param zxsj
     */
    List<ZlZlzrw> findListByRwfpIdAndZxsj(@Param(value = "zlrwfpid") Integer zlrwfpid, @Param(value = "zxsj") String zxsj);

    /**
     * 执行
     */
    void execute(ZlZlzrw e);

    /**
     * 出院证检查 - 未确费列表
     *
     * @param zyh 住院号
     */
    List<ZlrwCheckFailedResp> dischargeCheckList(@Param(value = "zyh") Integer zyh);
}
