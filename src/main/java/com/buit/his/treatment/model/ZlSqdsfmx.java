package com.buit.his.treatment.model;

import com.buit.commons.PageQuery;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * @author jiangwei
 * @Description 门诊治疗申请 - 收费项目明细表
 * @Date 2021-04-27
 */
@ApiModel(value = "门诊治疗申请 - 收费项目明细表")
public class ZlSqdsfmx extends PageQuery {
    @ApiModelProperty(value = "记录序号")
    private Integer jlxh;
    @ApiModelProperty(value = "申请单明细记录序号 | 关联zl_sqdmx.JLXH")
    private Integer sqdmxJlxh;
    @ApiModelProperty(value = "收费项目代码")
    private Integer sfxmdm;
    @ApiModelProperty(value = "收费项目名称")
    private String sfxmmc;


    public void setJlxh(Integer value) {
        this.jlxh = value;
    }

    public Integer getJlxh() {
        return jlxh;
    }


    public void setSqdmxJlxh(Integer value) {
        this.sqdmxJlxh = value;
    }

    public Integer getSqdmxJlxh() {
        return sqdmxJlxh;
    }


    public void setSfxmdm(Integer value) {
        this.sfxmdm = value;
    }

    public Integer getSfxmdm() {
        return sfxmdm;
    }


    public void setSfxmmc(String value) {
        this.sfxmmc = value;
    }

    public String getSfxmmc() {
        return sfxmmc;
    }


}