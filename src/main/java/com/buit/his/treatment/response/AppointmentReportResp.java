package com.buit.his.treatment.response;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.sql.Date;

/**
 * @Author jiangwei
 * @Date 2021-03-31 16:56
 **/
@ApiModel("住院病人治疗预约查询返回结果封装")
public class AppointmentReportResp {
    @ApiModelProperty(value = "预约时间段开始时间")
    private String kssj;
    @ApiModelProperty(value = "预约时间段结束时间")
    private String jssj;
    @ApiModelProperty(value = "住院号码（界面展示用）")
    private String zyhm;
    @ApiModelProperty(value = "病人姓名")
    private String brxm;
    @ApiModelProperty(value = "病人性别")
    private Integer brxb;
    @ApiModelProperty(value = "出生日期")
    private Date csrq;
    @ApiModelProperty(value = "病人病区")
    private Integer brbq;
    @ApiModelProperty(value = "病人床号")
    private String brch;
    @ApiModelProperty(value = "病人科室")
    private Integer brks;
    @ApiModelProperty(value = "诊疗类别")
    private Integer zllb;
    @ApiModelProperty(value = "治疗组主键")
    private Integer zlzid;
    @ApiModelProperty(value = "治疗师代码")
    private Integer zlsdm;
    @ApiModelProperty(value = "预约状态 |  0：未预约    2：已预约")
    private Integer yyzt;

    public String getZyhm() {
        return zyhm;
    }

    public void setZyhm(String zyhm) {
        this.zyhm = zyhm;
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

    public Date getCsrq() {
        return csrq;
    }

    public void setCsrq(Date csrq) {
        this.csrq = csrq;
    }

    public String getKssj() {

        return kssj;
    }

    public void setKssj(String kssj) {
        this.kssj = kssj;
    }

    public String getJssj() {
        return jssj;
    }

    public void setJssj(String jssj) {
        this.jssj = jssj;
    }

    public Integer getBrks() {
        return brks;
    }

    public void setBrks(Integer brks) {
        this.brks = brks;
    }

    public Integer getZllb() {
        return zllb;
    }

    public void setZllb(Integer zllb) {
        this.zllb = zllb;
    }

    public Integer getZlzid() {
        return zlzid;
    }

    public void setZlzid(Integer zlzid) {
        this.zlzid = zlzid;
    }

    public Integer getZlsdm() {
        return zlsdm;
    }

    public void setZlsdm(Integer zlsdm) {
        this.zlsdm = zlsdm;
    }

    public Integer getYyzt() {
        return yyzt;
    }

    public void setYyzt(Integer yyzt) {
        this.yyzt = yyzt;
    }
}
