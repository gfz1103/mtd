package com.buit.his.treatment.preService;

import cn.hutool.core.collection.CollectionUtil;
import cn.hutool.core.util.StrUtil;
import com.buit.aop.lock.Locked;
import com.buit.cis.im.response.ImHzryResp;
import com.buit.cis.im.service.ImHzryService;
import com.buit.cis.im.service.ImZyjsService;
import com.buit.commons.BaseException;
import com.buit.constans.SysXtcsCsmcCts;
import com.buit.constans.TableName;
import com.buit.his.sams.model.ImFeeFymx;
import com.buit.his.treatment.enums.PrescriptionTypeEnum;
import com.buit.his.treatment.enums.SexEnum;
import com.buit.his.treatment.enums.ZlRwZtEnum;
import com.buit.his.treatment.model.*;
import com.buit.his.treatment.request.ExecuteSaveReq;
import com.buit.his.treatment.request.ZlZlpcReq;
import com.buit.his.treatment.request.ZlZlzrwReq;
import com.buit.his.treatment.request.ZljlFormReq;
import com.buit.his.treatment.response.*;
import com.buit.his.treatment.service.*;
import com.buit.system.model.DicKszd;
import com.buit.system.response.DicJbbmModel;
import com.buit.system.service.DicJbbmService;
import com.buit.system.service.DicKszdOutSer;
import com.buit.system.service.SysXtcsCacheSer;
import com.buit.utill.BUHISUtil;
import com.buit.utill.DateUtils;
import com.buit.utill.MtdmsUtil;
import com.buit.utill.RedisFactory;
import org.apache.dubbo.config.annotation.DubboReference;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.sql.Timestamp;
import java.util.*;
import java.util.stream.Collectors;

/**
 * @author 蒋威
 * @Description 住院治疗执行预处理类
 * @Date 2021-03-26
 */
@Service
public class ExecutePreService {

    @Autowired
    private ZlZljlSer zljlSer;
    @Autowired
    private ZlZlpcSer zlpcSer;
    @Autowired
    private ZlZlzrwSer zlZlzrwSer;
    @Autowired
    private ZlRwmbSer zlRwmbSer;
    @Autowired
    private ZlRwfpSer zlRwfpSer;
    @Autowired
    private DicSypcSer dicSypcSer;
    @Autowired
    private ImFeeFymxSer imFeeFymxSer;
    @Autowired
    private RedisFactory redisFactory;
    @DubboReference
    private ImZyjsService imZyjsService;
    @DubboReference
    private DicKszdOutSer dicKszdOutSer;
    @DubboReference
    private DicJbbmService dicJbbmService;
    @Autowired
    private CisHzyzSer cisHzyzSer;
    @Autowired
    private AppointmentPreService appointmentPreService;
    @DubboReference
    private SysXtcsCacheSer sysXtcsCacheSer;
    @DubboReference
    private ImHzryService imHzryService;

    /**
     * 搜集需要执行的数据
     *
     * @param req
     */
    @Transactional(rollbackFor = Exception.class)
    @Locked(value = {"saveTreatmentTask_#[req.*zrwList.zlrwfpId]", "saveAccountMoney_#[req.*zrwList.zyh]", "repeatExecute_#[req.*zrwList.jlxh]"})
    public void save(ExecuteSaveReq req) {
        List<ZlZlzrwReq> list = req.getZrwList();
        if (CollectionUtil.isEmpty(list)) {
            throw BaseException.create("ERROR_ZL_00027");
        }

        if (req.getZxrq().compareTo(DateUtils.getTomorrow()) > 0) {
            throw BaseException.create("ERROR_ZL_00040");
        }
        List<Integer> zrwIdList = list.stream().map(ZlZlzrwReq::getJlxh).collect(Collectors.toList());
        lockAndSave(req, zrwIdList);
    }

    /**
     * 锁定并执行
     */
    @Transactional(rollbackFor = Exception.class)
    public void lockAndSave(ExecuteSaveReq req, List<Integer> zrwIdList) {
        List<ZlZlzrw> zrwList = zlZlzrwSer.findListByIds(zrwIdList, ZlRwZtEnum.NOT.getValue());
        if (CollectionUtil.isEmpty(zrwList)) {
            throw BaseException.create("ERROR_ZL_00031");
        }
        //执行状态检查
        for (ZlZlzrw zrw : zrwList) {
            if (ZlRwZtEnum.DONE.equals(zrw.getZxzt())) {
                throw BaseException.create("ERROR_ZL_00031");
            }
        }
        Map<Integer, List<ZlZlzrw>> map = zrwList.stream().collect(Collectors.groupingBy(ZlZlzrw::getZlrwfpid));
        for (Map.Entry<Integer, List<ZlZlzrw>> e : map.entrySet()) {
            save(e.getKey(), e.getValue(), req.getZlsdm(), req.getZxrq(), req.getZllb(), req.getJgid());
        }
    }

    /**
     * 单个任务执行
     */
    @Transactional(rollbackFor = Exception.class)
    public void save(Integer zlrwfpId, List<ZlZlzrw> list, Integer zlsdm, String zxrq, Integer zllb, Integer jgid) {
        //是否为历史任务
        boolean isHistory = zxrq.compareTo(DateUtils.getToday()) < 0;
        //治疗任务
        ZlRwfp rwfp = zlRwfpSer.getById(zlrwfpId);
        CisHzyz cisHzyz = cisHzyzSer.getById(rwfp.getYzJlxh());
        if (cisHzyz == null) {
            throw BaseException.create("ERROR_ZL_00032");
        }
        //2021-05-24 已改为定时任务，无需做提前执行判断
        //可执行的最大日期
//        String limit = sysXtcsCacheSer.getCsz(jgid, SysXtcsCsmcCts.TREATMENT_EXECUTE_DAYS_LIMIT);
//        String maxDate = null;
//        if (cisHzyz.getTzsj() != null) {
//            maxDate = DateUtils.dateAdd(DateUtils.formatToDate(cisHzyz.getTzsj()), Integer.parseInt(limit));
//        }

        //更改任务为开始执行状态
        zlRwfpSer.execute(zlrwfpId);

        //如果是执行历史任务
        if (isHistory) {
            //重新生成历史治疗记录
            zljlSer.reCreate(rwfp.getZyh(), zxrq, zlsdm, zllb);
        } else {
            //创建治疗记录
            zljlSer.create(rwfp.getZyh(), zxrq, zlsdm, zllb);
        }
        //正在使用的子任务模板
        List<String> zxsjList = list.stream().map(r -> DateUtils.formatToHour(r.getZxsj())).collect(Collectors.toList());
        List<ZlRwmb> rwmbList = zlRwmbSer.findListByRwfpAndZxsj(zlrwfpId, zxsjList);
//        List<ZlRwmbResp> resps = rwmbList.stream().map(r -> new ZlRwmbResp(r, rwfp.getZlksdm())).collect(Collectors.toList());
        //更改模板为开始执行状态
        zlRwmbSer.batchExecute(rwmbList);

        List<Integer> finishRwmbIds = new ArrayList<>();
//        String tomorrow = DateUtils.getTomorrow(zxrq);

//        for (ZlRwmbResp resp : resps) {
//            if (PrescriptionTypeEnum.TEMPORARY.equals(resp.getLsyz())) {
//                //临时医嘱
//                finishRwmbIds.add(resp.getJlxh());
//            } else if (PrescriptionTypeEnum.LONG_TERM.equals(resp.getLsyz())) {
//                //长期医嘱
//                DicSypc sypc = dicSypcSer.getById(resp.getPc());
//                String nextDate = null;
//                if (sypc.getZxzq() == 1) {//每天执行
//                    nextDate = tomorrow;
//                } else if (sypc.getRlz() == 1) {//日历周
//                    nextDate = MtdmsUtil.getNextExecuteDateByWeek(sypc.getRzxzq(), tomorrow);
//                } else {//非日历周且非每天执行
//                    nextDate = MtdmsUtil.getNextExecuteDateByDays(sypc.getZxzq(), sypc.getRzxzq(), zxrq);
//                }
//                if (cisHzyz.getTzsj() != null && nextDate.compareTo(maxDate) > 0) {
//                    throw BaseException.create("ERROR_ZL_00047");
//                }
//
//                //生成下一次的批次和子任务
//                ZlZlpc zlpc = zlpcSer.create(resp, nextDate, resp.getKssj(), resp.getJssj());
//                zlZlzrwSer.create(zlpc.getJlxh(), resp, nextDate, 0);
//            }
//        }
        //临时医嘱
        if (CollectionUtil.isNotEmpty(finishRwmbIds)) {
            zlRwmbSer.batchFinish(finishRwmbIds);
        }

        //生成住院费用
        ImFeeFymx rwfpFymx = imFeeFymxSer.createZlRwfpFymx(zlrwfpId);
        //插入费用明细
        List<ImFeeFymx> fymxList = new ArrayList<>(list.size());
        Timestamp jssj = imZyjsService.getLastZyjsSj(rwfp.getZyh());
        Timestamp now = DateUtils.getNow();
        for (ZlZlzrw zrw : list) {
            //判断费用时间是否在病人的最后一次结算时间之前
            if (zrw.getZxsj().before(jssj) || zrw.getZxsj().equals(jssj)) {
                throw BaseException.create("ERROR_ZL_00033");
            }
            zrw.setFysj(zrw.getZxsj());
            zrw.setJzsj(now);

            // ********** 把从map获取到的对象直接赋值后添加进数组里会有多引用问题！即数组里多个元素都指向同一个对象
            ImFeeFymx fymx = new ImFeeFymx();
            BeanUtils.copyProperties(rwfpFymx, fymx);
            fymx.setJlxh(redisFactory.getTableKey(TableName.DB_NAME, TableName.IM_FEE_FYMX));
            fymx.setFyrq(zrw.getFysj());
            fymx.setJfrq(zrw.getJzsj());
            fymx.setQrgh(String.valueOf(zlsdm));//确认医生为操作员工号
            //计算补给帐的次数和金额
            fymx.setFysl(fymx.getFysl().multiply(new BigDecimal(zrw.getBjzcs() + 1)));
            fymx.setZjje(fymx.getZjje().multiply(new BigDecimal(zrw.getBjzcs() + 1)));
            fymx.setZfje(fymx.getZfje().multiply(new BigDecimal(zrw.getBjzcs() + 1)));
            fymxList.add(fymx);
        }
        //批量修改执行状态
        zlZlzrwSer.batchExecute(list, zlsdm);
        imFeeFymxSer.batchInsert(fymxList);
    }

    /**
     * 取消执行
     */
    @Transactional(rollbackFor = Exception.class)
    @Locked(value = {"saveTreatmentTask_#[req.*zrwList.zlrwfpId]", "saveAccountMoney_#[req.*zrwList.zyh]", "repeatExecute_#[req.*zrwList.jlxh]"})
    public void cancel(ExecuteSaveReq req) {
        List<ZlZlzrwReq> list = req.getZrwList();
        if (CollectionUtil.isEmpty(list)) {
            throw BaseException.create("ERROR_ZL_00027");
        }
        List<Integer> zrwIdList = list.stream().map(ZlZlzrwReq::getJlxh).collect(Collectors.toList());
        lockAndCancel(req, zrwIdList);
    }

    /**
     * 锁定并取消执行
     */
    @Transactional(rollbackFor = Exception.class)
    public void lockAndCancel(ExecuteSaveReq req, List<Integer> zrwIdList) {
        List<ZlZlzrw> zrwList = zlZlzrwSer.findListByIds(zrwIdList, ZlRwZtEnum.DONE.getValue());
        if (CollectionUtil.isEmpty(zrwList)) {
            throw BaseException.create("ERROR_ZL_00031");
        }
        //执行状态检查
        for (ZlZlzrw zrw : zrwList) {
            if (ZlRwZtEnum.NOT.equals(zrw.getZxzt())) {
                throw BaseException.create("ERROR_ZL_00031");
            }
        }
        Map<Integer, List<ZlZlzrw>> map = zrwList.stream().collect(Collectors.groupingBy(ZlZlzrw::getZlrwfpid));
        for (Map.Entry<Integer, List<ZlZlzrw>> e : map.entrySet()) {
            cancel(e.getKey(), e.getValue(), req.getZlsdm(), req.getZxrq(), req.getZllb());
        }
    }

    /**
     * 单个取消执行
     */
    @Transactional(rollbackFor = Exception.class)
    public void cancel(Integer zlrwfpId, List<ZlZlzrw> list, Integer zlsdm, String zxrq, Integer zllb) {
        //治疗任务
        ZlRwfp rwfp = zlRwfpSer.getById(zlrwfpId);
        /*ZlZljl zljl = zljlSer.getById(jlxh);
        if (1 == zljl.getZt()) {
            throw BaseException.create("ERROR_ZL_00031");
        }
        zljlSer.cancel(jlxh, userId, qxyy);*/

//        List<ZlZlpc> pcList = zlpcSer.findByZljl(zljl);
//        List<ZlZlpcResp> zlpcResps = new ArrayList<>(pcList.size());
//        for (ZlZlpc pc : pcList) {
//            ZlZlpcResp entry = new ZlZlpcResp();
//            BeanUtils.copyProperties(pc, entry);
//            zlpcResps.add(entry);
//        }
//        List<ZlZlzrw> list = zlZlzrwSer.getExecutedByZlpc(pcList.stream().map(ZlZlpc::getJlxh).collect(Collectors.toList()));
        Set<Integer> rwmbIds = list.stream().map(ZlZlzrw::getRwmbJlxh).collect(Collectors.toSet());

        zlZlzrwSer.cancel(list, zlsdm);
        zlRwmbSer.cancelExecute(new ArrayList<>(rwmbIds));
        zlRwfpSer.cancel(zlrwfpId);
        Timestamp now = DateUtils.getNow();
        //生成住院费用
        ImFeeFymx rwfpFymx = imFeeFymxSer.createZlRwfpFymx(zlrwfpId);
        //插入费用明细
        List<ImFeeFymx> fymxList = new ArrayList<>(list.size());
        Timestamp jssj = imZyjsService.getLastZyjsSj(rwfp.getZyh());
        for (ZlZlzrw zrw : list) {
            // ********** 把从map获取到的对象直接赋值后添加进数组里会有多引用问题！即数组里多个元素都指向同一个对象
            ImFeeFymx fymx = new ImFeeFymx();
            BeanUtils.copyProperties(rwfpFymx, fymx);
            fymx.setJlxh(redisFactory.getTableKey(TableName.DB_NAME, TableName.IM_FEE_FYMX));

            fymx.setFyrq(zrw.getZxsj());
            fymx.setJfrq(now);
            //判断费用时间是否在病人的最后一次结算时间之前
            if (zrw.getZxsj().before(jssj) || zrw.getZxsj().equals(jssj)) {
                throw BaseException.create("ERROR_ZL_00033");
            }
            fymx.setQrgh(String.valueOf(zlsdm));//确认医生为操作员工号
            //补记账次数弥补
            fymx.setFysl(fymx.getFysl().multiply(new BigDecimal(zrw.getBjzcs() + 1)).negate());//数量改为负数
            fymx.setZjje(fymx.getZjje().multiply(new BigDecimal(zrw.getBjzcs() + 1)).negate());//总计金额改为负数
            fymx.setZfje(fymx.getZfje().multiply(new BigDecimal(zrw.getBjzcs() + 1)).negate());//自负金额改为负数
            fymxList.add(fymx);
        }
        imFeeFymxSer.batchInsert(fymxList);
    }

    /**
     * 缺诊
     *
     * @param req
     */
    @Transactional(rollbackFor = Exception.class)
    @Locked(value = {"repeatExecute_#[req.*zrwList.jlxh]"})
    public void absence(ExecuteSaveReq req) {
/*        if (req.getZxrq().compareTo(DateUtils.getToday()) < 0) {
            throw BaseException.create("ERRPR_ZL_00036");
        }*/
        List<ZlZlzrwReq> list = req.getZrwList();
        if (CollectionUtil.isEmpty(list)) {
            throw BaseException.create("ERROR_ZL_00027");
        }
        List<Integer> zrwIdList = list.stream().map(ZlZlzrwReq::getJlxh).distinct().collect(Collectors.toList());
        lockAndAbsence(req, zrwIdList);
    }

    /**
     * 锁定并缺诊 | 对需要补记账的子任务缺诊，补记的费用会丢失）
     */
    @Transactional(rollbackFor = Exception.class)
    public void lockAndAbsence(ExecuteSaveReq req, List<Integer> zrwIdList) {
        List<ZlZlzrw> zrwList = zlZlzrwSer.findListByIds(zrwIdList);
        if (CollectionUtil.isEmpty(zrwList)) {
            throw BaseException.create("ERROR_ZL_00031");
        }

        String tomorrow = DateUtils.getTomorrow(req.getZxrq());
        for (ZlZlzrw zlzrw : zrwList) {
            ZlRwfp rwfp = zlRwfpSer.getById(zlzrw.getZlrwfpid());
            ZlRwmb rwmb = zlRwmbSer.getByRwfpAndZxsj(zlzrw.getZlrwfpid(), DateUtils.formatToHour(zlzrw.getZxsj()));
            ZlRwmbResp resp = new ZlRwmbResp(rwmb, rwfp.getZlksdm());

            if (PrescriptionTypeEnum.TEMPORARY.equals(resp.getLsyz())) {
                throw BaseException.create("ERROR_ZL_00049");
            }
            DicSypc sypc = dicSypcSer.getById(resp.getPc());
            String nextDate = null;
            if (sypc.getZxzq() == 1) {//每天执行
                nextDate = tomorrow;
            } else if (sypc.getRlz() == 1) {//日历周
                nextDate = MtdmsUtil.getNextExecuteDateByWeek(sypc.getRzxzq(), tomorrow);
            } else {//非日历周且非每天执行
                nextDate = MtdmsUtil.getNextExecuteDateByDays(sypc.getZxzq(), sypc.getRzxzq(), req.getZxrq());
            }


            CisHzyz cisHzyz = cisHzyzSer.getById(rwfp.getYzJlxh());
            if (cisHzyz == null) {
                throw BaseException.create("ERROR_ZL_00032");
            }
            String limit = sysXtcsCacheSer.getCsz(req.getJgid(), SysXtcsCsmcCts.TREATMENT_EXECUTE_DAYS_LIMIT);
            //可操作的最大日期
            String maxDate = null;
            if (cisHzyz.getTzsj() != null) {
                maxDate = DateUtils.dateAdd(DateUtils.formatToDate(cisHzyz.getTzsj()), Integer.parseInt(limit));
                if (nextDate.compareTo(maxDate) > 0) {
                    throw BaseException.create("ERROR_ZL_00047");
                }
            }

            //生成下一次的批次和子任务
            ZlZlpc zlpc = zlpcSer.create(resp, nextDate, resp.getKssj(), resp.getJssj());
            zlZlzrwSer.create(zlpc.getJlxh(), resp, nextDate);
        }
    }

    /**
     * 获取当天的治疗记录
     *
     * @param zyh
     * @param zxrq
     * @return
     */
/*    public ZljlFormResp getZljl(Integer zlsdm, Integer zyh, Integer zllb, String zxrq) {
        ZljlFormResp result = new ZljlFormResp();
        //当天的治疗记录
        ZlZljl zljl = zljlSer.getZlzljl(zlsdm, zyh, zllb, zxrq);
        if (zljl == null) {
            throw BaseException.create("ERROR_ZL_00026");
        }
        //已执行的批次
        List<ZlZlpc> zlpcList = zlpcSer.findByZljl(zljl);
        BeanUtils.copyProperties(zljl, result);
        List<ZlZlpcResp> zlpcResps = new ArrayList<>(zlpcList.size());
        for (ZlZlpc pc : zlpcList) {
            ZlZlpcResp entry = new ZlZlpcResp();
            BeanUtils.copyProperties(pc, entry);
            zlpcResps.add(entry);
        }
        result.setZlpcList(zlpcResps);
        return result;
    }*/

    /**
     * 获取所有的治疗记录
     */
    public List<ZljlFormResp> findList(ZlZljl query) {
        //治疗记录
        List<ZlZljl> zljlList = zljlSer.findByEntity(query);
        if (CollectionUtil.isEmpty(zljlList)) {
            return null;
        }
        List<ZljlFormResp> results = new ArrayList<>(zljlList.size());
        for (ZlZljl zljl : zljlList) {
            ZljlFormResp entity = new ZljlFormResp();
            BeanUtils.copyProperties(zljl, entity);

            List<ZlZlpc> zlZlpcList = zlpcSer.findByZljl(zljl);
            List<ZlZlpcResp> zlpcResps = zlZlpcList.stream().map(r -> {
                ZlZlpcResp resp = new ZlZlpcResp();
                BeanUtils.copyProperties(r, resp);
                return resp;
            }).collect(Collectors.toList());

            entity.setZlpcList(zlpcResps);

            results.add(entity);
        }

        return results;
    }

    /**
     * 患者入院信息字段处理
     *
     * @param resp
     * @return
     */
    public ExecuteLogPatientResp preHandler(ImHzryResp resp) {
        ExecuteLogPatientResp result = new ExecuteLogPatientResp();
        result.setZyhm(resp.getZyhm());
        result.setBrxm(resp.getBrxm());
        result.setBrch(resp.getBrch());
        result.setBrxb(SexEnum.getText(resp.getBrxb()));
        result.setCsrq(DateUtils.formatToDate(resp.getCsny()));
        result.setAge(BUHISUtil.getPersonAgeStr(resp.getCsny()));

        DicKszd brks = dicKszdOutSer.getById(resp.getBrks());
        DicKszd brbq = dicKszdOutSer.getById(resp.getBrbq());
        result.setBrks(brks.getOfficename());
        result.setBrbq(brbq.getOfficename());

        //获取入院诊断
        DicJbbmModel dicJbbmParam = new DicJbbmModel();
        dicJbbmParam.setIcd10(resp.getRyzd());
        dicJbbmParam.setZfbz(0);
        List<DicJbbmModel> dicJbbmList = dicJbbmService.queryList(dicJbbmParam);
        DicJbbmModel dicJbbm = dicJbbmList.get(0);

        result.setRyzd(dicJbbm.getJbmc());
        return result;
    }

    /**
     * 修改治疗记录
     *
     * @param req
     */
    @Transactional(rollbackFor = Exception.class)
    public void edit(ZljlFormReq req) {
        ZlZljl zljl = new ZlZljl();
        BeanUtils.copyProperties(req, zljl);
        if (StrUtil.isNotBlank(zljl.getJdxj())) {
            zljl.setScxjcs(zljl.getMqzxcs());
        }
        zljlSer.updateByEntity(zljl);
        List<ZlZlpcReq> zlpcList = req.getZlpcList();
        for (ZlZlpcReq zlpcReq : zlpcList) {
            ZlZlpc pc = new ZlZlpc();
            BeanUtils.copyProperties(zlpcReq, pc);
            zlpcSer.updateByEntity(pc);
        }
    }

    /**
     * 删除
     */
    @Transactional(rollbackFor = Exception.class)
    @Locked(value = {"repeatExecute_#[*jlxhList]"})
    public void delete(List<Integer> jlxhList) {
        List<ZlZlzrw> zlzrwList = zlZlzrwSer.findListByIds(jlxhList);
        if (CollectionUtil.isEmpty(zlzrwList)) {
            throw BaseException.create("ERROR_ZL_00031");
        }
        for (ZlZlzrw zrw : zlzrwList) {
            if (ZlRwZtEnum.DONE.equals(zrw.getZxzt())) {
                throw BaseException.create("ERROR_ZL_00029");
            }
            zlZlzrwSer.deleteById(zrw.getJlxh());
        }
    }

    /**
     * 拆分
     */
    @Transactional(rollbackFor = Exception.class)
    @Locked(value = {"repeatExecute_#[jlxh]"})
    public void split(Integer jlxh) {
        ZlZlzrw zrw = zlZlzrwSer.getById(jlxh);
        Integer bjzcs = zrw.getBjzcs();
        if (bjzcs == null || bjzcs == 0) {
            throw BaseException.create("ERROR_ZL_00030");
        }
        if (ZlRwZtEnum.DONE.equals(zrw.getZxzt())) {
            throw BaseException.create("ERROR_ZL_00041");
        }
        List<ZlRwmbResp> zlRwmbResps = zlRwmbSer.findListByIds(Arrays.asList(new Integer[]{zrw.getRwmbJlxh()}));
        if (CollectionUtil.isNotEmpty(zlRwmbResps)) {
            ZlRwmbResp resp = zlRwmbResps.get(0);
            DicSypc sypc = dicSypcSer.getById(resp.getPc());
            String lastDate = null;
            String today = DateUtils.formatToDate(zrw.getZxsj());
            String yesterday = DateUtils.dateAdd(today, -1);

            for (; bjzcs > 0; bjzcs--) {
                if (sypc.getZxzq() == 1) {//每天执行
                    lastDate = yesterday;
                } else if (sypc.getRlz() == 1) {//日历周
                    lastDate = MtdmsUtil.getLastExecuteDateByWeek(sypc.getRzxzq(), yesterday);
                } else {//非日历周且非每天执行
                    lastDate = MtdmsUtil.getLastExecuteDateByDays(sypc.getZxzq(), sypc.getRzxzq(), today);
                }
                //生成批次和子任务
                ZlZlpc zlpc = zlpcSer.create(resp, lastDate, resp.getKssj(), resp.getJssj());
                zlZlzrwSer.create(zlpc.getJlxh(), resp, lastDate);
                today = lastDate;
                yesterday = DateUtils.dateAdd(today, -1);
            }
        }
        zlZlzrwSer.updateBjzcs(zrw.getJlxh());

    }

    /**
     * 出院证检查 - 未确费列表
     *
     * @param zyh 住院号
     */
    public List<ZlrwCheckFailedResp> dischargeCheckList(Integer zyh) {
        return zlZlzrwSer.dischargeCheckList(zyh);
    }
}