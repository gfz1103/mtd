package com.buit.his.treatment.dao;

import com.buit.commons.EntityDao;
import com.buit.his.treatment.model.ZlLb;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * 治疗类别表<br>
 *
 * @author ZHOUHAISHENG
 */
@Mapper
@Repository
public interface ZlLbDao extends EntityDao<ZlLb, Integer> {
    /**
     * 查询最大排序号
     */
    Integer queryMaxPxh(ZlLb zlLbReq);

    /**
     * 验证修改治疗类别名称唯一性
     */
    List<ZlLb> verifyUpdateZllb(ZlLb zlLbReq);
}
