package com.buit.his.treatment.dao;

import com.buit.his.treatment.model.ZlXmzljh;

import com.buit.commons.EntityDao;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * 治疗项目治疗计划表<br>
 * @author ZHOUHAISHENG
 */
@Mapper
public interface ZlXmzljhDao extends EntityDao<ZlXmzljh,Integer> {
    /**
     * 查询最大的排序号码
     * @param zlXmzljh
     * @return
     */
    Integer queryMaxPxh(ZlXmzljh zlXmzljh);

    /**
     * 查询治疗项目是否维护治疗计划
     * @param zlxmJlxhList
     * @param jgid
     * @return
     */
    List<String> checkIsExitZljh(List<Integer> zlxmJlxhList,Integer jgid);

}
