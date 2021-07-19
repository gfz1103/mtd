
package com.buit.his.sams.controller;

import com.buit.his.sams.model.SsSsj;
import com.buit.his.sams.request.SsSsjQueryPageReq;
import com.buit.his.sams.request.SsSsjReq;
import com.buit.his.sams.request.SsSsjReqQueryListReq;
import com.buit.his.sams.response.SsSsjResp;
import com.buit.his.sams.service.SsSsjSer;
import com.buit.commons.BaseSpringController;

import com.buit.utill.BeanUtil;
import com.buit.utill.ReturnEntity;
import com.buit.utill.ReturnEntityUtil;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.github.xiaoymin.knife4j.annotations.ApiOperationSupport;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/**
 * 手术间设置表<br>
 * @author zhouhaishenng
 */
@Api(tags="手术间设置")
@Controller
@RequestMapping("/ssssj")
public class SsSsjCtr extends BaseSpringController{
    
    static final Logger logger = LoggerFactory.getLogger(SsSsjCtr.class);
    
    @Autowired
    private SsSsjSer ssSsjSer;

    /**
     *手术间设置分页查询
     * @param req
     * @return
     */
    @RequestMapping("/queryPage")
    @ResponseBody
    @ApiOperationSupport(author = "zhouhaisheng")
    @ApiOperation(value="手术间设置分页查询" ,httpMethod="POST")
    public ReturnEntity<PageInfo<SsSsjResp>> queryPage(SsSsjQueryPageReq req){
        req.setJgid(getUser().getHospitalId());
        PageInfo<SsSsjResp> pageInfo = PageHelper.startPage(
                req.getPageNum(), req.getPageSize()).doSelectPageInfo(
                    () -> ssSsjSer.queryPage(req)
            );
        return ReturnEntityUtil.success(pageInfo);
    }

    /**
     * 查询手术间列表
     * @param req
     * @return
     */
    @RequestMapping("/findList")
    @ResponseBody
    @ApiOperationSupport(author = "zhouhaisheng")
    @ApiOperation(value="按条件查询-返回列表" ,httpMethod="POST")
    public ReturnEntity<List<SsSsjResp>> findList(SsSsjReqQueryListReq req){
        SsSsj ssSsj=new SsSsj();
        ssSsj.setJgid(getUser().getHospitalId());
        ssSsj.setSsksdm(req.getSsksdm());

        return ReturnEntityUtil.success(BeanUtil.toBeans(ssSsjSer.findByEntity(ssSsj),SsSsjResp.class));
    }


    /***
     * 查询手术间设置详情信息
     * @param jlxh
     * @return
     */
    @RequestMapping("/getDetail")
    @ResponseBody
    @ApiOperationSupport(author = "zhouhaisheng")
    @ApiOperation(value="查询手术间设置详情信息" ,httpMethod="POST")
    public ReturnEntity<SsSsjResp> getDetail(Integer jlxh){
       SsSsj ssSsj=ssSsjSer.getById(jlxh);
       SsSsjResp resp=new SsSsjResp();
        BeanUtils.copyProperties(ssSsj,resp);
        return ReturnEntityUtil.success(resp);
    }

    /**
     * 新增手术间设置信息
     * @param ssSsj
     * @return
     */
    @RequestMapping("/add")
    @ResponseBody
    @ApiOperationSupport(author = "zhouhaisheng")
    @ApiOperation(value="新增" ,httpMethod="POST")
    public ReturnEntity<SsSsjResp> add(SsSsjReq ssSsj) {
        ssSsj.setJgid(getUser().getHospitalId());
        ssSsjSer.add(ssSsj);
        return ReturnEntityUtil.success();
    }

    /**
     * 修改手术间设置信息
     * @param ssSsj
     * @return
     */
    @RequestMapping("/edit")
    @ResponseBody
    @ApiOperationSupport(author = "zhouhaisheng")
    @ApiOperation(value="修改手术间设置信息" ,httpMethod="POST")
    public ReturnEntity<String> edit(SsSsjReq ssSsj)  {
        ssSsjSer.update(ssSsj);
        return ReturnEntityUtil.success();
    }

    /**
     * 删除手术间设置信息
     * @param jlxh
     * @return
     */
    @RequestMapping("/delete")
    @ResponseBody
    @ApiOperationSupport(author = "zhouhaisheng")
    @ApiOperation(value="删除手术间设置信息" ,httpMethod="POST")
    public ReturnEntity<String> delete(Integer jlxh) {
        ssSsjSer.removeById(jlxh);
        return ReturnEntityUtil.success();
    }
    /***
     * 启用或者停用手术间
     * @param jlxh
     * @return
     */
    @RequestMapping("/enableZt")
    @ResponseBody
    @ApiOperationSupport(author = "zhouhaisheng")
    @ApiOperation(value="启用或者停用手术间" ,httpMethod="POST")
    public ReturnEntity<String> enableZt (@ApiParam(name = "jlxh", value = "记录序号", required = true) @RequestParam(value = "jlxh") Integer jlxh,
                                          @ApiParam(name = "zt", value = "状态0 使用/1 停用", required = true) @RequestParam(value = "zt")   String zt) {
        ssSsjSer.enableZt(jlxh,zt);
        return ReturnEntityUtil.success();
    }


}

