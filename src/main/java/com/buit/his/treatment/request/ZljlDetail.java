package com.buit.his.treatment.request;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.sql.Timestamp;

/**
 * @Author weijing
 * @Date 2021-01-27 13:39
 * @Description
 **/
@ApiModel("治疗记录详情")
public class ZljlDetail {
    @ApiModelProperty(value = "执行时间段（开始）")
    private String zxsjdks;

    @ApiModelProperty(value = "执行时间段（结束）")
    private String zxsjdjs;

    @ApiModelProperty(value = "执行医生/执行治疗师")
    private Integer zxysgh;

    @ApiModelProperty(value = "见习治疗师")
    private Integer jxzlsgh;

    @ApiModelProperty(value = "有无不良反应（1有 0无）")
    private Integer ywblfy;

    @ApiModelProperty(value = "不良反应")
    private String blfy;

    @ApiModelProperty(value = "备注")
    private String bz;

    @ApiModelProperty(value = "阶段小结（阶段小结时必填）")
    private String zlzj;

    @ApiModelProperty(value = "执行记录时间",hidden = true)
    private Timestamp zxjlsj;

    @ApiModelProperty(value = "执行记录人工号",hidden = true)
    private Integer zxjlgh;

    public String getZxsjdks() {
        return zxsjdks;
    }

    public void setZxsjdks(String zxsjdks) {
        this.zxsjdks = zxsjdks;
    }

    public String getZxsjdjs() {
        return zxsjdjs;
    }

    public void setZxsjdjs(String zxsjdjs) {
        this.zxsjdjs = zxsjdjs;
    }

    public Integer getZxysgh() {
        return zxysgh;
    }

    public void setZxysgh(Integer zxysgh) {
        this.zxysgh = zxysgh;
    }

    public Integer getJxzlsgh() {
        return jxzlsgh;
    }

    public void setJxzlsgh(Integer jxzlsgh) {
        this.jxzlsgh = jxzlsgh;
    }

    public Integer getYwblfy() {
        return ywblfy;
    }

    public void setYwblfy(Integer ywblfy) {
        this.ywblfy = ywblfy;
    }

    public String getBlfy() {
        return blfy;
    }

    public void setBlfy(String blfy) {
        this.blfy = blfy;
    }

    public String getBz() {
        return bz;
    }

    public void setBz(String bz) {
        this.bz = bz;
    }

    public String getZlzj() {
        return zlzj;
    }

    public void setZlzj(String zlzj) {
        this.zlzj = zlzj;
    }

    public Timestamp getZxjlsj() {
        return zxjlsj;
    }

    public void setZxjlsj(Timestamp zxjlsj) {
        this.zxjlsj = zxjlsj;
    }

    public Integer getZxjlgh() {
        return zxjlgh;
    }

    public void setZxjlgh(Integer zxjlgh) {
        this.zxjlgh = zxjlgh;
    }
}
