package com.buit.his.treatment.dao;


import com.buit.his.treatment.model.ZlSqdmx;
import com.buit.his.treatment.request.DeptTreatStatisticsDetailReq;
import com.buit.his.treatment.request.DeptTreatStatisticsReq;
import com.buit.his.treatment.request.DoctorTreatStatisticsDetailReq;
import com.buit.his.treatment.request.DoctorTreatStatisticsReq;
import com.buit.his.treatment.request.ZlsqdMxCheckReq;
import com.buit.his.treatment.response.DeptTreatStatisticsDetailResp;
import com.buit.his.treatment.response.DeptTreatStatisticsResp;
import com.buit.his.treatment.response.DoctorTreatStatisticsDetailResp;
import com.buit.his.treatment.response.DoctorTreatStatisticsResp;
import com.buit.commons.EntityDao;
import com.buit.his.treatment.response.ZlSqdmxResp;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * 治疗申请单明细表<br>
 * @author ZHOUHAISHENG
 */
@Mapper
public interface ZlSqdmxDao extends EntityDao<ZlSqdmx,Integer> {


    /**
     * 校验申请单项目是否重复
     * @param zlsqdMxCheckReq
     * @return
     */
    List<ZlSqdmx> addCcheck(ZlsqdMxCheckReq zlsqdMxCheckReq);

    /**
     * 修改治疗申请单预约次数
     * @param zlSqdmxParam
     */
    void updateYYsl(ZlSqdmx zlSqdmxParam);

    /**
     * 治疗项目完成保存
     * @param updateZlSqdmx
     */
    void finishSave(ZlSqdmx updateZlSqdmx);

    /**
     * 取消治疗项目完成
     * @param updateZlSqdmx
     */
    void cancelFinish(ZlSqdmx updateZlSqdmx);

    /**
     * 查询统计-科室治疗工作量统计
     * @param deptTreatStatisticsReq
     * @return
     */
    List<DeptTreatStatisticsResp> queryDeptTreatStatistics(DeptTreatStatisticsReq deptTreatStatisticsReq);

    /**
     * 查询统计-科室治疗工作量统计(明细)
     * @param deptTreatStatisticsDetailReq
     * @return
     */
    List<DeptTreatStatisticsDetailResp> queryDeptTreatStatisticsDetail(DeptTreatStatisticsDetailReq deptTreatStatisticsDetailReq);

    /**
     * 查询统计-医生治疗工作量统计（分页查询）
     * @param doctorTreatStatisticsReq
     * @return
     */
    List<DoctorTreatStatisticsResp> queryDoctorTreatStatistics(DoctorTreatStatisticsReq doctorTreatStatisticsReq);

    /**
     * 查询统计-医生治疗工作量统计(明细明细 )
     * @param doctorTreatStatisticsDetailReq
     * @return
     */
    List<DoctorTreatStatisticsDetailResp> queryDoctorTreatStatisticsDetail(DoctorTreatStatisticsDetailReq doctorTreatStatisticsDetailReq);

    /**
     *查询统计-病人治疗申请单-申请单治疗项目
     * @param zlSqdmx
     * @return
     */
    List<ZlSqdmxResp> queryPatientZlyyReportDetail(ZlSqdmx zlSqdmx);

    /**
     * 通过主键修改状态和预约时间
     * @param zlSqdmx
     */
    void  updateZtBySqdmxId(ZlSqdmx zlSqdmx);

    /**
     * 通过主键修改预约时间
     * @param zlSqdmx
     */
    void updateyysjBysqdmxId(ZlSqdmx zlSqdmx);


    /**
     * 通过治疗申请单号查询申请项目
     * @param zlsqdh
     * @return
     */
    int selectCountSqdmx(Integer zlsqdh);

    /**
     * 通过治疗申请单号查询申请项目
     * @param zlsqdh
     * @return
     */
    List<ZlSqdmx> selectZlSqdmx(Integer zlsqdh);

    /**
     * 校验项目是否已经开过
     * @param zlxmJlxhList
     * @param jgid
     * @param jzlsh
     * @return
     */
    List<String> checkIsExit(List<Integer> zlxmJlxhList,Integer jgid,String jzlsh);

}
