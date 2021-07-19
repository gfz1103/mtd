package com.buit.his.treatment.request;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * 查询病人治疗申请单治疗内容列表
 * zhouhaisheng
 */
@ApiModel(value = "查询病人治疗申请单治疗内容列表")
public class ZlSqdxmzlnrQueryListReq {

    @ApiModelProperty(value = "医疗机构id",hidden = true)
    public Integer jgid;
    @ApiModelProperty(value = "治疗申请单号")
    public String zlsqdh;
    @ApiModelProperty(value = "治疗项目名称")
    public String zlxmmc;
    @ApiModelProperty(value = "序号")
    public Integer xh;

    public Integer getJgid() {
        return jgid;
    }

    public void setJgid(Integer jgid) {
        this.jgid = jgid;
    }

    public String getZlsqdh() {
        return zlsqdh;
    }

    public void setZlsqdh(String zlsqdh) {
        this.zlsqdh = zlsqdh;
    }

    public String getZlxmmc() {
        return zlxmmc;
    }

    public void setZlxmmc(String zlxmmc) {
        this.zlxmmc = zlxmmc;
    }

    public Integer getXh() {
        return xh;
    }

    public void setXh(Integer xh) {
        this.xh = xh;
    }
}
