package com.buit.his.treatment.request;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.sql.Date;

/**
 * @Author weijing
 * @Date 2021-01-25 11:16
 * @Description
 **/
@ApiModel("住院治疗执行查询入参")
public class ImpleZyzlyyReq {
    @ApiModelProperty(value = "医疗机构代码",hidden = true)
    private Integer jgid;

    @ApiModelProperty(value = "当前科室（执行科室）",hidden = true)
    private Integer zxks;

    @ApiModelProperty(value = "诊疗类别")
    @NotNull(message = "诊疗类别不能为空")
    private Integer zllb;

    @ApiModelProperty(value = "治疗师代码(当选择我的患者时传,选择全部时不传)")
    private Integer zlsdm;

    @ApiModelProperty(value = "住院号码")
    private String zyhm;

    @ApiModelProperty(value = "病人病区")
    private Integer brbq;

    @ApiModelProperty(value = "病人姓名")
    private String brxm;

    @ApiModelProperty(value = "执行状态 0未执行 1已执行")
    private Integer zxzt;

    @ApiModelProperty(value = "执行日期 YYYY-MM-dd")
    @NotBlank(message = "执行日期不能为空")
    private String zxrq;

    @ApiModelProperty(value = "病人情况 1新病人 2需要阶段小结")
    private Integer brqk;

    public Integer getJgid() {
        return jgid;
    }

    public void setJgid(Integer jgid) {
        this.jgid = jgid;
    }

    public Integer getZxks() {
        return zxks;
    }

    public void setZxks(Integer zxks) {
        this.zxks = zxks;
    }

    public Integer getZllb() {
        return zllb;
    }

    public void setZllb(Integer zllb) {
        this.zllb = zllb;
    }

    public Integer getZlsdm() {
        return zlsdm;
    }

    public void setZlsdm(Integer zlsdm) {
        this.zlsdm = zlsdm;
    }

    public String getZyhm() {
        return zyhm;
    }

    public void setZyhm(String zyhm) {
        this.zyhm = zyhm;
    }

    public Integer getBrbq() {
        return brbq;
    }

    public void setBrbq(Integer brbq) {
        this.brbq = brbq;
    }

    public String getBrxm() {
        return brxm;
    }

    public void setBrxm(String brxm) {
        this.brxm = brxm;
    }

    public Integer getZxzt() {
        return zxzt;
    }

    public void setZxzt(Integer zxzt) {
        this.zxzt = zxzt;
    }

    public String getZxrq() {
        return zxrq;
    }

    public void setZxrq(String zxrq) {
        this.zxrq = zxrq;
    }

    public Integer getBrqk() {
        return brqk;
    }

    public void setBrqk(Integer brqk) {
        this.brqk = brqk;
    }
}
