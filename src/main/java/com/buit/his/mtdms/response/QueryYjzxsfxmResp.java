
package com.buit.his.mtdms.response;

import java.math.BigDecimal;

import com.buit.commons.PageQuery;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * 类名称：QueryYjzxsfxmResp<br>
 * 类描述：<br>
 * 
 * @author WY
 */
@ApiModel(value = "收费项目明细")
public class QueryYjzxsfxmResp extends PageQuery {
	private static final long serialVersionUID = -8752590682780824349L;
	@ApiModelProperty(value = "序号")
	private Integer xh;
	@ApiModelProperty(value = "收费项目代码")
	private Integer sfxmdm;
	@ApiModelProperty(value = "收费项目名称")
	private String sfxmmc;
	@ApiModelProperty(value = "药品规格 暂时为空")
	private String ypgg;
	@ApiModelProperty(value = "项目类别 暂时默认都为项目")
	private String xmlb;
	@ApiModelProperty(value = "数量")
	private Integer ylsl;
	@ApiModelProperty(value = "单位")
	private String yldw;
	@ApiModelProperty(value = "单价")
	private BigDecimal yldj;
	@ApiModelProperty(value = "金额")
	private BigDecimal ylje;
	@ApiModelProperty(value = "执行序号")
	private String zxxh;

	public Integer getXh() {
		return xh;
	}

	public void setXh(Integer xh) {
		this.xh = xh;
	}

	public Integer getSfxmdm() {
		return sfxmdm;
	}

	public void setSfxmdm(Integer sfxmdm) {
		this.sfxmdm = sfxmdm;
	}

	public String getSfxmmc() {
		return sfxmmc;
	}

	public void setSfxmmc(String sfxmmc) {
		this.sfxmmc = sfxmmc;
	}

	public String getYpgg() {
		return ypgg;
	}

	public void setYpgg(String ypgg) {
		this.ypgg = ypgg;
	}

	public String getXmlb() {
		return xmlb;
	}

	public void setXmlb(String xmlb) {
		this.xmlb = xmlb;
	}

	public Integer getYlsl() {
		return ylsl;
	}

	public void setYlsl(Integer ylsl) {
		this.ylsl = ylsl;
	}

	public String getYldw() {
		return yldw;
	}

	public void setYldw(String yldw) {
		this.yldw = yldw;
	}

	public BigDecimal getYldj() {
		return yldj;
	}

	public void setYldj(BigDecimal yldj) {
		this.yldj = yldj;
	}

	public BigDecimal getYlje() {
		return ylje;
	}

	public void setYlje(BigDecimal ylje) {
		this.ylje = ylje;
	}

	public String getZxxh() {
		return zxxh;
	}

	public void setZxxh(String zxxh) {
		this.zxxh = zxxh;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

}