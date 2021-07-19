package com.buit.his.sams.response;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.math.BigDecimal;
import java.sql.Timestamp;

/**
 * 手术室收入统计出参
 * zhouhaisheng
 */
@ApiModel(value = "手术室收入统计出参")
public class SsssrtjResp {
    @ApiModelProperty(value = "主键id")
    private Integer jlxh;
    @ApiModelProperty(value = "记账单号")
    private Integer jzdh;
    @ApiModelProperty(value = "手术科室代码")
    private Integer ssksdm;

    @ApiModelProperty(value = "记账时间")
    private Timestamp jzsj;
    @ApiModelProperty(value = "病人类型 1：门诊 2：住院")
    private Integer brlx;
    @ApiModelProperty(value = "住院号")
    private Integer zyh;
    @ApiModelProperty(value = "住院号码")
    private String zyhm;
    @ApiModelProperty(value = "门诊号码")
    private String mzhm;
    @ApiModelProperty(value = "病人姓名")
    private String brxm;
    @ApiModelProperty(value = "病人性别")
    private Integer brxb;
    @ApiModelProperty(value = "年龄")
    private Integer age;
    @ApiModelProperty(value = "病人病区")
    private Integer brbq;
    @ApiModelProperty(value = "病人床号")
    private String brch;
    @ApiModelProperty(value = "病人科室")
    private Integer brks;
    @ApiModelProperty(value = "记账总金额")
    private BigDecimal jzzje;
    @ApiModelProperty(value = "手术医生")
    private Integer ssys;
    @ApiModelProperty(value = "记账类型 1:手术记账 2：麻醉记账")
    private Integer jzlx;
    @ApiModelProperty(value = "记账人")
    private Integer jzr;
    @ApiModelProperty(value = "记账状态 | 0：未记账    1：已记账    2：已审核")
    private Integer jzzt;
    @ApiModelProperty(value = "手术记账状态 | 0：未记账    1：已记账    2：已审核")
    private Integer ssjzzt;
    @ApiModelProperty(value = "麻醉记账状态 | 0：未记账    1：已记账    2：已审核")
    private Integer mzjzzt;
    @ApiModelProperty(value = "出生年月", hidden = true)
    private Timestamp csny;

    public Timestamp getJzsj() {
        return jzsj;
    }

    public void setJzsj(Timestamp jzsj) {
        this.jzsj = jzsj;
    }

    public Integer getBrlx() {
        return brlx;
    }

    public void setBrlx(Integer brlx) {
        this.brlx = brlx;
    }

    public Integer getZyh() {
        return zyh;
    }

    public void setZyh(Integer zyh) {
        this.zyh = zyh;
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

    public BigDecimal getJzzje() {
        return jzzje;
    }

    public void setJzzje(BigDecimal jzzje) {
        this.jzzje = jzzje;
    }

    public Integer getSsys() {
        return ssys;
    }

    public void setSsys(Integer ssys) {
        this.ssys = ssys;
    }

    public Integer getJzlx() {
        return jzlx;
    }

    public void setJzlx(Integer jzlx) {
        this.jzlx = jzlx;
    }

    public Integer getJzr() {
        return jzr;
    }

    public void setJzr(Integer jzr) {
        this.jzr = jzr;
    }

    public Integer getJzzt() {
        return jzzt;
    }

    public void setJzzt(Integer jzzt) {
        this.jzzt = jzzt;
    }

    public Integer getJlxh() {
        return jlxh;
    }

    public void setJlxh(Integer jlxh) {
        this.jlxh = jlxh;
    }

    public Integer getSsksdm() {
        return ssksdm;
    }

    public void setSsksdm(Integer ssksdm) {
        this.ssksdm = ssksdm;
    }

    public Timestamp getCsny() {
        return csny;
    }

    public void setCsny(Timestamp csny) {
        this.csny = csny;
    }

    public Integer getJzdh() {
        return jzdh;
    }

    public void setJzdh(Integer jzdh) {
        this.jzdh = jzdh;
    }

    public String getMzhm() {
        return mzhm;
    }

    public void setMzhm(String mzhm) {
        this.mzhm = mzhm;
    }

    public Integer getSsjzzt() {
        return ssjzzt;
    }

    public void setSsjzzt(Integer ssjzzt) {
        this.ssjzzt = ssjzzt;
    }

    public Integer getMzjzzt() {
        return mzjzzt;
    }

    public void setMzjzzt(Integer mzjzzt) {
        this.mzjzzt = mzjzzt;
    }
}
