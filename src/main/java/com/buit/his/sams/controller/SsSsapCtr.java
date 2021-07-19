
package com.buit.his.sams.controller;

import com.buit.commons.BaseSpringController;
import com.buit.his.sams.request.SsSsapQueryPageReq;
import com.buit.his.sams.request.SsSsapUpdateReq;
import com.buit.his.sams.request.SsapViewQueryPageReq;
import com.buit.his.sams.response.SsSsapQueryPageResp;
import com.buit.his.sams.service.SsSsapSer;
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
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * 手术安排表<br>
 *
 * @author zhouhaishenng
 */
@Api(tags = "手术安排表")
@Controller
@RequestMapping("/ssssap")
public class SsSsapCtr extends BaseSpringController {

    static final Logger logger = LoggerFactory.getLogger(SsSsapCtr.class);

    @Autowired
    private SsSsapSer ssSsapSer;

    /**
     * 手术安排分页查询
     *
     * @param ssSsapQueryPageReq
     * @return
     */
    @RequestMapping("/queryPage")
    @ResponseBody
    @ApiOperationSupport(author = "zhouhaisheng")
    @ApiOperation(value = "手术安排分页查询", httpMethod = "POST")
    public ReturnEntity<PageInfo<SsSsapQueryPageResp>> queryPage(SsSsapQueryPageReq ssSsapQueryPageReq) {
        ssSsapQueryPageReq.setStartDate(DateUtils.getDailyStartTime(ssSsapQueryPageReq.getStartDate()));
        ssSsapQueryPageReq.setEndDate(DateUtils.getDailyEndTime(ssSsapQueryPageReq.getEndDate()));

        PageInfo<SsSsapQueryPageResp> pageInfo = PageHelper.startPage(
                ssSsapQueryPageReq.getPageNum(), ssSsapQueryPageReq.getPageSize()).doSelectPageInfo(
                () -> ssSsapSer.queryPage(ssSsapQueryPageReq)
        );
        return ReturnEntityUtil.success(pageInfo);
    }

    /**
     * 手术申请安排
     *
     * @param ssSsapUpdateReq
     * @return
     */
    @RequestMapping("/add")
    @ResponseBody
    @ApiOperationSupport(author = "zhouhaisheng")
    @ApiOperation(value = "手术申请安排", httpMethod = "POST")
    public ReturnEntity<String> add(SsSsapUpdateReq ssSsapUpdateReq) {
        ssSsapSer.add(ssSsapUpdateReq, getUser());
        return ReturnEntityUtil.success();
    }

    /**
     * 手术申请取消安排
     *
     * @param jlxh
     * @return
     */
    @RequestMapping("/edit")
    @ResponseBody
    @ApiOperationSupport(author = "zhouhaisheng")
    @ApiOperation(value = "手术申请取消安排", httpMethod = "POST")
    public ReturnEntity<String> cancel(Integer jlxh) {
        ssSsapSer.cancel(jlxh);
        return ReturnEntityUtil.success();
    }

    /**
     * 手术安排一览表分页查询
     *
     * @param ssapViewQueryPageReq
     * @return
     */
    @RequestMapping("/ssapViewQueryPage")
    @ResponseBody
    @ApiOperationSupport(author = "zhouhaisheng")
    @ApiOperation(value = "手术安排一览表分页查询", httpMethod = "POST")
    public ReturnEntity<PageInfo<SsSsapQueryPageResp>> ssapViewQueryPage(SsapViewQueryPageReq ssapViewQueryPageReq) {
        if (ssapViewQueryPageReq.getSsapsj() != null) {
            ssapViewQueryPageReq.setStartDate(DateUtils.getDailyStartTime(ssapViewQueryPageReq.getSsapsj()));
            ssapViewQueryPageReq.setEndDate(DateUtils.getDailyEndTime(ssapViewQueryPageReq.getSsapsj()));
        }
        PageInfo<SsSsapQueryPageResp> pageInfo = PageHelper.startPage(
                ssapViewQueryPageReq.getPageNum(), ssapViewQueryPageReq.getPageSize()).doSelectPageInfo(
                () -> ssSsapSer.ssapView(ssapViewQueryPageReq)
        );
        return ReturnEntityUtil.success(pageInfo);
    }


//    /** 删除 */
//    @RequestMapping("/delete")
//    @ResponseBody
//    @ApiOperationSupport(author = "zhouhaisheng")
//    @ApiOperation(value="按条件查询" ,httpMethod="POST")
//    public ReturnEntity<SsSsapResp> delete(SsSsapReq ssSsap) {
//        ssSsapSer.removeByEntity(ssSsap);        
//        return ReturnEntityUtil.success(ssSsap);            
//    }

}

