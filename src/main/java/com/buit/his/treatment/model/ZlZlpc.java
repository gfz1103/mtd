package com.buit.his.treatment.model;

import com.buit.commons.PageQuery;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * @author jiangwei
 * @Date 2021-03-22
 */
@ApiModel(value = "治疗师治疗批次表")
public class ZlZlpc extends PageQuery {
    @ApiModelProperty(value = "治疗批次记录序号")
    private Integer jlxh;
    @ApiModelProperty(value = "治疗师代码")
    private Integer zlsdm;
    @ApiModelProperty(value = "治疗科室代码")
    private Integer zlksdm;
    @ApiModelProperty(value = "住院号")
    private Integer zyh;
    @ApiModelProperty(value = "治疗日期")
    private String zlrq;
    @ApiModelProperty(value = "预约开始时间")
    private String kssj;
    @ApiModelProperty(value = "预约结束时间")
    private String jssj;
    @ApiModelProperty(value = "实际开始时间 | 更改治疗记录单时保存")
    private String sjkssj;
    @ApiModelProperty(value = "实际结束时间 | 更改治疗记录单时保存")
    private String sjjssj;

    public void setJlxh(Integer value) {
        this.jlxh = value;
    }

    public Integer getJlxh() {
        return jlxh;
    }


    public void setZlsdm(Integer value) {
        this.zlsdm = value;
    }

    public Integer getZlsdm() {
        return zlsdm;
    }


    public void setZlksdm(Integer value) {
        this.zlksdm = value;
    }

    public Integer getZlksdm() {
        return zlksdm;
    }

    public Integer getZyh() {
        return zyh;
    }

    public void setZyh(Integer zyh) {
        this.zyh = zyh;
    }

    public void setZlrq(String value) {
        this.zlrq = value;
    }

    public String getZlrq() {
        return zlrq;
    }


    public void setKssj(String value) {
        this.kssj = value;
    }

    public String getKssj() {
        return kssj;
    }


    public void setJssj(String value) {
        this.jssj = value;
    }

    public String getJssj() {
        return jssj;
    }

    public String getSjkssj() {
        return sjkssj;
    }

    public void setSjkssj(String sjkssj) {
        this.sjkssj = sjkssj;
    }

    public String getSjjssj() {
        return sjjssj;
    }

    public void setSjjssj(String sjjssj) {
        this.sjjssj = sjjssj;
    }

}