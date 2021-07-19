package com.buit.his.treatment.request;

import com.buit.commons.PageQuery;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import javax.validation.constraints.NotNull;

/**
 * @Author weijing
 * @Date 2021-01-20 15:25
 * @Description
 **/
@ApiModel("查询待康复治疗患者入参")
public class ZlRwfpPatientQueryReq extends PageQuery {
    @ApiModelProperty(value = "医疗机构id", hidden = true)
    private Integer jgid;

    @NotNull
    @ApiModelProperty(value = "治疗科室代码")
    private Integer zlksdm;

    @ApiModelProperty(value = "病人病区")
    private Integer brbq;

    @ApiModelProperty(value = "病人床号")
    private String brch;

    @ApiModelProperty(value = "出院判别 （1在院 2出院 空查询所有）")
    private Integer cypb;

    @ApiModelProperty(value = "诊疗类别")
    private Integer zllb;

    @ApiModelProperty(value = "分配状态 | 0：未分配    2：已分配")
    private Integer fpzt;

    @ApiModelProperty(value = "临时医嘱 | 0：长期医嘱    1：临时医嘱")
    private Integer lsyz;

    @ApiModelProperty(value = "停嘱状态 | 0：未停嘱    1：已停嘱")
    private Integer tzzt;

    public Integer getJgid() {
        return jgid;
    }

    public void setJgid(Integer jgid) {
        this.jgid = jgid;
    }

    public Integer getZlksdm() {
        return zlksdm;
    }

    public void setZlksdm(Integer zlksdm) {
        this.zlksdm = zlksdm;
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

    public Integer getCypb() {
        return cypb;
    }

    public void setCypb(Integer cypb) {
        this.cypb = cypb;
    }

    public Integer getZllb() {
        return zllb;
    }

    public void setZllb(Integer zllb) {
        this.zllb = zllb;
    }

    public Integer getFpzt() {
        return fpzt;
    }

    public void setFpzt(Integer fpzt) {
        this.fpzt = fpzt;
    }

    public Integer getLsyz() {
        return lsyz;
    }

    public void setLsyz(Integer lsyz) {
        this.lsyz = lsyz;
    }

    public Integer getTzzt() {
        return tzzt;
    }

    public void setTzzt(Integer tzzt) {
        this.tzzt = tzzt;
    }
}
