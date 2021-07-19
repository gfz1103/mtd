package com.buit.his.treatment.service;


import com.buit.commons.BaseManagerImp;
import com.buit.commons.SysUser;
import com.buit.constans.TableName;
import com.buit.his.treatment.dao.ZlXmDao;
import com.buit.his.treatment.dao.ZlXmldsfxmDao;
import com.buit.his.treatment.model.ZlXm;
import com.buit.his.treatment.model.ZlXmldsfxm;
import com.buit.his.treatment.request.ZlXmldsfxmAddReq;
import com.buit.his.treatment.request.ZlXmldsfxmUpdateReq;
import com.buit.his.treatment.response.ExecuteLogItemResp;
import com.buit.his.treatment.response.ZlXmldsfxmQueryListResp;
import com.buit.system.model.FeeYlsfxmdjModel;
import com.buit.system.request.FeeYlsfxmdjApiReq;
import com.buit.system.response.FeeYlsfxmOutResp;
import com.buit.system.service.FeeYlsfxmOutSer;
import com.buit.system.service.FeeYlsfxmdjService;
import com.buit.utill.RedisFactory;
import com.buit.utill.ReturnEntity;
import com.buit.utill.ReturnEntityUtil;
import org.apache.commons.collections.CollectionUtils;
import org.apache.dubbo.config.annotation.DubboReference;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 治疗项目联动收费项目表<br>
 *
 * @author ZHOUHAISHENG
 */
@Service
public class ZlXmldsfxmSer extends BaseManagerImp<ZlXmldsfxm, Integer> {

    static final Logger logger = LoggerFactory.getLogger(ZlXmldsfxmSer.class);

    @Autowired
    private ZlXmldsfxmDao zlXmldsfxmDao;

    @Autowired
    private ZlXmDao zlXmDao;

    @Autowired
    private RedisFactory redisFactory;
    //单价获取换fee_ylsfxmdj 表
    @DubboReference
    private FeeYlsfxmOutSer feeYlsfxmOutSer;
    @DubboReference
    private FeeYlsfxmdjService feeYlsfxmdjService;

    @Override
    public ZlXmldsfxmDao getEntityMapper() {
        return zlXmldsfxmDao;
    }

    /**
     * 新增治疗项目联动收费项目表
     *
     * @param zlXmldsfxmAddReq
     * @return
     */
    public ReturnEntity add(ZlXmldsfxmAddReq zlXmldsfxmAddReq, SysUser user) {
        ZlXmldsfxm zlXmldsfxm = new ZlXmldsfxm();
        BeanUtils.copyProperties(zlXmldsfxmAddReq, zlXmldsfxm);

        FeeYlsfxmOutResp feeYlsfxm = feeYlsfxmOutSer.getById(Integer.parseInt(zlXmldsfxmAddReq.getSfxmdm()));
        zlXmldsfxm.setJlxh(redisFactory.getTableKey(TableName.DB_NAME, TableName.ZL_XMLDSFXM));
        zlXmldsfxm.setJgid(user.getHospitalId());
        zlXmldsfxm.setSfxmmc(feeYlsfxm.getFymc());

        FeeYlsfxmdjApiReq feeYlsfxmdj = new FeeYlsfxmdjApiReq();
        feeYlsfxmdj.setJgid(user.getHospitalId());
        feeYlsfxmdj.setFyxh(Integer.parseInt(zlXmldsfxmAddReq.getSfxmdm()));
        feeYlsfxmdj.setZfpb(0);
        List<FeeYlsfxmdjModel> feeYlsfxmdjList = feeYlsfxmdjService.findByEntity(feeYlsfxmdj);
        if (CollectionUtils.isNotEmpty(feeYlsfxmdjList)) {
            zlXmldsfxm.setJe(zlXmldsfxm.getSl().multiply(feeYlsfxmdjList.get(0).getFydj()));
        }

        zlXmldsfxm.setJlxh(redisFactory.getTableKey(TableName.DB_NAME, TableName.ZL_XMLDSFXM));
        zlXmldsfxm.setJgid(user.getHospitalId());
        zlXmldsfxm.setSfxmmc(feeYlsfxm.getFymc());

        if (zlXmldsfxm.getPxh() == null) {
            zlXmldsfxm.setPxh(zlXmldsfxmDao.queryMaxPxh(zlXmldsfxm) + 1);
        }
        zlXmldsfxmDao.insert(zlXmldsfxm);
        return ReturnEntityUtil.success();
    }

    /**
     * 治疗项目联动收费项目列表查询
     *
     * @param jgid     机构id
     * @param zlxmJlxh 治疗项目记录序号
     * @return
     */
    public List<ZlXmldsfxmQueryListResp> findList(Integer jgid, Integer zlxmJlxh) {
        ZlXm zlxm = zlXmDao.getById(zlxmJlxh);
        List<ZlXmldsfxmQueryListResp> results = zlXmldsfxmDao.findList(jgid, zlxmJlxh);
        //List<ZlXmldsfxmQueryListResp> results = BeanUtil.toBeans(zlXmldsfxmList, ZlXmldsfxmQueryListResp.class);
        for (ZlXmldsfxmQueryListResp resp : results) {
            resp.setZllb(zlxm.getZllb());
            resp.setCkmb(zlxm.getCkmb());
            resp.setZysx(zlxm.getZysx());
        }
        return results;
    }


    /**
     * 治疗项目联动收费项目修改
     *
     * @param zlXmldsfxmUpdateReq
     * @param user
     */
    public void update(ZlXmldsfxmUpdateReq zlXmldsfxmUpdateReq, SysUser user) {
        ZlXmldsfxm zlXmldsfxm = new ZlXmldsfxm();
        BeanUtils.copyProperties(zlXmldsfxmUpdateReq, zlXmldsfxm);

        FeeYlsfxmOutResp feeYlsfxm = feeYlsfxmOutSer.getById(Integer.parseInt(zlXmldsfxmUpdateReq.getSfxmdm()));
        zlXmldsfxm.setJgid(user.getHospitalId());
        zlXmldsfxm.setSfxmmc(feeYlsfxm.getFymc());
        zlXmldsfxm.setJe(zlXmldsfxm.getSl().multiply(feeYlsfxm.getFydj()));
        zlXmldsfxmDao.update(zlXmldsfxm);

    }

    /**
     * 治疗项目联动收费项目详情
     *
     * @param jlxh
     */
    public ZlXmldsfxmQueryListResp getDetail(Integer jlxh) {
        ZlXmldsfxm zlXmldsfxm = zlXmldsfxmDao.getById(jlxh);
        ZlXmldsfxmQueryListResp zlXmldsfxmQueryListResp = new ZlXmldsfxmQueryListResp();
        BeanUtils.copyProperties(zlXmldsfxm, zlXmldsfxmQueryListResp);

        FeeYlsfxmOutResp feeYlsfxm = feeYlsfxmOutSer.getById(Integer.parseInt(zlXmldsfxm.getSfxmdm()));
        zlXmldsfxmQueryListResp.setDj(feeYlsfxm.getFydj());
        zlXmldsfxmQueryListResp.setDw(feeYlsfxm.getFydw());
        return zlXmldsfxmQueryListResp;
    }

    /**
     * 查询患者入院以来所有执行过的项目
     *
     * @param zyh  住院号
     * @param zllb 诊疗类别
     * @param zxgh 执行工号
     */
    public List<ExecuteLogItemResp> findListByZyhAndZlsdm(Integer zyh, Integer zllb, Integer zxgh) {
        return zlXmldsfxmDao.findListByZyhAndZlsdm(zyh, zllb, zxgh);
    }

    /**
     * 根据治疗类别查询收费项目
     *
     * @param jgid   机构id
     * @param zllb   治疗类别
     * @param zlksdm 治疗科室
     */
    public List<ZlXmldsfxm> findListByZllb(Integer jgid, Integer zllb, Integer zlksdm) {
        return zlXmldsfxmDao.findListByZllb(jgid, zllb, zlksdm);
    }
}
