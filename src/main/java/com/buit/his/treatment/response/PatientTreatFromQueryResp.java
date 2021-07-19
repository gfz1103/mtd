package com.buit.his.treatment.response;

import com.buit.commons.PageQuery;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.sql.Timestamp;

/**
 * 病人治疗申请单查询出参
 * zhouhaisheng
 */
@ApiModel(value = "病人治疗申请单查询出参")
public class PatientTreatFromQueryResp extends PageQuery {
    @ApiModelProperty(value = "申请时间")
    private Timestamp sqsj;
    @ApiModelProperty(value = "申请单号")
    private String zlsqdh;
    @ApiModelProperty(value = "病人姓名")
    private String brxm;
    @ApiModelProperty(value = "病人性别")
    private Integer brxb;
    @ApiModelProperty(value = "病人年龄")
    private Integer age;
    @ApiModelProperty(value = "病人床号")
    private String brch;
    @ApiModelProperty(value = "病人科室")
    private Integer brks;
    @ApiModelProperty(value = "开单医生")
    private String kdys;
    @ApiModelProperty(value = "住院号码")
    private  String zyhm;
    @ApiModelProperty(value="出生年月",hidden = true)
    private Timestamp csny;
    @ApiModelProperty(value="病人病区")
    private Integer brbq;
    @ApiModelProperty(value="病人科室")
    private Integer ksdm;

    @ApiModelProperty(value="状态 0 未预约1 部分预约2 全部预约3 部分执行4 完成")
    private String zt;
    public Timestamp getSqsj() {
        return sqsj;
    }

    public void setSqsj(Timestamp sqsj) {
        this.sqsj = sqsj;
    }

    public Integer getKsdm() {
        return ksdm;
    }

    public void setKsdm(Integer ksdm) {
        this.ksdm = ksdm;
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

    public String getKdys() {
        return kdys;
    }

    public void setKdys(String kdys) {
        this.kdys = kdys;
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

    public String getZlsqdh() {
        return zlsqdh;
    }

    public void setZlsqdh(String zlsqdh) {
        this.zlsqdh = zlsqdh;
    }

    public String getZt() {
        return zt;
    }

    public void setZt(String zt) {
        this.zt = zt;
    }

    public Integer getBrbq() {
        return brbq;
    }

    public void setBrbq(Integer brbq) {
        this.brbq = brbq;
    }
}
