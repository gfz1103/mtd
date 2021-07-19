package com.buit.his.sams.request;

import com.buit.commons.PageQuery;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.sql.Timestamp;


/**
 * 类名称：SsZytfsqzb<br>
 * 类描述：住院退费申请主表<br>
 * @author zhouhaisheng
 */
@ApiModel(value="住院退费申请主表")
public class SsZytfsqzbReq  extends  PageQuery{
    @ApiModelProperty(value="主键id")
    private Integer jlxh;
    @ApiModelProperty(value="医疗机构id ")
    private Integer jgid;
    @ApiModelProperty(value="手术科室代码")
    private Integer ssksdm;
    @ApiModelProperty(value="退费申请单号")
    private String tfsqdh;
    @ApiModelProperty(value="退费时间")
    private Timestamp tfsj;
    @ApiModelProperty(value="退费人代码")
    private Integer tfrdm;
    @ApiModelProperty(value="住院号码")
    private String zyhm;
    @ApiModelProperty(value="科室代码 ")
    private Integer ksdm;
    @ApiModelProperty(value="病区代码")
    private Integer bqdm;
    @ApiModelProperty(value="病人床号")
    private String brch;
    @ApiModelProperty(value="记账单号")
    private String jzdh;
    @ApiModelProperty(value="0 未确认/1 已确认")
    private String zt;
    /**
     * 设置:主键id
     */
    public void setJlxh(Integer value) {
        this.jlxh = value;
    }
    /**
     * 获取:主键id
     */
    public Integer getJlxh() {
        return jlxh;
    }
    /**
     * 设置:医疗机构id 
     */
    public void setJgid(Integer value) {
        this.jgid = value;
    }
    /**
     * 获取:医疗机构id 
     */
    public Integer getJgid() {
        return jgid;
    }
    /**
     * 设置:手术科室代码
     */
    public void setSsksdm(Integer value) {
        this.ssksdm = value;
    }
    /**
     * 获取:手术科室代码
     */
    public Integer getSsksdm() {
        return ssksdm;
    }
    /**
     * 设置:退费申请单号
     */
    public void setTfsqdh(String value) {
        this.tfsqdh = value;
    }
    /**
     * 获取:退费申请单号
     */
    public String getTfsqdh() {
        return tfsqdh;
    }
    /**
     * 设置:退费时间
     */
    public void setTfsj(Timestamp value) {
        this.tfsj = value;
    }
    /**
     * 获取:退费时间
     */
    public Timestamp getTfsj() {
        return tfsj;
    }
    /**
     * 设置:退费人代码
     */
    public void setTfrdm(Integer value) {
        this.tfrdm = value;
    }
    /**
     * 获取:退费人代码
     */
    public Integer getTfrdm() {
        return tfrdm;
    }
    /**
     * 设置:住院号码
     */
    public void setZyhm(String value) {
        this.zyhm = value;
    }
    /**
     * 获取:住院号码
     */
    public String getZyhm() {
        return zyhm;
    }
    /**
     * 设置:科室代码 
     */
    public void setKsdm(Integer value) {
        this.ksdm = value;
    }
    /**
     * 获取:科室代码 
     */
    public Integer getKsdm() {
        return ksdm;
    }
    /**
     * 设置:病区代码
     */
    public void setBqdm(Integer value) {
        this.bqdm = value;
    }
    /**
     * 获取:病区代码
     */
    public Integer getBqdm() {
        return bqdm;
    }
    /**
     * 设置:病人床号
     */
    public void setBrch(String value) {
        this.brch = value;
    }
    /**
     * 获取:病人床号
     */
    public String getBrch() {
        return brch;
    }
    /**
     * 设置:记账单号
     */
    public void setJzdh(String value) {
        this.jzdh = value;
    }
    /**
     * 获取:记账单号
     */
    public String getJzdh() {
        return jzdh;
    }
    /**
     * 设置:0 未确认/1 已确认
     */
    public void setZt(String value) {
        this.zt = value;
    }
    /**
     * 获取:0 未确认/1 已确认
     */
    public String getZt() {
        return zt;
    }
}