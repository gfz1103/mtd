package com.buit.his.treatment.service;


import com.buit.commons.BaseException;
import com.buit.commons.BaseManagerImp;
import com.buit.constans.TableName;
import com.buit.his.treatment.dao.ZlZlzcybDao;
import com.buit.his.treatment.model.ZlZlzcyb;
import com.buit.his.treatment.request.ZlZlzcybReq;
import com.buit.his.treatment.response.ZlZlzcybResp;
import com.buit.his.treatment.response.ZlsMsgResp;
import com.buit.utill.RedisFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

/**
 * 治疗小组成员表<br>
 *
 * @author 韦靖
 */
@Service
public class ZlZlzcybSer extends BaseManagerImp<ZlZlzcyb, Integer> {

    static final Logger logger = LoggerFactory.getLogger(ZlZlzcybSer.class);

    @Autowired
    private ZlZlzcybDao zlZlzcybDao;

    @Autowired
    public RedisFactory redisFactory;

    @Override
    public ZlZlzcybDao getEntityMapper() {
        return zlZlzcybDao;
    }

    /**
     * 通过小组id查询小组成员
     *
     * @param zlzid
     * @return
     */
    public List<ZlZlzcybResp> queryByZlzID(Integer zlzid) {
        return zlZlzcybDao.queryByZlzID(zlzid);
    }

    /**
     * 新增
     *
     * @param zlZlzcyb
     */
    @Transactional(rollbackFor = Exception.class)
    public void save(ZlZlzcybReq zlZlzcyb) {
        //校验同一组不能存在同一个治疗师
        List<ZlZlzcyb> newList = zlZlzcyb.getList();
        Set<Integer> zlsdmList = newList.stream().map(r -> r.getZlsdm()).collect(Collectors.toSet());
        if (newList.size() == zlsdmList.size()) {//去重后长度不变
            //先删
            delete(zlZlzcyb.getZlzid());
            //后增
            for (ZlZlzcyb entry : newList) {
                entry.setJgid(zlZlzcyb.getJgid());
                entry.setZlzid(zlZlzcyb.getZlzid());
                entry.setZlzcyid(redisFactory.getTableKey(TableName.DB_NAME, TableName.ZL_ZLZCYB));
            }
            zlZlzcybDao.batchInsert(newList);
        } else {
            throw BaseException.create("ERROR_ZL_00009");
        }
    }

    /**
     * 删除小组成员
     *
     * @param zlzid 治疗组Id
     */
    public void delete(Integer zlzid) {
        zlZlzcybDao.deleteByZlzId(zlzid);
    }

    /**
     * 查询某个类别下的治疗师列表
     *
     * @param zllb
     * @param jgid
     */
    public List<ZlsMsgResp> queryZlsList(Integer zllb, Integer jgid) {
        return zlZlzcybDao.queryZlsList(zllb, jgid);
    }

}
