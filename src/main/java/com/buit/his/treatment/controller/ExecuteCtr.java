package com.buit.his.treatment.controller;

import cn.hutool.core.bean.BeanUtil;
import com.buit.cis.im.response.ImHzryResp;
import com.buit.cis.im.service.ImHzryService;
import com.buit.commons.BaseException;
import com.buit.commons.BaseSpringController;
import com.buit.commons.PageQuery;
import com.buit.commons.SysUser;
import com.buit.file.IReportExportFileSer;
import com.buit.his.treatment.preService.ExecutePreService;
import com.buit.his.treatment.request.ExecuteQueryReq;
import com.buit.his.treatment.request.ExecuteSaveReq;
import com.buit.his.treatment.request.ExecuteZlZrwQueryReq;
import com.buit.his.treatment.request.ZljlFormReq;
import com.buit.his.treatment.response.*;
import com.buit.his.treatment.service.ZlXmldsfxmSer;
import com.buit.his.treatment.service.ZlZljlSer;
import com.buit.his.treatment.service.ZlZlzrwSer;
import com.buit.utill.ReturnEntity;
import com.buit.utill.ReturnEntityUtil;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.apache.dubbo.config.annotation.DubboReference;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import java.net.URL;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author 蒋威
 * @Description 住院治疗执行
 * @Date 2021-03-26
 */
@Api(tags = "住院治疗执行")
@Controller
@RequestMapping("/zyzlzx")
public class ExecuteCtr extends BaseSpringController {
    @Autowired
    private ExecutePreService executePreService;
    @Autowired
    private ZlZlzrwSer zlZlzrwSer;
    @Autowired
    private ZlZljlSer zlZljlSer;
    @Autowired
    private IReportExportFileSer iReportExportFileSer;
    @DubboReference
    private ImHzryService imHzryService;
    @Autowired
    private ZlXmldsfxmSer zlXmldsfxmSer;


    @RequestMapping("/queryPatientPage")
    @ResponseBody
    @ApiOperation(value = "查询住院治疗执行患者列表", httpMethod = "POST")
    public ReturnEntity<PageInfo<ExecutePatientResp>> queryPatientPage(@Valid ExecuteQueryReq req) {
        SysUser user = getUser();
        req.setJgid(user.getHospitalId());
        if (req.getType() != null && req.getType() == 1) {
            req.setZlsdm(user.getPersonId());
        }
        PageInfo<ExecutePatientResp> pageInfo = PageHelper.startPage(
                req.getPageNum(), req.getPageSize()).doSelectPageInfo(
                () -> zlZlzrwSer.queryExecutePatientPage(req)
        );
        return ReturnEntityUtil.success(pageInfo);
    }

    @RequestMapping("/queryZlZlzRw")
    @ResponseBody
    @ApiOperation(value = "查询当天治疗子任务", httpMethod = "POST")
    public ReturnEntity<List<ZlZlzrwResp>> queryZlZlzRw(@Valid ExecuteZlZrwQueryReq req) {
        SysUser user = getUser();
        req.setJgid(user.getHospitalId());
        if (req.getType() != null && req.getType() == 1) {
            req.setZlsdm(user.getPersonId());
        }
        return ReturnEntityUtil.success(zlZlzrwSer.findList(req));
    }


    @RequestMapping("/save")
    @ResponseBody
    @ApiOperation(value = "执行", httpMethod = "POST")
    public ReturnEntity save(@Valid @RequestBody ExecuteSaveReq req) {
        SysUser user = getUser();
        req.setJgid(user.getHospitalId());
        req.setZlsdm(user.getPersonId());
        executePreService.save(req);
        return ReturnEntityUtil.success();
    }

    @RequestMapping("/cancel")
    @ResponseBody
    @ApiOperation(value = "取消执行", httpMethod = "POST")
    public ReturnEntity cancel(@Valid @RequestBody ExecuteSaveReq req) {
        SysUser user = getUser();
        req.setJgid(user.getHospitalId());
        req.setZlsdm(user.getPersonId());
        executePreService.cancel(req);
        return ReturnEntityUtil.success();
    }

    @RequestMapping("/absence")
    @ResponseBody
    @ApiOperation(value = "跳过此任务 | 任务当天可以不用执行，直接生成下一次的子任务", httpMethod = "POST")
    public ReturnEntity absence(@Valid @RequestBody ExecuteSaveReq req) {
        SysUser user = getUser();
        req.setJgid(user.getHospitalId());
        req.setZlsdm(user.getPersonId());
        executePreService.absence(req);
        return ReturnEntityUtil.success();
    }

    @RequestMapping("/split")
    @ResponseBody
    @ApiOperation(value = "拆分此任务 | 将补记账次数大于1的任务拆分为若干个子任务", httpMethod = "POST")
    public ReturnEntity split(@NotNull @ApiParam(name = "jlxh", value = "记录序号") @RequestParam Integer jlxh) {
        executePreService.split(jlxh);
        return ReturnEntityUtil.success();
    }

/*    @RequestMapping("/queryZljlList")
    @ResponseBody
    @ApiOperation(value = "查询治疗记录列表", httpMethod = "POST")
    public ReturnEntity<List<ZljlFormResp>> queryZljlList(@NotNull @ApiParam(name = "zyh", value = "住院号") @RequestParam Integer zyh,
                                                          @NotNull @ApiParam(name = "zllb", value = "诊疗类别") @RequestParam Integer zllb,
                                                          @NotNull @ApiParam(name = "type", value = "查询模式 | 0：全部    1：我的病人") @RequestParam Integer type) {
        ZlZljl query = new ZlZljl();
        query.setZyh(zyh);
        query.setZllb(zllb);
        if (type != null && type == 1) {
            query.setZxgh(getUser().getPersonId());
        }
        query.setZt(ZfpbEnum.ABLE.getValue());
        query.setSortColumns("zxrq desc");
        return ReturnEntityUtil.success(executePreService.findList(query));
    }*/

/*    @RequestMapping("/getZljl")
    @ResponseBody
    @ApiOperation(value = "查询当前治疗记录", httpMethod = "POST")
    public ReturnEntity<ZljlFormResp> getZljl(@NotNull @ApiParam(name = "zyh", value = "住院号") @RequestParam Integer zyh,
                                              @NotNull @ApiParam(name = "zllb", value = "诊疗类别") @RequestParam Integer zllb,
                                              @NotNull @ApiParam(name = "zxrq", value = "执行日期") @RequestParam String zxrq) {
        return ReturnEntityUtil.success(executePreService.getZljl(getUser().getPersonId(), zyh, zllb, zxrq));
    }*/

    @RequestMapping("/edit")
    @ResponseBody
    @ApiOperation(value = "修改执行记录", httpMethod = "POST")
    public ReturnEntity edit(@Valid @RequestBody ZljlFormReq req) {
        executePreService.edit(req);
        return ReturnEntityUtil.success();
    }


    @RequestMapping("/ExecuteLogPrint")
    @ResponseBody
    @ApiOperation(value = "治疗记录单打印", httpMethod = "POST")
    public void historyPrint(@ApiParam(name = "zyh", value = "住院号") @RequestParam Integer zyh, @NotNull @ApiParam(name = "zllb", value = "诊疗类别") @RequestParam Integer zllb, HttpServletResponse response) {
        Integer userId = getUser().getPersonId();

        //患者信息
        ImHzryResp hzryResp = imHzryService.getByZyh(zyh);
        ExecuteLogPatientResp hzry = executePreService.preHandler(hzryResp);

        //收费项目列表
        List<ExecuteLogItemResp> sfxmList = zlXmldsfxmSer.findListByZyhAndZlsdm(zyh, zllb, userId);
        Integer no = 1;
        Map<String, String> sfxmMap = new HashMap<>(sfxmList.size());
        //收费项目代码映射编号
        for (ExecuteLogItemResp resp : sfxmList) {
            resp.setRownum(String.valueOf(no));
            sfxmMap.put(resp.getSfxmdm(), resp.getRownum());
        }

        //治疗记录
        List<ExecuteLogResp> zljlList = zlZljlSer.findZljlReportDetailResp(zyh, zllb, null, sfxmMap);
        List<Map<String, Object>> list = new ArrayList<>();
        for (ExecuteLogResp resps : zljlList) {
            list.add(BeanUtil.beanToMap(resps));
        }

        Map<String, Object> map = new HashMap<>();

        map.put("title", "康复医学科康复治疗项目记录单");
        map.put("ryzd", hzry.getRyzd());
        map.put("hzry", hzry);
        map.put("sfxmList", sfxmList);

        String jasperName = "jrxml/ExecuteLog_Main.jasper";
        URL url = this.getClass().getClassLoader().getResource(jasperName);
        if (url != null) {
            String path = url.getPath();
            String dir = path.substring(0, path.lastIndexOf('/') + 1);
            map.put("SUBREPORT_DIR", dir);
            iReportExportFileSer.reportHtmlForStream(list, map, jasperName, response);
        } else {
            throw BaseException.create("ERROR_JASPER_0003");
        }

    }

    @RequestMapping("/delete")
    @ResponseBody
    @ApiOperation(value = "删除任务", httpMethod = "POST")
    public ReturnEntity delete(@NotNull @ApiParam(name = "jlxh", value = "记录序号") @RequestParam List<Integer> jlxhList) {
        executePreService.delete(jlxhList);
        return ReturnEntityUtil.success();
    }

    @RequestMapping("/dischargeCheckList")
    @ResponseBody
    @ApiOperation(value = "出院证检查 - 未确费列表", httpMethod = "POST")
    public ReturnEntity<PageInfo<ZlrwCheckFailedResp>> dischargeCheckList(@NotNull @ApiParam(name = "zyh", value = "住院号") @RequestParam Integer zyh, PageQuery pageQuery) {
        PageInfo<ZlrwCheckFailedResp> pageInfo = PageHelper.startPage(
                pageQuery.getPageNum(), pageQuery.getPageSize()).doSelectPageInfo(
                () -> executePreService.dischargeCheckList(zyh)
        );
        return ReturnEntityUtil.success(pageInfo);
    }
}
