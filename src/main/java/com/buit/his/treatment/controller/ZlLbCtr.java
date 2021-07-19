
package com.buit.his.treatment.controller;

import com.buit.commons.BaseSpringController;
import com.buit.his.treatment.model.ZlLb;
import com.buit.his.treatment.request.ZlLbQueryReq;
import com.buit.his.treatment.service.ZlLbSer;
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
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/**
 * 治疗类别设置<br>
 *
 * @author ZHOUHAISHENG
 */
@Api(tags = "治疗类别设置")
@Controller
@RequestMapping("/zllb")
public class ZlLbCtr extends BaseSpringController {

    static final Logger logger = LoggerFactory.getLogger(ZlLbCtr.class);

    @Autowired
    private ZlLbSer zlLbSer;

    @RequestMapping("/queryPage")
    @ResponseBody
    @ApiOperationSupport(author = "zhouhaisheng")
    @ApiOperation(value = "治疗类别分页查询", httpMethod = "POST")
    public ReturnEntity<PageInfo<ZlLb>> queryPage(ZlLbQueryReq req) {
        ZlLb query = new ZlLb();
        BeanUtils.copyProperties(req, query);
        query.setJgid(getUser().getHospitalId());
        query.setSortColumns("pxh asc");
        PageInfo<ZlLb> pageInfo = PageHelper.startPage(
                req.getPageNum(), req.getPageSize()).doSelectPageInfo(
                () -> zlLbSer.findByEntity(query)
        );
        return ReturnEntityUtil.success(pageInfo);
    }

    @RequestMapping("/findList")
    @ResponseBody
    @ApiOperation(value = "按条件查询-返回列表", httpMethod = "POST")
    public ReturnEntity<List<ZlLb>> findList(@ApiParam(name = "zlksdm", value = "治疗科室代码") @RequestParam Integer zlksdm) {
        ZlLb query = new ZlLb();
        query.setJgid(getUser().getHospitalId());
        query.setZlksdm(zlksdm);
        return ReturnEntityUtil.success(zlLbSer.findByEntity(query));
    }


    /**
     * 治疗类别新增
     *
     * @param zlLb
     * @return
     */
    @RequestMapping("/add")
    @ResponseBody
    @ApiOperationSupport(author = "zhouhaisheng")
    @ApiOperation(value = "治疗类别新增", httpMethod = "POST")
    public ReturnEntity add(ZlLb zlLb) {
        zlLb.setJgid(getUser().getHospitalId());
        return zlLbSer.add(zlLb);
    }

    /**
     * 治疗类别编辑
     *
     * @param zlLb
     * @return
     */
    @RequestMapping("/edit")
    @ResponseBody
    @ApiOperationSupport(author = "zhouhaisheng")
    @ApiOperation(value = "治疗类别编辑", httpMethod = "POST")
    public ReturnEntity edit(ZlLb zlLb) {

        return zlLbSer.updateZllb(zlLb);
    }

    /**
     * 治疗类别删除
     *
     * @param zlLb
     * @return
     */
    @RequestMapping("/delete")
    @ResponseBody
    @ApiOperationSupport(author = "zhouhaisheng")
    @ApiOperation(value = "治疗类别删除", httpMethod = "POST")
    public ReturnEntity delete(ZlLb zlLb) {
        zlLb.setJgid(getUser().getHospitalId());
        return zlLbSer.delete(zlLb);
    }

}

