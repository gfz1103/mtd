package com.buit.his.sams.service;

import cn.hutool.core.date.DateUtil;
import cn.hutool.core.util.StrUtil;
import com.buit.drug.response.DrugsTypkDetailResp;
import com.buit.drug.service.DrugsTypkOutSer;
import com.buit.his.sams.dao.SsSsjzdmxDao;
import com.buit.his.sams.enums.JzdzbJzlxEnum;
import com.buit.his.sams.enums.SsjzdmxXmlxEnum;
import com.buit.his.sams.request.SsPubReq;
import com.buit.his.sams.request.SsmzxmReq;
import com.buit.his.sams.request.SsssrtjReq;
import com.buit.his.sams.response.*;
import com.buit.system.response.FeeYlsfxmOutResp;
import com.buit.system.service.FeeYlsfxmOutSer;
import org.apache.dubbo.config.annotation.DubboReference;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 手术麻醉查询统计service
 * zhouhaisheng
 */
@Service
public class SsReportSer {
    static final Logger logger = LoggerFactory.getLogger(SsReportSer.class);

    @Autowired
    private SsSsjzdmxDao ssSsjzdmxDao;
    @DubboReference
    private FeeYlsfxmOutSer feeYlsfxmSer;
    @DubboReference
    private DrugsTypkOutSer drugsTypkOutSer;

    /**
     * 手术麻醉项目统计
     *
     * @param ssmzxmReq
     * @return
     */
    public List<SsmzxmResp> querySsmzxm(SsmzxmReq ssmzxmReq) {
        List<SsmzxmResp> list = ssSsjzdmxDao.querySsmzxm(ssmzxmReq);
        for (SsmzxmResp r : list) {
            r.setAge(DateUtil.ageOfNow(r.getCsny()));
            if (SsjzdmxXmlxEnum.DRUG.equals(r.getSfxmlb())) {//药品
                DrugsTypkDetailResp drugsTypkDetail = drugsTypkOutSer.getDrugsTypkById(Integer.parseInt(r.getSfxmdm()));
                r.setSfxmmc(drugsTypkDetail.getYpmc());
                r.setDw(drugsTypkDetail.getYpdw());
            } else {//材料、项目
                FeeYlsfxmOutResp feeylsfxm = feeYlsfxmSer.getById(Integer.parseInt(r.getSfxmdm()));
                r.setSfxmmc(feeylsfxm.getFymc());
                r.setDw(feeylsfxm.getFydw());
            }
        }
        return list;
    }

    /**
     * 手术间工作量统计
     * @param ssPubReq
     * @return
     */
    public List<SsjgzltjResp> querySsjgzltj(SsPubReq ssPubReq) {

        return ssSsjzdmxDao.querySsjgzltj(ssPubReq);
    }

    /**
     * 麻醉医生工作量统计
     * @param ssPubReq
     * @return
     */
    public List<MzysgzltjResp> queryMzysgzltj(SsPubReq ssPubReq) {


        return ssSsjzdmxDao.queryMzysgzltj(ssPubReq);
    }
    /**
     * 手术医生工作量统计
     * @param ssPubReq
     * @return
     */
    public List<SsysgzltjResp> querySsysgzltj(SsPubReq ssPubReq) {

        return ssSsjzdmxDao.querySsysgzltj(ssPubReq);
    }

    /**
     * 手术科室工作量统计
     * @param ssPubReq
     * @return
     */
    public List<SsksgzltjResp> querySsksgzltj(SsPubReq ssPubReq) {

        return ssSsjzdmxDao.querySsksgzltj(ssPubReq);
    }

    /**
     * 手术室收入统计
     * @param ssssrtjReq
     * @return
     */
    public List<SsssrtjResp> querySsssrtj(SsssrtjReq ssssrtjReq) {
        List<SsssrtjResp> resps = ssSsjzdmxDao.querySsssrtj(ssssrtjReq);
        for (SsssrtjResp resp : resps) {
            resp.setAge(DateUtil.ageOfNow(resp.getCsny()));
            if (StrUtil.isNotBlank(resp.getMzhm())) {
                resp.setZyhm(resp.getMzhm());
            }
            if (JzdzbJzlxEnum.SURGERY.equals(resp.getJzlx())) {
                resp.setJzzt(resp.getSsjzzt());
            }
            if (JzdzbJzlxEnum.ANESTHESIA.equals(resp.getJzlx())) {
                resp.setJzzt(resp.getMzjzzt());
            }
        }
        return resps;
    }
}
