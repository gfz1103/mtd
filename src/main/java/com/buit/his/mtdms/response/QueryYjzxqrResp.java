
package com.buit.his.mtdms.response;

import java.math.BigDecimal;

import com.github.pagehelper.PageInfo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * 类名称：QueryYjzxqrListResp<br>
 * 类描述：项目执行确认列表返回<br>
 * 
 * @author WY
 */
@ApiModel(value = "项目执行确认返回")
public class QueryYjzxqrResp {
	@ApiModelProperty(value = "项目执行总金额")
	private BigDecimal totalAmount;
	@ApiModelProperty(value = "项目执行确认列表")
	PageInfo<QueryYjzxqrListResp> list = new PageInfo<QueryYjzxqrListResp>();

	public BigDecimal getTotalAmount() {
		return totalAmount;
	}

	public void setTotalAmount(BigDecimal totalAmount) {
		this.totalAmount = totalAmount;
	}

	public PageInfo<QueryYjzxqrListResp> getList() {
		return list;
	}

	public void setList(PageInfo<QueryYjzxqrListResp> list) {
		this.list = list;
	}

}