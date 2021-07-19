package com.buit.his.op.queuing.service;


import cn.hutool.core.date.DateUtil;
import com.buit.commons.BaseException;
import com.buit.commons.BaseManagerImp;
import com.buit.commons.SysUser;
import com.buit.his.op.queuing.dao.OpBcsjDao;
import com.buit.his.op.queuing.dao.OpZspdxxDao;
import com.buit.his.op.queuing.model.OpBcsj;
import com.buit.his.op.queuing.model.OpJzdlResult;
import com.buit.his.op.queuing.model.OpZspdxx;
import com.buit.his.op.queuing.request.OpZspdxxReq;
import com.buit.his.op.queuing.response.MpiBrdaResp;
import com.buit.his.op.queuing.response.OpZspdxxResp;
import com.buit.op.model.OpGhmx;
import com.buit.op.service.OpGhmxService;
import com.buit.op.service.OpMpiBrdaService;
import com.buit.op.service.OpYsJzlsService;
import com.buit.op.service.PatientListService;
import com.buit.system.response.HrPersonnelResp;
import com.buit.system.service.HrPersonnelService;
import com.buit.utill.BeanUtil;
import com.buit.utill.ParamUtil;
import org.apache.dubbo.config.annotation.DubboReference;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.sql.Date;
import java.sql.Timestamp;
import java.util.List;
import java.util.Map;

/**
 * 门诊就诊队列<br>
 * @author 老花生
 */
@Service
public class OpZspdxxSer extends BaseManagerImp<OpZspdxx,Integer> {

    static final Logger logger = LoggerFactory.getLogger(OpZspdxxSer.class);

    @Autowired
    private OpZspdxxDao opZspdxxDao;
    @Autowired
    private OpBcsjDao opBcsjDao;
    @DubboReference
    private OpYsJzlsService opYsJzlsService;
    @DubboReference
    private OpMpiBrdaService opMpiBrdaService;
    @DubboReference
    private OpGhmxService opGhmxService;
    @DubboReference
    private PatientListService patientListService;
    @DubboReference
    private HrPersonnelService hrPersonnelService;

    @Override
    public OpZspdxxDao getEntityMapper(){
        return opZspdxxDao;
    }

    /**
     * @name: query
     * @description: 查询列表
     * @param opzspdxx
     * @return: java.util.List<com.buit.his.op.queuing.response.OpZspdxxResp>
     * @date: 2020/9/7 15:43
     * @auther: 朱智
     *
     */
    public List<OpZspdxxResp> query(OpZspdxxReq opzspdxx) {
        //查询班级集合
        List<OpBcsj> bcList = opBcsjDao.findByEntity(new OpBcsj());
        //查询排队集合
        opzspdxx.setSortColumns("ghks, sddm, jzzt, brfj, pdxh");
        List<OpZspdxx> ret = opZspdxxDao.findByEntity(opzspdxx);
        List<OpZspdxxResp> respList = BeanUtil.toBeans(ret, OpZspdxxResp.class);
        for (int i = 0; i <respList.size() ; i++) {
            OpZspdxxResp pd = respList.get(i);
            //设置年龄
            if(pd.getCsrq() != null){
                pd.setNl(DateUtil.ageOfNow(pd.getCsrq()));
            }
            //设置等候时间
            for(OpBcsj sj : bcList){
                //满足时段代码相同  以及就诊状态（jzzt = 0）
                if(sj.getSddm().equals(pd.getSddm()) && "0".equals(pd.getJzzt())){
                    pd.setDhsj(sj.getPjsc().multiply(new BigDecimal(i+1)));
                }
            }
        }
        return respList;
    }

    /**
     * @name: appointDoctor
     * @description: 指定医生
     * @param oid
     * @param ysdm
     * @param jzlsh
     * @return: void
     * @date: 2020/9/7 17:56
     * @auther: 朱智
     *
     */
    @Transactional(rollbackFor=Exception.class)
    public void appointDoctor(Integer oid, Integer ysdm, String jzlsh) {
        List list = opYsJzlsService.findByEntity(ParamUtil.instance().put("jzlsh", jzlsh));
        if(!list.isEmpty()){//有就诊历史说明已经就诊中
            throw BaseException.create("ERROR_DCTWORK_OP_0044");
        }
        opZspdxxDao.updateZdysByOid(oid, ysdm);
        opGhmxService.updateYsdmByJzlsh(jzlsh, ysdm);
    }

    /**
     * @name: callNumber
     * @description: 叫号
     * @param ysdm
     * @param jzlsh
     * @return: void
     * @date: 2020/9/7 17:53
     * @auther: 朱智
     *
     */
    @Transactional(rollbackFor=Exception.class)
    public void callNumber(Integer ysdm, String jzlsh, SysUser user, String ip) {
        List list = opYsJzlsService.findByEntity(ParamUtil.instance().put("jzlsh", jzlsh));
        if(!list.isEmpty()){
            throw BaseException.create("ERROR_DCTWORK_OP_0044");
        }
        //根据就诊流水号查询信息
        OpGhmx opghmx = new OpGhmx();
        opghmx.setJzlsh(jzlsh);
        List<OpGhmx> ghmxList = opGhmxService.findByEntity(opghmx);
        if(!ghmxList.isEmpty()){
            Map<String, Object> par =  cn.hutool.core.bean.BeanUtil.beanToMap(ghmxList.get(0));
            par.put("ghks", par.get("ksdm"));
            //调用门诊叫号功能
            patientListService.saveInitClinicInfo(par, ysdm, user.getHospitalId(), ip);
        }

    }

    /**
     * @name: getBrdaByBrid
     * @description: 查询病人档案信息
     * @param brid
     * @return: com.buit.cis.op.dctwork.response.MpiBrdaResp
     * @date: 2020/9/8 13:22
     * @auther: 朱智
     *
     */
    public MpiBrdaResp getBrdaByBrid(Integer brid, Integer jgid) {
        return BeanUtil.toBean(opMpiBrdaService.getByBrid(brid, jgid), MpiBrdaResp.class);
    }

    /**
     * @name: getOutWaitQueueList
     * @description: TODO
     * @param ksid
     * @param zsid
     * @param jhsj
     * @param hospitalId
     * @return: void
     * @date: 2020/9/8 17:47
     * @auther: 朱智
     *
     */
    public List<OpJzdlResult> getOutWaitQueueList(Integer ksid, Integer zsid, Date jhsj, Integer hospitalId) {
        Timestamp beginOfDay = null;
        Timestamp endOfDay = null;
        if (jhsj != null) {
            beginOfDay = DateUtil.beginOfDay(jhsj).toTimestamp();
            endOfDay = DateUtil.endOfDay(jhsj).toTimestamp();
        }

        List<OpJzdlResult> waitQueueList = opZspdxxDao.getWaitQueueByDeptId(ksid, zsid,
                jhsj, beginOfDay, endOfDay, hospitalId);
        int unionKey = 0;
        if (waitQueueList != null && !waitQueueList.isEmpty()) {
            for (OpJzdlResult result : waitQueueList) {
                result.setUnionKey("dept" + result.getKsid());
                List<OpJzdlResult> childList = opZspdxxDao.getWaitQueueByConsultCode(
                        result.getKsid(), zsid, jhsj, beginOfDay, endOfDay, hospitalId);
                if (childList != null && !childList.isEmpty()) {
                    for (OpJzdlResult child : childList) {
                        child.setUnionKey("child" + unionKey++);
                    }
                    result.setChildren(childList);
                }
            }
        }
        return waitQueueList;
    }

    /**
     * @name: queryLoginDoctor
     * @description: 查询在线医生
     * @param ksid
     * @return: java.util.List<com.buit.his.user.response.SysUserResp>
     * @date: 2020/9/9 13:40
     * @auther: 朱智
     *
     */
    public List<HrPersonnelResp> queryLoginDoctor(Integer ksid) {
        return hrPersonnelService.queryLoginDoctor(ksid);
    }
}
