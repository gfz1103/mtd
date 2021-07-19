package com.buit.his.sams.response;

import com.buit.commons.PageQuery;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.math.BigDecimal;


/**
 * 类名称：SsSsjzdmx<br>
 * 类描述：手术记账单明细表<br>
 * @author zhouhaisheng
 */
@ApiModel(value="手术记账单明细表")
public class SsSsjzdmxResp  extends  PageQuery{
    @ApiModelProperty(value="主键id")
    private Integer jlxh;
    @ApiModelProperty(value="医疗机构id ")
    private Integer jgid;
    @ApiModelProperty(value="手术科室代码")
    private Integer ssksdm;
    @ApiModelProperty(value="记账单号")
    private String jzdh;
    @ApiModelProperty(value="序号")
    private Integer xh;
    @ApiModelProperty(value="收费项目类别")
    private String sfxmlb;
    @ApiModelProperty(value = "收费项目代码")
    private String sfxmdm;
    @ApiModelProperty(value = "数量 ")
    private BigDecimal sl;
    @ApiModelProperty(value = "单价")
    private BigDecimal dj;
    @ApiModelProperty(value = "金额")
    private BigDecimal je;
    @ApiModelProperty(value = "退费状态 | 0：正常记账    1：退费记账")
    private String zt;
    @ApiModelProperty(value = "记账明细记录序号")
    private Integer jzJlxh;
    @ApiModelProperty(value = "收费项目名称")
    private String sfxmmc;
    @ApiModelProperty(value = "单位")
    private String dw;
    @ApiModelProperty(value = "手术医生名称")
    private String ssysmc;
    @ApiModelProperty(value = "手术医生id")
    private Integer ssys;
    @ApiModelProperty("药品产地")
    private Integer ypcd;
    @ApiModelProperty("产地名称")
    private String cdmc;
    @ApiModelProperty("药房规格")
    private String yfgg;

    public String getSsysmc() {
        return ssysmc;
    }

    public void setSsysmc(String ssysmc) {
        this.ssysmc = ssysmc;
    }

    public Integer getSsys() {
        return ssys;
    }

    public void setSsys(Integer ssys) {
        this.ssys = ssys;
    }

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
     * 设置:记账单号
     */
    public void setJzdh(String value) {
        this.jzdh = value;
    }
    /**
     * 获取:记账单号
     */
    public String getJzdh() {
        return jzdh;
    }
    /**
     * 设置:序号
     */
    public void setXh(Integer value) {
        this.xh = value;
    }
    /**
     * 获取:序号
     */
    public Integer getXh() {
        return xh;
    }
    /**
     * 设置:收费项目类别
     */
    public void setSfxmlb(String value) {
        this.sfxmlb = value;
    }
    /**
     * 获取:收费项目类别
     */
    public String getSfxmlb() {
        return sfxmlb;
    }
    /**
     * 设置:收费项目代码
     */
    public void setSfxmdm(String value) {
        this.sfxmdm = value;
    }
    /**
     * 获取:收费项目代码
     */
    public String getSfxmdm() {
        return sfxmdm;
    }
    /**
     * 设置:数量 
     */
    public void setSl(BigDecimal value) {
        this.sl = value;
    }
    /**
     * 获取:数量 
     */
    public BigDecimal getSl() {
        return sl;
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
     * 设置:金额
     */
    public void setJe(BigDecimal value) {
        this.je = value;
    }
    /**
     * 获取:金额
     */
    public BigDecimal getJe() {
        return je;
    }
    /**
     * 设置:状态 0 未记账/1 已记账
     */
    public void setZt(String value) {
        this.zt = value;
    }
    /**
     * 获取:状态 0 未记账/1 已记账
     */
    public String getZt() {
        return zt;
    }

    public String getSfxmmc() {
        return sfxmmc;
    }

    public void setSfxmmc(String sfxmmc) {
        this.sfxmmc = sfxmmc;
    }

    public String getDw() {
        return dw;
    }

    public void setDw(String dw) {
        this.dw = dw;
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

    public Integer getJzJlxh() {
        return jzJlxh;
    }

    public void setJzJlxh(Integer jzJlxh) {
        this.jzJlxh = jzJlxh;
    }
}