package com.buit.his.treatment.request;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.util.List;

/**
 * @Author jiangwei
 * @Date 2021-03-23
 */
@ApiModel("住院治疗预约保存入参")
public class AppointmentSaveReq {
    @ApiModelProperty(value = "住院号")
    private Integer zyh;
    @ApiModelProperty(value = "治疗师代码")
    private Integer zlsdm;
    @ApiModelProperty(value = "预约时间段开始时间")
    private String kssj;
    @ApiModelProperty(value = "预约时间段结束时间")
    private String jssj;
    @ApiModelProperty(value = "模板记录序号数组")
    private List<Integer> jlxhList;

    public Integer getZyh() {
        return zyh;
    }

    public void setZyh(Integer zyh) {
        this.zyh = zyh;
    }

    public Integer getZlsdm() {
        return zlsdm;
    }

    public void setZlsdm(Integer zlsdm) {
        this.zlsdm = zlsdm;
    }

    public String getKssj() {
        return kssj;
    }

    public void setKssj(String kssj) {
        this.kssj = kssj;
    }

    public String getJssj() {
        return jssj;
    }

    public void setJssj(String jssj) {
        this.jssj = jssj;
    }

    public List<Integer> getJlxhList() {
        return jlxhList;
    }

    public void setJlxhList(List<Integer> jlxhList) {
        this.jlxhList = jlxhList;
    }
}
