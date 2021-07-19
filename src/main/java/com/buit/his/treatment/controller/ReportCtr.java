
package com.buit.his.treatment.controller;

import com.buit.commons.BaseSpringController;
import com.buit.his.treatment.request.AppointmentReportReq;
import com.buit.his.treatment.request.DeptWorkloadReportReq;
import com.buit.his.treatment.request.DoctorWorkloadReportReq;
import com.buit.his.treatment.request.WorkloadDetailReq;
import com.buit.his.treatment.response.AppointmentReportResp;
import com.buit.his.treatment.response.DeptWorkloadReportResp;
import com.buit.his.treatment.response.DoctorWorkloadReportResp;
import com.buit.his.treatment.response.WorkloadDetailResp;
import com.buit.his.treatment.service.ZlRwmbSer;
import com.buit.his.treatment.service.ZlZlzrwSer;
import com.buit.utill.DateUtils;
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
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.validation.Valid;

/**
 * 治疗管理系统-查询统计<br>
 *
 * @author ZHOUHAISHENG
 */
@Api(tags = "治疗管理系统-住院查询统计")
@Controller
@RequestMapping("/report")
public class ReportCtr extends BaseSpringController {
    static final Logger logger = LoggerFactory.getLogger(ReportCtr.class);

    @Autowired
    private ZlRwmbSer zlRwmbSer;
    @Autowired
    private ZlZlzrwSer zlZlzrwSer;

    @RequestMapping("/appointmentReport")
    @ResponseBody
    @ApiOperation(value = "住院病人治疗预约查询", httpMethod = "POST")
    public ReturnEntity<PageInfo<AppointmentReportResp>> appointmentReport(@Valid AppointmentReportReq req) {
        req.setJgid(getUser().getHospitalId());
        PageInfo<AppointmentReportResp> pageInfo = PageHelper.startPage(
                req.getPageNum(), req.getPageSize()).doSelectPageInfo(
                () -> zlRwmbSer.queryAppointmentReportPage(req)
        );
        return ReturnEntityUtil.success(pageInfo);
    }

    @RequestMapping("/deptWorkloadReport")
    @ResponseBody
    @ApiOperation(value = "科室治疗工作量统计", httpMethod = "POST")
    public ReturnEntity<PageInfo<DeptWorkloadReportResp>> deptWorkloadReport(@Valid DeptWorkloadReportReq req) {
        req.setJgid(getUser().getHospitalId());
        req.setKsrq(DateUtils.getDailyStartTime(req.getKsrq()));
        req.setJsrq(DateUtils.getDailyEndTime(req.getJsrq()));

        PageInfo<DeptWorkloadReportResp> pageInfo = PageHelper.startPage(
                req.getPageNum(), req.getPageSize()).doSelectPageInfo(
                () -> zlZlzrwSer.queryDeptWorkloadReportPage(req)
        );
        return ReturnEntityUtil.success(pageInfo);
    }

    @RequestMapping("/doctorWorkloadReport")
    @ResponseBody
    @ApiOperation(value = "医生治疗工作量统计", httpMethod = "POST")
    public ReturnEntity<PageInfo<DoctorWorkloadReportResp>> doctorWorkloadReport(@Valid DoctorWorkloadReportReq req) {
        req.setJgid(getUser().getHospitalId());
        req.setKsrq(DateUtils.getDailyStartTime(req.getKsrq()));
        req.setJsrq(DateUtils.getDailyEndTime(req.getJsrq()));

        PageInfo<DoctorWorkloadReportResp> pageInfo = PageHelper.startPage(
                req.getPageNum(), req.getPageSize()).doSelectPageInfo(
                () -> zlZlzrwSer.queryDoctorWorkloadReportPage(req)
        );
        return ReturnEntityUtil.success(pageInfo);
    }

    @RequestMapping("/WorkloadReportDetail")
    @ResponseBody
    @ApiOperation(value = "病人治疗项目详细记录", httpMethod = "POST")
    public ReturnEntity<PageInfo<WorkloadDetailResp>> workloadReportDetailPage(@Valid WorkloadDetailReq req) {
        req.setJgid(getUser().getHospitalId());
        req.setKsrq(DateUtils.getDailyStartTime(req.getKsrq()));
        req.setJsrq(DateUtils.getDailyEndTime(req.getJsrq()));

        PageInfo<WorkloadDetailResp> pageInfo = PageHelper.startPage(
                req.getPageNum(), req.getPageSize()).doSelectPageInfo(
                () -> zlZlzrwSer.queryWorkloadReportDetailPage(req)
        );
        return ReturnEntityUtil.success(pageInfo);
    }

}

