package com.buit.his.sams.dao;

import com.buit.commons.EntityDao;
import com.buit.his.sams.model.SsZytfsqmx;
import com.buit.his.sams.model.SsZytfsqzb;
import com.buit.his.sams.response.SsZytfsqmxResp;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * 住院退费申请明细表<br>
 *
 * @author zhouhaisheng
 */
@Mapper
@Repository
public interface SsZytfsqmxDao extends EntityDao<SsZytfsqmx, Integer> {
    /**
     * 住院退费确认
     *
     * @param zbParam
     */
    void refundSure(SsZytfsqzb zbParam);

    void batchInsert(@Param("list") List<SsZytfsqmx> insertList);

    /**
     * 删除退费明细
     */
    void deleteByIdAndZt(@Param("jlxh") Integer jlxh, @Param("zt") int zt);

    /**
     * 住院退费明细
     *
     * @param tfsqdh 退费申请序号
     */
    List<SsZytfsqmxResp> findList(Integer tfsqdh);

}
