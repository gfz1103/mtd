
package com.buit.his.sams.controller;

import com.buit.his.sams.service.SsMztfsqzbSer;
import com.buit.commons.BaseSpringController;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * 门诊退费申请主表<br>
 * @author zhouhaishenng
 */
//@Api(tags="门诊退费申请主表")
//@Controller
//@RequestMapping("/ssmztfsqzb")
public class SsMztfsqzbCtr extends BaseSpringController{
    
    static final Logger logger = LoggerFactory.getLogger(SsMztfsqzbCtr.class);
    
    @Autowired
    private SsMztfsqzbSer ssMztfsqzbSer;
    
//    @RequestMapping("/queryPage")
//    @ResponseBody
//    @ApiOperationSupport(author = "zhouhaisheng")
//    @ApiOperation(value="按条件分页查询" ,httpMethod="POST")
//    public ReturnEntity<PageInfo<SsMztfsqzbResp>> queryPage(SsMztfsqzbReq ssmztfsqzb,PageQuery page){
//        PageInfo<SsMztfsqzb> pageInfo = PageHelper.startPage(
//            page.getPageNum(), page.getPageSize()).doSelectPageInfo(
//                    () -> ssMztfsqzbSer.findByEntity(ssmztfsqzb)
//            );
//        return ReturnEntityUtil.success(pageInfo);
//    }
//    
//    @RequestMapping("/findList")
//    @ResponseBody
//    @ApiOperationSupport(author = "zhouhaisheng")
//    @ApiOperation(value="按条件查询-返回列表" ,httpMethod="POST")
//    public ReturnEntity<List<SsMztfsqzbResp>> getByEntity( SsMztfsqzbReq ssmztfsqzb){//@RequestBody 
//        return ReturnEntityUtil.success(ssMztfsqzbSer.findByEntity(ssmztfsqzb));    
//    }
//    
//    @RequestMapping("/getDetail")
//    @ResponseBody
//    @ApiOperationSupport(author = "zhouhaisheng")
//    @ApiOperation(value="按条件查询-返回唯一值" ,httpMethod="POST")
//    public ReturnEntity<SsMztfsqzbResp> getDetail(SsMztfsqzbReq ssmztfsqzb){
//        List<SsMztfsqzb> list=ssMztfsqzbSer.findByEntity(ssmztfsqzb);
//        if(list.size()>0){
//           return ReturnEntityUtil.success(list.get(0));    
//        }
//        return ReturnEntityUtil.success();
//    }
//    
//    /** 新增 */
//    @RequestMapping("/add")
//    @ResponseBody
//    @ApiOperationSupport(author = "zhouhaisheng")
//    @ApiOperation(value="新增" ,httpMethod="POST")
//    public ReturnEntity<SsMztfsqzbResp> add(SsMztfsqzbReq ssMztfsqzb) {
//        ssMztfsqzbSer.insert(ssMztfsqzb);        
//        return ReturnEntityUtil.success(ssMztfsqzb);            
//    }
//    /** 编辑 */
//    @RequestMapping("/edit")
//    @ResponseBody
//    @ApiOperationSupport(author = "zhouhaisheng")
//    @ApiOperation(value="编辑" ,httpMethod="POST")
//    public ReturnEntity<SsMztfsqzbResp> edit(SsMztfsqzbReq ssMztfsqzb)  {
//        ssMztfsqzbSer.update(ssMztfsqzb);        
//        return ReturnEntityUtil.success(ssMztfsqzb);            
//    }
//    
//    /** 删除 */
//    @RequestMapping("/delete")
//    @ResponseBody
//    @ApiOperationSupport(author = "zhouhaisheng")
//    @ApiOperation(value="按条件查询" ,httpMethod="POST")
//    public ReturnEntity<SsMztfsqzbResp> delete(SsMztfsqzbReq ssMztfsqzb) {
//        ssMztfsqzbSer.removeByEntity(ssMztfsqzb);        
//        return ReturnEntityUtil.success(ssMztfsqzb);            
//    }
    
}

