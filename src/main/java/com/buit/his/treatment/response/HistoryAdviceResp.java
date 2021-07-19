package com.buit.his.treatment.response;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.math.BigDecimal;
import java.sql.Timestamp;

/**
 * @Author jiangwei
 * @Date 2021-07-5
 **/
@ApiModel("查询住院康复治疗记录患者列表返回参数")
public class HistoryAdviceResp {
    @ApiModelProperty(value = "治疗任务分配id")
    private Integer zlrwfpid;

    @ApiModelProperty(value = "住院号")
    private Integer zyh;

    @ApiModelProperty(value = "收费项目代码")
    private Integer sfxmdm;

    @ApiModelProperty(value = "收费项目名称")
    private String sfxmmc;

    @ApiModelProperty(value = "治疗师")
    private Integer zlsdm;

    @ApiModelProperty(value = "开嘱时间")
    private Timestamp kssj;

    @ApiModelProperty(value = "停嘱时间")
    private Timestamp tzsj;

    @ApiModelProperty(value = "执行次数")
    private BigDecimal fysl;

    @ApiModelProperty(value = "总计金额")
    private BigDecimal zjje;

    @ApiModelProperty(value = "临时医嘱 | 0：长期    1：临时")
    private Integer lsyz;

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

    public Integer getZlsdm() {
        return zlsdm;
    }

    public void setZlsdm(Integer zlsdm) {
        this.zlsdm = zlsdm;
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

    public BigDecimal getFysl() {
        return fysl;
    }

    public void setFysl(BigDecimal fysl) {
        this.fysl = fysl;
    }

    public BigDecimal getZjje() {
        return zjje;
    }

    public void setZjje(BigDecimal zjje) {
        this.zjje = zjje;
    }

    public Integer getLsyz() {
        return lsyz;
    }

    public void setLsyz(Integer lsyz) {
        this.lsyz = lsyz;
    }

    public String getSypc() {
        return sypc;
    }

    public void setSypc(String sypc) {
        this.sypc = sypc;
    }
}
