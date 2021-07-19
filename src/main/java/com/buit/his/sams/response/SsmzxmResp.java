package com.buit.his.sams.response;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.math.BigDecimal;
import java.sql.Timestamp;

/**
 * 手术麻醉项目统计出参
 * zhouhaisheng
 */
@ApiModel(value = "手术麻醉项目统计出参")
public class SsmzxmResp {
    @ApiModelProperty(value = "记账时间")
    private Timestamp jzrq;
    @ApiModelProperty(value = "病人类型 1：住院 2：门诊")
    private Integer brlx;
    @ApiModelProperty(value = "住院号码")
    private String zyhm;
    @ApiModelProperty(value = "病人姓名")
    private String brxm;
    @ApiModelProperty(value = "病人性别")
    private Integer brxb;
    @ApiModelProperty(value = "出生年月")
    private Timestamp csny;

    @ApiModelProperty(value = "年龄")
    private Integer age;
    @ApiModelProperty(value = "病人病区")
    private Integer brbq;
    @ApiModelProperty(value = "病人床号")
    private String brch;
    @ApiModelProperty(value = "病人科室")
    private Integer brks;
    @ApiModelProperty(value = "项目类型 1项目 2材料")
    private String sfxmlb;
    @ApiModelProperty(value = "收费项目代码")
    private String sfxmdm;
    @ApiModelProperty(value = "项目名称")
    private String sfxmmc;
    @ApiModelProperty(value = "产地")
    private String cd;
    @ApiModelProperty(value = "规格")
    private String spe;
    @ApiModelProperty(value = "数量")
    private Integer sl;
    @ApiModelProperty(value = "单位")
    private String dw;
    @ApiModelProperty(value = "金额")
    private BigDecimal je;
    @ApiModelProperty(value = "手术医生")
    private Integer ssys;
    @ApiModelProperty(value = "单价")
    private BigDecimal dj;


    public Timestamp getJzrq() {
        return jzrq;
    }

    public void setJzrq(Timestamp jzrq) {
        this.jzrq = jzrq;
    }

    public Integer getBrlx() {
        return brlx;
    }

    public void setBrlx(Integer brlx) {
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

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public Integer getBrbq() {
        return brbq;
    }

    public void setBrbq(Integer brbq) {
        this.brbq = brbq;
    }

    public String getBrch() {
        return brch;
    }

    public void setBrch(String brch) {
        this.brch = brch;
    }

    public Integer getBrks() {
        return brks;
    }

    public void setBrks(Integer brks) {
        this.brks = brks;
    }

    public String getSfxmlb() {
        return sfxmlb;
    }

    public void setSfxmlb(String sfxmlb) {
        this.sfxmlb = sfxmlb;
    }

    public String getSfxmdm() {
        return sfxmdm;
    }

    public void setSfxmdm(String sfxmdm) {
        this.sfxmdm = sfxmdm;
    }

    public String getSfxmmc() {
        return sfxmmc;
    }

    public void setSfxmmc(String sfxmmc) {
        this.sfxmmc = sfxmmc;
    }

    public String getCd() {
        return cd;
    }

    public void setCd(String cd) {
        this.cd = cd;
    }

    public String getSpe() {
        return spe;
    }

    public void setSpe(String spe) {
        this.spe = spe;
    }

    public Integer getSl() {
        return sl;
    }

    public void setSl(Integer sl) {
        this.sl = sl;
    }

    public String getDw() {
        return dw;
    }

    public void setDw(String dw) {
        this.dw = dw;
    }

    public BigDecimal getJe() {
        return je;
    }

    public void setJe(BigDecimal je) {
        this.je = je;
    }

    public Integer getSsys() {
        return ssys;
    }

    public void setSsys(Integer ssys) {
        this.ssys = ssys;
    }

    public Timestamp getCsny() {
        return csny;
    }

    public void setCsny(Timestamp csny) {
        this.csny = csny;
    }

    public BigDecimal getDj() {
        return dj;
    }

    public void setDj(BigDecimal dj) {
        this.dj = dj;
    }
}
