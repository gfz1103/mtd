package com.buit.his.sams.response;

import com.buit.commons.PageQuery;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.sql.Timestamp;


/**
 * 类名称：SsSsjzdzb<br>
 * 类描述：手术记账单主表<br>
 * @author zhouhaisheng
 */
@ApiModel(value="手术记账单主表")
public class SsSsjzdzbResp  extends  PageQuery{
    @ApiModelProperty(value="主键id")
    private Integer jlxh;
    @ApiModelProperty(value="医疗机构id")
    private Integer jgid;
    @ApiModelProperty(value = "手术科室代码")
    private Integer ssksdm;
    @ApiModelProperty(value = "1 手术记账/2 麻醉记账")
    private Integer jzlx;
    @ApiModelProperty(value = "记账单号 ")
    private String jzdh;
    @ApiModelProperty(value="1 门诊/2 住院")
    private String brlx;
    @ApiModelProperty(value="门诊号码")
    private Integer mzhm;
    @ApiModelProperty(value="住院号码 ")
    private String zyhm;
    @ApiModelProperty(value="科室代码 ")
    private Integer ksdm;
    @ApiModelProperty(value="病区代码")
    private Integer bqdm;
    @ApiModelProperty(value="病人床号")
    private String brch;
    @ApiModelProperty(value="手术 申请单号")
    private String sssqdh;
    @ApiModelProperty(value="记账人")
    private Integer jzrdm;
    @ApiModelProperty(value="记账时间")
    private Timestamp jzsj;
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
     * 设置:1 手术记账/2 麻醉记账
     */
    public void setJzlx(Integer value) {
        this.jzlx = value;
    }

    /**
     * 获取:1 手术记账/2 麻醉记账
     */
    public Integer getJzlx() {
        return jzlx;
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
     * 设置:1 门诊/2 住院
     */
    public void setBrlx(String value) {
        this.brlx = value;
    }
    /**
     * 获取:1 门诊/2 住院
     */
    public String getBrlx() {
        return brlx;
    }
    /**
     * 设置:门诊号码
     */
    public void setMzhm(Integer value) {
        this.mzhm = value;
    }
    /**
     * 获取:门诊号码
     */
    public Integer getMzhm() {
        return mzhm;
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
     * 设置:手术 申请单号
     */
    public void setSssqdh(String value) {
        this.sssqdh = value;
    }
    /**
     * 获取:手术 申请单号
     */
    public String getSssqdh() {
        return sssqdh;
    }
    /**
     * 设置:记账人
     */
    public void setJzrdm(Integer value) {
        this.jzrdm = value;
    }
    /**
     * 获取:记账人
     */
    public Integer getJzrdm() {
        return jzrdm;
    }
    /**
     * 设置:记账时间
     */
    public void setJzsj(Timestamp value) {
        this.jzsj = value;
    }
    /**
     * 获取:记账时间
     */
    public Timestamp getJzsj() {
        return jzsj;
    }
}