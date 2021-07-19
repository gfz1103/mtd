package com.buit.his.treatment.response;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;

/**
 * @Author jiangwei
 * @Date 2021-04-01 16:03
 * @Description
 **/
@ApiModel("治疗记录单打印 - 治疗记录详情")
public class ZljlReportDetailResp implements Serializable {
    @ApiModelProperty(value = "执行日期")
    private String zxrq;
    @ApiModelProperty(value = "治疗项目")
    private String zlxm;
    @ApiModelProperty(value = "不良反应")
    private String blfy;
    @ApiModelProperty(value = "备注")
    private String bzxx;
    @ApiModelProperty(value = "阶段小结")
    private String jdxj;

    public String getZxrq() {
        return zxrq;
    }

    public void setZxrq(String zxrq) {
        this.zxrq = zxrq;
    }

    public String getZlxm() {
        return zlxm;
    }

    public void setZlxm(String zlxm) {
        this.zlxm = zlxm;
    }

    public String getBlfy() {
        return blfy;
    }

    public void setBlfy(String blfy) {
        this.blfy = blfy;
    }

    public String getBzxx() {
        return bzxx;
    }

    public void setBzxx(String bzxx) {
        this.bzxx = bzxx;
    }

    public String getJdxj() {
        return jdxj;
    }

    public void setJdxj(String jdxj) {
        this.jdxj = jdxj;
    }
}
