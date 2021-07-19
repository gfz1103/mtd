
package com.buit.his.mtdms.response;

import java.sql.Date;
import java.sql.Timestamp;

import com.buit.commons.PageQuery;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * 类名称：QueryYjqfListResp<br>
 * 类描述：医技确费查询列表返回<br>
 * 
 * @author WY
 */
@ApiModel(value = "医技确费查询列表返回")
public class QueryYjqfListResp extends PageQuery {
	private static final long serialVersionUID = 1094765794265661557L;
	@ApiModelProperty(value = "病人类型  1：门诊 2：住院")
	private String brlx;
	@ApiModelProperty(value = "住院号码")
	private String zyhm;
	@ApiModelProperty(value = "病人ID")
	private Integer brid;
	@ApiModelProperty(value = "病人姓名")
	private String brxm;
	@ApiModelProperty(value = "病人性别")
	private Integer brxb;
	@ApiModelProperty(value = "年龄")
	private String age;
	@ApiModelProperty(value = "出生年月")
	private Timestamp csny;
	@ApiModelProperty(value = "病区代码")
	private Integer bqdm;
	@ApiModelProperty(value = "执行科室代码")
	private Integer ksdm;
	@ApiModelProperty(value = "就诊卡号")
	private String jzkh;
	@ApiModelProperty(value = "病人床号")
	private String brch;
	@ApiModelProperty(value = "费用序号 处置项目标识")
	private Integer fyxh;
	@ApiModelProperty(value = "项目代码")
	private Integer xmdm;
	@ApiModelProperty(value = "项目名称")
	private String xmmc;
	@ApiModelProperty(value = "申请医生代码")
	private Integer sqysdm;
	@ApiModelProperty(value = "预约序号")
	private Integer yyxh;
	@ApiModelProperty(value = "预约状态")
	private Integer yyzt;
	@ApiModelProperty(value = "执行医生代码")
	private Integer zxysdm;
	@ApiModelProperty(value = "申请时间")
	private Timestamp sqsj;
	@ApiModelProperty(value = "预约日期")
	private Date yyrq;
	@ApiModelProperty(value = "执行时间")
	private Timestamp zxsj;
	@ApiModelProperty(value = "取消执行时间")
	private Timestamp qxzxsj;
	@ApiModelProperty(value = "作废时间")
	private Timestamp zfsj;
	@ApiModelProperty(value = "状态 0：未执行  1：部分执行/已执行(确费表需要，相当于状态1)  2：作废(确费表需要)  3:取消执行(确费表需要) 5：全部执行")
	private String zxzt;
	@ApiModelProperty(value = "组套标志：0：非组套  1：组套")
	private Integer ztbz;
	@ApiModelProperty(value = "组套医嘱识别序号")
	private Integer ztyzsbxh;
	@ApiModelProperty(value = "识别序号")
	private Integer sbxh;
	@ApiModelProperty(value = "执行序号")
	private String zxxh;
	@ApiModelProperty(value = "申请科室代码")
	private Integer sqksdm;
	@ApiModelProperty(value = "诊疗项目ID 检查组套项目标识")
	private Integer zlxmId;

	public Timestamp getQxzxsj() {
		return qxzxsj;
	}

	public void setQxzxsj(Timestamp qxzxsj) {
		this.qxzxsj = qxzxsj;
	}

	public Timestamp getZfsj() {
		return zfsj;
	}

	public void setZfsj(Timestamp zfsj) {
		this.zfsj = zfsj;
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

	public String getAge() {
		return age;
	}

	public void setAge(String age) {
		this.age = age;
	}

	public Integer getBqdm() {
		return bqdm;
	}

	public void setBqdm(Integer bqdm) {
		this.bqdm = bqdm;
	}

	public Integer getKsdm() {
		return ksdm;
	}

	public void setKsdm(Integer ksdm) {
		this.ksdm = ksdm;
	}

	public String getBrch() {
		return brch;
	}

	public void setBrch(String brch) {
		this.brch = brch;
	}

	public String getXmmc() {
		return xmmc;
	}

	public void setXmmc(String xmmc) {
		this.xmmc = xmmc;
	}

	public Integer getSqysdm() {
		return sqysdm;
	}

	public void setSqysdm(Integer sqysdm) {
		this.sqysdm = sqysdm;
	}

	public Timestamp getSqsj() {
		return sqsj;
	}

	public void setSqsj(Timestamp sqsj) {
		this.sqsj = sqsj;
	}

	public Date getYyrq() {
		return yyrq;
	}

	public void setYyrq(Date yyrq) {
		this.yyrq = yyrq;
	}

	public Integer getYyxh() {
		return yyxh;
	}

	public void setYyxh(Integer yyxh) {
		this.yyxh = yyxh;
	}

	public Integer getZxysdm() {
		return zxysdm;
	}

	public void setZxysdm(Integer zxysdm) {
		this.zxysdm = zxysdm;
	}

	public Timestamp getZxsj() {
		return zxsj;
	}

	public void setZxsj(Timestamp zxsj) {
		this.zxsj = zxsj;
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

	public Integer getZtbz() {
		return ztbz;
	}

	public void setZtbz(Integer ztbz) {
		this.ztbz = ztbz;
	}

	public Integer getZtyzsbxh() {
		return ztyzsbxh;
	}

	public void setZtyzsbxh(Integer ztyzsbxh) {
		this.ztyzsbxh = ztyzsbxh;
	}

	public Integer getSbxh() {
		return sbxh;
	}

	public void setSbxh(Integer sbxh) {
		this.sbxh = sbxh;
	}

	public Timestamp getCsny() {
		return csny;
	}

	public void setCsny(Timestamp csny) {
		this.csny = csny;
	}

	public String getZxxh() {
		return zxxh;
	}

	public void setZxxh(String zxxh) {
		this.zxxh = zxxh;
	}

	public Integer getBrid() {
		return brid;
	}

	public void setBrid(Integer brid) {
		this.brid = brid;
	}

	public Integer getXmdm() {
		return xmdm;
	}

	public void setXmdm(Integer xmdm) {
		this.xmdm = xmdm;
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

	public Integer getYyzt() {
		return yyzt;
	}

	public void setYyzt(Integer yyzt) {
		this.yyzt = yyzt;
	}

	public Integer getZlxmId() {
		return zlxmId;
	}

	public void setZlxmId(Integer zlxmId) {
		this.zlxmId = zlxmId;
	}

}