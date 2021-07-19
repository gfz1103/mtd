package com.buit.his.treatment.service;


import com.buit.his.treatment.dao.ZlXmDao;
import com.buit.his.treatment.model.ZlXm;
import com.buit.his.treatment.request.ZlXmReq;
import com.buit.his.treatment.response.ZlXmResp;
import com.buit.commons.BaseException;
import com.buit.commons.BaseManagerImp;
import com.buit.constans.TableName;

import com.buit.utill.PinyinUtils;
import com.buit.utill.RedisFactory;
import com.buit.utill.ReturnEntity;
import com.buit.utill.ReturnEntityUtil;
import com.buit.utill.WubiUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 治疗项目表<br>
 * @author ZHOUHAISHENG
 */
@Service
public class ZlXmSer extends BaseManagerImp<ZlXm,Integer> {

    static final Logger logger = LoggerFactory.getLogger(ZlXmSer.class);

    @Autowired
    private ZlXmDao zlXmDao;

    @Override
    public ZlXmDao getEntityMapper(){
        return zlXmDao;
    }
    @Autowired
    public RedisFactory redisFactory;
    /**
     *新增治疗项目
     * @param zlXm
     * @return
     */
    public ReturnEntity<ZlXmResp> add(ZlXmReq zlXm) {
        //效验治疗项目唯一性
        if(!verifyZlxm(zlXm)){
            throw BaseException.create("ERROR_ZL_00003");
        }
        zlXm.setJlxh(redisFactory.getTableKey(TableName.DB_NAME,TableName.ZL_XM));
        //默认启用状态
        zlXm.setZt("1");
        zlXm.setPydm(PinyinUtils.getSimplePinYin(zlXm.getZlxmmc()));
        zlXm.setWbdm(WubiUtils.getSimpleWuBi(zlXm.getZlxmmc()));


        zlXmDao.insert(zlXm);
        return ReturnEntityUtil.success();

    }

    /**
     * 添加效验治疗项目唯一性
     * @param zlXm
     * @return
     */
    public boolean verifyZlxm(ZlXmReq zlXm){
        ZlXm zlXmparam=new ZlXm();
        BeanUtils.copyProperties(zlXm,zlXmparam);
        List<ZlXm> zlXmList=zlXmDao.findByEntity(zlXmparam);
        if(zlXmList.size()>0){
            return false;
        }
        return true;
    }
    /**
     * 修改效验治疗项目唯一性
     * @param zlXm
     * @return
     */
    public boolean verifyUpdateZlxm(ZlXmReq zlXm){
        ZlXm zlXmparam=new ZlXm();
         BeanUtils.copyProperties(zlXm,zlXmparam);
        List<ZlXm> zlXmList=zlXmDao.verifyUpdateZlxm(zlXmparam);
        if(zlXmList.size()>0){
            return false;
        }
        return true;
    }
    /**
     * 治疗项目修改
     * @param zlXm
     * @return
     */
    public ReturnEntity<ZlXmResp> edit(ZlXmReq zlXm) {
        //效验唯一性
        if(!verifyUpdateZlxm(zlXm)){
            throw BaseException.create("ERROR_ZL_00003");
        }
        zlXm.setPydm(PinyinUtils.getSimplePinYin(zlXm.getZlxmmc()));
        zlXm.setWbdm(WubiUtils.getSimpleWuBi(zlXm.getZlxmmc()));
        zlXmDao.update(zlXm);
        return ReturnEntityUtil.success();
    }

    /**
     * 治疗项目删除
     * @param jlxh
     * @return
     */
    public ReturnEntity delete(Integer jlxh) {
        //删除前效验
        ZlXm zlXm=zlXmDao.getById(jlxh);
        if("1".equals(zlXm.getZt())){
            throw  BaseException.create("ERROR_ZL_00004");
        }
        //判断该项目是否已经使用过了
        // TODO: 2021/1/20

        zlXmDao.deleteById(jlxh);
        return ReturnEntityUtil.success();
    }

    /**
     * 修改治疗项目状态
     * @param jlxh
     * @return
     */
    public ReturnEntity updateZt(Integer jlxh,String zt) {
       ZlXm zlXm=new ZlXm();
        zlXm.setJlxh(jlxh);
        zlXm.setZt(zt);
        zlXmDao.update(zlXm);
       return ReturnEntityUtil.success();

    }
}
