
package com.buit.his.sams.controller;

import com.buit.commons.BaseSpringController;
import com.buit.his.sams.request.QuerySsjzPageReq;
import com.buit.his.sams.request.SsSsjzAddOrUpdateReq;
import com.buit.his.sams.response.QuerySsjzPageResp;
import com.buit.his.sams.response.SsjzBaseInfoResp;
import com.buit.his.sams.service.SsSsjzdzbSer;
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

import javax.validation.Valid;

/**
 * 手术记账单主表<br>
 *
 * @author zhouhaishenng
 */
@Api(tags = "手术记账单主表")
@Controller
@RequestMapping("/ssssjzdzb")
public class SsSsjzdzbCtr extends BaseSpringController {

    static final Logger logger = LoggerFactory.getLogger(SsSsjzdzbCtr.class);

    @Autowired
    private SsSsjzdzbSer ssSsjzdzbSer;


    /**
     * 新增或修改手术、麻醉记账
     *
     * @param ssSsjzAddOrUpdateReq
     * @return
     */
    @RequestMapping("/add")
    @ResponseBody
    @ApiOperationSupport(author = "zhouhaisheng")
    @ApiOperation(value = "新增或修改手术、麻醉记账", httpMethod = "POST")
    public ReturnEntity<String> add(@Valid @RequestBody SsSsjzAddOrUpdateReq ssSsjzAddOrUpdateReq) {
        if (ssSsjzAddOrUpdateReq.getJzdh() == null || ssSsjzAddOrUpdateReq.getJzdh() == 0) {
            ssSsjzdzbSer.add(ssSsjzAddOrUpdateReq, getUser());
        } else {
            ssSsjzdzbSer.update(ssSsjzAddOrUpdateReq, getUser());
        }
        return ReturnEntityUtil.success();
    }

    /**
     * 手术、麻醉记账审核
     *
     * @param ssSsjzAddOrUpdateReq
     * @return
     */
    @RequestMapping("/approve")
    @ResponseBody
    @ApiOperationSupport(author = "jiangwei")
    @ApiOperation(value = "手术申请单费用审核", httpMethod = "POST")
    public ReturnEntity<String> approve(@Valid @RequestBody SsSsjzAddOrUpdateReq ssSsjzAddOrUpdateReq) {
        ssSsjzdzbSer.approve(ssSsjzAddOrUpdateReq, getUser());
        return ReturnEntityUtil.success();
    }

    /**
     * 手术记账基本信息查询
     *
     * @param
     * @return
     */
    @RequestMapping("/querySsjzBaseInfo")
    @ResponseBody
    @ApiOperationSupport(author = "zhouhaisheng")
    @ApiOperation(value = "手术记账基本信息查询", httpMethod = "POST")
    public ReturnEntity<SsjzBaseInfoResp> querySsjzBaseInfo(Integer sqdh) {
        return ssSsjzdzbSer.querySsjzBaseInfo(sqdh);
    }

    /**
     * 手术记账病人分页查询
     *
     * @param
     * @return
     */
    @RequestMapping("/querySsjzPage")
    @ResponseBody
    @ApiOperationSupport(author = "zhouhaisheng")
    @ApiOperation(value = "手术记账病人分页查询", httpMethod = "POST")
    public ReturnEntity<PageInfo<QuerySsjzPageResp>> querySsjzPage(QuerySsjzPageReq querySsjzPageReq) {
        querySsjzPageReq.setStartDate(DateUtils.getDailyStartTime(querySsjzPageReq.getJzrq()));
        querySsjzPageReq.setEndDate(DateUtils.getDailyEndTime(querySsjzPageReq.getJzrq()));
        PageInfo<QuerySsjzPageResp> pageInfo = PageHelper.startPage(
                querySsjzPageReq.getPageNum(), querySsjzPageReq.getPageSize()).doSelectPageInfo(
                () -> ssSsjzdzbSer.querySsjzPage(querySsjzPageReq)
        );
        return ReturnEntityUtil.success(pageInfo);
    }

}

