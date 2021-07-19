
package com.buit.his.treatment.controller;

import com.buit.his.treatment.request.ZlSqdxmzlnrReq;
import com.buit.his.treatment.response.ZlSqdxmzlnrResp;
import com.buit.his.treatment.service.ZlSqdxmzlnrSer;
import com.buit.commons.BaseSpringController;

import com.buit.utill.ReturnEntity;
import com.buit.utill.ReturnEntityUtil;
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
 * 治疗申请单项目治疗内容表<br>
 * @author ZHOUHAISHENG
 */
@Api(tags="治疗申请单项目治疗内容表")
@Controller
@RequestMapping("/zlsqdxmzlnr")
public class ZlSqdxmzlnrCtr extends BaseSpringController{
    
    static final Logger logger = LoggerFactory.getLogger(ZlSqdxmzlnrCtr.class);
    
    @Autowired
    private ZlSqdxmzlnrSer zlSqdxmzlnrSer;
    
//    @RequestMapping("/queryPage")
//    @ResponseBody
//    @ApiOperation(value="按条件分页查询" ,httpMethod="POST")
//    public ReturnEntity<PageInfo<ZlSqdxmzlnrResp>> queryPage(ZlSqdxmzlnrReq zlsqdxmzlnr,PageQuery page){
//        PageInfo<ZlSqdxmzlnr> pageInfo = PageHelper.startPage(
//            page.getPageNum(), page.getPageSize()).doSelectPageInfo(
//                    () -> zlSqdxmzlnrSer.findByEntity(zlsqdxmzlnr)
//            );
//        return ReturnEntityUtil.success(pageInfo);
//    }
//

    /**
     * 查询病人治疗预约治疗内容列表
     * @param zlSqdmxJlxh
     * @return
     */
    @RequestMapping("/findList")
    @ResponseBody
    @ApiOperationSupport(author = "zhouhaisheng")
    @ApiOperation(value="查询病人治疗预约治疗内容列表" ,httpMethod="POST")
    public ReturnEntity<List<ZlSqdxmzlnrResp>> findList(Integer zlSqdmxJlxh){//@RequestBody
        return ReturnEntityUtil.success(zlSqdxmzlnrSer.findList(zlSqdmxJlxh));
    }

//    @RequestMapping("/getOneByEntity")
//    @ResponseBody
//    @ApiOperation(value="按条件查询-返回唯一值" ,httpMethod="POST")
//    public ReturnEntity<ZlSqdxmzlnrResp> getOneByEntity(ZlSqdxmzlnrReq zlsqdxmzlnr){
//        List<ZlSqdxmzlnr> list=zlSqdxmzlnrSer.findByEntity(zlsqdxmzlnr);
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
//    public ReturnEntity<ZlSqdxmzlnrResp> add(ZlSqdxmzlnrReq zlSqdxmzlnr) {
//        zlSqdxmzlnrSer.insert(zlSqdxmzlnr);        
//        return ReturnEntityUtil.success(zlSqdxmzlnr);            
//    }

    /**
     * 修改病人治疗预约资料内容
     * @param zlSqdxmzlnrReqs
     * @return
     */
    @RequestMapping("/edit")
    @ResponseBody
    @ApiOperationSupport(author = "zhouhaisheng")
    @ApiOperation(value="修改病人治疗预约资料内容" ,httpMethod="POST")
    public ReturnEntity<String> edit(@RequestBody  List<ZlSqdxmzlnrReq> zlSqdxmzlnrReqs)  {
        zlSqdxmzlnrSer.edit(zlSqdxmzlnrReqs);
        return ReturnEntityUtil.success();
    }
//    
//    /** 删除 */
//    @RequestMapping("/delete")
//    @ResponseBody
//    @ApiOperation(value="按条件查询" ,httpMethod="POST")
//    public ReturnEntity<ZlSqdxmzlnrResp> delete(ZlSqdxmzlnrReq zlSqdxmzlnr) {
//        zlSqdxmzlnrSer.removeByEntity(zlSqdxmzlnr);        
//        return ReturnEntityUtil.success(zlSqdxmzlnr);            
//    }
    
}

