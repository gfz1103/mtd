
package com.buit.his.treatment.controller;

import com.buit.his.treatment.request.StartZxReq;
import com.buit.his.treatment.request.ZlJlxjzjAddReq;
import com.buit.his.treatment.request.ZlJlxjzjReq;
import com.buit.his.treatment.response.ZlJlxjzjResp;
import com.buit.his.treatment.service.ZlJlxjzjSer;
import com.buit.commons.BaseSpringController;
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
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.validation.Valid;
import java.util.List;

/**
 * 治疗记录小结总结业务<br>
 * @author ZHOUHAISHENG
 */
@Api(tags="治疗记录小结总结业务")
@Controller
@RequestMapping("/zljlxjzj")
public class ZlJlxjzjCtr extends BaseSpringController{

    static final Logger logger = LoggerFactory.getLogger(ZlJlxjzjCtr.class);

    @Autowired
    private ZlJlxjzjSer zlJlxjzjSer;

//    @RequestMapping("/queryPage")
//    @ResponseBody
//    @ApiOperation(value="按条件分页查询" ,httpMethod="POST")
//    public ReturnEntity<PageInfo<ZlJlxjzjResp>> queryPage(ZlJlxjzjReq zljlxjzj,PageQuery page){
//        PageInfo<ZlJlxjzj> pageInfo = PageHelper.startPage(
//            page.getPageNum(), page.getPageSize()).doSelectPageInfo(
//                    () -> zlJlxjzjSer.findByEntity(zljlxjzj)
//            );
//        return ReturnEntityUtil.success(pageInfo);
//    }
//

    /**
     * 查询治疗记录列表
     * @param zlsqdmxJlxh
     * @return
     */
    @RequestMapping("/findJlList")
    @ResponseBody
    @ApiOperationSupport(author = "zhouhaisheng")
    @ApiOperation(value="查询治疗记录列表" ,httpMethod="POST")
    public ReturnEntity<List<ZlJlxjzjResp>> findJlList(Integer zlsqdmxJlxh){//@RequestBody
        return ReturnEntityUtil.success(zlJlxjzjSer.findJlList(zlsqdmxJlxh,getUser()));
    }

//    @RequestMapping("/getOneByEntity")
//    @ResponseBody
//    @ApiOperation(value="按条件查询-返回唯一值" ,httpMethod="POST")
//    public ReturnEntity<ZlJlxjzjResp> getOneByEntity(ZlJlxjzjReq zljlxjzj){
//        List<ZlJlxjzj> list=zlJlxjzjSer.findByEntity(zljlxjzj);
//        if(list.size()>0){
//           return ReturnEntityUtil.success(list.get(0));
//        }
//        return ReturnEntityUtil.success();
//    }
//

    /**
     * 新增治疗终结跟治疗小结治疗记录
     * @param zlJlxjzjAddReq
     * @return
     */
    @RequestMapping("/add")
    @ResponseBody
    @ApiOperationSupport(author = "zhouhaisheng")
    @ApiOperation(value="新增治疗终结跟治疗小结" ,httpMethod="POST")
    public ReturnEntity<String> add(ZlJlxjzjAddReq zlJlxjzjAddReq) {
        zlJlxjzjSer.add(zlJlxjzjAddReq,getUser());
        return ReturnEntityUtil.success();
    }

    /**
     * 治疗记录修改
     * @param zlJlxjzj
     * @return
     */
    @RequestMapping("/edit")
    @ResponseBody
    @ApiOperationSupport(author = "zhouhaisheng")
    @ApiOperation(value="治疗记录修改" ,httpMethod="POST")
    public ReturnEntity edit(ZlJlxjzjReq zlJlxjzj)  {
        zlJlxjzjSer.update(zlJlxjzj);
        return ReturnEntityUtil.success();
    }

    /**
     * 删除治疗记录
     * @param jlxh
     * @return
     */
    @RequestMapping("/delete")
    @ResponseBody
    @ApiOperationSupport(author = "zhouhaisheng")
    @ApiOperation(value="删除治疗记录" ,httpMethod="POST")
    public ReturnEntity delete(Integer jlxh) {
        zlJlxjzjSer.removeById(jlxh);
        return ReturnEntityUtil.success();
    }

    /**
     * 治疗项目完成查询
     * @param zlsqdmxJlxh
     * @return
     */
    @RequestMapping("/queryFinish")
    @ResponseBody
    @ApiOperationSupport(author = "zhouhaisheng")
    @ApiOperation(value="治疗项目完成查询" ,httpMethod="POST")
    public ReturnEntity<ZlJlxjzjResp> queryFinish(Integer zlsqdmxJlxh){

        return zlJlxjzjSer.queryFinish(zlsqdmxJlxh,getUser());

    }
    /**
     * 治疗项目完成保存
     * @param zlsqdmxJlxh
     * @return
     */
    @RequestMapping("/finishSave")
    @ResponseBody
    @ApiOperationSupport(author = "zhouhaisheng")
    @ApiOperation(value="治疗项目完成保存" ,httpMethod="POST")
    public ReturnEntity<String> finishSave(Integer zlsqdmxJlxh){
        return zlJlxjzjSer.finishSave(zlsqdmxJlxh,getUser());

    }
    /**
     * 取消治疗项目完成
     * @param zlsqdmxJlxh
     * @return
     */
    @RequestMapping("/cancelFinish")
    @ResponseBody
    @ApiOperationSupport(author = "zhouhaisheng")
    @ApiOperation(value="取消治疗项目完成" ,httpMethod="POST")
    public ReturnEntity<String> cancelFinish(Integer zlsqdmxJlxh){
        return zlJlxjzjSer.cancelFinish(zlsqdmxJlxh,getUser());

    }

    /**
     * 查询类别下的最后一条执行记录
     * @param zyh
     * @param zllb
     * @return
     */
    @RequestMapping("/queryOneZxjl")
    @ResponseBody
    @ApiOperationSupport(author = "weijing")
    @ApiOperation(value="查询类别下的最后一条执行记录" ,httpMethod="POST")
    public ReturnEntity<ZlJlxjzjResp> queryOneZxjl(@ApiParam(name = "zyh", value = "住院号", required = true) @RequestParam(value = "zyh") Integer zyh,
                                                         @ApiParam(name = "zllb", value = "诊疗类别", required = true) @RequestParam(value = "zllb") Integer zllb){
        return ReturnEntityUtil.success(zlJlxjzjSer.queryOneZxjl(getUser().getHospitalId(),zyh,zllb));
    }

    @RequestMapping("/queryAllZxjl")
    @ResponseBody
    @ApiOperationSupport(author = "weijing")
    @ApiOperation(value="查询类别下的执行记录列表" ,httpMethod="POST")
    public ReturnEntity<List<ZlJlxjzjResp>> queryAllZxjl(@ApiParam(name = "zyh", value = "住院号", required = true) @RequestParam(value = "zyh") Integer zyh,
                                                         @ApiParam(name = "zllb", value = "诊疗类别", required = true) @RequestParam(value = "zllb") Integer zllb){
        return ReturnEntityUtil.success(zlJlxjzjSer.queryAllZxjl(getUser().getHospitalId(),zyh,zllb));
    }

    @RequestMapping("/startZx")
    @ResponseBody
    @ApiOperationSupport(author = "weijing")
    @ApiOperation(value="开始执行" ,httpMethod="POST")
    public ReturnEntity startZx(@Valid @RequestBody StartZxReq req){
        req.setJgid(getUser().getHospitalId());
        req.setZxks(getUser().getDeptId());
        req.setZxr(getUser().getPersonId());
        zlJlxjzjSer.startZx(req);
        return ReturnEntityUtil.success();
    }

    @RequestMapping("/cancelZx")
    @ResponseBody
    @ApiOperationSupport(author = "weijing")
    @ApiOperation(value="取消执行" ,httpMethod="POST")
    public ReturnEntity cancelZx(@ApiParam(name = "jlxh", value = "记录序号（主键）", required = true) @RequestParam(value = "jlxh") Integer jlxh){
        zlJlxjzjSer.cancelZx(jlxh,getUser());
        return ReturnEntityUtil.success();
    }
}

