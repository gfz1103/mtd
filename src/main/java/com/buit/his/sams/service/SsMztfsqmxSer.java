package com.buit.his.sams.service;


import com.buit.his.sams.model.SsMztfsqmx;
import com.buit.his.sams.dao.SsMztfsqmxDao;

import com.buit.commons.BaseManagerImp;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
/**
 * 门诊退费申请明细表<br>
 * @author zhouhaisheng
 */
@Service
public class SsMztfsqmxSer extends BaseManagerImp<SsMztfsqmx,Integer> {
    
    static final Logger logger = LoggerFactory.getLogger(SsMztfsqmxSer.class);
    
    @Autowired
    private SsMztfsqmxDao ssMztfsqmxDao;
    
    @Override
    public SsMztfsqmxDao getEntityMapper(){        
        return ssMztfsqmxDao;
    }
    
}
