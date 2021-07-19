package com.buit.his.sams.response;

import com.buit.commons.PageQuery;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.math.BigDecimal;


/**
 * 类名称：SsZytfsqmx<br>
 * 类描述：住院退费申请明细表<br>
 *
 * @author zhouhaisheng
 */
@ApiModel(value = "住院退费申请明细表")
public class SsZytfsqmxResp extends PageQuery {
    @ApiModelProperty(value = "主键id")
    private Integer jlxh;
    @ApiModelProperty(value = "医疗机构id")
    private Integer jgid;
    @ApiModelProperty(value = "手术科室代码")
    private Integer ssksdm;
    @ApiModelProperty(value = "退费申请单号")
    private Integer tfsqdh;
    @ApiModelProperty(value = "退费序号")
    private Integer xh;
    @ApiModelProperty(value = "退费项目类别 | 1：材料 2：项目 3：药品")
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
    @ApiModelProperty(value = "记账序号")
    private Integer jzxh;
    @ApiModelProperty(value = "退费状态 0:已申请1:已退费")
    private String zt;
    @ApiModelProperty("药品产地")
    private Integer ypcd;
    @ApiModelProperty("产地名称")
    private String cdmc;
    @ApiModelProperty("药房规格")
    private String yfgg;
    @ApiModelProperty("药品类型")
    private Integer yplx;
    @ApiModelProperty(value = "单位")
    private String dw;
    @ApiModelProperty(value = "手术医生")
    private Integer ssys;

    public Integer getJlxh() {
        return jlxh;
    }

    public void setJlxh(Integer jlxh) {
        this.jlxh = jlxh;
    }

    public Integer getJgid() {
        return jgid;
    }

    public void setJgid(Integer jgid) {
        this.jgid = jgid;
    }

    public Integer getSsksdm() {
        return ssksdm;
    }

    public void setSsksdm(Integer ssksdm) {
        this.ssksdm = ssksdm;
    }

    public Integer getTfsqdh() {
        return tfsqdh;
    }

    public void setTfsqdh(Integer tfsqdh) {
        this.tfsqdh = tfsqdh;
    }

    public Integer getXh() {
        return xh;
    }

    public void setXh(Integer xh) {
        this.xh = xh;
    }

    public String getTfxmlb() {
        return tfxmlb;
    }

    public void setTfxmlb(String tfxmlb) {
        this.tfxmlb = tfxmlb;
    }

    public String getTfxmdm() {
        return tfxmdm;
    }

    public void setTfxmdm(String tfxmdm) {
        this.tfxmdm = tfxmdm;
    }

    public String getTfxmmc() {
        return tfxmmc;
    }

    public void setTfxmmc(String tfxmmc) {
        this.tfxmmc = tfxmmc;
    }

    public BigDecimal getTfsl() {
        return tfsl;
    }

    public void setTfsl(BigDecimal tfsl) {
        this.tfsl = tfsl;
    }

    public BigDecimal getDj() {
        return dj;
    }

    public void setDj(BigDecimal dj) {
        this.dj = dj;
    }

    public BigDecimal getTfje() {
        return tfje;
    }

    public void setTfje(BigDecimal tfje) {
        this.tfje = tfje;
    }

    public Integer getJzdh() {
        return jzdh;
    }

    public void setJzdh(Integer jzdh) {
        this.jzdh = jzdh;
    }

    public Integer getJzxh() {
        return jzxh;
    }

    public void setJzxh(Integer jzxh) {
        this.jzxh = jzxh;
    }

    public String getZt() {
        return zt;
    }

    public void setZt(String zt) {
        this.zt = zt;
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

    public Integer getYplx() {
        return yplx;
    }

    public void setYplx(Integer yplx) {
        this.yplx = yplx;
    }

    public String getDw() {
        return dw;
    }

    public void setDw(String dw) {
        this.dw = dw;
    }

    public Integer getSsys() {
        return ssys;
    }

    public void setSsys(Integer ssys) {
        this.ssys = ssys;
    }
}