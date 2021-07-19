
package com.buit.his.treatment.controller;

import com.buit.commons.BaseSpringController;
import com.buit.commons.PageQuery;
import com.buit.his.treatment.model.ZlZlz;
import com.buit.his.treatment.request.ZlZlzAddReq;
import com.buit.his.treatment.request.ZlZlzEditReq;
import com.buit.his.treatment.request.ZlZlzQueryReq;
import com.buit.his.treatment.response.ZlZlzResp;
import com.buit.his.treatment.service.ZlZlzSer;
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
 * 治疗小组表<br>
 *
 * @author 韦靖
 */
@Api(tags = "治疗小组表")
@Controller
@RequestMapping("/zlzlz")
public class ZlZlzCtr extends BaseSpringController {

    static final Logger logger = LoggerFactory.getLogger(ZlZlzCtr.class);

    @Autowired
    private ZlZlzSer zlZlzSer;

    @RequestMapping("/queryPage")
    @ResponseBody
    @ApiOperation(value = "按条件分页查询", httpMethod = "POST")
    public ReturnEntity<PageInfo<ZlZlzResp>> queryPage(ZlZlzQueryReq zlzlz, PageQuery page) {
        zlzlz.setJgid(getUser().getHospitalId());
        PageInfo<ZlZlzResp> pageInfo = PageHelper.startPage(
                page.getPageNum(), page.getPageSize()).doSelectPageInfo(
                () -> zlZlzSer.getEntityMapper().getByKsdm(zlzlz)
        );
        return ReturnEntityUtil.success(pageInfo);
    }

    @RequestMapping("/findAll")
    @ResponseBody
    @ApiOperation(value = "查询所有治疗组", httpMethod = "POST")
    public ReturnEntity<List<ZlZlz>> findAll() {
        ZlZlz query = new ZlZlz();
        query.setZt("1");
        query.setJgid(getUser().getHospitalId());
        return ReturnEntityUtil.success(zlZlzSer.findByEntity(query));
    }

    /**
     * 新增
     */
    @RequestMapping("/add")
    @ResponseBody
    @ApiOperation(value = "新增", httpMethod = "POST")
    public ReturnEntity<Integer> add(@Valid ZlZlzAddReq ZlZlzAddReq) {
        ZlZlzAddReq.setJgid(getUser().getHospitalId());
        Integer zlzid = zlZlzSer.add(ZlZlzAddReq);
        return ReturnEntityUtil.success(zlzid);
    }

    /**
     * 编辑
     */
    @RequestMapping("/edit")
    @ResponseBody
    @ApiOperation(value = "编辑", httpMethod = "POST")
    public ReturnEntity edit(@Valid ZlZlzEditReq zlZlz) {
        zlZlz.setJgid(getUser().getHospitalId());
        zlZlzSer.edit(zlZlz);
        return ReturnEntityUtil.success();
    }

    /**
     * 删除
     */
    @RequestMapping("/delete")
    @ResponseBody
    @ApiOperation(value = "通过主键删除", httpMethod = "POST")
    public ReturnEntity<ZlZlzResp> delete(@ApiParam(name = "zlzid", value = "诊疗小组ID", required = true) @RequestParam(value = "zlzid") Integer zlzid) {
        zlZlzSer.deleteZLZ(zlzid);
        return ReturnEntityUtil.success();
    }

    /**
     * 通过主键更改状态（停用,启用）
     */
    @RequestMapping("/updateZt")
    @ResponseBody
    @ApiOperation(value = "通过主键更改状态（停用,启用）", httpMethod = "POST")
    public ReturnEntity<ZlZlzResp> updateZt(@ApiParam(name = "zlzid", value = "诊疗小组ID", required = true) @RequestParam(value = "zlzid") Integer zlzid,
                                            @ApiParam(name = "zt", value = "状态（1启用0停用）", required = true) @RequestParam(value = "zt") String zt) {
        zlZlzSer.updateZt(zlzid, zt);
        return ReturnEntityUtil.success();
    }
}

