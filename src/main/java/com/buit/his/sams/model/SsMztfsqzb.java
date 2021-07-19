package com.buit.his.sams.model;

import com.buit.commons.PageQuery;
import io.swagger.annotations.ApiModelProperty;

import java.sql.Timestamp;

/**
 * 类名称：SsMztfsqzb<br> 
 * 类描述：门诊退费申请主表
 * @author zhouhaisheng
 * @ApiModel(value="门诊退费申请主表")
 */
public class SsMztfsqzb  extends  PageQuery{
	@ApiModelProperty(value="主键id")
    private Integer jlxh;
	@ApiModelProperty(value="机构id")
    private Integer jgid;
	@ApiModelProperty(value="手术科室代码")
    private Integer ssksdm;
	@ApiModelProperty(value="退费申请单号")
    private String tfsqdh;
	@ApiModelProperty(value="退费时间")
    private Timestamp tfsj;
	@ApiModelProperty(value="退费人代码")
    private Integer tfrdm;
	@ApiModelProperty(value="门诊号码")
    private Integer mzhm;
	@ApiModelProperty(value="记账单号")
    private String jzdh;

    /** 设置:主键id  */
    public void setJlxh(Integer value) {
        this.jlxh = value;
    }
    /** 获取:主键id */
    public Integer getJlxh() {
        return jlxh;
    }

    /** 设置:机构id  */
    public void setJgid(Integer value) {
        this.jgid = value;
    }
    /** 获取:机构id */
    public Integer getJgid() {
        return jgid;
    }

    /** 设置:手术科室代码  */
    public void setSsksdm(Integer value) {
        this.ssksdm = value;
    }
    /** 获取:手术科室代码 */
    public Integer getSsksdm() {
        return ssksdm;
    }

    /** 设置:退费申请单号  */
    public void setTfsqdh(String value) {
        this.tfsqdh = value;
    }
    /** 获取:退费申请单号 */
    public String getTfsqdh() {
        return tfsqdh;
    }

    /** 设置:退费时间  */
    public void setTfsj(Timestamp value) {
        this.tfsj = value;
    }
    /** 获取:退费时间 */
    public Timestamp getTfsj() {
        return tfsj;
    }

    /** 设置:退费人代码  */
    public void setTfrdm(Integer value) {
        this.tfrdm = value;
    }
    /** 获取:退费人代码 */
    public Integer getTfrdm() {
        return tfrdm;
    }

    /** 设置:门诊号码  */
    public void setMzhm(Integer value) {
        this.mzhm = value;
    }
    /** 获取:门诊号码 */
    public Integer getMzhm() {
        return mzhm;
    }

    /** 设置:记账单号  */
    public void setJzdh(String value) {
        this.jzdh = value;
    }
    /** 获取:记账单号 */
    public String getJzdh() {
        return jzdh;
    }


}