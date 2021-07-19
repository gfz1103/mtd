package com.buit.his.treatment.dao;

import com.buit.commons.EntityDao;
import com.buit.his.treatment.model.ZlRwfp;
import com.buit.his.treatment.request.*;
import com.buit.his.treatment.response.HistoryAdviceResp;
import com.buit.his.treatment.response.HistoryPatientResp;
import com.buit.his.treatment.response.ZlRwfpPatientResp;
import com.buit.his.treatment.response.ZlRwfpResp;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * 康复治疗任务分配表<br>
 *
 * @author 韦靖
 */
@Mapper
@Repository
public interface ZlRwfpDao extends EntityDao<ZlRwfp, Integer> {
    /**
     * 按属性修改非空值
     */
    void updateByEntity(ZlRwfp rwfp);

    /**
     * 查询治疗任务分配病人列表
     *
     * @param req
     * @return
     */
    List<ZlRwfpPatientResp> queryRwfpPatientPage(ZlRwfpPatientQueryReq req);

    /**
     * 查询住院患者康复治疗任务分配情况
     */
    List<ZlRwfpResp> queryRwfp(ZlRwfpQueryReq req);

    /**
     * 批量新增
     */
    void batchInsert(List<ZlRwfp> list);

    /**
     * 批量删除
     *
     * @param list 医嘱记录序号集合
     */
    void batchRemove(List<Integer> list);

    /**
     * 更改项目诊疗类型
     */
    void edit(ZlRwlbEditReq req);

    /**
     * 分配治疗师及治疗小组
     */
    void rwfp(ZlRwfp rwfp);

    /**
     * 执行
     */
    void execute(Integer rwfpId);

    /**
     * 根据医嘱查询任务
     *
     * @param yzjlxhList 医嘱记录序号
     */
    List<ZlRwfp> findByYzjlxhList(@Param("yzjlxhList") List<Integer> yzjlxhList);

    /**
     * 查询已经开始执行的治疗任务
     *
     * @param zyh 住院号
     */
    List<ZlRwfp> findStartExecutedList(Integer zyh);

    /**
     * 主键查询
     *
     * @param rwfpIds 任务分配id
     */
    List<ZlRwfp> findListByIds(@Param("rwfpIds") List<Integer> rwfpIds);

    /**
     * 取消执行
     *
     * @param zlrwfpId 任务分配id
     */
    void cancel(Integer zlrwfpId);

    /**
     * 查询住院患者治疗记录患者列表
     */
    List<HistoryPatientResp> findTreatmentPatientList(HistoryQueryPatientReq req);

    /**
     * 查询住院患者治疗医嘱列表
     */
    List<HistoryAdviceResp> findTreatmentAdviceList(HistoryQueryAdviceReq req);

    /**
     * 查询定时任务执行列表
     */
    List<ZlRwfpResp> findTaskList();

}
