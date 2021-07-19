
package com.buit.his.mtdms.controller;

import java.math.BigDecimal;
import java.util.List;

import com.buit.his.mtdms.enums.YjzxztEnum;
import com.buit.his.mtdms.request.QxzfYjzxReq;
import com.github.pagehelper.PageHelper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.buit.commons.BaseSpringController;
import com.buit.commons.PageQuery;
import com.buit.his.mtdms.request.CommitYjzxReq;
import com.buit.his.mtdms.request.QueryYjqfListReq;
import com.buit.his.mtdms.request.QueryYjzxqrListReq;
import com.buit.his.mtdms.response.OpyjzxDictResp;
import com.buit.his.mtdms.response.QueryYjqfListResp;
import com.buit.his.mtdms.response.QueryYjzxqrListResp;
import com.buit.his.mtdms.response.QueryYjzxsfxmResp;
import com.buit.his.mtdms.response.QueryYsdmListResp;
import com.buit.his.mtdms.service.OpYjzxSer;
import com.buit.utill.PageUtil;
import com.buit.utill.ReturnEntity;
import com.buit.utill.ReturnEntityUtil;
import com.github.pagehelper.PageInfo;
import com.github.xiaoymin.knife4j.annotations.ApiOperationSupport;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;

/**
 * 医技确费
 * 
 * @author WY
 */
@Api(tags = "医技确费")
@Controller
@RequestMapping("/opyjzx")
public class OpYjzxCtr extends BaseSpringController {

	static final Logger logger = LoggerFactory.getLogger(OpYjzxCtr.class);

	@Autowired
	private OpYjzxSer opYjzxSer;

	/**
	 * 医技确费列表-分页
	 * 
	 * @param req
	 * @return
	 */
	@RequestMapping("/doQueryYjqfList")
	@ResponseBody
	@ApiOperationSupport(author = "汪洋")
	@ApiOperation(value = "医技确费列表", httpMethod = "POST", notes = "医技确费列表")
	public ReturnEntity<PageInfo<QueryYjqfListResp>> getFpzfList(QueryYjqfListReq req, PageQuery page) {
		return ReturnEntityUtil
				.success(PageHelper.startPage(page.getPageNum(), page.getPageSize()).doSelectPageInfo(() -> opYjzxSer.getYjqfList(req)));
	}

	/**
	 * 根据检查项目查询项目明细
	 * 
	 * @param brlx
	 * @param ztbz
	 * @param zxzt
	 * @return
	 */
	@RequestMapping("/doQueryYjzxsfxm")
	@ResponseBody
	@ApiOperationSupport(author = "汪洋")
	@ApiOperation(value = "根据检查项目查询项目明细", httpMethod = "POST", notes = "根据检查项目查询项目明细")
	public ReturnEntity<List<QueryYjzxsfxmResp>> doQueryYjzxsfxm(
			@ApiParam(name = "brlx", value = "类型  1：门诊 2：住院 ", required = true) @RequestParam(value = "brlx") String brlx,
			@ApiParam(name = "ztbz", value = "组套标志：0：非组套  1：组套 ", required = true) @RequestParam(value = "ztbz") Integer ztbz,
			@ApiParam(name = "xmdm", value = "组套ztyzsbxh 或者非组套sbxh或者执行序号zxxh") @RequestParam(value = "xmdm") Integer xmdm,
			@ApiParam(name = "zxzt", value = "状态 0：未执行  1：部分执行/已执行  2：作废  3:取消执行 ") @RequestParam(value = "zxzt", required = false) String zxzt) {
		return ReturnEntityUtil.success(opYjzxSer.doQueryYjzxsfxm(brlx, ztbz, xmdm, zxzt));
	}

	/**
	 * 医技确费确认
	 * 
	 * @return
	 */
	@RequestMapping("/doCommitYjzx")
	@ResponseBody
	@ApiOperationSupport(author = "汪洋")
	@ApiOperation(value = "医技确费确认", httpMethod = "POST", notes = "医技确费确认")
	public ReturnEntity<?> doCommitYjzx(@RequestBody CommitYjzxReq req) {
		req.setJgid(getUser().getHospitalId());
		req.setZxysdm(getUser().getUserId());
		opYjzxSer.doCommitYjzx(req);
		return ReturnEntityUtil.success();
	}

	/**
	 * 医技确费取消确认
	 * @return
	 */
	@RequestMapping("/v2/doCancelCommitYjzx")
	@ResponseBody
	@ApiOperation(value = "医技确费取消确认", httpMethod = "POST", notes = "医技确费取消确认")
	public ReturnEntity<?> doCancelCommitYjzx(@RequestBody QxzfYjzxReq req) {
		req.setQxysdm(getUser().getUserId());
		opYjzxSer.doQxZfYjzx(req, YjzxztEnum.QXZX);
		return ReturnEntityUtil.success();
	}

	/**
	 * 医技确费作废
	 * @return
	 */
	@RequestMapping("/v2/doZfYjzx")
	@ResponseBody
	@ApiOperation(value = "医技确费作废", httpMethod = "POST", notes = "医技确费作废")
	public ReturnEntity<?> doZfYjzx(@RequestBody QxzfYjzxReq req) {
		req.setQxysdm(getUser().getUserId());
		opYjzxSer.doQxZfYjzx(req, YjzxztEnum.ZF);
		return ReturnEntityUtil.success();
	}

	/**
	 * 医技确费取消确认
	 *
	 * @param brlx
	 * @param ztbz
	 * @param xmdm
	 * @param zxxh
	 * @return
	 */
	@RequestMapping("/doCancelCommitYjzx")
	@ResponseBody
	@ApiOperationSupport(author = "汪洋")
	@ApiOperation(value = "医技确费取消确认", httpMethod = "POST", notes = "医技确费取消确认")
	public ReturnEntity<?> doCancelCommitYjzx(
			@ApiParam(name = "brlx", value = "类型  1：门诊 2：住院 ", required = true) @RequestParam(value = "brlx") String brlx,
			@ApiParam(name = "ztbz", value = "组套标志：0：非组套  1：组套 ", required = true) @RequestParam(value = "ztbz") Integer ztbz,
			@ApiParam(name = "xmdm", value = "组套ztyzsbxh或者非组套sbxh", required = true) @RequestParam(value = "xmdm") Integer xmdm,
			@ApiParam(name = "zxxh", value = "执行序号", required = true) @RequestParam(value = "zxxh") Integer zxxh) {
		opYjzxSer.doCancelCommitYjzx(zxxh, brlx, ztbz, xmdm, getUser().getUserId());
		return ReturnEntityUtil.success();
	}

	/**
	 * 医技确费作废
	 * @return
	 */
	@RequestMapping("/doZfYjzx")
	@ResponseBody
	@ApiOperationSupport(author = "汪洋")
	@ApiOperation(value = "医技确费作废", httpMethod = "POST", notes = "医技确费作废")
	public ReturnEntity<?> doZfYjzx(
			@ApiParam(name = "brlx", value = "类型  1：门诊 2：住院 ", required = true) @RequestParam(value = "brlx") String brlx,
			@ApiParam(name = "ztbz", value = "组套标志：0：非组套  1：组套 ", required = true) @RequestParam(value = "ztbz") Integer ztbz,
			@ApiParam(name = "xmdm", value = "组套ztyzsbxh 或者非组套sbxh", required = true) @RequestParam(value = "xmdm") Integer xmdm,
			@ApiParam(name = "zxxh", value = "执行序号") @RequestParam(value = "zxxh", required = false) Integer zxxh) {
		opYjzxSer.doZfYjzx(null, zxxh, brlx, ztbz, xmdm, getUser().getUserId());
		return ReturnEntityUtil.success();
	}

	/**
	 * 项目执行确认查询列表
	 * 
	 * @param req
	 * @return
	 */
	@RequestMapping("/doQueryYjzxqrList")
	@ResponseBody
	@ApiOperationSupport(author = "汪洋")
	@ApiOperation(value = "项目执行确认查询列表", httpMethod = "POST", notes = "项目执行确认查询列表")
	public ReturnEntity<PageInfo<QueryYjzxqrListResp>> doQueryYjzxqrList(QueryYjzxqrListReq req, PageQuery page) {
		return ReturnEntityUtil
				.success(PageUtil.getPageInfo(page.getPageNum(), page.getPageSize(), opYjzxSer.doQueryYjzxqrList(req)));
	}

	/**
	 * 当前执行科室下的检查项目
	 * @return
	 */
	@RequestMapping("/doQueryJcxmList")
	@ResponseBody
	@ApiOperationSupport(author = "汪洋")
	@ApiOperation(value = "当前执行科室下的检查项目", httpMethod = "POST", notes = "当前执行科室下的检查项目")
	public ReturnEntity<List<OpyjzxDictResp>> doQueryJcxmList(
			@ApiParam(name = "ksdm", value = "当前执行科室代码", required = true) @RequestParam(value = "ksdm") Integer ksdm) {
		List<OpyjzxDictResp> resp = opYjzxSer.doQueryJcxmList(ksdm);
		return ReturnEntityUtil.success(resp);
	}

	/**
	 * 当前执行科室下的执行医生
	 * @return
	 */
	@RequestMapping("/doQueryYsdmList")
	@ResponseBody
	@ApiOperationSupport(author = "汪洋")
	@ApiOperation(value = "当前执行科室下的执行医生", httpMethod = "POST", notes = "当前执行科室下的执行医生")
	public ReturnEntity<List<QueryYsdmListResp>> doQueryYsdmList(
			@ApiParam(name = "ksdm", value = "当前执行科室代码", required = true) @RequestParam(value = "ksdm") Integer ksdm) {
		List<QueryYsdmListResp> resp = opYjzxSer.doQueryYsdmList(ksdm);
		return ReturnEntityUtil.success(resp);
	}
	
	/**
	 * 查询项目执行确认总金额
	 * 
	 * @param req
	 * @return
	 */
	@RequestMapping("/doQueryTotalAmount")
	@ResponseBody
	@ApiOperationSupport(author = "汪洋")
	@ApiOperation(value = "查询项目执行确认总金额", httpMethod = "POST", notes = "查询项目执行确认总金额")
	public ReturnEntity<BigDecimal> doQueryTotalAmount(QueryYjzxqrListReq req) {
		BigDecimal totalAmount = opYjzxSer.doQueryTotalAmount(req);
		return ReturnEntityUtil.success(totalAmount);
	}

//    @RequestMapping("/queryPage")
//    @ResponseBody
//    @ApiOperation(value="按条件分页查询" ,httpMethod="POST")
//    public ReturnEntity<PageInfo<OpYjzxResp>> queryPage(OpYjzxReq opyjzx,PageQuery page){
//        PageInfo<OpYjzx> pageInfo = PageHelper.startPage(
//            page.getPageNum(), page.getPageSize()).doSelectPageInfo(
//                    () -> opYjzxSer.findByEntity(opyjzx)
//            );
//        return ReturnEntityUtil.success(pageInfo);
//    }
//    
//    @RequestMapping("/findList")
//    @ResponseBody
//    @ApiOperation(value="按条件查询-返回列表" ,httpMethod="POST")
//    public ReturnEntity<List<OpYjzxResp>> getByEntity( OpYjzxReq opyjzx){//@RequestBody 
//        return ReturnEntityUtil.success(opYjzxSer.findByEntity(opyjzx));    
//    }
//    
//    @RequestMapping("/getOneByEntity")
//    @ResponseBody
//    @ApiOperation(value="按条件查询-返回唯一值" ,httpMethod="POST")
//    public ReturnEntity<OpYjzxResp> getOneByEntity(OpYjzxReq opyjzx){
//        List<OpYjzx> list=opYjzxSer.findByEntity(opyjzx);
//        if(list.size()>0){
//           return ReturnEntityUtil.success(list.get(0));    
//        }
//        return ReturnEntityUtil.success();
//    }
//    
//    /** 新增 */
//    @RequestMapping("/add")
//    @ResponseBody
//    @ApiOperation(value="新增" ,httpMethod="POST")
//    public ReturnEntity<OpYjzxResp> add(OpYjzxReq opYjzx) {
//        opYjzxSer.insert(opYjzx);        
//        return ReturnEntityUtil.success(opYjzx);            
//    }
//    /** 编辑 */
//    @RequestMapping("/edit")
//    @ResponseBody
//    @ApiOperation(value="编辑" ,httpMethod="POST")
//    public ReturnEntity<OpYjzxResp> edit(OpYjzxReq opYjzx)  {
//        opYjzxSer.update(opYjzx);        
//        return ReturnEntityUtil.success(opYjzx);            
//    }
//    
//    /** 删除 */
//    @RequestMapping("/delete")
//    @ResponseBody
//    @ApiOperation(value="按条件查询" ,httpMethod="POST")
//    public ReturnEntity<OpYjzxResp> delete(OpYjzxReq opYjzx) {
//        opYjzxSer.removeByEntity(opYjzx);        
//        return ReturnEntityUtil.success(opYjzx);            
//    }

}
