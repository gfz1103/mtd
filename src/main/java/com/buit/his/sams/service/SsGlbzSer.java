package com.buit.his.sams.service;


import com.buit.his.sams.model.SsGlbz;
import com.buit.his.sams.request.SsGlbzAddReq;
import com.buit.his.sams.request.SsGlbzReq;
import com.buit.commons.BaseManagerImp;
import com.buit.constans.TableName;
import com.buit.his.sams.dao.SsGlbzDao;

import com.buit.utill.PinyinUtils;
import com.buit.utill.RedisFactory;
import com.buit.utill.WubiUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
/**
 * 隔离标志表<br>
 * @author zhouhaisheng
 */
@Service
public class SsGlbzSer extends BaseManagerImp<SsGlbz,Integer> {
    
    static final Logger logger = LoggerFactory.getLogger(SsGlbzSer.class);
    
    @Autowired
    private SsGlbzDao ssGlbzDao;
    @Autowired
    private RedisFactory redisFactory;


    @Override
    public SsGlbzDao getEntityMapper(){        
        return ssGlbzDao;
    }

    /**
     * 新增隔离标志信息
     * @param ssGlbzAdd
     */
    public void add(SsGlbzAddReq ssGlbzAdd) {
    SsGlbz ssGlbz=new SsGlbz();
    BeanUtils.copyProperties(ssGlbzAdd,ssGlbz);
    ssGlbz.setJlxh(redisFactory.getTableKey(TableName.DB_NAME,TableName.SS_GLBZ));
        //默认启用状态
        ssGlbz.setZt("0");
        ssGlbz.setPym(PinyinUtils.getSimplePinYin(ssGlbzAdd.getGlbz()));
        ssGlbz.setWbm(WubiUtils.getSimpleWuBi(ssGlbzAdd.getGlbz()));

        ssGlbzDao.insert(ssGlbz);


    }

    /**
     *修改隔离标志信息
     * @param ssGlbzReq
     */
    public void edit(SsGlbzReq ssGlbzReq) {

        SsGlbz ssGlbz=new SsGlbz();
        BeanUtils.copyProperties(ssGlbzReq,ssGlbz);

        ssGlbz.setPym(PinyinUtils.getSimplePinYin(ssGlbzReq.getGlbz()));
        ssGlbz.setWbm(WubiUtils.getSimpleWuBi(ssGlbzReq.getGlbz()));

        ssGlbzDao.update(ssGlbz);
    }

    /**
     * 修改状态
     * @param jlxh
     * @param zt
     */
    public void enableZt(Integer jlxh,String zt) {
        SsGlbz ssGlbz=new SsGlbz();
        ssGlbz.setJlxh(jlxh);
        ssGlbz.setZt(zt);
        ssGlbzDao.update(ssGlbz);
    }
}
