package com.buit.his.sams.service;


import com.buit.his.sams.dao.SsSsjzdmxDao;
import com.buit.his.sams.response.SsSsjzdmxResp;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 手术记账单明细表<br>
 * @author zhouhaisheng
 */
@Service
public class SsSsjzdmxSer {

    static final Logger log = LoggerFactory.getLogger(SsSsjzdmxSer.class);

    @Autowired
    private SsSsjzdmxDao ssSsjzdmxDao;


    public List<SsSsjzdmxResp> queryList(Integer jzdh) {
        return ssSsjzdmxDao.queryList(jzdh);
    }
}
