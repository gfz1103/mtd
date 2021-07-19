package com.buit.his.treatment.dao;

import com.buit.commons.EntityDao;
import com.buit.his.treatment.model.ZlZljl;
import com.buit.his.treatment.response.ZljlReportDetailResp;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author jiangwei
 * @Description 治疗记录表
 * @Date 2021-33-26
 */
@Mapper
@Repository
public interface ZlZljlDao extends EntityDao<ZlZljl, Integer> {
    /**
     * 按属性修改非空值
     */
    void updateByEntity(ZlZljl entry);

    /**
     * 治疗记录单打印 治疗记录数据
     *
     * @param zyh   住院号
     * @param zllb  诊疗类别
     * @param zlsdm 治疗师代码
     */
    List<ZljlReportDetailResp> findZljlReportDetailResp(@Param(value = "zyh") Integer zyh, @Param(value = "zllb") Integer zllb, @Param(value = "zlsdm") Integer zlsdm);

    /**
     * 通过任务分配id 查询治疗记录
     *
     * @param zlrwfpid 治疗任务分配id
     */
    List<ZlZljl> findTreatmentRecords(Integer zlrwfpid);
}
