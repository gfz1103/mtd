package com.buit.his.treatment.request;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * @Author jiangwei
 * @Date 2021-03-29 20:16
 * @Description
 **/
@ApiModel("治疗记录时间段修改入参")
public class ZlZlpcReq {
    @ApiModelProperty(value = "治疗批次记录序号")
    private Integer jlxh;
    @ApiModelProperty(value = "实际开始时间 | 更改治疗记录单时保存")
    private String sjkssj;
    @ApiModelProperty(value = "实际结束时间 | 更改治疗记录单时保存")
    private String sjjssj;
    @ApiModelProperty(value = "时间段数据数组 | 前端datepicker控件格式（方便渲染）")
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

    public String[] getSjd() {
        return sjd;
    }

    public void setSjd(String[] sjd) {
        this.sjkssj = sjd[0].split(" ")[1].substring(0, 5);
        this.sjjssj = sjd[1].split(" ")[1].substring(0, 5);
        this.sjd = sjd;
    }
}
