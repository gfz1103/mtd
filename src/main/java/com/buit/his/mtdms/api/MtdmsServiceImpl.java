package com.buit.his.mtdms.api;

import cn.hutool.core.bean.BeanUtil;
import cn.hutool.core.date.DateUtil;
import com.buit.cis.im.request.ImFeeFymxReq;
import com.buit.cis.im.response.ImFeeFymxYjModel;
import com.buit.cis.im.service.ImFeeFymxService;
import com.buit.cis.im.service.ImFeeFymxYjService;
import com.buit.cis.im.service.ImZyjsService;
import com.buit.constans.TableName;
import com.buit.his.mtdms.dao.OpYjzxDao;
import com.buit.his.mtdms.enums.DoEnum;
import com.buit.his.mtdms.enums.LxEnum;
import com.buit.his.mtdms.enums.YjzxztEnum;
import com.buit.his.mtdms.model.MtdmsJc;
import com.buit.his.mtdms.model.MtdmsSqd;
import com.buit.his.mtdms.response.RespMessage;
import com.buit.his.mtdms.service.MtdmsService;
import com.buit.his.treatment.dao.CisHzyzDao;
import com.buit.his.treatment.enums.JcztEnum;
import com.buit.op.service.OpYjcf02Service;
import com.buit.utill.RedisFactory;
import org.apache.dubbo.config.annotation.DubboReference;
import org.apache.dubbo.config.annotation.DubboService;
import org.springframework.beans.factory.annotation.Autowired;

import java.math.BigDecimal;
import java.sql.Timestamp;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@DubboService(timeout = 10000)
public class MtdmsServiceImpl implements MtdmsService {


    @Autowired
    private OpYjzxDao opYjzxDao;
    @DubboReference
    private OpYjcf02Service opYjcf02Service;
    @DubboReference
    private ImFeeFymxYjService imFeeFymxYjService;
    @DubboReference
    private ImFeeFymxService imFeeFymxService;
    @DubboReference
    private ImZyjsService imZyjsService;

    @Autowired
    private RedisFactory redisFactory;
    @Autowired
    private CisHzyzDao cisHzyzDao;

    /**
     * 检验取消执行
     *
     * @param mtdmsSqd
     * @return
     */
    @Override
    public RespMessage requestStateExec(MtdmsSqd mtdmsSqd) {
        try {
            //门诊
            if ("1".equals(mtdmsSqd.getType())) {
                //查询医技处方明细的sbxh
                List<Integer> list = opYjzxDao.selectCf02Xhlist(mtdmsSqd.getRequest_no());
                for (Integer sbxh : list) {
                    Map<String, Object> map = new HashMap<>();
                    map.put("zxzt", YjzxztEnum.WZX.getCode());
                    map.put("zxcs", 0);
                    map.put("sbxh", sbxh);
                    opYjcf02Service.updateZxztAndZxcs(map);
                }
            } else {
                //住院
                //查询医嘱表里的JLXH
                List<Integer> list = opYjzxDao.selectyzlist(mtdmsSqd.getRequest_no(), mtdmsSqd.getRequestdetail_no());
                for (Integer integer : list) {
                    Map<String, Object> map = new HashMap<String, Object>();
                    map.put("zxzt", YjzxztEnum.WZX.getCode());
                    map.put("zxcs", 0);
                    map.put("yzxh", integer);
                    imFeeFymxYjService.updateZxztAndZxcs(map);
                    ImFeeFymxYjModel imFeeFymxYj = imFeeFymxYjService.doQueryByYzxh(integer);
                    ImFeeFymxReq imFeeFymx = new ImFeeFymxReq();
                    BeanUtil.copyProperties(imFeeFymxYj, imFeeFymx);
                    imFeeFymx.setJlxh(redisFactory.getTableKey(TableName.DB_NAME, TableName.IM_FEE_FYMX));
                    imFeeFymx.setFysl(imFeeFymx.getFysl().multiply(new BigDecimal(-1)));
                    imFeeFymx.setZjje(imFeeFymx.getZjje().multiply(new BigDecimal(-1)));
                    imFeeFymx.setZfje(imFeeFymx.getZfje().multiply(new BigDecimal(-1)));
                    imFeeFymx.setJfrq(DateUtil.date().toTimestamp());
                    imFeeFymxService.insert(imFeeFymx);
                }
            }
        } catch (Exception e
        ) {
            return new RespMessage("1", "确认失败" + e.getMessage());
        }

        return new RespMessage("0", "更新成功");
    }

    /**
     * 检验确认执行
     *
     * @param mtdmsSqd
     * @return
     */
    @Override
    public RespMessage requestStateFinish(MtdmsSqd mtdmsSqd) {
        try {  //门诊
            Map<String, Object> map = new HashMap<String, Object>();
            map.put("zxrq", mtdmsSqd.getDate());
            map.put("zxys", mtdmsSqd.getDoctor());
            if ("1".equals(mtdmsSqd.getType())) {
                //查询医技处方明细的sbxh
                List<Integer> list = opYjzxDao.selectCf02Xhlist(mtdmsSqd.getRequest_no());
                //改状态为全部执行
                for (Integer sbxh : list) {
                    map.put("zxzt", YjzxztEnum.QBZX.getCode());
                    map.put("zxcs", 1);
                    map.put("sbxh", sbxh);
                    opYjcf02Service.updateZxztAndZxcs(map);
                }
            } else {
                //住院
                //查询医嘱表里的JLXH
                List<Integer> list = opYjzxDao.selectyzsqdlist(mtdmsSqd.getRequest_no());
                for (Integer integer : list) {
                    map.put("zxzt", YjzxztEnum.QBZX.getCode());
                    map.put("zxcs", 1);
                    map.put("yzxh", integer);
                    imFeeFymxYjService.updateZxztAndZxcs(map);
                }
            }
        } catch (Exception e
        ) {
            return new RespMessage("1", "更新失败" + e.getMessage());
        }

        return new RespMessage("0", "更新成功");
    }

    /**
     * 检验住院医嘱确费
     *
     * @param mtdmsSqd
     * @return
     */
    @Override
    public RespMessage feeStatus(MtdmsSqd mtdmsSqd) {
        try {
            List<Integer> list = opYjzxDao.selectyzsqdlist(mtdmsSqd.getRequest_no());
            for (Integer integer : list) {
                Map<String, Object> map = new HashMap<String, Object>();
                map.put("zxzt", YjzxztEnum.QBZX.getCode());
                map.put("zxcs", 1);
                map.put("yzxh", integer);
                imFeeFymxYjService.updateZxztAndZxcs(map);
                ImFeeFymxYjModel imFeeFymxYj = imFeeFymxYjService.doQueryByYzxh(integer);
                if (imFeeFymxYj != null) {
                    long cnt = opYjzxDao.queryFymxCountByYzxh(integer);
                    if(cnt > 0){
                    }else{
                        boolean isValid = imZyjsService.validFyrq(imFeeFymxYj.getZyh(), imFeeFymxYj.getFyrq());
                        if(isValid){
                            ImFeeFymxReq imFeeFymx = new ImFeeFymxReq();
                            BeanUtil.copyProperties(imFeeFymxYj, imFeeFymx);
                            imFeeFymx.setJlxh(redisFactory.getTableKey(TableName.DB_NAME, TableName.IM_FEE_FYMX));
                            imFeeFymx.setJfrq(DateUtil.date().toTimestamp());
                            imFeeFymxService.insert(imFeeFymx);
                        }
                    }
                }
            }
            cisHzyzDao.updateJcztByJlxh(JcztEnum.FEE.getValue(), Integer.valueOf(mtdmsSqd.getRequest_no()));
        } catch (Exception e) {
            return new RespMessage("1", "计费失败" + e.getMessage());
        }
        return new RespMessage("0", "计费成功");
    }

    /**
     * 检查
     * 门诊 确认取消检查状态
     *
     * @param spd
     * @return
     */
    @Override
    public Boolean risHisIsChargeUp(MtdmsJc spd) {
        try {
            if (DoEnum.QR.getCode().equals(spd.getFlag())) {
                opYjzxDao.updateJxsqStatus(spd.getStudy_id(), 3);
            } else {
                opYjzxDao.updateJxsqStatus(spd.getStudy_id(), 1);
            }

            //1门诊 2 住院
            Integer type = opYjzxDao.selectSqdLx(spd.getStudy_id());
            Map<String, Object> map = new HashMap<String, Object>();
            if (type == null) {
                return Boolean.FALSE;
            }
            if (type == LxEnum.MZ.getCode()) {
                List<Integer> list = opYjzxDao.selectOpJcList(spd.getStudy_id(), spd.getChkit_id());
                //1确认 0取消
                if (DoEnum.QR.getCode().equals(spd.getFlag())) {
                    // 执行次数全部改为1，状态为全部执行
                    for (Integer sbxh : list) {
                        map.put("zxzt", YjzxztEnum.QBZX.getCode());
                        map.put("zxcs", 1);
                        map.put("sbxh", sbxh);
                        opYjcf02Service.updateZxztAndZxcs(map);
                    }
                } else {
                    //执行次数全部改为0，状态为未执行
                    for (Integer sbxh : list) {
                        map.put("zxzt", YjzxztEnum.WZX.getCode());
                        map.put("zxcs", 0);
                        map.put("sbxh", sbxh);
                        opYjcf02Service.updateZxztAndZxcs(map);
                    }
                }
            } else {
                List<Integer> list = opYjzxDao.selectImJcList(spd.getStudy_id(), spd.getChkit_id());
                //确认
                if (DoEnum.QR.getCode().equals(spd.getFlag())) {
                    for (Integer integer : list) {
                        map.put("zxzt", YjzxztEnum.QBZX.getCode());
                        map.put("zxcs", 1);
                        map.put("yzxh", integer);
                        imFeeFymxYjService.updateZxztAndZxcs(map);
                        //计费
                        ImFeeFymxYjModel imFeeFymxYj = imFeeFymxYjService.doQueryByYzxh(integer);
                        if (imFeeFymxYj != null) {
//                            Timestamp lastZyjsSj = imZyjsService.getLastZyjsSj(imFeeFymxYj.getZyh());
//                            if (imFeeFymxYj.getJfrq().getTime() < lastZyjsSj.getTime()) {
                            // 记账明细
                            long cnt = opYjzxDao.queryFymxCountByYzxh(integer);
                            if(cnt > 0){
                            }else {
                                ImFeeFymxReq imFeeFymx = new ImFeeFymxReq();
                                BeanUtil.copyProperties(imFeeFymxYj, imFeeFymx);
                                imFeeFymx.setJlxh(redisFactory.getTableKey(TableName.DB_NAME, TableName.IM_FEE_FYMX));
                                imFeeFymx.setJfrq(DateUtil.date().toTimestamp());
                                imFeeFymxService.insert(imFeeFymx);
                            }
//                            }
                        }
                    }
                    cisHzyzDao.updateJcztBySqid(JcztEnum.FEE.getValue(),Integer.valueOf(spd.getStudy_id()), Integer.valueOf(spd.getChkit_id()));
                } else {
                    //取消
                    for (Integer integer : list) {
                        map.put("zxzt", YjzxztEnum.QXZX.getCode());
                        map.put("zxcs", 0);
                        map.put("yzxh", integer);
                        imFeeFymxYjService.updateZxztAndZxcs(map);
                        //记负的费用
                        BigDecimal fy = opYjzxDao.queryFymxByYzxh(integer);
                        if(fy.compareTo(BigDecimal.ZERO)>0) {
                            ImFeeFymxYjModel imFeeFymxYj = imFeeFymxYjService.doQueryByYzxh(integer);
                            ImFeeFymxReq imFeeFymx = new ImFeeFymxReq();
                            BeanUtil.copyProperties(imFeeFymxYj, imFeeFymx);
                            imFeeFymx.setJlxh(redisFactory.getTableKey(TableName.DB_NAME, TableName.IM_FEE_FYMX));
                            imFeeFymx.setFysl(imFeeFymx.getFysl().multiply(new BigDecimal(-1)));
                            imFeeFymx.setZjje(imFeeFymx.getZjje().multiply(new BigDecimal(-1)));
                            imFeeFymx.setZfje(imFeeFymx.getZfje().multiply(new BigDecimal(-1)));
                            imFeeFymx.setJfrq(DateUtil.date().toTimestamp());
                            imFeeFymxService.insert(imFeeFymx);
                        }
                    }
                    cisHzyzDao.updateJcztBySqid(JcztEnum.BACK.getValue(),Integer.valueOf(spd.getStudy_id()), Integer.valueOf(spd.getChkit_id()));
                }

            }
        } catch (Exception e) {
            return Boolean.FALSE;
        }
        return Boolean.TRUE;
    }

    @Override
    public RespMessage FeeStatus_Back(MtdmsSqd mtdmsSqd) {
        try {  //查询医嘱表里的JLXH
            List<Integer> list = opYjzxDao.selectyzsqdlist(mtdmsSqd.getRequest_no());
            for (Integer integer : list) {
//                Map<String, Object> map = new HashMap<String, Object>();
//                map.put("zxzt", YjzxztEnum.WZX.getCode());
//                map.put("zxcs", 0);
//                map.put("yzxh", integer);
//                imFeeFymxYjService.updateZxztAndZxcs(map);
                BigDecimal fy = opYjzxDao.queryFymxByYzxh(integer);
                if(fy.compareTo(BigDecimal.ZERO)>0){
                    ImFeeFymxYjModel imFeeFymxYj = imFeeFymxYjService.doQueryByYzxh(integer);
                    boolean isValid = imZyjsService.validFyrq(imFeeFymxYj.getZyh(), imFeeFymxYj.getFyrq());
                    if(isValid){
                        ImFeeFymxReq imFeeFymx = new ImFeeFymxReq();
                        BeanUtil.copyProperties(imFeeFymxYj, imFeeFymx);
                        imFeeFymx.setJlxh(redisFactory.getTableKey(TableName.DB_NAME, TableName.IM_FEE_FYMX));
                        imFeeFymx.setFysl(imFeeFymx.getFysl().multiply(new BigDecimal(-1)));
                        imFeeFymx.setZjje(imFeeFymx.getZjje().multiply(new BigDecimal(-1)));
                        imFeeFymx.setZfje(imFeeFymx.getZfje().multiply(new BigDecimal(-1)));
                        imFeeFymx.setJfrq(DateUtil.date().toTimestamp());
                        imFeeFymxService.insert(imFeeFymx);
                    }
                }
            }
            cisHzyzDao.updateJcztByJlxh(JcztEnum.BACK.getValue(), Integer.valueOf(mtdmsSqd.getRequest_no()));
        } catch (Exception e) {
            return new RespMessage("1", "撤销失败" + e.getMessage());
        }
        return new RespMessage("0", "撤销成功" );
    }


}
