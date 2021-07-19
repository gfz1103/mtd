package com.buit.his.op.queuing.service;


import com.buit.commons.BaseManagerImp;
import com.buit.his.op.queuing.dao.OpBcsjDao;
import com.buit.his.op.queuing.model.OpBcsj;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * 班次上下班时间字典<br>
 * @author 老花生
 */
@Service
public class OpBcsjSer extends BaseManagerImp<OpBcsj,Long> {
    
    static final Logger logger = LoggerFactory.getLogger(OpBcsjSer.class);
    
    @Autowired
    private OpBcsjDao opBcsjDao;
    
    @Override
    public OpBcsjDao getEntityMapper(){        
        return opBcsjDao;
    }
    
}
