package com.buit.his.treatment.request;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;


/**
 * 类名称：ZlSqdzd<br>
 * 类描述：治疗申请单诊断修改入参<br>
 * @author ZHOUHAISHENG
 */
@ApiModel(value="治疗申请单诊断修改入参")
public class ZlSqdzdUpdateReq {
    @ApiModelProperty(value="主键id")
    private Integer jlxh;
    @ApiModelProperty(value="治疗申请单号")
    private String zlsqdh;
    @ApiModelProperty(value="序号")
    private Integer xh;
    @ApiModelProperty(value="诊断名称")
    private String zdmc;
    @ApiModelProperty(value="ICD码")
    private String icd;

    public Integer getXh() {
        return xh;
    }

    public void setXh(Integer xh) {
        this.xh = xh;
    }

    public String getZdmc() {
        return zdmc;
    }

    public void setZdmc(String zdmc) {
        this.zdmc = zdmc;
    }

    public String getIcd() {
        return icd;
    }

    public void setIcd(String icd) {
        this.icd = icd;
    }

    public Integer getJlxh() {
        return jlxh;
    }

    public void setJlxh(Integer jlxh) {
        this.jlxh = jlxh;
    }

    public String getZlsqdh() {
        return zlsqdh;
    }

    public void setZlsqdh(String zlsqdh) {
        this.zlsqdh = zlsqdh;
    }
}