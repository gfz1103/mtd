package com.buit.his.treatment.request;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.util.List;

/**
 * 治疗预约申请单保存或修改入参
 * zhouhaisheng
 */
@ApiModel(value = "治疗预约申请单保存或修改入参")
public class ZlsqdyySaveOrUpdateAllReq {

    @ApiModelProperty(value="治疗申请单明细id")
    private Integer zlSqdmxJlxh;

    @ApiModelProperty(value = "治疗预约List")
    List<ZlsqdyySaveOrUpdateReq> zlsqdyySaveOrUpdateReqs;
    @ApiModelProperty(value = "治疗内容List")
    List<ZlSqdxmzlnrReq> zlSqdxmzlnrReqs;

    public List<ZlsqdyySaveOrUpdateReq> getZlsqdyySaveOrUpdateReqs() {
        return zlsqdyySaveOrUpdateReqs;
    }

    public void setZlsqdyySaveOrUpdateReqs(List<ZlsqdyySaveOrUpdateReq> zlsqdyySaveOrUpdateReqs) {
        this.zlsqdyySaveOrUpdateReqs = zlsqdyySaveOrUpdateReqs;
    }

    public List<ZlSqdxmzlnrReq> getZlSqdxmzlnrReqs() {
        return zlSqdxmzlnrReqs;
    }

    public void setZlSqdxmzlnrReqs(List<ZlSqdxmzlnrReq> zlSqdxmzlnrReqs) {
        this.zlSqdxmzlnrReqs = zlSqdxmzlnrReqs;
    }

    public Integer getZlSqdmxJlxh() {
        return zlSqdmxJlxh;
    }

    public void setZlSqdmxJlxh(Integer zlSqdmxJlxh) {
        this.zlSqdmxJlxh = zlSqdmxJlxh;
    }
}
