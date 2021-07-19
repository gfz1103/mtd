
package com.buit.his.treatment.controller;

import com.buit.commons.BaseSpringController;
import com.buit.commons.PageQuery;
import com.buit.his.treatment.model.ZlXm;
import com.buit.his.treatment.request.QueryZlxmSrfReq;
import com.buit.his.treatment.request.ZlXmPageReq;
import com.buit.his.treatment.request.ZlXmReq;
import com.buit.his.treatment.response.ZlXmResp;
import com.buit.his.treatment.service.ZlXmSer;
import com.buit.system.request.GyYlxmDicReq;
import com.buit.system.response.GyYlxmDicResp;
import com.buit.system.service.FeeYlsfxmOutSer;
import com.buit.utill.ReturnEntity;
import com.buit.utill.ReturnEntityUtil;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.github.xiaoymin.knife4j.annotations.ApiOperationSupport;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.apache.dubbo.config.annotation.DubboReference;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.validation.Valid;

/**
 * 治疗项目表<br>
 *
 * @author ZHOUHAISHENG
 */
@Api(tags = "治疗项目设置")
@Controller
@RequestMapping("/zlxm")
public class ZlXmCtr extends BaseSpringController {

    static final Logger logger = LoggerFactory.getLogger(ZlXmCtr.class);

    @Autowired
    private ZlXmSer zlXmSer;
    @DubboReference
    private FeeYlsfxmOutSer feeYlsfxmSer;

    /**
     * 治疗项目分页查询
     *
     * @param zlXmPageReq
     * @return
     */
    @RequestMapping("/queryPage")
    @ResponseBody
    @ApiOperationSupport(author = "zhouhaisheng")
    @ApiOperation(value = "治疗项目分页查询", httpMethod = "POST")
    public ReturnEntity<PageInfo<ZlXmResp>> queryPage(ZlXmPageReq zlXmPageReq) {
        zlXmPageReq.setJgid(getUser().getHospitalId());
        ZlXm zlxm = new ZlXm();
        BeanUtils.copyProperties(zlXmPageReq, zlxm);
        PageInfo<ZlXmResp> pageInfo = PageHelper.startPage(
                zlxm.getPageNum(), zlxm.getPageSize()).doSelectPageInfo(
                () -> zlXmSer.findByEntity(zlxm)
        );
        return ReturnEntityUtil.success(pageInfo);
    }

    /**
     * 查询治疗项目详情
     *
     * @param jlxh
     * @return
     */
    @RequestMapping("/getDetail")
    @ResponseBody
    @ApiOperationSupport(author = "zhouhaisheng")
    @ApiOperation(value = "查询治疗项目详情", httpMethod = "POST")
    public ReturnEntity<ZlXm> getDetail(Integer jlxh) {

        return ReturnEntityUtil.success(zlXmSer.getById(jlxh));
    }

    /**
     * 治疗项目新增
     *
     * @param zlXm
     * @return
     */
    @RequestMapping("/add")
    @ResponseBody
    @ApiOperationSupport(author = "zhouhaisheng")
    @ApiOperation(value = "治疗项目新增", httpMethod = "POST")
    public ReturnEntity<ZlXmResp> add(@Valid ZlXmReq zlXm) {
        zlXm.setJgid(getUser().getHospitalId());
        return zlXmSer.add(zlXm);
    }

    /**
     * 治疗项目修改
     *
     * @param zlXm
     * @return
     */
    @RequestMapping("/edit")
    @ResponseBody
    @ApiOperationSupport(author = "zhouhaisheng")
    @ApiOperation(value = "治疗项目修改", httpMethod = "POST")
    public ReturnEntity<ZlXmResp> edit(@Valid ZlXmReq zlXm) {
        zlXm.setJgid(getUser().getHospitalId());
        return zlXmSer.edit(zlXm);
    }

    /**
     * 治疗项目删除
     *
     * @param jlxh
     * @return
     */
    @RequestMapping("/delete")
    @ResponseBody
    @ApiOperationSupport(author = "zhouhaisheng")
    @ApiOperation(value = "治疗项目删除", httpMethod = "POST")
    public ReturnEntity delete(Integer jlxh) {

        return zlXmSer.delete(jlxh);
    }

    /**
     * 修改治疗项目状态
     *
     * @param jlxh
     * @return
     */
    @RequestMapping("/updateZt")
    @ResponseBody
    @ApiOperationSupport(author = "zhouhaisheng")
    @ApiOperation(value = "修改治疗项目状态", httpMethod = "POST")
    public ReturnEntity updateZt(@ApiParam(name = "jlxh", value = "id", required = true) @RequestParam Integer jlxh,
                                 @ApiParam(name = "zt", value = "0:停用 1:启用", required = true) @RequestParam String zt) {

        return zlXmSer.updateZt(jlxh, zt);
    }

    /**
     * 治疗项目字典输入法
     *
     * @param queryZlxmSrfReq
     * @return
     */
    @RequestMapping("/queryZlxmSrf")
    @ResponseBody
    @ApiOperation(value = "治疗项目字典输入法", httpMethod = "POST")
    public ReturnEntity<PageInfo<ZlXmResp>> queryZlxmSrf(QueryZlxmSrfReq queryZlxmSrfReq) {
        queryZlxmSrfReq.setJgid(getUser().getHospitalId());
        PageInfo<ZlXmResp> pageInfo = PageHelper.startPage(queryZlxmSrfReq.getPageNum(), queryZlxmSrfReq.getPageSize())
                .doSelectPageInfo(() -> zlXmSer.getEntityMapper().queryZlxmSrf(queryZlxmSrfReq));
        return ReturnEntityUtil.success(pageInfo);
    }

    /**
     * 治疗管理-治疗收费项目输入法字典
     *
     * @param
     * @return
     */
    @RequestMapping("/queryZlXmDic")
    @ResponseBody
    @ApiOperation(value = "治疗管理-治疗收费项目输入法字典", httpMethod = "POST")
    public ReturnEntity<PageInfo<GyYlxmDicResp>> queryZlXmDic(@ApiParam(name = "pydm", value = "拼音代码") @RequestParam(required = false) String pydm, PageQuery page) {
        GyYlxmDicReq gyYlxmDicReq = new GyYlxmDicReq();
        gyYlxmDicReq.setJgid(getUser().getHospitalId());
        gyYlxmDicReq.setPydm(pydm);
        gyYlxmDicReq.setPageNum(page.getPageNum());
        gyYlxmDicReq.setPageSize(page.getPageSize());
        gyYlxmDicReq.setSortType(page.getSortType());
        gyYlxmDicReq.setSortColumns(page.getSortColumns());
        PageInfo<GyYlxmDicResp> pageInfo = feeYlsfxmSer.queryZlxmDicList(gyYlxmDicReq);
        return ReturnEntityUtil.success(pageInfo);
    }
}

