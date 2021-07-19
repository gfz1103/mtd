package com.buit.his.treatment.service;


import cn.hutool.core.collection.CollectionUtil;
import com.buit.commons.BaseManagerImp;
import com.buit.commons.SysUser;
import com.buit.constans.TableName;
import com.buit.his.treatment.dao.ZlXmzljhDao;
import com.buit.his.treatment.model.ZlXmzljh;
import com.buit.his.treatment.request.ZlXmzljhUpdateReq;
import com.buit.utill.RedisFactory;
import com.buit.utill.ReturnEntity;
import com.buit.utill.ReturnEntityUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 治疗项目治疗计划表<br>
 *
 * @author ZHOUHAISHENG
 */
@Service
public class ZlXmzljhSer extends BaseManagerImp<ZlXmzljh, Integer> {

    static final Logger logger = LoggerFactory.getLogger(ZlXmzljhSer.class);

    @Autowired
    private ZlXmzljhDao zlXmzljhDao;
    @Autowired
    private RedisFactory redisFactory;

    @Override
    public ZlXmzljhDao getEntityMapper() {
        return zlXmzljhDao;
    }

    /**
     * 项目治疗计划编辑
     *
     * @param zlXmzljhUpdate
     * @return
     */
    public ReturnEntity<String> edit(ZlXmzljhUpdateReq zlXmzljhUpdate, SysUser user) {
        ZlXmzljh zlXmzljh = new ZlXmzljh();
        BeanUtils.copyProperties(zlXmzljhUpdate, zlXmzljh);
        zlXmzljh.setJgid(user.getHospitalId());
        if (zlXmzljh.getJlxh() == null || zlXmzljh.getJlxh() == 0) {
            zlXmzljh.setJlxh(redisFactory.getTableKey(TableName.DB_NAME, TableName.ZL_XMZLJH));
            if (zlXmzljh.getPxh() == null) {
                zlXmzljh.setPxh(zlXmzljhDao.queryMaxPxh(zlXmzljh) + 1);
            }
            zlXmzljhDao.insert(zlXmzljh);
        } else {
            zlXmzljhDao.update(zlXmzljh);
        }
        return ReturnEntityUtil.success();
    }

    /**
     * 项目治疗计划查询
     *
     * @param xmjlxh 治疗项目主键
     */
    public ZlXmzljh getByXmjlxh(Integer xmjlxh) {
        ZlXmzljh query = new ZlXmzljh();
        query.setZlxmJlxh(xmjlxh);
        List<ZlXmzljh> list = zlXmzljhDao.findByEntity(query);
        if (CollectionUtil.isNotEmpty(list)) {
            return list.get(0);
        }
        return null;
    }
}
