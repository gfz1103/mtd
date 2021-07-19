package com.buit.his.treatment.response;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.math.BigDecimal;


/**
 * 类名称：ZlXmldsfxm<br>
 * 类描述：治疗项目联动收费项目列表出参<br>
 * @author ZHOUHAISHENG
 */
@ApiModel(value = "治疗项目联动收费项目列表出参")
public class ZlXmldsfxmQueryListResp {
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
    @ApiModelProperty(value = "单价")
    private BigDecimal dj;
    @ApiModelProperty(value = "单位")
    private String dw;
    @ApiModelProperty(value = "金额")
    private BigDecimal je;
    @ApiModelProperty(value = "治疗项目ID")
    private Integer zlxmJlxh;
    @ApiModelProperty(value = "治疗项目名称")
    private String zlxmmc;
    @ApiModelProperty(value = "诊疗类别")
    private Integer zllb;
    @ApiModelProperty(value = "参考目标")
    private String ckmb;
    @ApiModelProperty(value = "注意事项")
    private String zysx;

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
     * 设置:医疗机构代码
     */
    public void setJgid(Integer value) {
        this.jgid = value;
    }
    /**
     * 获取:医疗机构代码
     */
    public Integer getJgid() {
        return jgid;
    }
    /**
     * 设置:治疗科室代码
     */
    public void setZlksdm(Integer value) {
        this.zlksdm = value;
    }
    /**
     * 获取:治疗科室代码
     */
    public Integer getZlksdm() {
        return zlksdm;
    }
    /**
     * 设置:治疗项目名称
     */
    public void setZlxmmc(String value) {
        this.zlxmmc = value;
    }
    /**
     * 获取:治疗项目名称
     */
    public String getZlxmmc() {
        return zlxmmc;
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
     * 设置:排序号
     */
    public void setPxh(Integer value) {
        this.pxh = value;
    }
    /**
     * 获取:排序号
     */
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

    public String getDw() {
        return dw;
    }

    public void setDw(String dw) {
        this.dw = dw;
    }

    public String getSfxmmc() {
        return sfxmmc;
    }

    public void setSfxmmc(String sfxmmc) {
        this.sfxmmc = sfxmmc;
    }

    public BigDecimal getDj() {
        return dj;
    }

    public void setDj(BigDecimal dj) {
        this.dj = dj;
    }

    public BigDecimal getJe() {
        return je;
    }

    public void setJe(BigDecimal je) {
        this.je = je;
    }

    public Integer getZlxmJlxh() {
        return zlxmJlxh;
    }

    public void setZlxmJlxh(Integer zlxmJlxh) {
        this.zlxmJlxh = zlxmJlxh;
    }

    public Integer getZllb() {
        return zllb;
    }

    public void setZllb(Integer zllb) {
        this.zllb = zllb;
    }

    public String getCkmb() {
        return ckmb;
    }

    public void setCkmb(String ckmb) {
        this.ckmb = ckmb;
    }

    public String getZysx() {
        return zysx;
    }

    public void setZysx(String zysx) {
        this.zysx = zysx;
    }
}