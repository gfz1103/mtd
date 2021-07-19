package com.buit.his.op.queuing.dao;

import com.buit.commons.EntityDao;
import com.buit.his.op.queuing.model.OpBcsj;
import com.buit.his.op.queuing.request.OpBcsjReq;
import org.apache.ibatis.annotations.Mapper;

/**
 * 班次上下班时间字典<br>
 * @author 老花生
 */
@Mapper
public interface OpBcsjDao extends EntityDao<OpBcsj,Long>{

//    /**
//     * @name: queryRepeatNum
//     * @description: 时间段重复数
//     * @param req
//     * @return: java.lang.Long
//     * @date: 2020/10/27 16:45
//     * @auther: 老花生
//     *
//     */
//    Long queryRepeatNum(OpBcsjReq req);
	
	/**
	 * 根据时段代码查询班次信息
	 * 
	 * @param sddm
	 * @return
	 */
	public OpBcsj getBySddm(String sddm);
}
