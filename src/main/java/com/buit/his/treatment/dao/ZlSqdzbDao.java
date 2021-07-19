package com.buit.his.treatment.dao;


import com.buit.commons.EntityDao;
import com.buit.his.treatment.model.ZlSqdmx;
import com.buit.his.treatment.model.ZlSqdzb;
import com.buit.his.treatment.model.bookKeepingData;
import com.buit.his.treatment.request.*;
import com.buit.his.treatment.response.*;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

/**
 * 治疗申请单主表<br>
 * @author ZHOUHAISHENG
 */
@Mapper
@Repository
public interface ZlSqdzbDao extends EntityDao<ZlSqdzb,Integer> {
    /**
     * 分页查询病人申请单列表
     * @param zlSqdzbPageQueryReq
     * @return
     */
    List<ZlSqdzbPageResp> queryPage(ZlSqdzbPageQueryReq zlSqdzbPageQueryReq);

    /**
     * 分页查询病人治疗预约信息
     *
     * @param zlyyPageQueryReq
     * @return
     */
    List<ZlyyPageQueryResp> queryAppointPage(ZlyyPageQueryReq zlyyPageQueryReq);

    /**
     * 查询统计-病人治疗申请单查询
     * @param patientTreatFromQueryReq
     * @return
     */
    List<PatientTreatFromQueryResp> queryPatientZlyyReport(PatientTreatFromQueryReq patientTreatFromQueryReq);

    /**
     * 获取患者治疗申请单主表信息
     * @param jlxh
     * @return
     */
    Map<String,Object> getZlSqdzbMap(Integer jlxh);

    /**
     * 修改状态
     * @param zt
     * @param jlxh
     */
    void updateZtById(@Param("zt") int zt, @Param("jlxh") Integer jlxh);

    /**
     * 查询住院患者治疗预约数据
     * @param param
     * @return
     */
    List<QueryZyzlyyResp> queryZyzlyy(QueryZyzlyyReq param);

    /**
     * 查询预约治疗项目详情
     * @return
     */
    List<QueryZyzlyyDetailResp> queryZyzDetail(QueryZyzlyyDetailReq param);

    /**
     * 查询项目类型不同于当前的项目数据
     * @param jgid
     * @param zllb
     * @param zyh
     * @return
     */
    List<ZlSqdmx> queryNotIdentity(@Param("jgid") Integer jgid, @Param("zllb") Integer zllb, @Param("zyh") Integer zyh);

    /**
     * 查询治疗执行数据
     * @param param
     * @return
     */
    List<ImpleZyzlyyResp> queryZyzlzx(ImpleZyzlyyReq param);

    /**
     * 查看执行状态（住院号，诊疗类别，执行时间 ）
     * @param zyh
     * @param zllb
     * @param zxrq
     * @return
     */
    int queryZxzt(@Param("zyh") Integer zyh,@Param("zllb") Integer zllb,@Param("zxrq") String zxrq);

    /**
     * 查询病人情况(住院号，诊疗类别)
     * @param zyh
     * @param zllb
     */
    int queryBrqk(@Param("zyh") Integer zyh,@Param("zllb") Integer zllb);

    /**
     * 通过住院号查询患者还需要执行的项目[还需过滤掉临时医嘱的项目]
     * @param param
     * @return
     */
    List<QueryZyzlZxDetailResp> queryZxXm(QueryZyzlZxDetailReq param);

    /**
     * 获取诊疗记账数据
     *
     * @param sqdmxidList
     * @return
     */
    List<bookKeepingData> bookKeepingData(@Param("sqdmxidList") List<Integer> sqdmxidList);

    /**
     * 按属性修改非空值
     */
    void updateByEntity(ZlSqdzb entry);

}
