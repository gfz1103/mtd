package com.buit.his.treatment.dao;

import com.buit.commons.EntityDao;
import com.buit.his.treatment.model.ZlRwmb;
import com.buit.his.treatment.request.AppointmentQueryReq;
import com.buit.his.treatment.request.AppointmentReportReq;
import com.buit.his.treatment.response.AppointmentPatientResp;
import com.buit.his.treatment.response.AppointmentReportResp;
import com.buit.his.treatment.response.ZlRwmbResp;
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
public interface ZlRwmbDao extends EntityDao<ZlRwmb, Integer> {

    /**
     * 按属性修改非空值
     */
    void updateByEntity(ZlRwmb entry);

    /**
     * 查询住院治疗预约病人列表
     *
     * @param req
     * @return
     */
    List<AppointmentPatientResp> queryAppointmentPatientPage(AppointmentQueryReq req);

    /**
     * 批量插入
     */
    void batchInsert(@Param("list") List<ZlRwmb> list);

    /**
     * 住院号查询所有模板
     *
     * @param zyh    住院号
     * @param zlksdm 治疗科室代码
     * @param zllb   诊疗类别
     * @param zxgh   执行工号
     */
    List<ZlRwmbResp> findList(@Param("zyh") Integer zyh, @Param("zlksdm") Integer zlksdm, @Param("zllb") Integer zllb, @Param("zxgh") Integer zxgh, @Param("yyzt") Integer yyzt);

    /**
     * 批量保存预约时间段
     */
    void batchAppoint(@Param("kssj") String kssj, @Param("jssj") String jssj, @Param("list") List<ZlRwmbResp> list);

    /**
     * 主键数组查询
     */
    List<ZlRwmbResp> findListByIds(@Param("list") List<Integer> list);

    /**
     * 批量执行
     */
    void batchExecute(@Param("list") List<ZlRwmb> rwmbList);

    /**
     * 住院病人治疗预约查询
     */
    List<AppointmentReportResp> queryAppointmentReportPage(AppointmentReportReq req);

    /**
     * 根据治疗任务查询子任务模板
     *
     * @param rwfpIds 任务分配主键
     */
    List<ZlRwmb> findListByRwfpIds(@Param("rwfpIds") List<Integer> rwfpIds);

    /**
     * 任务模板批量删除
     */
    void batchRemove(@Param("rwmbIds") List<Integer> rwmbIds);

    /**
     * 批量完成（停嘱）
     *
     * @param rwmbIds 已开始执行的任务模板主键
     */
    void batchFinish(@Param("rwmbIds") List<Integer> rwmbIds);

    /**
     * 取消执行
     */
    void cancelExecute(@Param("rwmbIds") List<Integer> rwmbIds);

    /**
     * 重新预约作废模板
     */
    void cancelAppoint(@Param("oldRwmbList") List<ZlRwmbResp> oldRwmbList);

    /**
     * 查询正在使用的任务模板
     *
     * @param zlrwfpid 治疗任务分配id
     * @param zxsjList 执行时间点（24小时制）
     */
    List<ZlRwmb> findListByRwfpAndZxsj(@Param("zlrwfpid") Integer zlrwfpid, @Param("zxsjList") List<String> zxsjList);
}
