package com.buit.his.treatment.controller;

import com.buit.commons.BaseSpringController;
import com.buit.commons.SysUser;
import com.buit.his.treatment.model.ZlZlzrw;
import com.buit.his.treatment.request.HistoryQueryAdviceReq;
import com.buit.his.treatment.request.HistoryQueryPatientReq;
import com.buit.his.treatment.response.HistoryAdviceResp;
import com.buit.his.treatment.response.HistoryPatientResp;
import com.buit.his.treatment.service.ZlRwfpSer;
import com.buit.his.treatment.service.ZlZlzrwSer;
import com.buit.utill.ReturnEntity;
import com.buit.utill.ReturnEntityUtil;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
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

import javax.validation.Valid;
import java.util.List;

/**
 * @author 蒋威
 * @Description 住院治疗记录
 * @Date 2021-05-08
 */
@Api(tags = "住院治疗记录")
@Controller
@RequestMapping("/history")
public class HistoryCtr extends BaseSpringController {

    static final Logger logger = LoggerFactory.getLogger(AppointmentCtr.class);

    @Autowired
    private ZlRwfpSer zlRwfpSer;
    @Autowired
    private ZlZlzrwSer zlZlzrwSer;

    @RequestMapping("/queryTreatmentPatientPage")
    @ResponseBody
    @ApiOperation(value = "查询住院患者治疗记录患者列表", httpMethod = "POST")
    public ReturnEntity<PageInfo<HistoryPatientResp>> queryPatientPage(@Valid HistoryQueryPatientReq req) {
        SysUser user = getUser();
        req.setJgid(user.getHospitalId());
        if (req.getType() != null && req.getType() == 1) {
            req.setZlsdm(user.getPersonId());
        }
        PageInfo<HistoryPatientResp> pageInfo = PageHelper.startPage(
                req.getPageNum(), req.getPageSize()).doSelectPageInfo(
                () -> zlRwfpSer.findTreatmentPatientList(req)
        );
        return ReturnEntityUtil.success(pageInfo);
    }

    @RequestMapping("/findTreatmentAdviceList")
    @ResponseBody
    @ApiOperation(value = "查询住院患者治疗记录医嘱列表", httpMethod = "POST")
    public ReturnEntity<List<HistoryAdviceResp>> findAdviceList(@Valid HistoryQueryAdviceReq req) {
        SysUser user = getUser();
        req.setJgid(user.getHospitalId());
        return ReturnEntityUtil.success(zlRwfpSer.findTreatmentAdviceList(req));
    }

    @RequestMapping("/findList")
    @ResponseBody
    @ApiOperation(value = "查询住院患者治疗记录列表", httpMethod = "POST")
    public ReturnEntity<List<ZlZlzrw>> findHistoryList(@ApiParam(name = "zlrwfpid", value = "治疗任务分配主键", required = true) @RequestParam Integer zlrwfpid) {
        return ReturnEntityUtil.success(zlZlzrwSer.findListByRwfpId(zlrwfpid));
    }


}
