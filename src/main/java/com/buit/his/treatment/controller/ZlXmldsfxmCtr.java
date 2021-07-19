
package com.buit.his.treatment.controller;

import com.buit.commons.BaseSpringController;
import com.buit.his.treatment.model.ZlXmldsfxm;
import com.buit.his.treatment.request.ZlXmldsfxmAddReq;
import com.buit.his.treatment.request.ZlXmldsfxmUpdateReq;
import com.buit.his.treatment.response.ZlXmldsfxmQueryListResp;
import com.buit.his.treatment.service.ZlXmldsfxmSer;
import com.buit.utill.ReturnEntity;
import com.buit.utill.ReturnEntityUtil;
import com.github.xiaoymin.knife4j.annotations.ApiOperationSupport;
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
import javax.validation.constraints.NotNull;
import java.util.List;

/**
 * 治疗项目联动收费项目表<br>
 *
 * @author ZHOUHAISHENG
 */
@Api(tags = "治疗项目联动收费项目表")
@Controller
@RequestMapping("/zlxmldsfxm")
public class ZlXmldsfxmCtr extends BaseSpringController {

    static final Logger logger = LoggerFactory.getLogger(ZlXmldsfxmCtr.class);

    @Autowired
    private ZlXmldsfxmSer zlXmldsfxmSer;

    /**
     * 治疗项目联动收费项目列表查询
     *
     * @param zlxmJlxh 治疗项目id
     */
    @RequestMapping("/findList")
    @ResponseBody
    @ApiOperationSupport(author = "zhouhaisheng")
    @ApiOperation(value = "治疗项目联动收费项目列表查询", httpMethod = "POST")
    public ReturnEntity<List<ZlXmldsfxmQueryListResp>> findList(Integer zlxmJlxh) {
        return ReturnEntityUtil.success(zlXmldsfxmSer.findList(getUser().getHospitalId(), zlxmJlxh));
    }

    /**
     * 查询详情
     *
     * @param jlxh
     * @return
     */
    @RequestMapping("/getDetail")
    @ResponseBody
    @ApiOperationSupport(author = "zhouhaisheng")
    @ApiOperation(value = "查询详情", httpMethod = "POST")
    public ReturnEntity<ZlXmldsfxmQueryListResp> getDetail(Integer jlxh) {
        return ReturnEntityUtil.success(zlXmldsfxmSer.getDetail(jlxh));
    }

    /**
     * 新增治疗项目联动收费项目表
     *
     * @param zlXmldsfxmAddReq
     * @return
     */
    @RequestMapping("/add")
    @ResponseBody
    @ApiOperationSupport(author = "zhouhaisheng")
    @ApiOperation(value = "新增治疗项目联动收费项目表", httpMethod = "POST")
    public ReturnEntity<ZlXmldsfxmQueryListResp> add(@Valid ZlXmldsfxmAddReq zlXmldsfxmAddReq) {

        return zlXmldsfxmSer.add(zlXmldsfxmAddReq, getUser());
    }

    /**
     * 编辑治疗项目联动收费项目表
     *
     * @param zlXmldsfxmUpdateReq
     * @return
     */
    @RequestMapping("/edit")
    @ResponseBody
    @ApiOperationSupport(author = "zhouhaisheng")
    @ApiOperation(value = "编辑治疗项目联动收费项目表", httpMethod = "POST")
    public ReturnEntity<String> edit(@Valid ZlXmldsfxmUpdateReq zlXmldsfxmUpdateReq) {
        zlXmldsfxmSer.update(zlXmldsfxmUpdateReq, getUser());
        return ReturnEntityUtil.success();
    }

    /**
     * 删除治疗项目联动收费项目表
     *
     * @param jlxh
     * @return
     */
    @RequestMapping("/delete")
    @ResponseBody
    @ApiOperationSupport(author = "zhouhaisheng")
    @ApiOperation(value = "删除治疗项目联动收费项目表", httpMethod = "POST")
    public ReturnEntity<String> delete(Integer jlxh) {
        zlXmldsfxmSer.removeById(jlxh);
        return ReturnEntityUtil.success();
    }

    @RequestMapping("/findListByZllb")
    @ResponseBody
    @ApiOperationSupport(author = "jiangwei")
    @ApiOperation(value = "治疗项目联动收费项目列表查询", httpMethod = "POST")
    public ReturnEntity<List<ZlXmldsfxm>> findListByZllb(@NotNull @ApiParam(name = "zlksdm", value = "治疗科室代码") @RequestParam Integer zlksdm,
                                                         @ApiParam(name = "zllb", value = "诊疗类别") @RequestParam(required = false) Integer zllb) {
        return ReturnEntityUtil.success(zlXmldsfxmSer.findListByZllb(getUser().getHospitalId(), zllb, zlksdm));
    }

}

