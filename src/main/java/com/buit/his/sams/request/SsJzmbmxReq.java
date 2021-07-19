package com.buit.his.sams.request;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.math.BigDecimal;


/**
 * 类名称：SsJzmbmx<br>
 * 类描述：手术麻醉记账模板明细<br>
 * @author zhouhaisheng
 */
@ApiModel(value="手术麻醉记账模板明细")
public class SsJzmbmxReq {
    @ApiModelProperty(value="主键id")
    private Integer jlxh;
    @ApiModelProperty(value="机构id")
    private Integer jgid;
    @ApiModelProperty(value="his手术科室代码")
    private Integer ssksdm;
    @ApiModelProperty(value="模板名称")
    private String mbmc;
    @ApiModelProperty(value="序号")
    private Integer xh;
    @ApiModelProperty(value="收费项目类别")
    private String sfxmlb;
    @ApiModelProperty(value="收费项目代码")
    private String sfxmdm;
    @ApiModelProperty(value="数量")
    private BigDecimal sl;
    @ApiModelProperty(value="记账模板主表记录序号")
    private Integer jzmbzbJlxh;
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
     * 设置:his手术科室代码
     */
    public void setSsksdm(Integer value) {
        this.ssksdm = value;
    }
    /**
     * 获取:his手术科室代码
     */
    public Integer getSsksdm() {
        return ssksdm;
    }
    /**
     * 设置:模板名称
     */
    public void setMbmc(String value) {
        this.mbmc = value;
    }
    /**
     * 获取:模板名称
     */
    public String getMbmc() {
        return mbmc;
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
     * 设置:收费项目类别
     */
    public void setSfxmlb(String value) {
        this.sfxmlb = value;
    }
    /**
     * 获取:收费项目类别
     */
    public String getSfxmlb() {
        return sfxmlb;
    }
    /**
     * 设置:收费项目代码
     */
    public void setSfxmdm(String value) {
        this.sfxmdm = value;
    }
    /**
     * 获取:收费项目代码
     */
    public String getSfxmdm() {
        return sfxmdm;
    }
    /**
     * 设置:数量
     */
    public void setSl(BigDecimal value) {
        this.sl = value;
    }
    /**
     * 获取:数量
     */
    public BigDecimal getSl() {
        return sl;
    }
    /**
     * 设置:记账模板主表记录序号
     */
    public void setJzmbzbJlxh(Integer value) {
        this.jzmbzbJlxh = value;
    }
    /**
     * 获取:记账模板主表记录序号
     */
    public Integer getJzmbzbJlxh() {
        return jzmbzbJlxh;
    }
}