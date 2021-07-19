package com.buit.his.sams.model;

import com.buit.commons.PageQuery;
import io.swagger.annotations.ApiModelProperty;

import java.math.BigDecimal;

/**
 * 类名称：SsMztfsqmx<br> 
 * 类描述：门诊退费申请明细表
 * @author zhouhaisheng
 * @ApiModel(value="门诊退费申请明细表")
 */
public class SsMztfsqmx  extends  PageQuery{
	@ApiModelProperty(value="主键id")
    private Integer jlxh;
	@ApiModelProperty(value="医疗机构id")
    private Integer jgid;
	@ApiModelProperty(value="手术科室代码")
    private Integer ssksdm;
	@ApiModelProperty(value="退费申请单号")
    private String tfsqdh;
	@ApiModelProperty(value="退费序号 ")
    private Integer xh;
	@ApiModelProperty(value="退费项目类别")
    private String tfxmlb;
	@ApiModelProperty(value="退费项目代码")
    private String tfxmdm;
	@ApiModelProperty(value="退费数量")
    private BigDecimal tfsl;
	@ApiModelProperty(value="单价")
    private BigDecimal dj;
	@ApiModelProperty(value="退费金额")
    private BigDecimal tfje;
	@ApiModelProperty(value="状态 0 未退款/1 已退款")
    private String zt;
	@ApiModelProperty(value="记账单号")
    private String jzdh;
	@ApiModelProperty(value="记账序号")
    private Integer jzxh;

    /** 设置:主键id  */
    public void setJlxh(Integer value) {
        this.jlxh = value;
    }
    /** 获取:主键id */
    public Integer getJlxh() {
        return jlxh;
    }

    /** 设置:医疗机构id  */
    public void setJgid(Integer value) {
        this.jgid = value;
    }
    /** 获取:医疗机构id */
    public Integer getJgid() {
        return jgid;
    }

    /** 设置:手术科室代码  */
    public void setSsksdm(Integer value) {
        this.ssksdm = value;
    }
    /** 获取:手术科室代码 */
    public Integer getSsksdm() {
        return ssksdm;
    }

    /** 设置:退费申请单号  */
    public void setTfsqdh(String value) {
        this.tfsqdh = value;
    }
    /** 获取:退费申请单号 */
    public String getTfsqdh() {
        return tfsqdh;
    }

    /** 设置:退费序号   */
    public void setXh(Integer value) {
        this.xh = value;
    }
    /** 获取:退费序号  */
    public Integer getXh() {
        return xh;
    }

    /** 设置:退费项目类别  */
    public void setTfxmlb(String value) {
        this.tfxmlb = value;
    }
    /** 获取:退费项目类别 */
    public String getTfxmlb() {
        return tfxmlb;
    }

    /** 设置:退费项目代码  */
    public void setTfxmdm(String value) {
        this.tfxmdm = value;
    }
    /** 获取:退费项目代码 */
    public String getTfxmdm() {
        return tfxmdm;
    }

    /** 设置:退费数量  */
    public void setTfsl(BigDecimal value) {
        this.tfsl = value;
    }
    /** 获取:退费数量 */
    public BigDecimal getTfsl() {
        return tfsl;
    }

    /** 设置:单价  */
    public void setDj(BigDecimal value) {
        this.dj = value;
    }
    /** 获取:单价 */
    public BigDecimal getDj() {
        return dj;
    }

    /** 设置:退费金额  */
    public void setTfje(BigDecimal value) {
        this.tfje = value;
    }
    /** 获取:退费金额 */
    public BigDecimal getTfje() {
        return tfje;
    }

    /** 设置:状态 0 未退款/1 已退款  */
    public void setZt(String value) {
        this.zt = value;
    }
    /** 获取:状态 0 未退款/1 已退款 */
    public String getZt() {
        return zt;
    }

    /** 设置:记账单号  */
    public void setJzdh(String value) {
        this.jzdh = value;
    }
    /** 获取:记账单号 */
    public String getJzdh() {
        return jzdh;
    }

    /** 设置:记账序号  */
    public void setJzxh(Integer value) {
        this.jzxh = value;
    }
    /** 获取:记账序号 */
    public Integer getJzxh() {
        return jzxh;
    }


}