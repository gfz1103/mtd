
package com.buit.his.sams.controller;

import com.buit.his.sams.model.SsGlbz;
import com.buit.his.sams.request.SsGlbzAddReq;
import com.buit.his.sams.request.SsGlbzReq;
import com.buit.his.sams.response.SsGlbzResp;
import com.buit.his.sams.service.SsGlbzSer;
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
 * 隔离标志<br>
 * @author zhouhaishenng
 */
@Api(tags="隔离标志")
@Controller
@RequestMapping("/ssglbz")
public class SsGlbzCtr extends BaseSpringController{
    
    static final Logger logger = LoggerFactory.getLogger(SsGlbzCtr.class);
    
    @Autowired
    private SsGlbzSer ssGlbzSer;
    
//    @RequestMapping("/queryPage")
//    @ResponseBody
//    @ApiOperationSupport(author = "zhouhaisheng")
//    @ApiOperation(value="按条件分页查询" ,httpMethod="POST")
//    public ReturnEntity<PageInfo<SsGlbzResp>> queryPage(SsGlbzReq ssglbz, PageQuery page){
//        PageInfo<SsGlbz> pageInfo = PageHelper.startPage(
//            page.getPageNum(), page.getPageSize()).doSelectPageInfo(
//                    () -> ssGlbzSer.findByEntity(ssglbz)
//            );
//        return ReturnEntityUtil.success(pageInfo);
//    }

    /**
     * 分页查询隔离标志
     * @return
     */
    @RequestMapping("/findList")
    @ResponseBody
    @ApiOperationSupport(author = "zhouhaisheng")
    @ApiOperation(value="分页查询隔离标志" ,httpMethod="POST")
    public ReturnEntity<List<SsGlbzResp>> getByEntity(){
        SsGlbz param=new SsGlbz();
        param.setJgid(getUser().getHospitalId());
        List<SsGlbz> ssGlbzList=ssGlbzSer.findByEntity(param);

        return ReturnEntityUtil.success(BeanUtil.toBeans(ssGlbzList,SsGlbzResp.class));
    }

    /**
     * 查询隔离标志设置详情
     * @param jlxh
     * @return
     */
    @RequestMapping("/getDetail")
    @ResponseBody
    @ApiOperationSupport(author = "zhouhaisheng")
    @ApiOperation(value="查询隔离标志设置详情" ,httpMethod="POST")
    public ReturnEntity<SsGlbzResp> getDetail(Integer jlxh){
        SsGlbz ssGlbz=ssGlbzSer.getById(jlxh);
        SsGlbzResp resp=new SsGlbzResp();
        BeanUtils.copyProperties(ssGlbz,resp);
        return ReturnEntityUtil.success(resp);
    }

    /**
     *新增隔离标志信息
     *
     * @param ssGlbzAdd
     * @return
     */
    @RequestMapping("/add")
    @ResponseBody
    @ApiOperationSupport(author = "zhouhaisheng")
    @ApiOperation(value="新增" ,httpMethod="POST")
    public ReturnEntity<SsGlbzResp> add(SsGlbzAddReq ssGlbzAdd) {
        ssGlbzAdd.setJgid(getUser().getHospitalId());
        ssGlbzSer.add(ssGlbzAdd);
        return ReturnEntityUtil.success();
    }

    /***
     * 修改隔离标志设置信息
     * @param ssGlbz
     * @return
     */
    @RequestMapping("/edit")
    @ResponseBody
    @ApiOperationSupport(author = "zhouhaisheng")
    @ApiOperation(value="编辑" ,httpMethod="POST")
    public ReturnEntity<SsGlbzResp> edit(SsGlbzReq ssGlbz)  {
        ssGlbzSer.edit(ssGlbz);
        return ReturnEntityUtil.success();
    }

    /***
     * 删除隔离标志信息
     * @param jlxh
     * @return
     */
    @RequestMapping("/delete")
    @ResponseBody
    @ApiOperationSupport(author = "zhouhaisheng")
    @ApiOperation(value="删除隔离标志信息" ,httpMethod="POST")
    public ReturnEntity<String> delete(Integer jlxh) {
        ssGlbzSer.removeById(jlxh);
        return ReturnEntityUtil.success();
    }
    /***
     * 启用或者停用隔离标志信息
     * @param jlxh
     * @return
     */
    @RequestMapping("/enableZt")
    @ResponseBody
    @ApiOperationSupport(author = "zhouhaisheng")
    @ApiOperation(value="启用或者停用隔离标志信息" ,httpMethod="POST")
    public ReturnEntity<String> enableZt (@ApiParam(name = "jlxh", value = "记录序号", required = true) @RequestParam(value = "jlxh") Integer jlxh,
                                          @ApiParam(name = "zt", value = "状态0 使用/1 停用", required = true) @RequestParam(value = "zt")   String zt) {
        ssGlbzSer.enableZt(jlxh,zt);
        return ReturnEntityUtil.success();
    }



}

