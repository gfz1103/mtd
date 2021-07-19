package com.buit.his.treatment.response;

import com.buit.commons.PageQuery;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.math.BigDecimal;
import java.sql.Timestamp;

/**
 * 科室治疗工作量统计明细出参
 * zhouhaisheng
 */
@ApiModel(value = "科室治疗工作量统计明细出参")
public class DeptTreatStatisticsDetailResp extends PageQuery {

    @ApiModelProperty(value = "执行时间")
    private Timestamp zxsj;
    @ApiModelProperty(value = "病人姓名")
    private String brxm;
    @ApiModelProperty(value = "病人性别")
    private Integer brxb;
    @ApiModelProperty(value = "病人年龄")
    private Integer age;
    @ApiModelProperty(value = "病人病区")
    private Integer brbq;
    @ApiModelProperty(value = "病人床号")
    private String brch;
    @ApiModelProperty(value = "病人科室")
    private Integer brks;
    @ApiModelProperty(value = "开单医生")
    private String kdys;
    @ApiModelProperty(value = "治疗项目名称")
    private String zlxmmc;
    @ApiModelProperty(value = "次数")
    private Integer zlcs;
    @ApiModelProperty(value = "金额")
    private String je;
    @ApiModelProperty(value = "执行医生工号")
    private Integer zxys;
    @ApiModelProperty(value = "执行医生")
    private String zxysStr;
    @ApiModelProperty(value = "出生年月",hidden = true)
    private Timestamp csny;

    public Timestamp getZxsj() {
        return zxsj;
    }

    public void setZxsj(Timestamp zxsj) {
        this.zxsj = zxsj;
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

    public String getKdys() {
        return kdys;
    }

    public void setKdys(String kdys) {
        this.kdys = kdys;
    }

    public String getZlxmmc() {
        return zlxmmc;
    }

    public void setZlxmmc(String zlxmmc) {
        this.zlxmmc = zlxmmc;
    }

    public Integer getZlcs() {
        return zlcs;
    }

    public void setZlcs(Integer zlcs) {
        this.zlcs = zlcs;
    }

    public Integer getZxys() {
        return zxys;
    }

    public void setZxys(Integer zxys) {
        this.zxys = zxys;
    }

    public String getZxysStr() {
        return zxysStr;
    }

    public void setZxysStr(String zxysStr) {
        this.zxysStr = zxysStr;
    }

    public Timestamp getCsny() {
        return csny;
    }

    public void setCsny(Timestamp csny) {
        this.csny = csny;
    }

    public String getJe() {
        return je;
    }

    public void setJe(String je) {
        this.je = je;
    }
}
