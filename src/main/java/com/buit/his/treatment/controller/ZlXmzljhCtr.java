package com.buit.his.treatment.controller;

import com.buit.commons.BaseSpringController;
import com.buit.his.treatment.model.ZlXmzljh;
import com.buit.his.treatment.request.ZlXmzljhUpdateReq;
import com.buit.his.treatment.response.ZlXmzljhResp;
import com.buit.his.treatment.service.ZlXmzljhSer;
import com.buit.utill.ReturnEntity;
import com.buit.utill.ReturnEntityUtil;
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

import javax.validation.Valid;

/**
 * 治疗项目治疗计划表<br>
 *
 * @author ZHOUHAISHENG
 */
@Api(tags = "治疗项目治疗计划表")
@Controller
@RequestMapping("/zlxmzljh")
public class ZlXmzljhCtr extends BaseSpringController {

    static final Logger logger = LoggerFactory.getLogger(ZlXmzljhCtr.class);

    @Autowired
    private ZlXmzljhSer zlXmzljhSer;

    /**
     * 获取项目治疗计划的详情
     *
     * @param xmjlxh
     * @return
     */
    @RequestMapping("/getDetails")
    @ResponseBody
    @ApiOperationSupport(author = "zhouhaisheng")
    @ApiOperation(value = "获取项目治疗计划的详情", httpMethod = "POST")
    public ReturnEntity<ZlXmzljhResp> getDetails(Integer xmjlxh) {
        ZlXmzljhResp zlXmzljhResp = null;
        ZlXmzljh zlxm = zlXmzljhSer.getByXmjlxh(xmjlxh);
        if (zlxm != null) {
            zlXmzljhResp = new ZlXmzljhResp();
            BeanUtils.copyProperties(zlxm, zlXmzljhResp);
        }
        return ReturnEntityUtil.success(zlXmzljhResp);
    }

    /**
     * 项目治疗计划编辑
     *
     * @param zlXmzljhUpdate
     * @return
     */
    @RequestMapping("/edit")
    @ResponseBody
    @ApiOperationSupport(author = "zhouhaisheng")
    @ApiOperation(value = "项目治疗计划编辑", httpMethod = "POST")
    public ReturnEntity<String> edit(@Valid ZlXmzljhUpdateReq zlXmzljhUpdate) {
        return zlXmzljhSer.edit(zlXmzljhUpdate, getUser());
    }

}

