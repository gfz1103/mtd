package com.buit.his.treatment.service;


import com.buit.his.treatment.dao.ZlSqdxmzlnrDao;
import com.buit.his.treatment.model.ZlSqdxmzlnr;
import com.buit.his.treatment.request.ZlSqdxmzlnrReq;
import com.buit.his.treatment.response.ZlSqdxmzlnrResp;
import com.buit.commons.BaseManagerImp;
import com.buit.constans.TableName;

import com.buit.utill.BeanUtil;
import com.buit.utill.RedisFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * 治疗申请单项目治疗内容表<br>
 * @author ZHOUHAISHENG
 */
@Service
public class ZlSqdxmzlnrSer extends BaseManagerImp<ZlSqdxmzlnr,Integer> {
    
    static final Logger logger = LoggerFactory.getLogger(ZlSqdxmzlnrSer.class);
    
    @Autowired
    private ZlSqdxmzlnrDao zlSqdxmzlnrDao;
    @Autowired
    private RedisFactory redisFactory;
    @Override
    public ZlSqdxmzlnrDao getEntityMapper(){        
        return zlSqdxmzlnrDao;
    }

    /**
     * 新增治疗申请单治疗内容
     * @param zlSqdxmzlnr
     */
    public void add(ZlSqdxmzlnr zlSqdxmzlnr){
        zlSqdxmzlnr.setJlxh(redisFactory.getTableKey(TableName.DB_NAME,TableName.ZL_SQDXMZLNR));
        zlSqdxmzlnrDao.insert(zlSqdxmzlnr);

    }

    /**
     * 批量插入
     * @param zlSqdxmzlnrList
     */
    public void insertForeach(List<ZlSqdxmzlnr> zlSqdxmzlnrList) {
        zlSqdxmzlnrDao.insertForeach(zlSqdxmzlnrList);
    }

    /**
     * 查询病人治疗预约治疗内容列表
     * @param zlSqdmxJlxh
     * @return
     */
    public List<ZlSqdxmzlnrResp> findList(Integer zlSqdmxJlxh) {
        ZlSqdxmzlnr queryParam=new ZlSqdxmzlnr();
        queryParam.setZlSqdmxJlxh(zlSqdmxJlxh);
        queryParam.setSortColumns("pxh asc");
        List<ZlSqdxmzlnr> zlSqdxmzlnrList=zlSqdxmzlnrDao.findByEntity(queryParam);
        List<ZlSqdxmzlnrResp> zlSqdxmzlnrRespList= BeanUtil.toBeans(zlSqdxmzlnrList,ZlSqdxmzlnrResp.class);
        return zlSqdxmzlnrRespList;
    }

    /**
     * 批量修改病人治疗预约内容
     * @param zlSqdxmzlnrReqs
     */
    @Transactional(rollbackFor = Exception.class)
    public void edit(List<ZlSqdxmzlnrReq> zlSqdxmzlnrReqs) {
        for(ZlSqdxmzlnrReq zlSqdxmzlnrReq:zlSqdxmzlnrReqs){
            zlSqdxmzlnrDao.update(zlSqdxmzlnrReq);

        }

    }
}
