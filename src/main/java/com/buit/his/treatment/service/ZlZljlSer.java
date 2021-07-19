package com.buit.his.treatment.service;


import cn.hutool.core.collection.CollectionUtil;
import cn.hutool.core.util.StrUtil;
import com.buit.commons.BaseManagerImp;
import com.buit.constans.TableName;
import com.buit.his.treatment.dao.ZlZljlDao;
import com.buit.his.treatment.enums.ZfpbEnum;
import com.buit.his.treatment.model.ZlZljl;
import com.buit.his.treatment.response.ExecuteLogResp;
import com.buit.his.treatment.response.ZljlReportDetailResp;
import com.buit.utill.DateUtils;
import com.buit.utill.RedisFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * @author jiangwei
 * @Description 治疗记录表
 * @Date 2021-33-26
 */
@Service
public class ZlZljlSer extends BaseManagerImp<ZlZljl, Integer> {

    static final Logger logger = LoggerFactory.getLogger(ZlZljlSer.class);

    @Autowired
    private ZlZljlDao zlZljlDao;
    @Autowired
    private RedisFactory redisFactory;

    @Override
    public ZlZljlDao getEntityMapper() {
        return zlZljlDao;
    }

    /**
     * 获取指定的治疗记录
     *
     * @param zlsdm 治疗师代码
     * @param zyh   住院号
     * @param zllb  诊疗类别
     * @param zxrq  执行日期
     */
    public ZlZljl getZlzljl(Integer zlsdm, Integer zyh, Integer zllb, String zxrq) {
        ZlZljl query = new ZlZljl();
        query.setZxgh(zlsdm);
        query.setZyh(zyh);
        query.setZllb(zllb);
        query.setZxrq(zxrq);
        query.setZt(ZfpbEnum.ABLE.getValue());
        List<ZlZljl> list = zlZljlDao.findByEntity(query);
        if (CollectionUtil.isNotEmpty(list)) {
            return list.get(0);
        }
        return null;
    }

    /**
     * 创建治疗记录
     *
     * @param zyh   住院号
     * @param zxrq  执行日期
     * @param zlsdm 治疗师代码
     * @param zllb  诊疗类别
     */
    @Transactional(rollbackFor = Exception.class)
    public void create(Integer zyh, String zxrq, Integer zlsdm, Integer zllb) {
        //查询今天是否有创建过执行记录
        ZlZljl query = new ZlZljl();
        query.setZyh(zyh);
        query.setZxrq(zxrq);
        query.setZllb(zllb);
//        query.setZxgh(zlsdm);
        query.setZt(ZfpbEnum.ABLE.getValue());
        List<ZlZljl> jlOfToday = zlZljlDao.findByEntity(query);
        if (CollectionUtil.isEmpty(jlOfToday)) {
            query.setZxrq(null);
            query.setSortColumns("zxrq desc");
            //查找记录列表
            List<ZlZljl> history = zlZljlDao.findByEntity(query);

            Integer mqzxcs = 0;
            Integer scxjcs = 0;
            if (CollectionUtil.isNotEmpty(history)) {
                //最近一次执行记录
                ZlZljl lastRecord = history.get(0);
                mqzxcs = lastRecord.getMqzxcs();
                scxjcs = lastRecord.getScxjcs();
            }

            ZlZljl zljl = new ZlZljl();
            zljl.setJlxh(redisFactory.getTableKey(TableName.DB_NAME, TableName.ZL_ZLJL));
            zljl.setZyh(zyh);
            zljl.setZxrq(zxrq);
            zljl.setZllb(zllb);
            zljl.setZxgh(zlsdm);
            zljl.setJlgh(zlsdm);
            zljl.setJlsj(DateUtils.getNow());
            zljl.setBlfy("无不良反应");
            zljl.setMqzxcs(mqzxcs + 1);
            zljl.setScxjcs(scxjcs);
            zljl.setZt(ZfpbEnum.ABLE.getValue());
            zlZljlDao.insert(zljl);
        }
    }

    /**
     * 生成历史治疗记录
     *
     * @param zyh   住院号
     * @param zxrq  执行日期
     * @param zlsdm 治疗师代码
     * @param zllb  诊疗类别
     */
    @Transactional(rollbackFor = Exception.class)
    public void reCreate(Integer zyh, String zxrq, Integer zlsdm, Integer zllb) {
        //查询今天是否有执行记录
        ZlZljl query = new ZlZljl();
        query.setZyh(zyh);
        query.setZxrq(zxrq);
        query.setZllb(zllb);
//        query.setZxgh(zlsdm);
        List<ZlZljl> jlOfToday = zlZljlDao.findByEntity(query);
        if (CollectionUtil.isEmpty(jlOfToday)) {
            ZlZljl zljl = new ZlZljl();
            zljl.setJlxh(redisFactory.getTableKey(TableName.DB_NAME, TableName.ZL_ZLJL));
            zljl.setZyh(zyh);
            zljl.setZxrq(zxrq);
            zljl.setZllb(zllb);
            zljl.setZxgh(zlsdm);
            zljl.setJlgh(zlsdm);
            zljl.setJlsj(DateUtils.getNow());
            zljl.setMqzxcs(-1);
            zljl.setScxjcs(-1);
            zljl.setZt(ZfpbEnum.ABLE.getValue());
            zlZljlDao.insert(zljl);
        } else {
            query = jlOfToday.get(0);
            if (ZfpbEnum.DISABLED.equals(query.getZt())) {
                query.setZt(ZfpbEnum.ABLE.getValue());
                ZlZljl zljl = new ZlZljl();
                zljl.setJlxh(redisFactory.getTableKey(TableName.DB_NAME, TableName.ZL_ZLJL));
                zljl.setZyh(zyh);
                zljl.setZxrq(zxrq);
                zljl.setZllb(zllb);
//                zljl.setZxgh(zlsdm);
                zljl.setJlgh(zlsdm);
                zljl.setJlsj(DateUtils.getNow());
                zljl.setMqzxcs(-1);
                zljl.setScxjcs(-1);
                zljl.setZt(ZfpbEnum.ABLE.getValue());
                zlZljlDao.insert(zljl);
            }

        }
    }

    /**
     * 修改非空属性
     */
    public void updateByEntity(ZlZljl zljl) {
        zlZljlDao.updateByEntity(zljl);
    }

    /**
     * 取消执行
     *
     * @param jlxh   治疗记录序号
     * @param userId 取消工号
     * @param qxyy   取消原因
     */
    public void cancel(Integer jlxh, Integer userId, String qxyy) {
        ZlZljl query = new ZlZljl();
        query.setJlxh(jlxh);
        query.setZt(ZfpbEnum.DISABLED.getValue());
        query.setZxgh(null);
        query.setZxrq(null);
        query.setQxgh(userId);
        query.setQxsj(DateUtils.getNow());
        query.setQxyy(qxyy);
        zlZljlDao.updateByEntity(query);
    }

    /**
     * 治疗记录单打印 治疗记录数据
     *
     * @param zyh   住院号
     * @param zllb  诊疗类别
     * @param zlsdm 治疗师代码
     * @param map   项目代码与项目编码的映射
     */
    public List<ExecuteLogResp> findZljlReportDetailResp(Integer zyh, Integer zllb, Integer zlsdm, Map<String, String> map) {
        //成块分割的治疗记录
        List<ExecuteLogResp> results = new ArrayList<>();
        //所有治疗记录
        List<ZljlReportDetailResp> list = zlZljlDao.findZljlReportDetailResp(zyh, zllb, zlsdm);

        //初始阶段点
        int splitIndex = 0;
        ExecuteLogResp result = null;
        for (int index = 0; index < list.size(); index++) {
            ZljlReportDetailResp resp = list.get(0);
            //替换项目代码为项目编号
            String[] sfxmdmArray = resp.getZlxm().split(",");
            List<String> rownums = Arrays.stream(sfxmdmArray).map(r -> map.get(r)).collect(Collectors.toList());
            resp.setZlxm(CollectionUtil.join(rownums, ","));

            //如果治疗记录有阶段小结，截断当前数组
            if (StrUtil.isNotBlank(resp.getJdxj()) || index == list.size() - 1) {
                result = new ExecuteLogResp();
                result.setJdxj(resp.getJdxj());
                result.setList(list.subList(splitIndex, index + 1));
                results.add(result);
                splitIndex = index + 1;
            }
        }
        return results;
    }

    /**
     * 通过任务分配id 查询治疗记录
     *
     * @param zlrwfpid 治疗任务分配id
     */
    public List<ZlZljl> findTreatmentRecords(Integer zlrwfpid) {
        return zlZljlDao.findTreatmentRecords(zlrwfpid);
    }
}
