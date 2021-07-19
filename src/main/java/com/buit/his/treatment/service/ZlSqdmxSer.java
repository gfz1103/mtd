package com.buit.his.treatment.service;


import cn.hutool.core.bean.copier.CopyOptions;
import com.buit.commons.BaseException;
import com.buit.commons.BaseManagerImp;
import com.buit.commons.SysUser;
import com.buit.constans.TableName;
import com.buit.his.treatment.dao.ZlSqdmxDao;
import com.buit.his.treatment.dao.ZlSqdsfmxDao;
import com.buit.his.treatment.dao.ZlXmldsfxmDao;
import com.buit.his.treatment.model.ZlSqdmx;
import com.buit.his.treatment.model.ZlSqdsfmx;
import com.buit.his.treatment.model.ZlSqdzb;
import com.buit.his.treatment.model.ZlXmldsfxm;
import com.buit.his.treatment.request.ZlSqdmxReq;
import com.buit.his.treatment.request.ZlSqdmxUpdateReq;
import com.buit.his.treatment.request.ZlSqdzbUpdateReq;
import com.buit.his.treatment.request.ZlsqdMxCheckReq;
import com.buit.his.treatment.response.ZlSqdmxResp;
import com.buit.his.treatment.response.ZlXmldsfxmQueryListResp;
import com.buit.op.service.OpYjcf01Service;
import com.buit.utill.BeanUtil;
import com.buit.utill.RedisFactory;
import com.buit.utill.ReturnEntity;
import com.buit.utill.ReturnEntityUtil;
import org.apache.dubbo.config.annotation.DubboReference;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * 治疗申请单明细表<br>
 *
 * @author ZHOUHAISHENG
 */
@Service
public class ZlSqdmxSer extends BaseManagerImp<ZlSqdmx, Integer> {

    static final Logger logger = LoggerFactory.getLogger(ZlSqdmxSer.class);

    @Autowired
    private ZlSqdmxDao zlSqdmxDao;
    @Autowired
    private RedisFactory redisFactory;
    @Autowired
    public ZlSqdsfmxDao zlSqdsfmxDao;
    @Autowired
    public ZlXmldsfxmSer zlXmldsfxmSer;
    @Autowired
    private ZlXmldsfxmDao zlXmldsfxmDao;
    @DubboReference
    private OpYjcf01Service opYjcf01Service;

    @Override
    public ZlSqdmxDao getEntityMapper() {
        return zlSqdmxDao;
    }

    /**
     * 新增病人治疗申请明细
     *
     * @param zlSqdmxReqList
     * @return
     */
    @Transactional(rollbackFor = Exception.class)
    public List<ZlSqdmx> add(List<ZlSqdmxReq> zlSqdmxReqList, ZlSqdzb zlSqdzb, SysUser user) {
        List<ZlSqdmx> zlSqdmxList = new ArrayList<>();

        Integer xh = 1;
        for (ZlSqdmxReq zlSqdmxReq : zlSqdmxReqList) {
            ZlSqdmx zlSqdmx = new ZlSqdmx();
            BeanUtils.copyProperties(zlSqdmxReq, zlSqdmx);
            zlSqdmx.setJlxh(redisFactory.getTableKey(TableName.DB_NAME, TableName.ZL_SQDMX));
            zlSqdmx.setXh(xh);
            zlSqdmx.setZlsqdh(zlSqdzb.getZlsqdh());
            zlSqdmx.setJgid(user.getHospitalId());
            zlSqdmx.setZt("0");//默认未预约
            zlSqdmx.setYyycs(BigDecimal.ZERO);
            zlSqdmx.setYzxcs(BigDecimal.ZERO);
            zlSqdmxDao.insert(zlSqdmx);

            xh++;
            zlSqdmxList.add(zlSqdmx);

            //保存收费项目明细（批量新增收费项目）
            List<ZlXmldsfxmQueryListResp> sfxmList = zlXmldsfxmDao.findList(user.getHospitalId(), zlSqdmx.getZlxmJlxh());
            List<ZlSqdsfmx> insertList = new ArrayList<>();
            for (ZlXmldsfxmQueryListResp resp : sfxmList) {
                ZlSqdsfmx insert = new ZlSqdsfmx();
                insert.setJlxh(redisFactory.getTableKey(TableName.DB_NAME, TableName.ZL_SQDSFMX));
                insert.setSqdmxJlxh(zlSqdmx.getJlxh());
                insert.setSfxmdm(Integer.parseInt(resp.getSfxmdm()));
                insert.setSfxmmc(resp.getSfxmmc());
                insertList.add(insert);
            }
            zlSqdsfmxDao.batchInsert(insertList);
        }
        return zlSqdmxList;
    }

    /**
     * 删除病人治疗申请明细
     *
     * @param zlSqdmx
     * @return
     */
    public ReturnEntity<ZlSqdmxResp> delete(ZlSqdmxReq zlSqdmx) {
        return null;
    }

    /**
     * 修改病人治疗项目明细
     *
     * @param zlSqdzbUpdateReq
     * @param zlSqdmxUpdateReqList
     * @param user
     */
    @Transactional(rollbackFor = Exception.class)
    public void updateList(ZlSqdzbUpdateReq zlSqdzbUpdateReq, List<ZlSqdmxUpdateReq> zlSqdmxUpdateReqList, SysUser user) {
        //先去查询该病人治疗申请下面的诊断信息
        ZlSqdmx queryParam = new ZlSqdmx();
        queryParam.setZlsqdh(zlSqdzbUpdateReq.getZlsqdh());
        queryParam.setJgid(user.getHospitalId());
        List<ZlSqdmx> zlSqdmxList = zlSqdmxDao.findByEntity(queryParam);
        Map<Integer, List<ZlSqdmx>> zlsqdmxMap = zlSqdmxList.stream().collect(Collectors.groupingBy(ZlSqdmx::getJlxh));
        Map<Integer, ZlSqdmx> updateMap = new HashMap<>();
        for (ZlSqdmxUpdateReq zlSqdmxUpdateReq : zlSqdmxUpdateReqList) {


            //查询jlxh是否为空 为空则新增
            if (zlSqdmxUpdateReq.getJlxh() == null) {
                ZlSqdmx zlSqdmxAdd = new ZlSqdmx();
                cn.hutool.core.bean.BeanUtil.copyProperties(zlSqdmxUpdateReq, zlSqdmxAdd, CopyOptions.create().setIgnoreNullValue(true));
                zlSqdmxAdd.setJgid(user.getHospitalId());
                zlSqdmxAdd.setZlsqdh(zlSqdzbUpdateReq.getZlsqdh());
                zlSqdmxAdd.setJlxh(redisFactory.getTableKey(TableName.DB_NAME, TableName.ZL_SQDMX));


                //校验申请单项目是否重复
                ZlsqdMxCheckReq zlsqdMxCheckReq = new ZlsqdMxCheckReq();
                BeanUtils.copyProperties(zlSqdzbUpdateReq, zlsqdMxCheckReq);
                zlsqdMxCheckReq.setZlxmmc(zlSqdmxUpdateReq.getZlxmmc());
                zlsqdMxCheckReq.setJlxh(null);
                List<ZlSqdmx> zlSqdmxes = zlSqdmxDao.addCcheck(zlsqdMxCheckReq);
                if (zlSqdmxes.size() > 0) {
                    throw BaseException.create("ERROR_ZL_00007", new String[]{zlSqdmxUpdateReq.getZlxmmc()});
                }
                zlSqdmxDao.insert(zlSqdmxAdd);
                updateMap.put(zlSqdmxAdd.getJlxh(), zlSqdmxAdd);

            }
            //jlxh不为空 做修改操作
            else {
                ZlSqdmx zlSqdmxUpdate = new ZlSqdmx();
                cn.hutool.core.bean.BeanUtil.copyProperties(zlSqdmxUpdateReq, zlSqdmxUpdate, CopyOptions.create().setIgnoreNullValue(true));
                ZlSqdmx zlSqdmx = new ZlSqdmx();
                zlSqdmx.setJgid(user.getHospitalId());
                zlSqdmx.setZlxmmc(zlSqdmxUpdateReq.getZlxmmc());
                zlSqdmx.setJlxh(zlSqdmxUpdateReq.getJlxh());
                //校验申请单项目是否重复
                //校验申请单项目是否重复
                ZlsqdMxCheckReq zlsqdMxCheckReq = new ZlsqdMxCheckReq();
                BeanUtils.copyProperties(zlSqdmxUpdateReq, zlsqdMxCheckReq);
                zlsqdMxCheckReq.setZlxmmc(zlSqdmxUpdateReq.getZlxmmc());
                zlsqdMxCheckReq.setJlxh(zlSqdmxUpdateReq.getJlxh());
                List<ZlSqdmx> zlSqdmxes = zlSqdmxDao.addCcheck(zlsqdMxCheckReq);
                if (zlSqdmxes.size() > 0) {
                    throw BaseException.create("ERROR_ZL_00007", new String[]{zlSqdmx.getZlxmmc()});
                }

                zlSqdmxDao.update(zlSqdmxUpdate);
                updateMap.put(zlSqdmxUpdate.getJlxh(), zlSqdmxUpdate);
            }

        }
        //查询删除的诊断记录
        for (Integer jlxh : zlsqdmxMap.keySet()) {
            if (!updateMap.containsKey(jlxh)) {
                zlSqdmxDao.deleteById(jlxh);
            }

        }

    }

    /**
     * 查询治疗申请单明细项目列表
     *
     * @param zlsqdh
     * @param user
     * @return
     */
    public List<ZlSqdmxResp> findZlyyZlxmList(String zlsqdh, SysUser user) {
        List<ZlSqdmxResp> resp = new ArrayList<>();
        ZlSqdmx queryParam = new ZlSqdmx();
        queryParam.setZlsqdh(zlsqdh);
        queryParam.setJgid(user.getHospitalId());
        List<ZlSqdmx> zlSqdmxList = zlSqdmxDao.findByEntity(queryParam);
        resp = BeanUtil.toBeans(zlSqdmxList, ZlSqdmxResp.class);
        return resp;
    }

    /**
     * 查询统计-病人治疗申请单-申请单治疗项目
     *
     * @param zlsqdh
     * @param user
     * @return
     */
    public List<ZlSqdmxResp> queryPatientZlyyReportDetail(String zlsqdh, SysUser user) {
        ZlSqdmx zlSqdmx = new ZlSqdmx();
        zlSqdmx.setJgid(user.getHospitalId());
        zlSqdmx.setZlsqdh(zlsqdh);
        return zlSqdmxDao.queryPatientZlyyReportDetail(zlSqdmx);
    }

    /**
     * 根据治疗申请单号删除申请单明细
     *
     * @param sqdh
     */
    public void deleteBySqdh(Integer sqdh) {
        ZlSqdmx zlSqdmx = new ZlSqdmx();
        zlSqdmx.setZlsqdh(String.valueOf(sqdh));
        zlSqdmxDao.removeByEntity(zlSqdmx);
    }

}
