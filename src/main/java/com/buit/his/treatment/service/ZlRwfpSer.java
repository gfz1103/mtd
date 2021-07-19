package com.buit.his.treatment.service;


import cn.hutool.core.collection.CollectionUtil;
import cn.hutool.core.date.DateUtil;
import com.buit.aop.lock.Locked;
import com.buit.cis.im.response.ImRyzdModel;
import com.buit.cis.im.service.ImRyzdService;
import com.buit.commons.BaseManagerImp;
import com.buit.constans.SysXtcsCsmcCts;
import com.buit.constans.TableName;
import com.buit.his.treatment.ResultsUtil;
import com.buit.his.treatment.dao.ZlRwfpDao;
import com.buit.his.treatment.dao.ZlXmDao;
import com.buit.his.treatment.enums.CypbEnum;
import com.buit.his.treatment.enums.RyzdEnum;
import com.buit.his.treatment.enums.ZlRwZtEnum;
import com.buit.his.treatment.model.*;
import com.buit.his.treatment.request.*;
import com.buit.his.treatment.response.HistoryAdviceResp;
import com.buit.his.treatment.response.HistoryPatientResp;
import com.buit.his.treatment.response.ZlRwfpPatientResp;
import com.buit.his.treatment.response.ZlRwfpResp;
import com.buit.system.model.DicKszd;
import com.buit.system.response.HrPersonnelModel;
import com.buit.system.service.DicKszdOutSer;
import com.buit.system.service.HrPersonnelService;
import com.buit.system.service.SysXtcsCacheSer;
import com.buit.utill.DateUtils;
import com.buit.utill.RedisFactory;
import org.apache.dubbo.config.annotation.DubboReference;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

/**
 * 康复治疗任务分配表<br>
 *
 * @author 韦靖
 */
@Service
public class ZlRwfpSer extends BaseManagerImp<ZlRwfp, Integer> {

    static final Logger logger = LoggerFactory.getLogger(ZlRwfpSer.class);

    @Autowired
    private ZlRwfpDao zlRwfpDao;
    @Autowired
    private ZlXmDao zlXmDao;

    @Autowired
    public RedisFactory redisFactory;

    @DubboReference
    private ImRyzdService imRyzdService;

    @Autowired
    private ZlRwmbSer zlRwmbSer;
    @Autowired
    private ZlZlzrwSer zlZlzrwSer;
    @DubboReference
    private DicKszdOutSer kszdOutSer;
    @DubboReference
    private HrPersonnelService hrPersonnelService;
    @Autowired
    private CisHzyzSer cisHzyzSer;
    @DubboReference
    private SysXtcsCacheSer sysXtcsCacheSer;

    @Override
    public ZlRwfpDao getEntityMapper() {
        return zlRwfpDao;
    }

    /**
     * 查询住院任务分配患者列表
     */
    public List<ZlRwfpPatientResp> queryRwfpPatientPage(ZlRwfpPatientQueryReq req) {
        List<ZlRwfpPatientResp> resps = zlRwfpDao.queryRwfpPatientPage(req);
        for (ZlRwfpPatientResp resp : resps) {
            resp.setCypb(CypbEnum.isDischarge(resp.getCypb()) ? 2 : 1);
            List<ImRyzdModel> ryzdList = imRyzdService.findList(resp.getZyh(), RyzdEnum.ADMITTING_MAIN_DIAGNOSIS.getValue());
            if (CollectionUtil.isNotEmpty(ryzdList)) {
                resp.setRyzd(ryzdList.get(0).getZdmc());
            }
        }
        return resps;
    }

    /**
     * 查询住院患者康复治疗任务分配情况
     */
    public List<ZlRwfpResp> queryRwfp(ZlRwfpQueryReq req) {
        return zlRwfpDao.queryRwfp(req);
    }

    /**
     * 任务分配分配状态
     *
     * @param rwfp   被分配的任务
     * @param sczxrq 首次执行日期
     * @param xczxrq 下次执行日期
     */
    public ZlRwfp rwfp(ZlRwfp rwfp, String sczxrq, String xczxrq) {
        rwfp.setFpsj(DateUtils.getNow());
        rwfp.setFpzt(ZlRwZtEnum.DONE.getValue());
        rwfp.setSczxrq(sczxrq);
        rwfp.setXczxrq(xczxrq);
        zlRwfpDao.rwfp(rwfp);
        return rwfp;
    }

    /**
     * 任务重新分配
     *
     * @param rwfp 被分配的任务
     */
    public ZlRwfp rwfp(ZlRwfp rwfp) {
        rwfp.setFpsj(DateUtils.getNow());
        rwfp.setFpzt(ZlRwZtEnum.DONE.getValue());
        zlRwfpDao.rwfp(rwfp);
        return rwfp;
    }

    @Transactional(rollbackFor = Exception.class)
    @Locked(value = {"saveTreatmentTask_#[req.zlrwfpid]"})
    public void edit(ZlRwlbEditReq req) {
        zlRwfpDao.edit(req);
    }

    public void batchInsert(List<ZlRwfpUpdateReq> yzList) {
        List<ZlRwfp> list = new ArrayList<>(yzList.size());
        for (ZlRwfpUpdateReq updateReq : yzList) {
            ZlRwfp entry = new ZlRwfp();
            BeanUtils.copyProperties(updateReq, entry);
            entry.setZlrwfpid(redisFactory.getTableKey(TableName.DB_NAME, TableName.ZL_RWFP));
            entry.setSfxmdm(String.valueOf(updateReq.getSfxmdm()));
            entry.setFpzt(ZlRwZtEnum.NOT.getValue());
            entry.setZxzt(ZlRwZtEnum.NOT.getValue());
            //查询收费项目所属套餐的诊疗类别(只取第一个)
            ZlXm zlxm = zlXmDao.getBySfxmdm(entry.getSfxmdm(), entry.getJgid());
            if (zlxm != null) {
                entry.setZllb(zlxm.getZllb());
            }
            list.add(entry);
        }
        zlRwfpDao.batchInsert(list);
    }

    /**
     * 根据医嘱记录序号删除康复治疗任务
     *
     * @param yzJlxhList 医嘱记录序号集合
     */
    public void batchRemove(List<Integer> yzJlxhList) {
        zlRwfpDao.batchRemove(yzJlxhList);
    }

    /**
     * 根据医嘱查询任务
     *
     * @param yzjlxhList 医嘱记录序号
     */
    public List<ZlRwfp> findByYzjlxhList(List<Integer> yzjlxhList) {
        return zlRwfpDao.findByYzjlxhList(yzjlxhList);
    }

    /**
     * 根据医嘱查询任务
     *
     * @param yzJlxh 医嘱记录序号
     */
    public ZlRwfp findByYzjlxh(Integer yzJlxh) {
        ZlRwfp query = new ZlRwfp();
        query.setYzJlxh(yzJlxh);
        List<ZlRwfp> list = zlRwfpDao.findByEntity(query);
        if (CollectionUtil.isNotEmpty(list)) {
            return list.get(0);
        }
        return null;
    }

    /**
     * 查询已经开始执行的治疗任务
     *
     * @param zyh 住院号
     */
    public List<ZlRwfp> findStartExecutedList(Integer zyh) {
        return zlRwfpDao.findStartExecutedList(zyh);
    }

    /**
     * 主键查询
     *
     * @param rwfpIds 任务分配id
     */
    public List<ZlRwfp> findListByIds(List<Integer> rwfpIds) {
        return zlRwfpDao.findListByIds(rwfpIds);
    }

    /**
     * 执行
     */
    public void execute(Integer zlrwfpId) {
        zlRwfpDao.execute(zlrwfpId);
    }

    /**
     * 取消执行
     *
     * @param zlrwfpId 任务分配id
     */
    public void cancel(Integer zlrwfpId) {
        zlRwfpDao.cancel(zlrwfpId);
    }

    /**
     * 锁定并完成任务
     *
     * @param rwfp 被停嘱的治疗任务(长期)
     */
    @Transactional(rollbackFor = Exception.class)
    @Locked(value = {"saveTreatmentTask_#[rwfp.zlrwfpid]"})
    public ResultsUtil lockAndFinish(ZlRwfp rwfp, ZlHzyz cisHzyz, Integer jgid) {
        String limit = sysXtcsCacheSer.getCsz(jgid, SysXtcsCsmcCts.TREATMENT_EXECUTE_DAYS_LIMIT);
        //可操作的最大日期
        //停嘱时间第二天之后的子任务
        String maxDate = DateUtils.formatToDate(DateUtils.dateAdd(cisHzyz.getTzsj(), Integer.parseInt(limit)));
        List<ZlZlzrw> checkList = zlZlzrwSer.findListOutRange(rwfp.getZlrwfpid(), DateUtils.getDailyEndTime(maxDate));

        if (CollectionUtil.isNotEmpty(checkList)) {
            boolean isSuccess = true;
            List<String> zxsjList = new ArrayList<>();

            for (ZlZlzrw zlzrw : checkList) {
                if (ZlRwZtEnum.DONE.equals(zlzrw.getZxzt())) {
                    zxsjList.add(DateUtils.formatToDateTime(zlzrw.getZxsj()));
                    isSuccess = false;
                }
            }

            if (isSuccess) {
                zlZlzrwSer.batchRemove(checkList);
            } else {
                StringBuilder message = new StringBuilder("{治疗项目[" + rwfp.getSfxmmc() + ":");
                message.append(CollectionUtil.join(zxsjList, ","));
                message.append("]已确费，无法停嘱！}");
                return ResultsUtil.fail(message.toString());
            }
        }
        return ResultsUtil.ok();
    }


    /**
     * 锁定并检查患者费用
     *
     * @param zyh 住院号
     */
    public ResultsUtil lockAndCheck(Integer zyh) {
        List<ZlRwfp> rwfpList = findListByZyh(zyh);
        if (CollectionUtil.isNotEmpty(rwfpList)) {
            ResultsUtil result = lockAndCheck(rwfpList);
            if (!result.isOk()) {
                return result;
            }
        }
        return ResultsUtil.ok();
    }

    /**
     * 锁定并检查
     *
     * @param rwfpList
     */
    private ResultsUtil lockAndCheck(List<ZlRwfp> rwfpList) {
        if (CollectionUtil.isNotEmpty(rwfpList)) {
            boolean isSuccess = true;
            String message = "";
            for (ZlRwfp rwfp : rwfpList) {
                List<ZlZlzrw> list = zlZlzrwSer.findListByRwfpId(rwfp.getZlrwfpid());
                for (ZlZlzrw zlzrw : list) {
                    if (ZlRwZtEnum.NOT.equals(zlzrw.getZxzt())) {
                        DicKszd kszd = kszdOutSer.getById(rwfp.getZlksdm());
                        HrPersonnelModel hr = hrPersonnelService.getPersonnelById(rwfp.getZlsdm());
                        isSuccess = false;
                        message += "康复治疗项目（长期）：[" + DateUtils.formatToDate(zlzrw.getZxsj()) + "]:" +
                                rwfp.getSfxmmc() + " 未执行(确费),【治疗科室:" + kszd.getOfficename() + ",治疗师：" + hr.getPersonname() + "】\n";
                    }
                }
            }
            if (!isSuccess) {
                return ResultsUtil.fail(message);
            }
        }
        return ResultsUtil.ok();
    }

    /**
     * 通过住院号查询任务
     *
     * @param zyh 住院号
     */
    private List<ZlRwfp> findListByZyh(Integer zyh) {
        ZlRwfp query = new ZlRwfp();
        query.setZyh(zyh);
        return zlRwfpDao.findByEntity(query);
    }

    /**
     * 查询住院患者治疗记录患者列表
     */
    public List<HistoryPatientResp> findTreatmentPatientList(HistoryQueryPatientReq req) {
        List<HistoryPatientResp> resps = zlRwfpDao.findTreatmentPatientList(req);
        for (HistoryPatientResp resp : resps) {
            List<ImRyzdModel> ryzdList = imRyzdService.findList(resp.getZyh(), RyzdEnum.ADMITTING_MAIN_DIAGNOSIS.getValue());
            if (CollectionUtil.isNotEmpty(ryzdList)) {
                resp.setRyzd(ryzdList.get(0).getZdmc());
            }
            if (resp.getCsny() != null) {
                resp.setAge(DateUtil.ageOfNow(resp.getCsny()));
            }
        }
        return resps;
    }

    /**
     * 查询住院患者治疗记录医嘱列表
     */
    public List<HistoryAdviceResp> findTreatmentAdviceList(HistoryQueryAdviceReq req) {
        return zlRwfpDao.findTreatmentAdviceList(req);
    }

    /**
     * 查询定时任务列表
     */
    public List<ZlRwfpResp> findTaskList() {
        return zlRwfpDao.findTaskList();
    }

    /**
     * 定时任务完成后 更新下次定时任务启动日期
     *
     * @param zlrwfpid 治疗任务分配id
     * @param nextDate 下次执行日期
     */
    public void updateExecuteDay(Integer zlrwfpid, String nextDate) {
        ZlRwfp query = new ZlRwfp();
        query.setZlrwfpid(zlrwfpid);
        query.setXczxrq(nextDate);
        zlRwfpDao.updateByEntity(query);
    }
}
