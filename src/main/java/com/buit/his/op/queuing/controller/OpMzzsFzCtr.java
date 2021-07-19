
package com.buit.his.op.queuing.controller;

import com.buit.commons.BaseSpringController;
import com.buit.utill.ParamUtil;
import com.buit.utill.ReturnEntityUtil;
import com.github.xiaoymin.knife4j.annotations.ApiOperationSupport;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/**
 * 门诊诊室信息<br>
 *
 * @author 老花生
 */
@Api(tags = "服务台科室维护")
@Controller
@RequestMapping("/opmzzs")
public class OpMzzsFzCtr extends BaseSpringController {

	static final Logger logger = LoggerFactory.getLogger(OpMzzsFzCtr.class);
//
//	@Autowired
//	private OpMzzsSer opMzzsSer;
//
//	/**
//	 * @name: queryMsByFwtId
//	 * @description: 根据服务台ID查询诊室信息
//	 * @param fwtid
//	 * @return: com.buit.utill.ReturnEntity<?>
//	 * @date: 2020/9/4 9:58
//	 * @auther: 朱智
//	 *
//	 */
//	@RequestMapping("/queryZsByFwtId")
//	@ResponseBody
//	@ApiOperationSupport(author = "朱智")
//	@ApiOperation(value = "根据服务台ID查询科室", httpMethod = "POST")
//	public ReturnEntity<List<OpGhks>> queryKsByFwtId(
//			@ApiParam(name = "fwtid", value = "服务台ID", required = true) @RequestParam(value = "fwtid") Integer fwtid,
//			@ApiParam(name = "ksmc", value = "科室名称") @RequestParam(value = "ksmc", required = false) String ksmc) {
//		return ReturnEntityUtil.success(opMzzsSer.queryKsByFwtId(fwtid, ksmc));
//	}

//	/**
//	 * @name: queryAll
//	 * @description: 查询全部诊室
//	 * @return: com.buit.utill.ReturnEntity<?>
//	 * @date: 2020/9/4 9:58
//	 * @auther: 朱智
//	 *
//	 */
//	@RequestMapping("/queryAll")
//	@ResponseBody
//	@ApiOperationSupport(author = "朱智")
//	@ApiOperation(value = "查询全部诊室", httpMethod = "POST")
//	public ReturnEntity<List<OpMzzs>> queryAll() {
//		return ReturnEntityUtil.success(opMzzsSer.findByEntity(new OpMzzs()));
//	}
//
//	/**
//	 * @name: queryWaitMs
//	 * @description: 查询待选择科室信息
//	 * @date: 2020/9/4 9:58
//	 * @auther: 朱智
//	 *
//	 */
//	@RequestMapping("/queryWaitMs")
//	@ResponseBody
//	@ApiOperationSupport(author = "朱智")
//	@ApiOperation(value = "查询待选择诊室信息", httpMethod = "POST")
//	public ReturnEntity<List<OpGhks>> queryWaitMs(@ApiParam(name = "ksmc", value = "科室名称") @RequestParam(value = "ksmc", required = false) String ksmc) {
//		return ReturnEntityUtil.success(opMzzsSer.queryWaitMs(ksmc));
//	}
//
//	/**
//	 * @name: fwtZsChange
//	 * @description: 服务台诊室维护
//	 * @date: 2020/9/4 9:58
//	 * @auther: 朱智
//	 *
//	 */
//	@RequestMapping("/fwtKsChange")
//	@ResponseBody
//	@ApiOperationSupport(author = "朱智")
//	@ApiOperation(value = "服务台科室维护", httpMethod = "POST")
//	public ReturnEntity<List<OpMzzs>> fwtZsChange(@ApiParam(name = "fwtid", value = "服务台ID", required = true) @RequestParam(value = "fwtid") Integer fwtid,
//												  @ApiParam(name = "ksdmList", value = "诊室识别序号集合", required = true) @RequestParam(value = "ksdmList") List<Integer> ksdmList,
//												  @ApiParam(name = "type", value = "类型1：加、2：减", required = true) @RequestParam(value = "type") Integer type) {
//		opMzzsSer.fwtKsChange(fwtid, ksdmList, type);
//		return ReturnEntityUtil.success();
//	}
//

//	@RequestMapping("/getFwtIdByZsmc")
//	@ResponseBody
//	@ApiOperationSupport(author = "朱智")
//	@ApiOperation(value = "通过诊室名称查询服务台ID", httpMethod = "POST")
//	public ReturnEntity<OpMzzs> fwtZsChange(@ApiParam(name = "zsmc", value = "诊室名称", required = true) @RequestParam(value = "zsmc") String zsmc) {
//		List<OpMzzs> list = opMzzsSer.getEntityMapper().findByEntity(ParamUtil.instance().put("zsmc", zsmc));
//		if(!list.isEmpty()){
//			return ReturnEntityUtil.success(list.get(0));
//		}
//		return ReturnEntityUtil.success();
//	}

//
//    @RequestMapping("/findList")
//    @ResponseBody
//    @ApiOperation(value="按条件查询-返回列表" ,httpMethod="POST")
//    public ReturnEntity<List<OpMzzsResp>> getByEntity( OpMzzsReq opmzzs){//@RequestBody
//        return ReturnEntityUtil.success(opMzzsSer.findByEntity(opmzzs));
//    }
//
//    @RequestMapping("/getOneByEntity")
//    @ResponseBody
//    @ApiOperation(value="按条件查询-返回唯一值" ,httpMethod="POST")
//    public ReturnEntity<OpMzzsResp> getOneByEntity(OpMzzsReq opmzzs){
//        List<OpMzzs> list=opMzzsSer.findByEntity(opmzzs);
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
//    public ReturnEntity<OpMzzsResp> add(OpMzzsReq opMzzs) {
//        opMzzsSer.insert(opMzzs);
//        return ReturnEntityUtil.success(opMzzs);
//    }
//    /** 编辑 */
//    @RequestMapping("/edit")
//    @ResponseBody
//    @ApiOperation(value="编辑" ,httpMethod="POST")
//    public ReturnEntity<OpMzzsResp> edit(OpMzzsReq opMzzs)  {
//        opMzzsSer.update(opMzzs);
//        return ReturnEntityUtil.success(opMzzs);
//    }
//
//    /** 删除 */
//    @RequestMapping("/delete")
//    @ResponseBody
//    @ApiOperation(value="按条件查询" ,httpMethod="POST")
//    public ReturnEntity<OpMzzsResp> delete(OpMzzsReq opMzzs) {
//        opMzzsSer.removeByEntity(opMzzs);
//        return ReturnEntityUtil.success(opMzzs);
//    }

}
