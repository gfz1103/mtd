
package com.buit.his.op.queuing.controller;


import com.buit.commons.BaseSpringController;
import com.buit.his.op.queuing.model.OpFwtxx;
import com.buit.his.op.queuing.request.OpFwtxxAddReq;
import com.buit.his.op.queuing.request.OpFwtxxEditReq;
import com.buit.his.op.queuing.request.OpFwtxxReq;
import com.buit.his.op.queuing.response.OpFwtxxResp;
import com.buit.his.op.queuing.service.OpFwtxxSer;
import com.buit.utill.BeanUtil;
import com.buit.utill.DateUtil;
import com.buit.utill.ReturnEntity;
import com.buit.utill.ReturnEntityUtil;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.validation.Valid;
import java.util.List;

/**
 * 服务台信息<br>
 * @author 老花生
 */
@Api(tags="服务台信息")
@Controller
@RequestMapping("/opfwtxx")
public class OpFwtxxCtr extends BaseSpringController{

    static final Logger logger = LoggerFactory.getLogger(OpFwtxxCtr.class);

    @Autowired
    private OpFwtxxSer opFwtxxSer;

    @RequestMapping("/queryPage")
    @ResponseBody
    @ApiOperation(value="按条件分页查询" ,httpMethod="POST")
    public ReturnEntity<PageInfo<OpFwtxxResp>> queryPage(OpFwtxxReq opfwtxx){
        opfwtxx.setYqdm(getUser().getHospitalIdStr());
        PageInfo<OpFwtxx> pageInfo = PageHelper.startPage(
                opfwtxx.getPageNum(), opfwtxx.getPageSize()).doSelectPageInfo(
                    () -> opFwtxxSer.findByEntity(opfwtxx)
            );
        return ReturnEntityUtil.success(BeanUtil.toPage(pageInfo, OpFwtxxResp.class));
    }

    @RequestMapping("/queryList")
    @ResponseBody
    @ApiOperation(value="按条件查询集合" ,httpMethod="POST")
    public ReturnEntity<List<OpFwtxxResp>> queryList(OpFwtxxReq opfwtxx){
        opfwtxx.setYqdm(getUser().getHospitalIdStr());
        return ReturnEntityUtil.success(BeanUtil.toBeans(opFwtxxSer.findByEntity(opfwtxx), OpFwtxxResp.class));
    }

    /** 删除 */
    @RequestMapping("/deleteById")
    @ResponseBody
    @ApiOperation(value="根据id删除" ,httpMethod="POST")
    public ReturnEntity<OpFwtxxResp> delete(@ApiParam(name = "rid", value = "主键id", required = true) @RequestParam Integer rid) {
        opFwtxxSer.removeById(rid);
        return ReturnEntityUtil.success();
    }

    /** 编辑 */
    @RequestMapping("/edit")
    @ResponseBody
    @ApiOperation(value="编辑" ,httpMethod="POST")
    public ReturnEntity edit(@Valid OpFwtxxEditReq opFwtxx)  {
        opFwtxxSer.updateFwt(opFwtxx);
        return ReturnEntityUtil.success();
    }

    /** 编辑状态 */
    @RequestMapping("/editState")
    @ResponseBody
    @ApiOperation(value="编辑状态" ,httpMethod="POST")
    public ReturnEntity editState(@ApiParam(name = "rid", value = "主键id", required = true) @RequestParam Integer rid,
                                  @ApiParam(name = "sfky", value = "可用 0 可用 1 停用", required = true) @RequestParam String sfky)  {
        opFwtxxSer.getEntityMapper().editState(rid, sfky, DateUtil.getCurrentTimestamp());
        return ReturnEntityUtil.success();
    }

    /** 新增 */
    @RequestMapping("/add")
    @ResponseBody
    @ApiOperation(value="新增" ,httpMethod="POST")
    public ReturnEntity<OpFwtxxResp> add(@Valid OpFwtxxAddReq opFwtxx) {
        opFwtxx.setJgid(getUser().getHospitalId());
        opFwtxxSer.insertFwt(opFwtxx);
        return ReturnEntityUtil.success();
    }


    /**
     * 通过科室或者诊室名称查询分诊台
     * @param condition
     * @return
     */
    @RequestMapping("/queryFwtIdByKsmcOrZsmc")
    @ResponseBody
    @ApiOperation(value="通过科室或者诊室名称查询分诊台" ,httpMethod="POST")
    public ReturnEntity<Integer> queryFwtIdByKsmcOrZsmc(@ApiParam(name = "condition", value = "科室或者诊室名称", required = true) @RequestParam String condition) {
        return ReturnEntityUtil.success(opFwtxxSer.queryFwtIdByKsmcOrZsmc(getUser().getHospitalId(),condition));
    }


//
//    @RequestMapping("/findList")
//    @ResponseBody
//    @ApiOperation(value="按条件查询-返回列表" ,httpMethod="POST")
//    public ReturnEntity<List<OpFwtxxResp>> getByEntity( OpFwtxxReq opfwtxx){//@RequestBody
//        return ReturnEntityUtil.success(opFwtxxSer.findByEntity(opfwtxx));
//    }
//
//    @RequestMapping("/getOneByEntity")
//    @ResponseBody
//    @ApiOperation(value="按条件查询-返回唯一值" ,httpMethod="POST")
//    public ReturnEntity<OpFwtxxResp> getOneByEntity(OpFwtxxReq opfwtxx){
//        List<OpFwtxx> list=opFwtxxSer.findByEntity(opfwtxx);
//        if(list.size()>0){
//           return ReturnEntityUtil.success(list.get(0));
//        }
//        return ReturnEntityUtil.success();
//    }


}

