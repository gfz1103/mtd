package com.buit.his.treatment.request;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import javax.validation.constraints.NotNull;

@ApiModel(value = "更改治疗项目类别入参")
public class ZlRwlbEditReq {
    @NotNull
    @ApiModelProperty(value = "康复治疗任务分配ID")
    private Integer zlrwfpid;
    @NotNull
    @ApiModelProperty(value = "治疗类别")
    private Integer zllb;
    @NotNull
    @ApiModelProperty(value = "住院号")
    private Integer zyh;

    public Integer getZlrwfpid() {
        return zlrwfpid;
    }

    public void setZlrwfpid(Integer zlrwfpid) {
        this.zlrwfpid = zlrwfpid;
    }

    public Integer getZllb() {
        return zllb;
    }

    public void setZllb(Integer zllb) {
        this.zllb = zllb;
    }

    public Integer getZyh() {
        return zyh;
    }

    public void setZyh(Integer zyh) {
        this.zyh = zyh;
    }
}
