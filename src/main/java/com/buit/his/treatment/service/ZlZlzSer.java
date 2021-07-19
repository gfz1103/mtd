package com.buit.his.treatment.service;


import com.buit.commons.BaseException;
import com.buit.commons.BaseManagerImp;
import com.buit.constans.TableName;
import com.buit.his.treatment.dao.ZlZlzDao;
import com.buit.his.treatment.model.ZlZlz;
import com.buit.his.treatment.request.ZlZlzAddReq;
import com.buit.his.treatment.request.ZlZlzEditReq;
import com.buit.his.treatment.request.ZlZlzQueryReq;
import com.buit.his.treatment.status.TreatmentCode;
import com.buit.utill.RedisFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * 治疗小组表<br>
 *
 * @author 韦靖
 */
@Service
public class ZlZlzSer extends BaseManagerImp<ZlZlz, Integer> {

    static final Logger logger = LoggerFactory.getLogger(ZlZlzSer.class);

    @Autowired
    private ZlZlzDao zlZlzDao;

    @Autowired
    public RedisFactory redisFactory;

    @Override
    public ZlZlzDao getEntityMapper() {
        return zlZlzDao;
    }


    /**
     * 新增诊疗小组
     *
     * @param req
     */
    public Integer add(ZlZlzAddReq req) {
        ZlZlz entry = new ZlZlz();
        BeanUtils.copyProperties(req, entry);
        //同一类别的小组名称不重复
        if (verifyZllbForAdd(entry)) {
            throw BaseException.create("ERROR_ZL_00008");
        }
        entry.setZlzid(redisFactory.getTableKey(TableName.DB_NAME, TableName.ZL_ZLZ));
        entry.setZt(TreatmentCode.zt.ENABLE.getCode());
        zlZlzDao.insert(entry);
        return entry.getZlzid();
    }

    /**
     * 修改诊疗小组
     *
     * @param zlzEdit
     */
    public void edit(ZlZlzEditReq zlzEdit) {
        //同一类别的小组名称不重复
        if (verifyZllbForUpd(zlzEdit)) {
            throw BaseException.create("ERROR_ZL_00008");
        }
        //修改
        zlZlzDao.update(zlzEdit);
    }

    /**
     * 通过小组的id 删除小组
     *
     * @param zlzid
     */
    public void deleteZLZ(Integer zlzid) {
        // TODO: 2021/1/20
        //必须先停用才能删除
        //校验小组是否已经使用过了

        //删除
        zlZlzDao.deleteById(zlzid);
    }

    /**
     * 通过主键修改状态
     *
     * @param zlzid
     * @param zt
     */
    public void updateZt(Integer zlzid, String zt) {
        zlZlzDao.updateZtByZlzid(zlzid, zt);
    }

    /**
     * （新增时）校验同一小组的组名唯一性
     *
     * @param zlZlz
     * @return
     */
    private boolean verifyZllbForAdd(ZlZlz zlZlz) {
        int data = zlZlzDao.queryByzmcAndzllbForAdd(zlZlz.getZlzmc(), zlZlz.getZllb(), zlZlz.getJgid());
        if (data > 0) {
            return true;
        }
        return false;
    }

    private boolean verifyZllbForUpd(ZlZlzEditReq zlZlz) {
        int data = zlZlzDao.queryByzmcAndzllbForUpd(zlZlz.getZlzmc(), zlZlz.getZllb(), zlZlz.getJgid(), zlZlz.getZlzid());
        if (data > 0) {
            return true;
        }
        return false;
    }
}
