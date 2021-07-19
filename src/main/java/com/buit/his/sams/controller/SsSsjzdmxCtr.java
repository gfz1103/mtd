
package com.buit.his.sams.controller;

import com.buit.commons.BaseSpringController;
import com.buit.his.sams.response.SsSsjzdmxResp;
import com.buit.his.sams.service.SsSsjzdmxSer;
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
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/**
 * 手术记账单明细表<br>
 * @author zhouhaishenng
 */
@Api(tags="手术记账单明细表")
@Controller
@RequestMapping("/ssssjzdmx")
public class SsSsjzdmxCtr extends BaseSpringController{
    
    static final Logger logger = LoggerFactory.getLogger(SsSsjzdmxCtr.class);
    
    @Autowired
    private SsSsjzdmxSer ssSsjzdmxSer;

    @RequestMapping("/query/list")
    @ResponseBody
    @ApiOperationSupport(author = "zhouhaisheng")
    @ApiOperation(value = "按条件查询-返回列表", httpMethod = "POST")
    public ReturnEntity<List<SsSsjzdmxResp>> queryList(Integer jzdh) {
        return ReturnEntityUtil.success(ssSsjzdmxSer.queryList(jzdh));
    }

    
}

