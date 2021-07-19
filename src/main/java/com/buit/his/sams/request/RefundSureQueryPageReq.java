package com.buit.his.sams.request;

import com.buit.commons.PageQuery;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * 住院退款确认 分页查询入参
 * zhouhaisheng
 */
@ApiModel(value = "住院退款确认 分页查询入参")
public class RefundSureQueryPageReq extends PageQuery {
    @ApiModelProperty(value = "记账类型 | 1:手术记账 2:麻醉记账")
    private Integer jzlx;
    @ApiModelProperty(value = "医疗机构id")
    private Integer jgid;
    @ApiModelProperty(value = "手术科室代码")
    private Integer ssksdm;
    @ApiModelProperty(value = "确认状态 | 0：未确认 1：已确认")
    private Integer zt;
    @ApiModelProperty(value = "开始时间")
    private String startDate;
    @ApiModelProperty(value = "结束时间")
    private String endDate;
    @ApiModelProperty(value = "病人姓名")
    private String brxm;
    @ApiModelProperty(value = "住院号码")
    private String zyhm;

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

    public Integer getZt() {
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

    public String getBrxm() {
        return brxm;
    }

    public void setBrxm(String brxm) {
        this.brxm = brxm;
    }

    public String getZyhm() {
        return zyhm;
    }

    public void setZyhm(String zyhm) {
        this.zyhm = zyhm;
    }

    public Integer getJgid() {
        return jgid;
    }

    public void setJgid(Integer jgid) {
        this.jgid = jgid;
    }
}
