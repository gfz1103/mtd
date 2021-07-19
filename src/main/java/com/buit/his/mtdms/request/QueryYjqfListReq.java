
package com.buit.his.mtdms.request;

import com.buit.commons.PageQuery;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * 类名称：QueryYjqfListReq<br>
 * 类描述：医技确费查询列表请求<br>
 * 
 * @author WY
 */
@ApiModel(value = "医技确费查询列表请求")
public class QueryYjqfListReq extends PageQuery {
	private static final long serialVersionUID = 1094765794265661557L;
	@ApiModelProperty(value = "病人类型  1：门诊 2：住院  3:全部")
	private String brlx;
	@ApiModelProperty(value = "就诊卡号")
	private String jzkh;
	@ApiModelProperty(value = "住院号码")
	private String zyhm;
	@ApiModelProperty(value = "病人姓名")
	private String brxm;
	@ApiModelProperty(value = "预约状态   2：全部  0：未预约  1：已预约")
	private String yyzt;
	@ApiModelProperty(value = "执行状态  0：未执行  1：部分执行/已执行  2：作废  3：取消执行  4：全部")
	private String zxzt;
	@ApiModelProperty(hidden = true)
	private String yjzxzt;
	@ApiModelProperty(value = "当前执行科室")
	private Integer ksdm;
	@ApiModelProperty(value = "申请时间开始  yyyy-MM-dd")
	private String sqsjks;
	@ApiModelProperty(value = "申请时间结束  yyyy-MM-dd")
	private String sqsjjs;
	@ApiModelProperty(value = "预约时间开始  yyyy-MM-dd")
	private String yysjks;
	@ApiModelProperty(value = "预约时间结束  yyyy-MM-dd")
	private String yysjjs;
	@ApiModelProperty(value = "执行时间开始  yyyy-MM-dd")
	private String zxsjks;
	@ApiModelProperty(value = "执行时间结束  yyyy-MM-dd")
	private String zxsjjs;
	@ApiModelProperty(value = "作废时间开始  yyyy-MM-dd")
	private String zfsjks;
	@ApiModelProperty(value = "作废时间结束  yyyy-MM-dd")
	private String zfsjjs;
	@ApiModelProperty(value = "取消执行时间结束  yyyy-MM-dd")
	private String qxzxsjks;
	@ApiModelProperty(value = "取消执行时间结束  yyyy-MM-dd")
	private String qxzxsjjs;

	public String getQxzxsjks() {
		return qxzxsjks;
	}

	public void setQxzxsjks(String qxzxsjks) {
		this.qxzxsjks = qxzxsjks;
	}

	public String getQxzxsjjs() {
		return qxzxsjjs;
	}

	public void setQxzxsjjs(String qxzxsjjs) {
		this.qxzxsjjs = qxzxsjjs;
	}

	public String getZfsjks() {
		return zfsjks;
	}

	public void setZfsjks(String zfsjks) {
		this.zfsjks = zfsjks;
	}

	public String getZfsjjs() {
		return zfsjjs;
	}

	public void setZfsjjs(String zfsjjs) {
		this.zfsjjs = zfsjjs;
	}

	public static long getSerialVersionUID() {
		return serialVersionUID;
	}

	public String getSqsjks() {
		return sqsjks;
	}

	public void setSqsjks(String sqsjks) {
		this.sqsjks = sqsjks;
	}

	public String getSqsjjs() {
		return sqsjjs;
	}

	public void setSqsjjs(String sqsjjs) {
		this.sqsjjs = sqsjjs;
	}

	public String getYysjks() {
		return yysjks;
	}

	public void setYysjks(String yysjks) {
		this.yysjks = yysjks;
	}

	public String getYysjjs() {
		return yysjjs;
	}

	public void setYysjjs(String yysjjs) {
		this.yysjjs = yysjjs;
	}

	public String getZxsjks() {
		return zxsjks;
	}

	public void setZxsjks(String zxsjks) {
		this.zxsjks = zxsjks;
	}

	public String getZxsjjs() {
		return zxsjjs;
	}

	public void setZxsjjs(String zxsjjs) {
		this.zxsjjs = zxsjjs;
	}

	public String getBrlx() {
		return brlx;
	}

	public String getYjzxzt() {
		return yjzxzt;
	}

	public void setYjzxzt(String yjzxzt) {
		this.yjzxzt = yjzxzt;
	}

	public void setBrlx(String brlx) {
		this.brlx = brlx;
	}

	public String getJzkh() {
		return jzkh;
	}

	public void setJzkh(String jzkh) {
		this.jzkh = jzkh;
	}

	public String getZyhm() {
		return zyhm;
	}

	public void setZyhm(String zyhm) {
		this.zyhm = zyhm;
	}

	public String getBrxm() {
		return brxm;
	}

	public void setBrxm(String brxm) {
		this.brxm = brxm;
	}

	public String getYyzt() {
		return yyzt;
	}

	public void setYyzt(String yyzt) {
		this.yyzt = yyzt;
	}

	public String getZxzt() {
		return zxzt;
	}

	public void setZxzt(String zxzt) {
		this.zxzt = zxzt;
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

}