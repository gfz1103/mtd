
package com.buit.his.sams.controller;

import com.buit.commons.BaseSpringController;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * 门诊退费申请明细表<br>
 * @author zhouhaishenng
 */
//@Api(tags="门诊退费申请明细表")
//@Controller
//@RequestMapping("/ssmztfsqmx")
public class SsMztfsqmxCtr extends BaseSpringController{
    
    static final Logger logger = LoggerFactory.getLogger(SsMztfsqmxCtr.class);
    
//    @Autowired
//    private SsMztfsqmxSer ssMztfsqmxSer;
    
//    @RequestMapping("/queryPage")
//    @ResponseBody
//    @ApiOperationSupport(author = "zhouhaisheng")
//    @ApiOperation(value="按条件分页查询" ,httpMethod="POST")
//    public ReturnEntity<PageInfo<SsMztfsqmxResp>> queryPage(SsMztfsqmxReq ssmztfsqmx,PageQuery page){
//        PageInfo<SsMztfsqmx> pageInfo = PageHelper.startPage(
//            page.getPageNum(), page.getPageSize()).doSelectPageInfo(
//                    () -> ssMztfsqmxSer.findByEntity(ssmztfsqmx)
//            );
//        return ReturnEntityUtil.success(pageInfo);
//    }
//    
//    @RequestMapping("/findList")
//    @ResponseBody
//    @ApiOperationSupport(author = "zhouhaisheng")
//    @ApiOperation(value="按条件查询-返回列表" ,httpMethod="POST")
//    public ReturnEntity<List<SsMztfsqmxResp>> getByEntity( SsMztfsqmxReq ssmztfsqmx){//@RequestBody 
//        return ReturnEntityUtil.success(ssMztfsqmxSer.findByEntity(ssmztfsqmx));    
//    }
//    
//    @RequestMapping("/getDetail")
//    @ResponseBody
//    @ApiOperationSupport(author = "zhouhaisheng")
//    @ApiOperation(value="按条件查询-返回唯一值" ,httpMethod="POST")
//    public ReturnEntity<SsMztfsqmxResp> getDetail(SsMztfsqmxReq ssmztfsqmx){
//        List<SsMztfsqmx> list=ssMztfsqmxSer.findByEntity(ssmztfsqmx);
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
//    public ReturnEntity<SsMztfsqmxResp> add(SsMztfsqmxReq ssMztfsqmx) {
//        ssMztfsqmxSer.insert(ssMztfsqmx);        
//        return ReturnEntityUtil.success(ssMztfsqmx);            
//    }
//    /** 编辑 */
//    @RequestMapping("/edit")
//    @ResponseBody
//    @ApiOperationSupport(author = "zhouhaisheng")
//    @ApiOperation(value="编辑" ,httpMethod="POST")
//    public ReturnEntity<SsMztfsqmxResp> edit(SsMztfsqmxReq ssMztfsqmx)  {
//        ssMztfsqmxSer.update(ssMztfsqmx);        
//        return ReturnEntityUtil.success(ssMztfsqmx);            
//    }
//    
//    /** 删除 */
//    @RequestMapping("/delete")
//    @ResponseBody
//    @ApiOperationSupport(author = "zhouhaisheng")
//    @ApiOperation(value="按条件查询" ,httpMethod="POST")
//    public ReturnEntity<SsMztfsqmxResp> delete(SsMztfsqmxReq ssMztfsqmx) {
//        ssMztfsqmxSer.removeByEntity(ssMztfsqmx);        
//        return ReturnEntityUtil.success(ssMztfsqmx);            
//    }
    
}

