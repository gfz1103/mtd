package com.buit.his.sams.response;

import com.buit.commons.PageQuery;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;


/**
 * 类名称：SsSqdss<br>
 * 类描述：手术申请单手术表<br>
 * @author zhouhaisheng
 */
@ApiModel(value="手术申请单手术表")
public class SsSqdssResp  extends  PageQuery{
    @ApiModelProperty(value="主键id")
    private Integer jlxh;
    @ApiModelProperty(value="机构id")
    private Integer jgid;
    @ApiModelProperty(value="手术 申请单号")
    private String sssqdh;
    @ApiModelProperty(value="序号")
    private Integer xh;
    @ApiModelProperty(value="拟行手术名称")
    private String nxssmc;
    @ApiModelProperty(value="手术编码")
    private String ssbm;
    @ApiModelProperty(value="切口")
    private String qk;
    @ApiModelProperty(value="1一级2二级3三级4四级")
    private String ssjb;
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
     * 设置:拟行手术名称
     */
    public void setNxssmc(String value) {
        this.nxssmc = value;
    }
    /**
     * 获取:拟行手术名称
     */
    public String getNxssmc() {
        return nxssmc;
    }
    /**
     * 设置:手术编码
     */
    public void setSsbm(String value) {
        this.ssbm = value;
    }
    /**
     * 获取:手术编码
     */
    public String getSsbm() {
        return ssbm;
    }
    /**
     * 设置:切口
     */
    public void setQk(String value) {
        this.qk = value;
    }
    /**
     * 获取:切口
     */
    public String getQk() {
        return qk;
    }
    /**
     * 设置:1一级2二级3三级4四级
     */
    public void setSsjb(String value) {
        this.ssjb = value;
    }
    /**
     * 获取:1一级2二级3三级4四级
     */
    public String getSsjb() {
        return ssjb;
    }
}