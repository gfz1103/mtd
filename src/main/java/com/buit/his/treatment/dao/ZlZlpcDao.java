package com.buit.his.treatment.dao;

import com.buit.commons.EntityDao;
import com.buit.his.treatment.model.ZlZljl;
import com.buit.his.treatment.model.ZlZlpc;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Set;

/**
 * @author jiangwei
 * @Date 2021-21-22
 */
@Mapper
@Repository
public interface ZlZlpcDao extends EntityDao<ZlZlpc, Integer> {

    /**
     * 修改非空属性
     *
     * @param pc
     */
    void updateByEntity(ZlZlpc pc);

    /**
     * 查询当天已执行过的治疗批次
     *
     * @param zlsdm 治疗师
     * @param zyh   住院号
     * @param zxrq  执行日期
     * @return
     */
//    List<ZlZlpc> getExecutedZlpc(@Param("zlsdm") Integer zlsdm, @Param("zyh") Integer zyh, @Param("zxrq") String zxrq);

    /**
     * 作废今天之前该时间段的批次
     */
//    void appointCancel(ZlZlpc query);

    /**
     * 治疗批次批量删除
     */
    void batchRemove(@Param("zlpcIds") Set<Integer> zlpcIds);

    /**
     * 根据治疗记录查询治疗批次
     *
     * @param zljl
     */
    List<ZlZlpc> findByZljl(ZlZljl zljl);

    /**
     * 删除批次（如果没有子任务关联）
     */
    void removeIfNotAppointed(Integer jlxh);
}
