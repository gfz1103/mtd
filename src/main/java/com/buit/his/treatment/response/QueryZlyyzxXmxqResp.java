package com.buit.his.treatment.response;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * 病人治疗执行-治疗项目详情返回参数
 * zhouhaisheng
 */
@ApiModel(value = "病人治疗执行-治疗项目详情返回参数")
public class QueryZlyyzxXmxqResp {
    @ApiModelProperty(value = "主键id")
    private Integer jlxh;
    @ApiModelProperty(value = "诊断")
    private String zlzd;
    @ApiModelProperty(value = "治疗项目名称")
    private String zlxmmc;
    @ApiModelProperty(value = "治疗目标")
    private String zlmb;
    @ApiModelProperty(value = "注意事项")
    private String zysx;

    public Integer getJlxh() {
        return jlxh;
    }

    public void setJlxh(Integer jlxh) {
        this.jlxh = jlxh;
    }

    public String getZlzd() {
        return zlzd;
    }

    public void setZlzd(String zlzd) {
        this.zlzd = zlzd;
    }

    public String getZlxmmc() {
        return zlxmmc;
    }

    public void setZlxmmc(String zlxmmc) {
        this.zlxmmc = zlxmmc;
    }

    public String getZysx() {
        return zysx;
    }

    public void setZysx(String zysx) {
        this.zysx = zysx;
    }

    public String getZlmb() {
        return zlmb;
    }

    public void setZlmb(String zlmb) {
        this.zlmb = zlmb;
    }
}
