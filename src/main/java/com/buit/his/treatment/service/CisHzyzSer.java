package com.buit.his.treatment.service;

import com.buit.commons.BaseManagerImp;
import com.buit.his.treatment.dao.CisHzyzDao;
import com.buit.his.treatment.model.CisHzyz;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CisHzyzSer extends BaseManagerImp<CisHzyz, Integer> {
    static final Logger logger = LoggerFactory.getLogger(ZlZlzcybSer.class);

    @Autowired
    private CisHzyzDao cisHzyzDao;

    @Override
    public CisHzyzDao getEntityMapper() {
        return cisHzyzDao;
    }

}
