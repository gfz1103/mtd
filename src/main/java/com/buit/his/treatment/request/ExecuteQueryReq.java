package com.buit.his.treatment.request;

import com.buit.commons.PageQuery;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import javax.validation.constraints.NotNull;

/**
 * @author 蒋威
 * @Date 2021-03-26
 */
@ApiModel("查询住院治疗执行患者入参")
public class ExecuteQueryReq extends PageQuery {
    @ApiModelProperty(value = "医疗机构id", hidden = true)
    private Integer jgid;

    @NotNull
    @ApiModelProperty(value = "治疗科室代码")
    private Integer zlksdm;

    @ApiModelProperty(value = "治疗师代码", hidden = true)
    private Integer zlsdm;

    @ApiModelProperty(value = "查询模式 | 0：全部    1：我的病人")
    private Integer type;

    @NotNull
    @ApiModelProperty(value = "诊疗类别")
    private Integer zllb;

    @ApiModelProperty(value = "病人病区")
    private Integer brbq;

    @ApiModelProperty(value = "病人床号")
    private String brch;


    @ApiModelProperty(value = "病人姓名")
    private String brxm;

    @ApiModelProperty(value = "住院号码")
    private String zyhm;

    @ApiModelProperty(value = "执行状态 | 0：未执行    2：已执行")
    private Integer zxzt;

    @NotNull
    @ApiModelProperty(value = "执行日期")
    private String zxrq;

    @ApiModelProperty(value = "患者情况 | 0：全部    1：新病人    2：需要阶段小结")
    private Integer hzqk;

    public Integer getJgid() {
        return jgid;
    }

    public void setJgid(Integer jgid) {
        this.jgid = jgid;
    }

    public Integer getZlksdm() {
        return zlksdm;
    }

    public void setZlksdm(Integer zlksdm) {
        this.zlksdm = zlksdm;
    }

    public Integer getZlsdm() {
        return zlsdm;
    }

    public void setZlsdm(Integer zlsdm) {
        this.zlsdm = zlsdm;
    }

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }

    public Integer getZllb() {
        return zllb;
    }

    public void setZllb(Integer zllb) {
        this.zllb = zllb;
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

    public String getBrxm() {
        return brxm;
    }

    public void setBrxm(String brxm) {
        this.brxm = brxm;
    }

    public String getZyhm() {
        return zyhm;
    }

    public void setZyhm(String zyhm) {
        this.zyhm = zyhm;
    }

    public String getZxrq() {
        return zxrq;
    }

    public void setZxrq(String zxrq) {
        this.zxrq = zxrq;
    }

    public Integer getHzqk() {
        return hzqk;
    }

    public void setHzqk(Integer hzqk) {
        this.hzqk = hzqk;
    }

    public Integer getZxzt() {
        return zxzt;
    }

    public void setZxzt(Integer zxzt) {
        this.zxzt = zxzt;
    }
}
