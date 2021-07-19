package com.buit.his.treatment.request;

import com.buit.commons.PageQuery;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * 科室治疗工作量统计入参
 * zhouhaisheng
 */
@ApiModel(value = "科室治疗工作量统计入参")
public class DeptTreatStatisticsReq extends PageQuery {

    @ApiModelProperty(value = "医疗机构id",hidden = true)
    private Integer jgid;
    @ApiModelProperty(value = "治疗科室代码")
    private Integer zlksdm;
    @ApiModelProperty(value = "开始时间")
    private String startDate;
    @ApiModelProperty(value = "结束时间")
    private String endDate;

    @ApiModelProperty(value = "治疗项目id")
    private Integer zlxmxh;

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

    public Integer getZlxmxh() {
        return zlxmxh;
    }

    public void setZlxmxh(Integer zlxmxh) {
        this.zlxmxh = zlxmxh;
    }
}
