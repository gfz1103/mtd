
package com.buit.his.op.queuing.controller;


import cn.hutool.core.date.DateUtil;
import com.buit.commons.BaseSpringController;
import com.buit.his.op.queuing.model.OpBcsj;
import com.buit.his.op.queuing.request.OpBcsjReq;
import com.buit.his.op.queuing.response.OpBcsjResp;
import com.buit.his.op.queuing.service.OpBcsjSer;
import com.buit.utill.BeanUtil;
import com.buit.utill.ReturnEntity;
import com.buit.utill.ReturnEntityUtil;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/**
 * 班次上下班时间字典<br>
 * @author 老花生
 */
@Api(tags="班次上下班时间字典")
@Controller
@RequestMapping("/opbcsj")
public class OpBcsjCtr extends BaseSpringController{
    
    static final Logger logger = LoggerFactory.getLogger(OpBcsjCtr.class);
    
    @Autowired
    private OpBcsjSer opBcsjSer;
    
//    @RequestMapping("/queryPage")
//    @ResponseBody
//    @ApiOperation(value="按条件分页查询" ,httpMethod="POST")
//    public ReturnEntity<PageInfo<OpBcsjResp>> queryPage(OpBcsjReq opbcsj,PageQuery page){
//        PageInfo<OpBcsj> pageInfo = PageHelper.startPage(
//            page.getPageNum(), page.getPageSize()).doSelectPageInfo(
//                    () -> opBcsjSer.findByEntity(opbcsj)
//            );
//        return ReturnEntityUtil.success(pageInfo);
//    }

    @RequestMapping("/findList")
    @ResponseBody
    @ApiOperation(value="班次列表" ,httpMethod="POST")
    public ReturnEntity<List<OpBcsjResp>> getByEntity(){//@RequestBody
        List<OpBcsj> ret = opBcsjSer.findByEntity(new OpBcsj());
        return ReturnEntityUtil.success(BeanUtil.toBeans(ret, OpBcsjResp.class));
    }

    @RequestMapping("/edit")
    @ResponseBody
    @ApiOperation(value="编辑" ,httpMethod="POST")
    public ReturnEntity edit(OpBcsjReq req)  {
        //Long num = opBcsjSer.getEntityMapper().queryRepeatNum(req);
        opBcsjSer.getEntityMapper().update(req);
        return ReturnEntityUtil.success();
    }
//    
//    @RequestMapping("/getOneByEntity")
//    @ResponseBody
//    @ApiOperation(value="按条件查询-返回唯一值" ,httpMethod="POST")
//    public ReturnEntity<OpBcsjResp> getOneByEntity(OpBcsjReq opbcsj){
//        List<OpBcsj> list=opBcsjSer.findByEntity(opbcsj);
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
//    public ReturnEntity<OpBcsjResp> add(OpBcsjReq opBcsj) {
//        opBcsjSer.insert(opBcsj);        
//        return ReturnEntityUtil.success(opBcsj);            
//    }

//    
//    /** 删除 */
//    @RequestMapping("/delete")
//    @ResponseBody
//    @ApiOperation(value="按条件查询" ,httpMethod="POST")
//    public ReturnEntity<OpBcsjResp> delete(OpBcsjReq opBcsj) {
//        opBcsjSer.removeByEntity(opBcsj);        
//        return ReturnEntityUtil.success(opBcsj);            
//    }
    
}

