
package com.buit.his.treatment.controller;

import com.buit.commons.BaseSpringController;
import com.buit.his.treatment.request.ZlSqdzbPageQueryReq;
import com.buit.his.treatment.request.ZlSqdzbReq;
import com.buit.his.treatment.request.ZlSqdzbUpdateReq;
import com.buit.his.treatment.request.ZlyyPageQueryReq;
import com.buit.his.treatment.response.ZlSqdmxResp;
import com.buit.his.treatment.response.ZlSqdzbPageResp;
import com.buit.his.treatment.response.ZlSqdzbResp;
import com.buit.his.treatment.response.ZlyyPageQueryResp;
import com.buit.his.treatment.service.ZlSqdmxSer;
import com.buit.his.treatment.service.ZlSqdzbSer;
import com.buit.utill.DateUtils;
import com.buit.utill.ReturnEntity;
import com.buit.utill.ReturnEntityUtil;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.github.xiaoymin.knife4j.annotations.ApiOperationSupport;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.validation.Valid;
import java.util.List;

/**
 * 治疗申请单主表<br>
 *
 * @author ZHOUHAISHENG
 */
@Api(tags = "治疗申请单主表")
@Controller
@RequestMapping("/zlsqdzb")
public class ZlSqdzbCtr extends BaseSpringController {

    static final Logger logger = LoggerFactory.getLogger(ZlSqdzbCtr.class);

    @Autowired
    private ZlSqdzbSer zlSqdzbSer;
    @Autowired
    private ZlSqdmxSer zlSqdmxSer;

    @RequestMapping("/queryPage")
    @ResponseBody
    @ApiOperationSupport(author = "zhouhaisheng")
    @ApiOperation(value = "查询病人治疗申请单列表(门诊医生站)", httpMethod = "POST")
    public ReturnEntity<PageInfo<ZlSqdzbPageResp>> queryPage(@Valid ZlSqdzbPageQueryReq req) {
        req.setJgid(getUser().getHospitalId());
        req.setStartDate(DateUtils.getDailyStartTime(req.getStartDate()));
        req.setEndDate(DateUtils.getDailyEndTime(req.getEndDate()));

        PageInfo<ZlSqdzbPageResp> pageInfo = PageHelper.startPage(
                req.getPageNum(), req.getPageSize()).doSelectPageInfo(
                () -> zlSqdzbSer.queryPage(req)
        );
        return ReturnEntityUtil.success(pageInfo);
    }

    /**
     * 分页查询病人治疗预约信息
     *
     * @param req
     * @param
     * @return
     */
    @RequestMapping("/queryAppointPage")
    @ResponseBody
    @ApiOperationSupport(author = "zhouhaisheng")
    @ApiOperation(value = "分页查询病人治疗预约信息(康复治疗)", httpMethod = "POST")
    public ReturnEntity<PageInfo<ZlyyPageQueryResp>> queryZlyyPage(@Valid ZlyyPageQueryReq req) {
        req.setJgid(getUser().getHospitalId());
        //req.setZlksdm(getUser().getDeptId());
        req.setStartDate(DateUtils.getDailyStartTime(req.getStartDate()));
        req.setEndDate(DateUtils.getDailyEndTime(req.getEndDate()));
        PageInfo<ZlyyPageQueryResp> pageInfo = PageHelper.startPage(
                req.getPageNum(), req.getPageSize()).doSelectPageInfo(
                () -> zlSqdzbSer.queryAppointPage(req)
        );
        return ReturnEntityUtil.success(pageInfo);
    }

    /**
     * 查询治疗申请单详情
     *
     * @param jlxh
     * @return
     */
    @RequestMapping("/getDetail")
    @ResponseBody
    @ApiOperationSupport(author = "zhouhaisheng")
    @ApiOperation(value = "查询治疗申请单详情", httpMethod = "POST")
    public ReturnEntity<ZlSqdzbResp> getDetail(Integer jlxh) {

        return zlSqdzbSer.getDetail(jlxh);
    }


    /**
     * 新增病人治疗申请
     *
     * @param zlSqdzb
     * @return
     */
    @RequestMapping("/add")
    @ResponseBody
    @ApiOperationSupport(author = "zhouhaisheng")
    @ApiOperation(value = "新增病人治疗申请(门诊医生站)", httpMethod = "POST")
    public ReturnEntity<String> add(@Valid @RequestBody ZlSqdzbReq zlSqdzb) {

        return zlSqdzbSer.add(zlSqdzb, getUser());
    }

    /**
     * 病人治疗申请修改
     *
     * @param zlSqdzbUpdateReq
     * @return
     */
    @RequestMapping("/edit")
    @ResponseBody
    @ApiOperationSupport(author = "zhouhaisheng")
    @ApiOperation(value = "病人治疗申请修改(门诊医生站)", httpMethod = "POST")
    public ReturnEntity<String> edit(@RequestBody ZlSqdzbUpdateReq zlSqdzbUpdateReq) {

        return zlSqdzbSer.edit(zlSqdzbUpdateReq, getUser());
    }

    /**
     * 治疗申请单作废
     *
     * @param jlxh
     * @return
     */
    @RequestMapping("/cancel")
    @ResponseBody
    @ApiOperationSupport(author = "zhouhaisheng")
    @ApiOperation(value = "治疗申请单作废(门诊医生站)", httpMethod = "POST")
    public ReturnEntity<String> cancel(Integer jlxh) {
        return zlSqdzbSer.cancel(jlxh, getUser().getUserId());
    }

    @RequestMapping("/delete")
    @ResponseBody
    @ApiOperation(value = "治疗申请单删除(门诊医生站)", httpMethod = "POST")
    public ReturnEntity<String> delete(Integer jlxh) {
        return zlSqdzbSer.deleteZlsq(jlxh);
    }

    /**
     * 查询治疗预约的治疗项目
     *
     * @param zlsqdh
     * @return
     */
    @RequestMapping("/findZlyyZlxmList")
    @ResponseBody
    @ApiOperationSupport(author = "zhouhaisheng")
    @ApiOperation(value = "查询治疗预约的治疗项目", httpMethod = "POST")
    public ReturnEntity<List<ZlSqdmxResp>> findZlyyZlxmList(@ApiParam(name = "zlsqdh", value = "治疗申请单号", required = true) @RequestParam String zlsqdh) {
        return ReturnEntityUtil.success(zlSqdmxSer.findZlyyZlxmList(zlsqdh, getUser()));
    }


//    @RequestMapping("/queryZyzlyy")
//    @ResponseBody
//    @ApiOperation(value = "查询住院治疗预约数据（住院）", httpMethod = "POST")
//    public ReturnEntity<PageInfo<QueryZyzlyyResp>> queryZyzlyy(@Valid QueryZyzlyyReq req, PageQuery page) {
//        req.setJgid(getUser().getHospitalId());//医疗机构代码
//        req.setZxks(getUser().getDeptId());//执行科室
//        PageInfo<QueryZyzlyyResp> pageInfo = PageHelper.startPage(
//                page.getPageNum(), page.getPageSize()).doSelectPageInfo(
//                () -> zlSqdzbSer.queryZyzlyy(req)
//        );
//        return ReturnEntityUtil.success(pageInfo);
//    }

//    @RequestMapping("/queryZyzDetail")
//    @ResponseBody
//    @ApiOperation(value = "查询住院治疗预约治疗项目数据（住院）", httpMethod = "POST")
//    public ReturnEntity<List<QueryZyzlyyDetailResp>> queryZyzDetail(@Valid QueryZyzlyyDetailReq req) {
//        req.setJgid(getUser().getHospitalId());//医疗机构代码
//        req.setZxks(getUser().getDeptId());//执行科室
//        return ReturnEntityUtil.success(zlSqdzbSer.zyzlyyDetail(req));
//    }

//    @RequestMapping("/applyZyzlyy")
//    @ResponseBody
//    @ApiOperation(value = "住院治疗预约（住院）", httpMethod = "POST")
//    public ReturnEntity applyZyzlyy(@RequestBody List<ApplyZyzlyyReq> req) {
//        zlSqdzbSer.applyZyzlyy(req, getUser());
//        return ReturnEntityUtil.success();
//    }

//    @RequestMapping("/impleZyzlyy")
//    @ResponseBody
//    @ApiOperation(value = "查询住院治疗执行数据（住院）", httpMethod = "POST")
//    public ReturnEntity<List<ImpleZyzlyyResp>> impleZyzlyy(@Valid ImpleZyzlyyReq req) {
//        req.setJgid(getUser().getHospitalId());
//        req.setZxks(getUser().getDeptId());
//        return ReturnEntityUtil.success(zlSqdzbSer.impleZyzlyy(req));
//    }

//    @RequestMapping("/queryZxXm")
//    @ResponseBody
//    @ApiOperation(value = "通过住院号查询患者需要执行的项目（住院）", httpMethod = "POST")
//    public ReturnEntity<List<QueryZyzlZxDetailResp>> queryZxXm(@Valid QueryZyzlZxDetailReq req) {
//        req.setJgid(getUser().getHospitalId());
//        req.setZxks(getUser().getDeptId());
//        return ReturnEntityUtil.success(zlSqdzbSer.queryZxXm(req));
//    }
}

