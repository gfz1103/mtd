package com.buit.his.sams.preService;

import cn.hutool.core.collection.CollectionUtil;
import com.buit.commons.BaseException;
import com.buit.commons.SysUser;
import com.buit.constans.TableName;
import com.buit.drug.response.DrugsTypkDetailResp;
import com.buit.drug.service.DrugsTypkOutSer;
import com.buit.his.sams.dao.*;
import com.buit.his.sams.enums.*;
import com.buit.his.sams.model.*;
import com.buit.his.sams.request.SsSsjzAddOrUpdateReq;
import com.buit.his.sams.request.SsSsjzdmxAddOrUpdateReq;
import com.buit.his.sams.response.SsSsjzdmxResp;
import com.buit.system.response.FeeYlsfxmOutResp;
import com.buit.system.service.FeeYlsfxmOutSer;
import com.buit.utill.DateUtils;
import com.buit.utill.RedisFactory;
import org.apache.dubbo.config.annotation.DubboReference;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

/**
 * 手术/麻醉 记账预处理
 * jiangwei
 */
@Service
public class SsjzPreService {
    @Autowired
    private SsSsapDao ssSsapDao;
    @Autowired
    private SsSsjzdmxDao ssSsjzdmxDao;
    @Autowired
    private SsSsjzdzbDao ssSsjzdzbDao;
    @Autowired
    private SsZytfsqzbDao ssZytfsqzbDao;
    @Autowired
    private ImFeeFymxDao imFeeFymxDao;
    @Autowired
    private RedisFactory redisFactory;
    @DubboReference
    private DrugsTypkOutSer drugsTypkOutSer;
    @DubboReference
    private FeeYlsfxmOutSer feeYlsfxmSer;

    /**
     * 通过手术申请单号获取手术安排
     *
     * @param sqdh 申请单号
     */
    @Transactional(rollbackFor = Exception.class)
    public SsSsap getBySqdh(Integer sqdh) {
        SsSsap query = new SsSsap();
        query.setSqdh(sqdh);
        List<SsSsap> list = ssSsapDao.findByEntity(query);
        if (CollectionUtil.isNotEmpty(list)) {
            return list.get(0);
        }
        return null;
    }

    /**
     * 手术记账审核验证（所有退费申请必须全部确认）
     *
     * @param sqdh 申请单号
     */
    @Transactional(rollbackFor = Exception.class)
    public boolean isAllApproved(Integer sqdh) {
        //查询该台手术所有记账单
        SsSsjzdzb query = new SsSsjzdzb();
        query.setSssqdh(sqdh);
        List<SsSsjzdzb> list = ssSsjzdzbDao.findByEntity(query);
        //是否所有记账单都不存在未确认的退费申请
        for (SsSsjzdzb ssjzd : list) {
            if (isExistUnapproved(ssjzd.getJzdh())) {
                return false;
            }
        }
        return true;
    }

    /**
     * 记帐单名下是否有退费申请尚未确认,记账审核/退费申请时校验
     *
     * @param jzdh 记账单号
     * @return
     */
    public boolean isExistUnapproved(Integer jzdh) {
        SsZytfsqzb query = new SsZytfsqzb();
        query.setJzdh(jzdh);
        query.setZt("0");
        List<SsZytfsqzb> list = ssZytfsqzbDao.findByEntity(query);
        return CollectionUtil.isNotEmpty(list);
    }

    /**
     * 修改记账时 验证手术记账明细数据的实时性
     *
     * @param detailList 页面展示的记账明细集合
     * @return 需要保存的记账明细集合
     */
    @Transactional(rollbackFor = Exception.class)
    public List<SsSsjzdmxAddOrUpdateReq> verify(List<SsSsjzdmxAddOrUpdateReq> detailList, Integer jzdh) {
        List<SsSsjzdmxAddOrUpdateReq> result = new ArrayList<>();
        int history = 0;
        for (SsSsjzdmxAddOrUpdateReq req : detailList) {
            if (req.getJlxh() == null || req.getJlxh() == 0) {//记录未保存
                result.add(req);
            } else {
                history++;//已经保存过的明细
            }
        }
        List<SsSsjzdmxResp> savedList = ssSsjzdmxDao.queryList(jzdh);//当下数据库最新的明细记录
        if (history != savedList.size()) {//有新的明细记录产生
            throw BaseException.create("ERROR_SSMZ_0002");
        }
        return result;
    }

    @Transactional(rollbackFor = Exception.class)
    public void save(SsSsjzAddOrUpdateReq req, SsSsjzdzb ssSsjzdzb, SysUser sysUser, JzlxEnum jzlx) {
        Integer jgid = sysUser.getHospitalId();
        Integer userId = sysUser.getUserId();
        List<ImFeeFymx> imFeeFymxList = new ArrayList<>();
        List<SsSsjzdmx> ssSsjzdmxList = new ArrayList<>();

        List<SsSsjzdmxAddOrUpdateReq> detailList;
        //新增
        if (req.getJzdh() == null || req.getJzdh() == 0) {
            detailList = req.getSsSsjzdmxAddOrUpdateReqs();
        } else {
            detailList = verify(req.getSsSsjzdmxAddOrUpdateReqs(), ssSsjzdzb.getJzdh());
        }

        for (SsSsjzdmxAddOrUpdateReq obj : detailList) {
            // 住院费用明细
            ImFeeFymx imFeeFymx = new ImFeeFymx();
            imFeeFymx.setJlxh(redisFactory.getTableKey(TableName.DB_NAME, TableName.IM_FEE_FYMX));
            imFeeFymx.setJgid(jgid);
            imFeeFymx.setZyh(req.getZyh());
            imFeeFymx.setFyrq(new Timestamp(System.currentTimeMillis()));
            imFeeFymx.setFyxh(Integer.parseInt(obj.getSfxmdm()));
            imFeeFymx.setFymc(obj.getSfxmmc());
            //收费项目类型判断
            if (SsjzdmxXmlxEnum.DRUG.equals(obj.getSfxmlb())) {//药品
                DrugsTypkDetailResp drugsTypkDetail = drugsTypkOutSer.getDrugsTypkById(Integer.parseInt(obj.getSfxmdm()));
                imFeeFymx.setYpcd(obj.getYpcd());
                imFeeFymx.setYplx(drugsTypkDetail.getType());
                imFeeFymx.setFyxm(drugsTypkDetail.getZblb());
                imFeeFymx.setFyks(req.getKsdm());
            } else {//项目、材料
                imFeeFymx.setYplx(FymxYplxEnum.NOT_MEDICINE.getValue());
                FeeYlsfxmOutResp feeylsfxm = feeYlsfxmSer.getById(Integer.parseInt(obj.getSfxmdm()));
                imFeeFymx.setFyks(feeylsfxm.getFyks() == null ? req.getKsdm() : feeylsfxm.getFyks());
                imFeeFymx.setFyxm(feeylsfxm.getFygb());
                imFeeFymx.setYpcd(0);
            }
            imFeeFymx.setFysl(obj.getSl());
            imFeeFymx.setFydj(obj.getDj());
            imFeeFymx.setZjje(imFeeFymx.getFysl().multiply(imFeeFymx.getFydj()));
            imFeeFymx.setZfje(imFeeFymx.getFysl().multiply(imFeeFymx.getFydj()));
            imFeeFymx.setYsgh(String.valueOf(userId));
            imFeeFymx.setFybq(req.getBqdm());
            imFeeFymx.setZlje(new BigDecimal(0));
            imFeeFymx.setZxks(req.getSsksdm());
            imFeeFymx.setJfrq(new Timestamp(System.currentTimeMillis()));
            imFeeFymx.setXmlx(jzlx.getValue());
            imFeeFymx.setJscs(0);
            imFeeFymx.setZfbl(new BigDecimal(1));
            imFeeFymx.setYzxh(0);
            imFeeFymx.setDzbl(new BigDecimal(0));
            imFeeFymx.setSrgh(String.valueOf(userId));
            imFeeFymx.setQrgh(String.valueOf(userId));
            imFeeFymx.setYepb(0);
            imFeeFymx.setZfpb(FymxZfpbEnum.NORMAL.getValue());
            imFeeFymxList.add(imFeeFymx);
            //手术记账明细
            SsSsjzdmx ssSsjzdmx = new SsSsjzdmx();
            BeanUtils.copyProperties(obj, ssSsjzdmx);

            ssSsjzdmx.setJzdh(ssSsjzdzb.getJzdh());
            ssSsjzdmx.setJgid(jgid);
            ssSsjzdmx.setJlxh(redisFactory.getTableKey(TableName.DB_NAME, TableName.SS_SSJZDMX));
            ssSsjzdmx.setZt(SsjzdmxZtEnum.NORMAL.getValue());
            ssSsjzdmx.setJzJlxh(ssSsjzdmx.getJlxh());
            ssSsjzdmx.setSsys(obj.getSsys());
            ssSsjzdmx.setSqdh(req.getSqdh());
            ssSsjzdmx.setJzrdm(userId);
            ssSsjzdmx.setJzsj(DateUtils.getNow());
            ssSsjzdmxList.add(ssSsjzdmx);
        }
        ssSsjzdmxDao.batchInsert(ssSsjzdmxList);
        imFeeFymxDao.batchInsert(imFeeFymxList);
    }

    /**
     * 记账审核    2021.2.3 jiangwei 记账审核只有手术系统能用，审核后手术状态直接更改为已完成
     *
     * @param sqdh 手术申请单号
     */
    @Transactional(rollbackFor = Exception.class)
    public void approve(Integer sqdh, SysUser sysUser) {
        //手术安排状态改为已完成
        SsSsap current = getBySqdh(sqdh);
        SsSsap query = new SsSsap();
        query.setJlxh(current.getJlxh());
        query.setSsjzzt(SsapJzztEnum.CHECKED.getValue());
        query.setMzjzzt(SsapJzztEnum.CHECKED.getValue());
        query.setZt(SsapZtEnum.DONE.getValue());
        ssSsapDao.update(query);
        //手术申请保存审核工号及时间
        ssSsjzdzbDao.jzApprove(sqdh, sysUser.getUserId(), DateUtils.getNow());
    }

}
