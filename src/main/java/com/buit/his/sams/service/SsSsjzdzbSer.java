package com.buit.his.sams.service;


import cn.hutool.core.date.DateUtil;
import com.buit.aop.lock.Locked;
import com.buit.cis.im.response.ImHzryModel;
import com.buit.cis.im.service.ImHzryService;
import com.buit.commons.BaseException;
import com.buit.commons.BaseManagerImp;
import com.buit.commons.SysUser;
import com.buit.constans.TableName;
import com.buit.his.sams.dao.SsSsjzdmxDao;
import com.buit.his.sams.dao.SsSsjzdzbDao;
import com.buit.his.sams.enums.JzlxEnum;
import com.buit.his.sams.enums.SsapJzztEnum;
import com.buit.his.sams.model.SsSsap;
import com.buit.his.sams.model.SsSsjzdzb;
import com.buit.his.sams.preService.SsjzPreService;
import com.buit.his.sams.preService.SstfPreService;
import com.buit.his.sams.request.QuerySsjzPageReq;
import com.buit.his.sams.request.SsSsjzAddOrUpdateReq;
import com.buit.his.sams.response.QuerySsjzPageResp;
import com.buit.his.sams.response.SsjzBaseInfoResp;
import com.buit.mms.cmo.response.IOptSssqResp;
import com.buit.mms.cmo.service.OptSssqService;
import com.buit.utill.RedisFactory;
import com.buit.utill.ReturnEntity;
import com.buit.utill.ReturnEntityUtil;
import org.apache.dubbo.config.annotation.DubboReference;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.sql.Timestamp;
import java.util.List;

/**
 * 手术记账单主表<br>
 *
 * @author zhouhaisheng
 */
@Service
public class SsSsjzdzbSer extends BaseManagerImp<SsSsjzdzb, Integer> {

    static final Logger logger = LoggerFactory.getLogger(SsSsjzdzbSer.class);

    @Autowired
    private SsSsjzdzbDao ssSsjzdzbDao;
    @Autowired
    private RedisFactory redisFactory;
    @Autowired
    private SsSsjzdmxDao ssSsjzdmxDao;
    @Autowired
    private SsSsjzdmxSer ssSsjzdmxSer;
    @DubboReference
    public ImHzryService imHzryService;
    @DubboReference
    private OptSssqService optSssqService;
    @Autowired
    private SsjzPreService ssjzPreService;
    @Autowired
    private SstfPreService stfPreService;
    @Autowired
    private SsSsapSer ssSsapSer;

    @Override
    public SsSsjzdzbDao getEntityMapper() {
        return ssSsjzdzbDao;
    }


    /**
     * 新增手术记账
     *
     * @param req
     * @param user
     */
    @Transactional(rollbackFor = Exception.class)
    public void add(SsSsjzAddOrUpdateReq req, SysUser user) {
        //新增记账单
        SsSsjzdzb ssSsjzdzb = new SsSsjzdzb();
        BeanUtils.copyProperties(req, ssSsjzdzb);
        ssSsjzdzb.setJgid(user.getHospitalId());
        ssSsjzdzb.setJlxh(redisFactory.getTableKey(TableName.DB_NAME, TableName.SS_SSJZDZB));
        ssSsjzdzb.setJzsj(new Timestamp(System.currentTimeMillis()));
        ssSsjzdzb.setJzrdm(user.getUserId());
        ssSsjzdzb.setJzdh(ssSsjzdzb.getJlxh());
        ssSsjzdzb.setJzlx(req.getJzlx());
        ssSsjzdzb.setSssqdh(req.getSqdh());
        ssSsjzdzbDao.insert(ssSsjzdzb);

        //手术安排表更改记账状态
        SsSsap ssSsap = ssjzPreService.getBySqdh(req.getSqdh());
        if (SsapJzztEnum.RECORDED.equals(ssSsap.getSsjzzt()) || SsapJzztEnum.RECORDED.equals(ssSsap.getMzjzzt())) {
            ssSsap.setJlxh(ssSsap.getJlxh());
            ssSsap.setSsjzzt(SsapJzztEnum.UNRECORDED.getValue());
            ssSsap.setMzjzzt(SsapJzztEnum.UNRECORDED.getValue());
            ssSsapSer.update(ssSsap);
        }

        //费用明细保存
        ssjzPreService.save(req, ssSsjzdzb, user, JzlxEnum.SURGERY);
    }

    /**
     * 手术记账修改
     *
     * @param req
     * @param user
     */
    @Locked(value = {"surgery_bill_#[req.jzdh]"})
    @Transactional(rollbackFor = Exception.class)
    public void update(SsSsjzAddOrUpdateReq req, SysUser user) {
        //修改记账单
        SsSsjzdzb ssSsjzdzb = ssSsjzdzbDao.getById(req.getJlxh());
        ssSsjzdzb.setJzsj(new Timestamp(System.currentTimeMillis()));
        ssSsjzdzb.setJzrdm(user.getUserId());
        ssSsjzdzbDao.update(ssSsjzdzb);

        //费用明细保存
        ssjzPreService.save(req, ssSsjzdzb, user, JzlxEnum.SURGERY);
    }

    /**
     * 手术/麻醉记账审核
     *
     * @param req
     * @param user
     */
    @Transactional(rollbackFor = Exception.class)
    public void approve(SsSsjzAddOrUpdateReq req, SysUser user) {
        if (!ssjzPreService.isAllApproved(req.getSqdh())) {
            throw BaseException.create("ERROR_SSMZ_0006");
        }
        ssjzPreService.approve(req.getSqdh(), user);
    }

    /**
     * 手术记账基本信息查询
     *
     * @param sqdh 手术申请单号
     */
    public ReturnEntity<SsjzBaseInfoResp> querySsjzBaseInfo(Integer sqdh) {
        SsjzBaseInfoResp response = new SsjzBaseInfoResp();
        IOptSssqResp optSssqResp = optSssqService.getBySqdh(sqdh);
        SsSsap ssSsap = ssjzPreService.getBySqdh(sqdh);
        ImHzryModel imHzryModel = imHzryService.queryPatientBaseInfo(optSssqResp.getZyh());

        BeanUtils.copyProperties(imHzryModel, response);
        response.setAge(DateUtil.ageOfNow(response.getCsny()));
        response.setSqdh(ssSsap.getSqdh());
        response.setSsapJlxh(ssSsap.getJlxh());
        response.setSsjzzt(ssSsap.getSsjzzt());
        response.setMzjzzt(ssSsap.getMzjzzt());

        BigDecimal yjje = ssSsjzdmxDao.queryYjje(response.getZyh());
        response.setYjhj(yjje);
        BigDecimal fyhj = ssSsjzdmxDao.queryHjfy(response.getZyh());
        response.setFyhj(fyhj);
        response.setYehj(yjje.subtract(fyhj));
        return ReturnEntityUtil.success(response);
    }

    /**
     * 分页查询手术记账病人列表
     */
    public List<QuerySsjzPageResp> querySsjzPage(QuerySsjzPageReq querySsjzPageReq) {
        List<QuerySsjzPageResp> querySsjzPageRespList = ssSsjzdmxDao.querySsjzPage(querySsjzPageReq);
        for (QuerySsjzPageResp querySsjzPageResp : querySsjzPageRespList) {
            querySsjzPageResp.setAge(DateUtil.ageOfNow(querySsjzPageResp.getCsny()));
        }
        return querySsjzPageRespList;
    }

}
