package com.buit.his.sams.request;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;


/**
 * 类名称：SsTsss<br>
 * 类描述：特殊手术表<br>
 * @author zhouhaisheng
 */
@ApiModel(value="特殊手术表")
public class SsTsssReq {
    @ApiModelProperty(value="主键id")
    private Integer jlxh;
    @ApiModelProperty(value="机构id")
    private Integer jgid;
    @ApiModelProperty(value="特殊手术名称")
    private String tsssmc;
    @ApiModelProperty(value="拼音码")
    private String pym;
    @ApiModelProperty(value="五笔码")
    private String wbm;
    @ApiModelProperty(value="0 使用/1 停用")
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
     * 设置:机构id
     */
    public void setJgid(Integer value) {
        this.jgid = value;
    }
    /**
     * 获取:机构id
     */
    public Integer getJgid() {
        return jgid;
    }
    /**
     * 设置:特殊手术名称
     */
    public void setTsssmc(String value) {
        this.tsssmc = value;
    }
    /**
     * 获取:特殊手术名称
     */
    public String getTsssmc() {
        return tsssmc;
    }
    /**
     * 设置:拼音码
     */
    public void setPym(String value) {
        this.pym = value;
    }
    /**
     * 获取:拼音码
     */
    public String getPym() {
        return pym;
    }
    /**
     * 设置:五笔码
     */
    public void setWbm(String value) {
        this.wbm = value;
    }
    /**
     * 获取:五笔码
     */
    public String getWbm() {
        return wbm;
    }
    /**
     * 设置:0 使用/1 停用
     */
    public void setZt(String value) {
        this.zt = value;
    }
    /**
     * 获取:0 使用/1 停用
     */
    public String getZt() {
        return zt;
    }
}