
package com.buit.his.treatment.controller;

import com.buit.his.treatment.model.ZlSqdyyzx;
import com.buit.his.treatment.request.PatientZlyyQueryRep;
import com.buit.his.treatment.request.ZlsqdyySaveOrUpdateAllReq;
import com.buit.his.treatment.response.PatientZlyyQueryResp;
import com.buit.his.treatment.response.QueryZlyyzxXmxqResp;
import com.buit.his.treatment.response.ZlSqdyyzxResp;
import com.buit.his.treatment.service.ZlSqdyyzxSer;
import com.buit.commons.BaseSpringController;

import com.buit.utill.ReturnEntity;
import com.buit.utill.ReturnEntityUtil;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
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
 * 治疗申请单预约执行表<br>
 * @author ZHOUHAISHENG
 */
@Api(tags="治疗申请单预约执行表")
@Controller
@RequestMapping("/zlsqdyyzx")
public class ZlSqdyyzxCtr extends BaseSpringController{
    
    static final Logger logger = LoggerFactory.getLogger(ZlSqdyyzxCtr.class);
    
    @Autowired
    private ZlSqdyyzxSer zlSqdyyzxSer;
    
//    @RequestMapping("/queryPage")
//    @ResponseBody
//    @ApiOperation(value="按条件分页查询" ,httpMethod="POST")
//    public ReturnEntity<PageInfo<ZlSqdyyzxResp>> queryPage(ZlSqdyyzxReq zlsqdyyzx,PageQuery page){
//        PageInfo<ZlSqdyyzx> pageInfo = PageHelper.startPage(
//            page.getPageNum(), page.getPageSize()).doSelectPageInfo(
//                    () -> zlSqdyyzxSer.findByEntity(zlsqdyyzx)
//            );
//        return ReturnEntityUtil.success(pageInfo);
//    }
//

    /**
     * 查询治疗申请单执行列表
     * @param zlSqdmxJlxh
     * @return
     */
    @RequestMapping("/findList")
    @ResponseBody
    @ApiOperation(value="查询治疗申请单执行列表" ,httpMethod="POST")
    public ReturnEntity<List<ZlSqdyyzxResp>> findList(Integer zlSqdmxJlxh){
        return ReturnEntityUtil.success(zlSqdyyzxSer.findList(zlSqdmxJlxh));
    }

    /**
     *查询治疗申请单预约执行详情
     * @param jlxh
     * @return
     */
    @RequestMapping("/queryDetail")
    @ResponseBody
    @ApiOperation(value="查询治疗申请单预约执行详情" ,httpMethod="POST")
    public ReturnEntity<ZlSqdyyzxResp> queryDetail(Integer jlxh){
        ZlSqdyyzx zlSqdyyzx=zlSqdyyzxSer.getById(jlxh);
        ZlSqdyyzxResp zlSqdyyzxResp= new ZlSqdyyzxResp();
        BeanUtils.copyProperties(zlSqdyyzx,zlSqdyyzxResp);
        return ReturnEntityUtil.success(zlSqdyyzxResp);
    }

//    /** 新增 */
//    @RequestMapping("/add")
//    @ResponseBody
//    @ApiOperation(value="新增" ,httpMethod="POST")
//    public ReturnEntity<ZlSqdyyzxResp> add(ZlSqdyyzxReq zlSqdyyzx) {
//        zlSqdyyzxSer.insert(zlSqdyyzx);        
//        return ReturnEntityUtil.success(zlSqdyyzx);            
//    }
//    /** 编辑 */
//    @RequestMapping("/edit")
//    @ResponseBody
//    @ApiOperation(value="编辑" ,httpMethod="POST")
//    public ReturnEntity<ZlSqdyyzxResp> edit(ZlSqdyyzxReq zlSqdyyzx)  {
//        zlSqdyyzxSer.update(zlSqdyyzx);        
//        return ReturnEntityUtil.success(zlSqdyyzx);            
//    }
//    
//    /** 删除 */
//    @RequestMapping("/delete")
//    @ResponseBody
//    @ApiOperation(value="按条件查询" ,httpMethod="POST")
//    public ReturnEntity<ZlSqdyyzxResp> delete(ZlSqdyyzxReq zlSqdyyzx) {
//        zlSqdyyzxSer.removeByEntity(zlSqdyyzx);        
//        return ReturnEntityUtil.success(zlSqdyyzx);            
//    }

    /**
     * 保存或修改治疗预约信息
     * @return
     */
    @RequestMapping("/saveOrUpdateZlyy")
    @ResponseBody
    @ApiOperationSupport(author = "zhouhaisheng")
    @ApiOperation(value="保存或修改治疗预约信息" ,httpMethod="POST")
    public  ReturnEntity<String> saveOrUpdateZlyy(@RequestBody ZlsqdyySaveOrUpdateAllReq zlsqdyySaveOrUpdateAllReq){
        zlSqdyyzxSer.saveOrUpdateZlyy(zlsqdyySaveOrUpdateAllReq,getUser());
        return ReturnEntityUtil.success();
    }
    /**
     * 取消执行
     * @return
     */
    @RequestMapping("/cancelZx")
    @ResponseBody
    @ApiOperationSupport(author = "zhouhaisheng")
    @ApiOperation(value="取消执行" ,httpMethod="POST")
    public  ReturnEntity<String> cancelZx(Integer jlxh){
        zlSqdyyzxSer.cancelZx(jlxh,getUser());
        return ReturnEntityUtil.success();
    }



    /**
     * 病人治疗执行分页查询
     * @return
     */
    @RequestMapping("/queryZlyyzxPage")
    @ResponseBody
    @ApiOperationSupport(author = "zhouhaisheng")
    @ApiOperation(value="病人治疗执行分页查询" ,httpMethod="POST")
    public  ReturnEntity<PageInfo<PatientZlyyQueryResp>> queryZlyyzxPage(PatientZlyyQueryRep patientZlyyQueryRep){

        PageInfo<PatientZlyyQueryResp> pageInfo = PageHelper.startPage(
                patientZlyyQueryRep.getPageNum(), patientZlyyQueryRep.getPageSize()).doSelectPageInfo(
                () -> zlSqdyyzxSer.queryZlyyzxPage(patientZlyyQueryRep,getUser())
        );
        return ReturnEntityUtil.success(pageInfo);

    }

    /**
     * 病人治疗执行--治疗项目详情查询
     * @return
     */
    @RequestMapping("/queryZlyyzxXmxq")
    @ResponseBody
    @ApiOperationSupport(author = "zhouhaisheng")
    @ApiOperation(value="病人治疗执行--治疗项目详情查询" ,httpMethod="POST")
    public  ReturnEntity<QueryZlyyzxXmxqResp> queryZlyyzxXmxq(Integer jlxh){
        return ReturnEntityUtil.success(zlSqdyyzxSer.queryZlyyzxXmxq(jlxh,getUser()));
    }



    
}

