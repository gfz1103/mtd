package com.buit.his.sams.response;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.math.BigDecimal;

/**
 * 手术间工作量统计出参
 * zhouhaisheng
 */
@ApiModel(value = "手术间工作量统计出参")
public class SsjgzltjResp {
    @ApiModelProperty(value = "手术间")
    private String ssj;
    @ApiModelProperty(value = "总人次")
    private Integer zrc;
    @ApiModelProperty(value = "总金额")
    private BigDecimal zje;
    @ApiModelProperty(value = "药品金额")
    private BigDecimal ypje;
    @ApiModelProperty(value = "非药品金额")
    private BigDecimal fypje;
    @ApiModelProperty(value = "药占比")
    private BigDecimal yzb;

    public String getSsj() {
        return ssj;
    }

    public void setSsj(String ssj) {
        this.ssj = ssj;
    }

    public Integer getZrc() {
        return zrc;
    }

    public void setZrc(Integer zrc) {
        this.zrc = zrc;
    }

    public BigDecimal getZje() {
        return zje;
    }

    public void setZje(BigDecimal zje) {
        this.zje = zje;
    }

    public BigDecimal getYpje() {
        return ypje;
    }

    public void setYpje(BigDecimal ypje) {
        this.ypje = ypje;
    }

    public BigDecimal getFypje() {
        return fypje;
    }

    public void setFypje(BigDecimal fypje) {
        this.fypje = fypje;
    }

    public BigDecimal getYzb() {
        return yzb;
    }

    public void setYzb(BigDecimal yzb) {
        this.yzb = yzb;
    }
}
