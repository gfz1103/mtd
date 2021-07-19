package com.buit.his.sams.controller;


import com.buit.commons.BaseSpringController;
import com.buit.his.sams.request.SsPubReq;
import com.buit.his.sams.request.SsmzxmReq;
import com.buit.his.sams.request.SsssrtjReq;
import com.buit.his.sams.response.*;
import com.buit.his.sams.service.SsReportSer;
import com.buit.utill.DateUtils;
import com.buit.utill.ReturnEntity;
import com.buit.utill.ReturnEntityUtil;
import com.github.xiaoymin.knife4j.annotations.ApiOperationSupport;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/**
 * 手术麻醉查询统计<br>
 * @author zhouhaishenng
 */
@Api(tags="手术麻醉查询统计")
@Controller
@RequestMapping("/ssReport")
public class SsReportCtr extends BaseSpringController {

    @Autowired
    private SsReportSer ssReportSer;

    /**
     * 手术麻醉项目统计
     * @param ssmzxmReq
     * @return
     */
    @RequestMapping("/querySsmzxm")
    @ResponseBody
    @ApiOperationSupport(author = "zhouhaisheng")
    @ApiOperation(value="手术麻醉项目统计" ,httpMethod="POST")
    public ReturnEntity<List<SsmzxmResp>> querySsmzxm(SsmzxmReq ssmzxmReq){
        ssmzxmReq.setStartDate(DateUtils.getDailyStartTime(ssmzxmReq.getStartDate()));
        ssmzxmReq.setEndDate(DateUtils.getDailyEndTime(ssmzxmReq.getEndDate()));
        return ReturnEntityUtil.success(ssReportSer.querySsmzxm(ssmzxmReq));

    }

    /**
     * 手术间工作量统计
     * @param ssPubReq
     * @return
     */
    @RequestMapping("/querySsjgzltj")
    @ResponseBody
    @ApiOperationSupport(author = "zhouhaisheng")
    @ApiOperation(value="手术间工作量统计" ,httpMethod="POST")
    public ReturnEntity<List<SsjgzltjResp>> querySsjgzltj(SsPubReq ssPubReq){
        ssPubReq.setStartDate(DateUtils.getDailyStartTime(ssPubReq.getStartDate()));
        ssPubReq.setEndDate(DateUtils.getDailyEndTime(ssPubReq.getEndDate()));
        return ReturnEntityUtil.success(ssReportSer.querySsjgzltj(ssPubReq));

    }

    /**
     * 麻醉医生工作量统计
     * @param ssPubReq
     * @return
     */
    @RequestMapping("/queryMzysgzltj")
    @ResponseBody
    @ApiOperationSupport(author = "zhouhaisheng")
    @ApiOperation(value="麻醉医生工作量统计" ,httpMethod="POST")
    public ReturnEntity<List<MzysgzltjResp>> queryMzysgzltj(SsPubReq ssPubReq) {
        ssPubReq.setStartDate(DateUtils.getDailyStartTime(ssPubReq.getStartDate()));
        ssPubReq.setEndDate(DateUtils.getDailyEndTime(ssPubReq.getEndDate()));
        return ReturnEntityUtil.success(ssReportSer.queryMzysgzltj(ssPubReq));

    }

    /**
     * 手术医生工作量统计
     * @param ssPubReq
     * @return
     */
    @RequestMapping("/querySsysgzltj")
    @ResponseBody
    @ApiOperationSupport(author = "zhouhaisheng")
    @ApiOperation(value="手术医生工作量统计" ,httpMethod="POST")
    public ReturnEntity<List<SsysgzltjResp>> querySsysgzltj(SsPubReq ssPubReq) {
        ssPubReq.setStartDate(DateUtils.getDailyStartTime(ssPubReq.getStartDate()));
        ssPubReq.setEndDate(DateUtils.getDailyEndTime(ssPubReq.getEndDate()));
        return ReturnEntityUtil.success(ssReportSer.querySsysgzltj(ssPubReq));

    }
    /**
     * 手术科室工作量统计
     * @param ssPubReq
     * @return
     */
    @RequestMapping("/querySsksgzltj")
    @ResponseBody
    @ApiOperationSupport(author = "zhouhaisheng")
    @ApiOperation(value="手术科室工作量统计" ,httpMethod="POST")
    public ReturnEntity<List<SsksgzltjResp>> querySsksgzltj(SsPubReq ssPubReq){
        ssPubReq.setStartDate(DateUtils.getDailyStartTime(ssPubReq.getStartDate()));
        ssPubReq.setEndDate(DateUtils.getDailyEndTime(ssPubReq.getEndDate()));
        return ReturnEntityUtil.success(ssReportSer.querySsksgzltj(ssPubReq));

    }

    /**
     * 手术室收入统计
     */
    @RequestMapping("/querySsssrtj")
    @ResponseBody
    @ApiOperationSupport(author = "zhouhaisheng")
    @ApiOperation(value = "手术室收入统计", httpMethod = "POST")
    public ReturnEntity<List<SsssrtjResp>> querySsssrtj(SsssrtjReq req) {
        req.setStartDate(DateUtils.getDailyStartTime(req.getStartDate()));
        req.setEndDate(DateUtils.getDailyEndTime(req.getEndDate()));
        return ReturnEntityUtil.success(ssReportSer.querySsssrtj(req));

    }

}
