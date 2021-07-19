
package com.buit.his.treatment.controller;

import com.buit.commons.BaseSpringController;
import com.buit.his.treatment.request.*;
import com.buit.his.treatment.response.*;
import com.buit.his.treatment.service.ZlSqdmxSer;
import com.buit.his.treatment.service.ZlSqdyyzxSer;
import com.buit.his.treatment.service.ZlSqdzbSer;
import com.buit.system.service.ExportFileSer;
import com.buit.utill.ReturnEntity;
import com.buit.utill.ReturnEntityUtil;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.github.xiaoymin.knife4j.annotations.ApiOperationSupport;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.apache.dubbo.config.annotation.DubboReference;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 治疗管理系统-查询统计<br>
 * @author ZHOUHAISHENG
 */
@Api(tags = "治疗管理系统-门诊查询统计")
@Controller
@RequestMapping("/zlReport")
public class ZlReportCtr extends BaseSpringController{
   static final Logger logger = LoggerFactory.getLogger(ZlReportCtr.class);
   @Autowired
   public ZlSqdzbSer zlSqdzbSer;
    @Autowired
    public ZlSqdyyzxSer zlSqdyyzxSer;
    @Autowired
    private ZlSqdmxSer zlSqdmxSer;
    @DubboReference
    private ExportFileSer exportFileSer;
    /**
     * 查询统计-病人治疗申请单查询
     * @param patientTreatFromQueryReq
     * @return
     */
    @RequestMapping("/queryPatientZlyyReport")
    @ResponseBody
    @ApiOperationSupport(author = "zhouhaisheng")
    @ApiOperation(value="病人治疗申请单查询" ,httpMethod="POST")
    public ReturnEntity<PageInfo<PatientTreatFromQueryResp>> queryPatientZlyyReport(PatientTreatFromQueryReq patientTreatFromQueryReq){
        patientTreatFromQueryReq.setJgid(getUser().getHospitalId());
        PageInfo<PatientTreatFromQueryResp> pageInfo = PageHelper.startPage(
                patientTreatFromQueryReq.getPageNum(), patientTreatFromQueryReq.getPageSize()).doSelectPageInfo(
                () -> zlSqdzbSer.queryPatientZlyyReport(patientTreatFromQueryReq,getUser())
        );
        return ReturnEntityUtil.success(pageInfo);
    }
    /**
     * 查询统计-病人治疗申请单-申请单治疗项目
     * @param queryPatientZlyyReportDetailReq
     * @return
     */
    @RequestMapping("/queryPatientZlyyReportDetail")
    @ResponseBody
    @ApiOperationSupport(author = "zhouhaisheng")
    @ApiOperation(value="查询统计-病人治疗申请单-申请单治疗项目" ,httpMethod="POST")
    public ReturnEntity<PageInfo<ZlSqdmxResp>> queryPatientZlyyReportDetail(QueryPatientZlyyReportDetailReq queryPatientZlyyReportDetailReq){
        queryPatientZlyyReportDetailReq.setJgid(getUser().getHospitalId());
        PageInfo<ZlSqdmxResp> pageInfo = PageHelper.startPage(
                queryPatientZlyyReportDetailReq.getPageNum(), queryPatientZlyyReportDetailReq.getPageSize()).doSelectPageInfo(
                () -> zlSqdmxSer.queryPatientZlyyReportDetail(queryPatientZlyyReportDetailReq.getZlsqdh(),getUser())
        );
        return ReturnEntityUtil.success(pageInfo);
    }

    /**
     * 查询统计-科室治疗工作量统计
     * @param deptTreatStatisticsReq
     * @return
     */
    @RequestMapping("/queryDeptTreatStatistics")
    @ResponseBody
    @ApiOperationSupport(author = "zhouhaisheng")
    @ApiOperation(value="查询统计-科室治疗工作量统计" ,httpMethod="POST")
    public ReturnEntity<PageInfo<DeptTreatStatisticsResp>> queryDeptTreatStatistics(DeptTreatStatisticsReq deptTreatStatisticsReq){
        deptTreatStatisticsReq.setJgid(getUser().getHospitalId());


        return ReturnEntityUtil.success(zlSqdzbSer.queryDeptTreatStatistics(deptTreatStatisticsReq));
    }
    /**
     * 查询统计-科室治疗工作量统计(明细)
     * @param deptTreatStatisticsDetailReq
     * @return
     */
    @RequestMapping("/queryDeptTreatStatisticsDetail")
    @ResponseBody
    @ApiOperationSupport(author = "zhouhaisheng")
    @ApiOperation(value="查询统计-科室治疗工作量统计(明细)" ,httpMethod="POST")
    public ReturnEntity<List<DeptTreatStatisticsDetailResp>> queryDeptTreatStatisticsDetail(DeptTreatStatisticsDetailReq deptTreatStatisticsDetailReq){
        deptTreatStatisticsDetailReq.setJgid(getUser().getHospitalId());
        return zlSqdyyzxSer.queryDeptTreatStatisticsDetail(deptTreatStatisticsDetailReq);
    }
    /**
     * 查询统计-医生治疗工作量统计（分页查询）
     *
     * @param doctorTreatStatisticsReq
     * @return
     */
    @RequestMapping("/queryDoctorTreatStatistics")
    @ResponseBody
    @ApiOperationSupport(author = "zhouhaisheng")
    @ApiOperation(value="查询统计-医生治疗工作量统计（分页查询)" ,httpMethod="POST")
    public ReturnEntity<PageInfo<DoctorTreatStatisticsResp>> queryDoctorTreatStatistics(DoctorTreatStatisticsReq doctorTreatStatisticsReq){
        doctorTreatStatisticsReq.setJgid(getUser().getHospitalId());
        PageInfo<DoctorTreatStatisticsResp> pageInfo = PageHelper.startPage(
                doctorTreatStatisticsReq.getPageNum(), doctorTreatStatisticsReq.getPageSize()).doSelectPageInfo(
                () -> zlSqdzbSer.queryDoctorTreatStatistics(doctorTreatStatisticsReq)
        );
        return ReturnEntityUtil.success(pageInfo);
    }

    /**
     * 查询统计-医生治疗工作量统计(明细明细 )
     *
     * @param doctorTreatStatisticsDetailReq
     * @return
     */
    @RequestMapping("/queryDoctorTreatStatisticsDetail")
    @ResponseBody
    @ApiOperationSupport(author = "zhouhaisheng")
    @ApiOperation(value="查询统计-医生治疗工作量统计（明细)" ,httpMethod="POST")
    public ReturnEntity<PageInfo<DoctorTreatStatisticsDetailResp>> queryDoctorTreatStatisticsDetail(DoctorTreatStatisticsDetailReq doctorTreatStatisticsDetailReq){
        doctorTreatStatisticsDetailReq.setJgid(getUser().getHospitalId());

        return ReturnEntityUtil.success(zlSqdzbSer.queryDoctorTreatStatisticsDetail(doctorTreatStatisticsDetailReq));
    }


    /**
     * 治疗预约指引单打印
     * @return
     */
    @RequestMapping("/yyzydPrint")
    @ResponseBody
    @ApiOperationSupport(author = "zhouhaisheng")
    @ApiOperation(value="治疗预约指引单打印" ,httpMethod="POST")
    public ReturnEntity<String> yyzydPrint(Integer jlxh){
        Map<String, Object> params = new HashMap<>();
        List<Map<String, Object>> list=new ArrayList<>();
        String jasperName="";


            jasperName="bookingGuide.jasper";
            params=zlSqdzbSer.getYyzydPrintParams(jlxh,getUser());
            list=zlSqdzbSer.getYyzydPrintFields(jlxh,getUser());

        String url = exportFileSer.reportHtml(list,
                params,
                jasperName);
        return ReturnEntityUtil.success(url);







    }


}

