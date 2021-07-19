package com.buit.his.sams.service;


import com.buit.his.sams.model.SsSsj;
import com.buit.his.sams.request.SsSsjQueryPageReq;
import com.buit.his.sams.request.SsSsjReq;
import com.buit.his.sams.response.SsSsjResp;
import com.buit.commons.BaseManagerImp;
import com.buit.constans.TableName;
import com.buit.his.sams.dao.SsSsjDao;

import com.buit.utill.BeanUtil;
import com.buit.utill.RedisFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 手术间设置表<br>
 * @author zhouhaisheng
 */
@Service
public class SsSsjSer extends BaseManagerImp<SsSsj,Integer> {
    
    static final Logger logger = LoggerFactory.getLogger(SsSsjSer.class);
    
    @Autowired
    private SsSsjDao ssSsjDao;
    @Autowired
    private RedisFactory redisFactory;


    @Override
    public SsSsjDao getEntityMapper(){        
        return ssSsjDao;
    }

    /**
     * 手术间设置分页查询
     * @param req
     * @return
     */
    public List<SsSsjResp> queryPage(SsSsjQueryPageReq req) {
        SsSsj ssSsj=new SsSsj();
        BeanUtils.copyProperties(req,ssSsj);

        List<SsSsj> list=ssSsjDao.findByEntity(ssSsj);

        return BeanUtil.toBeans(list,SsSsjResp.class);
    }

    /**
     * 手术间设置新增
     * @param ssSsjReq
     */
    public void add(SsSsjReq ssSsjReq) {
        SsSsj ssSsj=new SsSsj();
        BeanUtils.copyProperties(ssSsjReq,ssSsj);
        ssSsj.setJlxh(redisFactory.getTableKey(TableName.DB_NAME,TableName.SS_SSJ));
        ssSsjDao.insert(ssSsj);

    }

    /**
     * 启用或停用手术间
     * @param jlxh
     * @param zt
     */
    public void enableZt(Integer jlxh, String zt) {
        SsSsj ssSsj=new SsSsj();
        ssSsj.setJlxh(jlxh);
        ssSsj.setZt(zt);
        ssSsjDao.update(ssSsj);
    }
}
