package com.buit.his.treatment.service;


import cn.hutool.core.collection.CollUtil;
import cn.hutool.core.date.DateUtil;
import cn.hutool.core.util.StrUtil;
import com.buit.cis.dctwork.response.CisHzyzModel;
import com.buit.cis.dctwork.response.CisHzyzZtModel;
import com.buit.cis.dctwork.service.CisHzyzService;
import com.buit.cis.dctwork.service.CisHzyzZtService;
import com.buit.commons.BaseException;
import com.buit.commons.BaseManagerImp;
import com.buit.commons.SysUser;
import com.buit.constans.TableName;
import com.buit.his.treatment.dao.*;
import com.buit.his.treatment.enums.ZfpbEnum;
import com.buit.his.treatment.enums.ZlsqdZtEnum;
import com.buit.his.treatment.model.*;
import com.buit.his.treatment.request.*;
import com.buit.his.treatment.response.*;
import com.buit.his.treatment.status.TreatmentCode;
import com.buit.op.model.OpYjcf01;
import com.buit.op.model.OpYjcf02;
import com.buit.op.model.OpYjcf02Zt;
import com.buit.op.service.OpYjcf01Service;
import com.buit.op.service.OpYjcf02Service;
import com.buit.op.service.OpYjcf02ZtService;
import com.buit.system.response.DicSypcModel;
import com.buit.system.response.GyYlxmDicResp;
import com.buit.system.service.DicSypcService;
import com.buit.system.service.FeeYlsfxmOutSer;
import com.buit.utill.*;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import jodd.util.StringUtil;
import org.apache.dubbo.config.annotation.DubboReference;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * 治疗申请单主表<br>
 * @author ZHOUHAISHENG
 */
@Service
public class ZlSqdzbSer extends BaseManagerImp<ZlSqdzb,Integer> {

    static final Logger logger = LoggerFactory.getLogger(ZlSqdzbSer.class);

    @Autowired
    private ZlSqdzbDao zlSqdzbDao;
    @Autowired
    private RedisFactory redisFactory;
    @Override
    public ZlSqdzbDao getEntityMapper(){
        return zlSqdzbDao;
    }
    @Autowired
    public ZlSqdmxSer zlSqdmxSer;
    @Autowired
    public ZlSqdmxDao zlSqdmxDao;
    @Autowired
    public ZlSqdzdSer zlSqdzdSer;
    @Autowired
    public ZlXmzljhSer zlXmzljhSer;
    @Autowired
    public ZlSqdxmzlnrSer zlSqdxmzlnrSer;
    @Autowired
    public ZlXmDao zlXmDao;
    @DubboReference
    public OpYjcf01Service opYjcf01Service;
    @DubboReference
    public OpYjcf02Service opYjcf02Service;
    @Autowired
    public ZlXmldsfxmDao zlXmldsfxmDao;
    @DubboReference
    public FeeYlsfxmOutSer feeYlsfxmOutSer;

    @DubboReference
    public DicSypcService dicSypcService;

    @DubboReference
    public CisHzyzZtService cisHzyzZtService;
    @DubboReference
    public OpYjcf02ZtService opYjcf02ZtService;
    @Autowired
    public ZlSqdxmzlnrDao zlSqdxmzlnrDao;
    @DubboReference
    public CisHzyzService cisHzyzSer;
    @Autowired
    public DicSer dicSer;
    @Autowired
    public ZlSqdzdDao zlSqdzdDao;
    @Autowired
    public ZlSqdyyzxDao zlSqdyyzxDao;
    @Autowired
    private ZlSqdsfmxDao zlSqdsfmxDao;
    @Autowired
    private ZlXmzljhDao zlXmzljhDao;



    /**
     * 门诊医生站分页查询病人申请单列表，未收费的也会展示
     */
    public List<ZlSqdzbPageResp> queryPage(ZlSqdzbPageQueryReq zlSqdzbPageQueryReq) {
        return zlSqdzbDao.queryPage(zlSqdzbPageQueryReq);
    }

    /**
     * 康复治疗分页查询病人治疗预约信息，已收费的才会显示
     */
    public List<ZlyyPageQueryResp> queryAppointPage(ZlyyPageQueryReq zlyyPageQueryReq) {
        List<ZlyyPageQueryResp> zlyyPageQueryResps = zlSqdzbDao.queryAppointPage(zlyyPageQueryReq);
        for (ZlyyPageQueryResp zlyyPageQueryResp : zlyyPageQueryResps) {
            zlyyPageQueryResp.setAge(DateUtil.ageOfNow(zlyyPageQueryResp.getCsny()));

        }
        return zlyyPageQueryResps;

    }

    /**
     * 新增病人治疗申请
     *
     * @param zlSqdzbReq
     * @return
     */
    @Transactional(rollbackFor = Exception.class)
    public ReturnEntity<String> add(ZlSqdzbReq zlSqdzbReq, SysUser sysUser) {
        //1.检验项目是否重复，校验项目是否已经存在
        checkIsExit(zlSqdzbReq.getZlSqdmxReqList(),sysUser.getHospitalId(),zlSqdzbReq.getJzlsh());
        //2.拆分项目（按照执行科室）
        Map<Integer, List<ZlSqdmxReq>> map = splitXmByZxks(zlSqdzbReq.getZlSqdmxReqList());
        //3.开始循环插入
        for (Map.Entry<Integer, List<ZlSqdmxReq>> newMap : map.entrySet()){
            Integer zxks = newMap.getKey();//执行科室
            List<ZlSqdmxReq> zlSqdmxReqs = newMap.getValue();//执行科室下对应的项目(组套)

            Integer zlsqdJlxh = redisFactory.getTableKey(TableName.DB_NAME, TableName.ZL_SQDZB);//治疗申请单主键

            //新增治疗申请单相关表
            List<ZlSqdmx> zlSqdmxList = addZlsqd(zlSqdzbReq, sysUser, zxks, zlSqdmxReqs,zlsqdJlxh);

            //门诊写入处置
            if("1".equals(zlSqdzbReq.getBrlx())){
                saveYjcf01(zlSqdzbReq, zlSqdmxList, sysUser, zlsqdJlxh,zxks);
            }
            //住院写入临时医嘱
            //if("2".equals(zlSqdzbReq.getBrlx())){
            //saveCisHzyz(zlSqdzbReq,zlSqdmxList,sysUser);
            //}
        }
        return ReturnEntityUtil.success();
    }

    /**
     * 新增治疗申请单相关表数据
     * @param zlSqdzbReq 主数据
     * @param sysUser 用户信息
     * @param zxks 执行科室
     * @param mxList  项目组套数据
     */
    private List<ZlSqdmx> addZlsqd(ZlSqdzbReq zlSqdzbReq,SysUser sysUser,Integer zxks,List<ZlSqdmxReq> mxList,Integer jlxh){
        //1.zl_sqdzb => 2.zl_sqdzd => 3.zl_sqdmx => 4.zl_sqdsfmx =>5.zl_sqdxmzlnr
        ZlSqdzb zlSqdzb = new ZlSqdzb();
        BeanUtils.copyProperties(zlSqdzbReq, zlSqdzb);
        zlSqdzb.setJlxh(jlxh);
        zlSqdzb.setJgid(sysUser.getHospitalId());
        //zlSqdzb.setJlxh(redisFactory.getTableKey(TableName.DB_NAME,TableName.ZL_SQDZB));
        zlSqdzb.setZlsqdh(zlSqdzb.getJlxh().toString());
        zlSqdzb.setSqsj(new Timestamp(System.currentTimeMillis()));
        zlSqdzb.setSqysgh(sysUser.getUserId());
        zlSqdzb.setZlksdm(zxks);//治疗科室代码
        //默认状态未预约(新开)
        zlSqdzb.setZt("0");
        //默认未作废
        zlSqdzb.setZf("0");
        //新增治疗申请单主表
        zlSqdzbDao.insert(zlSqdzb);

        //添加诊断列表
        zlSqdzdSer.add(zlSqdzbReq.getZlSqdzdReqList(),zlSqdzb,sysUser);

        //添加治疗项目明细列表以及明细对应的收费明细
        List<ZlSqdmx> zlSqdmxList = zlSqdmxSer.add(mxList, zlSqdzb, sysUser);

        //添加治疗申请单项目治疗内容表
        bublidZlSqdxmzlnrList(zlSqdmxList);
        return zlSqdmxList;
    }

    /**
     * 根据执行科室拆分明细
     * @param list
     */
    private Map<Integer, List<ZlSqdmxReq>> splitXmByZxks(List<ZlSqdmxReq> list){
        Map<Integer, List<ZlSqdmxReq>> mapForZxks = list.stream().collect(Collectors.groupingBy(ZlSqdmxReq::getZxks));
        return mapForZxks;
    }

    /**
     * 判断项目是否重复，判断项目是否已经申请过，不能重复申请
     * @param list
     */
    private void checkIsExit(List<ZlSqdmxReq> list,Integer jgid,String jzlsh){
        //无治疗项目
        if (CollUtil.isEmpty(list)){
            throw BaseException.create("ERROR_ZL_00043");
        }

        //项目重复
        Map<Integer, List<ZlSqdmxReq>> mapforJlxh = list.stream().collect(Collectors.groupingBy(ZlSqdmxReq::getZlxmJlxh));
        if (list.size() > mapforJlxh.size()){
            throw BaseException.create("ERROR_ZL_00005");
        }

        List<Integer> zlxmJlxhList = list.stream().map(o -> o.getZlxmJlxh()).collect(Collectors.toList());

        //项目是否停用
        List<String> stopList = zlXmDao.checkIsStop(zlxmJlxhList, jgid);
        if (CollUtil.isNotEmpty(stopList)){
            throw BaseException.create("ERROR_ZL_00046",new String[]{stopList.stream().collect(Collectors.joining(";"))});
        }

        //项目已经申请过
        List<String> zllmmcList = zlSqdmxDao.checkIsExit(zlxmJlxhList, jgid, jzlsh);
        if (CollUtil.isNotEmpty(zllmmcList)){
            throw BaseException.create("ERROR_ZL_00007", new String[]{zllmmcList.stream().collect(Collectors.joining(";"))});
        }

        //校验项目是否存在治疗计划
        List<String> zljhNotExit = zlXmzljhDao.checkIsExitZljh(zlxmJlxhList, jgid);
        if (CollUtil.isNotEmpty(zljhNotExit)){
            throw BaseException.create("ERROR_ZL_00038", new String[]{zljhNotExit.stream().collect(Collectors.joining(";"))});
        }
    }



    /**
     * 查询治疗申请单详情
     * @param jlxh
     * @return
     */
    public ReturnEntity<ZlSqdzbResp> getDetail(Integer jlxh) {
        ZlSqdzb zlSqdzb=zlSqdzbDao.getById(jlxh);
        ZlSqdzbResp zlSqdzbResp=new ZlSqdzbResp();
        BeanUtils.copyProperties(zlSqdzb,zlSqdzbResp);
        //查询治疗申请诊断信息
        ZlSqdzd zlSqdzd=new ZlSqdzd();
        zlSqdzd.setJgid(zlSqdzbResp.getJgid());
        zlSqdzd.setZlsqdh(zlSqdzbResp.getZlsqdh());

        List<ZlSqdzd> zlSqdzdList=zlSqdzdSer.findByEntity(zlSqdzd);
        List<ZlSqdzdResp> zlSqdzdRespList=BeanUtil.toBeans(zlSqdzdList, ZlSqdzdResp.class);
        zlSqdzbResp.setZlSqdzdRespList(zlSqdzdRespList);

        //查询治疗申请单明细
        ZlSqdmx param=new ZlSqdmx();
        param.setJgid(zlSqdzbResp.getJgid());
        param.setZlsqdh(zlSqdzbResp.getZlsqdh());
        param.setSortColumns("xh asc");
        List<ZlSqdmx> zlSqdmxList= zlSqdmxDao.findByEntity(param);
        List<ZlSqdmxResp> zlSqdmxRespList= BeanUtil.toBeans(zlSqdmxList,ZlSqdmxResp.class);
        ZlXm zlXmParam=new ZlXm();
        zlXmParam.setJgid(zlSqdzb.getJgid());
        zlXmParam.setZt("1");
        List<ZlXm> zlxmList= zlXmDao.findByEntity(zlXmParam);
        Map<String,List<ZlXm>> zlxmMap=zlxmList.stream().collect(Collectors.groupingBy(ZlXm::getZlxmmc));

        for(ZlSqdmxResp zlSqdmxResp:zlSqdmxRespList ){
            zlSqdmxResp.setLbmc(zlxmMap.get(zlSqdmxResp.getZlxmmc()).get(0).getLbmc());
            zlSqdmxResp.setDw(zlxmMap.get(zlSqdmxResp.getZlxmmc()).get(0).getDw());
        }

        zlSqdzbResp.setZlSqdmxRespList(zlSqdmxRespList);

        return ReturnEntityUtil.success(zlSqdzbResp);

    }

    /**
     * 修改病人治疗申请信息
     * @param zlSqdzbUpdateReq
     * @return
     */
    @Transactional(rollbackFor = Exception.class)
    public ReturnEntity<String> edit(ZlSqdzbUpdateReq zlSqdzbUpdateReq, SysUser user) {
        //修改病人治疗申请单主表
        ZlSqdzb zlSqdzb=new ZlSqdzb();
        BeanUtils.copyProperties(zlSqdzbUpdateReq,zlSqdzb);
        zlSqdzbDao.update(zlSqdzb);
        //修改病人诊断信息
        zlSqdzdSer.updateList(zlSqdzbUpdateReq,zlSqdzbUpdateReq.getZlSqdzdUpdateReqList(),user);

        //修改病人治疗项目信息
        zlSqdmxSer.updateList(zlSqdzbUpdateReq,zlSqdzbUpdateReq.getZlSqdmxUpdateReqList(),user);
        return ReturnEntityUtil.success();
    }

    /**
     * 病人治疗申请单作废
     *
     * @param jlxh 记录序号
     * @param zfgh 作废工号
     * @return
     */
    public ReturnEntity<String> cancel(Integer jlxh, Integer zfgh) {
        ZlSqdzb zlSqdzb = zlSqdzbDao.getById(jlxh);
        //已经执行申请单不能作废操作
        if (ZlsqdZtEnum.EXECUTED.equals(zlSqdzb.getZt()) || ZlsqdZtEnum.DONE.equals(zlSqdzb.getZt())) {
            throw BaseException.create("ERROR_ZL_00006");
        }
        ZlSqdzb cancelParam = new ZlSqdzb();
        cancelParam.setJlxh(jlxh);
        //已作废
        cancelParam.setZf(String.valueOf(ZfpbEnum.DISABLED.getValue()));
        cancelParam.setZfsj(new Timestamp(System.currentTimeMillis()));
        cancelParam.setZfgh(zfgh);
        zlSqdzbDao.updateByEntity(cancelParam);
        return ReturnEntityUtil.success();
    }

    /**
     * 删除处置
     * @param jlxh
     * @return
     */
    @Transactional(rollbackFor = Exception.class)
    public ReturnEntity deleteZlsq(Integer jlxh){
        //判断是否收费（已收费不能删除）
        ZlSqdzb sqdzb = zlSqdzbDao.getById(jlxh);
        if (sqdzb != null){
            if (StrUtil.isNotBlank(sqdzb.getZf()) && "1".equals(sqdzb.getZf())){
                throw BaseException.create("ERROR_ZL_00044");
            }
            if (StrUtil.isNotBlank(sqdzb.getFphm())){
                throw BaseException.create("ERROR_ZL_00045");
            }
        }

        //删除治疗申请单主表
        zlSqdzbDao.deleteById(jlxh);
        //删除治疗申请单诊断
        zlSqdzdSer.deleteBySqdh(jlxh);
        //删除治疗计划(通过主表的jlxh直接删除)
        zlSqdxmzlnrDao.deleteByZlSqdmxJlxh(jlxh);
        //删除治疗申请单收费明细(通过主表的jlxh直接删除)
        zlSqdsfmxDao.deleteByJlxh(jlxh);
        //删除治疗申请单明细(必须放最后)
        zlSqdmxSer.deleteBySqdh(jlxh);
        try {
            //刪除处置相关
            opYjcf01Service.deleteOpyj(jlxh);
        }catch (BaseException e){
            return ReturnEntityUtil.error(e.getCode(), e.getMessage());
        }catch (Exception e){
            return ReturnEntityUtil.error(e.getMessage());
        }
        return ReturnEntityUtil.success();
    }

    /**
     * 查询治疗内容
     * @param zlSqdmxList
     */
    private void bublidZlSqdxmzlnrList(List<ZlSqdmx> zlSqdmxList){
        List<ZlSqdxmzlnr> zlSqdxmzlnrList=new ArrayList<>();

        for(ZlSqdmx zlSqdmx:zlSqdmxList){
            //查询组套项目的具体的治疗计划
            ZlXmzljh queryParam =new ZlXmzljh();
            queryParam.setZlxmJlxh(zlSqdmx.getZlxmJlxh());
            List<ZlXmzljh> zlXmzljhList=zlXmzljhSer.findByEntity(queryParam);
            if (CollUtil.isEmpty(zlXmzljhList)){
                throw BaseException.create("ERROR_ZL_00038", new String[]{zlSqdmx.getZlxmmc()});
            }
            for(ZlXmzljh zlXmzljh:zlXmzljhList){
                ZlSqdxmzlnr zlSqdxmzlnr=new ZlSqdxmzlnr();
                BeanUtils.copyProperties(zlXmzljh,zlSqdxmzlnr);
                zlSqdxmzlnr.setXh(zlSqdmx.getXh());
                zlSqdxmzlnr.setZlsqdh(zlSqdmx.getZlsqdh());
                zlSqdxmzlnr.setJlxh(redisFactory.getTableKey(TableName.DB_NAME,TableName.ZL_SQDXMZLNR));
                zlSqdxmzlnr.setZlSqdmxJlxh(zlSqdmx.getJlxh());
                zlSqdxmzlnrList.add(zlSqdxmzlnr);
            }
        }

        //数据批量插入治疗申请单项目治疗内容表
        if(zlSqdxmzlnrList.size()>0){
            zlSqdxmzlnrSer.insertForeach(zlSqdxmzlnrList);
        }
    }

    /**
     * 保存门诊医技信息
     * @param zlSqdzbReq
     * @param zlSqdmxList
     * @param user
     * @param sqdzbJlxh
     */
    private void saveYjcf01(ZlSqdzbReq zlSqdzbReq, List<ZlSqdmx> zlSqdmxList, SysUser user, Integer sqdzbJlxh,Integer zxks) {
        //获取最大的医技组号
        Integer maxYjzh = opYjcf02Service.getMaxYjzh(zlSqdzbReq.getJzlsh(), zlSqdzbReq.getJgid());
        //Integer maxYjzh = 1;//同一康复申请单组套表（op_yj02_zt）组号从1开始,依次递增  todo 待定
        OpYjcf01 opYjcf01 = new OpYjcf01();
        Integer yjxh = redisFactory.getTableKey(TableName.DB_NAME, TableName.OP_YJCF01);
        opYjcf01.setYjxh(yjxh);
        opYjcf01.setJgid(user.getHospitalId());
        //opYjcf01.setMzxh(zlSqdzbReq.getJzxh());//门诊序号(取op_ys_jzls表就诊序号)
        opYjcf01.setBrid(zlSqdzbReq.getBrid());
        opYjcf01.setBrxm(zlSqdzbReq.getBrxm());
        opYjcf01.setKdrq(new Timestamp(System.currentTimeMillis()));
        opYjcf01.setKsdm(zlSqdzbReq.getKsdm());
        opYjcf01.setYsdm(String.valueOf(user.getUserId()));
        //opYjcf01.setZxks(zlSqdzbReq.getZlksdm());
        opYjcf01.setZxks(zxks);
        opYjcf01.setZxpb(TreatmentCode.Zxpb.WZX.getCode());//执行判别
        opYjcf01.setZfpb(TreatmentCode.Zfpb.WZF.getCode());//作废判别
        opYjcf01.setCfbz(TreatmentCode.Cfbz.NO.getCode());//处方标志
        opYjcf01.setJzxh(zlSqdzbReq.getJzxh());
        opYjcf01.setDjzt(TreatmentCode.Djzt.ZC.getCode());//单据状态
        opYjcf01.setJzkh(zlSqdzbReq.getKh());
        opYjcf01.setXmlx(TreatmentCode.Xmlx.ZL.getCode());
        //单据来源
        opYjcf01.setDjly(TreatmentCode.Djly.YSKD.getCode());
        opYjcf01.setJzlsh(zlSqdzbReq.getJzlsh());
        opYjcf01.setZlsqdid(sqdzbJlxh);
        //1.新增申请单主表
        opYjcf01Service.insert(opYjcf01);
        for (ZlSqdmx zlSqdmx : zlSqdmxList) {
            ZlXm zlxm = zlXmDao.getById(zlSqdmx.getZlxmJlxh());
            //查询康复组套对应的详细数据
            List<GyYlxmDicResp> zlXmldsfxmList = zlXmldsfxmDao.getfyxmDatas(user.getHospitalId(), zlxm.getJlxh());
            if (CollUtil.isEmpty(zlXmldsfxmList)){
                throw BaseException.create("ERROR_ZL_00037", new String[]{zlxm.getZlxmmc()});
            }
            StringBuffer yzmcStr = new StringBuffer();
            for (GyYlxmDicResp gyYlxm : zlXmldsfxmList) {
                yzmcStr.append(gyYlxm.getFymc()).append("+");
            }
            yzmcStr.deleteCharAt(yzmcStr.length()-1);//删除最后的‘+’号


            OpYjcf02Zt opYjcf02Zt=new OpYjcf02Zt();
            opYjcf02Zt.setSbxh(redisFactory.getTableKey(TableName.DB_NAME,TableName.OP_YJ02_ZT));
            opYjcf02Zt.setJgid(user.getHospitalId());
            opYjcf02Zt.setYjxh(yjxh);//op_yjcf01表主键
            opYjcf02Zt.setYlxh(zlSqdmx.getJlxh());//zl_sqdmx表主键
            opYjcf02Zt.setXmlx(TreatmentCode.Xmlx.ZL.getCode());//项目类型
            opYjcf02Zt.setYjzx(0);//医技主项？？？
            opYjcf02Zt.setYldj(zlSqdmx.getDj());//单价
            opYjcf02Zt.setYlsl(zlSqdmx.getSl());//数量
            opYjcf02Zt.setHjje(zlSqdmx.getJe());//总金额
            opYjcf02Zt.setFygb(6); // TODO: 2021/4/14 项目归并
            opYjcf02Zt.setZfbl(new BigDecimal(1));
            opYjcf02Zt.setBzxx(zlSqdmx.getZysx());//备注信息（取注意事项）
            opYjcf02Zt.setDzbl(new BigDecimal(1));//打折比例
            opYjcf02Zt.setYjzh(maxYjzh);//医技组号
            opYjcf02Zt.setDjzt(TreatmentCode.Djzt.ZC.getCode());
            //opYjcf02Zt.setZtbh(1); // TODO: 2021/4/14 组套编号
            opYjcf02Zt.setZxpb(0);//执行判别
            opYjcf02Zt.setFymc(zlSqdmx.getZlxmmc()+ "(" + yzmcStr.toString() + ")");
            opYjcf02Zt.setZtbz(TreatmentCode.Ztbz.YES.getCode());//组套标志
            opYjcf02Zt.setJzlsh(zlSqdzbReq.getJzlsh());
            //2.保存医技组套组套
            opYjcf02ZtService.insert(opYjcf02Zt);

            //3.保存组套明细
            saveYjcf02(zlSqdzbReq,opYjcf01,opYjcf02Zt.getSbxh(),zlSqdmx,maxYjzh,zlXmldsfxmList);

            maxYjzh++;//组号递增
        }
    }


    /**
     * 保存医技明细信息
     * @param zlSqdzbReq
     * @param opYjcf01
     * @param sbxh
     * @param zlSqdmx
     * @param maxYjzh
     * @param zlXmldsfxmList
     */
    private void saveYjcf02(ZlSqdzbReq zlSqdzbReq,OpYjcf01 opYjcf01,Integer sbxh,ZlSqdmx zlSqdmx,Integer maxYjzh,List<GyYlxmDicResp> zlXmldsfxmList){
        //Integer yjzh = 1;//康复项目的收费项目未分组，默认同组
        for(GyYlxmDicResp zlXmldsfxm:zlXmldsfxmList){
            OpYjcf02 opYjcf02=new  OpYjcf02();
            opYjcf02.setSbxh(redisFactory.getTableKey(TableName.DB_NAME,TableName.OP_YJCF02));
            opYjcf02.setJgid(opYjcf01.getJgid());
            opYjcf02.setYjxh(opYjcf01.getYjxh());//op_yjcf01表主键
            opYjcf02.setYlxh(Integer.valueOf(zlXmldsfxm.getFyxh()));//收费项目序号
            opYjcf02.setXmlx(zlXmldsfxm.getXmlx());
            opYjcf02.setYjzx(0);//医技主项
            opYjcf02.setYldj(zlXmldsfxm.getFydj());
            opYjcf02.setYlsl(zlSqdmx.getSl());
            opYjcf02.setHjje(opYjcf02.getYldj().multiply(opYjcf02.getYlsl()).setScale(2, RoundingMode.HALF_UP));
            opYjcf02.setFygb(zlXmldsfxm.getFygb());
            //获取自负比例
            Map<String, Object> zfblParamMap=new HashMap<>();
            zfblParamMap.put("TYPE",0);
            zfblParamMap.put("BRXZ",zlSqdzbReq.getBrxz());
            zfblParamMap.put("FYXH", zlXmldsfxm.getFyxh());
            zfblParamMap.put("FYGB", zlXmldsfxm.getFygb());
            Map<String, Object> zfblMap = cisHzyzSer.getzfbl(zfblParamMap);
            opYjcf02.setZfbl(new BigDecimal(MapAttributeUtils.getString("ZFBL", zfblMap)));
            opYjcf02.setDzbl(new BigDecimal(1).subtract(opYjcf02.getZfbl()));
            opYjcf02.setYjzh(maxYjzh);//医技组号  默认同组
            opYjcf02.setZtbz(TreatmentCode.Ztbz.YES.getCode());
            opYjcf02.setJzlsh(opYjcf01.getJzlsh());
            opYjcf02.setZtyzsbxh(sbxh);
            opYjcf02Service.insert(opYjcf02);
        }
    }
    //治疗管理 保存临时医嘱(组套)
    private void saveCisHzyz(ZlSqdzbReq zlSqdzbReq, List<ZlSqdmx> zlSqdmxList,SysUser user) {

        List<GyYlxmDicResp> gyYlxmDicResp= feeYlsfxmOutSer.queryZlxmDicList(zlSqdzbReq.getJgid(),null);
        Map<Integer,List<GyYlxmDicResp>> ylxmMap=gyYlxmDicResp.stream().collect(Collectors.groupingBy(GyYlxmDicResp::getFyxh));
        List<CisHzyzModel> cisHzyzList=new ArrayList<>();
        List<CisHzyzZtModel> cisHzyzZtList=new ArrayList<>();

        Integer yzpx = 1;// 医嘱排序
        Integer jcxh = redisFactory.getTableKey(TableName.DB_NAME, TableName.CIS_JCSQ01);
        for(ZlSqdmx zlSqdmx:zlSqdmxList) {
            ZlXm zlxm = zlXmDao.getById(zlSqdmx.getZlxmJlxh());
            ZlXmldsfxm zlXmldsfxmParam = new ZlXmldsfxm();
            zlXmldsfxmParam.setZlksdm(zlxm.getZlksdm());
            zlXmldsfxmParam.setZlxmmc(zlxm.getZlxmmc());
            List<ZlXmldsfxm> zlXmldsfxmList = zlXmldsfxmDao.findByEntity(zlXmldsfxmParam);
            // 查询st对应的执行时间
            DicSypcModel dicSypc  = dicSypcService.getById("st");
            String zxsj = "";
            //组套编号
            Integer ztbh =zlSqdmx.getJlxh();
            StringBuffer yzmcStr = new StringBuffer();
            for (ZlXmldsfxm zlXmldsfxm : zlXmldsfxmList) {
                yzmcStr.append(ylxmMap.get(Integer.parseInt(zlXmldsfxm.getSfxmdm())).get(0).getFymc()).append("+");
            }
            yzmcStr.deleteCharAt(yzmcStr.length()-1);

            if (dicSypc != null && StrUtil.isNotBlank(dicSypc.getZxsj())) {
                zxsj = dicSypc.getZxsj();
            }
            //保存组套信息
            CisHzyzZtModel cisHzyzZt=new CisHzyzZtModel();
            cisHzyzZt.setYzlx(6);
            cisHzyzZt.setJgid(zlSqdzbReq.getJgid());
            cisHzyzZt.setZyh(zlSqdzbReq.getZyh());
            //药嘱名称
            cisHzyzZt.setYzmc(zlSqdmx.getZlxmmc()+ "(" + yzmcStr.toString() + ")");
            cisHzyzZt.setYpxh(ztbh);
            cisHzyzZt.setYpcd(0);
            cisHzyzZt.setXmlx(6);
            cisHzyzZt.setYplx(0);
            //一次数量
            cisHzyzZt.setYcsl(new BigDecimal(1.0000));
            cisHzyzZt.setMzcs(0);
            cisHzyzZt.setKssj(new Timestamp(System.currentTimeMillis()));
            //停嘱时间
            cisHzyzZt.setTzsj(new Timestamp(System.currentTimeMillis()));
            //使用频次
            cisHzyzZt.setSypc("st");
            //医嘱执行时间
            cisHzyzZt.setYzzxsj(zxsj);
            //药品单价
            cisHzyzZt.setYpdj(zlSqdmx.getDj());
            cisHzyzZt.setYpyf(0);
           cisHzyzZt.setJfbz(3);
            //首日次数
            cisHzyzZt.setSrcs(1);
            cisHzyzZt.setCzgh(String.valueOf(zlSqdzbReq.getSqysgh()));
            cisHzyzZt.setZyh(zlSqdzbReq.getZyh());

            cisHzyzZt.setSrks(zlSqdzbReq.getKsdm());
            Integer ztxh=redisFactory.getTableKey(TableName.DB_NAME, TableName.CIS_HZYZ_ZT);
            cisHzyzZt.setSqid(jcxh);
            cisHzyzZt.setSybz(0);
            cisHzyzZt.setZfpb(0);
            cisHzyzZt.setYjzx(0);
            cisHzyzZt.setYfsb(0);
            cisHzyzZt.setYsbz(1);
            cisHzyzZt.setYstj(0);
            //作废标志
            cisHzyzZt.setZfbz(0);
            // 审方结果
            cisHzyzZt.setSfjg(new BigDecimal(0));
            //复核标志
            cisHzyzZt.setFhbz(0);
            //// 停嘱复核标志
            cisHzyzZt.setTzfhbz(0);
            //皮试判别
            cisHzyzZt.setPspb(0);
            //医嘱判别
            cisHzyzZt.setYzpb(0);
            //历史标志
            cisHzyzZt.setLsbz(0);
            //婴儿判别
            cisHzyzZt.setYepb(0);
            //发药属性
            cisHzyzZt.setFysx(0);
            cisHzyzZt.setTpn(0);
            // 临时医嘱
            cisHzyzZt.setLsyz(1);
            // 贴数
            cisHzyzZt.setCfts(0);
            // 煎法
            cisHzyzZt.setYpzs(1);
            // 脚注
            cisHzyzZt.setJz(1);
            cisHzyzZt.setMrcs(1);
            //开嘱医生
            cisHzyzZt.setYsgh(zlSqdzbReq.getSqysgh().toString());
            //停嘱医生
            cisHzyzZt.setTzys(zlSqdzbReq.getSqysgh().toString());
            //机构id
            cisHzyzZt.setJgid(zlSqdzbReq.getJgid());
            // 组套标志(该条医嘱存是组套信息) 0非组套标志，1组套标志
            cisHzyzZt.setZtbz(1);
            //一次剂量
            cisHzyzZt.setYcjl(new BigDecimal(0));
            //药品序号
            cisHzyzZt.setYpxh(Integer.valueOf(zlSqdmx.getZlsqdh()));
            //医技序号
            cisHzyzZt.setYjxh(Integer.valueOf(zlSqdmx.getZlsqdh()));
          /*  //药嘱名称
            cisHzyzZt.setYzmc(zlSqdmx.getZlxmmc());*/
            cisHzyzZt.setYzlx(6);
            cisHzyzZt.setYzpx(yzpx++);
            cisHzyzZt.setZxks(zlSqdzbReq.getZlksdm());
            cisHzyzZt.setJlxh(ztxh);
            cisHzyzZt.setBrks(zlSqdzbReq.getKsdm());
            cisHzyzZt.setBrbq(zlSqdzbReq.getBqdm());
            cisHzyzZt.setBrch(zlSqdzbReq.getBrch());
            cisHzyzZt.setYzzh(redisFactory.getTableKey(TableName.DB_NAME,TableName.CIS_HZYZ_ZT+".yzzh"));
            Integer  yzzh=redisFactory.getTableKey(TableName.DB_NAME,TableName.CIS_HZYZ+".yzzh");
            cisHzyzZtList.add(cisHzyzZt);
            for (ZlXmldsfxm zlXmldsfxm : zlXmldsfxmList) {
                GyYlxmDicResp ylxm=ylxmMap.get(Integer.parseInt(zlXmldsfxm.getSfxmdm())).get(0);
                CisHzyzModel cisHzyz = new CisHzyzModel();
                Integer xh=redisFactory.getTableKey(TableName.DB_NAME, TableName.CIS_HZYZ);
                cisHzyz.setZtyzjlxh(ztxh);
                cisHzyz.setBrks(zlSqdzbReq.getKsdm());
                cisHzyz.setBrbq(zlSqdzbReq.getBqdm());
                cisHzyz.setBrch(zlSqdzbReq.getBrch());
                cisHzyz.setZfyp(0);
                cisHzyz.setYpcd(0);
                cisHzyz.setXmlx(6);
                cisHzyz.setYplx(0);
                cisHzyz.setZtbz(1);
                //一次数量
                cisHzyz.setYcsl(zlXmldsfxm.getSl());
                cisHzyz.setMrcs(1);
                cisHzyz.setMzcs(0);
                cisHzyz.setJfbz(3);
                cisHzyz.setYpyf(0);
                cisHzyz.setBzxx("(不计费医嘱)");
                //首日次数
                cisHzyz.setSrcs(1);
                cisHzyz.setYfdw(ylxm.getFydw());
                cisHzyz.setCzgh(String.valueOf(zlSqdzbReq.getSqysgh()));
                cisHzyz.setZyh(zlSqdzbReq.getZyh());
                 cisHzyz.setYzzh(yzzh);

                cisHzyz.setKssj(new Timestamp(System.currentTimeMillis()));
                cisHzyz.setSrks(zlSqdzbReq.getKsdm());
                cisHzyz.setSqid(jcxh);
                cisHzyz.setSybz(0);
                cisHzyz.setZfpb(0);
                cisHzyz.setYjzx(0);
                cisHzyz.setYfsb(0);
                cisHzyz.setYsbz(1);
                cisHzyz.setYstj(0);
                //作废标志
                cisHzyz.setZfbz(0);
                // 审方结果
                cisHzyz.setSfjg(0);
                //复核标志
                cisHzyz.setFhbz(0);
                //// 停嘱复核标志
                cisHzyz.setTzfhbz(0);
                //皮试判别
                cisHzyz.setPspb(0);
                //医嘱判别
                cisHzyz.setYzpb(0);
                //历史标志
                cisHzyz.setLsbz(0);
                //婴儿判别
                cisHzyz.setYepb(0);
                //发药属性
                cisHzyz.setFysx(0);
                cisHzyz.setTpn(0);
                // 临时医嘱
                cisHzyz.setLsyz(1);
                // 贴数
                cisHzyz.setCfts(0);
                // 煎法
                cisHzyz.setYpzs(1);
                // 脚注
                cisHzyz.setJz(1);
                //药品单价
                cisHzyz.setYpdj(ylxm.getFydj());
                //开嘱医生
                cisHzyz.setYsgh(zlSqdzbReq.getSqysgh().toString());
                //停嘱时间
                cisHzyz.setTzsj(new Timestamp(System.currentTimeMillis()));
                //停嘱医生
                cisHzyz.setTzys(zlSqdzbReq.getSqysgh().toString());
                //使用频次
                cisHzyz.setSypc("st");
                //医嘱执行时间
                cisHzyz.setYzzxsj(zxsj);
                //机构id
                cisHzyz.setJgid(zlSqdzbReq.getJgid());
                //住院号
                cisHzyz.setZyh(zlSqdzbReq.getZyh());
                //一次剂量
                cisHzyz.setYcjl(new BigDecimal(0));
                //药品序号
                cisHzyz.setYpxh(Integer.valueOf(zlXmldsfxm.getSfxmdm()));
                //医技序号
                cisHzyz.setYjxh(Integer.valueOf(zlXmldsfxm.getSfxmdm()));
                //药嘱名称
                cisHzyz.setYzmc(ylxm.getFymc());
                cisHzyz.setYzlx(6);

                cisHzyz.setYzpx(zlXmldsfxm.getPxh());
                cisHzyz.setZxks(zlSqdzbReq.getZlksdm());
                cisHzyz.setJlxh(xh);
                cisHzyzList.add(cisHzyz);
            }
        }
        for(CisHzyzZtModel cisHzyzZt:cisHzyzZtList){
            cisHzyzZtService.insert(cisHzyzZt);
        }
        for(CisHzyzModel cisHzyz:cisHzyzList){
        cisHzyzSer.insert(cisHzyz);
        }
    }

    /**
     * 查询统计-病人治疗申请单查询
     * @param patientTreatFromQueryReq
     * @param user
     * @return
     */
    public List<PatientTreatFromQueryResp> queryPatientZlyyReport(PatientTreatFromQueryReq patientTreatFromQueryReq, SysUser user) {
        List<PatientTreatFromQueryResp> respList=zlSqdzbDao.queryPatientZlyyReport(patientTreatFromQueryReq);
        for(PatientTreatFromQueryResp patientTreatFromQueryResp:respList){
            patientTreatFromQueryResp.setAge(DateUtil.ageOfNow(patientTreatFromQueryResp.getCsny()));
        }

        return respList;
    }


    /**
     * 查询统计-科室治疗工作量统计
     * @param deptTreatStatisticsReq
     * @param
     * @return
     */
    public PageInfo<DeptTreatStatisticsResp> queryDeptTreatStatistics(DeptTreatStatisticsReq deptTreatStatisticsReq) {
        PageInfo<DeptTreatStatisticsResp> pageInfo = PageHelper.startPage(
                deptTreatStatisticsReq.getPageNum(), deptTreatStatisticsReq.getPageSize()).doSelectPageInfo(
                () -> zlSqdmxDao.queryDeptTreatStatistics(deptTreatStatisticsReq)
        );
        return pageInfo;
    }

    /**
     * 查询统计-医生治疗工作量统计（分页查询）
     * @param doctorTreatStatisticsReq
     * @return
     */
    public List<DoctorTreatStatisticsResp> queryDoctorTreatStatistics(DoctorTreatStatisticsReq doctorTreatStatisticsReq) {

        List<DoctorTreatStatisticsResp> doctorTreatStatisticsRespList=   zlSqdmxDao.queryDoctorTreatStatistics(doctorTreatStatisticsReq);

        return doctorTreatStatisticsRespList;
    }

    /**
     * 查询统计-医生治疗工作量统计(明细明细 )
     * @param doctorTreatStatisticsDetailReq
     */
    public PageInfo<DoctorTreatStatisticsDetailResp> queryDoctorTreatStatisticsDetail(DoctorTreatStatisticsDetailReq doctorTreatStatisticsDetailReq) {
        PageInfo<DoctorTreatStatisticsDetailResp> resp = PageHelper.startPage(
                doctorTreatStatisticsDetailReq.getPageNum(), doctorTreatStatisticsDetailReq.getPageSize()).doSelectPageInfo(
                () -> zlSqdmxDao.queryDoctorTreatStatisticsDetail(doctorTreatStatisticsDetailReq)
        );
        for(DoctorTreatStatisticsDetailResp r:resp.getList()){
            r.setAge(DateUtil.ageOfNow(r.getCsny()));
            r.setJe(r.getJe().setScale(2));
        }
       return resp;
    }

    /**
     * 获取治疗预约P参数
     * @param jlxh
     * @param user
     * @return
     */
    public Map<String, Object> getYyzydPrintParams(Integer jlxh, SysUser user) {
        Map respMap=new HashMap();
        Map<String,Object> zbMap=zlSqdzbDao.getZlSqdzbMap(jlxh);
        ZlSqdmx queryZlSqdmx=new ZlSqdmx();
        queryZlSqdmx.setZlsqdh(MapAttributeUtils.getString("zlsqdh",zbMap));
        List<ZlSqdmx> zlSqdmxList=zlSqdmxDao.findByEntity(queryZlSqdmx);
        ZlSqdzd zlSqdzdParam=new ZlSqdzd();
        zlSqdzdParam.setJgid(user.getHospitalId());
        zlSqdzdParam.setZlsqdh(MapAttributeUtils.getString("zlsqdh",zbMap));
        List<ZlSqdzd> zlSqdzdList= zlSqdzdDao.findByEntity(zlSqdzdParam);
        respMap.put("yymc",user.getHospitalName());
        respMap.put("xmmc",zlSqdmxList.stream().map(ZlSqdmx::getZlxmmc).collect(Collectors.joining(",")));
        respMap.put("brxm",MapAttributeUtils.getString("brxm",zbMap));
        respMap.put("zybs",MapAttributeUtils.getString("zybs",zbMap));
        respMap.put("brxb",dicSer.getBrxbDic().get(MapAttributeUtils.getString("brxb",zbMap)));
        if(StringUtil.isNotBlank(MapAttributeUtils.getString("zyhm",zbMap))){
            respMap.put("brlx","住院号码:");
            respMap.put("zyhm",MapAttributeUtils.getString("zyhm",zbMap));
        }
        if(StringUtil.isNotBlank(MapAttributeUtils.getString("mzhm",zbMap))){
            respMap.put("brlx","门诊号码:");
            respMap.put("mzhm",MapAttributeUtils.getString("mzhm",zbMap));
        }
        respMap.put("yb","");
        respMap.put("dz", StringUtil.isNotBlank(MapAttributeUtils.getString("dz",zbMap))?"":MapAttributeUtils.getString("dz",zbMap));
        respMap.put("brnl",DateUtil.ageOfNow(MapAttributeUtils.getString("csny",zbMap))+"岁" );
        respMap.put("cwh",MapAttributeUtils.getString("brch",zbMap));
        respMap.put("telephone",MapAttributeUtils.getString("lxdh",zbMap));
        respMap.put("ZYSX",zlSqdmxList.stream().map(ZlSqdmx::getZysx).collect(Collectors.joining(",")));
        respMap.put("llmb",zlSqdmxList.stream().map(ZlSqdmx::getZlmb).collect(Collectors.joining(",")));
        respMap.put("zd",zlSqdzdList.stream().map(ZlSqdzd::getZdmc).collect(Collectors.joining(",")));
        respMap.put("tjpd",MapAttributeUtils.getString("tjpd",zbMap));
        respMap.put("zysx",zlSqdmxList.stream().map(ZlSqdmx::getZysx).collect(Collectors.joining(",")));
        return respMap;
    }

    /**
     * 获取治疗预约List参数
     * @param jlxh
     * @param user
     * @return
     */
    public List<Map<String, Object>> getYyzydPrintFields(Integer jlxh, SysUser user) {
        List<Map<String, Object>> response=new ArrayList<>();
        Map<String,Object> zbMap=zlSqdzbDao.getZlSqdzbMap(jlxh);
        ZlSqdmx queryZlSqdmx=new ZlSqdmx();
        queryZlSqdmx.setZlsqdh(MapAttributeUtils.getString("zlsqdh",zbMap));
        List<ZlSqdmx> zlSqdmxList=zlSqdmxDao.findByEntity(queryZlSqdmx);
        ZlSqdxmzlnr zlSqdxmzlnrParam=new ZlSqdxmzlnr();
        zlSqdxmzlnrParam.setJgid(user.getHospitalId());
        zlSqdxmzlnrParam.setZlsqdh(MapAttributeUtils.getString("zlsqdh",zbMap));
        List<ZlSqdxmzlnr> zlSqdxmzlnrList=zlSqdxmzlnrDao.findByEntity(zlSqdxmzlnrParam);
        ZlSqdyyzx zlSqdyyzxParam=new ZlSqdyyzx();
        zlSqdyyzxParam.setZlsqdh(MapAttributeUtils.getString("zlsqdh",zbMap));
        List<ZlSqdyyzx> zlSqdyyzxList= zlSqdyyzxDao.findByEntity(zlSqdyyzxParam);


        int i=0;
        for(ZlSqdxmzlnr nr:zlSqdxmzlnrList){
            i=i+1;
            Map<String, Object> respMap=new HashMap<>();
            respMap.put("typeNum",i);
            respMap.put("zlcs",nr.getZlcs());
            respMap.put("bw",nr.getZlbw());
            respMap.put("methods",nr.getZlff());
            respMap.put("sj",nr.getSj());
            respMap.put("pc",nr.getZlpc());
            response.add(respMap);
        }
        int j=0;
        for(ZlSqdyyzx zx:zlSqdyyzxList){
            j=j+1;
            ZlSqdmx zlsqdmx=zlSqdmxDao.getById(zx.getZlSqdmxJlxh());

            Map<String, Object> respMap=new HashMap<>();
            respMap.put("cs",j);
            respMap.put("date",zx.getYysj());
            respMap.put("zlxg",StringUtil.isBlank(zlsqdmx.getZlmb())?"":zlsqdmx.getZlmb());
            respMap.put("bz","");
            respMap.put("zlys",zx.getZxygh());
            response.add(respMap);

        }


        return response;
    }

    /**
     * 查询住院治疗预约数据
     * 查询出护士已复核、执行科室为当前登录科室的长期/临时医嘱项目
     * @param req
     * @return
     */
    public List<QueryZyzlyyResp> queryZyzlyy(QueryZyzlyyReq req){
        return zlSqdzbDao.queryZyzlyy(req);
    }

    /**
     * 查询住院治疗预约治疗项目数据
     * @param req
     * @return
     */
    public List<QueryZyzlyyDetailResp> zyzlyyDetail(QueryZyzlyyDetailReq req){
        // TODO: 2021/1/22  对于临时医嘱 可能需要判断如果临时医嘱已经做了的不展示
        return zlSqdzbDao.queryZyzDetail(req);
    }

    /**
     * 住院治疗预约操作
     * @param reqs
     * @param sysUser
     */
    public void applyZyzlyy(List<ApplyZyzlyyReq> reqs,SysUser sysUser){
        if (CollUtil.isEmpty(reqs)){
            throw BaseException.create("ERROR_ZL_00016");
        }
        //校验非空
        validIsNotNull(reqs);

        reqs.stream().forEach(o ->{
            //校验预约时间与其他项目的是否交叉
            boolean overlapping = checkTimeNotOverlapping(o);
            if (!overlapping){
                //开始预约
                startAppoint(o,sysUser);
            }
        });
    }

    /**
     * 查询住院治疗执行数据
     * @param req
     * @return
     */
    public List<ImpleZyzlyyResp> impleZyzlyy(ImpleZyzlyyReq req){
        List<ImpleZyzlyyResp> resps = zlSqdzbDao.queryZyzlzx(req);
        if (CollUtil.isEmpty(resps)){
            return resps;
        }

        //查询到数据,过滤数据
        //1、根据执行状态过滤
        filterByZxzt(req,resps);

        //2、根据病人情况过滤
        filterByBrqk(req,resps);

        return resps;
    }

    /**
     * 通过住院号查询患者需要执行的项目
     * @param req
     * @return
     */
    public List<QueryZyzlZxDetailResp> queryZxXm(QueryZyzlZxDetailReq req){
        List<QueryZyzlZxDetailResp> resps = zlSqdzbDao.queryZxXm(req);
        if (CollUtil.isEmpty(resps)){
            return resps;
        }

        resps.stream().forEach(o ->{
            //过滤临时项目（对于已经做过的临时医嘱，不会再重复展示）todo 有问题需要优化
            int count = zlSqdzbDao.queryBrqk(req.getZyh(), req.getZllb());
            if (count > 0 && TreatmentCode.lx.LS.getCode().equals(o.getLx())){
                resps.removeIf(item -> item.getSqdmxid() == o.getSqdmxid());
            }
        });
        return resps;
    }

    /**
     * 根据执行状态过滤
     * @param req
     * @param resps
     * @return
     */
    private List<ImpleZyzlyyResp> filterByZxzt(ImpleZyzlyyReq req,List<ImpleZyzlyyResp> resps){
        if (req.getZxzt() == null){
            return resps;
        }

        //查看执行状态（住院号，诊疗类别，执行时间 ）
        resps.stream().forEach(o ->{
            int count = zlSqdzbDao.queryZxzt(o.getZyh(), req.getZllb(), req.getZxrq());
            //更新执行状态
            if (count == 0){
                o.setZxzt(TreatmentCode.zxzt.WZX.getCode());
            }else {
                o.setZxzt(TreatmentCode.zxzt.YZX.getCode());
            }

            //过滤数据
            if (req.getZxzt() == 0){
                //未执行
                if (count > 0)
                    resps.removeIf(item -> item.getZyh() == o.getZyh());

            }else if (req.getZxzt() == 1){
                //已执行
                if (count == 0)
                    resps.removeIf(item -> item.getZyh() == o.getZyh());
            }
        });
        return resps;
    }

    /**
     * 根据病人情况过滤
     * @param req
     * @param resps
     * @return
     */
    private List<ImpleZyzlyyResp> filterByBrqk(ImpleZyzlyyReq req,List<ImpleZyzlyyResp> resps){
        int zxxjcs = 10;//执行小结次数为10的倍数
        if (req.getBrqk() == null){
            return resps;
        }

        //查询病人情况(住院号，诊疗类别，执行时间)
        resps.stream().forEach(o ->{
            int count = zlSqdzbDao.queryBrqk(o.getZyh(), req.getZllb());

            //更新病人情况状态
            if (count == 0){
                //新病人
                o.setBrqk(TreatmentCode.brqk.NEW_PAT.getCode());
            } else if ((count+1) % zxxjcs == 0){
                //需要阶段小结
                o.setBrqk(TreatmentCode.brqk.SUMMARY_PAT.getCode());
            }else {
                //普通
                o.setBrqk(TreatmentCode.brqk.NORMAL.getCode());
            }


            //过滤数据
            if (req.getBrqk() == TreatmentCode.brqk.NEW_PAT.getCode()){
                if (count > 0){
                    resps.removeIf(item -> item.getZyh() == o.getZyh());
                }
            }else if (req.getBrqk() == TreatmentCode.brqk.SUMMARY_PAT.getCode()){
                if (count == 0 || (count+1) % zxxjcs == 0){
                    resps.removeIf(item -> item.getZyh() == o.getZyh());
                }
            }
        });
        return resps;
    }



    /**
     * 校验非空
     * @param reqs
     */
    private void validIsNotNull(List<ApplyZyzlyyReq> reqs){
        for (ApplyZyzlyyReq req:reqs){
            if (req.getZyh() == null || req.getZyh() == 0){
                throw BaseException.create("ERROR_ZL_00011");
            }
            if (req.getZllb() == null || req.getZllb() == 0){
                throw BaseException.create("ERROR_ZL_00012");
            }
            if (StrUtil.isBlank(req.getYysdks())){
                throw BaseException.create("ERROR_ZL_00017");
            }
            if (StrUtil.isBlank(req.getYysdjs())){
                throw BaseException.create("ERROR_ZL_00018");
            }
        }
    }

    /**
     * 校验预约时间与其他项目的是否交叉
     * @param req
     */
    private boolean checkTimeNotOverlapping(ApplyZyzlyyReq req){
        List<ZlSqdmx> zlSqdmxes = zlSqdzbDao.queryNotIdentity(req.getZllb(), req.getZyh(), req.getJgid());
        if (CollUtil.isNotEmpty(zlSqdmxes)){
            for (ZlSqdmx zlSqdzb:zlSqdmxes){
                //校验时间是否有交叉
                boolean isSame = inspectionTime(req.getYysdks(), req.getYysdjs(), zlSqdzb.getYysdks(), zlSqdzb.getYysdjs());
                if (isSame){
                    return true;
                }
            }
        }
        return false;
    }

    /**
     * 校验时间是否存在交叉
     * @param reqSjKs 请求开始时间
     * @param reqSjJs 请求结束时间
     * @param compareKs 比较的开始时间
     * @param compareJs 比较的结束时间
     */
    private boolean inspectionTime(String reqSjKs,String reqSjJs,String compareKs,String compareJs){
        Integer ks = Integer.valueOf(reqSjKs.replace(":",""));
        Integer js = Integer.valueOf(reqSjJs.replace(":",""));
        Integer compKs = Integer.valueOf(compareKs.replace(":",""));
        Integer compJs = Integer.valueOf(compareJs.replace(":",""));
        if ( (ks > compKs&& ks < compJs) || (js > compKs && js < compJs ) ){
            return true;
        }
        return false;
    }

    /**
     * 开始预约
     * @param req
     * @param sysUser
     */
    private void startAppoint(ApplyZyzlyyReq req,SysUser sysUser){
        //查询预约项目
        QueryZyzlyyDetailReq detailReq = new QueryZyzlyyDetailReq();
        detailReq.setJgid(sysUser.getHospitalId());
        detailReq.setZllb(req.getZllb());
        detailReq.setZxks(sysUser.getDeptId());
        detailReq.setZyh(req.getZyh());
        List<QueryZyzlyyDetailResp> detailResps = zyzlyyDetail(detailReq);
        //对项目进行预约（已经预约过的修改预约时间）
        if (CollUtil.isNotEmpty(detailResps)){
            detailResps.stream().forEach(o ->{
                ZlSqdmx sqdmx = new ZlSqdmx();
                sqdmx.setJlxh(o.getSqdmxid());
                sqdmx.setZt(o.getZt());
                sqdmx.setYysdks(req.getYysdks());
                sqdmx.setYysdjs(req.getYysdjs());
                sqdmx.setLx(o.getLx());
                //1.对于未预约的项目需要更改为预约
                if (TreatmentCode.zlsqdzt.WYY.getCode().equals(o.getZt())) {
                    //修改项目的预约状态和预约时间（通过主键）
                    zlSqdmxDao.updateZtBySqdmxId(sqdmx);
                } else {//2.对于已预约的项目需要修改预约时间
                    zlSqdmxDao.updateyysjBysqdmxId(sqdmx);
                }
            });
        }
    }

    /**
     * 更新发票号码
     *
     * @param jlxh 记录序号
     * @param fphm 发票号码
     */
    public void updateFphm(Integer jlxh, String fphm) {
        ZlSqdzb query = new ZlSqdzb();
        query.setJlxh(jlxh);
        query.setFphm(fphm);
        zlSqdzbDao.updateByEntity(query);
    }
}
