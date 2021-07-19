package com.buit.his.treatment.request;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

/**
 * @Author weijing
 * @Date 2021-01-20 10:44
 * @Description
 **/
@ApiModel(value="治疗小组修改入参")
public class ZlZlzEditReq {
    @ApiModelProperty(value="治疗小组ID")
    @NotNull(message = "治疗类别ID不能为空")
    private Integer zlzid;
    @ApiModelProperty(value="医疗机构代码",hidden = true)
    private Integer jgid;
    @ApiModelProperty(value="治疗组名称")
    @NotBlank(message = "治疗组名称不能为空")
    private String zlzmc;
    @ApiModelProperty(value="治疗类别")
    @NotNull(message = "治疗类别不能为空")
    private Integer zllb;
    @ApiModelProperty(value="状态 1启用 0停用")
    @NotBlank(message = "状态不能为空")
    private String zt;

    public Integer getZlzid() {
        return zlzid;
    }

    public void setZlzid(Integer zlzid) {
        this.zlzid = zlzid;
    }

    public Integer getJgid() {
        return jgid;
    }

    public void setJgid(Integer jgid) {
        this.jgid = jgid;
    }

    public String getZlzmc() {
        return zlzmc;
    }

    public void setZlzmc(String zlzmc) {
        this.zlzmc = zlzmc;
    }

    public Integer getZllb() {
        return zllb;
    }

    public void setZllb(Integer zllb) {
        this.zllb = zllb;
    }

    public String getZt() {
        return zt;
    }

    public void setZt(String zt) {
        this.zt = zt;
    }
}
