package com.buit.his.mtdms.dao;

import java.math.BigDecimal;
import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.buit.commons.EntityDao;
import com.buit.his.mtdms.model.OpYjzx;
import com.buit.his.mtdms.request.QueryYjqfListReq;
import com.buit.his.mtdms.request.QueryYjzxqrListReq;
import com.buit.his.mtdms.response.OpyjzxDictResp;
import com.buit.his.mtdms.response.QueryYjqfListResp;
import com.buit.his.mtdms.response.QueryYjzxqrListResp;
import com.buit.his.mtdms.response.QueryYjzxsfxmResp;
import com.buit.his.mtdms.response.QueryYsdmListResp;
import org.apache.ibatis.annotations.Param;

/**
 * 医技确费 <br>
 * 
 * @author WY
 */
@Mapper
public interface OpYjzxDao extends EntityDao<OpYjzx, Integer> {

	/**
	 * 医技确费列表-分页
	 * 
	 * @param req
	 * @return
	 */
	List<QueryYjqfListResp> yjqfList(QueryYjqfListReq req);

	/**
	 * 未执行门诊医技检查确费列表
	 * 
	 * @param req
	 * @return
	 */
	List<QueryYjqfListResp> doQueryMzyjqfList(QueryYjqfListReq req);

	/**
	 * 未执行门诊医技处置确费列表
	 * 
	 * @param req
	 * @return
	 */
	List<QueryYjqfListResp> doQueryMzyjczqfList(QueryYjqfListReq req);

	/**
	 * 住院医技确费列表
	 * 
	 * @param req
	 * @return
	 */
	List<QueryYjqfListResp> doQueryZyyjqfList(QueryYjqfListReq req);

	/**
	 * 医技确费执行列表
	 * 
	 * @param req
	 * @return
	 */
	List<QueryYjqfListResp> doQueryMzZyyjqfList(QueryYjqfListReq req);

	/**
	 * 查询门诊组套和非组套收费项目
	 * 
	 * @param xmdm
	 * @param ztbz
	 * @return
	 */
	List<QueryYjzxsfxmResp> doQueryMzXmDetails(Integer sbxh, Integer ztbz);

	/**
	 * 住院项目收费明细
	 * 
	 * @param xmdm
	 * @param ztbz
	 * @return
	 */
	List<QueryYjzxsfxmResp> doQueryZyXmDetails(Integer sbxh, Integer ztbz);

	/**
	 * 更新医技执行表执行状态
	 * 
	 * @param opYjzx
	 */
	void doUpdateZxztByZxxh(OpYjzx opYjzx);

	/**
	 * 项目执行确认查询列表
	 * 
	 * @param req
	 * @return
	 */
	List<QueryYjzxqrListResp> doQueryYjzxqrList(QueryYjzxqrListReq req);

	/**
	 * 当前执行科室下的检查项目
	 * 
	 * @param ksdm
	 * @return
	 */
	List<OpyjzxDictResp> doQueryJcxmList(Integer ksdm);

	/**
	 * 当前执行科室下的执行医生
	 * 
	 * @param ksdm
	 * @return
	 */
	List<QueryYsdmListResp> doQueryYsdmList(Integer ksdm);

	/**
	 * 获取全部金额
	 * 
	 * @param req
	 * @return
	 */
	BigDecimal doQueryTotalAmount(QueryYjzxqrListReq req);

	List<Integer> selectCf02Xhlist(@Param(value = "xh") String xh);

	List<Integer> selectyzlist( @Param(value = "xh") String xh,@Param(value = "request_no") String request_no);

	List<Integer> selectyzsqdlist( @Param(value = "xh") String xh);

	List<Integer> selectOpJcList(@Param(value = "xh") String xh,@Param(value = "ylxh") String ylxh);

	List<Integer> selectImJcList(@Param(value = "xh") String xh,@Param(value = "ypxh") String ypxh);

	Integer selectSqdLx(@Param(value = "xh")String xh);

	void updateJxsqStatus(@Param(value = "xh")String xh, @Param(value = "status")int status);

	BigDecimal queryFymxByYzxh(@Param(value = "yzxh")Integer yzxh);

	long queryFymxCountByYzxh(@Param(value = "yzxh")Integer yzxh);

	Integer getZlxmId(Integer xmdm);
}
