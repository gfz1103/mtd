package com.buit.his.mtdms.service;

import java.math.BigDecimal;
import java.sql.Timestamp;
import java.util.*;

import cn.hutool.core.collection.CollUtil;
import cn.hutool.core.util.StrUtil;
import com.buit.cis.im.service.ImZyjsService;
import com.buit.commons.BaseException;
import com.buit.his.mtdms.request.QxzfYjzxReq;
import com.buit.system.utill.AgeUtil;
import org.apache.dubbo.config.annotation.DubboReference;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.buit.cis.dctwork.response.CisHzyzModel;
import com.buit.cis.dctwork.service.CisHzyzService;
import com.buit.cis.im.request.ImFeeFymxReq;
import com.buit.cis.im.response.ImFeeFymxYjModel;
import com.buit.cis.im.service.ImFeeFymxService;
import com.buit.cis.im.service.ImFeeFymxYjService;
import com.buit.commons.BaseManagerImp;
import com.buit.constans.TableName;
import com.buit.his.mtdms.dao.OpYjzxDao;
import com.buit.his.mtdms.dao.OpYjzxsfxmDao;
import com.buit.his.mtdms.enums.YjsfxmztEnum;
import com.buit.his.mtdms.enums.YjzxztEnum;
import com.buit.his.mtdms.model.OpYjzx;
import com.buit.his.mtdms.model.OpYjzxsfxm;
import com.buit.his.mtdms.request.CommitYjzxReq;
import com.buit.his.mtdms.request.QueryYjqfListReq;
import com.buit.his.mtdms.request.QueryYjzxqrListReq;
import com.buit.his.mtdms.response.OpyjzxDictResp;
import com.buit.his.mtdms.response.QueryYjqfListResp;
import com.buit.his.mtdms.response.QueryYjzxqrListResp;
import com.buit.his.mtdms.response.QueryYjzxsfxmResp;
import com.buit.his.mtdms.response.QueryYsdmListResp;
import com.buit.op.model.OpYjcf02;
import com.buit.op.service.OpYjcf02Service;
import com.buit.op.service.OpYjcf02ZtService;
import com.buit.system.utill.ObjectToTypes;
import com.buit.utill.ChineseCharacterUtil;
import com.buit.utill.MtdmsUtil;
import com.buit.utill.Param;
import com.buit.utill.RedisFactory;

import cn.hutool.core.bean.BeanUtil;
import cn.hutool.core.date.DateUtil;

/**
 * 医技确费 <br>
 * 
 * @author WY
 */
@Service
public class OpYjzxSer extends BaseManagerImp<OpYjzx, Integer> {

	static final Logger logger = LoggerFactory.getLogger(OpYjzxSer.class);

	@Autowired
	private OpYjzxDao opYjzxDao;

	@DubboReference
	private OpYjcf02ZtService opYjcf02ZtService;

	@Autowired
	private OpYjzxsfxmDao opYjzxsfxmDao;

	@DubboReference
	private OpYjcf02Service opYjcf02Service;

	@DubboReference
	private ImFeeFymxYjService imFeeFymxYjService;

	@DubboReference
	private ImFeeFymxService imFeeFymxService;

	@DubboReference
	private CisHzyzService cisHzyzService;

	@Autowired
	private RedisFactory redisFactory;
	@DubboReference
	private ImZyjsService imZyjsService;

	@Override
	public OpYjzxDao getEntityMapper() {
		return opYjzxDao;
	}

	/**
	 * 医技确费列表-分页
	 *
	 * @param req
	 * @return
	 */
	public List<QueryYjqfListResp> getYjqfList(QueryYjqfListReq req) {
		//时间
		req.setSqsjks(StrUtil.isNotBlank(req.getSqsjks()) ? req.getSqsjks() + " 00:00:00" : null);
		req.setSqsjjs(StrUtil.isNotBlank(req.getSqsjjs()) ? req.getSqsjjs() + " 23:59:59" : null);
		req.setYysjks(StrUtil.isNotBlank(req.getYysjks()) ? req.getYysjks() + " 00:00:00" : null);
		req.setYysjjs(StrUtil.isNotBlank(req.getYysjjs()) ? req.getYysjjs() + " 23:59:59" : null);
		req.setZxsjks(StrUtil.isNotBlank(req.getZxsjks()) ? req.getZxsjks() + " 00:00:00" : null);
		req.setZxsjjs(StrUtil.isNotBlank(req.getZxsjjs()) ? req.getZxsjjs() + " 23:59:59" : null);
		req.setZfsjks(StrUtil.isNotBlank(req.getZfsjks()) ? req.getZfsjks() + " 00:00:00" : null);
		req.setZfsjjs(StrUtil.isNotBlank(req.getZfsjjs()) ? req.getZfsjjs() + " 23:59:59" : null);
		req.setQxzxsjks(StrUtil.isNotBlank(req.getQxzxsjks()) ? req.getQxzxsjks() + " 00:00:00" : null);
		req.setQxzxsjjs(StrUtil.isNotBlank(req.getQxzxsjjs()) ? req.getQxzxsjjs() + " 23:59:59" : null);

		//执行状态
		if (req.getZxzt() != null) {
			//全部
			if("4".equals(req.getZxzt())){
				req.setZxzt("0,1,2,3");
			//未执行
			}else if("0".equals(req.getZxzt())){
				req.setYjzxzt("0");
			}
		}

		//预约状态 默认,全部
		if (req.getYyzt() != null && "2".equals(req.getYyzt())
				|| StrUtil.isNotBlank(req.getYysjks())
				|| StrUtil.isNotBlank(req.getYysjjs())) {
			req.setYyzt("0,1");
		}

		//病人类型
		if(StrUtil.isNotBlank(req.getZyhm())){
			req.setBrlx("2");
		}else{
			if("3".equals(req.getBrlx())){
				req.setBrlx("1,2");
			}
		}

		List<QueryYjqfListResp> list = opYjzxDao.yjqfList(req);

		if(CollUtil.isEmpty(list)){
			return null;
		}

		Date now = new Date();

		for (QueryYjqfListResp resq : list) {
			if(null == resq.getZtbz()){
				resq.setZtbz(0);
			}
			if(null != resq.getCsny()){
				resq.setAge(String.valueOf(AgeUtil.calculateAge(resq.getCsny(), now)));
			}
		}

		//组套
//		if (req.getBrlx().contains("1")
//				&& ("0".equals(req.getZxzt()) || "0,1,2,3,5".equals(req.getZxzt()))) {
//
//			Map<String, Object> ZTYZSBXH = new HashMap<String, Object>();
//			for (QueryYjqfListResp record : list) {
//				if (record.getZtbz() != null && 1 == record.getZtbz()) {
//					if (ZTYZSBXH.containsKey(ObjectToTypes.parseString(record.getZtyzsbxh()))) {
//						continue;
//					}
//					Map<String, Object> parm = Param.instance().put("sbxh", ObjectToTypes.parseLong(record.getZtyzsbxh()));
//					Map<String, Object> ztmcMap = opYjcf02ZtService.getZtBySbxh(parm);
//					if(null == ztmcMap){
//						continue;
//					}
//					record.setXmmc(ztmcMap.get("fymc") != null ? ztmcMap.get("fymc").toString() : "");
//					ZTYZSBXH.put(ObjectToTypes.parseString(record.getZtyzsbxh()), ztmcMap);
//				}
//			}
//		}

		return list;
	}

	/**
	 * 医技确费列表-分页
	 * 
	 * @param req
	 * @return
	 */
	public List<QueryYjqfListResp> getYjqfList2(QueryYjqfListReq req) {
		//执行状态 默认,全部
		if (req.getZxzt() != null && "4".equals(req.getZxzt())) {
			req.setZxzt("0,1,2,3,5");
		}
		//预约状态 默认,全部
		if (req.getYyzt() != null && "2".equals(req.getYyzt())) {
			req.setYyzt("0,1");
		}

		List<QueryYjqfListResp> respList = new ArrayList<QueryYjqfListResp>();
		List<QueryYjqfListResp> yjjcqfList = new ArrayList<QueryYjqfListResp>();

		//病人类型 含门诊 且 执行状态 含未执行; 有住院号时候不查询门诊的
		if (("1".equals(req.getBrlx()) || "3".equals(req.getBrlx()))
				&& ("0".equals(req.getZxzt()) || "0,1,2,3,5".equals(req.getZxzt()))
				&& StrUtil.isBlank(req.getZyhm())) {

			// 门诊检查
			List<QueryYjqfListResp> mzyjqfList = opYjzxDao.doQueryMzyjqfList(req);
			Map<String, Object> ZTYZSBXH = new HashMap<String, Object>();
			for (QueryYjqfListResp record : mzyjqfList) {
				if (record.getZtbz() != null && 1 == record.getZtbz()) {
					if (ZTYZSBXH.containsKey(ObjectToTypes.parseString(record.getZtyzsbxh()))) {
						continue;
					}
					Map<String, Object> parm = Param.instance().put("sbxh", ObjectToTypes.parseLong(record.getZtyzsbxh()));
					Map<String, Object> ztmcMap = opYjcf02ZtService.getZtBySbxh(parm);
					record.setXmmc(ztmcMap.get("fymc") != null ? ztmcMap.get("fymc").toString() : "");
					ZTYZSBXH.put(ObjectToTypes.parseString(record.getZtyzsbxh()), ztmcMap);
				}
				yjjcqfList.add(record);
			}
			respList.addAll(yjjcqfList);

			// 处置
//			List<QueryYjqfListResp> mzyjczList = opYjzxDao.doQueryMzyjczqfList(req);
//			Map<String, Object> ZTYZCZSBXH = new HashMap<String, Object>();
//			for (QueryYjqfListResp record : mzyjczList) {
//				if (record.getZtbz() != null && record.getZtbz().toString().equals("1")) {
//					if (ZTYZCZSBXH.containsKey(ObjectToTypes.parseString(record.getZtyzsbxh()))) {
//						continue;
//					}
//					Map<String, Object> parm = Param.instance().put("sbxh",
//							ObjectToTypes.parseLong(record.getZtyzsbxh()));
//					Map<String, Object> ztmcMap = opYjcf02ZtService.getZtBySbxh(parm);
//					record.setXmmc(ztmcMap.get("fymc") != null ? ztmcMap.get("fymc").toString() : "");
//					ZTYZCZSBXH.put(ObjectToTypes.parseString(record.getZtyzsbxh()), ztmcMap);
//					yjczqfList.add(record);
//				}
//			}
//			respList.addAll(yjczqfList);

		}
		if (("2".equals(req.getBrlx()) || "3".equals(req.getBrlx()))
				&& ("0".equals(req.getZxzt()) || "0,1,2,3,5".equals(req.getZxzt()))) {
			// 住院
			List<QueryYjqfListResp> zyyjqfList = opYjzxDao.doQueryZyyjqfList(req);
			respList.addAll(zyyjqfList);
		}
		if ("3".equals(req.getBrlx())) {
			req.setBrlx("1,2");
		}
		List<QueryYjqfListResp> mzzyyjqfList = opYjzxDao.doQueryMzZyyjqfList(req);
		respList.addAll(mzzyyjqfList);

		// 数据排序
		Comparator<QueryYjqfListResp> byBrlx = Comparator.comparing(QueryYjqfListResp::getBrlx);
		Comparator<QueryYjqfListResp> bySqsj = Comparator.comparing(QueryYjqfListResp::getSqsj);
		Comparator<QueryYjqfListResp> byZxzt = Comparator.comparing(QueryYjqfListResp::getZxzt);
		respList.sort((byBrlx.thenComparing(bySqsj)).thenComparing(byZxzt));

		for (QueryYjqfListResp resp : respList) {
			if (resp.getCsny() != null) {
				Map<String, Object> agMap = MtdmsUtil.getPersonAge(resp.getCsny(), null);
				if (agMap != null && !agMap.isEmpty()) {
					resp.setAge(agMap.get("ages").toString());
				}
			}
			if ("".equals(resp.getZxzt()) || resp.getZxzt() == null) {
				resp.setZxzt(YjzxztEnum.WZX.getCode());
			}
			resp.setZtbz(resp.getZtbz() != null ? resp.getZtbz() : 0);
		}

		return respList;
	}

	/**
	 * 根据检查项目查询项目明细
	 * 
	 * @param brlx
	 * @param ztbz
	 * @param sbxh
	 * @param zxzt
	 * @return
	 */
	public List<QueryYjzxsfxmResp> doQueryYjzxsfxm(String brlx, Integer ztbz, Integer xmdm, String zxzt) {
		List<QueryYjzxsfxmResp> resp = new ArrayList<QueryYjzxsfxmResp>();
		if (YjzxztEnum.YZX.getCode().equals(zxzt) || YjzxztEnum.ZF.getCode().equals(zxzt)
				|| YjzxztEnum.QXZX.getCode().equals(zxzt)) {
			resp = opYjzxsfxmDao.doQueryXmDetails(xmdm);
		} else {
			if ("1".equals(brlx)) {
				resp = opYjzxDao.doQueryMzXmDetails(xmdm, ztbz);
			} else if ("2".equals(brlx)) {
				resp = opYjzxDao.doQueryZyXmDetails(xmdm, ztbz);
			}
		}
		return resp;
	}

	/**
	 * 医技确费确认
	 * @return
	 */
	@Transactional(rollbackFor = Exception.class)
	public void doCommitYjzx(CommitYjzxReq req) {
		// 新增主表数据
		OpYjzx opYjzx = new OpYjzx();
		BeanUtil.copyProperties(req, opYjzx);
		opYjzx.setZxzt(YjzxztEnum.YZX.getCode());
		opYjzx.setZxsj(DateUtil.date().toTimestamp());
		opYjzx.setZxxh(redisFactory.getTableKey(TableName.DB_NAME, TableName.OP_YJZX));
		opYjzx.setYyzt(req.getYyzt() != null ? req.getYyzt() : 0);
		if("1".equals(opYjzx.getBrlx()) && opYjzx.getZtbz() == 1){
			opYjzx.setZlxmId(opYjzxDao.getZlxmId(req.getXmdm()));
		}
		opYjzxDao.insert(opYjzx);
		// 明细表增加数据
		List<QueryYjzxsfxmResp> sfxmList = new ArrayList<QueryYjzxsfxmResp>();
		if ("1".equals(req.getBrlx())) {
			sfxmList = opYjzxDao.doQueryMzXmDetails(req.getXmdm(), req.getZtbz());
		} else if ("2".equals(req.getBrlx())) {
			sfxmList = opYjzxDao.doQueryZyXmDetails(req.getXmdm(), req.getZtbz());
		}
		int i = 1;
		for (QueryYjzxsfxmResp sfxm : sfxmList) {
			OpYjzxsfxm opYjzxsfxm = new OpYjzxsfxm();
			BeanUtil.copyProperties(sfxm, opYjzxsfxm);
			opYjzxsfxm.setXh(i);
			opYjzxsfxm.setZt(YjsfxmztEnum.YX.getCode());
			opYjzxsfxm.setKsdm(req.getKsdm());
			opYjzxsfxm.setZxxh(opYjzx.getZxxh());
			opYjzxsfxm.setZxrdm(req.getZxysdm());
			opYjzxsfxm.setZxsj(DateUtil.date().toTimestamp());
			opYjzxsfxm.setJgid(req.getJgid());
			opYjzxsfxmDao.insert(opYjzxsfxm);
			i++;
			// 更新门诊住院医技表执行次数和执行状态
			if ("1".equals(req.getBrlx())) {
				OpYjcf02 opYjcf02 = opYjcf02Service.getById(sfxm.getSfxmdm());
				if (opYjcf02 != null && opYjcf02.getYlsl() != null) {
					int ylsl = opYjcf02.getYlsl() != null ? opYjcf02.getYlsl().intValue() : 0;
					Map<String, Object> map = new HashMap<String, Object>();
					map.put("zxcs", ylsl);
					map.put("sbxh", sfxm.getSfxmdm());
					map.put("zxzt", YjzxztEnum.QBZX.getCode());
					opYjcf02Service.updateZxztAndZxcs(map);
				}
			} else if ("2".equals(req.getBrlx())) {
				ImFeeFymxYjModel imFeeFymxYj = imFeeFymxYjService.doQueryByYzxh(sfxm.getSfxmdm());
				if (imFeeFymxYj != null && imFeeFymxYj.getFysl() != null) {
					int yjzxcs = imFeeFymxYj.getZxcs() != null ? imFeeFymxYj.getZxcs() : 0;
					int fysl = imFeeFymxYj.getFysl() != null ? imFeeFymxYj.getFysl().intValue() : 0;
					int xmsl = imFeeFymxYj.getXmsl() != null ? imFeeFymxYj.getXmsl() : 0;
					if (yjzxcs < fysl) {
						Map<String, Object> map = new HashMap<String, Object>();
						int zxcs = yjzxcs + xmsl;
						if (zxcs == fysl) {
							map.put("zxzt", YjzxztEnum.QBZX.getCode());
						} else {
							map.put("zxzt", YjzxztEnum.YZX.getCode());
						}
						map.put("zxcs", zxcs);
						map.put("yzxh", sfxm.getSfxmdm());
						imFeeFymxYjService.updateZxztAndZxcs(map);
					}

					Timestamp lastZyjsSj = imZyjsService.getLastZyjsSj(imFeeFymxYj.getZyh());
					if (imFeeFymxYj.getJfrq().getTime() <=  lastZyjsSj.getTime()) {
						throw BaseException.create("ERROR_MTDMS_0001");
					}
					// 记账明细
					ImFeeFymxReq imFeeFymx = new ImFeeFymxReq();
					BeanUtil.copyProperties(imFeeFymxYj, imFeeFymx);
					imFeeFymx.setJlxh(redisFactory.getTableKey(TableName.DB_NAME, TableName.IM_FEE_FYMX));
					imFeeFymxService.insert(imFeeFymx);
				}
			}
		}
	}

	/**
	 * 医技确费取消确认
	 *
	 * @param zxxh
	 * @param brlx
	 * @param ztbz
	 * @param xmdm
	 * @param userId
	 */
	@Transactional(rollbackFor = Exception.class)
	public void doCancelCommitYjzx(Integer zxxh, String brlx, Integer ztbz, Integer xmdm, Integer userId) {
		// 更新医技执行表执行状态
		OpYjzx opYjzx = new OpYjzx();
		opYjzx.setZxxh(zxxh);
		opYjzx.setZxzt(YjzxztEnum.QXZX.getCode());
		opYjzx.setQxysdm(userId);
		opYjzx.setQxzxsj(DateUtil.date().toTimestamp());
		opYjzxDao.doUpdateZxztByZxxh(opYjzx);

		// 更新收费项目表状态
		OpYjzxsfxm opYjzxsfxm = new OpYjzxsfxm();
		opYjzxsfxm.setZxxh(zxxh);
		opYjzxsfxm.setZt(YjsfxmztEnum.QXZX.getCode());
		opYjzxsfxm.setQxzxrdm(userId);
		opYjzxsfxm.setQxzxsj(DateUtil.date().toTimestamp());
		opYjzxsfxmDao.doUpdateZtByZxxh(opYjzxsfxm);

		// 更新门诊住院医技表执行次数和执行状态
		if ("1".equals(brlx)) {
			List<OpYjcf02> opYjcf02 = opYjcf02Service.doQueryBySBxhOrZtsbxh(xmdm, ztbz);
			for (OpYjcf02 cf02 : opYjcf02) {
				Map<String, Object> map = new HashMap<String, Object>();
				map.put("zxzt", YjzxztEnum.WZX.getCode());
				map.put("zxcs", 0);
				map.put("sbxh", cf02.getSbxh());
				opYjcf02Service.updateZxztAndZxcs(map);
			}
		} else if ("2".equals(brlx)) {
			List<CisHzyzModel> cisHzyz = cisHzyzService.doQueryByJlxhOrZtjlxh(xmdm, ztbz);
			for (CisHzyzModel hzyz : cisHzyz) {
				ImFeeFymxYjModel imFeeFymxYj = imFeeFymxYjService.doQueryByYzxh(hzyz.getJlxh());

				Timestamp lastZyjsSj = imZyjsService.getLastZyjsSj(hzyz.getZyh());
				if (imFeeFymxYj.getJfrq().getTime() <=  lastZyjsSj.getTime()) {
					throw BaseException.create("ERROR_MTDMS_0001");
				}

				int yjzxcs = imFeeFymxYj.getZxcs() != null ? imFeeFymxYj.getZxcs().intValue() : 0;
				if (imFeeFymxYj != null && imFeeFymxYj.getFysl() != null) {
					Map<String, Object> map = new HashMap<String, Object>();
					int zxcs = yjzxcs - 1 < 0 ? 0 : yjzxcs - 1;
					if (zxcs == 0) {
						map.put("zxzt", YjzxztEnum.WZX.getCode());
					} else {
						map.put("zxzt", YjzxztEnum.YZX.getCode());
					}
					map.put("zxcs", zxcs);
					map.put("yzxh", imFeeFymxYj.getYzxh());
					imFeeFymxYjService.updateZxztAndZxcs(map);
					// 记账明细
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

	}

	/**
	 * 医技确费作废
	 * @param zxxh
	 * @param brlx
	 * @param ztbz
	 * @param xmdm
	 * @param userId
	 */
	@Transactional(rollbackFor = Exception.class)
	public void doZfYjzx(CommitYjzxReq req, Integer zxxh, String brlx, Integer ztbz, Integer xmdm, Integer userId) {
		OpYjzx oldOpYjzx = new OpYjzx();
		if(null != zxxh){
			oldOpYjzx = opYjzxDao.getById(zxxh);
			//更新医技执行表执行状态
			OpYjzx opYjzx = new OpYjzx();
			opYjzx.setZxxh(zxxh);
			opYjzx.setZxzt(YjzxztEnum.ZF.getCode());
			opYjzx.setZfysdm(userId);
			opYjzx.setZfsj(DateUtil.date().toTimestamp());
			opYjzxDao.doUpdateZxztByZxxh(opYjzx);

			//更新收费项目表状态
			OpYjzxsfxm opYjzxsfxm = new OpYjzxsfxm();
			opYjzxsfxm.setZxxh(zxxh);
			opYjzxsfxm.setZt(YjsfxmztEnum.ZF.getCode());
			opYjzxsfxm.setZfrdm(userId);
			opYjzxsfxm.setZfsj(DateUtil.date().toTimestamp());
			opYjzxsfxmDao.doUpdateZtByZxxh(opYjzxsfxm);
		}else if(null != req){
			OpYjzx opYjzx = new OpYjzx();
			BeanUtil.copyProperties(req, opYjzx);
			opYjzx.setZxxh(redisFactory.getTableKey(TableName.DB_NAME, TableName.OP_YJZX));
			opYjzx.setYyzt(req.getYyzt() != null ? req.getYyzt() : 0);
			opYjzx.setZxzt(YjzxztEnum.ZF.getCode());
			opYjzx.setZfysdm(userId);
			opYjzx.setZfsj(DateUtil.date().toTimestamp());
			opYjzxDao.insert(opYjzx);
		}else{
			return;
		}

		//门诊
		if ("1".equals(brlx)) {
			List<OpYjcf02> opYjcf02 = opYjcf02Service.doQueryBySBxhOrZtsbxh(xmdm, ztbz);
			for (OpYjcf02 cf02 : opYjcf02) {
				if (cf02.getYlsl() != null) {
					Map<String, Object> map = new HashMap<String, Object>();
					map.put("zxzt", YjzxztEnum.ZF.getCode());
					map.put("sbxh", cf02.getSbxh());
					opYjcf02Service.updateZxztAndZxcs(map);
				}
			}

			//住院
		}if ("2".equals(brlx)) {
			List<CisHzyzModel> cisHzyz = cisHzyzService.doQueryByJlxhOrZtjlxh(xmdm, ztbz);
			for (CisHzyzModel hzyz : cisHzyz) {
				ImFeeFymxYjModel imFeeFymxYj = imFeeFymxYjService.doQueryByYzxh(hzyz.getJlxh());
				if (imFeeFymxYj != null) {
					Map<String, Object> map = new HashMap<String, Object>();
					map.put("zxzt", YjzxztEnum.ZF.getCode());
					map.put("yzxh", imFeeFymxYj.getYzxh());
					imFeeFymxYjService.updateZxztAndZxcs(map);
					if(null != zxxh){
						if(YjzxztEnum.YZX.getCode().equals(oldOpYjzx.getZxzt())|| YjzxztEnum.QBZX.getCode().equals(oldOpYjzx.getZxzt())){
							// 记账明细
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
			}
		}
	}

	/**
	 * 医技确费取消作废接口
	 */
	@Transactional(rollbackFor = Exception.class)
	public void doQxZfYjzx(QxzfYjzxReq req, YjzxztEnum zxzt) {

		//只能作废和取消执行操作
		if(zxzt != YjzxztEnum.ZF && zxzt != YjzxztEnum.QXZX){
			return;
		}

		//未执行的取消没有意义
		if(zxzt == YjzxztEnum.QXZX && null == req.getZxxh()){
			return;
		}

		//新增一条取消\作废记录
		OpYjzx newOpyjzx = new OpYjzx();

		//已执行的取消
		if(null != req.getZxxh()){
			OpYjzx opYjzx = opYjzxDao.getById(req.getZxxh());
			BeanUtil.copyProperties(opYjzx, newOpyjzx);
			//费用？
		}else {
			BeanUtil.copyProperties(req, newOpyjzx);
		}

		newOpyjzx.setZxxh(redisFactory.getTableKey(TableName.DB_NAME, TableName.OP_YJZX));
		newOpyjzx.setZxzt(zxzt.getCode());
		newOpyjzx.setZfsj(DateUtil.date().toTimestamp());
		opYjzxDao.insert(newOpyjzx);

		//取消执行
		if(zxzt == YjzxztEnum.QXZX){

			// 更新收费项目表状态
			OpYjzxsfxm opYjzxsfxm = new OpYjzxsfxm();
			opYjzxsfxm.setZxxh(req.getZxxh());
			opYjzxsfxm.setZt(YjsfxmztEnum.QXZX.getCode());
			opYjzxsfxm.setQxzxrdm(req.getQxysdm());
			opYjzxsfxm.setQxzxsj(DateUtil.date().toTimestamp());
			opYjzxsfxmDao.doUpdateZtByZxxh(opYjzxsfxm);

			//门诊取消时候更新数量
			if ("1".equals(req.getBrlx())) {
				List<OpYjcf02> opYjcf02 = opYjcf02Service.doQueryBySBxhOrZtsbxh(req.getXmdm(), req.getZtbz());
				for (OpYjcf02 cf02 : opYjcf02) {
					int cf02Zxcs = cf02.getZxcs() != null ? cf02.getZxcs() : 0;
					Map<String, Object> map = new HashMap<>();
					int zxcs = Math.max(cf02Zxcs - 1, 0);
					if (zxcs == 0) {
						map.put("zxzt", YjzxztEnum.WZX.getCode());
					} else {
						map.put("zxzt", YjzxztEnum.YZX.getCode());
					}
					map.put("zxcs", zxcs);
					map.put("sbxh", cf02.getSbxh());
					opYjcf02Service.updateZxztAndZxcs(map);
				}

				//住院
			}if ("2".equals(req.getBrlx())) {
				List<CisHzyzModel> cisHzyz = cisHzyzService.doQueryByJlxhOrZtjlxh(req.getXmdm(), req.getZtbz());
				for (CisHzyzModel hzyz : cisHzyz) {
					ImFeeFymxYjModel imFeeFymxYj = imFeeFymxYjService.doQueryByYzxh(hzyz.getJlxh());
					if (imFeeFymxYj != null) {
						int yjzxcs = imFeeFymxYj.getZxcs() != null ? imFeeFymxYj.getZxcs() : 0;
						Map<String, Object> map = new HashMap<>();
						int zxcs = Math.max(yjzxcs - 1, 0);
						if (zxcs == 0) {
							map.put("zxzt", YjzxztEnum.WZX.getCode());
						} else {
							map.put("zxzt", YjzxztEnum.YZX.getCode());
						}
						map.put("zxcs", zxcs);
						map.put("yzxh", imFeeFymxYj.getYzxh());
						imFeeFymxYjService.updateZxztAndZxcs(map);

						// 记账明细
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

		//作废执行
		}else if (zxzt == YjzxztEnum.ZF) {
			//门诊
			if ("1".equals(req.getBrlx())) {
				List<OpYjcf02> opYjcf02 = opYjcf02Service.doQueryBySBxhOrZtsbxh(req.getXmdm(), req.getZtbz());
				for (OpYjcf02 cf02 : opYjcf02) {
					Map<String, Object> map = new HashMap<>();
					map.put("zxzt", YjzxztEnum.ZF.getCode());
					map.put("sbxh", cf02.getSbxh());
					opYjcf02Service.updateZxztAndZxcs(map);
				}

			//住院
			}else if ("2".equals(req.getBrlx())) {
				List<CisHzyzModel> cisHzyz = cisHzyzService.doQueryByJlxhOrZtjlxh(req.getXmdm(), req.getZtbz());
				for (CisHzyzModel hzyz : cisHzyz) {
					ImFeeFymxYjModel imFeeFymxYj = imFeeFymxYjService.doQueryByYzxh(hzyz.getJlxh());
					if (imFeeFymxYj != null) {
						Map<String, Object> map = new HashMap<>();
						map.put("zxzt", YjzxztEnum.ZF.getCode());
						map.put("yzxh", imFeeFymxYj.getYzxh());
						imFeeFymxYjService.updateZxztAndZxcs(map);
					}
				}
			}
		}
	}


	/**
	 * 项目执行确认查询列表
	 * 
	 * @param req
	 * @return
	 */
	public List<QueryYjzxqrListResp> doQueryYjzxqrList(QueryYjzxqrListReq req) {
		if (req.getBeginDay() != null && req.getEndDay() != null) {
			req.setZxsj(DateUtil.date().toTimestamp());
			req.setBeginOfDay(
					MtdmsUtil.toString(DateUtil.beginOfDay(req.getBeginDay()).toTimestamp(), "yyyy-MM-dd HH:mm:ss"));
			req.setEndOfDay(
					MtdmsUtil.toString(DateUtil.endOfDay(req.getEndDay()).toTimestamp(), "yyyy-MM-dd HH:mm:ss"));
		}
		if (req.getBrlx() != null && "3".equals(req.getBrlx())) {
			req.setBrlx("1,2");
		}
		if (req.getZxzt() != null && "4".equals(req.getZxzt())) {
			req.setZxzt("1,2,3");
		}
		List<QueryYjzxqrListResp> respList = new ArrayList<QueryYjzxqrListResp>();
		List<QueryYjzxqrListResp> resp = opYjzxDao.doQueryYjzxqrList(req);
		for (QueryYjzxqrListResp yjzxqr : resp) {
			if (yjzxqr.getCsny() != null) {
				Map<String, Object> agMap = MtdmsUtil.getPersonAge(yjzxqr.getCsny(), null);
				if (agMap != null && !agMap.isEmpty()) {
					yjzxqr.setAges(agMap.get("ages").toString());
				}
			}
			respList.add(yjzxqr);
		}

		// 数据排序
		Comparator<QueryYjzxqrListResp> byBrlx = Comparator.comparing(QueryYjzxqrListResp::getBrlx);
		Comparator<QueryYjzxqrListResp> bySqsj = Comparator.comparing(QueryYjzxqrListResp::getSqsj);
		Comparator<QueryYjzxqrListResp> byZxzt = Comparator.comparing(QueryYjzxqrListResp::getZxzt);
		respList.sort((byBrlx.thenComparing(bySqsj)).thenComparing(byZxzt));

		return respList;
	}

	/**
	 * 当前执行科室下的检查项目
	 * 
	 * @param ksdm
	 * @return
	 */
	public List<OpyjzxDictResp> doQueryJcxmList(Integer ksdm) {
		List<OpyjzxDictResp> respList = new ArrayList<OpyjzxDictResp>();
		List<OpyjzxDictResp> result = opYjzxDao.doQueryJcxmList(ksdm);
		for (OpyjzxDictResp resp : result) {
			// 设置拼音、五笔字符
			ChineseCharacterUtil.setPyAndWb(resp, resp.getXmmc());
			respList.add(resp);
		}
		return respList;
	}

	/**
	 * 当前执行科室下的执行医生
	 * 
	 * @param ksdm
	 * @return
	 */
	public List<QueryYsdmListResp> doQueryYsdmList(Integer ksdm) {
		return opYjzxDao.doQueryYsdmList(ksdm);
	}

	/**
	 * 获取全部金额
	 * 
	 * @param req
	 * @return
	 */
	public BigDecimal doQueryTotalAmount(QueryYjzxqrListReq req) {
		if (req.getBeginDay() != null && req.getEndDay() != null) {
			req.setZxsj(DateUtil.date().toTimestamp());
			req.setBeginOfDay(
					MtdmsUtil.toString(DateUtil.beginOfDay(req.getBeginDay()).toTimestamp(), "yyyy-MM-dd HH:mm:ss"));
			req.setEndOfDay(
					MtdmsUtil.toString(DateUtil.endOfDay(req.getEndDay()).toTimestamp(), "yyyy-MM-dd HH:mm:ss"));
		}
		if (req.getBrlx() != null && "3".equals(req.getBrlx())) {
			req.setBrlx("1,2");
		}
		if (req.getZxzt() != null && "4".equals(req.getZxzt())) {
			req.setZxzt("1,2,3");
		}
		BigDecimal totalAmount = opYjzxDao.doQueryTotalAmount(req);
		return totalAmount != null ? totalAmount : BigDecimal.ZERO;
	}

}
