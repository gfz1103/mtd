package com.buit.his.sams.dao;

import com.buit.commons.EntityDao;
import com.buit.his.sams.model.SsZytfsqzb;
import com.buit.his.sams.request.QuerySsjzPageReq;
import com.buit.his.sams.request.RefundSureQueryPageReq;
import com.buit.his.sams.response.RefundSureQueryPageResp;
import com.buit.his.sams.response.SsZytfQueryPageResp;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * 住院退费申请主表<br>
 * @author zhouhaisheng
 */
@Mapper
@Repository
public interface SsZytfsqzbDao extends EntityDao<SsZytfsqzb,Integer>{
    /**
     * 门诊、住院退费申请(分页查询记账病人)
     *
     * @param ssZytfQueryPageReq
     * @return
     */
    List<SsZytfQueryPageResp> queryPage(QuerySsjzPageReq ssZytfQueryPageReq);

    /**
     * 住院确认退费分页查询
     * @param refundSureQueryPageReq
     * @return
     */
    List<RefundSureQueryPageResp> queryRefundSurePage(RefundSureQueryPageReq refundSureQueryPageReq);

    /**
     * 住院确认退费确认
     * @param zbParam
     */
    void refundSure(SsZytfsqzb zbParam);

}
