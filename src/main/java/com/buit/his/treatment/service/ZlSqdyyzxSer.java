package com.buit.his.treatment.service;


import cn.hutool.core.collection.CollUtil;
import cn.hutool.core.date.DateUtil;
import com.buit.his.treatment.dao.ZlJlxjzjDao;
import com.buit.his.treatment.dao.ZlSqdmxDao;
import com.buit.his.treatment.dao.ZlSqdxmzlnrDao;
import com.buit.his.treatment.dao.ZlSqdyyzxDao;
import com.buit.his.treatment.dao.ZlSqdzbDao;
import com.buit.his.treatment.dao.ZlSqdzdDao;
import com.buit.his.treatment.model.ZlJlxjzj;
import com.buit.his.treatment.model.ZlSqdmx;
import com.buit.his.treatment.model.ZlSqdyyzx;
import com.buit.his.treatment.model.ZlSqdzb;
import com.buit.his.treatment.model.ZlSqdzd;
import com.buit.his.treatment.request.*;
import com.buit.his.treatment.response.*;
import com.buit.commons.BaseManagerImp;
import com.buit.constans.TableName;
import com.buit.commons.SysUser;

import com.buit.utill.BeanUtil;
import com.buit.utill.RedisFactory;
import com.buit.utill.ReturnEntity;
import com.buit.utill.ReturnEntityUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.validation.Valid;
import java.math.BigDecimal;
import java.sql.Timestamp;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * 治疗申请单预约执行表<br>
 * @author ZHOUHAISHENG
 */
@Service
public class ZlSqdyyzxSer extends BaseManagerImp<ZlSqdyyzx,Integer> {

    static final Logger logger = LoggerFactory.getLogger(ZlSqdyyzxSer.class);

    @Autowired
    private ZlSqdyyzxDao zlSqdyyzxDao;
    @Autowired
    private ZlSqdxmzlnrDao zlSqdxmzlnrDao;
    @Autowired
    private RedisFactory redisFactory;
    @Autowired
    private ZlSqdmxDao zlSqdmxDao;
    @Autowired
    private ZlSqdzbDao zlSqdzbDao;
    @Autowired
    private ZlSqdzdDao zlSqdzdDao;
    @Autowired
    private ZlJlxjzjDao zlJlxjzjDao;
    @Autowired
    ZlJlxjzjSer zlJlxjzjSer;


    @Override
    public ZlSqdyyzxDao getEntityMapper(){
        return zlSqdyyzxDao;
    }

    /**
     * 查询病人治疗预约列表
     * @param zlSqdmxJlxh
     * @return
     */
    public List<ZlSqdyyzxResp> findList(Integer zlSqdmxJlxh) {
        ZlSqdyyzx zlSqdyyzxParam = new ZlSqdyyzx();
        zlSqdyyzxParam.setZlSqdmxJlxh(zlSqdmxJlxh);
        List<ZlSqdyyzx> list=zlSqdyyzxDao.findByEntity(zlSqdyyzxParam);
        List<ZlSqdyyzxResp> respList=  BeanUtil.toBeans(list,ZlSqdyyzxResp.class);

        return  respList;
    }
    /**
     * 保存或修改治疗预约记录跟治疗内容
     * @param zlsqdyySaveOrUpdateAllReq
     */
    @Transactional(rollbackFor = Exception.class)
    public void saveOrUpdateZlyy(ZlsqdyySaveOrUpdateAllReq zlsqdyySaveOrUpdateAllReq, SysUser user) {
        ZlSqdyyzx zlSqdyyzxParam=new ZlSqdyyzx();
        zlSqdyyzxParam.setJgid(user.getHospitalId());
        zlSqdyyzxParam.setZlSqdmxJlxh(zlsqdyySaveOrUpdateAllReq.getZlSqdmxJlxh());
        List<ZlSqdyyzx> zlSqdyyzxList=zlSqdyyzxDao.findByEntity(zlSqdyyzxParam);
        Map<Integer,List<ZlSqdyyzx>> sqdyyzxMap=zlSqdyyzxList.stream().collect(Collectors.groupingBy(ZlSqdyyzx::getJlxh));
        ZlSqdyyzx zlSqdyyzx=new ZlSqdyyzx();
        int zxsl=0;
        for(ZlsqdyySaveOrUpdateReq zlsqdyySaveOrUpdateReq:zlsqdyySaveOrUpdateAllReq.getZlsqdyySaveOrUpdateReqs()){
          //只对未执行的记录做操作
           if(!"2".equals(zlsqdyySaveOrUpdateReq.getZt())){
               //新增
               if (zlsqdyySaveOrUpdateReq.getJlxh() == null) {
                BeanUtils.copyProperties(zlsqdyySaveOrUpdateReq,zlSqdyyzx);
                zlSqdyyzx.setZt("1");
                zlSqdyyzx.setJlxh(redisFactory.getTableKey(TableName.DB_NAME,TableName.ZL_SQDYYZX));
                zlSqdyyzx.setYyczgh(user.getUserId());
                zlSqdyyzx.setJgid(user.getHospitalId());
                zlSqdyyzx.setYyczsj(new Timestamp(System.currentTimeMillis()));
                zlSqdyyzx.setZxjlgh(user.getUserId());
                zlSqdyyzxDao.insert(zlSqdyyzx);
               } else {
                   //key存在则为修改 不存在为删除
                   //删除
                    if(!sqdyyzxMap.containsKey(zlsqdyySaveOrUpdateReq.getJlxh())){
                        zlSqdyyzxDao.deleteById(zlsqdyySaveOrUpdateReq.getJlxh());
                    }
                    //修改
                    else{
                        BeanUtils.copyProperties(zlsqdyySaveOrUpdateReq, zlSqdyyzx);
                        zlSqdyyzx.setJgid(user.getHospitalId());
                        zlSqdyyzxDao.update(zlSqdyyzx);
                    }

               }

           }
           //执行数量
           else{
               zxsl=zxsl+1;
           }


        }
        for(ZlSqdxmzlnrReq zlSqdxmzlnrReq:zlsqdyySaveOrUpdateAllReq.getZlSqdxmzlnrReqs()){
            zlSqdxmzlnrDao.update(zlSqdxmzlnrReq);
        }
        updateYyzt(zlsqdyySaveOrUpdateAllReq,zxsl);
    }

    /**
     * 病人治疗执行分页查询
     * @param patientZlyyQueryRep
     * @param user
     * @return
     */
    public List<PatientZlyyQueryResp> queryZlyyzxPage(@Valid PatientZlyyQueryRep patientZlyyQueryRep, SysUser user) {
        patientZlyyQueryRep.setJgid(user.getHospitalId());
        List<PatientZlyyQueryResp> respList=zlSqdyyzxDao.queryZlyyzxPage(patientZlyyQueryRep);
        for(PatientZlyyQueryResp patientZlyyQueryResp:respList){
            patientZlyyQueryResp.setAge(DateUtil.ageOfNow(patientZlyyQueryResp.getCsny()));
        }


        return respList;
    }
    //修改状态
    public void updateYyzt(ZlsqdyySaveOrUpdateAllReq req,Integer zxsl){
        ZlSqdmx zlSqdmx=zlSqdmxDao.getById(req.getZlSqdmxJlxh());
        ZlSqdzb zlSqdzb= zlSqdzbDao.getById(Integer.parseInt(zlSqdmx.getZlsqdh()));
        String zbZt=zlSqdzb.getZt();
        String sqdmxZt=zlSqdmx.getZt();
        //更新申请单明细的状态跟预约数量
        ZlSqdmx zlSqdmxParam=new ZlSqdmx();
        zlSqdmxParam.setJgid(zlSqdmx.getJgid());
        zlSqdmxParam.setJlxh(req.getZlSqdmxJlxh());
        zlSqdmxParam.setYyycs(new BigDecimal(req.getZlsqdyySaveOrUpdateReqs().size()));
        //执行数量为0
        if(zxsl.intValue()==0){
            //设置全部预约还是部分预约
            if(zlSqdmx.getSl().subtract(new BigDecimal(req.getZlsqdyySaveOrUpdateReqs().size())).compareTo(BigDecimal.ZERO)==0){
                //全部预约
                sqdmxZt="2";
            }
            else{
                //部分预约
                sqdmxZt="1";
            }
        }
        else{
            //全部执行
            if(zlSqdmx.getSl().subtract(new BigDecimal(zxsl)).compareTo(BigDecimal.ZERO)==0){
                sqdmxZt="4";
            }
            //部分执行
            else{
                sqdmxZt="3";
            }

        }
        zlSqdmxParam.setZt(sqdmxZt);
        zlSqdmxDao.updateYYsl(zlSqdmxParam);

        ZlSqdmx zlSqdmxCount=zlSqdmx;
        zlSqdmxCount.setJgid(zlSqdzb.getJgid());
        zlSqdmxCount.setZlsqdh(zlSqdzb.getZlsqdh());

        List<ZlSqdmx> zlSqdmxList=zlSqdmxDao.findByEntity(zlSqdmxCount);
        List<ZlSqdmx> bfyyList=zlSqdmxList.stream().filter(s->s.getZt().equals("1")).collect(Collectors.toList());
        List<ZlSqdmx> qbyyList=zlSqdmxList.stream().filter(s->s.getZt().equals("2")).collect(Collectors.toList());
        List<ZlSqdmx> bfzxList=zlSqdmxList.stream().filter(s->s.getZt().equals("3")).collect(Collectors.toList());
        List<ZlSqdmx> qbzxList=zlSqdmxList.stream().filter(s->s.getZt().equals("4")).collect(Collectors.toList());
        if(qbzxList.size()==zlSqdmxList.size()){
            zbZt="4";
        }
        else if(bfzxList.size()>0){
            zbZt="3";
        }
        else if(qbyyList.size()==zlSqdmxList.size()){
            zbZt="2";
        }
        else if(bfyyList.size()>0 && qbyyList.size()<zlSqdmxList.size()){
            zbZt="1";
        }
        zlSqdzb.setZt(zbZt);
        zlSqdzbDao.update(zlSqdzb);
    }

    /**
     * 病人治疗执行--治疗项目详情查询
     * @param jlxh
     * @param user
     * @return
     */
    public QueryZlyyzxXmxqResp queryZlyyzxXmxq(Integer jlxh, SysUser user) {
        QueryZlyyzxXmxqResp queryZlyyzxXmxqResp=new QueryZlyyzxXmxqResp();
        ZlSqdmx zlSqdmx=zlSqdmxDao.getById(jlxh);
        ZlSqdzd zlSqdzdParam=new ZlSqdzd();
        zlSqdzdParam.setJgid(user.getHospitalId());
        zlSqdzdParam.setZlsqdh(zlSqdmx.getZlsqdh());
        List<ZlSqdzd> zlSqdzdList= zlSqdzdDao.findByEntity(zlSqdzdParam);
        queryZlyyzxXmxqResp.setJlxh(jlxh);
        queryZlyyzxXmxqResp.setZlxmmc(zlSqdmx.getZlxmmc());
        queryZlyyzxXmxqResp.setZysx(zlSqdmx.getZysx());
        queryZlyyzxXmxqResp.setZlmb(zlSqdmx.getZlmb());
        String zlzd= zlSqdzdList.stream().map(ZlSqdzd::getZdmc).collect(Collectors.joining(","));
        queryZlyyzxXmxqResp.setZlzd(zlzd);
        return queryZlyyzxXmxqResp;

    }

    /**
     * 取消执行
     * @param jlxh
     * @param user
     */
    @Transactional(rollbackFor = Exception.class)
    public void cancelZx(Integer jlxh, SysUser user) {
        //修改执行预约记录数据
        ZlSqdyyzx zlSqdyyzxUpdate=new ZlSqdyyzx();
        zlSqdyyzxUpdate.setJgid(user.getHospitalId());
        zlSqdyyzxUpdate.setJlxh(jlxh);
        zlSqdyyzxUpdate.setZxsj(null);
        zlSqdyyzxUpdate.setZxygh(null);
        zlSqdyyzxUpdate.setZxjlsj(null);
        zlSqdyyzxUpdate.setZt("1");
        zlSqdyyzxDao.cancelZx(zlSqdyyzxUpdate);
        ZlSqdyyzx zlSqdyyzx = zlSqdyyzxDao.getById(jlxh);
        zlJlxjzjSer.saveFymx(zlSqdyyzx.getZlSqdmxJlxh(),user,true);
        //删除执行记录
        ZlJlxjzj zlJlxjzjDel=new ZlJlxjzj();
        zlJlxjzjDel.setYyzxJlxh(jlxh);
        zlJlxjzjDel.setJgid(user.getHospitalId());
        zlJlxjzjDao.removeByEntity(zlJlxjzjDel);

    }

    /**
     * 查询统计-科室治疗工作量统计(明细)
     * @param deptTreatStatisticsDetailReq
     * @return
     */
    public ReturnEntity<List<DeptTreatStatisticsDetailResp>> queryDeptTreatStatisticsDetail(DeptTreatStatisticsDetailReq deptTreatStatisticsDetailReq) {

        List<DeptTreatStatisticsDetailResp> resp=zlSqdmxDao.queryDeptTreatStatisticsDetail(deptTreatStatisticsDetailReq);
        for(DeptTreatStatisticsDetailResp r:resp){
            r.setAge(DateUtil.ageOfNow(r.getCsny()));
        }
        return ReturnEntityUtil.success(resp);
    }

}
