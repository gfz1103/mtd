package com.buit.his.treatment.request;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * @Author weijing
 * @Date 2021-01-21 10:26
 * @Description
 **/
@ApiModel("住院治疗预约申请入参")
public class ApplyZyzlyyReq {
    @ApiModelProperty(value = "医疗机构代码",hidden = true)
    private Integer jgid;

    @ApiModelProperty(value = "住院号")
    private Integer zyh;

    @ApiModelProperty(value = "诊疗类别")
    private Integer zllb;

    @ApiModelProperty(value = "预约时间开始 格式：08:00")
    private String yysdks;

    @ApiModelProperty(value = "预约时间结束 格式：08:30")
    private String yysdjs;

    @ApiModelProperty(value = "执行科室",hidden = true)
    private Integer zxks;

    public Integer getZyh() {
        return zyh;
    }

    public void setZyh(Integer zyh) {
        this.zyh = zyh;
    }

    public Integer getZllb() {
        return zllb;
    }

    public void setZllb(Integer zllb) {
        this.zllb = zllb;
    }

    public String getYysdks() {
        return yysdks;
    }

    public void setYysdks(String yysdks) {
        this.yysdks = yysdks;
    }

    public String getYysdjs() {
        return yysdjs;
    }

    public void setYysdjs(String yysdjs) {
        this.yysdjs = yysdjs;
    }

    public Integer getZxks() {
        return zxks;
    }

    public void setZxks(Integer zxks) {
        this.zxks = zxks;
    }

    public Integer getJgid() {
        return jgid;
    }

    public void setJgid(Integer jgid) {
        this.jgid = jgid;
    }
}
