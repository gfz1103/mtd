package com.buit.his.treatment.request;

import com.buit.commons.PageQuery;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import javax.validation.constraints.NotNull;

/**
 * 分页查询病人治疗预约信息入参
 * zhouhaisheng
 */
@ApiModel(value = "分页查询病人治疗预约信息入参")
public class ZlyyPageQueryReq extends PageQuery {
    @ApiModelProperty(value = "申请开始时间")
    private String startDate;
    @ApiModelProperty(value = "申请结束时间")
    private String endDate;
    @ApiModelProperty(value = "状态 0 未预约1 部分预约2 全部预约3 部分执行4 完成")
    private String zt;
    @ApiModelProperty("病人姓名")
    private String brxm;
    @ApiModelProperty("门诊号码")
    private String mzhm;
    @ApiModelProperty(value = "医疗机构id", hidden = true)
    private Integer jgid;
    @ApiModelProperty(value = "治疗科室代码")
    @NotNull(message = "治疗科室代码必填")
    private Integer zlksdm;

    public Integer getZlksdm() {
        return zlksdm;
    }

    public void setZlksdm(Integer zlksdm) {
        this.zlksdm = zlksdm;
    }

    public String getStartDate() {
        return startDate;
    }

    public void setStartDate(String startDate) {
        this.startDate = startDate;
    }

    public String getEndDate() {
        return endDate;
    }

    public void setEndDate(String endDate) {
        this.endDate = endDate;
    }

    public String getZt() {
        return zt;
    }

    public void setZt(String zt) {
        this.zt = zt;
    }

    public String getBrxm() {
        return brxm;
    }

    public void setBrxm(String brxm) {
        this.brxm = brxm;
    }

    public String getMzhm() {
        return mzhm;
    }

    public void setMzhm(String mzhm) {
        this.mzhm = mzhm;
    }

    public Integer getJgid() {
        return jgid;
    }

    public void setJgid(Integer jgid) {
        this.jgid = jgid;
    }
}
