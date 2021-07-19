package com.buit.his.sams.service;


import cn.hutool.core.date.DateUtil;
import com.buit.aop.lock.Locked;
import com.buit.commons.BaseException;
import com.buit.commons.BaseManagerImp;
import com.buit.commons.EntityDao;
import com.buit.commons.SysUser;
import com.buit.constans.TableName;
import com.buit.drug.response.DrugsTypkDetailResp;
import com.buit.drug.service.DrugsTypkOutSer;
import com.buit.his.sams.dao.*;
import com.buit.his.sams.enums.*;
import com.buit.his.sams.model.*;
import com.buit.his.sams.preService.SsjzPreService;
import com.buit.his.sams.preService.SstfPreService;
import com.buit.his.sams.request.QuerySsjzPageReq;
import com.buit.his.sams.request.RefundSureQueryPageReq;
import com.buit.his.sams.request.SsZytfsqmxReq;
import com.buit.his.sams.request.SsZytfsqzbAddReq;
import com.buit.his.sams.response.RefundSureQueryPageResp;
import com.buit.his.sams.response.SsZytfQueryPageResp;
import com.buit.mms.cmo.response.IOptSssqResp;
import com.buit.mms.cmo.service.OptSssqService;
import com.buit.system.response.FeeYlsfxmOutResp;
import com.buit.system.service.FeeYlsfxmOutSer;
import com.buit.utill.DateUtils;
import com.buit.utill.RedisFactory;
import org.apache.dubbo.config.annotation.DubboReference;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * 住院退费申请主表<br>
 *
 * @author zhouhaisheng
 */
@Service
public class SsZytfsqzbSer extends BaseManagerImp<SsZytfsqzb, Integer> {

    static final Logger logger = LoggerFactory.getLogger(SsZytfsqzbSer.class);

    @Autowired
    private RedisFactory redisFactory;
    @Autowired
    private SsZytfsqzbDao ssZytfsqzbDao;
    @Autowired
    private SsZytfsqmxDao ssZytfsqmxDao;
    @Autowired
    private SsSsjzdzbDao ssSsjzdzbDao;
    @Autowired
    private SsSsjzdmxDao ssSsjzdmxDao;
    @Autowired
    private SstfPreService sstfPreService;
    @Autowired
    private SsjzPreService ssjzPreService;
    @Autowired
    private ImFeeFymxDao imFeeFymxDao;
    @DubboReference
    private OptSssqService optSssqService;
    @DubboReference
    private DrugsTypkOutSer drugsTypkOutSer;
    @DubboReference
    private FeeYlsfxmOutSer feeYlsfxmSer;

    @Override
    public EntityDao<SsZytfsqzb, Integer> getEntityMapper() {
        return ssZytfsqzbDao;
    }

    /**
     * 门诊、住院退费申请(分页查询记账病人)
     */
    public List<SsZytfQueryPageResp> queryPage(QuerySsjzPageReq req) {
        List<SsZytfQueryPageResp> list = ssZytfsqzbDao.queryPage(req);
        for (SsZytfQueryPageResp resp : list) {
            resp.setAge(DateUtil.ageOfNow(resp.getCsny()));
        }
        return list;
    }

    /**
     * 新增住院退费申请
     */
    @Transactional(rollbackFor = Exception.class)
    @Locked(value = {"surgery_refund_#[req.jzdh]"})
    public void add(SsZytfsqzbAddReq req, SysUser sysUser) {
        req.setJgid(sysUser.getHospitalId());
        //同一记账单同时只能有一个申请
        if (ssjzPreService.isExistUnapproved(req.getJzdh())) {
            throw BaseException.create("ERROR_SSMZ_0003");
        }

        List<SsZytfsqmxReq> tfmxList = req.getSsZytfsqmxReqList();
        List<SsZytfsqmx> tfList = new ArrayList<>(tfmxList.size());

        for (SsZytfsqmxReq tfmx : tfmxList) {
            //退费项目数量验证
            BigDecimal count = countTfsl(tfmx.getJzxh());
            if (count.compareTo(tfmx.getTfsl()) < 0) {
                throw BaseException.create("ERROR_SSMZ_0004");
            }
        }

        //新增退费申请
        SsZytfsqzb ssZytfsqzb = new SsZytfsqzb();
        BeanUtils.copyProperties(req, ssZytfsqzb);
        ssZytfsqzb.setJlxh(redisFactory.getTableKey(TableName.DB_NAME, TableName.SS_ZYTFSQZB));
        ssZytfsqzb.setTfsj(new Timestamp(System.currentTimeMillis()));
        ssZytfsqzb.setTfrdm(sysUser.getUserId());
        ssZytfsqzb.setTfsqdh(ssZytfsqzb.getJlxh().toString());
        ssZytfsqzb.setZt("0");
        ssZytfsqzbDao.insert(ssZytfsqzb);

        for (SsZytfsqmxReq tfmx : tfmxList) {
            //退费明细保存
            SsZytfsqmx ssZytfsqmx = new SsZytfsqmx();
            BeanUtils.copyProperties(tfmx, ssZytfsqmx);
            ssZytfsqmx.setTfsqdh(ssZytfsqzb.getJlxh());
            ssZytfsqmx.setTfje(ssZytfsqmx.getDj().multiply(ssZytfsqmx.getTfsl()));
            ssZytfsqmx.setJlxh(redisFactory.getTableKey(TableName.DB_NAME, TableName.SS_ZYTFSQMX));
            ssZytfsqmx.setJgid(sysUser.getHospitalId());
            ssZytfsqmx.setZt("0");
            tfList.add(ssZytfsqmx);
        }
        ssZytfsqmxDao.batchInsert(tfList);
    }

    /**
     * 住院确认退费分页查询
     *
     * @param refundSureQueryPageReq
     * @param user
     * @return
     */
    public List<RefundSureQueryPageResp> queryRefundSurePage(RefundSureQueryPageReq refundSureQueryPageReq, SysUser user) {
        refundSureQueryPageReq.setJgid(user.getHospitalId());
        return ssZytfsqzbDao.queryRefundSurePage(refundSureQueryPageReq).stream().map(r->{
            r.setAge(DateUtil.ageOfNow(r.getCsny()));
            return r;
        }).collect(Collectors.toList());
    }

    /**
     * 住院确认退费确认
     *
     * @param tfsqdh
     * @param user
     */
    @Transactional(rollbackFor = Exception.class)
    @Locked(value = {"surgery_refund_approve_#[tfsqdh]"})
    public void refundSure(Integer tfsqdh, SysUser user) {
        SsZytfsqzb ssZytfsqzb = ssZytfsqzbDao.getById(tfsqdh);
        //重复确认状态检查
        if (!"0".equals(ssZytfsqzb.getZt())) {
            throw BaseException.create("ERROR_SSMZ_0005");
        }

        //退费申请单状态修改
        SsZytfsqzb zbParam = new SsZytfsqzb();
        zbParam.setZt("1");
        zbParam.setJgid(user.getHospitalId());
        zbParam.setQrr(user.getUserId());
        zbParam.setQrsj(new Timestamp(System.currentTimeMillis()));
        zbParam.setTfsqdh(String.valueOf(tfsqdh));
        ssZytfsqzbDao.refundSure(zbParam);

        //退费明细状态修改
        SsZytfsqmx mxParam = new SsZytfsqmx();
        mxParam.setJgid(user.getHospitalId());
        mxParam.setTfsqdh(tfsqdh);
        mxParam.setZt("1");
        ssZytfsqmxDao.refundSure(zbParam);

        //住院费用插入退费记录
        List<SsZytfsqmx> ssZytfsqmxList = sstfPreService.findListByTfsqdh(tfsqdh);//退费明细
        SsSsjzdzb ssSsjzdzb = ssSsjzdzbDao.getById(ssZytfsqzb.getJzdh());//记账申请
        IOptSssqResp optSssqResp = optSssqService.getBySqdh(ssSsjzdzb.getSssqdh());//手术申请单

        List<ImFeeFymx> imFeeFymxList = new ArrayList<>(ssZytfsqmxList.size());
        List<SsSsjzdmx> jzList = new ArrayList<>(ssZytfsqmxList.size());

        for (SsZytfsqmx ssZytfsqmx : ssZytfsqmxList) {
            ImFeeFymx imFeeFymx = new ImFeeFymx();
            imFeeFymx.setJlxh(redisFactory.getTableKey(TableName.DB_NAME, TableName.IM_FEE_FYMX));
            imFeeFymx.setJgid(user.getHospitalId());
            imFeeFymx.setZyh(optSssqResp.getZyh());
            imFeeFymx.setFyrq(DateUtils.getNow());
            imFeeFymx.setFyxh(Integer.parseInt(ssZytfsqmx.getTfxmdm()));
            imFeeFymx.setFymc(ssZytfsqmx.getTfxmmc());
            //收费项目类型判断
            if (SsjzdmxXmlxEnum.DRUG.equals(ssZytfsqmx.getTfxmlb())) {//药品
                DrugsTypkDetailResp drugsTypkDetail = drugsTypkOutSer.getDrugsTypkById(Integer.parseInt(ssZytfsqmx.getTfxmdm()));
                imFeeFymx.setYpcd(ssZytfsqmx.getYpcd());
                imFeeFymx.setYplx(drugsTypkDetail.getType());
                imFeeFymx.setFyxm(drugsTypkDetail.getZblb());
                imFeeFymx.setFyks(ssZytfsqmx.getSsksdm());
            } else {//项目、材料
                imFeeFymx.setYplx(FymxYplxEnum.NOT_MEDICINE.getValue());
                FeeYlsfxmOutResp feeylsfxm = feeYlsfxmSer.getById(Integer.parseInt(ssZytfsqmx.getTfxmdm()));
                imFeeFymx.setFyks(feeylsfxm.getFyks() == null ? ssZytfsqmx.getSsksdm() : feeylsfxm.getFyks());
                imFeeFymx.setFyxm(feeylsfxm.getFygb());
                imFeeFymx.setYpcd(0);
            }
            imFeeFymx.setFysl(ssZytfsqmx.getTfsl().negate());
            imFeeFymx.setFydj(ssZytfsqmx.getDj());
            imFeeFymx.setZjje(imFeeFymx.getFysl().multiply(imFeeFymx.getFydj()));
            imFeeFymx.setZfje(imFeeFymx.getFysl().multiply(imFeeFymx.getFydj()));
            imFeeFymx.setFybq(ssSsjzdzb.getBqdm());
            imFeeFymx.setZlje(new BigDecimal(0));
            imFeeFymx.setZxks(ssZytfsqmx.getSsksdm());
            imFeeFymx.setJfrq(new Timestamp(System.currentTimeMillis()));
            if (JzdzbJzlxEnum.SURGERY.equals(ssSsjzdzb.getJzlx())) {
                imFeeFymx.setXmlx(JzlxEnum.SURGERY.getValue());
            } else if (JzdzbJzlxEnum.ANESTHESIA.equals(ssSsjzdzb.getJzlx())) {
                imFeeFymx.setXmlx(JzlxEnum.ANESTHESIA.getValue());
            }
            imFeeFymx.setJscs(0);
            imFeeFymx.setZfbl(new BigDecimal(1));
            imFeeFymx.setYzxh(0);
            imFeeFymx.setDzbl(new BigDecimal(0));
            imFeeFymx.setYsgh(String.valueOf(ssSsjzdzb.getJzrdm()));
            imFeeFymx.setSrgh(String.valueOf(ssSsjzdzb.getJzrdm()));
            imFeeFymx.setQrgh(String.valueOf(user.getUserId()));
            imFeeFymx.setYepb(0);
            imFeeFymx.setZfpb(FymxZfpbEnum.NORMAL.getValue());
            imFeeFymxList.add(imFeeFymx);

            //增加抵扣的记账明细
            SsSsjzdmx ssSsjzdmx = new SsSsjzdmx();
            ssSsjzdmx.setJlxh(redisFactory.getTableKey(TableName.DB_NAME, TableName.SS_SSJZDMX));
            ssSsjzdmx.setJgid(ssZytfsqmx.getJgid());
            ssSsjzdmx.setSsksdm(ssZytfsqmx.getSsksdm());
            ssSsjzdmx.setJzdh(ssSsjzdzb.getJzdh());
            ssSsjzdmx.setSfxmdm(ssZytfsqmx.getTfxmdm());
            ssSsjzdmx.setSfxmlb(ssZytfsqmx.getTfxmlb());
            ssSsjzdmx.setSl(ssZytfsqmx.getTfsl().negate());
            ssSsjzdmx.setDj(ssZytfsqmx.getDj());
            ssSsjzdmx.setJe(ssZytfsqmx.getTfje().negate());
            ssSsjzdmx.setZt(SsjzdmxZtEnum.REFUND.getValue());
            ssSsjzdmx.setJzJlxh(ssZytfsqmx.getJzxh());
            ssSsjzdmx.setSsys(ssZytfsqmx.getSsys());
            ssSsjzdmx.setSqdh(optSssqResp.getSqdh());
            ssSsjzdmx.setYpcd(ssZytfsqmx.getYpcd());
            ssSsjzdmx.setCdmc(ssZytfsqmx.getCdmc());
            ssSsjzdmx.setYfgg(ssZytfsqmx.getYfgg());
            ssSsjzdmx.setJzrdm(user.getUserId());
            ssSsjzdmx.setJzsj(DateUtils.getNow());
            jzList.add(ssSsjzdmx);
        }
        imFeeFymxDao.batchInsert(imFeeFymxList);
        ssSsjzdmxDao.batchInsert(jzList);
    }

    /**
     * 计算可退费数量
     *
     * @param jlxh 记账明细序号
     */
    public BigDecimal countTfsl(Integer jlxh) {
        SsSsjzdmx query = new SsSsjzdmx();
        query.setJzJlxh(jlxh);
        List<SsSsjzdmx> list = ssSsjzdmxDao.findByEntity(query);
        /**
         * lamda写法
         * list.stream().map(r -> r.getSl()).reduce(BigDecimal.ZERO, (x, y) -> x.add(y));
         */
        return list.stream().map(SsSsjzdmx::getSl).reduce(BigDecimal.ZERO, BigDecimal::add);
    }
}
