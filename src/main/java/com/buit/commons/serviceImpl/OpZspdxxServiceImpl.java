package com.buit.commons.serviceImpl;

import com.buit.his.op.queuing.dao.OpZspdxxDao;
import com.buit.his.op.queuing.model.OpZspdxx;
import com.buit.his.op.queuing.service.OpZspdxxService;

import org.apache.dubbo.config.annotation.DubboService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Map;

/**
 * @Description 类描述
 * @Author 老花生
 * @Date 2020/10/14 9:43
 */
@DubboService
public class OpZspdxxServiceImpl implements OpZspdxxService {
    @Autowired
    private OpZspdxxDao opZspdxxDao;

    @Override
    public void updatePdxhByOid(Map<String, Object> map) {
        opZspdxxDao.updatePdxhByOid(map);
    }

    @Override
    public void insert(OpZspdxx pdxx) {
        opZspdxxDao.insert(pdxx);
    }

    @Override
    public void updateZdysJzztByOid(String jzlsh, Integer ysdm, Integer zsid) {
        opZspdxxDao.updateZdysJzztByOid(jzlsh, ysdm, zsid);
    }
}
