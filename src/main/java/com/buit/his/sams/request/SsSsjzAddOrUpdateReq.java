package com.buit.his.sams.request;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import javax.validation.constraints.NotNull;
import java.util.List;


/**
 * 类名称：SsSsjzdzb<br>
 * 类描述：手术、麻醉记账<br>
 *
 * @author zhouhaisheng
 */
@ApiModel(value = "手术、麻醉记账")
public class SsSsjzAddOrUpdateReq {
    @ApiModelProperty(value = "主键id")
    private Integer jlxh;
    @ApiModelProperty(value = "医疗机构id", hidden = true)
    private Integer jgid;
    @ApiModelProperty(value = "手术科室代码")
    private Integer ssksdm;
    @ApiModelProperty(value = "1 手术记账/2 麻醉记账")
    private Integer jzlx;
    @ApiModelProperty(value = "记账单号 ")
    private Integer jzdh;
    @ApiModelProperty(value = "1 门诊/2 住院")
    private String brlx;
    @ApiModelProperty(value = "门诊号码")
    private Integer mzhm;
    @ApiModelProperty(value = "住院号码 ")
    private String zyhm;
    @ApiModelProperty(value = "科室代码 ")
    private Integer ksdm;
    @ApiModelProperty(value = "病区代码")
    private Integer bqdm;
    @ApiModelProperty(value = "病人床号")
    private String brch;
    @NotNull
    @ApiModelProperty(value = "手术 申请单号")
    private Integer sqdh;
    @ApiModelProperty(value = "住院号")
    private Integer zyh;
    @ApiModelProperty(value = "记账单明细")
    List<SsSsjzdmxAddOrUpdateReq> ssSsjzdmxAddOrUpdateReqs;


    public Integer getZyh() {
        return zyh;
    }

    public void setZyh(Integer zyh) {
        this.zyh = zyh;
    }

    public Integer getJgid() {
        return jgid;
    }

    public void setJgid(Integer jgid) {
        this.jgid = jgid;
    }

    public Integer getSsksdm() {
        return ssksdm;
    }

    public void setSsksdm(Integer ssksdm) {
        this.ssksdm = ssksdm;
    }

    public Integer getJzlx() {
        return jzlx;
    }

    public void setJzlx(Integer jzlx) {
        this.jzlx = jzlx;
    }

    public Integer getJzdh() {
        return jzdh;
    }

    public void setJzdh(Integer jzdh) {
        this.jzdh = jzdh;
    }

    public String getBrlx() {
        return brlx;
    }

    public void setBrlx(String brlx) {
        this.brlx = brlx;
    }

    public Integer getMzhm() {
        return mzhm;
    }

    public void setMzhm(Integer mzhm) {
        this.mzhm = mzhm;
    }

    public String getZyhm() {
        return zyhm;
    }

    public void setZyhm(String zyhm) {
        this.zyhm = zyhm;
    }

    public Integer getKsdm() {
        return ksdm;
    }

    public void setKsdm(Integer ksdm) {
        this.ksdm = ksdm;
    }

    public Integer getBqdm() {
        return bqdm;
    }

    public void setBqdm(Integer bqdm) {
        this.bqdm = bqdm;
    }

    public String getBrch() {
        return brch;
    }

    public void setBrch(String brch) {
        this.brch = brch;
    }

    public Integer getSqdh() {
        return sqdh;
    }

    public void setSqdh(Integer sqdh) {
        this.sqdh = sqdh;
    }

    public List<SsSsjzdmxAddOrUpdateReq> getSsSsjzdmxAddOrUpdateReqs() {
        return ssSsjzdmxAddOrUpdateReqs;
    }

    public void setSsSsjzdmxAddOrUpdateReqs(List<SsSsjzdmxAddOrUpdateReq> ssSsjzdmxAddOrUpdateReqs) {
        this.ssSsjzdmxAddOrUpdateReqs = ssSsjzdmxAddOrUpdateReqs;
    }

    public Integer getJlxh() {
        return jlxh;
    }

    public void setJlxh(Integer jlxh) {
        this.jlxh = jlxh;
    }

}