package com.buit.his.sams.request;

import com.buit.commons.PageQuery;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;


/**
 * 类名称：SsSqdzd<br>
 * 类描述：手术申请单诊断表<br>
 * @author zhouhaisheng
 */
@ApiModel(value="手术申请单诊断表")
public class SsSqdzdReq  extends  PageQuery{
    @ApiModelProperty(value="主键id")
    private Integer jlxh;
    @ApiModelProperty(value="医疗机构id")
    private Integer jgid;
    @ApiModelProperty(value="手术申请单号")
    private String sssqdh;
    @ApiModelProperty(value="序号")
    private Integer xh;
    @ApiModelProperty(value="诊断名称")
    private String zdmc;
    @ApiModelProperty(value="ICD编码")
    private String icdbm;
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
     * 设置:手术申请单号
     */
    public void setSssqdh(String value) {
        this.sssqdh = value;
    }
    /**
     * 获取:手术申请单号
     */
    public String getSssqdh() {
        return sssqdh;
    }
    /**
     * 设置:序号
     */
    public void setXh(Integer value) {
        this.xh = value;
    }
    /**
     * 获取:序号
     */
    public Integer getXh() {
        return xh;
    }
    /**
     * 设置:诊断名称
     */
    public void setZdmc(String value) {
        this.zdmc = value;
    }
    /**
     * 获取:诊断名称
     */
    public String getZdmc() {
        return zdmc;
    }
    /**
     * 设置:ICD编码
     */
    public void setIcdbm(String value) {
        this.icdbm = value;
    }
    /**
     * 获取:ICD编码
     */
    public String getIcdbm() {
        return icdbm;
    }
}