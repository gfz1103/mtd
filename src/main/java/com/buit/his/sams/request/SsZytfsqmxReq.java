package com.buit.his.sams.request;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.math.BigDecimal;


/**
 * 类名称：SsZytfsqmx<br>
 * 类描述：住院退费申请明细表<br>
 * @author zhouhaisheng
 */
@ApiModel(value="住院退费申请明细表")
public class SsZytfsqmxReq{
    @ApiModelProperty(value="主键id")
    private Integer jlxh;
    @ApiModelProperty(value="医疗机构id",hidden = true)
    private Integer jgid;
    @ApiModelProperty(value = "手术科室代码")
    private Integer ssksdm;
    @ApiModelProperty(value = "退费申请单号")
    private Integer tfsqdh;
    @ApiModelProperty(value = "退费序号")
    private Integer xh;
    @ApiModelProperty(value = "退费项目类别")
    private String tfxmlb;
    @ApiModelProperty(value = "退费项目代码")
    private String tfxmdm;
    @ApiModelProperty(value = "退费项目名称")
    private String tfxmmc;
    @ApiModelProperty(value = "退费数量")
    private BigDecimal tfsl;
    @ApiModelProperty(value = "单价")
    private BigDecimal dj;
    @ApiModelProperty(value = "退费金额")
    private BigDecimal tfje;
    @ApiModelProperty(value = "记账单号")
    private Integer jzdh;
    @ApiModelProperty(value = "记账明细记录序号")
    private Integer jzxh;
    @ApiModelProperty(value = "退费状态 0:已申请1:已退费")
    private String zt;
    @ApiModelProperty("药品产地")
    private Integer ypcd;
    @ApiModelProperty("产地名称")
    private String cdmc;
    @ApiModelProperty("药房规格")
    private String yfgg;
    @ApiModelProperty("手术医生")
    private Integer ssys;
    /**
     * 设置:主键id
     */
    public void setJlxh(Integer value) {
        this.jlxh = value;
    }

    /**
     * 获取:主键id
     */
    public Integer getJlxh() {
        return jlxh;
    }
    /**
     * 设置:医疗机构id
     */
    public void setJgid(Integer value) {
        this.jgid = value;
    }
    /**
     * 获取:医疗机构id
     */
    public Integer getJgid() {
        return jgid;
    }
    /**
     * 设置:手术科室代码
     */
    public void setSsksdm(Integer value) {
        this.ssksdm = value;
    }
    /**
     * 获取:手术科室代码
     */
    public Integer getSsksdm() {
        return ssksdm;
    }
    /**
     * 设置:退费申请单号
     */
    public Integer getTfsqdh() {
        return tfsqdh;
    }

    public void setTfsqdh(Integer tfsqdh) {
        this.tfsqdh = tfsqdh;
    }

    /**
     * 设置:退费序号
     */
    public void setXh(Integer value) {
        this.xh = value;
    }
    /**
     * 获取:退费序号
     */
    public Integer getXh() {
        return xh;
    }
    /**
     * 设置:退费项目类别
     */
    public void setTfxmlb(String value) {
        this.tfxmlb = value;
    }
    /**
     * 获取:退费项目类别
     */
    public String getTfxmlb() {
        return tfxmlb;
    }
    /**
     * 设置:退费项目代码
     */
    public void setTfxmdm(String value) {
        this.tfxmdm = value;
    }
    /**
     * 获取:退费项目代码
     */
    public String getTfxmdm() {
        return tfxmdm;
    }
    /**
     * 设置:退费数量
     */
    public void setTfsl(BigDecimal value) {
        this.tfsl = value;
    }
    /**
     * 获取:退费数量
     */
    public BigDecimal getTfsl() {
        return tfsl;
    }
    /**
     * 设置:单价
     */
    public void setDj(BigDecimal value) {
        this.dj = value;
    }
    /**
     * 获取:单价
     */
    public BigDecimal getDj() {
        return dj;
    }
    /**
     * 设置:退费金额
     */
    public void setTfje(BigDecimal value) {
        this.tfje = value;
    }
    /**
     * 获取:退费金额
     */
    public BigDecimal getTfje() {
        return tfje;
    }
    /**
     * 设置:记账单号
     */
    public void setJzdh(Integer value) {
        this.jzdh = value;
    }
    /**
     * 获取:记账单号
     */
    public Integer getJzdh() {
        return jzdh;
    }
    /**
     * 设置:记账序号
     */
    public void setJzxh(Integer value) {
        this.jzxh = value;
    }
    /**
     * 获取:记账序号
     */
    public Integer getJzxh() {
        return jzxh;
    }

    public String getZt() {
        return zt;
    }

    public void setZt(String zt) {
        this.zt = zt;
    }

    public String getTfxmmc() {
        return tfxmmc;
    }

    public void setTfxmmc(String tfxmmc) {
        this.tfxmmc = tfxmmc;
    }

    public Integer getYpcd() {
        return ypcd;
    }

    public void setYpcd(Integer ypcd) {
        this.ypcd = ypcd;
    }

    public String getCdmc() {
        return cdmc;
    }

    public void setCdmc(String cdmc) {
        this.cdmc = cdmc;
    }

    public String getYfgg() {
        return yfgg;
    }

    public void setYfgg(String yfgg) {
        this.yfgg = yfgg;
    }

    public Integer getSsys() {
        return ssys;
    }

    public void setSsys(Integer ssys) {
        this.ssys = ssys;
    }
}