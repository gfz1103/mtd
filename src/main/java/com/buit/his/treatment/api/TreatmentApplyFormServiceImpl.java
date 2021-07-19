package com.buit.his.treatment.api;

import cn.hutool.core.collection.CollUtil;
import com.buit.his.treatment.dao.ZlSqdmxDao;
import com.buit.his.treatment.dao.ZlSqdsfmxDao;
import com.buit.his.treatment.dao.ZlSqdxmzlnrDao;
import com.buit.his.treatment.dao.ZlXmzljhDao;
import com.buit.his.treatment.model.ZlSqdmx;
import com.buit.his.treatment.service.TreatmentApplyFormService;
import com.buit.his.treatment.service.ZlSqdmxSer;
import com.buit.his.treatment.service.ZlSqdzbSer;
import com.buit.his.treatment.service.ZlSqdzdSer;
import org.apache.dubbo.config.annotation.DubboService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

/**
 * @Description 康复治疗任务相关（处置状态改变后调用）
 * @Author jiangwei
 * @Date 2021-04-14
 */
@DubboService(timeout = 10000)
public class TreatmentApplyFormServiceImpl implements TreatmentApplyFormService {
    static final Logger logger = LoggerFactory.getLogger(TreatmentApplyFormServiceImpl.class);

    @Autowired
    private ZlSqdzbSer zlSqdzbSer;
    @Autowired
    private ZlSqdzdSer zlSqdzdSer;
    @Autowired
    private ZlSqdmxSer zlSqdmxSer;
    @Autowired
    private ZlSqdmxDao zlSqdmxDao;
    @Autowired
    private ZlSqdxmzlnrDao zlSqdxmzlnrDao;
    @Autowired
    private ZlSqdsfmxDao zlSqdsfmxDao;

    /**
     * 处置删除（门诊医生删除治疗申请单关联处置时调用）
     *
     * @param jlxh 申请单记录序号
     * @param xmJlxh 申请单明细项目记录序号
     */
    @Override
    public void delete(Integer jlxh,Integer xmJlxh) {
        if (jlxh == null){
            logger.error("jlxh为空，无法删除康复申请单数据");
            return;
        }
        // TODO: 2021/4/20 此处是否需要校验项目已经被执行

        if (xmJlxh == null){//删除整个申请单
            //删除治疗申请单主表
            zlSqdzbSer.removeById(jlxh);
            //删除治疗申请单诊断
            zlSqdzdSer.deleteBySqdh(jlxh);
            //删除治疗计划
            zlSqdxmzlnrDao.deleteByZlSqdmxJlxh(jlxh);
            //删除治疗申请单收费明细(通过主表的jlxh直接删除)
            zlSqdsfmxDao.deleteByJlxh(jlxh);
            //删除治疗申请单明细
            zlSqdmxSer.deleteBySqdh(jlxh);
        }else {//删除单个项目
            //删除治疗计划
            zlSqdxmzlnrDao.deleteByZlSqdmxJlxh(xmJlxh);
            //删除单个治疗项目明细
            zlSqdsfmxDao.deleteBySfxmmxJlxh(xmJlxh);
            //删除治疗申请单明细（必须放最后）
            zlSqdmxDao.deleteById(xmJlxh);
            //判断申请单下是否还存在其他项目,不存在删除整个申请单
            int sqdmx = zlSqdmxDao.selectCountSqdmx(jlxh);
            if (sqdmx == 0){
                //删除治疗申请单主表
                zlSqdzbSer.removeById(jlxh);
                //删除治疗申请单诊断
                zlSqdzdSer.deleteBySqdh(jlxh);
            }
        }
    }


    /**
     * 申请单作废（门诊医生删除治疗申请单关联处置时调用）
     *
     * @param jlxh 申请单记录序号
     */
    @Override
    public void cancel(Integer jlxh, Integer zfgh) {
        zlSqdzbSer.cancel(jlxh, zfgh);
    }

    /**
     * 修改申请单发票号码 （门诊挂号收费后调用）
     *
     * @param jlxh 申请单记录序号
     * @param fphm 发票号码t
     */
    @Override
    public void payBill(Integer jlxh, String fphm) {
        zlSqdzbSer.updateFphm(jlxh, fphm);
    }


}
