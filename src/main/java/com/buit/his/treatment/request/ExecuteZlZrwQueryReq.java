package com.buit.his.treatment.request;

import com.buit.commons.PageQuery;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import javax.validation.constraints.NotNull;
import java.util.List;

/**
 * @author 蒋威
 * @Date 2021-04-30
 */
@ApiModel("查询住院治疗执行患者当天子任务入参")
public class ExecuteZlZrwQueryReq extends PageQuery {
    @ApiModelProperty(value = "医疗机构id", hidden = true)
    private Integer jgid;

    @NotNull
    @ApiModelProperty(value = "治疗科室代码")
    private Integer zlksdm;

    @ApiModelProperty(value = "治疗师代码", hidden = true)
    private Integer zlsdm;

    @NotNull
    @ApiModelProperty(value = "查询模式 | 0：全部    1：我的病人")
    private Integer type;

    @NotNull
    @ApiModelProperty(value = "诊疗类别")
    private Integer zllb;

    @NotNull
    @ApiModelProperty(value = "住院号")
    private List<Integer> zyhList;

    @NotNull
    @ApiModelProperty(value = "执行状态 | 0：未执行    2：已执行")
    private Integer zxzt;

    @NotNull
    @ApiModelProperty(value = "执行日期")
    private String zxrq;

    @ApiModelProperty(value = "患者情况 | 0：全部    1：新病人    2：需要阶段小结")
    private Integer hzqk;

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

    public Integer getZlsdm() {
        return zlsdm;
    }

    public void setZlsdm(Integer zlsdm) {
        this.zlsdm = zlsdm;
    }

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
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

    public Integer getHzqk() {
        return hzqk;
    }

    public void setHzqk(Integer hzqk) {
        this.hzqk = hzqk;
    }

    public Integer getZxzt() {
        return zxzt;
    }

    public void setZxzt(Integer zxzt) {
        this.zxzt = zxzt;
    }

    public List<Integer> getZyhList() {
        return zyhList;
    }

    public void setZyhList(List<Integer> zyhList) {
        this.zyhList = zyhList;
    }
}
