package com.buit.his.sams.dao;

import com.buit.commons.EntityDao;
import com.buit.his.sams.model.SsSsap;
import com.buit.his.sams.request.SsSsapQueryPageReq;
import com.buit.his.sams.request.SsapViewQueryPageReq;
import com.buit.his.sams.response.SsSsapQueryPageResp;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * 手术安排表<br>
 * @author zhouhaisheng
 */
@Mapper
@Repository
public interface SsSsapDao extends EntityDao<SsSsap,Integer>{

    /**
     * 手术安排一览表分页查询
     * @param ssapViewQueryPageReq
     * @return
     */
    List<SsSsapQueryPageResp> ssapView(SsapViewQueryPageReq ssapViewQueryPageReq);

    /**
     * 查询手术安排分页数据
     * @param ssSsapQueryPageReq
     * @return
     */
    List<SsSsapQueryPageResp> querySsapPage(SsSsapQueryPageReq ssSsapQueryPageReq);

}
