package com.buit.his.treatment.response;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.sql.Date;
import java.sql.Timestamp;

/**
 * @Author jiangwei
 * @Date 2021-03-16 11:16
 * @Description
 **/
@ApiModel("查询住院康复治疗病人")
public class ZlRwfpPatientResp {
    @ApiModelProperty(value = "医疗机构id")
    private Integer jgid;

    @ApiModelProperty(value = "住院号（主键）")
    private Integer zyh;

    @ApiModelProperty(value = "住院号码（界面展示用）")
    private String zyhm;

    @ApiModelProperty(value = "病人病区")
    private Integer brbq;

    @ApiModelProperty(value = "病人床号")
    private String brch;

    @ApiModelProperty(value = "病人科室")
    private Integer brks;

    @ApiModelProperty(value = "病人姓名")
    private String brxm;

    @ApiModelProperty(value = "病人性别")
    private Integer brxb;

    @ApiModelProperty(value = "出生日期")
    private Date csrq;

    @ApiModelProperty(value = "入院日期")
    private Timestamp ryrq;

    @ApiModelProperty(value = "入院诊断")
    private String ryzd;

    @ApiModelProperty(value = "出院判别（1在院 2出院）")
    private Integer cypb;

    public Integer getJgid() {
        return jgid;
    }

    public void setJgid(Integer jgid) {
        this.jgid = jgid;
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

    public Timestamp getRyrq() {
        return ryrq;
    }

    public void setRyrq(Timestamp ryrq) {
        this.ryrq = ryrq;
    }

    public String getRyzd() {
        return ryzd;
    }

    public void setRyzd(String ryzd) {
        this.ryzd = ryzd;
    }

    public Integer getCypb() {
        return cypb;
    }

    public void setCypb(Integer cypb) {
        this.cypb = cypb;
    }
}
