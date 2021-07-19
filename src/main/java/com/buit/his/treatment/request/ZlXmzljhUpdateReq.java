package com.buit.his.treatment.request;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import javax.validation.constraints.NotNull;

/**
 * 新增项目治疗计划入参
 * zhouhaisheng
 *
 */
@ApiModel(value = "新增项目治疗计划入参")
public class ZlXmzljhUpdateReq {
    @ApiModelProperty(value="主键id")
    private Integer jlxh;
    @ApiModelProperty(value="治疗科室代码")
    @NotNull(message = "治疗科室代码不能为空")
    private Integer zlksdm;
    @ApiModelProperty(value="治疗项目名称")
    private String zlxmmc;
    @ApiModelProperty(value="排序号")
    private Integer pxh;
    @ApiModelProperty(value="治疗频次")
    private String zlpc;
    @ApiModelProperty(value="时间")
    private String sj;
    @ApiModelProperty(value="用量")
    private String yl;
    @ApiModelProperty(value="治疗方法")
    private String zlff;
    @ApiModelProperty(value="治疗部位")
    private String zlbw;
    @ApiModelProperty(value="治疗措施")
    private String zlcs;
    @ApiModelProperty(value="备注")
    private String bzxx;
    @ApiModelProperty(value="治疗项目ID")
    @NotNull(message = "治疗项目ID不能为空")
    private Integer zlxmJlxh;

    public Integer getZlxmJlxh() {
        return zlxmJlxh;
    }

    public void setZlxmJlxh(Integer zlxmJlxh) {
        this.zlxmJlxh = zlxmJlxh;
    }

    public String getBzxx() {
        return bzxx;
    }

    public void setBzxx(String bzxx) {
        this.bzxx = bzxx;
    }

    public Integer getZlksdm() {
        return zlksdm;
    }

    public void setZlksdm(Integer zlksdm) {
        this.zlksdm = zlksdm;
    }

    public String getZlxmmc() {
        return zlxmmc;
    }

    public void setZlxmmc(String zlxmmc) {
        this.zlxmmc = zlxmmc;
    }

    public Integer getPxh() {
        return pxh;
    }

    public void setPxh(Integer pxh) {
        this.pxh = pxh;
    }

    public String getZlpc() {
        return zlpc;
    }

    public void setZlpc(String zlpc) {
        this.zlpc = zlpc;
    }

    public String getSj() {
        return sj;
    }

    public void setSj(String sj) {
        this.sj = sj;
    }

    public String getYl() {
        return yl;
    }

    public void setYl(String yl) {
        this.yl = yl;
    }

    public String getZlff() {
        return zlff;
    }

    public void setZlff(String zlff) {
        this.zlff = zlff;
    }

    public String getZlbw() {
        return zlbw;
    }

    public void setZlbw(String zlbw) {
        this.zlbw = zlbw;
    }

    public String getZlcs() {
        return zlcs;
    }

    public void setZlcs(String zlcs) {
        this.zlcs = zlcs;
    }

    public Integer getJlxh() {
        return jlxh;
    }

    public void setJlxh(Integer jlxh) {
        this.jlxh = jlxh;
    }
}
