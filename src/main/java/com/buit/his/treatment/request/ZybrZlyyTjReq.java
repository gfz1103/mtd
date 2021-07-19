package com.buit.his.treatment.request;

import com.buit.commons.PageQuery;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 *
 * 住院病人治疗预约查询入参
 * zhouhaisheng
 */
@ApiModel(value = "住院病人治疗预约查询入参")
public class ZybrZlyyTjReq extends PageQuery {

    @ApiModelProperty(value="医疗机构ID",hidden = true)
    private  Integer jgid;

    @ApiModelProperty(value="病人病区")
    private  Integer brbq;

    @ApiModelProperty(value="治疗科室代码")
    private Integer zlksdm;

    @ApiModelProperty(value="开始时间")
    private String startDate;

    @ApiModelProperty(value="结束时间")
    private String endDate;

    public Integer getJgid() {
        return jgid;
    }

    public void setJgid(Integer jgid) {
        this.jgid = jgid;
    }

    public Integer getBrbq() {
        return brbq;
    }

    public void setBrbq(Integer brbq) {
        this.brbq = brbq;
    }

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
}
