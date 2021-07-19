package com.buit.his.treatment.response;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.math.BigDecimal;
import java.sql.Timestamp;

/**
 * @Author jiangwei
 * @Date 2021-03-19 14:24
 * @Description
 **/
@ApiModel("查询住院康复治疗医嘱")
public class ZlRwfpResp {
    @ApiModelProperty(value = "康复治疗任务分配ID")
    private Integer zlrwfpid;
    @ApiModelProperty(value = "住院号")
    private Integer zyh;
    @ApiModelProperty(value = "医嘱记录序号")
    private Integer yzJlxh;
    @ApiModelProperty(value = "诊疗类别")
    private Integer zllb;
    @ApiModelProperty(value = "分配状态 | 0：未分配    2：已分配")
    private Integer fpzt;
    @ApiModelProperty(value = "治疗组ID")
    private Integer zlzid;
    @ApiModelProperty(value = "治疗师代码")
    private Integer zlsdm;
    @ApiModelProperty(value = "分配时间")
    private Timestamp fpsj;
    @ApiModelProperty(value = "治疗科室代码")
    private Integer zlksdm;
    @ApiModelProperty(value = "收费项目代码")
    private Integer sfxmdm;
    @ApiModelProperty(value = "收费项目名称")
    private String sfxmmc;
    @ApiModelProperty(value = "数量")
    private BigDecimal sl;
    @ApiModelProperty(value = "金额")
    private BigDecimal je;
    @ApiModelProperty(value = "临时医嘱 | 0：长期医嘱    1：临时医嘱")
    private Integer lsyz;
    @ApiModelProperty(value = "执行状态 | 0：未执行    1：部分执行    2：已执行")
    private Integer zxzt;
    @ApiModelProperty(value = "下次执行日期 | 定时任务下次启动日期")
    private String xczxrq;
    @ApiModelProperty(value = "开嘱时间")
    private Timestamp kssj;
    @ApiModelProperty(value = "停嘱时间")
    private Timestamp tzsj;
    @ApiModelProperty(value = "使用频次")
    private String sypc;

    public Integer getZlrwfpid() {
        return zlrwfpid;
    }

    public void setZlrwfpid(Integer zlrwfpid) {
        this.zlrwfpid = zlrwfpid;
    }

    public Integer getZyh() {
        return zyh;
    }

    public void setZyh(Integer zyh) {
        this.zyh = zyh;
    }

    public Integer getYzJlxh() {
        return yzJlxh;
    }

    public void setYzJlxh(Integer yzJlxh) {
        this.yzJlxh = yzJlxh;
    }

    public Integer getZllb() {
        return zllb;
    }

    public void setZllb(Integer zllb) {
        this.zllb = zllb;
    }

    public Integer getFpzt() {
        return fpzt;
    }

    public void setFpzt(Integer fpzt) {
        this.fpzt = fpzt;
    }

    public Integer getZlzid() {
        return zlzid;
    }

    public void setZlzid(Integer zlzid) {
        this.zlzid = zlzid;
    }

    public Integer getZlsdm() {
        return zlsdm;
    }

    public void setZlsdm(Integer zlsdm) {
        this.zlsdm = zlsdm;
    }

    public Timestamp getFpsj() {
        return fpsj;
    }

    public void setFpsj(Timestamp fpsj) {
        this.fpsj = fpsj;
    }

    public Integer getZlksdm() {
        return zlksdm;
    }

    public void setZlksdm(Integer zlksdm) {
        this.zlksdm = zlksdm;
    }

    public Integer getSfxmdm() {
        return sfxmdm;
    }

    public void setSfxmdm(Integer sfxmdm) {
        this.sfxmdm = sfxmdm;
    }

    public String getSfxmmc() {
        return sfxmmc;
    }

    public void setSfxmmc(String sfxmmc) {
        this.sfxmmc = sfxmmc;
    }

    public BigDecimal getSl() {
        return sl;
    }

    public void setSl(BigDecimal sl) {
        this.sl = sl;
    }

    public BigDecimal getJe() {
        return je;
    }

    public void setJe(BigDecimal je) {
        this.je = je;
    }

    public Integer getYslz() {
        return lsyz;
    }

    public void setYslz(Integer lsyz) {
        this.lsyz = lsyz;
    }

    public Integer getLsyz() {
        return lsyz;
    }

    public void setLsyz(Integer lsyz) {
        this.lsyz = lsyz;
    }

    public Integer getZxzt() {
        return zxzt;
    }

    public void setZxzt(Integer zxzt) {
        this.zxzt = zxzt;
    }

    public Timestamp getKssj() {
        return kssj;
    }

    public void setKssj(Timestamp kssj) {
        this.kssj = kssj;
    }

    public Timestamp getTzsj() {
        return tzsj;
    }

    public void setTzsj(Timestamp tzsj) {
        this.tzsj = tzsj;
    }

    public String getSypc() {
        return sypc;
    }

    public void setSypc(String sypc) {
        this.sypc = sypc;
    }

    public String getXczxrq() {
        return xczxrq;
    }

    public void setXczxrq(String xczxrq) {
        this.xczxrq = xczxrq;
    }
}
