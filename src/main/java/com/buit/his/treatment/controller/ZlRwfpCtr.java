
package com.buit.his.treatment.controller;

import com.buit.commons.BaseSpringController;
import com.buit.his.treatment.preService.ZlRwfpPreService;
import com.buit.his.treatment.request.ZlRwfpPatientQueryReq;
import com.buit.his.treatment.request.ZlRwfpQueryReq;
import com.buit.his.treatment.request.ZlRwfpReq;
import com.buit.his.treatment.request.ZlRwlbEditReq;
import com.buit.his.treatment.response.ZlRwfpPatientResp;
import com.buit.his.treatment.response.ZlRwfpResp;
import com.buit.his.treatment.service.ZlRwfpSer;
import com.buit.utill.ReturnEntity;
import com.buit.utill.ReturnEntityUtil;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.validation.Valid;
import java.util.List;

/**
 * 康复治疗任务分配表<br>
 *
 * @author 韦靖
 */
@Api(tags = "康复治疗任务分配表")
@Validated
@Controller
@RequestMapping("/zlrwfp")
public class ZlRwfpCtr extends BaseSpringController {

    static final Logger logger = LoggerFactory.getLogger(ZlRwfpCtr.class);

    @Autowired
    private ZlRwfpSer zlRwfpSer;

    @Autowired
    private ZlRwfpPreService zlRwfpPreService;

    @RequestMapping("/queryPatientPage")
    @ResponseBody
    @ApiOperation(value = "查询住院任务分配患者列表", httpMethod = "POST")
    public ReturnEntity<PageInfo<ZlRwfpPatientResp>> queryPatientPage(@Valid ZlRwfpPatientQueryReq req) {
        req.setJgid(getUser().getHospitalId());
        PageInfo<ZlRwfpPatientResp> pageInfo = PageHelper.startPage(
                req.getPageNum(), req.getPageSize()).doSelectPageInfo(
                () -> zlRwfpSer.queryRwfpPatientPage(req)
        );
        return ReturnEntityUtil.success(pageInfo);
    }

    @RequestMapping("/queryRwfp")
    @ResponseBody
    @ApiOperation(value = "查询患者的治疗任务列表", httpMethod = "POST")
    public ReturnEntity<List<ZlRwfpResp>> queryRwfp(@Valid ZlRwfpQueryReq req) {
        req.setJgid(getUser().getHospitalId());
        return ReturnEntityUtil.success(zlRwfpSer.queryRwfp(req));
    }

    @RequestMapping("/edit")
    @ResponseBody
    @ApiOperation(value = "更改项目类别", httpMethod = "POST")
    public ReturnEntity edit(@Valid @RequestBody List<ZlRwlbEditReq> reqs) {
        for (ZlRwlbEditReq req : reqs) {
            zlRwfpSer.edit(req);
        }
        return ReturnEntityUtil.success();
    }

    @RequestMapping("/rwfp")
    @ResponseBody
    @ApiOperation(value = "任务分配", httpMethod = "POST")
    public ReturnEntity rwfp(@Valid @RequestBody List<ZlRwfpReq> reqs) {
        for (ZlRwfpReq req : reqs) {
            zlRwfpPreService.rwfp(req);
        }
        return ReturnEntityUtil.success();
    }

}

