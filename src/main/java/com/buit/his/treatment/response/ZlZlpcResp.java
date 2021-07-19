package com.buit.his.treatment.response;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * @Author jiangwei
 * @Date 2021-03-29 9:34
 * @Description
 **/
@ApiModel("治疗师-患者当天已执行的批次")
public class ZlZlpcResp {
    @ApiModelProperty(value = "治疗批次记录序号")
    private Integer jlxh;
    @ApiModelProperty(value = "治疗日期")
    private String zlrq;
    @ApiModelProperty(value = "实际开始时间 | 更改治疗记录单时保存")
    private String sjkssj;
    @ApiModelProperty(value = "实际结束时间 | 更改治疗记录单时保存")
    private String sjjssj;
    @ApiModelProperty(value = "时间段数据数组 | 前端datepicker控件格式（方便传参）")
    private String[] sjd;

    public Integer getJlxh() {
        return jlxh;
    }

    public void setJlxh(Integer jlxh) {
        this.jlxh = jlxh;
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

    public String getZlrq() {
        return zlrq;
    }

    public void setZlrq(String zlrq) {

        this.zlrq = zlrq;
    }

    public String[] getSjd() {
        return new String[]{zlrq + " " + sjkssj + ":00", zlrq + " " + sjjssj + ":00"};
    }

    public void setSjd(String[] sjd) {
        this.sjd = sjd;
    }
}
