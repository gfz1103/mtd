
package com.buit.his.mtdms.response;

import com.buit.commons.PageQuery;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * 类名称：OpyjzxDictResp<br>
 * 类描述：项目执行字典列表返回<br>
 * 
 * @author WY
 */
@ApiModel(value = "项目执行字典列表返回")
public class OpyjzxDictResp extends PageQuery {
	private static final long serialVersionUID = 1094765794265661557L;
	@ApiModelProperty(value = "诊疗项目ID")
	private Integer zlxmId;
	@ApiModelProperty(value = "费用序号")
	private Integer fyxh;
	@ApiModelProperty(value = "项目名称")
	private String xmmc;
	@ApiModelProperty(value = "拼音代码")
	private String pyCode;
	@ApiModelProperty(value = "五笔代码")
	private String wbCode;

	public Integer getZlxmId() {
		return zlxmId;
	}

	public void setZlxmId(Integer zlxmId) {
		this.zlxmId = zlxmId;
	}

	public Integer getFyxh() {
		return fyxh;
	}

	public void setFyxh(Integer fyxh) {
		this.fyxh = fyxh;
	}

	public String getXmmc() {
		return xmmc;
	}

	public void setXmmc(String xmmc) {
		this.xmmc = xmmc;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	public String getPyCode() {
		return pyCode;
	}

	public void setPyCode(String pyCode) {
		this.pyCode = pyCode;
	}

	public String getWbCode() {
		return wbCode;
	}

	public void setWbCode(String wbCode) {
		this.wbCode = wbCode;
	}

}