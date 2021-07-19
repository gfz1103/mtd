package com.buit.his.treatment.request;

import com.buit.commons.PageQuery;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * 治疗项目输入法入参
 * zhouhaisheng
 */
@ApiModel(value = "治疗项目输入法入参")
public class QueryZlxmSrfReq extends PageQuery {
    @ApiModelProperty(value="拼音代码")
    private String pydm;
    @ApiModelProperty(value="类别名称")
    private String lbmc;
    @ApiModelProperty(value="治疗科室代码")
    private Integer zlksdm;
    @ApiModelProperty(value="医疗机构代码",hidden = true)
    private Integer jgid;
    @ApiModelProperty(value="诊疗类别")
    private Integer zllb;

    public Integer getZllb() {
        return zllb;
    }

    public void setZllb(Integer zllb) {
        this.zllb = zllb;
    }

    public String getPydm() {
        return pydm;
    }

    public void setPydm(String pydm) {
        this.pydm = pydm;
    }

    public String getLbmc() {
        return lbmc;
    }

    public void setLbmc(String lbmc) {
        this.lbmc = lbmc;
    }

    public Integer getZlksdm() {
        return zlksdm;
    }

    public void setZlksdm(Integer zlksdm) {
        this.zlksdm = zlksdm;
    }

    public Integer getJgid() {
        return jgid;
    }

    public void setJgid(Integer jgid) {
        this.jgid = jgid;
    }
}
