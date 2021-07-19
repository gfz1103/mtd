package com.buit.his.sams.preService;

import com.buit.his.sams.dao.SsZytfsqmxDao;
import com.buit.his.sams.model.SsZytfsqmx;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 手术/麻醉 记账预处理
 * jiangwei
 */
@Service
public class SstfPreService {

    @Autowired
    private SsZytfsqmxDao ssZytfsqmxDao;

    /**
     * 根据退费申请单号查询退费明细
     */
    public List<SsZytfsqmx> findListByTfsqdh(Integer tfsqdh) {
        SsZytfsqmx query = new SsZytfsqmx();
        query.setTfsqdh(tfsqdh);
        return ssZytfsqmxDao.findByEntity(query);
    }
}
