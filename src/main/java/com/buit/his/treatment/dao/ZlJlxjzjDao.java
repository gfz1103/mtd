package com.buit.his.treatment.dao;

import com.buit.his.treatment.model.ZlJlxjzj;
import com.buit.commons.EntityDao;

import com.buit.his.treatment.response.ZlJlxjzjResp;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * 治疗记录/小结/总结表<br>
 * @author ZHOUHAISHENG
 */
@Mapper
public interface ZlJlxjzjDao extends EntityDao<ZlJlxjzj,Integer>{

    /**
     * 查询某个类型的诊疗项目的最新一条数据
     * @param jgid
     * @param zyh
     * @param zllb
     * @return
     */
    ZlJlxjzjResp queryOneZxjl(@Param("jgid") Integer jgid,@Param("zyh") Integer zyh,@Param("zllb") Integer zllb);


    /**
     * 查询某个类型的诊疗项目的所有数据
     * @param jgid
     * @param zyh
     * @param zllb
     * @return
     */
    List<ZlJlxjzjResp> queryZxjl(@Param("jgid") Integer jgid,@Param("zyh") Integer zyh,@Param("zllb") Integer zllb);

    /**
     * 通过主键修改取消执行
     * @param zlJlxjzj
     */
    void cancelZx(ZlJlxjzj zlJlxjzj);
}
