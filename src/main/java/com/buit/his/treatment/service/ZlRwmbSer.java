package com.buit.his.treatment.service;


import cn.hutool.core.collection.CollectionUtil;
import cn.hutool.core.util.StrUtil;
import com.buit.commons.BaseManagerImp;
import com.buit.constans.TableName;
import com.buit.his.treatment.dao.ZlRwmbDao;
import com.buit.his.treatment.enums.ZfpbEnum;
import com.buit.his.treatment.enums.ZlRwZtEnum;
import com.buit.his.treatment.model.CisHzyz;
import com.buit.his.treatment.model.DicSypc;
import com.buit.his.treatment.model.ZlRwfp;
import com.buit.his.treatment.model.ZlRwmb;
import com.buit.his.treatment.request.AppointmentQueryReq;
import com.buit.his.treatment.request.AppointmentReportReq;
import com.buit.his.treatment.request.AppointmentSaveReq;
import com.buit.his.treatment.response.AppointmentPatientResp;
import com.buit.his.treatment.response.AppointmentReportResp;
import com.buit.his.treatment.response.ZlRwmbResp;
import com.buit.utill.RedisFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

/**
 * @author jiangwei
 * @Date 2021-21-22
 */
@Service
public class ZlRwmbSer extends BaseManagerImp<ZlRwmb, Integer> {

    static final Logger logger = LoggerFactory.getLogger(ZlRwmbSer.class);

    @Autowired
    private RedisFactory redisFactory;
    @Autowired
    private ZlRwmbDao zlRwmbDao;

    @Override
    public ZlRwmbDao getEntityMapper() {
        return zlRwmbDao;
    }

    /**
     * 查询住院治疗预约患者列表
     */
    public List<AppointmentPatientResp> queryAppointmentPatientPage(AppointmentQueryReq req) {
        List<AppointmentPatientResp> resps = zlRwmbDao.queryAppointmentPatientPage(req);
        return resps;
    }

    /**
     * 按照频次执行时间创建子任务模板
     *
     * @param rwfp 治疗任务
     * @param hzyz 患者医嘱
     */
    @Transactional(rollbackFor = Exception.class)
    public List<ZlRwmb> split(ZlRwfp rwfp, CisHzyz hzyz, DicSypc sypc) {
        List<ZlRwmb> list = new ArrayList<>();
        String[] zxsjList = sypc.getZxsj().split("-");
        for (String zxsj : zxsjList) {
            ZlRwmb rwmb = new ZlRwmb();
            rwmb.setJlxh(redisFactory.getTableKey(TableName.DB_NAME, TableName.ZL_RWMB));
            rwmb.setZlrwfpid(rwfp.getZlrwfpid());
            rwmb.setZyh(rwfp.getZyh());
            rwmb.setZxsj(zxsj);
            rwmb.setZxgh(rwfp.getZlsdm());
            rwmb.setYyzt(ZlRwZtEnum.NOT.getValue());
            rwmb.setLsyz(hzyz.getLsyz());
            rwmb.setDw(hzyz.getYfdw());
            rwmb.setPc(hzyz.getSypc());
            rwmb.setKzsj(hzyz.getKssj());
            rwmb.setBzxx(hzyz.getBzxx());
            rwmb.setSczxrq(rwfp.getSczxrq());
            rwmb.setZfpb(ZfpbEnum.ABLE.getValue());
            rwmb.setZxzt(ZlRwZtEnum.NOT.getValue());
            list.add(rwmb);
        }
        return list;
    }

    /**
     * 批量插入
     */
    public void batchInsert(List<ZlRwmb> list) {
        zlRwmbDao.batchInsert(list);
    }

    /**
     * 住院号查询所有模板
     *
     * @param zyh    住院号
     * @param zlksdm 治疗科室代码
     * @param zllb   诊疗类别
     * @param zxgh   执行工号
     * @param yyzt   预约状态
     */
    public List<ZlRwmbResp> findList(Integer zyh, Integer zlksdm, Integer zllb, Integer zxgh, Integer yyzt) {
        return zlRwmbDao.findList(zyh, zlksdm, zllb, zxgh, yyzt);
    }

    /**
     * 主键数组查询
     */
    public List<ZlRwmbResp> findListByIds(List<Integer> jlxhList) {
        return zlRwmbDao.findListByIds(jlxhList);
    }

    /**
     * 保存预约时间段
     */
    @Transactional(rollbackFor = Exception.class)
    public void save(String kssj, String jssj, List<ZlRwmbResp> insertList) {
        zlRwmbDao.batchAppoint(kssj, jssj, insertList);
    }

    /**
     * 查询病人在此时段是否已预约了医生
     */
    public boolean isAppointedOthers(AppointmentSaveReq req) {
        List<ZlRwmbResp> list = zlRwmbDao.findList(req.getZyh(), null, null, null, null);
        for (ZlRwmbResp resp : list) {
            //不是同一个医生 && 已预约(未执行)、已开始执行(未停嘱) && 时间段有交叉
            if (!resp.getZxgh().equals(req.getZlsdm()) &&
                    (ZlRwZtEnum.DONE.equals(resp.getYyzt()) || !ZlRwZtEnum.DONE.equals(resp.getZxzt()))
                    && StrUtil.isNotBlank(resp.getKssj()) && StrUtil.isNotBlank(resp.getJssj())
                    && !(resp.getKssj().compareTo(req.getJssj()) >= 0 || resp.getJssj().compareTo(req.getKssj()) <= 0)) {
                return true;
            }
        }
        return false;
    }

    /**
     * 批量执行
     */
    public void batchExecute(List<ZlRwmb> rwmbList) {
        zlRwmbDao.batchExecute(rwmbList);
    }

    /**
     * 预约模板作废
     */
    public void cancelAppoint(Integer jlxh) {
        ZlRwmb old = new ZlRwmb();
        old.setJlxh(jlxh);
        old.setZfpb(ZfpbEnum.DISABLED.getValue());
        zlRwmbDao.updateByEntity(old);
    }

    /**
     * 预约模板作废
     */
    public void cancelAppoint(List<ZlRwmbResp> oldRwmbList) {
        zlRwmbDao.cancelAppoint(oldRwmbList);
    }

    /**
     * 重新预约生成新的任务模板
     *
     * @param update 旧模板
     * @param kssj   开始时间
     * @param jssj   结束时间
     */
    public ZlRwmb reAppoint(ZlRwmbResp update, String kssj, String jssj) {
        ZlRwmb zlRwmb = new ZlRwmb();
        BeanUtils.copyProperties(update, zlRwmb);
        zlRwmb.setJlxh(redisFactory.getTableKey(TableName.DB_NAME, TableName.ZL_RWMB));
        zlRwmb.setKssj(kssj);
        zlRwmb.setJssj(jssj);
        zlRwmb.setZfpb(ZfpbEnum.ABLE.getValue());
        zlRwmbDao.insert(zlRwmb);
        return zlRwmb;
    }

    /**
     * 住院病人治疗预约查询
     */
    public List<AppointmentReportResp> queryAppointmentReportPage(AppointmentReportReq req) {
        return zlRwmbDao.queryAppointmentReportPage(req);
    }

    /**
     * 根据治疗任务查询子任务模板
     *
     * @param rwfpIds 治疗任务
     */
    public List<ZlRwmb> findListByRwfpIds(List<Integer> rwfpIds) {
        return zlRwmbDao.findListByRwfpIds(rwfpIds);
    }

    /**
     * 任务模板批量删除
     */
    public void batchRemove(List<Integer> rwmbIds) {
        zlRwmbDao.batchRemove(rwmbIds);
    }

    /**
     * 批量完成（停嘱）
     *
     * @param rwmbIds 已开始执行的任务模板主键
     */
    public void batchFinish(List<Integer> rwmbIds) {
        zlRwmbDao.batchFinish(rwmbIds);
    }

    /**
     * 取消执行
     */
    public void cancelExecute(List<Integer> rwmbIds) {
        zlRwmbDao.cancelExecute(rwmbIds);
    }

    /**
     * 查询正在使用的任务模板
     *
     * @param zlrwfpid 治疗任务分配id
     * @param zxsj     执行时间点（24小时制）
     */
    public ZlRwmb getByRwfpAndZxsj(Integer zlrwfpid, String zxsj) {
        ZlRwmb query = new ZlRwmb();
        query.setZlrwfpid(zlrwfpid);
        query.setZxsj(zxsj);
        query.setZfpb(ZfpbEnum.ABLE.getValue());
        List<ZlRwmb> list = zlRwmbDao.findByEntity(query);
        if (CollectionUtil.isNotEmpty(list)) {
            return list.get(0);
        }
        return null;
    }

    /**
     * 查询正在使用的任务模板
     *
     * @param zlrwfpid 治疗任务分配id
     * @param zxsjList 执行时间点（24小时制）
     */
    public List<ZlRwmb> findListByRwfpAndZxsj(Integer zlrwfpid, List<String> zxsjList) {
        return zlRwmbDao.findListByRwfpAndZxsj(zlrwfpid, zxsjList);
    }
}
