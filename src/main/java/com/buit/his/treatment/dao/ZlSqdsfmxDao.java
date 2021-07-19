package com.buit.his.treatment.dao;

import com.buit.commons.EntityDao;
import com.buit.his.treatment.model.ZlSqdsfmx;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author jiangwei
 * @Description 门诊治疗申请 - 收费项目明细表
 * @Date 2021-04-27
 */
@Mapper
@Repository
public interface ZlSqdsfmxDao extends EntityDao<ZlSqdsfmx, Integer> {
    /**
     * 按属性修改非空值
     */
    void updateByEntity(ZlSqdsfmx entry);

    /**
     * 批量新增
     */
    void batchInsert(@Param(value = "list") List<ZlSqdsfmx> list);

    /**
     * 根据治疗申请单明细删除治疗申请单明细项目
     * @param jlxh
     */
    void deleteByJlxh(Integer jlxh);

    /**
     * 删除单个治疗项目明细对应的收费项目
     * @param sfxmmxJlxh
     */
    void deleteBySfxmmxJlxh(Integer sfxmmxJlxh);
}
