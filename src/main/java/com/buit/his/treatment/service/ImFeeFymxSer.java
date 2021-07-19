package com.buit.his.treatment.service;

import com.buit.commons.BaseManagerImp;
import com.buit.his.sams.dao.ImFeeFymxDao;
import com.buit.his.sams.enums.FymxYplxEnum;
import com.buit.his.sams.enums.JzlxEnum;
import com.buit.his.sams.model.ImFeeFymx;
import com.buit.his.treatment.response.RwfpFymxResp;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;

@Service
public class ImFeeFymxSer extends BaseManagerImp<ImFeeFymx, Integer> {
    static final Logger logger = LoggerFactory.getLogger(ImFeeFymxSer.class);

    @Autowired
    private ImFeeFymxDao imFeeFymxDao;


    @Override
    public ImFeeFymxDao getEntityMapper() {
        return imFeeFymxDao;
    }

    /**
     * 为执行的康复任务创建住院费用明细
     *
     * @param zlrwfpId 治疗任务主键
     */
    public ImFeeFymx createZlRwfpFymx(Integer zlrwfpId) {
        RwfpFymxResp resp = imFeeFymxDao.createZlRwfpFymx(zlrwfpId);
        ImFeeFymx fymx = new ImFeeFymx();
        BeanUtils.copyProperties(resp, fymx);

        fymx.setZfbl(resp.getRealZfbl());
        fymx.setZfje(resp.getZjje().multiply(fymx.getZfbl()));
        fymx.setYpcd(0);
        fymx.setXmlx(JzlxEnum.RECOVERY.getValue());
        fymx.setYplx(FymxYplxEnum.NOT_MEDICINE.getValue());
        fymx.setJscs(0);
        fymx.setZlje(BigDecimal.ZERO);
        fymx.setDzbl(BigDecimal.ZERO);
        return fymx;
    }

    /**
     * 批量插入
     */
    public void batchInsert(List<ImFeeFymx> list) {
        imFeeFymxDao.batchInsert(list);
    }
}
