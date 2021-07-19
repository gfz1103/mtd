package com.buit.his.treatment.request;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.math.BigDecimal;


/**
 * 类名称：ZlSqdmx<br>
 * 类描述：治疗申请单明细修改入参<br>
 * @author ZHOUHAISHENG
 */
@ApiModel(value="治疗申请单明细修改入参")
public class ZlSqdmxUpdateReq {
    @ApiModelProperty(value="主键id")
    private Integer jlxh;
    @ApiModelProperty(value="治疗申请单号")
    private String zlsqdh;
    @ApiModelProperty(value="序号")
    private Integer xh;
    @ApiModelProperty(value="治疗项目名称")
    private String zlxmmc;
    @ApiModelProperty(value="疗程次数")
    private Integer zxlc;
    @ApiModelProperty(value="执行间隔")
    private Integer lccs;
    @ApiModelProperty(value="执行间隔")
    private Integer zxjg;
    @ApiModelProperty(value="数量")
    private BigDecimal sl;
    @ApiModelProperty(value="单价")
    private BigDecimal dj;
    @ApiModelProperty(value="金额")
    private BigDecimal je;
    @ApiModelProperty(value="治疗目标")
    private String zlmb;
    @ApiModelProperty(value="注意事项")
    private String zysx;
    @ApiModelProperty(value="治疗项目的记录序号")
    private Integer zlxmJlxh;
    public Integer getXh() {
        return xh;
    }

    public void setXh(Integer xh) {
        this.xh = xh;
    }

    public String getZlxmmc() {
        return zlxmmc;
    }

    public void setZlxmmc(String zlxmmc) {
        this.zlxmmc = zlxmmc;
    }

    public Integer getZxlc() {
        return zxlc;
    }

    public void setZxlc(Integer zxlc) {
        this.zxlc = zxlc;
    }

    public Integer getLccs() {
        return lccs;
    }

    public void setLccs(Integer lccs) {
        this.lccs = lccs;
    }

    public Integer getZxjg() {
        return zxjg;
    }

    public void setZxjg(Integer zxjg) {
        this.zxjg = zxjg;
    }

    public BigDecimal getSl() {
        return sl;
    }

    public void setSl(BigDecimal sl) {
        this.sl = sl;
    }

    public BigDecimal getDj() {
        return dj;
    }

    public void setDj(BigDecimal dj) {
        this.dj = dj;
    }

    public BigDecimal getJe() {
        return je;
    }

    public void setJe(BigDecimal je) {
        this.je = je;
    }

    public String getZlmb() {
        return zlmb;
    }

    public void setZlmb(String zlmb) {
        this.zlmb = zlmb;
    }

    public String getZysx() {
        return zysx;
    }

    public void setZysx(String zysx) {
        this.zysx = zysx;
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

    public Integer getZlxmJlxh() {
        return zlxmJlxh;
    }

    public void setZlxmJlxh(Integer zlxmJlxh) {
        this.zlxmJlxh = zlxmJlxh;
    }
}