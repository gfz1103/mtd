
package com.buit.his.treatment.controller;

import cn.hutool.core.collection.CollectionUtil;
import com.buit.commons.BaseSpringController;
import com.buit.commons.SysUser;
import com.buit.his.treatment.preService.AppointmentPreService;
import com.buit.his.treatment.request.AppointmentQueryReq;
import com.buit.his.treatment.request.AppointmentSaveReq;
import com.buit.his.treatment.response.AppointmentPatientResp;
import com.buit.his.treatment.response.ZlRwmbResp;
import com.buit.his.treatment.service.ZlRwmbSer;
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
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.validation.Valid;
import java.util.List;
import java.util.stream.Collectors;

/**
 * 住院治疗预约
 *
 * @author 蒋威
 */
@Api(tags = "住院治疗预约")
@Controller
@RequestMapping("/zyzlyy")
public class AppointmentCtr extends BaseSpringController {

    static final Logger logger = LoggerFactory.getLogger(AppointmentCtr.class);

    @Autowired
    private ZlRwmbSer zlRwmbSer;

    @Autowired
    private AppointmentPreService appointmentPreService;

    @RequestMapping("/queryPatientPage")
    @ResponseBody
    @ApiOperation(value = "查询住院治疗预约患者列表", httpMethod = "POST")
    public ReturnEntity<PageInfo<AppointmentPatientResp>> queryPatientPage(@Valid AppointmentQueryReq req) {
        SysUser user = getUser();
        req.setJgid(user.getHospitalId());
        if (req.getType() != null && req.getType() == 1) {
            req.setZlsdm(user.getPersonId());
        }
        PageInfo<AppointmentPatientResp> pageInfo = PageHelper.startPage(
                req.getPageNum(), req.getPageSize()).doSelectPageInfo(
                () -> zlRwmbSer.queryAppointmentPatientPage(req)
        );
        return ReturnEntityUtil.success(pageInfo);
    }

    @RequestMapping("/queryZlRwmb")
    @ResponseBody
    @ApiOperation(value = "查询治疗任务模板", httpMethod = "POST")
    public ReturnEntity<List<ZlRwmbResp>> queryZlRwmb(@ApiParam(name = "zyh", value = "住院号") @RequestParam Integer zyh,
                                                      @ApiParam(name = "zlksdm", value = "治疗科室代码") @RequestParam Integer zlksdm,
                                                      @ApiParam(name = "zllb", value = "诊疗类别") @RequestParam Integer zllb,
                                                      @ApiParam(name = "type", value = "查询模式 | 0：全部    1：我的病人") @RequestParam Integer type,
                                                      @ApiParam(name = "yyzt", value = "预约状态 | 0：未预约    2：已预约") @RequestParam Integer yyzt) {
        Integer zxgh = null;
        if (type != null && type == 1) {
            zxgh = getUser().getPersonId();
        }
        return ReturnEntityUtil.success(zlRwmbSer.findList(zyh, zlksdm, zllb, zxgh, yyzt));
    }

    @RequestMapping("/save")
    @ResponseBody
    @ApiOperation(value = "预约保存", httpMethod = "POST")
    public ReturnEntity<List<ZlRwmbResp>> save(@Valid @RequestBody AppointmentSaveReq req) {
        List<ZlRwmbResp> rwmbList = zlRwmbSer.findListByIds(req.getJlxhList());
        if (CollectionUtil.isNotEmpty(rwmbList)) {
            List<Integer> rwfpIds = rwmbList.stream().map(ZlRwmbResp::getZlrwfpid).distinct().collect(Collectors.toList());
            appointmentPreService.save(req, getUser().getHospitalId(), rwfpIds);
        }
        return ReturnEntityUtil.success();
    }

}

