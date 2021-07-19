package com.buit.his.treatment.dao;

import com.buit.his.treatment.model.ZlSqdyyzx;
import com.buit.his.treatment.request.PatientZlyyQueryRep;
import com.buit.his.treatment.response.PatientZlyyQueryResp;
import com.buit.commons.EntityDao;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.sql.Timestamp;
import java.util.List;

/**
 * 治疗申请单预约执行表<br>
 * @author ZHOUHAISHENG
 */
@Mapper
public interface ZlSqdyyzxDao extends EntityDao<ZlSqdyyzx,Integer>{
    /**
     * 病人治疗执行分页查询
     * @param patientZlyyQueryRep
     * @return
     */
    List<PatientZlyyQueryResp> queryZlyyzxPage(PatientZlyyQueryRep patientZlyyQueryRep);


    /**
     * 取消执行
     * @param zlSqdyyzxUpdate
     */
    void cancelZx(ZlSqdyyzx zlSqdyyzxUpdate);

    /**
     * 按治疗申请单号统计已执行的预约记录数量
     * */
    long countByZlsqdhAndZt(@Param("jlxh") Integer jlxh, @Param("zt") int zt);


    /**
     * 通过住院号，执行日期，诊疗类别查询治疗申请单预约执行表
     * @param zyh
     * @param zxrq
     * @param zllb
     * @return
     */
    List<ZlSqdyyzx> queryZlXm(@Param("zyh") Integer zyh, @Param("zxrq")Timestamp zxrq,@Param("zllb") Integer zllb);

    /**
     * 修改执行状态
     * @param zlSqdyyzx
     */
    void updateZxzt(ZlSqdyyzx zlSqdyyzx);
}
