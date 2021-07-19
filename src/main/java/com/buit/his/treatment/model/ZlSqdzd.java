package com.buit.his.treatment.model;

import com.buit.commons.PageQuery;
import io.swagger.annotations.ApiModelProperty;

/**
 * 类名称：ZlSqdzd<br> 
 * 类描述：治疗申请单诊断表
 * @author ZHOUHAISHENG 
 * @ApiModel(value="治疗申请单诊断表")
 */
public class ZlSqdzd  extends PageQuery {
	@ApiModelProperty(value="主键id")
    private Integer jlxh;
	@ApiModelProperty(value="医疗机构代码")
    private Integer jgid;
	@ApiModelProperty(value="治疗申请单号")
    private String zlsqdh;
	@ApiModelProperty(value="序号")
    private Integer xh;
	@ApiModelProperty(value="诊断名称")
    private String zdmc;
	@ApiModelProperty(value="ICD码")
    private String icd;

    /** 设置:主键id  */
    public void setJlxh(Integer value) {
        this.jlxh = value;
    }
    /** 获取:主键id */
    public Integer getJlxh() {
        return jlxh;
    }

    /** 设置:医疗机构代码  */
    public void setJgid(Integer value) {
        this.jgid = value;
    }
    /** 获取:医疗机构代码 */
    public Integer getJgid() {
        return jgid;
    }

    /** 设置:治疗申请单号  */
    public void setZlsqdh(String value) {
        this.zlsqdh = value;
    }
    /** 获取:治疗申请单号 */
    public String getZlsqdh() {
        return zlsqdh;
    }

    /** 设置:序号  */
    public void setXh(Integer value) {
        this.xh = value;
    }
    /** 获取:序号 */
    public Integer getXh() {
        return xh;
    }

    /** 设置:诊断名称  */
    public void setZdmc(String value) {
        this.zdmc = value;
    }
    /** 获取:诊断名称 */
    public String getZdmc() {
        return zdmc;
    }

    /** 设置:ICD码  */
    public void setIcd(String value) {
        this.icd = value;
    }
    /** 获取:ICD码 */
    public String getIcd() {
        return icd;
    }


}