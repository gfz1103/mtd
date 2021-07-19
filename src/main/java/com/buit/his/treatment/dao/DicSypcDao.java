package com.buit.his.treatment.dao;

import com.buit.commons.EntityDao;
import com.buit.his.treatment.model.DicSypc;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * 公用_使用频次<br>
 *
 * @author GONGFANGZHOU
 */
@Mapper
@Repository
public interface DicSypcDao extends EntityDao<DicSypc, String> {
    /**
     * 批量查询
     *
     * @param sypcList 频次编码数组
     */
    List<DicSypc> findListByIds(@Param("sypcList") List<String> sypcList);
}
