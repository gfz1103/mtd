package com.buit.his.sams.request;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * 手术室收入统计入参
 * zhouhaisheng
 */
@ApiModel(value = "手术室收入统计入参")
public class SsssrtjReq {
    @ApiModelProperty(value = "手术科室代码")
    private Integer ssksdm;
    @ApiModelProperty(value = "开始时间")
    private String startDate;
    @ApiModelProperty(value = "结束时间")
    private String endDate;
    @ApiModelProperty(value = "记账类型 1：手术记账 2：麻醉记账")
    private Integer jzlx;
    @ApiModelProperty(value = "病人姓名")
    private String brxm;
    @ApiModelProperty(value = "病人卡号")
    private String brkh;
    @ApiModelProperty(value = "住院号码")
    private String zyhm;

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

    public Integer getJzlx() {
        return jzlx;
    }

    public void setJzlx(Integer jzlx) {
        this.jzlx = jzlx;
    }

    public String getBrxm() {
        return brxm;
    }

    public void setBrxm(String brxm) {
        this.brxm = brxm;
    }

    public String getBrkh() {
        return brkh;
    }

    public void setBrkh(String brkh) {
        this.brkh = brkh;
    }

    public String getZyhm() {
        return zyhm;
    }

    public void setZyhm(String zyhm) {
        this.zyhm = zyhm;
    }
}
