package com.buit.his.treatment.response;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.sql.Timestamp;

/**
 * @Author weijing
 * @Date 2021-01-25 16:12
 * @Description
 **/
@ApiModel("治疗预约执行项目返回")
public class QueryZyzlZxDetailResp {
    @ApiModelProperty(value = "预约申请单明细ID（用作修改状态，时间时用）")
    private Integer sqdmxid;

    @ApiModelProperty(value = "住院号")
    private Integer zyh;

    @ApiModelProperty(value = "类型（1临时 2长期）")
    private String lx;

    @ApiModelProperty(value = "项目名称")
    private String zlxmmc;

    @ApiModelProperty(value = "数量")
    private String sl;

    @ApiModelProperty(value = "单位")
    private String dw;

    @ApiModelProperty(value = "频次")
    private String sypc;

    @ApiModelProperty(value = "开嘱时间")
    private Timestamp kzsj;

    @ApiModelProperty(value = "开嘱医生")
    private Integer kzys;

    @ApiModelProperty(value = "说明")
    private String sm;

    @ApiModelProperty(value = "是否预约 1预约 0未预约")
    private String sfyy;

    @ApiModelProperty(value = "状态0 未预约/1 部分预约/2 全部预约/3 部分执行/4 完成")
    private String zt;

    public Integer getZyh() {
        return zyh;
    }

    public void setZyh(Integer zyh) {
        this.zyh = zyh;
    }

    public Integer getSqdmxid() {
        return sqdmxid;
    }

    public void setSqdmxid(Integer sqdmxid) {
        this.sqdmxid = sqdmxid;
    }

    public String getLx() {
        return lx;
    }

    public void setLx(String lx) {
        this.lx = lx;
    }

    public String getZlxmmc() {
        return zlxmmc;
    }

    public void setZlxmmc(String zlxmmc) {
        this.zlxmmc = zlxmmc;
    }

    public String getSl() {
        return sl;
    }

    public void setSl(String sl) {
        this.sl = sl;
    }

    public String getDw() {
        return dw;
    }

    public void setDw(String dw) {
        this.dw = dw;
    }

    public String getSypc() {
        return sypc;
    }

    public void setSypc(String sypc) {
        this.sypc = sypc;
    }

    public Timestamp getKzsj() {
        return kzsj;
    }

    public void setKzsj(Timestamp kzsj) {
        this.kzsj = kzsj;
    }

    public Integer getKzys() {
        return kzys;
    }

    public void setKzys(Integer kzys) {
        this.kzys = kzys;
    }

    public String getSm() {
        return sm;
    }

    public void setSm(String sm) {
        this.sm = sm;
    }

    public String getSfyy() {
        return sfyy;
    }

    public void setSfyy(String sfyy) {
        this.sfyy = sfyy;
    }

    public String getZt() {
        return zt;
    }

    public void setZt(String zt) {
        this.zt = zt;
    }
}
