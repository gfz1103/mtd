package com.buit.his.sams.service;


import com.buit.his.sams.model.SsJzmbmx;
import com.buit.his.sams.request.SsJzmbmxReq;
import com.buit.commons.BaseManagerImp;
import com.buit.constans.TableName;
import com.buit.his.sams.dao.SsJzmbmxDao;

import com.buit.commons.SysUser;
import com.buit.his.sams.response.SsJzmbmxResp;
import com.buit.system.response.SsInputResp;
import com.buit.system.service.FeeYlsfxmOutSer;
import com.buit.utill.BeanUtil;
import com.buit.utill.RedisFactory;
import org.apache.dubbo.config.annotation.DubboReference;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * 手术/麻醉记账模板明细<br>
 * @author zhouhaisheng
 */
@Service
public class SsJzmbmxSer extends BaseManagerImp<SsJzmbmx,Integer> {
    
    static final Logger logger = LoggerFactory.getLogger(SsJzmbmxSer.class);
    
    @Autowired
    private SsJzmbmxDao ssJzmbmxDao;
    @Autowired
    private RedisFactory redisFactory;
    @DubboReference
    private FeeYlsfxmOutSer feeYlsfxmSer;


    @Override
    public SsJzmbmxDao getEntityMapper(){        
        return ssJzmbmxDao;
    }

    /**
     *手术、麻醉记账模板-新增收费项目详情
     * @param ssJzmbmxReqList
     * @param user
     */

   @Transactional(rollbackFor = Exception.class)
    public void saveOrUpdate(List<SsJzmbmxReq> ssJzmbmxReqList, SysUser user) {
       Integer  jzmbzbJlxh=ssJzmbmxReqList.get(0).getJzmbzbJlxh();
       SsJzmbmx queeryParam=new SsJzmbmx();
       queeryParam.setJgid(user.getHospitalId());
       queeryParam.setJzmbzbJlxh(jzmbzbJlxh);
       queeryParam.setSortColumns("xh asc");
        List<SsJzmbmx>  ssJzmbmxList=ssJzmbmxDao.findByEntity(queeryParam);
       Map<Integer,List<SsJzmbmx>> map=ssJzmbmxList.stream().collect(Collectors.groupingBy(SsJzmbmx::getJlxh));


       SsJzmbmx ssJzmbmx=new SsJzmbmx();
        for(SsJzmbmxReq ssJzmbmxReq:ssJzmbmxReqList){
            //判断是否是新增
           if(ssJzmbmxReq.getJlxh()==null){

               BeanUtils.copyProperties(ssJzmbmxReq,ssJzmbmx);
               ssJzmbmx.setJlxh(redisFactory.getTableKey(TableName.DB_NAME,TableName.SS_JZMBMX));
               ssJzmbmx.setJgid(user.getHospitalId());
               ssJzmbmxDao.insert(ssJzmbmx);

           }else{
                   //key存在则为修改 不存在为删除
                   //删除
                   if(!map.containsKey(ssJzmbmxReq.getJlxh())){
                       ssJzmbmxDao.deleteById(ssJzmbmxReq.getJlxh());
                   }
                   //修改
                   else{
                       BeanUtils.copyProperties(ssJzmbmxReq, ssJzmbmx);
                       ssJzmbmx.setJgid(user.getHospitalId());
                       ssJzmbmxDao.update(ssJzmbmx);
                   }
               }
            //删除操作
            if(ssJzmbmxReqList.size()<ssJzmbmxList.size()){
                List<SsJzmbmxReq> reqList=ssJzmbmxReqList.stream().filter(k->k.getJlxh()!=null).collect(Collectors.toList());
                Map<Integer,List<SsJzmbmxReq>> delmap=reqList.stream().collect(Collectors.groupingBy(SsJzmbmxReq::getJlxh));
                for(Integer jlxh:map.keySet()){
                    if(!delmap.containsKey(jlxh)){
                        ssJzmbmxDao.deleteById(jlxh);
                    }
                }
            }


        }



    }

    /**
     * 查询手术麻醉记账模板明细表列表
     * @param ssJzmbmx
     * @return
     */
    public List<SsJzmbmxResp> findList(SsJzmbmx ssJzmbmx) {

        List<SsJzmbmx> ssJzmbmxList=ssJzmbmxDao.findByEntity(ssJzmbmx);

        //转换收费项目、材料
        List<SsJzmbmxResp> resp= BeanUtil.toBeans(ssJzmbmxList,SsJzmbmxResp.class);
        List<SsInputResp> ssInputRespsXm=feeYlsfxmSer.querySsInputItem(ssJzmbmx.getJgid(),null);
        Map<Integer,SsInputResp> xmMap=ssInputRespsXm.stream().collect(Collectors.toMap(SsInputResp::getFyxh, t -> t));
        List<SsInputResp> ssInputRespsMaterial=feeYlsfxmSer.querySsInputMaterial(ssJzmbmx.getJgid(),null);
        Map<Integer,SsInputResp> materialMap=ssInputRespsMaterial.stream().collect(Collectors.toMap(SsInputResp::getFyxh, t -> t));

        for(SsJzmbmxResp ssJzmbmxResp:resp){
            if("2".equals(ssJzmbmxResp.getSfxmlb())){
                ssJzmbmxResp.setDw(xmMap.get(Integer.parseInt(ssJzmbmxResp.getSfxmdm())).getFydw());
                ssJzmbmxResp.setDj(xmMap.get(Integer.parseInt(ssJzmbmxResp.getSfxmdm())).getFydj());
                ssJzmbmxResp.setSfxmmc(xmMap.get(Integer.parseInt(ssJzmbmxResp.getSfxmdm())).getFymc());
            }
            if("1".equals(ssJzmbmxResp.getSfxmlb())){
                ssJzmbmxResp.setDw(materialMap.get(Integer.parseInt(ssJzmbmxResp.getSfxmdm())).getFydw());
                ssJzmbmxResp.setDj(materialMap.get(Integer.parseInt(ssJzmbmxResp.getSfxmdm())).getFydj());
                ssJzmbmxResp.setSfxmmc(materialMap.get(Integer.parseInt(ssJzmbmxResp.getSfxmdm())).getFymc());
            }

        }



        return resp;


    }
}
