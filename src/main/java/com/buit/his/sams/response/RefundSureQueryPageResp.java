package com.buit.his.sams.response;

import com.buit.commons.PageQuery;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.math.BigDecimal;
import java.sql.Timestamp;
import java.util.List;

/**
 * 住院退款确认 分页查询出参
 * zhouhaisheng
 */
@ApiModel(value ="住院退款确认 分页查询出参" )
public class RefundSureQueryPageResp extends PageQuery {
    private Integer jlxh;
    @ApiModelProperty(value="申请时间")
    private Timestamp sqsj;
    @ApiModelProperty(value="记账单号 ")
    private Integer jzdh;
    @ApiModelProperty(value="病人病区 ")
    private Integer brbq;
    @ApiModelProperty(value="病人床号 ")
    private String brch;
    @ApiModelProperty(value="住院号码 ")
    private String zyhm;
    @ApiModelProperty(value="病人科室 ")
    private Integer brks;
    @ApiModelProperty(value = "病人姓名")
    private String  brxm;
    @ApiModelProperty(value = "病人性别")
    private Integer brxb;
    @ApiModelProperty(value = "出生年月",hidden = true)
    private Timestamp csny;
    @ApiModelProperty(value = "年龄")
    private Integer age;
    @ApiModelProperty(value = "退账金额")
    private BigDecimal tzje;
    @ApiModelProperty(value = "退费申请人")
    private Integer tfsqr;
    @ApiModelProperty(value = "0 未确认/1 已确认")
    private String zt;
    @ApiModelProperty(value="退费确认时间")
    private Timestamp qrsj;
    @ApiModelProperty(value="确认人")
    private Integer qrr;

    public Integer getJlxh() {
        return jlxh;
    }

    public void setJlxh(Integer jlxh) {
        this.jlxh = jlxh;
    }

    public Timestamp getSqsj() {
        return sqsj;
    }

    public void setSqsj(Timestamp sqsj) {
        this.sqsj = sqsj;
    }

    public Integer getJzdh() {
        return jzdh;
    }

    public void setJzdh(Integer jzdh) {
        this.jzdh = jzdh;
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

    public String getZyhm() {
        return zyhm;
    }

    public void setZyhm(String zyhm) {
        this.zyhm = zyhm;
    }

    public Integer getBrks() {
        return brks;
    }

    public void setBrks(Integer brks) {
        this.brks = brks;
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

    public BigDecimal getTzje() {
        return tzje;
    }

    public void setTzje(BigDecimal tzje) {
        this.tzje = tzje;
    }

    public Integer getTfsqr() {
        return tfsqr;
    }

    public void setTfsqr(Integer tfsqr) {
        this.tfsqr = tfsqr;
    }

    public String getZt() {
        return zt;
    }

    public void setZt(String zt) {
        this.zt = zt;
    }

    public Timestamp getQrsj() {
        return qrsj;
    }

    public void setQrsj(Timestamp qrsj) {
        this.qrsj = qrsj;
    }

    public Integer getQrr() {
        return qrr;
    }

    public void setQrr(Integer qrr) {
        this.qrr = qrr;
    }

    public Timestamp getCsny() {
        return csny;
    }

    public void setCsny(Timestamp csny) {
        this.csny = csny;
    }

}
