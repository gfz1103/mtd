
package com.buit.his.treatment.controller;

import com.buit.commons.BaseSpringController;
import com.buit.his.treatment.request.ZlZlzcybReq;
import com.buit.his.treatment.response.ZlZlzcybResp;
import com.buit.his.treatment.response.ZlsMsgResp;
import com.buit.his.treatment.service.ZlZlzcybSer;
import com.buit.utill.ReturnEntity;
import com.buit.utill.ReturnEntityUtil;
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
 * 治疗小组成员表<br>
 *
 * @author 韦靖
 */
@Api(tags = "治疗小组成员表")
@Controller
@RequestMapping("/zlzlzcyb")
public class ZlZlzcybCtr extends BaseSpringController {

    static final Logger logger = LoggerFactory.getLogger(ZlZlzcybCtr.class);

    @Autowired
    private ZlZlzcybSer zlZlzcybSer;

    /**
     * 通过诊疗小组ID查询小组成员
     */
    @RequestMapping("/queryByZlzId")
    @ResponseBody
    @ApiOperation(value = "通过诊疗小组ID查询小组成员", httpMethod = "POST")
    public ReturnEntity<List<ZlZlzcybResp>> queryByZlzID(@ApiParam(name = "zlzid", value = "诊疗小组ID", required = true) @RequestParam(value = "zlzid") Integer zlzid) {
        return ReturnEntityUtil.success(zlZlzcybSer.queryByZlzID(zlzid));
    }

    /**
     * 保存小组成员
     */
    @RequestMapping("/save")
    @ResponseBody
    @ApiOperation(value = "保存", httpMethod = "POST")
    public ReturnEntity save(@Valid @RequestBody ZlZlzcybReq zlZlzcybReq) {
        zlZlzcybReq.setJgid(getUser().getHospitalId());
        zlZlzcybSer.save(zlZlzcybReq);
        return ReturnEntityUtil.success();
    }

    /**
     * 查询某个类别下的治疗师列表
     */
    @RequestMapping("/queryZlsList")
    @ResponseBody
    @ApiOperation(value = "查询某个类别下的治疗师列表", httpMethod = "POST")
    public ReturnEntity<List<ZlsMsgResp>> queryZlsList(@ApiParam(name = "zllb", value = "诊疗类别", required = true) @RequestParam(value = "zllb") Integer zllb) {
        return ReturnEntityUtil.success(zlZlzcybSer.queryZlsList(zllb, getUser().getHospitalId()));
    }
}

