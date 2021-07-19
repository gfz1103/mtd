
package com.buit.his.mtdms.request;

import java.sql.Date;
import java.sql.Timestamp;

import com.buit.commons.PageQuery;
import com.fasterxml.jackson.annotation.JsonIgnore;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * 类名称：QueryYjzxqrListReq<br>
 * 类描述：医技项目执行确认查询列表请求<br>
 * 
 * @author WY
 */
@ApiModel(value = "医技项目执行确认查询列表请求")
public class QueryYjzxqrListReq extends PageQuery {
	private static final long serialVersionUID = 1094765794265661557L;
	@ApiModelProperty(value = "执行开始时间")
	private Date beginDay;
	@ApiModelProperty(value = "执行结束时间")
	private Date endDay;
	@ApiModelProperty(value = "病人类型  1：门诊 2：住院  3:全部")
	private String brlx;
	@ApiModelProperty(value = "项目代码")
	private Integer fyxh;
	@ApiModelProperty(value = "执行人代码")
	private Integer zxysdm;
	@ApiModelProperty(value = "执行状态   1：已执行  2：作废  3：取消执行  4：全部")
	private String zxzt;
	@JsonIgnore
	@ApiModelProperty(value = "后台查询执行开始时间")
	private String beginOfDay;
	@JsonIgnore
	@ApiModelProperty(value = "后台查询执行结束时间")
	private String endOfDay;
	@JsonIgnore
	@ApiModelProperty(value = "执行时间")
	private Timestamp zxsj;
	@ApiModelProperty(value = "诊疗项目ID")
	private Integer zlxmId;
	@ApiModelProperty(value = "执行科室代码")
	private Integer ksdm;
	@ApiModelProperty(value = "病人姓名")
	private String brxm;
	@ApiModelProperty(value = "住院号码")
	private String zyhm;

	public String getBrlx() {
		return brlx;
	}

	public void setBrlx(String brlx) {
		this.brlx = brlx;
	}

	public Integer getFyxh() {
		return fyxh;
	}

	public void setFyxh(Integer fyxh) {
		this.fyxh = fyxh;
	}

	public Integer getZxysdm() {
		return zxysdm;
	}

	public void setZxysdm(Integer zxysdm) {
		this.zxysdm = zxysdm;
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

	public Date getBeginDay() {
		return beginDay;
	}

	public void setBeginDay(Date beginDay) {
		this.beginDay = beginDay;
	}

	public Date getEndDay() {
		return endDay;
	}

	public void setEndDay(Date endDay) {
		this.endDay = endDay;
	}

	public String getBeginOfDay() {
		return beginOfDay;
	}

	public void setBeginOfDay(String beginOfDay) {
		this.beginOfDay = beginOfDay;
	}

	public String getEndOfDay() {
		return endOfDay;
	}

	public void setEndOfDay(String endOfDay) {
		this.endOfDay = endOfDay;
	}

	public Timestamp getZxsj() {
		return zxsj;
	}

	public void setZxsj(Timestamp zxsj) {
		this.zxsj = zxsj;
	}

	public Integer getZlxmId() {
		return zlxmId;
	}

	public void setZlxmId(Integer zlxmId) {
		this.zlxmId = zlxmId;
	}

	public Integer getKsdm() {
		return ksdm;
	}

	public void setKsdm(Integer ksdm) {
		this.ksdm = ksdm;
	}

	public String getBrxm() {
		return brxm;
	}

	public void setBrxm(String brxm) {
		this.brxm = brxm;
	}

	public String getZyhm() {
		return zyhm;
	}

	public void setZyhm(String zyhm) {
		this.zyhm = zyhm;
	}
}