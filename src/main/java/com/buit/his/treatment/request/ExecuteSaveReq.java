package com.buit.his.treatment.request;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import javax.validation.constraints.NotNull;
import java.util.List;

/**
 * @Author jiangwei
 * @Date 2021-03-29
 */
@ApiModel("住院治疗执行保存入参")
public class ExecuteSaveReq {
    @ApiModelProperty(value = "治疗机构", hidden = true)
    private Integer jgid;
    @ApiModelProperty(value = "治疗师代码", hidden = true)
    private Integer zlsdm;
    @ApiModelProperty(value = "治疗科室代码")
    private Integer zlksdm;
    @NotNull
    @ApiModelProperty(value = "执行日期")
    private String zxrq;
    @NotNull
    @ApiModelProperty(value = "诊疗类别")
    private Integer zllb;
    @ApiModelProperty(value = "子任务执行记录序号")
    private List<ZlZlzrwReq> zrwList;

    public Integer getJgid() {
        return jgid;
    }

    public void setJgid(Integer jgid) {
        this.jgid = jgid;
    }

    public Integer getZlsdm() {
        return zlsdm;
    }

    public void setZlsdm(Integer zlsdm) {
        this.zlsdm = zlsdm;
    }

    public Integer getZlksdm() {
        return zlksdm;
    }

    public void setZlksdm(Integer zlksdm) {
        this.zlksdm = zlksdm;
    }

    public String getZxrq() {
        return zxrq;
    }

    public void setZxrq(String zxrq) {
        this.zxrq = zxrq;
    }

    public Integer getZllb() {
        return zllb;
    }

    public void setZllb(Integer zllb) {
        this.zllb = zllb;
    }

    public List<ZlZlzrwReq> getZrwList() {
        return zrwList;
    }

    public void setZrwList(List<ZlZlzrwReq> zrwList) {
        this.zrwList = zrwList;
    }
}
