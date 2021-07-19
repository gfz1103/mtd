package com.buit.commons.serviceImpl;

import java.util.List;

import org.apache.dubbo.config.annotation.DubboService;
import org.springframework.beans.factory.annotation.Autowired;

import com.buit.his.op.queuing.dao.OpBcsjDao;
import com.buit.his.op.queuing.model.OpBcsj;
import com.buit.his.op.queuing.service.OpBcsjService;
import com.itextpdf.text.pdf.PdfStructTreeController.returnType;

/**
 * @Description 类描述
 * @Author 老花生
 * @Date 2020/10/14 9:43
 */
@DubboService
public class OpBcsjServiceImpl implements OpBcsjService {
	@Autowired
	private OpBcsjDao opBcsjDao;

	public List<OpBcsj> getBcsjInfo(OpBcsj opBcsj) {
		return opBcsjDao.findByEntity(opBcsj);
	}

	public OpBcsj getBySddm(String sddm) {
		return opBcsjDao.getBySddm(sddm);
	}


}
