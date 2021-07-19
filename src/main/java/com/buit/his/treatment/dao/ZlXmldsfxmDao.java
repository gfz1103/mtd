package com.buit.his.treatment.dao;

import com.buit.commons.EntityDao;
import com.buit.his.treatment.model.ZlXmldsfxm;
import com.buit.his.treatment.response.ExecuteLogItemResp;
import com.buit.his.treatment.response.ZlXmldsfxmQueryListResp;
import com.buit.system.response.GyYlxmDicResp;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * 治疗项目联动收费项目表<br>
 *
 * @author ZHOUHAISHENG
 */
@Mapper
@Repository
public interface ZlXmldsfxmDao extends EntityDao<ZlXmldsfxm, Integer> {
    /**
     * 查询最大的排序号
     *
     * @param zlXmldsfxm
     * @return
     */
    Integer queryMaxPxh(ZlXmldsfxm zlXmldsfxm);

    /**
     * 查询某治疗项目的所有收费项
     *
     * @param jgid     机构id
     * @param zlxmJlxh 治疗项目记录序号
     */
    List<ZlXmldsfxmQueryListResp> findList(@Param("jgid") Integer jgid, @Param("zlxmJlxh") Integer zlxmJlxh);

    /**
     * 查询患者入院以来所有执行过的项目
     *
     * @param zyh  住院号
     * @param zllb 治疗类别
     * @param zxgh 执行工号
     */
    List<ExecuteLogItemResp> findListByZyhAndZlsdm(@Param("zyh") Integer zyh, @Param("zllb") Integer zllb, @Param("zxgh") Integer zxgh);


    /**
     * 通过康复组套查询到它的收费子项
     *
     * @param jgid
     * @param zlxmjlxh
     * @return
     */
    List<GyYlxmDicResp> getfyxmDatas(Integer jgid, Integer zlxmjlxh);

    /**
     * 根据治疗类别查询收费项目
     *
     * @param jgid   机构id
     * @param zllb   治疗类别
     * @param zlksdm 治疗科室
     */
    List<ZlXmldsfxm> findListByZllb(Integer jgid, Integer zllb, Integer zlksdm);
}
