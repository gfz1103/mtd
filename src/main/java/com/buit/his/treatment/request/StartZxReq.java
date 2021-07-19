package com.buit.his.treatment.request;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.util.List;

/**
 * @Author weijing
 * @Date 2021-01-27 13:27
 * @Description
 **/
@ApiModel("开始执行入参")
public class StartZxReq {
    @ApiModelProperty(value = "医疗机构代码",hidden = true)
    private Integer jgid;

    @ApiModelProperty(value = "执行科室",hidden = true)
    private Integer zxks;

    @ApiModelProperty(value = "执行人",hidden = true)
    private Integer zxr;

    @ApiModelProperty(value = "诊疗类别")
    @NotNull(message = "诊疗类别不能为空")
    private Integer zllb;

    @ApiModelProperty(value = "执行日期")
    @NotBlank(message = "执行日期不能我空")
    private String zxrq;

    @ApiModelProperty(value = "需要执行的数据列表")
    private List<XmzxData> list;

    public Integer getZxr() {
        return zxr;
    }

    public void setZxr(Integer zxr) {
        this.zxr = zxr;
    }

    public Integer getJgid() {
        return jgid;
    }

    public void setJgid(Integer jgid) {
        this.jgid = jgid;
    }

    public Integer getZxks() {
        return zxks;
    }

    public void setZxks(Integer zxks) {
        this.zxks = zxks;
    }

    public Integer getZllb() {
        return zllb;
    }

    public void setZllb(Integer zllb) {
        this.zllb = zllb;
    }

    public String getZxrq() {
        return zxrq;
    }

    public void setZxrq(String zxrq) {
        this.zxrq = zxrq;
    }

    public List<XmzxData> getList() {
        return list;
    }

    public void setList(List<XmzxData> list) {
        this.list = list;
    }
}
