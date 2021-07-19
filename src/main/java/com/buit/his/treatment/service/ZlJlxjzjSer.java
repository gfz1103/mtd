package com.buit.his.treatment.service;


import cn.hutool.core.collection.CollUtil;
import cn.hutool.core.date.DateUtil;
import cn.hutool.core.util.StrUtil;
import com.buit.cis.im.request.ImFeeFymxReq;
import com.buit.cis.im.response.ImHzryModel;
import com.buit.cis.im.service.ImFeeFymxService;
import com.buit.cis.im.service.ImHzryService;
import com.buit.commons.BaseException;
import com.buit.commons.BaseManagerImp;
import com.buit.commons.SysUser;
import com.buit.constans.TableName;
import com.buit.his.treatment.dao.*;
import com.buit.his.treatment.model.*;
import com.buit.his.treatment.request.*;
import com.buit.his.treatment.response.QueryZyzlZxDetailResp;
import com.buit.his.treatment.response.ZlJlxjzjResp;
import com.buit.his.treatment.status.TreatmentCode;
import com.buit.system.response.GyYlxmDicResp;
import com.buit.system.service.FeeYlsfxmOutSer;
import com.buit.utill.BeanUtil;
import com.buit.utill.RedisFactory;
import com.buit.utill.ReturnEntity;
import com.buit.utill.ReturnEntityUtil;
import org.apache.commons.lang3.StringUtils;
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
import java.util.Map;
import java.util.stream.Collectors;

/**
 * 治疗记录/小结/总结表<br>
 * @author ZHOUHAISHENG
 */
@Service
public class ZlJlxjzjSer extends BaseManagerImp<ZlJlxjzj,Integer> {

    static final Logger logger = LoggerFactory.getLogger(ZlJlxjzjSer.class);

    @Autowired
    private ZlJlxjzjDao zlJlxjzjDao;
    @Autowired
    private ZlSqdyyzxDao zlSqdyyzxDao;
    @Autowired
    private RedisFactory redisFactory;
    @Autowired
    private ZlSqdmxDao zlSqdmxDao;
    @Autowired
    private ZlSqdzbDao zlSqdzbDao;
    @Autowired
    private ZlXmldsfxmDao zlXmldsfxmDao;
    @Autowired
    private ZlSqdzbSer zlSqdzbSer;

    @DubboReference
    private ImFeeFymxService imFeeFymxService;
    @DubboReference
    private ImHzryService imHzryService;

    @DubboReference
    private FeeYlsfxmOutSer feeYlsfxmOutSer;
    @Override
    public ZlJlxjzjDao getEntityMapper(){
        return zlJlxjzjDao;
    }


    /**
     * 新增治疗终结跟治疗终结、治疗记录
     * @param zlJlxjzjAddReq
     */
    @Transactional(rollbackFor = Exception.class)
    public void add(ZlJlxjzjAddReq zlJlxjzjAddReq, SysUser user) {
        //保存记录
        if("1".equals(zlJlxjzjAddReq.getJllx())){
            saveZljl(zlJlxjzjAddReq,user);
            updateYyzxZt(zlJlxjzjAddReq);
            //记账
            saveFymx(zlJlxjzjAddReq.getZlsqdmxJlxh(),user,false);
        }
        //保存小结
        if("2".equals(zlJlxjzjAddReq.getJllx())){
            saveXj(zlJlxjzjAddReq,user);
        }
        //保存总结
        if("3".equals(zlJlxjzjAddReq.getJllx())){
            saveZj(zlJlxjzjAddReq,user);
        }
    }

    /**
     * 保存收费项目记账
     * @param zlsqdmxxh
     * @param user
     */
    public void saveFymx(Integer zlsqdmxxh, SysUser user,boolean cancelJz) {
        int temp=cancelJz?-1:1;
        ZlSqdmx zlSqdmx=zlSqdmxDao.getById(zlsqdmxxh);

        ZlXmldsfxm sfxmParam=new ZlXmldsfxm();
        sfxmParam.setJgid(user.getHospitalId());
        sfxmParam.setZlxmmc(zlSqdmx.getZlxmmc());
        List<ZlXmldsfxm> zlXmldsfxm=zlXmldsfxmDao.findByEntity(sfxmParam);
//        ZlXmldsfxm sfxm=zlXmldsfxm.get(0);
        List< GyYlxmDicResp > feeYlsfxmList=feeYlsfxmOutSer.queryZlFeeYlsfxm(user.getHospitalId());
        Map<Integer,GyYlxmDicResp> feeMap = feeYlsfxmList.stream().collect(Collectors.toMap(z->z.getFyxh(),z->z));
       //查询是否是住院病人
        ZlSqdzb zlSqdzb=zlSqdzbDao.getById(Integer.parseInt(zlSqdmx.getZlsqdh()));
        //住院病人开始记账
        if(StringUtils.isNotBlank(zlSqdzb.getZyhm())){
            List<ImFeeFymxReq> insertList = zlXmldsfxm.stream().map(sfxm->{
                ImFeeFymxReq imFeeFymxReq=new ImFeeFymxReq();
                GyYlxmDicResp feeYlsfxmOutResp=feeMap.get(Integer.parseInt(sfxm.getSfxmdm()));
                imFeeFymxReq.setJlxh(redisFactory.getTableKey(TableName.DB_NAME,TableName.IM_FEE_FYMX));
                imFeeFymxReq.setJgid(user.getHospitalId());
                imFeeFymxReq.setZyh(zlSqdzb.getZyh());
                imFeeFymxReq.setFyrq(new Timestamp(System.currentTimeMillis()));
                imFeeFymxReq.setFyxh(feeYlsfxmOutResp.getFyxh());
                imFeeFymxReq.setFymc(feeYlsfxmOutResp.getFymc());
                imFeeFymxReq.setYpcd(0);
                imFeeFymxReq.setFysl(sfxm.getSl().multiply(BigDecimal.valueOf(temp)));
                imFeeFymxReq.setFydj(feeYlsfxmOutResp.getFydj());
                imFeeFymxReq.setZjje(imFeeFymxReq.getFysl().multiply(imFeeFymxReq.getFydj()));
                imFeeFymxReq.setZfje(imFeeFymxReq.getFysl().multiply(imFeeFymxReq.getFydj()));
                imFeeFymxReq.setYsgh(String.valueOf(user.getUserId()));
                imFeeFymxReq.setFybq(zlSqdzb.getBqdm());
                imFeeFymxReq.setFyks(feeYlsfxmOutResp.getFyks()==null?zlSqdzb.getKsdm():feeYlsfxmOutResp.getFyks());
                imFeeFymxReq.setZlje(new BigDecimal(0));
                imFeeFymxReq.setZxks(imFeeFymxReq.getFyks());
                imFeeFymxReq.setJfrq(new Timestamp(System.currentTimeMillis()));
                imFeeFymxReq.setXmlx(3);
                imFeeFymxReq.setYplx(0);
                imFeeFymxReq.setFyxm(feeYlsfxmOutResp.getFygb());
                imFeeFymxReq.setJscs(0);
                imFeeFymxReq.setZfbl(new BigDecimal(1));
                imFeeFymxReq.setYzxh(0);
                imFeeFymxReq.setDzbl(new BigDecimal(0));
                imFeeFymxReq.setSrgh(user.getUserId().toString());
                imFeeFymxReq.setQrgh(user.getUserId().toString());
                imFeeFymxReq.setYepb(0);
                return imFeeFymxReq;
            }).collect(Collectors.toList());
            imFeeFymxService.batchInsert(insertList);
        }
        zlSqdzbDao.updateZtById(3,zlSqdzb.getJlxh());

    }

    /**
     * 保存治疗记录
      * @param zlJlxjzjAddReq
     */
    public void saveZljl(ZlJlxjzjAddReq zlJlxjzjAddReq,SysUser user){
        ZlJlxjzj zlJlxjzj=new ZlJlxjzj();
        ZlSqdyyzx zlSqdyyzx= zlSqdyyzxDao.getById(zlJlxjzjAddReq.getYyzxJlxh());
        ZlSqdmx zlSqdmx= zlSqdmxDao.getById(zlSqdyyzx.getZlSqdmxJlxh());
        zlJlxjzj.setJlxh(redisFactory.getTableKey(TableName.DB_NAME,TableName.ZL_JLXJZJ));
        zlJlxjzj.setJgid(user.getHospitalId());
        zlJlxjzj.setZlsqdh(zlSqdyyzx.getZlsqdh());
        zlJlxjzj.setZlsqdxh(zlSqdmx.getXh());
        zlJlxjzj.setZlxmmc(zlSqdyyzx.getZlxmmc());
        zlJlxjzj.setZlsqdmxJlxh(zlJlxjzjAddReq.getZlsqdmxJlxh());
        zlJlxjzj.setJlsj(new Timestamp(System.currentTimeMillis()));
        zlJlxjzj.setJllx("1");
        zlJlxjzj.setYysj(zlSqdyyzx.getYysj());
        zlJlxjzj.setYyxh(zlSqdyyzx.getYyxh());
        zlJlxjzj.setBczlsl(zlSqdyyzx.getBczlsl());
        zlJlxjzj.setYyczgh(zlSqdyyzx.getYyczgh());
        zlJlxjzj.setYyczsj(zlSqdyyzx.getYyczsj());
        zlJlxjzj.setZt("2");
        zlJlxjzj.setZxsj(zlJlxjzjAddReq.getZxsj());
        zlJlxjzj.setZxysgh(zlJlxjzjAddReq.getZxysgh());
        zlJlxjzj.setBz(zlJlxjzjAddReq.getBz());
        zlJlxjzj.setZlzj(zlJlxjzjAddReq.getZlzj());
        zlJlxjzj.setZxjlsj(new Timestamp(System.currentTimeMillis()));
        zlJlxjzj.setZxjlgh(user.getUserId());
        zlJlxjzj.setYyzxJlxh(zlJlxjzjAddReq.getYyzxJlxh());
        zlJlxjzjDao.insert(zlJlxjzj);
    }

    /**
     * 保存小结
     * @param zlJlxjzjAddReq
     * @param user
     */
    private void saveXj(ZlJlxjzjAddReq zlJlxjzjAddReq,SysUser user){
        ZlJlxjzj zlJlxjzj=new ZlJlxjzj();
        ZlSqdmx  zlSqdmx= zlSqdmxDao.getById(zlJlxjzjAddReq.getZlsqdmxJlxh());
        zlJlxjzj.setJlxh(redisFactory.getTableKey(TableName.DB_NAME,TableName.ZL_JLXJZJ));
        zlJlxjzj.setZlsqdmxJlxh(zlJlxjzjAddReq.getZlsqdmxJlxh());
        zlJlxjzj.setJgid(user.getHospitalId());
        zlJlxjzj.setZlsqdh(zlSqdmx.getZlsqdh());
        zlJlxjzj.setZlsqdxh(zlSqdmx.getXh());
        zlJlxjzj.setZlxmmc(zlSqdmx.getZlxmmc());
        zlJlxjzj.setJlsj(new Timestamp(System.currentTimeMillis()));
        zlJlxjzj.setJllx("2");
        zlJlxjzj.setZt("2");
        zlJlxjzj.setZxsj(zlJlxjzjAddReq.getZxsj());
        zlJlxjzj.setZxysgh(zlJlxjzjAddReq.getZxysgh());
        zlJlxjzj.setBz(zlJlxjzjAddReq.getBz());
        zlJlxjzj.setZlzj(zlJlxjzjAddReq.getZlzj());
        zlJlxjzj.setZxjlsj(new Timestamp(System.currentTimeMillis()));
        zlJlxjzj.setZxjlgh(user.getUserId());
        zlJlxjzjDao.insert(zlJlxjzj);
    }
    /**
     * 保存总结
     * @param zlJlxjzjAddReq
     * @param user
     */
    private void saveZj(ZlJlxjzjAddReq zlJlxjzjAddReq,SysUser user){
        ZlJlxjzj zlJlxjzj=new ZlJlxjzj();
        ZlSqdmx  zlSqdmx= zlSqdmxDao.getById(zlJlxjzjAddReq.getZlsqdmxJlxh());
        zlJlxjzj.setJlxh(redisFactory.getTableKey(TableName.DB_NAME,TableName.ZL_JLXJZJ));
        zlJlxjzj.setZlsqdmxJlxh(zlJlxjzjAddReq.getZlsqdmxJlxh());
        zlJlxjzj.setJgid(user.getHospitalId());
        zlJlxjzj.setZlsqdh(zlSqdmx.getZlsqdh());
        zlJlxjzj.setZlsqdxh(zlSqdmx.getXh());
        zlJlxjzj.setZlxmmc(zlSqdmx.getZlxmmc());
        zlJlxjzj.setJlsj(new Timestamp(System.currentTimeMillis()));
        zlJlxjzj.setJllx("3");
        zlJlxjzj.setZt("2");
        zlJlxjzj.setZxsj(zlJlxjzjAddReq.getZxsj());
        zlJlxjzj.setZxysgh(zlJlxjzjAddReq.getZxysgh());
        zlJlxjzj.setBz(zlJlxjzjAddReq.getBz());
        zlJlxjzj.setZlzj(zlJlxjzjAddReq.getZlzj());
        zlJlxjzj.setZxjlsj(new Timestamp(System.currentTimeMillis()));
        zlJlxjzj.setZxjlgh(user.getUserId());
        zlJlxjzjDao.insert(zlJlxjzj);
    }

    /**
     * 查询治疗记录列表
     * @param zlsqdmxJlxh
     * @param user
     * @return
     */
    public List<ZlJlxjzjResp> findJlList(Integer zlsqdmxJlxh, SysUser user) {
        ZlJlxjzj zlJlxjzjParam=new ZlJlxjzj();
        zlJlxjzjParam.setZlsqdmxJlxh(zlsqdmxJlxh);
        zlJlxjzjParam.setJgid(user.getHospitalId());
        List<ZlJlxjzj> zlJlxjzjList=zlJlxjzjDao.findByEntity(zlJlxjzjParam);

        return BeanUtil.toBeans(zlJlxjzjList,ZlJlxjzjResp.class);

    }

    /**
     * 修改执行状态
     * @param zlJlxjzjAddReq
     * @param zlJlxjzjAddReq
     */
    public void updateYyzxZt(ZlJlxjzjAddReq zlJlxjzjAddReq){
        ZlSqdyyzx updateParam=new ZlSqdyyzx();
        updateParam.setJlxh(zlJlxjzjAddReq.getYyzxJlxh());
        updateParam.setZt("2");
        updateParam.setZxygh(zlJlxjzjAddReq.getZxysgh());
        updateParam.setZxsj(zlJlxjzjAddReq.getZxsj() );
        zlSqdyyzxDao.update(updateParam);

    }

    /**
     * 治疗项目完成
     * @param zlsqdmxJlxh
     * @param user
     */
    public ReturnEntity<ZlJlxjzjResp> queryFinish(Integer zlsqdmxJlxh, SysUser user) {
        ReturnEntity<ZlJlxjzjResp> returnEntity=new ReturnEntity<>();
        //查询是否书写治疗总结
        ZlJlxjzj zlJlxjzjParam=new ZlJlxjzj();
        zlJlxjzjParam.setJgid(user.getHospitalId());
        zlJlxjzjParam.setZlsqdmxJlxh(zlsqdmxJlxh);
        //总结
        zlJlxjzjParam.setJllx("3");
        List<ZlJlxjzj> zlJlxjzjList=zlJlxjzjDao.findByEntity(zlJlxjzjParam);
        if(zlJlxjzjList.size()>0){
            ZlJlxjzjResp zlJlxjzjResp=new ZlJlxjzjResp();
            BeanUtils.copyProperties(zlJlxjzjList.get(0),zlJlxjzjResp);
            returnEntity.setData(zlJlxjzjResp);
           return returnEntity;

        }

        return returnEntity;
    }

    /**
     * 治疗项目完成保存
     *
     * @param zlsqdmxJlxh
     * @param user
     * @return
     */
    @Transactional(rollbackFor = Exception.class)
    public ReturnEntity<String> finishSave(Integer zlsqdmxJlxh, SysUser user) {
        ZlSqdmx updateZlSqdmx = new ZlSqdmx();
        updateZlSqdmx.setJlxh(zlsqdmxJlxh);
        updateZlSqdmx.setWcgh(user.getUserId());
        updateZlSqdmx.setWcrsj(new Timestamp(System.currentTimeMillis()));
        updateZlSqdmx.setQxwcgh(null);
        updateZlSqdmx.setQxwcsj(null);
        updateZlSqdmx.setZt("4");
        zlSqdmxDao.finishSave(updateZlSqdmx);
        //修改治疗申请单主表状态
        ZlSqdmx zlSqdmx = zlSqdmxDao.getById(zlsqdmxJlxh);

        ZlSqdmx queryZtParam=new ZlSqdmx();
        queryZtParam.setZlsqdh(zlSqdmx.getZlsqdh());
        List<ZlSqdmx> zlSqdmxLits=zlSqdmxDao.findByEntity(queryZtParam);

        boolean isAllFinish=true;
        for(ZlSqdmx mx:zlSqdmxLits){
            if(!"4".equals(mx.getZt())){
                isAllFinish= false;
                break;
            }


        }
        //修改主表状态
        if(isAllFinish){
            ZlSqdzb updateParam=new ZlSqdzb();
            updateParam.setZt("4");
            updateParam.setJlxh(Integer.parseInt(zlSqdmx.getZlsqdh()));
            zlSqdzbDao.updateByEntity(updateParam);
        }


        return ReturnEntityUtil.success();
    }

    /**
     * 取消治疗项目完成
     * @param zlsqdmxJlxh
     * @param user
     * @return
     */
    @Transactional(rollbackFor = Exception.class)
    public ReturnEntity<String> cancelFinish(Integer zlsqdmxJlxh, SysUser user) {
        ZlSqdmx updateZlSqdmx=new ZlSqdmx();
        updateZlSqdmx.setJlxh(zlsqdmxJlxh);
        updateZlSqdmx.setQxwcgh(user.getUserId());
        updateZlSqdmx.setQxwcsj(new Timestamp(System.currentTimeMillis()));
        updateZlSqdmx.setZt("3");
        zlSqdmxDao.cancelFinish(updateZlSqdmx);
        //修改治疗申请单主表状态
        ZlSqdmx zlSqdmx=zlSqdmxDao.getById(zlsqdmxJlxh);

        ZlSqdmx queryZtParam=new ZlSqdmx();
        queryZtParam.setZlsqdh(zlSqdmx.getZlsqdh());
        List<ZlSqdmx> zlSqdmxLits=zlSqdmxDao.findByEntity(queryZtParam);

        boolean isAllFinish=true;
        for(ZlSqdmx mx:zlSqdmxLits){
            if(!"4".equals(mx.getZt())){
                isAllFinish= false;
                break;
            }


        }
        //修改主表状态  部分执行
        if(!isAllFinish){
            ZlSqdzb updateParam=new ZlSqdzb();
            updateParam.setZt("3");
            updateParam.setJlxh(Integer.parseInt(zlSqdmx.getZlsqdh()));
            zlSqdzbDao.updateByEntity(updateParam);
        }
        return ReturnEntityUtil.success();
    }

    /**
     * 查询类别下的最后一条执行记录
     * @param jgid
     * @param zyh
     * @param zllb
     * @return
     */
    public ZlJlxjzjResp queryOneZxjl(Integer jgid,Integer zyh,Integer zllb){
        return zlJlxjzjDao.queryOneZxjl(jgid, zyh, zllb);
    }

    /**
     * 查询类别下的执行记录列表
     * @param jgid
     * @param zyh
     * @param zllb
     * @return
     */
    public List<ZlJlxjzjResp> queryAllZxjl(Integer jgid,Integer zyh,Integer zllb){
        return zlJlxjzjDao.queryZxjl(jgid, zyh, zllb);
    }

    /**
     * 开始执行
     * @param req
     */
    @Transactional(rollbackFor = Exception.class)
    public void startZx(StartZxReq req){
        if (CollUtil.isEmpty(req.getList())){
            //无需要执行的数据
            throw BaseException.create("ERROR_ZL_00019");
        }

        //循环执行
        for (XmzxData data:req.getList()){
            //必传校验(住院号，记录类型)
            mustPassCheck(data);

            //1.通过住院号,zllb等查询患者需要执行的项目
            QueryZyzlZxDetailReq detailReq = BeanUtil.toBean(req, QueryZyzlZxDetailReq.class);
            detailReq.setZyh(data.getZyh());
            List<QueryZyzlZxDetailResp> zxxmList = zlSqdzbSer.queryZxXm(detailReq);

            //生成执行时间
            Timestamp zxTime = new Timestamp(System.currentTimeMillis());

            //2存在项目执行插表操作
            if (CollUtil.isNotEmpty(zxxmList)){
                //数据插入到执行项目表（zl_sqdyyzx）
                addSqdyyzx(zxxmList,req,zxTime);

                //3数据插入到治疗记录/小结/总结表（zl_jlxjzj）
                addJlxjzj(data,req,zxTime);

                //4记账(查询最小收费项目)
                List<Integer> sqdmxidList = zxxmList.stream().map(o -> o.getSqdmxid()).collect(Collectors.toList());
                bookkeeping(sqdmxidList,zxTime,req.getZxr());
            }else {
                logger.error("住院号:{} 未查询到需要执行的项目，不保存项目,小结以及记账数据",data.getZyh());
            }
        };
    }

    /**
     * 取消执行
     * @param jlxh 记录序号（主键）
     */
    public void cancelZx(Integer jlxh,SysUser sysUser){
        //通过主键查询小结表数据
        ZlJlxjzj zlJlxjzj = zlJlxjzjDao.getById(jlxh);
        if (zlJlxjzj == null){
            throw BaseException.create("ERROR_ZL_00021");
        }

        //判断患者是否出院结算(已出院结算的住院病人不能取消执行)
        ImHzryModel hzryModel = imHzryService.queryPatientBaseInfo(zlJlxjzj.getZyh());
        if (hzryModel != null){
            if (hzryModel.getCypb() != null && hzryModel.getCypb() >= 8){
                throw BaseException.create("ERROR_ZL_00022");
            }
        }

        //退账时间
        Timestamp tzTime = new Timestamp(System.currentTimeMillis());

        //开始取消执行
        //1.取消治疗记录/小结/总结表数据（状态置为3已取消）
        zlJlxjzj.setZt(TreatmentCode.jlxjzjzt.QXZX.getCode());
        zlJlxjzj.setQxzxsj(tzTime);
        zlJlxjzj.setQxrgh(sysUser.getPersonId());
        zlJlxjzjDao.cancelZx(zlJlxjzj);
        //2.取消执行的项目（通过住院号，执行日期，诊疗类别查询治疗申请单预约执行表【zl_sqdyyzx】）
        List<ZlSqdyyzx> list = zlSqdyyzxDao.queryZlXm(zlJlxjzj.getZyh(), zlJlxjzj.getZxsj(), zlJlxjzj.getZllb());
        if (CollUtil.isNotEmpty(list)){
            list.stream().forEach(o ->{
                o.setZt(TreatmentCode.jlxjzjzt.QXZX.getCode());
                zlSqdyyzxDao.updateZxzt(o);
            });
        }
        //3.退账
        refund(zlJlxjzj.getJlsj(),zlJlxjzj.getZyh());
    }

    /**
     * 必传校验
     * @param data
     */
    private void mustPassCheck(XmzxData data) {
        if (data.getZyh() == null){
            throw BaseException.create("ERROR_ZL_00011");
        }
        if (StrUtil.isBlank(data.getJllx())){
            throw BaseException.create("ERROR_ZL_00020");
        }
    }

    /**
     * 执行后保存执行项目
     * @param zxxmList
     * @param req
     */
    private void addSqdyyzx(List<QueryZyzlZxDetailResp> zxxmList, StartZxReq req,Timestamp zxTime){
        zxxmList.stream().forEach(o ->{
            ZlSqdyyzx sqdyyzx = new ZlSqdyyzx();
            sqdyyzx.setJlxh(redisFactory.getTableKey(TableName.DB_NAME,TableName.ZL_SQDYYZX));
            sqdyyzx.setJgid(req.getJgid());
            sqdyyzx.setZt(TreatmentCode.jlxjzjzt.YZX.getCode());//已执行
            sqdyyzx.setZxsj(zxTime);
            sqdyyzx.setZxjlgh(req.getZxr());
            sqdyyzx.setZlSqdmxJlxh(o.getSqdmxid());//申请单明细id
            sqdyyzx.setZyh(o.getZyh());//住院号
            sqdyyzx.setZllb(req.getZllb());//诊疗类别
            zlSqdyyzxDao.insert(sqdyyzx);
        });
    }

    /**
     * 执行后保存小结
     * @param data
     * @param req
     */
    private void addJlxjzj(XmzxData data,StartZxReq req,Timestamp zxTime){
        ZlJlxjzj jlxjzj = new ZlJlxjzj();

        //如果没传小结 就取上次小结的值；传小结就取小结的值
        ZljlDetail detail = data.getZljlDetail();
        if (detail == null){
            //查询最后一次的诊疗总结数据
            ZlJlxjzjResp oneZxjl = queryOneZxjl(req.getJgid(), data.getZyh(), req.getZllb());
            if (oneZxjl == null){
                logger.error("住院号:{},诊疗类别:{},不存在最近一次的小结数据",data.getZyh(),req.getZllb());
            }else {
                //保存小结（数据库中获取的数据）
                jlxjzj.setJlxh(redisFactory.getTableKey(TableName.DB_NAME,TableName.ZL_JLXJZJ));
                jlxjzj.setJgid(req.getJgid());
                jlxjzj.setJlsj(zxTime);
                jlxjzj.setJllx(TreatmentCode.jllx.JL.getCode());
                jlxjzj.setZt(TreatmentCode.jlxjzjzt.YZX.getCode());
                jlxjzj.setZxsj(zxTime);
                jlxjzj.setZxysgh(oneZxjl.getZxysgh());//执行治疗师
                jlxjzj.setZyh(data.getZyh());
                jlxjzj.setZllb(req.getZllb());
                jlxjzj.setYwblfy(TreatmentCode.ywblfy.NO.getCode());
                jlxjzj.setJxzlsgh(oneZxjl.getJxzlsgh());//见习治疗师
                jlxjzj.setZxsjdks(dealZxsjd(oneZxjl.getZxsjdks()));
                jlxjzj.setZxsjdjs(dealZxsjd(oneZxjl.getZxsjdjs()));
                zlJlxjzjDao.insert(jlxjzj);
            }
        }else {
            //保存小结（传过来的数据）
            jlxjzj.setJlxh(redisFactory.getTableKey(TableName.DB_NAME,TableName.ZL_JLXJZJ));
            jlxjzj.setJgid(req.getJgid());
            jlxjzj.setJlsj(new Timestamp(System.currentTimeMillis()));
            jlxjzj.setJllx(data.getJllx());
            jlxjzj.setZt(TreatmentCode.jlxjzjzt.YZX.getCode());
            jlxjzj.setZxsj(new Timestamp(System.currentTimeMillis()));
            jlxjzj.setZxysgh(detail.getZxysgh());//执行治疗师
            jlxjzj.setZyh(data.getZyh());
            jlxjzj.setZllb(req.getZllb());
            jlxjzj.setYwblfy(detail.getYwblfy());
            jlxjzj.setBlfy(detail.getBlfy());
            jlxjzj.setJxzlsgh(detail.getJxzlsgh());//见习治疗师
            jlxjzj.setZxsjdks(detail.getZxsjdks());
            jlxjzj.setZxsjdjs(detail.getZxsjdjs());
            zlJlxjzjDao.insert(jlxjzj);
        }
    }

    /**
     * 处理执行时间段
     * @param oldZxsjd
     * @return
     */
    private String dealZxsjd(String oldZxsjd){
        if (StrUtil.isBlank(oldZxsjd)){
            return null;
        }
        //假如数据格式错误（暂定）
        if (oldZxsjd.length() != 16){
            return null;
        }
        return DateUtil.now().substring(0,10).concat(oldZxsjd.substring(10,16));
    }

    /**
     * 记账(im_fee_fymx表插入正数据)
     * @param sqdmxidList  申请单项目明细表主键
     * @param zxTime  执行时间
     * @param zxr 执行人
     */
    private void bookkeeping(List<Integer> sqdmxidList,Timestamp zxTime,Integer zxr){
        //查询到记账数据
        List<bookKeepingData> bookKeepingData = zlSqdzbDao.bookKeepingData(sqdmxidList);
        List<ImFeeFymxReq> bookKeepingDatas = bookKeepingData.stream().map(o -> {
            ImFeeFymxReq imFeeFymxReq = new ImFeeFymxReq();
            imFeeFymxReq.setJlxh(redisFactory.getTableKey(TableName.DB_NAME, TableName.IM_FEE_FYMX));
            imFeeFymxReq.setJgid(o.getJgid());
            imFeeFymxReq.setZyh(o.getZyh());
            imFeeFymxReq.setFyrq(zxTime);
            imFeeFymxReq.setFyxh(o.getFyxh());
            imFeeFymxReq.setFymc(o.getFymc());
            imFeeFymxReq.setYpcd(0);
            imFeeFymxReq.setFysl(o.getSl());
            imFeeFymxReq.setFydj(o.getFydj());
            imFeeFymxReq.setZjje(imFeeFymxReq.getFysl().multiply(imFeeFymxReq.getFydj()));
            imFeeFymxReq.setZfje(imFeeFymxReq.getFysl().multiply(imFeeFymxReq.getFydj()).multiply(o.getZfbl()));
            imFeeFymxReq.setYsgh(o.getYsgh() != null ? String.valueOf(o.getYsgh()) : null);
            imFeeFymxReq.setFybq(o.getFybq());
            imFeeFymxReq.setFyks(o.getFyks());
            imFeeFymxReq.setZlje(new BigDecimal(0));
            imFeeFymxReq.setZxks(o.getZxks());
            imFeeFymxReq.setJfrq(zxTime);
            imFeeFymxReq.setXmlx(6);//康复记账
            imFeeFymxReq.setYplx(0);//药品类型 | 0：费用\n1：西药\n2：中成药\n3：中草药\n'
            imFeeFymxReq.setFyxm(o.getFyxm());
            imFeeFymxReq.setJscs(0);
            imFeeFymxReq.setZfbl(o.getZfbl());
            imFeeFymxReq.setYzxh(0);
            imFeeFymxReq.setDzbl(new BigDecimal(0));
            imFeeFymxReq.setSrgh(String.valueOf(zxr));//输入工号
            //imFeeFymxReq.setQrgh();//确认工号
            imFeeFymxReq.setYepb(0);
            // TODO: 2021/1/29 缺少作废判别
            return imFeeFymxReq;
        }).collect(Collectors.toList());

        imFeeFymxService.batchInsert(bookKeepingDatas);
    }


    /**
     * 退账（将im_fee_fymx表原来的数据的ZFPB置为1，再生成一条负记录，ZFPB置为2）
     * @param jzsj  记账时间
     * @param zyh  住院号
     */
    private void refund(Timestamp jzsj,Integer zyh){
        //1.通过记账时间和住院号查询im_fee_fymx数据

        //2.将费用数据zfpb置为1

        //3生成新的数据

    }
}
