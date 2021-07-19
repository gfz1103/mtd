package com.buit.his.treatment.dao;

import com.buit.commons.EntityDao;
import com.buit.his.treatment.model.CisHzyz;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

/**
 * 住院_病区医嘱<br>
 *
 * @author GONGFANGZHOU
 */

@Mapper
@Repository
public interface CisHzyzDao extends EntityDao<CisHzyz, Integer> {
    void updateJcztByJlxh(@Param("jczt") Integer jczt, @Param("jlxh") Integer jlxh);

    void updateJcztBySqid(@Param("jczt") Integer jczt, @Param("sqid") Integer sqid, @Param("ypxh") Integer ypxh);
}
