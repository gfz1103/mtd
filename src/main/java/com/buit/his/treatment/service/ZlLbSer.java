package com.buit.his.treatment.service;


import com.buit.commons.BaseException;
import com.buit.commons.BaseManagerImp;
import com.buit.constans.TableName;
import com.buit.his.treatment.dao.ZlLbDao;
import com.buit.his.treatment.dao.ZlXmDao;
import com.buit.his.treatment.model.ZlLb;
import com.buit.his.treatment.model.ZlXm;
import com.buit.utill.RedisFactory;
import com.buit.utill.ReturnEntity;
import com.buit.utill.ReturnEntityUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 治疗类别表<br>
 *
 * @author ZHOUHAISHENG
 */
@Service
public class ZlLbSer extends BaseManagerImp<ZlLb, Integer> {

    static final Logger logger = LoggerFactory.getLogger(ZlLbSer.class);

    @Autowired
    private ZlLbDao zlLbDao;
    @Autowired
    private ZlXmDao zlXmDao;

    @Override
    public ZlLbDao getEntityMapper() {
        return zlLbDao;
    }

    @Autowired
    public RedisFactory redisFactory;

    /**
     * 治疗类别新增
     */
    public ReturnEntity add(ZlLb zlLb) {
        //验证唯一性
        if (!verifyZllb(zlLb)) {
            throw BaseException.create("errorCode.ERROR_ZL_00001");
        }
        zlLb.setJlxh(redisFactory.getTableKey(TableName.DB_NAME, TableName.ZL_LB));
        if (zlLb.getPxh() == null) {
            zlLb.setPxh(zlLbDao.queryMaxPxh(zlLb) + 1);
        }
        zlLbDao.insert(zlLb);
        return ReturnEntityUtil.success();

    }

    /**
     * 添加效验治疗类别的唯一性
     */
    public boolean verifyZllb(ZlLb zllb) {
        List<ZlLb> zlLbList = zlLbDao.findByEntity(zllb);
        if (zlLbList.size() > 0) {
            return false;
        }
        return true;
    }

    /**
     * 修改效验治疗类别的唯一性
     */
    public boolean verifyUpdateZllb(ZlLb zllb) {
        List<ZlLb> zlLbList = zlLbDao.verifyUpdateZllb(zllb);
        if (zlLbList.size() > 0) {
            return false;
        }
        return true;
    }

    /**
     * 修改治疗类别
     *
     * @param zlLb
     * @return
     */
    public ReturnEntity updateZllb(ZlLb zlLb) {
        //验证唯一性
        if (!verifyUpdateZllb(zlLb)) {
            throw BaseException.create("errorCode.ERROR_ZL_00001");
        }
        zlLbDao.update(zlLb);
        return ReturnEntityUtil.success();
    }

    /**
     * 参数治疗类别
     * 治疗类别下存在治疗项目，则不能删除
     *
     * @param zlLb
     * @return
     */
    public ReturnEntity delete(ZlLb zlLb) {
        ZlXm zlXm = new ZlXm();
        zlXm.setJgid(zlLb.getJgid());
        zlXm.setLbmc(zlLb.getLbmc());
        zlXm.setZlksdm(zlLb.getZlksdm());

        List<ZlXm> zlXmList = zlXmDao.findByEntity(zlXm);
        if (zlXmList.size() > 0) {
            throw BaseException.create("ERROR_ZL_00002");
        }
        zlLbDao.removeByEntity(zlLb);
        return ReturnEntityUtil.success();
    }
}
