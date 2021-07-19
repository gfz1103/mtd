
package com.buit.his.mtdms.response;

import java.math.BigDecimal;
import java.sql.Timestamp;

import com.buit.commons.PageQuery;
import com.fasterxml.jackson.annotation.JsonIgnore;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * 类名称：QueryYjzxqrListResp<br>
 * 类描述：项目执行确认列表返回<br>
 * 
 * @author WY
 */
@ApiModel(value = "项目执行确认列表返回")
public class QueryYjzxqrListResp extends PageQuery {
	private static final long serialVersionUID = 1094765794265661557L;
	@ApiModelProperty(value = "执行序号")
	private Integer zxxh;
	@ApiModelProperty(value = "执行时间")
	private Timestamp zxsj;
	@ApiModelProperty(value = "执行医生代码")
	private Integer zxysdm;
	@ApiModelProperty(value = "病人类型  1：门诊 2：住院")
	private String brlx;
	@ApiModelProperty(value = "住院号码")
	private String zyhm;
	@ApiModelProperty(value = "就诊卡号")
	private String jzkh;
	@ApiModelProperty(value = "病人姓名")
	private String brxm;
	@ApiModelProperty(value = "病人性别")
	private Integer brxb;
	@ApiModelProperty(value = "病人年龄描述")
	private String ages;
	@ApiModelProperty(value = "项目名称")
	private String xmmc;
	@ApiModelProperty(value = "申请科室代码")
	private Integer sqksdm;
	@ApiModelProperty(value = "申请医生代码")
	private Integer sqysdm;
	@ApiModelProperty(value = "数量")
	private BigDecimal sl;
	@ApiModelProperty(value = "单位")
	private String dw;
	@ApiModelProperty(value = "金额")
	private BigDecimal ylje;
	@ApiModelProperty(value = "执行状态")
	private String zxzt;
	@ApiModelProperty(value = "取消执行时间")
	private Timestamp qxzxsj;
	@ApiModelProperty(value = "取消医生代码")
	private Integer qxysdm;
	@ApiModelProperty(value = "作废时间")
	private Timestamp zfsj;
	@ApiModelProperty(value = "作废医生代码")
	private Integer zfysdm;
	@JsonIgnore
	@ApiModelProperty(value = "出生年月")
	private Timestamp csny;
	@ApiModelProperty(value = "申请时间")
	private Timestamp sqsj;
	@ApiModelProperty(value = "费用序号")
	private Integer fyxh;
	@ApiModelProperty(value = "诊疗项目ID")
	private Integer zlxmId;

	public Timestamp getZxsj() {
		return zxsj;
	}

	public void setZxsj(Timestamp zxsj) {
		this.zxsj = zxsj;
	}

	public Integer getZxysdm() {
		return zxysdm;
	}

	public void setZxysdm(Integer zxysdm) {
		this.zxysdm = zxysdm;
	}

	public String getBrlx() {
		return brlx;
	}

	public void setBrlx(String brlx) {
		this.brlx = brlx;
	}

	public String getZyhm() {
		return zyhm;
	}

	public void setZyhm(String zyhm) {
		this.zyhm = zyhm;
	}

	public String getJzkh() {
		return jzkh;
	}

	public void setJzkh(String jzkh) {
		this.jzkh = jzkh;
	}

	public String getBrxm() {
		return brxm;
	}

	public void setBrxm(String brxm) {
		this.brxm = brxm;
	}

	public Integer getBrxb() {
		return brxb;
	}

	public void setBrxb(Integer brxb) {
		this.brxb = brxb;
	}

	public String getAges() {
		return ages;
	}

	public void setAges(String ages) {
		this.ages = ages;
	}

	public String getXmmc() {
		return xmmc;
	}

	public void setXmmc(String xmmc) {
		this.xmmc = xmmc;
	}

	public Integer getSqksdm() {
		return sqksdm;
	}

	public void setSqksdm(Integer sqksdm) {
		this.sqksdm = sqksdm;
	}

	public Integer getSqysdm() {
		return sqysdm;
	}

	public void setSqysdm(Integer sqysdm) {
		this.sqysdm = sqysdm;
	}

	public BigDecimal getSl() {
		return sl;
	}

	public void setSl(BigDecimal sl) {
		this.sl = sl;
	}

	public String getDw() {
		return dw;
	}

	public void setDw(String dw) {
		this.dw = dw;
	}

	public BigDecimal getYlje() {
		return ylje;
	}

	public void setYlje(BigDecimal ylje) {
		this.ylje = ylje;
	}

	public String getZxzt() {
		return zxzt;
	}

	public void setZxzt(String zxzt) {
		this.zxzt = zxzt;
	}

	public Timestamp getQxzxsj() {
		return qxzxsj;
	}

	public void setQxzxsj(Timestamp qxzxsj) {
		this.qxzxsj = qxzxsj;
	}

	public Integer getQxysdm() {
		return qxysdm;
	}

	public void setQxysdm(Integer qxysdm) {
		this.qxysdm = qxysdm;
	}

	public Timestamp getZfsj() {
		return zfsj;
	}

	public void setZfsj(Timestamp zfsj) {
		this.zfsj = zfsj;
	}

	public Integer getZfysdm() {
		return zfysdm;
	}

	public void setZfysdm(Integer zfysdm) {
		this.zfysdm = zfysdm;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	public Timestamp getCsny() {
		return csny;
	}

	public void setCsny(Timestamp csny) {
		this.csny = csny;
	}

	public Integer getZxxh() {
		return zxxh;
	}

	public void setZxxh(Integer zxxh) {
		this.zxxh = zxxh;
	}

	public Timestamp getSqsj() {
		return sqsj;
	}

	public void setSqsj(Timestamp sqsj) {
		this.sqsj = sqsj;
	}

	public Integer getFyxh() {
		return fyxh;
	}

	public void setFyxh(Integer fyxh) {
		this.fyxh = fyxh;
	}

	public Integer getZlxmId() {
		return zlxmId;
	}

	public void setZlxmId(Integer zlxmId) {
		this.zlxmId = zlxmId;
	}

}