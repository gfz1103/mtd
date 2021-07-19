package com.buit.his.sams.response;

import com.buit.commons.PageQuery;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.math.BigDecimal;
import java.sql.Timestamp;

/**
 * 手术记账病人分页查询出参
 * zhouhaisheng
 */
@ApiModel(value = "手术记账病人分页查询出参")
public class QuerySsjzPageResp extends PageQuery {
    @ApiModelProperty("主键id")
    private Integer jlxh;
    @ApiModelProperty("记账时间")
    private Timestamp jzsj;
    @ApiModelProperty("记账类型 1:手术 2:麻醉")
    private Integer jzlx;
    @ApiModelProperty("记账单号")
    private Integer jzdh;
    @ApiModelProperty("申请单号")
    private Integer sqdh;
    @ApiModelProperty("病人病区")
    private Integer brbq;
    @ApiModelProperty("病人床号")
    private String brch;
    @ApiModelProperty("病人科室")
    private Integer brks;
    @ApiModelProperty("住院号码")
    private String zyhm;
    @ApiModelProperty("病人姓名")
    private String brxm;
    @ApiModelProperty("病人性别")
    private Integer brxb;
    @ApiModelProperty("年龄")
    private int age;
    @ApiModelProperty(value = "出生年月", hidden = true)
    private Timestamp csny;
    @ApiModelProperty("记账金额")
    private BigDecimal jzje;
    @ApiModelProperty("手术医生")
    private Integer ssys;
    @ApiModelProperty("记账人")
    private Integer jzrdm;

    public Integer getJlxh() {
        return jlxh;
    }

    public void setJlxh(Integer jlxh) {
        this.jlxh = jlxh;
    }

    public Timestamp getJzsj() {
        return jzsj;
    }

    public void setJzsj(Timestamp jzsj) {
        this.jzsj = jzsj;
    }

    public Integer getJzlx() {
        return jzlx;
    }

    public void setJzlx(Integer jzlx) {
        this.jzlx = jzlx;
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

    public BigDecimal getJzje() {
        return jzje;
    }

    public void setJzje(BigDecimal jzje) {
        this.jzje = jzje;
    }

    public Integer getSsys() {
        return ssys;
    }

    public void setSsys(Integer ssys) {
        this.ssys = ssys;
    }

    public Integer getJzrdm() {
        return jzrdm;
    }

    public void setJzrdm(Integer jzrdm) {
        this.jzrdm = jzrdm;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
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

    public Integer getSqdh() {
        return sqdh;
    }

    public void setSqdh(Integer sqdh) {
        this.sqdh = sqdh;
    }
}
