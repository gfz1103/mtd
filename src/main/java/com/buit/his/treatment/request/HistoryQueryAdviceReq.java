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
@ApiModel("查询住院治疗记录医嘱入参")
public class HistoryQueryAdviceReq extends PageQuery {
    @ApiModelProperty(value = "医疗机构id", hidden = true)
    private Integer jgid;

    @ApiModelProperty(value = "治疗师代码", hidden = true)
    private Integer zlsdm;

    @NotNull
    @ApiModelProperty(value = "治疗科室代码")
    private Integer zlksdm;

    @NotNull
    @ApiModelProperty(value = "住院号")
    private Integer zyh;

    @ApiModelProperty(value = "查询模式 | 0：全部    1：我的病人")
    private Integer type;

    @ApiModelProperty(value = "治疗类别")
    private Integer zllb;

    @ApiModelProperty(value = "收费项目代码")
    private List<Integer> sfxmdm;

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

    public Integer getZyh() {
        return zyh;
    }

    public void setZyh(Integer zyh) {
        this.zyh = zyh;
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
}
