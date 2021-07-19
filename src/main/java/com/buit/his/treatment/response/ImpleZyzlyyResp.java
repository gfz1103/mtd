package com.buit.his.treatment.response;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.sql.Date;

/**
 * @Author weijing
 * @Date 2021-01-25 11:16
 * @Description
 **/
@ApiModel("住院治疗执行查询返回")
public class ImpleZyzlyyResp {
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

    @ApiModelProperty(value = "病人科室")
    private Integer brks;

    @ApiModelProperty(value = "执行状态 0未执行 1已执行")
    private Integer zxzt;

    @ApiModelProperty(value = "病人情况 0普通 1新病人 2需要阶段小结")
    private Integer brqk;

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

    public String getJzkh() {
        return jzkh;
    }

    public void setJzkh(String jzkh) {
        this.jzkh = jzkh;
    }

    public Integer getBrks() {
        return brks;
    }

    public void setBrks(Integer brks) {
        this.brks = brks;
    }

    public Integer getZxzt() {
        return zxzt;
    }

    public void setZxzt(Integer zxzt) {
        this.zxzt = zxzt;
    }

    public Integer getBrqk() {
        return brqk;
    }

    public void setBrqk(Integer brqk) {
        this.brqk = brqk;
    }
}
