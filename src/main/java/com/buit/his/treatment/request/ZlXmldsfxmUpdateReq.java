package com.buit.his.treatment.request;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.math.BigDecimal;


/**
 * 类名称：ZlXmldsfxm<br>
 * 类描述：治疗项目联动收费项目表新增入参<br>
 * @author ZHOUHAISHENG
 */
@ApiModel(value="治疗项目联动收费项目表")
public class ZlXmldsfxmUpdateReq {
    @ApiModelProperty(value="主键id")
    @NotNull(message = "主键id不能为空")
    private Integer jlxh;
    @ApiModelProperty(value="治疗科室代码")
    @NotNull(message = "治疗科室代码不能为空")
    private Integer zlksdm;
    @ApiModelProperty(value="收费项目代码")
    @NotBlank(message = "收费项目代码不能为空")
    private String sfxmdm;
    @ApiModelProperty(value = "排序号")
    @NotNull(message = "排序号不能为空")
    private Integer pxh;
    @ApiModelProperty(value = "数量")
    @NotNull(message = "数量不能为空")
    private BigDecimal sl;
    @ApiModelProperty(value = "治疗项目ID")
    @NotNull(message = "治疗项目ID不能为空")
    private Integer zlxmJlxh;
    @ApiModelProperty(value = "治疗项目名称")
    private String zlxmmc;

    public Integer getZlxmJlxh() {
        return zlxmJlxh;
    }

    public void setZlxmJlxh(Integer zlxmJlxh) {
        this.zlxmJlxh = zlxmJlxh;
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

    public String getSfxmdm() {
        return sfxmdm;
    }

    public void setSfxmdm(String sfxmdm) {
        this.sfxmdm = sfxmdm;
    }

    public Integer getPxh() {
        return pxh;
    }

    public void setPxh(Integer pxh) {
        this.pxh = pxh;
    }

    public BigDecimal getSl() {
        return sl;
    }

    public void setSl(BigDecimal sl) {
        this.sl = sl;
    }

    public Integer getJlxh() {
        return jlxh;
    }

    public void setJlxh(Integer jlxh) {
        this.jlxh = jlxh;
    }
}
