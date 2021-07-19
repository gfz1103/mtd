package com.buit.his.treatment.request;

import com.buit.commons.PageQuery;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import javax.validation.constraints.NotNull;
import java.util.List;

/**
 * @author 蒋威
 * @Date 2021-05-10
 */
@ApiModel("查询住院治疗记录患者入参")
public class HistoryQueryPatientReq extends PageQuery {
    @ApiModelProperty(value = "医疗机构id", hidden = true)
    private Integer jgid;

    @ApiModelProperty(value = "治疗师代码", hidden = true)
    private Integer zlsdm;

    @NotNull
    @ApiModelProperty(value = "治疗科室代码")
    private Integer zlksdm;

    @ApiModelProperty(value = "出院判别 （1在院 2出院 空查询所有）")
    private Integer cypb;

    @ApiModelProperty(value = "查询模式 | 0：全部    1：我的病人")
    private Integer type;

    @ApiModelProperty(value = "治疗类别")
    private Integer zllb;

    @ApiModelProperty(value = "收费项目代码")
    private List<Integer> sfxmdm;

    @ApiModelProperty(value = "病人病区")
    private Integer brbq;

    @ApiModelProperty(value = "病人姓名")
    private String brxm;

    @ApiModelProperty(value = "住院号码")
    private String zyhm;

    @ApiModelProperty(value = "病人床号")
    private String brch;

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

    public Integer getCypb() {
        return cypb;
    }

    public void setCypb(Integer cypb) {
        this.cypb = cypb;
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

    public List<Integer> getSfxmdm() {
        return sfxmdm;
    }

    public void setSfxmdm(List<Integer> sfxmdm) {
        this.sfxmdm = sfxmdm;
    }

    public Integer getBrbq() {
        return brbq;
    }

    public void setBrbq(Integer brbq) {
        this.brbq = brbq;
    }

    public String getBrxm() {
        return brxm;
    }

    public void setBrxm(String brxm) {
        this.brxm = brxm;
    }

    public String getZyhm() {
        return zyhm;
    }

    public void setZyhm(String zyhm) {
        this.zyhm = zyhm;
    }

    public String getBrch() {
        return brch;
    }

    public void setBrch(String brch) {
        this.brch = brch;
    }
}
