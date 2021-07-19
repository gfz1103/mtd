package com.buit.his.treatment.request;

import com.buit.commons.PageQuery;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import javax.validation.constraints.NotNull;

/**
 * 病人治疗预约查询入参
 * zhouhaisheng
 */
@ApiModel(value = "病人治疗预约查询入参")
public class PatientZlyyQueryRep extends PageQuery {

    @ApiModelProperty(value="医疗机构代码",hidden = true)
    private Integer jgid;
    @ApiModelProperty(value="治疗科室代码")
    @NotNull(message = "治疗科室代码不能为空")
    private Integer zlksdm;
    @ApiModelProperty(value="病人类型  1 门诊/2 住院")
    private String brlx;
    @ApiModelProperty(value="门诊号/住院号码")
    private Integer hm;
    @ApiModelProperty(value="状态 -1:全部")
    private Integer zt;
    @ApiModelProperty(value="病区代码")
    private Integer bqdm;
    @ApiModelProperty(value="科室代码")
    private Integer ksdm;
    @ApiModelProperty(value="病人床号")
    private String brch;
    @ApiModelProperty(value="卡号")
    private String kh;
    @ApiModelProperty(value="发票号码")
    private String fphm;
    @ApiModelProperty(value = "开始时间")
    private String startDate;
    @ApiModelProperty(value = "结束时间")
    private String endDate;
    @ApiModelProperty(value = "病人姓名")
    private String brxm;
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

    public String getBrlx() {
        return brlx;
    }

    public void setBrlx(String brlx) {
        this.brlx = brlx;
    }

    public Integer getHm() {
        return hm;
    }

    public void setHm(Integer hm) {
        this.hm = hm;
    }

    public Integer getBqdm() {
        return bqdm;
    }

    public void setBqdm(Integer bqdm) {
        this.bqdm = bqdm;
    }

    public Integer getKsdm() {
        return ksdm;
    }

    public void setKsdm(Integer ksdm) {
        this.ksdm = ksdm;
    }

    public String getBrch() {
        return brch;
    }

    public void setBrch(String brch) {
        this.brch = brch;
    }

    public String getKh() {
        return kh;
    }

    public void setKh(String kh) {
        this.kh = kh;
    }

    public String getFphm() {
        return fphm;
    }

    public void setFphm(String fphm) {
        this.fphm = fphm;
    }

    public String getStartDate() {
        return startDate;
    }

    public void setStartDate(String startDate) {
        this.startDate = startDate;
    }

    public String getEndDate() {
        return endDate;
    }

    public void setEndDate(String endDate) {
        this.endDate = endDate;
    }

    public Integer getZt() {
        return zt;
    }

    public void setZt(Integer zt) {
        this.zt = zt;
    }

    public String getBrxm() {
        return brxm;
    }

    public void setBrxm(String brxm) {
        this.brxm = brxm;
    }
}
