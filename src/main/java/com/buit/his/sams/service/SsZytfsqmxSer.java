package com.buit.his.sams.service;


import com.buit.commons.BaseManagerImp;
import com.buit.his.sams.dao.SsZytfsqmxDao;
import com.buit.his.sams.model.SsZytfsqmx;
import com.buit.his.sams.response.SsZytfsqmxResp;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 住院退费申请明细表<br>
 *
 * @author zhouhaisheng
 */
@Service
public class SsZytfsqmxSer extends BaseManagerImp<SsZytfsqmx, Integer> {

    static final Logger logger = LoggerFactory.getLogger(SsZytfsqmxSer.class);

    @Autowired
    private SsZytfsqmxDao ssZytfsqmxDao;

    @Override
    public SsZytfsqmxDao getEntityMapper() {
        return ssZytfsqmxDao;
    }

    /**
     * 查询退费项目列表
     *
     * @param
     * @return
     */
    public List<SsZytfsqmxResp> findList(Integer jlxh) {
        return ssZytfsqmxDao.findList(jlxh);
    }

    public void delete(Integer jlxh) {
        logger.info("删除退费明细[{}]", jlxh);
        ssZytfsqmxDao.deleteByIdAndZt(jlxh, 0);
    }
}
