package com.buit.his.sams.controller;

import com.buit.commons.BaseSpringController;
import com.buit.commons.PageQuery;
import com.buit.system.response.SsInputResp;
import com.buit.system.service.FeeYlsfxmOutSer;
import com.buit.utill.ReturnEntity;
import com.buit.utill.ReturnEntityUtil;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.apache.dubbo.config.annotation.DubboReference;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * 手术费用输入法
 * zhouhaisheng
 */
@Api(tags="手术费用输入法")
@Controller
@RequestMapping("/ssInput")
public class SsInputCtr extends BaseSpringController {
    static final Logger logger = LoggerFactory.getLogger(SsGlbzCtr.class);
    @DubboReference
    private FeeYlsfxmOutSer feeYlsfxmSer;

    /**
     * 手术费用输入法-材料
     * @param pydm
     * @param page
     * @return
     */
    @RequestMapping("/ssInputMaterial")
    @ResponseBody
    @ApiOperation(value="手术费用输入法-材料字典" ,httpMethod="POST")
    public ReturnEntity<PageInfo<SsInputResp>> querySsInputMaterial(
            @ApiParam(name = "pydm", value = "拼音代码") @RequestParam(required = false) String pydm, PageQuery page){

        return ReturnEntityUtil.success(feeYlsfxmSer.querySsInputMaterialPage(getUser().getHospitalId(),pydm,page));
    }

    /**
     * 手术费用输入法-项目
     * @param pydm
     * @param page
     * @return
     */
    @RequestMapping("/ssInputItem")
    @ResponseBody
    @ApiOperation(value="手术费用输入法-项目" ,httpMethod="POST")
    public ReturnEntity<PageInfo<SsInputResp>> querySsInputItem(
            @ApiParam(name = "pydm", value = "拼音代码") @RequestParam(required = false) String pydm, PageQuery page){

        return ReturnEntityUtil.success(feeYlsfxmSer.querySsInputItemPage(getUser().getHospitalId(),pydm,page));
    }


}
