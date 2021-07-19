package com.buit.his.treatment.response;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.sql.Date;

/**
 * @Author weijing
 * @Date 2021-01-21 09:59
 * @Description
 **/
@ApiModel("查询住院诊疗预约返回")
public class QueryZyzlyyResp {
    @ApiModelProperty(value = "医疗机构代码")
    private Integer jgid;

    @ApiModelProperty(value = "住院号")
    private Integer zyh;

    @ApiModelProperty(value = "病人病区")
    private Integer brbq;

    @ApiModelProperty(value = "病人床号")
    private String brch;

    @ApiModelProperty(value = "住院号码")
    private String zyhm;

    @ApiModelProperty(value = "病人姓名")
    private String brxm;

    @ApiModelProperty(value = "病人性别")
    private Integer brxb;

    @ApiModelProperty(value = "出生日期")
    private Date csrq;

    @ApiModelProperty(value = "就诊卡号")
    private String jzkh;

    @ApiModelProperty(value = "预约状态")
    private Integer zt;

    @ApiModelProperty(value = "预约时间开始")
    private String yysdks;

    @ApiModelProperty(value = "预约时间结束")
    private String yysdjs;

    public String getJzkh() {
        return jzkh;
    }

    public void setJzkh(String jzkh) {
        this.jzkh = jzkh;
    }

    public Integer getJgid() {
        return jgid;
    }

    public void setJgid(Integer jgid) {
        this.jgid = jgid;
    }

    public Integer getZyh() {
        return zyh;
    }

    public void setZyh(Integer zyh) {
        this.zyh = zyh;
    }

    public Integer getBrbq() {
        return brbq;
    }

    public void setBrbq(Integer brbq) {
        this.brbq = brbq;
    }

    public String getBrch() {
        return brch;
    }

    public void setBrch(String brch) {
        this.brch = brch;
    }

    public String getZyhm() {
        return zyhm;
    }

    public void setZyhm(String zyhm) {
        this.zyhm = zyhm;
    }

    public String getBrxm() {
        return brxm;
    }

    public void setBrxm(String brxm) {
        this.brxm = brxm;
    }

    public Integer getBrxb() {
        return brxb;
    }

    public void setBrxb(Integer brxb) {
        this.brxb = brxb;
    }

    public Date getCsrq() {
        return csrq;
    }

    public void setCsrq(Date csrq) {
        this.csrq = csrq;
    }

    public Integer getZt() {
        return zt;
    }

    public void setZt(Integer zt) {
        this.zt = zt;
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
}
