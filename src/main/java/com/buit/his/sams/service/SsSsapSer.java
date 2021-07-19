package com.buit.his.sams.service;


import cn.hutool.core.date.DateUtil;
import com.buit.cis.im.response.ImHzryModel;
import com.buit.cis.im.service.ImHzryService;
import com.buit.commons.BaseManagerImp;
import com.buit.commons.SysUser;
import com.buit.constans.TableName;
import com.buit.his.sams.dao.SsSsapDao;
import com.buit.his.sams.enums.SsapJzztEnum;
import com.buit.his.sams.enums.SsapZtEnum;
import com.buit.his.sams.model.SsSsap;
import com.buit.his.sams.model.SsSsj;
import com.buit.his.sams.request.SsSsapQueryPageReq;
import com.buit.his.sams.request.SsSsapUpdateReq;
import com.buit.his.sams.request.SsapViewQueryPageReq;
import com.buit.his.sams.response.SsSsapQueryPageResp;
import com.buit.utill.RedisFactory;
import org.apache.dubbo.config.annotation.DubboReference;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.sql.Timestamp;
import java.util.List;

/**
 * 手术安排表<br>
 *
 * @author zhouhaisheng
 */
@Service
public class SsSsapSer extends BaseManagerImp<SsSsap, Integer> {

    static final Logger logger = LoggerFactory.getLogger(SsSsapSer.class);

    @Autowired
    private SsSsapDao ssSsapDao;
    @Autowired
    private SsSsjSer ssSsjSer;
    @Autowired
    private RedisFactory redisFactory;

    @Override
    public SsSsapDao getEntityMapper() {
        return ssSsapDao;
    }

    @DubboReference
    public ImHzryService imHzryService;
//    @DubboReference
//    public OptSssqService optSssqService;


    /**
     * 手术安排分页查询
     *
     * @param ssSsapQueryPageReq
     * @return
     */
    public List<SsSsapQueryPageResp> queryPage(SsSsapQueryPageReq ssSsapQueryPageReq) {
        List<SsSsapQueryPageResp> ssSsapList = ssSsapDao.querySsapPage(ssSsapQueryPageReq);
        for (SsSsapQueryPageResp ssSsapQueryPageResp : ssSsapList) {
            if (ssSsapQueryPageResp.getMzhm() == null) {
                ssSsapQueryPageResp.setBrlx("2");
            }
            if (ssSsapQueryPageResp.getZt() != null) {
                ssSsapQueryPageResp.setZt(SsapZtEnum.NOT_ARRANGE.getValue());
            }
            //病人信息
            ImHzryModel imHzryModel = imHzryService.queryPatientBaseInfo(ssSsapQueryPageResp.getZyh());
            ssSsapQueryPageResp.setZyhm(imHzryModel.getZyhm());
            ssSsapQueryPageResp.setBrxm(imHzryModel.getBrxm());
            ssSsapQueryPageResp.setBrxb(imHzryModel.getBrxb());
            ssSsapQueryPageResp.setBrxz(imHzryModel.getBrxz());
            ssSsapQueryPageResp.setBrch(imHzryModel.getBrch());
            ssSsapQueryPageResp.setAge(DateUtil.ageOfNow(imHzryModel.getCsny()));
            ssSsapQueryPageResp.setBqdm(imHzryModel.getBrbq());
            //手术间
            if (ssSsapQueryPageResp.getSsj() != null) {
                SsSsj ssSsj = ssSsjSer.getById(Integer.parseInt(ssSsapQueryPageResp.getSsj()));
                ssSsapQueryPageResp.setSsj(ssSsj.getSsj());
            }
        }
        return ssSsapList;
    }

    /**
     * 手术申请安排
     *
     * @param ssSsapUpdateReq
     */
    @Transactional(rollbackFor = Exception.class)
    public void add(SsSsapUpdateReq ssSsapUpdateReq, SysUser user) {
        SsSsap ssSsap = new SsSsap();
        BeanUtils.copyProperties(ssSsapUpdateReq, ssSsap);
        ssSsap.setAprdm(user.getUserId());
        ssSsap.setJgid(user.getHospitalId());
        ssSsap.setCzsj(new Timestamp(System.currentTimeMillis()));

        ssSsap.setZt(SsapZtEnum.ARRANGED.getValue());
        ssSsap.setSsjzzt(SsapJzztEnum.RECORDED.getValue());
        ssSsap.setMzjzzt(SsapJzztEnum.RECORDED.getValue());
        if (ssSsapUpdateReq.getJlxh() != null) {//修改
            ssSsapDao.update(ssSsap);
        } else {
            ssSsap.setJlxh(redisFactory.getTableKey(TableName.DB_NAME, TableName.SS_SSAP));
            ssSsapDao.insert(ssSsap);
        }
    }

    /**
     * 手术申请取消安排
     *
     * @param jlxh
     */
    public void cancel(Integer jlxh) {
        ssSsapDao.deleteById(jlxh);
    }

    /**
     * 手术安排一览表分页查询
     *
     * @param ssapViewQueryPageReq
     * @return
     */
    public List<SsSsapQueryPageResp> ssapView(SsapViewQueryPageReq ssapViewQueryPageReq) {
        List<SsSsapQueryPageResp> ssSsapList = ssSsapDao.ssapView(ssapViewQueryPageReq);
        for (SsSsapQueryPageResp ssSsapQueryPageResp : ssSsapList) {
            ImHzryModel imHzryModel = imHzryService.queryPatientBaseInfo(ssSsapQueryPageResp.getZyh());
            ssSsapQueryPageResp.setZyhm(imHzryModel.getZyhm());
            ssSsapQueryPageResp.setBrch(imHzryModel.getBrch());
            ssSsapQueryPageResp.setAge(DateUtil.ageOfNow(imHzryModel.getCsny()));
            ssSsapQueryPageResp.setBrxb(imHzryModel.getBrxb());
            ssSsapQueryPageResp.setZyh(imHzryModel.getZyh());
            ssSsapQueryPageResp.setBqdm(imHzryModel.getBrbq());
        }
        return ssSsapList;
    }
}
