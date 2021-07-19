package com.buit.his.mtdms.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.buit.commons.EntityDao;
import com.buit.his.mtdms.model.OpYjzxsfxm;
import com.buit.his.mtdms.response.QueryYjzxsfxmResp;

/**
 * <br>
 * 
 * @author WY
 */
@Mapper
public interface OpYjzxsfxmDao extends EntityDao<OpYjzxsfxm, Integer> {

	/**
	 * 收费项目
	 * 
	 * @param sbxh
	 * @return
	 */
	List<QueryYjzxsfxmResp> doQueryXmDetails(Integer sbxh);

	/**
	 * 更新收费项目表状态
	 * 
	 * @param opYjzxsfxm
	 */
	void doUpdateZtByZxxh(OpYjzxsfxm opYjzxsfxm);

}
