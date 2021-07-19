package com.buit.his.treatment.request;

import com.buit.commons.PageQuery;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import javax.validation.constraints.NotNull;

/**
 * 分页查询病人申请单列表入参
 * jiangwei
 */
@ApiModel(value = "分页查询病人申请单列表入参")
public class ZlSqdzbPageQueryReq extends PageQuery {
    @NotNull
    @ApiModelProperty(value = "申请开始时间")
    private String startDate;
    @NotNull
    @ApiModelProperty(value = "申请结束时间")
    private String endDate;
    @ApiModelProperty(value = "0 未作废 1:已作废")
    private String zf;
    @ApiModelProperty(value = "医疗机构id", hidden = true)
    private Integer jgid;
    @NotNull
    @ApiModelProperty(value = "门诊号码")
    private String mzhm;

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

    public String getZf() {
        return zf;
    }

    public void setZf(String zf) {
        this.zf = zf;
    }

    public Integer getJgid() {
        return jgid;
    }

    public void setJgid(Integer jgid) {
        this.jgid = jgid;
    }

    public String getMzhm() {
        return mzhm;
    }

    public void setMzhm(String mzhm) {
        this.mzhm = mzhm;
    }
}
