package com.buit.his.treatment.response;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.sql.Timestamp;

/**
 * 病人治疗申请分页查询出参
 * zhouhaisheng
 */
@ApiModel(value = "病人治疗申请分页查询出参")
public class ZlSqdzbPageResp {

    @ApiModelProperty(value = "主键id")
    private Integer jlxh;
    @ApiModelProperty(value = "申请时间")
    private Timestamp sqsj;
    @ApiModelProperty(value = "申请内容")
    private String zlxmmc;
    @ApiModelProperty(value = "科室代码")
    private Integer ksdm;
    @ApiModelProperty(value = "申请医生工号")
    private Integer sqysgh;
    @ApiModelProperty(value = "状态 0 未预约(新开) 1 部分预约2 全部预约3 部分执行4 完成")
    private Integer zt;
    @ApiModelProperty(value = "发票号码")
    private String fphm;
    @ApiModelProperty(value = "接收时间")
    private Timestamp jssj;
    @ApiModelProperty(value = "接收医生")
    private Integer jsgh;
    @ApiModelProperty(value = "作废标志 0未作废 1已作废")
    private String zf;
    @ApiModelProperty(value = "治疗科室代码")
    private Integer zlksdm;
    @ApiModelProperty(value = "收费状态")
    private String sfzt;


    public String getSfzt() {
        return sfzt;
    }

    public void setSfzt(String sfzt) {
        this.sfzt = sfzt;
    }

    public Integer getZlksdm() {
        return zlksdm;
    }

    public void setZlksdm(Integer zlksdm) {
        this.zlksdm = zlksdm;
    }

    public Integer getJlxh() {
        return jlxh;
    }

    public void setJlxh(Integer jlxh) {
        this.jlxh = jlxh;
    }

    public Timestamp getSqsj() {
        return sqsj;
    }

    public void setSqsj(Timestamp sqsj) {
        this.sqsj = sqsj;
    }

    public String getZlxmmc() {
        return zlxmmc;
    }

    public void setZlxmmc(String zlxmmc) {
        this.zlxmmc = zlxmmc;
    }

    public Integer getKsdm() {
        return ksdm;
    }

    public void setKsdm(Integer ksdm) {
        this.ksdm = ksdm;
    }

    public Integer getSqysgh() {
        return sqysgh;
    }

    public void setSqysgh(Integer sqysgh) {
        this.sqysgh = sqysgh;
    }

    public Integer getZt() {
        return zt;
    }

    public void setZt(Integer zt) {
        this.zt = zt;
    }

    public String getFphm() {
        return fphm;
    }

    public void setFphm(String fphm) {
        this.fphm = fphm;
    }

    public Timestamp getJssj() {
        return jssj;
    }

    public void setJssj(Timestamp jssj) {
        this.jssj = jssj;
    }

    public Integer getJsgh() {
        return jsgh;
    }

    public void setJsgh(Integer jsgh) {
        this.jsgh = jsgh;
    }

    public String getZf() {
        return zf;
    }

    public void setZf(String zf) {
        this.zf = zf;
    }
}
