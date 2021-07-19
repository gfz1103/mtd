
package com.buit.his.sams.controller;

import com.buit.his.sams.model.SsJzmbzb;
import com.buit.his.sams.request.SsJzmbzbAddReq;
import com.buit.his.sams.request.SsJzmbzbPageQueryReq;
import com.buit.his.sams.request.SsJzmbzbReq;
import com.buit.his.sams.response.SsJzmbzbResp;
import com.buit.his.sams.service.SsJzmbzbSer;
import com.buit.commons.BaseSpringController;

import com.buit.utill.ReturnEntity;
import com.buit.utill.ReturnEntityUtil;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.github.xiaoymin.knife4j.annotations.ApiOperationSupport;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/**
 * 手术/麻醉记账模板主表<br>
 * @author zhouhaishenng
 */
@Api(tags="手术麻醉记账模板")
@Controller
@RequestMapping("/ssjzmbzb")
public class SsJzmbzbCtr extends BaseSpringController{
    
    static final Logger logger = LoggerFactory.getLogger(SsJzmbzbCtr.class);
    
    @Autowired
    private SsJzmbzbSer ssJzmbzbSer;


    /**
     * 分页查询手术麻醉记账模板
     * @param ssJzmbzbPageQueryReq
     * @return
     */
    @RequestMapping("/queryPage")
    @ResponseBody
    @ApiOperationSupport(author = "zhouhaisheng")
    @ApiOperation(value="分页查询手术麻醉记账模板" ,httpMethod="POST")
    public ReturnEntity<List<SsJzmbzbResp>> queryPage(SsJzmbzbPageQueryReq ssJzmbzbPageQueryReq){
        ssJzmbzbPageQueryReq.setJgid(getUser().getHospitalId());

        return ReturnEntityUtil.success(ssJzmbzbSer.findList(ssJzmbzbPageQueryReq));
    }

//    @RequestMapping("/findList")
//    @ResponseBody
//    @ApiOperationSupport(author = "zhouhaisheng")
//    @ApiOperation(value="按条件查询-返回列表" ,httpMethod="POST")
//    public ReturnEntity<List<SsJzmbzbResp>> getByEntity(SsJzmbzbReq ssjzmbzb){//@RequestBody
//
//        return ReturnEntityUtil.success(ssJzmbzbSer.findByEntity(ssjzmbzb));
//    }

    /**
     * 查询手术/麻醉记账模板详情
     * @param jlxh
     * @return
     */
    @RequestMapping("/getDetail")
    @ResponseBody
    @ApiOperationSupport(author = "zhouhaisheng")
    @ApiOperation(value="查询手术麻醉记账模板详情" ,httpMethod="POST")
    public ReturnEntity<SsJzmbzbResp> getDetail(Integer jlxh){
        SsJzmbzb ssJzmbzb=ssJzmbzbSer.getById(jlxh);
        SsJzmbzbResp ssJzmbzbResp=new SsJzmbzbResp();
        BeanUtils.copyProperties(ssJzmbzb,ssJzmbzbResp);
        return ReturnEntityUtil.success(ssJzmbzbResp);
    }

    /**
     * 新增手术/麻醉记账模板
     * @param ssJzmbzbAddReq
     * @return
     */
    @RequestMapping("/add")
    @ResponseBody
    @ApiOperationSupport(author = "zhouhaisheng")
    @ApiOperation(value="新增手术麻醉记账模板" ,httpMethod="POST")
    public ReturnEntity<String> add(SsJzmbzbAddReq ssJzmbzbAddReq) {
        ssJzmbzbSer.add(ssJzmbzbAddReq,getUser());
        return ReturnEntityUtil.success();
    }

    /**
     * 手术/麻醉记账模板修改
     * @param ssJzmbzb
     * @return
     */
    @RequestMapping("/edit")
    @ResponseBody
    @ApiOperationSupport(author = "zhouhaisheng")
    @ApiOperation(value="手术麻醉记账模板修改" ,httpMethod="POST")
    public ReturnEntity<String> edit(SsJzmbzbReq ssJzmbzb)  {
        ssJzmbzbSer.update(ssJzmbzb);
        return ReturnEntityUtil.success();
    }

    /**
     * 删除手术/麻醉记账模板
     * @param jlxh
     * @return
     */
    @RequestMapping("/delete")
    @ResponseBody
    @ApiOperationSupport(author = "zhouhaisheng")
    @ApiOperation(value="删除手术麻醉记账模板" ,httpMethod="POST")
    public ReturnEntity<SsJzmbzbResp> delete(Integer jlxh) {
        ssJzmbzbSer.removeById(jlxh);
        return ReturnEntityUtil.success();
    }
    
}

