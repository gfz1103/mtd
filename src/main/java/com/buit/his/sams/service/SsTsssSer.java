package com.buit.his.sams.service;


import com.buit.his.sams.model.SsTsss;
import com.buit.his.sams.request.SsTsssAddReq;
import com.buit.his.sams.request.SsTsssReq;
import com.buit.commons.BaseManagerImp;
import com.buit.constans.TableName;
import com.buit.his.sams.dao.SsTsssDao;

import com.buit.utill.PinyinUtils;
import com.buit.utill.RedisFactory;
import com.buit.utill.WubiUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
/**
 * 特殊手术表<br>
 * @author zhouhaisheng
 */
@Service
public class SsTsssSer extends BaseManagerImp<SsTsss,Integer> {
    
    static final Logger logger = LoggerFactory.getLogger(SsTsssSer.class);
    
    @Autowired
    private SsTsssDao ssTsssDao;
    @Autowired
    private RedisFactory redisFactory;

    @Override
    public SsTsssDao getEntityMapper(){        
        return ssTsssDao;
    }

    /**
     * 新增特殊手术信息
     * @param ssTsssAddReq
     */
    public void add(SsTsssAddReq ssTsssAddReq) {
    SsTsss ssTsss=new SsTsss();
    BeanUtils.copyProperties(ssTsssAddReq,ssTsss);
    ssTsss.setJlxh(redisFactory.getTableKey(TableName.DB_NAME,TableName.SS_TSSS));
    ssTsss.setPym(PinyinUtils.getSimplePinYin(ssTsssAddReq.getTsssmc()));
    ssTsss.setWbm(WubiUtils.getSimpleWuBi(ssTsssAddReq.getTsssmc()));
    //ssTsss.setZt("0");
    ssTsssDao.insert(ssTsss);
    }

    /**
     * 修改特殊手术信息
     * @param ssTsssReq
     */
    public void edit(SsTsssReq ssTsssReq) {
        SsTsss ssTsss=new SsTsss();
        BeanUtils.copyProperties(ssTsssReq,ssTsss);
        ssTsss.setPym(PinyinUtils.getSimplePinYin(ssTsssReq.getTsssmc()));
        ssTsss.setWbm(WubiUtils.getSimpleWuBi(ssTsssReq.getTsssmc()));
        ssTsssDao.update(ssTsssReq);

    }

    /**
     * 启用或者停用特殊手术
     * @param jlxh
     * @param zt
     */
    public void enableZt(Integer jlxh, String zt) {
        SsTsss ssTsss =new SsTsss();
        ssTsss.setJlxh(jlxh);
        ssTsss.setZt(zt);
        ssTsssDao.update(ssTsss);

    }
}
