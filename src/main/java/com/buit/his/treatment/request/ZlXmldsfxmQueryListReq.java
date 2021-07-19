package com.buit.his.treatment.request;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;


/**
 * 治疗项目联动收费项目列表查询入参
 * zhouhaisheng
 */
@ApiModel(value = "治疗项目联动收费项目列表")
public class ZlXmldsfxmQueryListReq {

    @ApiModelProperty(value = "医疗机构代码", hidden = true)
    private Integer jgid;
    @ApiModelProperty(value = "治疗科室代码")
    private Integer zlksdm;
    @ApiModelProperty(value = "收费项目名称")
    private String sfxmmc;
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

    public Integer getJgid() {
        return jgid;
    }

    public void setJgid(Integer jgid) {
        this.jgid = jgid;
    }

    public Integer getZlksdm() {
        return zlksdm;
    }

    public void setZlksdm(Integer zlksdm) {
        this.zlksdm = zlksdm;
    }

    public String getZlxmmc() {
        return zlxmmc;
    }

    public void setZlxmmc(String zlxmmc) {
        this.zlxmmc = zlxmmc;
    }

    public String getSfxmmc() {
        return sfxmmc;
    }

    public void setSfxmmc(String sfxmmc) {
        this.sfxmmc = sfxmmc;
    }
}
