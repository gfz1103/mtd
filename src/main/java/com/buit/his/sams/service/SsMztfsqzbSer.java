package com.buit.his.sams.service;


import com.buit.his.sams.model.SsMztfsqzb;
import com.buit.his.sams.dao.SsMztfsqzbDao;

import com.buit.commons.BaseManagerImp;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
/**
 * 门诊退费申请主表<br>
 * @author zhouhaisheng
 */
@Service
public class SsMztfsqzbSer extends BaseManagerImp<SsMztfsqzb,Integer> {
    
    static final Logger logger = LoggerFactory.getLogger(SsMztfsqzbSer.class);
    
    @Autowired
    private SsMztfsqzbDao ssMztfsqzbDao;
    
    @Override
    public SsMztfsqzbDao getEntityMapper(){        
        return ssMztfsqzbDao;
    }
    
}
