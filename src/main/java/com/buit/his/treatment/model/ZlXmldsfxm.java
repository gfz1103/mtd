package com.buit.his.treatment.model;

import com.buit.commons.PageQuery;
import io.swagger.annotations.ApiModelProperty;

import java.math.BigDecimal;

/**
 * 类名称：ZlXmldsfxm<br>
 * 类描述：治疗项目联动收费项目表
 * @author ZHOUHAISHENG
 * @ApiModel(value="治疗项目联动收费项目表")
 */
public class ZlXmldsfxm extends PageQuery {
    @ApiModelProperty(value = "主键id")
    private Integer jlxh;
    @ApiModelProperty(value = "医疗机构代码")
    private Integer jgid;
    @ApiModelProperty(value = "治疗科室代码")
    private Integer zlksdm;
    @ApiModelProperty(value = "收费项目代码")
    private String sfxmdm;
    @ApiModelProperty(value = "收费项目名称")
    private String sfxmmc;
    @ApiModelProperty(value = "排序号")
    private Integer pxh;
    @ApiModelProperty(value = "数量")
    private BigDecimal sl;
    @ApiModelProperty(value = "金额")
    private BigDecimal je;
    @ApiModelProperty(value = "治疗项目ID")
    private Integer zlxmJlxh;
    @ApiModelProperty(value = "治疗项目名称")
    private String zlxmmc;

    public Integer getZlxmJlxh() {
        return zlxmJlxh;
    }

    public void setZlxmJlxh(Integer zlxmJlxh) {
        this.zlxmJlxh = zlxmJlxh;
    }

    /**
     * 设置:主键id
     */
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

    /** 设置:治疗科室代码  */
    public void setZlksdm(Integer value) {
        this.zlksdm = value;
    }
    /** 获取:治疗科室代码 */
    public Integer getZlksdm() {
        return zlksdm;
    }

    /** 设置:治疗项目名称  */
    public void setZlxmmc(String value) {
        this.zlxmmc = value;
    }
    /** 获取:治疗项目名称 */
    public String getZlxmmc() {
        return zlxmmc;
    }

    /** 设置:收费项目代码  */
    public void setSfxmdm(String value) {
        this.sfxmdm = value;
    }
    /** 获取:收费项目代码 */
    public String getSfxmdm() {
        return sfxmdm;
    }

    /** 设置:排序号  */
    public void setPxh(Integer value) {
        this.pxh = value;
    }
    /** 获取:排序号 */
    public Integer getPxh() {
        return pxh;
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

    public String getSfxmmc() {
        return sfxmmc;
    }

    public void setSfxmmc(String sfxmmc) {
        this.sfxmmc = sfxmmc;
    }

    public BigDecimal getJe() {
        return je;
    }

    public void setJe(BigDecimal je) {
        this.je = je;
    }
}
