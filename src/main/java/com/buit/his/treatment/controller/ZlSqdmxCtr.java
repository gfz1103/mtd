
package com.buit.his.treatment.controller;

import com.buit.his.treatment.request.ZlSqdmxReq;
import com.buit.his.treatment.response.ZlSqdmxResp;
import com.buit.his.treatment.service.ZlSqdmxSer;
import com.buit.commons.BaseSpringController;

import com.buit.utill.ReturnEntity;
import com.github.xiaoymin.knife4j.annotations.ApiOperationSupport;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/**
 * 治疗申请单明细表<br>
 * @author ZHOUHAISHENG
 */
@Api(tags="治疗申请单明细")
@Controller
@RequestMapping("/zlsqdmx")
public class ZlSqdmxCtr extends BaseSpringController{
    
    static final Logger logger = LoggerFactory.getLogger(ZlSqdmxCtr.class);
    
    @Autowired
    private ZlSqdmxSer zlSqdmxSer;
    
//    @RequestMapping("/queryPage")
//    @ResponseBody
//    @ApiOperation(value="按条件分页查询" ,httpMethod="POST")
//    public ReturnEntity<PageInfo<ZlSqdmxResp>> queryPage(ZlSqdmxReq zlsqdmx,PageQuery page){
//        PageInfo<ZlSqdmx> pageInfo = PageHelper.startPage(
//            page.getPageNum(), page.getPageSize()).doSelectPageInfo(
//                    () -> zlSqdmxSer.findByEntity(zlsqdmx)
//            );
//        return ReturnEntityUtil.success(pageInfo);
//    }
//    
//    @RequestMapping("/findList")
//    @ResponseBody
//    @ApiOperation(value="按条件查询-返回列表" ,httpMethod="POST")
//    public ReturnEntity<List<ZlSqdmxResp>> getByEntity( ZlSqdmxReq zlsqdmx){//@RequestBody 
//        return ReturnEntityUtil.success(zlSqdmxSer.findByEntity(zlsqdmx));    
//    }
//    
//    @RequestMapping("/getOneByEntity")
//    @ResponseBody
//    @ApiOperation(value="按条件查询-返回唯一值" ,httpMethod="POST")
//    public ReturnEntity<ZlSqdmxResp> getOneByEntity(ZlSqdmxReq zlsqdmx){
//        List<ZlSqdmx> list=zlSqdmxSer.findByEntity(zlsqdmx);
//        if(list.size()>0){
//           return ReturnEntityUtil.success(list.get(0));    
//        }
//        return ReturnEntityUtil.success();
//    }
//    

    /**
     * 新增病人治疗申请明细
     * @param zlSqdmxList
     * @return
     */
    @RequestMapping("/add")
    @ResponseBody
    @ApiOperationSupport(author = "zhouhaisheng")
    @ApiOperation(value="新增病人治疗申请明细" ,httpMethod="POST")
    public ReturnEntity<ZlSqdmxResp> add(@RequestBody List<ZlSqdmxReq> zlSqdmxList) {

        return  null;
    }
//    /** 编辑 */
//    @RequestMapping("/edit")
//    @ResponseBody
//    @ApiOperation(value="编辑" ,httpMethod="POST")
//    public ReturnEntity<ZlSqdmxResp> edit(ZlSqdmxReq zlSqdmx)  {
//        zlSqdmxSer.update(zlSqdmx);        
//        return ReturnEntityUtil.success(zlSqdmx);            
//    }
//

    /**
     * 删除病人治疗申请明细
     * @param zlSqdmx
     * @return
     */
    @RequestMapping("/delete")
    @ResponseBody
    @ApiOperationSupport(author = "zhouhaisheng")
    @ApiOperation(value="删除病人治疗申请明细" ,httpMethod="POST")
    public ReturnEntity<ZlSqdmxResp> delete(ZlSqdmxReq zlSqdmx) {

        return zlSqdmxSer.delete(zlSqdmx);
    }
    
}

