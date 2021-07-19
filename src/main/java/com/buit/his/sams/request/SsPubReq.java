package com.buit.his.sams.request;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * 手术统计查询公用入参
 * zhouhaisheng
 */
@ApiModel(value = "手术统计查询公用入参")
public class SsPubReq {
    @ApiModelProperty(value = "记账类型 1：手术记账 2：麻醉记账")
    private Integer jzlx;
    @ApiModelProperty(value = "手术室")
    private Integer ssksdm;
    @ApiModelProperty(value = "开始时间")
    private String startDate;
    @ApiModelProperty(value = "结束时间")
    private String endDate;

    public Integer getJzlx() {
        return jzlx;
    }

    public void setJzlx(Integer jzlx) {
        this.jzlx = jzlx;
    }

    public Integer getSsksdm() {
        return ssksdm;
    }

    public void setSsksdm(Integer ssksdm) {
        this.ssksdm = ssksdm;
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
