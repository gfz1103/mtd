package com.buit.his.treatment.request;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import javax.validation.constraints.NotNull;

/**
 * @Author weijing
 * @Date 2021-01-21 14:54
 * @Description
 **/
@ApiModel("查询诊疗项目详情")
public class QueryZyzlyyDetailReq {
    @ApiModelProperty(value = "医疗机构代码",hidden = true)
    private Integer jgid;

    @ApiModelProperty(value = "住院号")
    @NotNull(message = "住院号不能为空")
    private Integer zyh;

    @ApiModelProperty(value = "诊疗类别")
    @NotNull(message = "诊疗类别不能为空")
    private Integer zllb;

    @ApiModelProperty(value = "执行科室",hidden = true)
    private Integer zxks;

    public Integer getJgid() {
        return jgid;
    }

    public void setJgid(Integer jgid) {
        this.jgid = jgid;
    }

    public Integer getZyh() {
        return zyh;
    }

    public void setZyh(Integer zyh) {
        this.zyh = zyh;
    }

    public Integer getZllb() {
        return zllb;
    }

    public void setZllb(Integer zllb) {
        this.zllb = zllb;
    }

    public Integer getZxks() {
        return zxks;
    }

    public void setZxks(Integer zxks) {
        this.zxks = zxks;
    }
}
