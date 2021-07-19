package com.buit.his.treatment.service;


import cn.hutool.core.collection.CollectionUtil;
import com.buit.commons.BaseManagerImp;
import com.buit.constans.TableName;
import com.buit.his.treatment.dao.ZlZlpcDao;
import com.buit.his.treatment.model.ZlRwmb;
import com.buit.his.treatment.model.ZlZljl;
import com.buit.his.treatment.model.ZlZlpc;
import com.buit.his.treatment.response.ZlRwmbResp;
import com.buit.utill.RedisFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Set;

/**
 * @author jiangwei
 * @Date 2021-21-22
 */
@Service
public class ZlZlpcSer extends BaseManagerImp<ZlZlpc, Integer> {

    static final Logger logger = LoggerFactory.getLogger(ZlZlpcSer.class);

    @Autowired
    private ZlZlpcDao zlZlpcDao;
    @Autowired
    private RedisFactory redisFactory;

    @Override
    public ZlZlpcDao getEntityMapper() {
        return zlZlpcDao;
    }


    /**
     * 查询已存在的批次
     *
     * @param zlsdm 治疗师代码
     * @param zxrq  执行日期
     */
    public List<ZlZlpc> getExistsOfDate(Integer zlsdm, String zxrq) {
        ZlZlpc query = new ZlZlpc();
        query.setZlsdm(zlsdm);
        query.setZlrq(zxrq);
        return zlZlpcDao.findByEntity(query);
    }

    /**
     * 生成治疗批次
     *
     * @param newRwmb
     * @param zlksdm
     * @param zxrq
     */
    public ZlZlpc create(ZlRwmb newRwmb, Integer zlksdm, String zxrq) {
        //当天该治疗师所有批次
        List<ZlZlpc> exists = getExistsOfDate(newRwmb.getZxgh(), zxrq);
        if (CollectionUtil.isNotEmpty(exists)) {
            //判断是否有冲突
            for (ZlZlpc entry : exists) {
                if (entry.getJssj().compareTo(newRwmb.getKssj()) <= 0 || entry.getKssj().compareTo(newRwmb.getJssj()) >= 0) {
                    //结束时间比此时间段的开始时间还小，或者开始时间比此时间段的结束时间还大，则不冲突
                    continue;
                } else if (entry.getKssj().compareTo(newRwmb.getKssj()) == 0 && entry.getJssj().compareTo(newRwmb.getJssj()) == 0) {
                    //开始时间，结束时间完全相同，为同一批次
                    return entry;
                    //                2021-05-06 取消同一治疗师多病人或者多任务时间段的冲突验证
//                } else {
//                    //有冲突
//                    throw BaseException.create("ERROR_ZL_00024", new String[]{zxrq});
                }
            }
        }
        ZlZlpc zlpc = new ZlZlpc();
        zlpc.setJlxh(redisFactory.getTableKey(TableName.DB_NAME, TableName.ZL_ZLPC));
        zlpc.setKssj(newRwmb.getKssj());
        zlpc.setJssj(newRwmb.getJssj());
        zlpc.setZlrq(zxrq);
        zlpc.setZlsdm(newRwmb.getZxgh());
        zlpc.setZyh(newRwmb.getZyh());
        zlpc.setZlksdm(zlksdm);
        zlpc.setSjkssj(newRwmb.getKssj());
        zlpc.setSjjssj(newRwmb.getJssj());
        zlZlpcDao.insert(zlpc);
        return zlpc;
    }

    /**
     * 生成治疗批次
     */
    @Transactional(rollbackFor = Exception.class)
    public ZlZlpc create(ZlRwmbResp rwmbResp, String zxrq, String kssj, String jssj) {

        //当天该治疗师所有批次
        List<ZlZlpc> exists = getExistsOfDate(rwmbResp.getZxgh(), zxrq);
        if (CollectionUtil.isNotEmpty(exists)) {
            //判断是否有冲突
            for (ZlZlpc entry : exists) {
                if (entry.getJssj().compareTo(kssj) <= 0 || entry.getKssj().compareTo(jssj) >= 0) {
                    //结束时间比此时间段的开始时间还小，或者开始时间比此时间段的结束时间还大，则不冲突
                    continue;
                } else if (entry.getKssj().compareTo(kssj) == 0 && entry.getJssj().compareTo(jssj) == 0) {
                    //开始时间，结束时间完全相同，为同一批次
                    return entry;
//                2021-05-06 取消同一治疗师多病人或者多任务时间段的冲突验证
//                } else {
//                    //有冲突
//                    throw BaseException.create("ERROR_ZL_00024", new String[]{zxrq});
                }
            }
        }
        ZlZlpc zlpc = new ZlZlpc();
        zlpc.setJlxh(redisFactory.getTableKey(TableName.DB_NAME, TableName.ZL_ZLPC));
        zlpc.setKssj(kssj);
        zlpc.setJssj(jssj);
        zlpc.setZlrq(zxrq);
        zlpc.setZlsdm(rwmbResp.getZxgh());
        zlpc.setZyh(rwmbResp.getZyh());
        zlpc.setZlksdm(rwmbResp.getZlksdm());
        zlpc.setSjkssj(kssj);
        zlpc.setSjjssj(jssj);
        zlZlpcDao.insert(zlpc);
        return zlpc;
    }

    /**
     * 修改非空属性
     */
    public void updateByEntity(ZlZlpc pc) {
        zlZlpcDao.updateByEntity(pc);
    }

    /**
     * 治疗批次批量删除(只删除没有关联子任务的批次)
     */
    public void batchRemove(Set<Integer> zlpcIds) {
        zlZlpcDao.batchRemove(zlpcIds);
    }

    /**
     * 根据治疗记录查询治疗批次
     *
     * @param zljl
     */
    public List<ZlZlpc> findByZljl(ZlZljl zljl) {
        return zlZlpcDao.findByZljl(zljl);
    }

    /**
     * 刪除批次(如果沒有子任务关联)
     *
     * @param zlpcJlxh
     */
    public void removeIfNotAppointed(Integer zlpcJlxh) {
        zlZlpcDao.removeIfNotAppointed(zlpcJlxh);
    }
}
