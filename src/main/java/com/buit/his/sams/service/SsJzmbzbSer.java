package com.buit.his.sams.service;


import com.buit.his.sams.model.SsJzmbzb;
import com.buit.his.sams.request.SsJzmbzbAddReq;
import com.buit.his.sams.request.SsJzmbzbPageQueryReq;
import com.buit.his.sams.response.SsJzmbzbResp;
import com.buit.commons.BaseManagerImp;
import com.buit.constans.TableName;
import com.buit.his.sams.dao.SsJzmbzbDao;

import com.buit.commons.SysUser;
import com.buit.utill.BeanUtil;
import com.buit.utill.RedisFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;
import java.util.List;

/**
 * 手术/麻醉记账模板主表<br>
 * @author zhouhaisheng
 */
@Service
public class SsJzmbzbSer extends BaseManagerImp<SsJzmbzb,Integer> {
    
    static final Logger logger = LoggerFactory.getLogger(SsJzmbzbSer.class);
    
    @Autowired
    private SsJzmbzbDao ssJzmbzbDao;
    @Autowired
    private RedisFactory redisFactory;
    @Override
    public SsJzmbzbDao getEntityMapper(){        
        return ssJzmbzbDao;
    }

    /**
     * 新增手术记账模板
     * @param ssJzmbzbAddReq
     */
    public void add(SsJzmbzbAddReq ssJzmbzbAddReq, SysUser sysUser) {
        SsJzmbzb ssJzmbzb=new SsJzmbzb();
        BeanUtils.copyProperties(ssJzmbzbAddReq,ssJzmbzb);
        ssJzmbzb.setCjsj(new Timestamp(System.currentTimeMillis()));
        ssJzmbzb.setCjrdm(sysUser.getUserId());
        ssJzmbzb.setJlxh(redisFactory.getTableKey(TableName.DB_NAME,TableName.SS_JZMBZB));
        ssJzmbzb.setJgid(sysUser.getHospitalId());
        ssJzmbzbDao.insert(ssJzmbzb);

    }

    /**
     * 查询手术/麻醉记账模板列表
     * @param ssJzmbzbPageQueryReq
     * @return
     */
    public List<SsJzmbzbResp> findList(SsJzmbzbPageQueryReq ssJzmbzbPageQueryReq) {
        SsJzmbzb ssJzmbzb=new SsJzmbzb();
        BeanUtils.copyProperties(ssJzmbzbPageQueryReq,ssJzmbzb);
        List<SsJzmbzb> list=ssJzmbzbDao.findByEntity(ssJzmbzb);
        return BeanUtil.toBeans(list,SsJzmbzbResp.class);

    }
}
