package com.buit.his.treatment.service;


import com.buit.commons.BaseManagerImp;
import com.buit.his.treatment.dao.DicSypcDao;
import com.buit.his.treatment.model.DicSypc;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 公用_使用频次<br>
 *
 * @author GONGFANGZHOU
 */
@Service
public class DicSypcSer extends BaseManagerImp<DicSypc, String> {

    static final Logger logger = LoggerFactory.getLogger(DicSypcSer.class);

    @Autowired
    private DicSypcDao dicSypcDao;

    @Override
    public DicSypcDao getEntityMapper() {
        return dicSypcDao;
    }

    /**
     * 批量查询
     *
     * @param sypcList 频次编码数组
     */
    public List<DicSypc> findListByIds(List<String> sypcList) {
        return dicSypcDao.findListByIds(sypcList);
    }
}
