package com.buit.his.sams.dao;

import com.buit.commons.EntityDao;
import com.buit.his.sams.model.ImFeeFymx;
import com.buit.his.treatment.response.RwfpFymxResp;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * 费用明细表<br>
 *
 * @author jiangwei
 */
@Mapper
@Repository
public interface ImFeeFymxDao extends EntityDao<ImFeeFymx, Integer> {
    /**
     * 批量插入
     *
     * @param list
     * @return
     */
    void batchInsert(@Param("list") List<ImFeeFymx> list);

    /**
     * 为执行的康复任务创建住院费用明细
     *
     * @param rwfpId 治疗任务主键
     */
    RwfpFymxResp createZlRwfpFymx(Integer rwfpId);
}
