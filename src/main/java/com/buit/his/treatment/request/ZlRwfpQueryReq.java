package com.buit.his.treatment.request;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import javax.validation.constraints.NotNull;
import java.util.List;

/**
 * @Author jiangwei
 * @Date 2021-06-18 11:20
 * @Description
 **/
@ApiModel("查询康复分配治疗任务列表入参")
public class ZlRwfpQueryReq {
    @ApiModelProperty(value = "医疗机构id", hidden = true)
    private Integer jgid;

    @NotNull
    @ApiModelProperty(value = "治疗科室代码")
    private Integer zlksdm;

    @NotNull
    @ApiModelProperty(value = "住院号")
    private List<Integer> zyhList;

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

    public List<Integer> getZyhList() {
        return zyhList;
    }

    public void setZyhList(List<Integer> zyhList) {
        this.zyhList = zyhList;
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
