
package com.buit.his.sams.controller;

import com.buit.his.sams.model.SsJzmbmx;
import com.buit.his.sams.request.SsJzmbmxQueryReq;
import com.buit.his.sams.request.SsJzmbmxReq;
import com.buit.his.sams.response.SsJzmbmxResp;
import com.buit.his.sams.service.SsJzmbmxSer;
import com.buit.commons.BaseSpringController;

import com.buit.utill.BeanUtil;
import com.buit.utill.ReturnEntity;
import com.buit.utill.ReturnEntityUtil;
import com.github.xiaoymin.knife4j.annotations.ApiOperationSupport;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/**
 * 手术/麻醉记账模板明细表<br>
 * @author zhouhaishenng
 */
@Api(tags="手术麻醉记账模板明细表")
@Controller
@RequestMapping("/ssjzmbmx")
public class SsJzmbmxCtr extends BaseSpringController{
    
    static final Logger logger = LoggerFactory.getLogger(SsJzmbmxCtr.class);
    
    @Autowired
    private SsJzmbmxSer ssJzmbmxSer;
    
//    @RequestMapping("/queryPage")
//    @ResponseBody
//    @ApiOperationSupport(author = "zhouhaisheng")
//    @ApiOperation(value="按条件分页查询" ,httpMethod="POST")
//    public ReturnEntity<PageInfo<SsJzmbmxResp>> queryPage(SsJzmbmxReq ssjzmbmx,PageQuery page){
//        PageInfo<SsJzmbmx> pageInfo = PageHelper.startPage(
//            page.getPageNum(), page.getPageSize()).doSelectPageInfo(
//                    () -> ssJzmbmxSer.findByEntity(ssjzmbmx)
//            );
//        return ReturnEntityUtil.success(pageInfo);
//    }
//

    /**
     * 查询手术麻醉记账模板明细表列表
     * @param ssJzmbmxQueryReq
     * @return
     */
    @RequestMapping("/findList")
    @ResponseBody
    @ApiOperationSupport(author = "zhouhaisheng")
    @ApiOperation(value="按条件查询-返回列表" ,httpMethod="POST")
    public ReturnEntity<List<SsJzmbmxResp>> findList(SsJzmbmxQueryReq ssJzmbmxQueryReq){
        ssJzmbmxQueryReq.setJgid(getUser().getHospitalId());
        SsJzmbmx ssJzmbmx=new SsJzmbmx();
        BeanUtils.copyProperties(ssJzmbmxQueryReq,ssJzmbmx);
        ssJzmbmx.setSortColumns("xh asc");
        List<SsJzmbmxResp> list=ssJzmbmxSer.findList(ssJzmbmx);

        return ReturnEntityUtil.success(list);
    }

//    @RequestMapping("/getDetail")
//    @ResponseBody
//    @ApiOperationSupport(author = "zhouhaisheng")
//    @ApiOperation(value="按条件查询-返回唯一值" ,httpMethod="POST")
//    public ReturnEntity<SsJzmbmxResp> getDetail(SsJzmbmxReq ssjzmbmx){
//        List<SsJzmbmx> list=ssJzmbmxSer.findByEntity(ssjzmbmx);
//        if(list.size()>0){
//           return ReturnEntityUtil.success(list.get(0));
//        }
//        return ReturnEntityUtil.success();
//    }

    /**
     * 手术、麻醉记账模板-新增、修改、删除收费项目详情
     * @param ssJzmbmxReqList
     * @return
     */
    @RequestMapping("/saveOrUpdate")
    @ResponseBody
    @ApiOperationSupport(author = "zhouhaisheng")
    @ApiOperation(value="手术麻醉记账模板-新增修改删除收费项目详情" ,httpMethod="POST")
    public ReturnEntity<String> saveOrUpdate(@RequestBody List<SsJzmbmxReq> ssJzmbmxReqList) {
        ssJzmbmxSer.saveOrUpdate(ssJzmbmxReqList,getUser());
        return ReturnEntityUtil.success();
    }
    /** 编辑 */
    @RequestMapping("/edit")
    @ResponseBody
    @ApiOperationSupport(author = "zhouhaisheng")
    @ApiOperation(value="编辑" ,httpMethod="POST")
    public ReturnEntity<String> edit(SsJzmbmxReq ssJzmbmx)  {
        ssJzmbmxSer.update(ssJzmbmx);
        return ReturnEntityUtil.success();
    }

    /**
     * 删除手术/麻醉记账模板明细
     * @param jlxh
     * @return
     */
    @RequestMapping("/delete")
    @ResponseBody
    @ApiOperationSupport(author = "zhouhaisheng")
    @ApiOperation(value="删除手术麻醉记账模板明细" ,httpMethod="POST")
    public ReturnEntity<SsJzmbmxResp> delete(Integer jlxh) {
        ssJzmbmxSer.removeById(jlxh);
        return ReturnEntityUtil.success();
    }
    
}

