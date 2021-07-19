
package com.buit.his.op.queuing.controller;


import com.buit.commons.BaseSpringController;
import com.buit.commons.PageQuery;
import com.buit.his.op.queuing.model.OpJzdlResult;
import com.buit.his.op.queuing.request.OpZspdxxReq;
import com.buit.his.op.queuing.response.MpiBrdaResp;
import com.buit.his.op.queuing.response.OpZspdxxResp;
import com.buit.his.op.queuing.service.OpZspdxxSer;
import com.buit.system.response.HrPersonnelResp;
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
import java.sql.Date;
import java.util.List;

/**
 * 门诊就诊队列<br>
 * @author 老花生
 */
@Api(tags="门诊就诊队列")
@Controller
@RequestMapping("/opzspdxx")
public class OpZspdxxCtr extends BaseSpringController {
    
    static final Logger logger = LoggerFactory.getLogger(OpZspdxxCtr.class);
    
    @Autowired
    private OpZspdxxSer opZspdxxSer;
    
//    @RequestMapping("/queryPage")
//    @ResponseBody
//    @ApiOperation(value="按条件分页查询" ,httpMethod="POST")
//    public ReturnEntity<PageInfo<OpZspdxxResp>> queryPage(OpZspdxxReq opzspdxx,PageQuery page){
//        PageInfo<OpZspdxx> pageInfo = PageHelper.startPage(
//            page.getPageNum(), page.getPageSize()).doSelectPageInfo(
//                    () -> opZspdxxSer.findByEntity(opzspdxx)
//            );
//        return ReturnEntityUtil.success(pageInfo);
//    }
//    
    @RequestMapping("/findList")
    @ResponseBody
    @ApiOperation(value="按条件查询-返回列表" ,httpMethod="POST")
    public ReturnEntity<List<OpZspdxxResp>> getByEntity(@Valid OpZspdxxReq opzspdxx){//@RequestBody
        opzspdxx.setJgid(getUser().getHospitalId());
        List<OpZspdxxResp> resp = opZspdxxSer.query(opzspdxx);
        return ReturnEntityUtil.success(resp);
    }

    @RequestMapping("/appointDoctor")
    @ResponseBody
    @ApiOperation(value="指定医生" ,httpMethod="POST")
    public ReturnEntity appointDoctor(@ApiParam(name = "oid", value = "主键ID", required = true) @RequestParam(value = "oid") Integer oid,
                                      @ApiParam(name = "ysdm", value = "医生代码", required = true) @RequestParam(value = "ysdm") Integer ysdm,
                                      @ApiParam(name = "lsh", value = "就诊流水号", required = true) @RequestParam(value = "lsh") String lsh){
        opZspdxxSer.appointDoctor(oid, ysdm, lsh);
        return ReturnEntityUtil.success();
    }


    @RequestMapping("/callNumber")
    @ResponseBody
    @ApiOperation(value="叫号" ,httpMethod="POST")
    public ReturnEntity callNumber(@ApiParam(name = "ysdm", value = "医生代码", required = true) @RequestParam(value = "ysdm") Integer ysdm,
                                   @ApiParam(name = "lsh", value = "就诊流水号", required = true) @RequestParam(value = "lsh") String lsh){
        opZspdxxSer.callNumber(ysdm, lsh, getUser(), getIpAddress());
        return ReturnEntityUtil.success();
    }


    @RequestMapping("/getBrdaByBrid")
    @ResponseBody
    @ApiOperation(value="查询病人档案信息" ,httpMethod="POST")
    public ReturnEntity<MpiBrdaResp> getBrdaByBrid(@ApiParam(name = "brid", value = "病人id", required = true) @RequestParam(value = "brid") Integer brid){
        MpiBrdaResp resp = opZspdxxSer.getBrdaByBrid(brid, getUser().getHospitalId());
        return ReturnEntityUtil.success(resp);
    }

    @RequestMapping("/waitQueueResult")
    @ResponseBody
    @ApiOperation(value = "资源排队情况条件分页查询", httpMethod = "POST", notes = "资源排队情况查询")
    public ReturnEntity<PageInfo<OpJzdlResult>> waitQueueResult(
            @ApiParam(name = "ksid", value = "科室ID") @RequestParam(value = "ksid", required = false) Integer ksid,
            @ApiParam(name = "zsid", value = "诊室ID") @RequestParam(value = "zsid", required = false) Integer zsid,
            @ApiParam(name = "jhsj", value = "就诊时间") @RequestParam(value = "jhsj", required = false) Date jhsj,
            PageQuery page) {
        PageInfo<OpJzdlResult> pageInfo = PageHelper.startPage(page.getPageNum(), page.getPageSize())
                .doSelectPageInfo(() -> opZspdxxSer.getOutWaitQueueList(ksid,zsid,jhsj,getUser().getHospitalId()));
        return ReturnEntityUtil.success(pageInfo);
    }

    @RequestMapping("/queryLoginDoctor")
    @ResponseBody
    @ApiOperation(value = "查询在线医生", httpMethod = "POST")
    public ReturnEntity<List<HrPersonnelResp>> queryLoginDoctor(
            @ApiParam(name = "ksid", value = "科室ID") @RequestParam(value = "ksid", required = false) Integer ksid) {
        List<HrPersonnelResp> resp = opZspdxxSer.queryLoginDoctor(ksid);
        return ReturnEntityUtil.success(resp);
    }



//    
//    @RequestMapping("/getOneByEntity")
//    @ResponseBody
//    @ApiOperation(value="按条件查询-返回唯一值" ,httpMethod="POST")
//    public ReturnEntity<OpZspdxxResp> getOneByEntity(OpZspdxxReq opzspdxx){
//        List<OpZspdxx> list=opZspdxxSer.findByEntity(opzspdxx);
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
//    public ReturnEntity<OpZspdxxResp> add(OpZspdxxReq opZspdxx) {
//        opZspdxxSer.insert(opZspdxx);        
//        return ReturnEntityUtil.success(opZspdxx);            
//    }
//    /** 编辑 */
//    @RequestMapping("/edit")
//    @ResponseBody
//    @ApiOperation(value="编辑" ,httpMethod="POST")
//    public ReturnEntity<OpZspdxxResp> edit(OpZspdxxReq opZspdxx)  {
//        opZspdxxSer.update(opZspdxx);        
//        return ReturnEntityUtil.success(opZspdxx);            
//    }
//    
//    /** 删除 */
//    @RequestMapping("/delete")
//    @ResponseBody
//    @ApiOperation(value="按条件查询" ,httpMethod="POST")
//    public ReturnEntity<OpZspdxxResp> delete(OpZspdxxReq opZspdxx) {
//        opZspdxxSer.removeByEntity(opZspdxx);        
//        return ReturnEntityUtil.success(opZspdxx);            
//    }
    
}

