package com.buit.his.sams.dao;

import com.buit.commons.EntityDao;
import com.buit.his.sams.model.SsSsjzdzb;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.sql.Timestamp;

/**
 * 手术记账单主表<br>
 *
 * @author zhouhaisheng
 */
@Mapper
@Repository
public interface SsSsjzdzbDao extends EntityDao<SsSsjzdzb, Integer> {

    /**
     * 手术申请保存审核信息
     *
     * @param sqdh 申请单号
     * @param shgh 审核工号
     * @param shsj 审核时间
     */
    void jzApprove(@Param(value = "sqdh") Integer sqdh, @Param(value = "shgh") Integer shgh, @Param(value = "shsj") Timestamp shsj);
}
