package com.buit.his.sams.service;


import com.buit.his.sams.model.SsSslx;
import com.buit.his.sams.request.SsSslxAddReq;
import com.buit.his.sams.request.SsSslxReq;
import com.buit.commons.BaseManagerImp;
import com.buit.constans.TableName;
import com.buit.his.sams.dao.SsSslxDao;

import com.buit.utill.PinyinUtils;
import com.buit.utill.RedisFactory;
import com.buit.utill.WubiUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
/**
 * 手术类型表<br>
 * @author zhouhaisheng
 */
@Service
public class SsSslxSer extends BaseManagerImp<SsSslx,Integer> {
    
    static final Logger logger = LoggerFactory.getLogger(SsSslxSer.class);
    
    @Autowired
    private SsSslxDao ssSslxDao;
    @Autowired
    private RedisFactory redisFactory;


    @Override
    public SsSslxDao getEntityMapper(){        
        return ssSslxDao;
    }

    /**
     * 新增手术类型
     * @param ssSslxAddReq
     */
    public void add(SsSslxAddReq ssSslxAddReq) {
    SsSslx ssSslx=new SsSslx();
    BeanUtils.copyProperties(ssSslxAddReq,ssSslx);
    ssSslx.setJlxh(redisFactory.getTableKey(TableName.DB_NAME,TableName.SS_SSLX));
   // ssSslx.setZt("0");
    ssSslx.setPym(PinyinUtils.getSimplePinYin(ssSslx.getSslx()));
    ssSslx.setWbm(WubiUtils.getSimpleWuBi(ssSslx.getSslx()));
    ssSslxDao.insert(ssSslx);

    }

    /**
     * 修改手术类型
     * @param ssSslxReq
     */
    public void edit(SsSslxReq ssSslxReq) {
    SsSslx  ssSslx =new SsSslx();
    BeanUtils.copyProperties(ssSslxReq,ssSslx);
    ssSslx.setPym(PinyinUtils.getSimplePinYin(ssSslxReq.getSslx()));
    ssSslx.setWbm(WubiUtils.getSimpleWuBi(ssSslxReq.getSslx()));
    ssSslxDao.update(ssSslx);
    }

    /**
     * 启用或者停用手术类型
     * @param jlxh
     * @param zt
     */
    public void enableZt(Integer jlxh, String zt) {
        SsSslx  ssSslx =new SsSslx();
        ssSslx.setJlxh(jlxh);
        ssSslx.setZt(zt);
        ssSslxDao.update(ssSslx);
    }
}
