package com.buit.his.treatment.service;


import cn.hutool.core.bean.copier.CopyOptions;
import com.buit.commons.BaseManagerImp;
import com.buit.commons.SysUser;
import com.buit.constans.TableName;
import com.buit.his.treatment.dao.ZlSqdzdDao;
import com.buit.his.treatment.model.ZlSqdzb;
import com.buit.his.treatment.model.ZlSqdzd;
import com.buit.his.treatment.request.ZlSqdzbUpdateReq;
import com.buit.his.treatment.request.ZlSqdzdReq;
import com.buit.his.treatment.request.ZlSqdzdUpdateReq;
import com.buit.utill.RedisFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * 治疗申请单诊断表<br>
 * @author ZHOUHAISHENG
 */
@Service
public class ZlSqdzdSer extends BaseManagerImp<ZlSqdzd,Integer> {

    static final Logger logger = LoggerFactory.getLogger(ZlSqdzdSer.class);

    @Autowired
    private ZlSqdzdDao zlSqdzdDao;
    @Autowired
    private RedisFactory redisFactory;
    @Override
    public ZlSqdzdDao getEntityMapper(){
        return zlSqdzdDao;
    }

    /**
     * 添加病人治疗申请诊断
     * @param zlSqdzdList
     */
    public void add(List<ZlSqdzdReq> zlSqdzdList, ZlSqdzb zlSqdzb, SysUser sysUser) {
    for(ZlSqdzdReq zlSqdzdReq:zlSqdzdList){
        ZlSqdzd zlSqdzd=new ZlSqdzd();
        BeanUtils.copyProperties(zlSqdzdReq,zlSqdzd);
        zlSqdzd.setJlxh(redisFactory.getTableKey(TableName.DB_NAME,TableName.ZL_SQDZD));
        zlSqdzd.setJgid(sysUser.getHospitalId());
        zlSqdzd.setZlsqdh(zlSqdzb.getZlsqdh());
        zlSqdzdDao.insert(zlSqdzd);
    }

    }

    /**
     * 修改病人治疗申请信息
     * @param zlSqdzdUpdateReqList
     */
    @Transactional(rollbackFor = Exception.class)
    public void updateList(ZlSqdzbUpdateReq zlSqdzbUpdateReq, List<ZlSqdzdUpdateReq> zlSqdzdUpdateReqList, SysUser user) {
        //先去查询该病人治疗申请下面的诊断信息
        ZlSqdzd queryParam=new ZlSqdzd();
        queryParam.setJgid(user.getHospitalId());
        queryParam.setZlsqdh(zlSqdzbUpdateReq.getZlsqdh());
        List<ZlSqdzd> zlSqdzdList=zlSqdzdDao.findByEntity(queryParam);
        Map<Integer,List<ZlSqdzd>> zlsqzdMap=zlSqdzdList.stream().collect(Collectors.groupingBy(ZlSqdzd::getJlxh));
        Map<Integer,ZlSqdzd> updateMap=new HashMap<>();
        for(ZlSqdzdUpdateReq zlSqdzdUpdateReq:zlSqdzdUpdateReqList){
            //jlxh为空为新增
            if(zlSqdzdUpdateReq.getJlxh()==null){
            ZlSqdzd zlSqdzd=new ZlSqdzd();
            cn.hutool.core.bean.BeanUtil.copyProperties(zlSqdzdUpdateReq,zlSqdzd, CopyOptions.create().setIgnoreNullValue(true));
            zlSqdzd.setZlsqdh(zlSqdzbUpdateReq.getZlsqdh());
            zlSqdzd.setJgid(user.getUserId());
            zlSqdzd.setJlxh(redisFactory.getTableKey(TableName.DB_NAME,TableName.ZL_SQDZD));
            zlSqdzdDao.insert(zlSqdzd);
            updateMap.put(zlSqdzd.getJlxh(),zlSqdzd);
            }
            else{
                //jlxh不为空 做修改操作
                ZlSqdzd zlSqdzd=zlsqzdMap.get(zlSqdzdUpdateReq.getJlxh()).get(0);
                cn.hutool.core.bean.BeanUtil.copyProperties(zlSqdzdUpdateReq,zlSqdzd, CopyOptions.create().setIgnoreNullValue(true));
                zlSqdzdDao.update(zlSqdzd);
                updateMap.put(zlSqdzd.getJlxh(),zlSqdzd);

            }
        }
        //查询删除的诊断记录
        for (Integer jlxh : zlsqzdMap.keySet()) {
            if (!updateMap.containsKey(jlxh)) {
                zlSqdzdDao.deleteById(jlxh);
            }
        }

    }


    /**
     * 根据治疗申请单号删除诊断
     *
     * @param sqdh 治疗申请单号
     */
    public void deleteBySqdh(Integer sqdh) {
        ZlSqdzd query = new ZlSqdzd();
        query.setZlsqdh(String.valueOf(sqdh));
        zlSqdzdDao.removeByEntity(query);
    }
}
