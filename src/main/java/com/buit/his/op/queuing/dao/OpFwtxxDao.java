package com.buit.his.op.queuing.dao;

import com.buit.commons.EntityDao;
import com.buit.his.op.queuing.model.OpFwtxx;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.sql.Timestamp;

/**
 * 服务台信息<br>
 * @author 老花生
 */
@Mapper
public interface OpFwtxxDao extends EntityDao<OpFwtxx,Integer>{

    /**
     * @name: editState
     * @description: 编辑状态
     * @param rid
     * @param sfky
     * @param gxsj
     * @return: void
     * @date: 2020/9/1 16:43
     * @auther: 朱智
     *
     */
    void editState(@Param("rid") Integer rid, @Param("sfky") String sfky, @Param("gxsj") Timestamp gxsj);

    /**
     * 通过科室名称或者诊室名称查询服务台
     * @param jgid
     * @param condition
     * @return
     */
    Integer queryFwtIdByKsmcOrZsmc(@Param("jgid") Integer jgid,@Param("condition") String condition);
}
