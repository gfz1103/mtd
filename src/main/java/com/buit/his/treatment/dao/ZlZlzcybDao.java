package com.buit.his.treatment.dao;

import com.buit.commons.EntityDao;
import com.buit.his.treatment.model.ZlZlzcyb;
import com.buit.his.treatment.response.ZlZlzcybResp;
import com.buit.his.treatment.response.ZlsMsgResp;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * 治疗小组成员表<br>
 *
 * @author 韦靖
 */
@Mapper
@Repository
public interface ZlZlzcybDao extends EntityDao<ZlZlzcyb, Integer> {

    /**
     * 通过小组id查询小组成员
     *
     * @param zlzid
     * @return
     */
    List<ZlZlzcybResp> queryByZlzID(@Param("zlzid") Integer zlzid);

    /**
     * 查询某个类别下的治疗师列表
     *
     * @param zllb
     * @param jgid
     * @return
     */
    List<ZlsMsgResp> queryZlsList(@Param("zllb") Integer zllb, @Param("jgid") Integer jgid);

    /**
     * 批量新增
     */
    void batchInsert(List<ZlZlzcyb> list);

    /**
     * 批量删除
     *
     * @param zlzid 治疗组id
     */
    void deleteByZlzId(Integer zlzid);
}
