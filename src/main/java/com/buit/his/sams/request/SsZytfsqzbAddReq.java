package com.buit.his.sams.request;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.sql.Timestamp;
import java.util.List;


/**
 * 类名称：SsZytfsqzb<br>
 * 类描述：新增住院退费申请入参<br>
 * @author zhouhaisheng
 */
@ApiModel(value="新增住院退费申请入参")
public class SsZytfsqzbAddReq {
    @ApiModelProperty(value="主键id",hidden = true)
    private Integer jlxh;
    @ApiModelProperty(value="机构id",hidden = true)
    private Integer jgid;
    @ApiModelProperty(value="手术科室代码")
    private Integer ssksdm;
    @ApiModelProperty(value="退费时间")
    private Timestamp tfsj;
    @ApiModelProperty(value="住院号码")
    private String zyhm;
    @ApiModelProperty(value="科室代码 ")
    private Integer ksdm;
    @ApiModelProperty(value="病区代码")
    private Integer bqdm;
    @ApiModelProperty(value="病人床号")
    private String brch;
    @ApiModelProperty(value="记账单号")
    private Integer jzdh;
    @ApiModelProperty(value="退费明细List")
    private List<SsZytfsqmxReq> ssZytfsqmxReqList;

    public Integer getSsksdm() {
        return ssksdm;
    }

    public void setSsksdm(Integer ssksdm) {
        this.ssksdm = ssksdm;
    }

    public Timestamp getTfsj() {
        return tfsj;
    }

    public void setTfsj(Timestamp tfsj) {
        this.tfsj = tfsj;
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

    public Integer getJzdh() {
        return jzdh;
    }

    public void setJzdh(Integer jzdh) {
        this.jzdh = jzdh;
    }

    public List<SsZytfsqmxReq> getSsZytfsqmxReqList() {
        return ssZytfsqmxReqList;
    }

    public void setSsZytfsqmxReqList(List<SsZytfsqmxReq> ssZytfsqmxReqList) {
        this.ssZytfsqmxReqList = ssZytfsqmxReqList;
    }

    public Integer getJgid() {
        return jgid;
    }

    public void setJgid(Integer jgid) {
        this.jgid = jgid;
    }

    public Integer getJlxh() {
        return jlxh;
    }

    public void setJlxh(Integer jlxh) {
        this.jlxh = jlxh;
    }
}