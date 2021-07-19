package com.buit.his.treatment.dao;

import com.buit.commons.EntityDao;
import com.buit.his.treatment.model.ZlZlz;
import com.buit.his.treatment.request.ZlZlzQueryReq;
import com.buit.his.treatment.response.ZlZlzResp;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * 治疗小组表<br>
 * @author 韦靖
 */
@Mapper
@Repository
public interface ZlZlzDao extends EntityDao<ZlZlz,Integer>{

    /**
     * （新增时）查询同一诊疗类型下是否存在小组名称对应的数据
     * @param zlzmc
     * @param zllb
     * @param jgid
     * @return
     */
    int queryByzmcAndzllbForAdd(@Param("zlzmc") String zlzmc,@Param("zllb") Integer zllb,@Param("jgid") Integer jgid);

    /**
     * (修改时）查询同一诊疗类型下是否存在小组名称对应的数据
     * @param zlzmc
     * @param zllb
     * @param jgid
     * @param zlzid
     * @return
     */
    int queryByzmcAndzllbForUpd(@Param("zlzmc") String zlzmc,@Param("zllb") Integer zllb,@Param("jgid") Integer jgid,@Param("zlzid") Integer zlzid);

    /**
     * 通过主键修改状态
     * @param zlzid
     * @param zt
     */
    void updateZtByZlzid(@Param("zlzid") Integer zlzid,@Param("zt") String zt);

    List<ZlZlzResp> getByKsdm(ZlZlzQueryReq zlzlz);
}
