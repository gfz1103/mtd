package com.buit.his.treatment.dao;

import com.buit.his.treatment.model.ZlSqdxmzlnr;
import com.buit.commons.EntityDao;

import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * 治疗申请单项目治疗内容表<br>
 * @author ZHOUHAISHENG
 */
@Mapper
public interface ZlSqdxmzlnrDao extends EntityDao<ZlSqdxmzlnr,Integer>{
    /**
     * 批量插入
     * @param zlSqdxmzlnrList
     */
    void insertForeach(List<ZlSqdxmzlnr> zlSqdxmzlnrList);

    /**
     * 通过jlxh删除数据
     * @param jlxh
     */
    void deleteByZlSqdmxJlxh(Integer jlxh);
}
