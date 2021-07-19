package com.buit.his.treatment.request;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * @Author weijing
 * @Date 2021-01-27 13:37
 * @Description
 **/
@ApiModel("执行的数据列表")
public class XmzxData {
    @ApiModelProperty(value = "住院号")
    private Integer zyh;

    @ApiModelProperty(value = "记录类型 1 记录2小结（阶段小结）")
    private String jllx;

    @ApiModelProperty(value = "治疗小结/治疗记录")
    private ZljlDetail zljlDetail;

    public String getJllx() {
        return jllx;
    }

    public void setJllx(String jllx) {
        this.jllx = jllx;
    }

    public Integer getZyh() {
        return zyh;
    }

    public void setZyh(Integer zyh) {
        this.zyh = zyh;
    }

    public ZljlDetail getZljlDetail() {
        return zljlDetail;
    }

    public void setZljlDetail(ZljlDetail zljlDetail) {
        this.zljlDetail = zljlDetail;
    }
}
