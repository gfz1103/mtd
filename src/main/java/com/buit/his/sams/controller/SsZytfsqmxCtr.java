
package com.buit.his.sams.controller;

import com.buit.commons.BaseSpringController;
import com.buit.his.sams.response.SsZytfsqmxResp;
import com.buit.his.sams.service.SsZytfsqmxSer;
import com.buit.utill.ReturnEntity;
import com.buit.utill.ReturnEntityUtil;
import com.github.xiaoymin.knife4j.annotations.ApiOperationSupport;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/**
 * 住院退费申请明细表<br>
 *
 * @author zhouhaishenng
 */
@Api(tags = "住院退费申请明细表")
@Controller
@RequestMapping("/sszytfsqmx")
public class SsZytfsqmxCtr extends BaseSpringController {

    static final Logger logger = LoggerFactory.getLogger(SsZytfsqmxCtr.class);

    @Autowired
    private SsZytfsqmxSer ssZytfsqmxSer;


    @RequestMapping("/findList")
    @ResponseBody
    @ApiOperationSupport(author = "zhouhaisheng")
    @ApiOperation(value = "查询退费项目列表", httpMethod = "POST")
    public ReturnEntity<List<SsZytfsqmxResp>> findList(@RequestParam("jlxh") Integer jlxh) {
        return ReturnEntityUtil.success(ssZytfsqmxSer.findList(jlxh));
    }

    @RequestMapping("/delete")
    @ResponseBody
    @ApiOperation(value = "删除退费明细", httpMethod = "POST")
    public ReturnEntity delete(@RequestParam("jlxh") Integer jlxh) {
        ssZytfsqmxSer.delete(jlxh);
        return ReturnEntityUtil.success();
    }


}

