package com.buit.his.sams.dao;

import com.buit.commons.EntityDao;
import com.buit.his.sams.model.SsSsjzdmx;
import com.buit.his.sams.request.QuerySsjzPageReq;
import com.buit.his.sams.request.SsPubReq;
import com.buit.his.sams.request.SsmzxmReq;
import com.buit.his.sams.request.SsssrtjReq;
import com.buit.his.sams.response.*;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.math.BigDecimal;
import java.util.List;

/**
 * 手术记账单明细表<br>
 * @author zhouhaisheng
 */
@Mapper
@Repository
public interface SsSsjzdmxDao extends EntityDao<SsSsjzdmx,Integer>{
    /**
     * 查询预交金额
     * @param zyh
     * @return
     */
    BigDecimal queryYjje(Integer zyh);

    /**
     * 查询合计费用
     * @param zyh
     * @return
     */
    BigDecimal queryHjfy(Integer zyh);

    /**
     * 手术记账基本信息查询
     * @param zyhm
     * @return
     */
//    SsjzBaseInfoResp querySsjzBaseInfoResp(String zyhm);

    /**
     * 手术记账病人分页查询
     * @param querySsjzPageReq
     * @return
     */
    List<QuerySsjzPageResp> querySsjzPage(QuerySsjzPageReq querySsjzPageReq);

    /**
     * 手术间工作量统计
     * @param ssPubReq
     * @return
     */
    List<SsjgzltjResp> querySsjgzltj(SsPubReq ssPubReq);

    /**
     * 麻醉医生工作量统计
     * @param ssPubReq
     * @return
     */
    List<MzysgzltjResp> queryMzysgzltj(SsPubReq ssPubReq);

    /**
     * 手术医生工作量统计
     * @param ssPubReq
     * @return
     */
    List<SsysgzltjResp> querySsysgzltj(SsPubReq ssPubReq);

    /**
     * 手术科室工作量统计
     * @param ssPubReq
     * @return
     */
    List<SsksgzltjResp> querySsksgzltj(SsPubReq ssPubReq);

    /**
     * 手术室收入统计
     * @param ssssrtjReq
     * @return
     */
    List<SsssrtjResp> querySsssrtj(SsssrtjReq ssssrtjReq);

    /**
     *
     * 批量新增
     * */
    void batchInsert(@Param("list") List<SsSsjzdmx> ssSsjzdmxList);

    /**
     * 查询手术记账单明细
     */
    List<SsSsjzdmxResp> queryList(@Param("jzdh") Integer jzdh);

    /**
     * 手术麻醉项目统计
     *
     * @param ssmzxmReq
     * @return
     */
    List<SsmzxmResp> querySsmzxm(SsmzxmReq ssmzxmReq);

}
