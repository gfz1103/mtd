
package com.buit.his.sams.controller;

import com.buit.commons.BaseSpringController;
import com.buit.his.sams.request.QuerySsjzPageReq;
import com.buit.his.sams.request.RefundSureQueryPageReq;
import com.buit.his.sams.request.SsZytfsqzbAddReq;
import com.buit.his.sams.response.RefundSureQueryPageResp;
import com.buit.his.sams.response.SsZytfQueryPageResp;
import com.buit.his.sams.service.SsZytfsqzbSer;
import com.buit.utill.DateUtils;
import com.buit.utill.ReturnEntity;
import com.buit.utill.ReturnEntityUtil;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.github.xiaoymin.knife4j.annotations.ApiOperationSupport;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.math.BigDecimal;

/**
 * 住院退费申请主表<br>
 *
 * @author zhouhaishenng
 */
@Api(tags = "住院退费申请主表")
@Controller
@RequestMapping("/sszytfsqzb")
public class SsZytfsqzbCtr extends BaseSpringController {

    static final Logger logger = LoggerFactory.getLogger(SsZytfsqzbCtr.class);

    @Autowired
    private SsZytfsqzbSer ssZytfsqzbSer;

    /**
     * 住院退费申请(分页查询记账病人)
     */
    @RequestMapping("/queryPage")
    @ResponseBody
    @ApiOperationSupport(author = "zhouhaisheng")
    @ApiOperation(value = "住院退费申请(分页查询记账病人)", httpMethod = "POST")
    public ReturnEntity<PageInfo<SsZytfQueryPageResp>> queryPage(QuerySsjzPageReq req) {
        req.setStartDate(DateUtils.getDailyStartTime(req.getJzrq()));
        req.setEndDate(DateUtils.getDailyEndTime(req.getJzrq()));
        PageInfo<SsZytfQueryPageResp> pageInfo = PageHelper.startPage(
                req.getPageNum(), req.getPageSize()).doSelectPageInfo(
                () -> ssZytfsqzbSer.queryPage(req)
        );
        return ReturnEntityUtil.success(pageInfo);
    }

    /**
     * 根据记账信息 计算可退数量
     */
    @RequestMapping("/countTfsl")
    @ResponseBody
    @ApiOperationSupport(author = "jiangwei")
    @ApiOperation(value = "计算可退数量", httpMethod = "POST")
    public ReturnEntity<BigDecimal> add(Integer jlxh) {
        return ReturnEntityUtil.success(ssZytfsqzbSer.countTfsl(jlxh));
    }

    /**
     * 新增住院退费信息
     *
     * @param ssZytfsqzb
     * @return
     */
    @RequestMapping("/add")
    @ResponseBody
    @ApiOperationSupport(author = "zhouhaisheng")
    @ApiOperation(value = "新增住院退费信息", httpMethod = "POST")
    public ReturnEntity<BigDecimal> add(@RequestBody SsZytfsqzbAddReq ssZytfsqzb) {
        ssZytfsqzb.setJgid(getUser().getHospitalId());
        ssZytfsqzbSer.add(ssZytfsqzb, getUser());
        return ReturnEntityUtil.success();
    }

    /**
     * 住院确认退费分页查询
     *
     * @param refundSureQueryPageReq
     * @return
     */
    @RequestMapping("/queryRefundSurePage")
    @ResponseBody
    @ApiOperationSupport(author = "zhouhaisheng")
    @ApiOperation(value = "住院确认退费分页查询)", httpMethod = "POST")
    public ReturnEntity<PageInfo<RefundSureQueryPageResp>> queryRefundSurePage(RefundSureQueryPageReq refundSureQueryPageReq) {
        PageInfo<RefundSureQueryPageResp> pageInfo = PageHelper.startPage(
                refundSureQueryPageReq.getPageNum(), refundSureQueryPageReq.getPageSize()).doSelectPageInfo(
                () -> ssZytfsqzbSer.queryRefundSurePage(refundSureQueryPageReq, getUser())
        );
        return ReturnEntityUtil.success(pageInfo);
    }

    /**
     * 住院确认退费确认
     *
     * @param tfsqdh
     * @return
     */
    @RequestMapping("/refundSure")
    @ResponseBody
    @ApiOperationSupport(author = "zhouhaisheng")
    @ApiOperation(value = "住院确认退费确认)", httpMethod = "POST")
    public ReturnEntity<String> refundSure(Integer tfsqdh) {
        ssZytfsqzbSer.refundSure(tfsqdh, getUser());
        return ReturnEntityUtil.success();
    }


}

