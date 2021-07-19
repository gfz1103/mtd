package com.buit.his.sams.response;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.math.BigDecimal;

/**
 * 手术科室工作量统计出参
 * zhouhaisheng
 */
@ApiModel(value = "手术科室工作量统计出参")
public class SsksgzltjResp {

    @ApiModelProperty(value = "科室")
    private Integer brks;
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

    public Integer getBrks() {
        return brks;
    }

    public void setBrks(Integer brks) {
        this.brks = brks;
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
