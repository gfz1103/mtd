package com.buit.his.op.queuing.service;


import com.buit.commons.BaseException;
import com.buit.commons.BaseManagerImp;
import com.buit.constans.TableName;
import com.buit.his.op.queuing.dao.OpFwtxxDao;
import com.buit.his.op.queuing.model.OpFwtxx;
import com.buit.his.op.queuing.request.OpFwtxxAddReq;
import com.buit.his.op.queuing.request.OpFwtxxEditReq;
import com.buit.utill.DateUtil;
import com.buit.utill.RedisFactory;
import com.buit.utill.WubiUtils;
import com.buit.utill.pinyin.PinYinHelper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * 服务台信息<br>
 * @author 老花生
 */
@Service
public class OpFwtxxSer extends BaseManagerImp<OpFwtxx,Integer> {

    static final Logger logger = LoggerFactory.getLogger(OpFwtxxSer.class);

    @Autowired
    private OpFwtxxDao opFwtxxDao;
    @Autowired
    private RedisFactory redisFactory;

    @Override
    public OpFwtxxDao getEntityMapper(){
        return opFwtxxDao;
    }

    /**
     * @name: updateFwt
     * @description: 更新服务台信息
     * @param opFwtxx
     * @return: void
     * @date: 2020/9/1 15:38
     * @auther: 老花生
     *
     */
    public void updateFwt(OpFwtxxEditReq opFwtxx) {
        opFwtxx.setPydm(PinYinHelper.getInstance().getSimplePinYin(opFwtxx.getZsmc()));
        opFwtxx.setWbdm(WubiUtils.getSimpleWuBi(opFwtxx.getZsmc()));
        opFwtxx.setGxsj(DateUtil.getCurrentTimestamp());
        opFwtxxDao.update(opFwtxx);
    }

    /**
     * @name: insertFwt
     * @description: 新增服务台信息
     * @param opFwtxx
     * @return: void
     * @date: 2020/9/1 15:43
     * @auther: 朱智
     *
     */
    public void insertFwt(OpFwtxxAddReq opFwtxx) {
        opFwtxx.setRid(redisFactory.getTableKey(TableName.DB_NAME,TableName.OP_FWTXX));
        opFwtxx.setBbh(1);
        opFwtxx.setCjsj(DateUtil.getCurrentTimestamp());
        opFwtxx.setGxsj(DateUtil.getCurrentTimestamp());
        opFwtxx.setLx("1");
        opFwtxx.setZsdm(opFwtxx.getRid().toString());
        opFwtxx.setSfky("0");
        opFwtxx.setPydm(PinYinHelper.getInstance().getSimplePinYin(opFwtxx.getZsmc()));
        opFwtxx.setWbdm(WubiUtils.getSimpleWuBi(opFwtxx.getZsmc()));
        opFwtxxDao.insert(opFwtxx);
    }

    /**
     * 通过科室名称或者诊室名称查询服务台
     * @param jgid
     * @param condition
     * @return
     */
    public Integer queryFwtIdByKsmcOrZsmc(Integer jgid,String condition){
        return opFwtxxDao.queryFwtIdByKsmcOrZsmc(jgid, condition);
    }
}
