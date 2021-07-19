
package com.buit.his.sams.controller;

import com.buit.his.sams.model.SsSslx;
import com.buit.his.sams.request.SsSslxAddReq;
import com.buit.his.sams.request.SsSslxReq;
import com.buit.his.sams.response.SsSslxResp;
import com.buit.his.sams.service.SsSslxSer;
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
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/**
 * 手术类型<br>
 * @author zhouhaishenng
 */
@Api(tags="手术类型设置")
@Controller
@RequestMapping("/sssslx")
public class SsSslxCtr extends BaseSpringController{
    
    static final Logger logger = LoggerFactory.getLogger(SsSslxCtr.class);
    
    @Autowired
    private SsSslxSer ssSslxSer;
    
//    @RequestMapping("/queryPage")
//    @ResponseBody
//    @ApiOperationSupport(author = "zhouhaisheng")
//    @ApiOperation(value="按条件分页查询" ,httpMethod="POST")
//    public ReturnEntity<PageInfo<SsSslxResp>> queryPage(SsSslxReq sssslx,PageQuery page){
//        PageInfo<SsSslx> pageInfo = PageHelper.startPage(
//            page.getPageNum(), page.getPageSize()).doSelectPageInfo(
//                    () -> ssSslxSer.findByEntity(sssslx)
//            );
//        return ReturnEntityUtil.success(pageInfo);
//    }
//    
    @RequestMapping("/findList")
    @ResponseBody
    @ApiOperationSupport(author = "zhouhaisheng")
    @ApiOperation(value="按条件查询-返回列表" ,httpMethod="POST")
    public ReturnEntity<List<SsSslxResp>> findList(){
        SsSslx ssSslx=new SsSslx();
        ssSslx.setJgid(getUser().getHospitalId());
        List<SsSslx> list=ssSslxSer.findByEntity(ssSslx);

        return ReturnEntityUtil.success(BeanUtil.toBeans(list,SsSslxResp.class));
    }

    /**
     * 查询手术类型详情
     * @param jlxh
     * @return
     */
    @RequestMapping("/getDetail")
    @ResponseBody
    @ApiOperationSupport(author = "zhouhaisheng")
    @ApiOperation(value="按条件查询-返回唯一值" ,httpMethod="POST")
    public ReturnEntity<SsSslxResp> getDetail(Integer jlxh){
        SsSslx ssSslx=ssSslxSer.getById(jlxh);
        SsSslxResp resp=new SsSslxResp();
        BeanUtils.copyProperties(ssSslx,resp);
        return ReturnEntityUtil.success(resp);
    }

    /**
     * 新增手术类型
     * @param ssSslxAddReq
     * @return
     */
    @RequestMapping("/add")
    @ResponseBody
    @ApiOperationSupport(author = "zhouhaisheng")
    @ApiOperation(value="新增手术类型" ,httpMethod="POST")
    public ReturnEntity<SsSslxResp> add(SsSslxAddReq ssSslxAddReq) {
        ssSslxAddReq.setJgid(getUser().getHospitalId());
        ssSslxSer.add(ssSslxAddReq);
        return ReturnEntityUtil.success();
    }

    /**
     * 修改手术类型
     * @param ssSslx
     * @return
     */
    @RequestMapping("/edit")
    @ResponseBody
    @ApiOperationSupport(author = "zhouhaisheng")
    @ApiOperation(value="修改手术类型" ,httpMethod="POST")
    public ReturnEntity<String> edit(SsSslxReq ssSslx)  {
        ssSslxSer.edit(ssSslx);
        return ReturnEntityUtil.success();
    }

    /**
     * 删除单个手术类型
     * @param jlxh
     * @return
     */
    @RequestMapping("/delete")
    @ResponseBody
    @ApiOperationSupport(author = "zhouhaisheng")
    @ApiOperation(value="删除单个手术类型" ,httpMethod="POST")
    public ReturnEntity<String> delete(Integer jlxh) {
        ssSslxSer.removeById(jlxh);
        return ReturnEntityUtil.success();
    }

    /***
     * 启用或者停用手术类型
     * @param jlxh
     * @return
     */
    @RequestMapping("/enableZt")
    @ResponseBody
    @ApiOperationSupport(author = "zhouhaisheng")
    @ApiOperation(value="启用或者停用手术类型" ,httpMethod="POST")
    public ReturnEntity<String> enableZt (@ApiParam(name = "jlxh", value = "记录序号", required = true) @RequestParam(value = "jlxh") Integer jlxh,
                                          @ApiParam(name = "zt", value = "状态0 使用/1 停用", required = true) @RequestParam(value = "zt")   String zt) {
        ssSslxSer.enableZt(jlxh,zt);
        return ReturnEntityUtil.success();
    }

}

