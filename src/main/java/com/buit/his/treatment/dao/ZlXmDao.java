package com.buit.his.treatment.dao;


import com.buit.commons.EntityDao;
import com.buit.his.treatment.model.ZlXm;
import com.buit.his.treatment.request.QueryZlxmSrfReq;
import com.buit.his.treatment.response.ZlXmResp;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * 治疗项目表<br>
 * @author ZHOUHAISHENG
 */
@Mapper
@Repository
public interface ZlXmDao extends EntityDao<ZlXm,Integer> {
    /**
     * 治疗项目输入法
     * @param queryZlxmSrfReq
     */
    List<ZlXmResp> queryZlxmSrf(QueryZlxmSrfReq queryZlxmSrfReq);

    /**
     * 治疗项目修改校验
     *
     * @param zlXmparam
     * @return
     */
    List<ZlXm> verifyUpdateZlxm(ZlXm zlXmparam);

    /**
     * 通过收费项目代码查询治疗项目（诊疗类别）
     *
     * @param sfxmdm 收费项目代码
     * @param jgid   机构代码
     */
    ZlXm getBySfxmdm(@Param("sfxmdm") String sfxmdm, @Param("jgid") Integer jgid);

    /**
     * 查询停用的项目列表
     * @param zlxmJlxhList
     * @param jgid
     * @return
     */
    List<String> checkIsStop(List<Integer> zlxmJlxhList,Integer jgid);
}
