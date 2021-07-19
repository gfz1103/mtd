
package com.buit.his.sams.controller;

import com.buit.his.sams.model.SsTsss;
import com.buit.his.sams.request.SsTsssAddReq;
import com.buit.his.sams.request.SsTsssReq;
import com.buit.his.sams.response.SsTsssResp;
import com.buit.his.sams.service.SsTsssSer;
import com.buit.commons.BaseSpringController;

import com.buit.utill.BeanUtil;
import com.buit.utill.ReturnEntity;
import com.buit.utill.ReturnEntityUtil;
import com.github.xiaoymin.knife4j.annotations.ApiOperationSupport;
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

import java.util.List;

/**
 * 特殊手术<br>
 * @author zhouhaishenng
 */
@Api(tags="特殊手术")
@Controller
@RequestMapping("/sstsss")
public class SsTsssCtr extends BaseSpringController{
    
    static final Logger logger = LoggerFactory.getLogger(SsTsssCtr.class);
    
    @Autowired
    private SsTsssSer ssTsssSer;
    
//    @RequestMapping("/queryPage")
//    @ResponseBody
//    @ApiOperationSupport(author = "zhouhaisheng")
//    @ApiOperation(value="按条件分页查询" ,httpMethod="POST")
//    public ReturnEntity<PageInfo<SsTsssResp>> queryPage(SsTsssReq sstsss,PageQuery page){
//        PageInfo<SsTsss> pageInfo = PageHelper.startPage(
//            page.getPageNum(), page.getPageSize()).doSelectPageInfo(
//                    () -> ssTsssSer.findByEntity(sstsss)
//            );
//        return ReturnEntityUtil.success(pageInfo);
//    }
//

    /**
     * 查询特殊手术列表
     * @return
     */
    @RequestMapping("/findList")
    @ResponseBody
    @ApiOperationSupport(author = "zhouhaisheng")
    @ApiOperation(value="查询特殊手术列表" ,httpMethod="POST")
    public ReturnEntity<List<SsTsssResp>> findList(){//@RequestBody
        SsTsss ssTsss=new SsTsss();
        ssTsss.setJgid(getUser().getHospitalId());
        List<SsTsss> list= ssTsssSer.findByEntity(ssTsss);

        return ReturnEntityUtil.success(BeanUtil.toBeans(list,SsTsssResp.class));
    }

    /**
     * 查询特殊手术详情
     * @param jlxh
     * @return
     */
    @RequestMapping("/getDetail")
    @ResponseBody
    @ApiOperationSupport(author = "zhouhaisheng")
    @ApiOperation(value="查询特殊手术详情" ,httpMethod="POST")
    public ReturnEntity<SsTsssResp> getDetail(Integer jlxh){

        return ReturnEntityUtil.success(BeanUtil.toBean(ssTsssSer.getById(jlxh),SsTsssResp.class));
    }

    /**
     * 新增特殊手术信息
     * @param ssTsssAddReq
     * @return
     */
    @RequestMapping("/add")
    @ResponseBody
    @ApiOperationSupport(author = "zhouhaisheng")
    @ApiOperation(value="新增特殊手术特" ,httpMethod="POST")
    public ReturnEntity<String> add(SsTsssAddReq ssTsssAddReq) {
        ssTsssAddReq.setJgid(getUser().getHospitalId());
        ssTsssSer.add(ssTsssAddReq);
        return ReturnEntityUtil.success();
    }

    /**
     * 修改特殊手术信息
     * @param ssTsss
     * @return
     */
    @RequestMapping("/edit")
    @ResponseBody
    @ApiOperationSupport(author = "zhouhaisheng")
    @ApiOperation(value="修改特殊手术信息" ,httpMethod="POST")
    public ReturnEntity<String> edit(SsTsssReq ssTsss)  {

        ssTsssSer.edit(ssTsss);
        return ReturnEntityUtil.success();
    }

    /**
     * 删除特殊手术信息
     * @param jlxh
     * @return
     */
    @RequestMapping("/delete")
    @ResponseBody
    @ApiOperationSupport(author = "zhouhaisheng")
    @ApiOperation(value="删除特殊手术信息" ,httpMethod="POST")
    public ReturnEntity<String> delete(Integer jlxh) {
        ssTsssSer.removeById(jlxh);
        return ReturnEntityUtil.success();
    }


    /***
     * 启用或者停用特殊手术
     * @param jlxh
     * @return
     */
    @RequestMapping("/enableZt")
    @ResponseBody
    @ApiOperationSupport(author = "zhouhaisheng")
    @ApiOperation(value="启用或者停用手术类型" ,httpMethod="POST")
    public ReturnEntity<String> enableZt (@ApiParam(name = "jlxh", value = "记录序号", required = true) @RequestParam(value = "jlxh") Integer jlxh,
                                          @ApiParam(name = "zt", value = "状态0 使用/1 停用", required = true) @RequestParam(value = "zt")   String zt) {
        ssTsssSer.enableZt(jlxh,zt);
        return ReturnEntityUtil.success();
    }
}

