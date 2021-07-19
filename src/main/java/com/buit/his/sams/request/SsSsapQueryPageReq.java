package com.buit.his.sams.request;

import com.buit.commons.PageQuery;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;


/**
 * 类名称：SsSsap<br>
 * 类描述：手术安排表分页查询入参<br>
 * @author zhouhaisheng
 */
@ApiModel(value = "手术安排表分页查询入参")
public class SsSsapQueryPageReq extends PageQuery {

    @ApiModelProperty(value = "机构id", hidden = true)
    private Integer jgid;
    @ApiModelProperty(value = "手术 科室代码")
    private Integer ssksdm;
    @ApiModelProperty(value = "紧急类型 1择期/2急诊")
    private String jjlx;
    @ApiModelProperty(value = "手术状态 | 0：未安排    1：已安排    2：已完成")
    private Integer zt;
    @ApiModelProperty(value = "开始时间")
    private String startDate;
    @ApiModelProperty(value = "结束时间")
    private String endDate;


    public Integer getJgid() {
        return jgid;
    }

    public void setJgid(Integer jgid) {
        this.jgid = jgid;
    }

    public Integer getSsksdm() {
        return ssksdm;
    }

    public void setSsksdm(Integer ssksdm) {
        this.ssksdm = ssksdm;
    }

    public String getJjlx() {
        return jjlx;
    }

    public void setJjlx(String jjlx) {
        this.jjlx = jjlx;
    }

    public Integer isZt() {
        return zt;
    }

    public void setZt(Integer zt) {
        this.zt = zt;
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