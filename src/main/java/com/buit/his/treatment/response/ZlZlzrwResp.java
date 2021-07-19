package com.buit.his.treatment.response;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.math.BigDecimal;
import java.sql.Timestamp;

/**
 * @Author jiangwei
 * @Date 2021-03-27 15:10
 */
@ApiModel("查询住院治疗患者子任务列表返回结果")
public class ZlZlzrwResp {
    @ApiModelProperty(value = "记录序号")
    private Integer jlxh;
    @ApiModelProperty(value = "住院号")
    private Integer zyh;
    @ApiModelProperty(value = "任务分配主键")
    private Integer zlrwfpId;
    @ApiModelProperty(value = "执行状态 | 0：未执行    2：已执行")
    private Integer zxzt;
    @ApiModelProperty(value = "临时医嘱 | 0：长期医嘱    1：临时医嘱")
    private Integer lsyz;
    @ApiModelProperty(value = "收费项目代码")
    private Integer sfxmdm;
    @ApiModelProperty(value = "收费项目名称")
    private String sfxmmc;
    @ApiModelProperty(value = "数量")
    private BigDecimal sl;
    @ApiModelProperty(value = "金额")
    private BigDecimal je;
    @ApiModelProperty(value = "单位")
    private String dw;
    @ApiModelProperty(value = "频次")
    private String pc;
    @ApiModelProperty(value = "开嘱时间")
    private Timestamp kzsj;
    @ApiModelProperty(value = "停嘱时间")
    private Timestamp tzsj;
    @ApiModelProperty(value = "执行时间")
    private Timestamp zxsj;
    @ApiModelProperty(value = "预约工号")
    private Integer yygh;
    @ApiModelProperty(value = "执行工号")
    private Integer zxgh;
    @ApiModelProperty(value = "医嘱备注信息")
    private String bzxx;
    @ApiModelProperty(value = "补记账次数")
    private Integer bjzcs;
    @ApiModelProperty(value = "补记账金额")
    private Integer bjzfy;

    public Integer getJlxh() {
        return jlxh;
    }

    public void setJlxh(Integer jlxh) {
        this.jlxh = jlxh;
    }

    public Integer getZyh() {
        return zyh;
    }

    public void setZyh(Integer zyh) {
        this.zyh = zyh;
    }

    public Integer getZlrwfpId() {
        return zlrwfpId;
    }

    public void setZlrwfpId(Integer zlrwfpId) {
        this.zlrwfpId = zlrwfpId;
    }

    public Integer getZxzt() {
        return zxzt;
    }

    public void setZxzt(Integer zxzt) {
        this.zxzt = zxzt;
    }

    public Integer getLsyz() {
        return lsyz;
    }

    public void setLsyz(Integer lsyz) {
        this.lsyz = lsyz;
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

    public String getDw() {
        return dw;
    }

    public void setDw(String dw) {
        this.dw = dw;
    }

    public String getPc() {
        return pc;
    }

    public void setPc(String pc) {
        this.pc = pc;
    }

    public Timestamp getKzsj() {
        return kzsj;
    }

    public void setKzsj(Timestamp kzsj) {
        this.kzsj = kzsj;
    }

    public Integer getYygh() {
        return yygh;
    }

    public void setYygh(Integer yygh) {
        this.yygh = yygh;
    }

    public Integer getZxgh() {
        return zxgh;
    }

    public void setZxgh(Integer zxgh) {
        this.zxgh = zxgh;
    }

    public String getBzxx() {
        return bzxx;
    }

    public void setBzxx(String bzxx) {
        this.bzxx = bzxx;
    }

    public Timestamp getZxsj() {
        return zxsj;
    }

    public void setZxsj(Timestamp zxsj) {
        this.zxsj = zxsj;
    }

    public Integer getBjzcs() {
        return bjzcs;
    }

    public void setBjzcs(Integer bjzcs) {
        this.bjzcs = bjzcs;
    }

    public Integer getBjzfy() {
        return bjzfy;
    }

    public void setBjzfy(Integer bjzfy) {
        this.bjzfy = bjzfy;
    }

    public Timestamp getTzsj() {
        return tzsj;
    }

    public void setTzsj(Timestamp tzsj) {
        this.tzsj = tzsj;
    }
}
