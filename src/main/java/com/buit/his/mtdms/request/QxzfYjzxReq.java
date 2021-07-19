
package com.buit.his.mtdms.request;

import com.buit.commons.PageQuery;
import com.fasterxml.jackson.annotation.JsonIgnore;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.util.Date;

@ApiModel(value = "医技确费取消作废请求")
public class QxzfYjzxReq extends PageQuery {
	private static final long serialVersionUID = 1094765794265661557L;
	@ApiModelProperty(value = "zxxh")
	private Integer zxxh;
	@JsonIgnore
	@ApiModelProperty(value = "机构ID")
	private Integer jgid;
	@ApiModelProperty(value = "病人类型  1：门诊 2：住院")
	private String brlx;
	@ApiModelProperty(value = "病人ID")
	private Integer brid;
	@ApiModelProperty(value = "执行科室代码")
	private Integer ksdm;
	@ApiModelProperty(value = "住院号码")
	private String zyhm;
	@ApiModelProperty(value = "病区代码  sys_dict_config:47")
	private Integer bqdm;
	@ApiModelProperty(value = "病人床号")
	private String brch;
	@ApiModelProperty(value = "申请科室代码")
	private Integer sqksdm;
	@ApiModelProperty(value = "申请医生代码")
	private Integer sqysdm;
	@ApiModelProperty(value = "申请时间")
	private Date sqsj;
	@ApiModelProperty(value = "费用序号")
	private Integer fyxh;
	@ApiModelProperty(value = "项目代码 非组套：门诊/住院 存放op_yjcf02中的sbxh /cis_hzyz中的jlxh 组套：门诊/住院 存放op_yjcf02中的ZTYZSBXH /cis_hzyz中的ZTYZJLXH")
	private Integer xmdm;
	@ApiModelProperty(value = "项目名称")
	private String xmmc;
	@ApiModelProperty(value = "数量")
	private double sl;
	@ApiModelProperty(value = "执行医生代码")
	private Integer zxysdm;
	@ApiModelProperty(value = "取消医生代码")
	private Integer qxysdm;
	@ApiModelProperty(value = "作废医生代码")
	private Integer zfysdm;
	@ApiModelProperty(value = "预约日期")
	private java.sql.Date yyrq;
	@ApiModelProperty(value = "预约序号")
	private Integer yyxh;
	@ApiModelProperty(value = "预约序号")
	private Integer yyzt;
	@ApiModelProperty(value = "组套标志：0：非组套  1：组套")
	private Integer ztbz;
	@ApiModelProperty(value = "就诊卡号")
	private String jzkh;
	@ApiModelProperty(value = "诊疗项目ID")
	private Integer zlxmId;

	public Integer getZxxh() {
		return zxxh;
	}

	public void setZxxh(Integer zxxh) {
		this.zxxh = zxxh;
	}

	public String getBrlx() {
		return brlx;
	}

	public void setBrlx(String brlx) {
		this.brlx = brlx;
	}

	public Integer getBrid() {
		return brid;
	}

	public void setBrid(Integer brid) {
		this.brid = brid;
	}

	public String getZyhm() {
		return zyhm;
	}

	public void setZyhm(String zyhm) {
		this.zyhm = zyhm;
	}

	public Integer getBqdm() {
		return bqdm;
	}

	public void setBqdm(Integer bqdm) {
		this.bqdm = bqdm;
	}

	public String getBrch() {
		return brch;
	}

	public void setBrch(String brch) {
		this.brch = brch;
	}

	public Integer getSqysdm() {
		return sqysdm;
	}

	public void setSqysdm(Integer sqysdm) {
		this.sqysdm = sqysdm;
	}

	public Date getSqsj() {
		return sqsj;
	}

	public void setSqsj(Date sqsj) {
		this.sqsj = sqsj;
	}

	public Integer getXmdm() {
		return xmdm;
	}

	public void setXmdm(Integer xmdm) {
		this.xmdm = xmdm;
	}

	public String getXmmc() {
		return xmmc;
	}

	public void setXmmc(String xmmc) {
		this.xmmc = xmmc;
	}

	public double getSl() {
		return sl;
	}

	public void setSl(double sl) {
		this.sl = sl;
	}

	public Integer getZxysdm() {
		return zxysdm;
	}

	public void setZxysdm(Integer zxysdm) {
		this.zxysdm = zxysdm;
	}

	public Integer getQxysdm() {
		return qxysdm;
	}

	public void setQxysdm(Integer qxysdm) {
		this.qxysdm = qxysdm;
	}

	public Integer getZfysdm() {
		return zfysdm;
	}

	public void setZfysdm(Integer zfysdm) {
		this.zfysdm = zfysdm;
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

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	public Integer getKsdm() {
		return ksdm;
	}

	public void setKsdm(Integer ksdm) {
		this.ksdm = ksdm;
	}

	public Integer getZtbz() {
		return ztbz;
	}

	public void setZtbz(Integer ztbz) {
		this.ztbz = ztbz;
	}

	public Integer getJgid() {
		return jgid;
	}

	public void setJgid(Integer jgid) {
		this.jgid = jgid;
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