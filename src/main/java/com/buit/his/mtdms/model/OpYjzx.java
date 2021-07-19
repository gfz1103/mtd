package com.buit.his.mtdms.model;

import java.sql.Timestamp;
import java.util.Date;

import com.buit.commons.PageQuery;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * 类名称：OpYjzx<br>
 * 类描述：医技确费
 * 
 * @author WY
 * 
 */
@ApiModel(value = "医技确费")
public class OpYjzx extends PageQuery {
	// @ApiModelProperty(value="执行序号")
	/** 执行序号 */
	private Integer zxxh;
	// @ApiModelProperty(value="机构ID")
	/** 机构ID */
	private Integer jgid;
	// @ApiModelProperty(value="执行科室代码")
	/** 执行科室代码 */
	private Integer ksdm;
	// @ApiModelProperty(value="病人类型 1：门诊 2：住院")
	/** 病人类型 1：门诊 2：住院 */
	private String brlx;
	// @ApiModelProperty(value="病人ID")
	/** 病人ID */
	private Integer brid;
	// @ApiModelProperty(value="住院号码")
	/** 住院号码 */
	private String zyhm;
	// @ApiModelProperty(value="病区代码")
	/** 病区代码 */
	private Integer bqdm;
	// @ApiModelProperty(value="病人床号")
	/** 病人床号 */
	private String brch;
	// @ApiModelProperty(value="申请医生代码")
	/** 申请医生代码 */
	private Integer sqysdm;
	// @ApiModelProperty(value="申请时间")
	/** 申请时间 */
	private Date sqsj;
	// @ApiModelProperty(value="计划执行时间")
	/** 计划执行时间 */
	private Timestamp jhzxsj;
	// @ApiModelProperty(value="项目代码 根据是否组套 判断传非组套sbxh或者组套的sbxh")
	/** 项目代码 */
	private Integer xmdm;
	// @ApiModelProperty(value="数量")
	/** 数量 */
	private Integer sl;
	// @ApiModelProperty(value="单位")
	/** 单位 */
	private String dw;
	// @ApiModelProperty(value="状态 0：未执行 1：已执行 2：作废 3：已取消")
	/** 状态 0：未执行 1：已执行 2：作废 3：已取消 */
	private String zxzt;
	// @ApiModelProperty(value="执行医生代码")
	/** 执行医生代码 */
	private Integer zxysdm;
	// @ApiModelProperty(value="执行时间")
	/** 执行时间 */
	private Timestamp zxsj;
	// @ApiModelProperty(value="取消医生代码")
	/** 取消医生代码 */
	private Integer qxysdm;
	// @ApiModelProperty(value="取消执行时间")
	/** 取消执行时间 */
	private Timestamp qxzxsj;
	// @ApiModelProperty(value="作废医生代码")
	/** 作废医生代码 */
	private Integer zfysdm;
	// @ApiModelProperty(value="作废时间")
	/** 作废时间 */
	private Timestamp zfsj;
	@ApiModelProperty(value = "预约日期")
	private java.sql.Date yyrq;
	@ApiModelProperty(value = "预约序号")
	private Integer yyxh;
	@ApiModelProperty(value = "预约序号")
	private Integer yyzt;
	@ApiModelProperty(value = "项目名称")
	private String xmmc;
	@ApiModelProperty(value = "组套标志：0：非组套  1：组套")
	private Integer ztbz;
	@ApiModelProperty(value = "费用序号")
	private Integer fyxh;
	@ApiModelProperty(value = "就诊卡号")
	private String jzkh;
	@ApiModelProperty(value = "申请科室代码")
	private Integer sqksdm;
	@ApiModelProperty(value = "诊疗项目ID")
	private Integer zlxmId;

	/** 设置:执行序号 */
	public void setZxxh(Integer value) {
		this.zxxh = value;
	}

	/** 获取:执行序号 */
	public Integer getZxxh() {
		return zxxh;
	}

	/** 设置:机构ID */
	public void setJgid(Integer value) {
		this.jgid = value;
	}

	/** 获取:机构ID */
	public Integer getJgid() {
		return jgid;
	}

	/** 设置:执行科室代码 */
	public void setKsdm(Integer value) {
		this.ksdm = value;
	}

	/** 获取:执行科室代码 */
	public Integer getKsdm() {
		return ksdm;
	}

	/** 设置:病人类型 1：门诊 2：住院 */
	public void setBrlx(String value) {
		this.brlx = value;
	}

	/** 获取:病人类型 1：门诊 2：住院 */
	public String getBrlx() {
		return brlx;
	}

	/** 设置:病人ID */
	public void setBrid(Integer value) {
		this.brid = value;
	}

	/** 获取:病人ID */
	public Integer getBrid() {
		return brid;
	}

	/** 设置:住院号码 */
	public void setZyhm(String value) {
		this.zyhm = value;
	}

	/** 获取:住院号码 */
	public String getZyhm() {
		return zyhm;
	}

	/** 设置:病区代码 */
	public void setBqdm(Integer value) {
		this.bqdm = value;
	}

	/** 获取:病区代码 */
	public Integer getBqdm() {
		return bqdm;
	}

	/** 设置:病人床号 */
	public void setBrch(String value) {
		this.brch = value;
	}

	/** 获取:病人床号 */
	public String getBrch() {
		return brch;
	}

	/** 设置:申请医生代码 */
	public void setSqysdm(Integer value) {
		this.sqysdm = value;
	}

	/** 获取:申请医生代码 */
	public Integer getSqysdm() {
		return sqysdm;
	}

	public Date getSqsj() {
		return sqsj;
	}

	public void setSqsj(Date sqsj) {
		this.sqsj = sqsj;
	}

	/** 设置:计划执行时间 */
	public void setJhzxsj(Timestamp value) {
		this.jhzxsj = value;
	}

	/** 获取:计划执行时间 */
	public Timestamp getJhzxsj() {
		return jhzxsj;
	}

	/** 设置:项目代码 */
	public void setXmdm(Integer value) {
		this.xmdm = value;
	}

	/** 获取:项目代码 */
	public Integer getXmdm() {
		return xmdm;
	}

	/** 设置:数量 */
	public void setSl(Integer value) {
		this.sl = value;
	}

	/** 获取:数量 */
	public Integer getSl() {
		return sl;
	}

	/** 设置:单位 */
	public void setDw(String value) {
		this.dw = value;
	}

	/** 获取:单位 */
	public String getDw() {
		return dw;
	}

	public String getZxzt() {
		return zxzt;
	}

	public void setZxzt(String zxzt) {
		this.zxzt = zxzt;
	}

	/** 设置:执行医生代码 */
	public void setZxysdm(Integer value) {
		this.zxysdm = value;
	}

	/** 获取:执行医生代码 */
	public Integer getZxysdm() {
		return zxysdm;
	}

	/** 设置:执行时间 */
	public void setZxsj(Timestamp value) {
		this.zxsj = value;
	}

	/** 获取:执行时间 */
	public Timestamp getZxsj() {
		return zxsj;
	}

	/** 设置:取消医生代码 */
	public void setQxysdm(Integer value) {
		this.qxysdm = value;
	}

	/** 获取:取消医生代码 */
	public Integer getQxysdm() {
		return qxysdm;
	}

	/** 设置:取消执行时间 */
	public void setQxzxsj(Timestamp value) {
		this.qxzxsj = value;
	}

	/** 获取:取消执行时间 */
	public Timestamp getQxzxsj() {
		return qxzxsj;
	}

	/** 设置:作废医生代码 */
	public void setZfysdm(Integer value) {
		this.zfysdm = value;
	}

	/** 获取:作废医生代码 */
	public Integer getZfysdm() {
		return zfysdm;
	}

	/** 设置:作废时间 */
	public void setZfsj(Timestamp value) {
		this.zfsj = value;
	}

	/** 获取:作废时间 */
	public Timestamp getZfsj() {
		return zfsj;
	}

	public String getXmmc() {
		return xmmc;
	}

	public void setXmmc(String xmmc) {
		this.xmmc = xmmc;
	}

	public Integer getZtbz() {
		return ztbz;
	}

	public void setZtbz(Integer ztbz) {
		this.ztbz = ztbz;
	}

	public java.sql.Date getYyrq() {
		return yyrq;
	}

	public void setYyrq(java.sql.Date yyrq) {
		this.yyrq = yyrq;
	}

	public Integer getYyxh() {
		return yyxh;
	}

	public void setYyxh(Integer yyxh) {
		this.yyxh = yyxh;
	}

	public Integer getYyzt() {
		return yyzt;
	}

	public void setYyzt(Integer yyzt) {
		this.yyzt = yyzt;
	}

	public Integer getFyxh() {
		return fyxh;
	}

	public void setFyxh(Integer fyxh) {
		this.fyxh = fyxh;
	}

	public String getJzkh() {
		return jzkh;
	}

	public void setJzkh(String jzkh) {
		this.jzkh = jzkh;
	}

	public Integer getSqksdm() {
		return sqksdm;
	}

	public void setSqksdm(Integer sqksdm) {
		this.sqksdm = sqksdm;
	}

	public Integer getZlxmId() {
		return zlxmId;
	}

	public void setZlxmId(Integer zlxmId) {
		this.zlxmId = zlxmId;
	}
	
	

}