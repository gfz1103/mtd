package com.buit.his.treatment.response;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.sql.Timestamp;

/**
 * @Author jiangwei
 * @Date 2021-04-13 10:10
 * @Description
 **/
@ApiModel("康复治疗住院治疗记录单打印 - 患者信息参数状态")
public class ExecuteLogPatientResp {
    @ApiModelProperty(value = "病人姓名")
    private String brxm;
    @ApiModelProperty(value = "出生日期")
    private Timestamp csny;
    private String csrq;
    @ApiModelProperty(value = "病人性别")
    private String brxb;
    @ApiModelProperty(value = "病人年龄")
    private String age;
    @ApiModelProperty(value = "病人科室")
    private String brks;
    @ApiModelProperty(value = "病人病区")
    private String brbq;
    @ApiModelProperty(value = "病人床号")
    private String brch;
    @ApiModelProperty(value = "住院号码")
    private String zyhm;
    @ApiModelProperty(value = "入院诊断")
    private String ryzd;

    public String getBrxm() {
        return brxm;
    }

    public void setBrxm(String brxm) {
        this.brxm = brxm;
    }

    public String getCsrq() {
        return csrq;
    }

    public void setCsrq(String csrq) {
        this.csrq = csrq;
    }

    public String getBrxb() {
        return brxb;
    }

    public void setBrxb(String brxb) {
        this.brxb = brxb;
    }

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }

    public String getBrks() {
        return brks;
    }

    public void setBrks(String brks) {
        this.brks = brks;
    }

    public String getBrbq() {
        return brbq;
    }

    public void setBrbq(String brbq) {
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

    public Timestamp getCsny() {
        return csny;
    }

    public void setCsny(Timestamp csny) {
        this.csny = csny;
    }

    public String getRyzd() {
        return ryzd;
    }

    public void setRyzd(String ryzd) {
        this.ryzd = ryzd;
    }
}
