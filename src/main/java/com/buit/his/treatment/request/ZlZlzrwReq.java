package com.buit.his.treatment.request;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * @Author jiangwei
 * @Date 2021-04-30
 */
@ApiModel("住院治疗执行保存 - 治疗子任务数组对象封装")
public class ZlZlzrwReq {
    @ApiModelProperty(value = "记录序号")
    private Integer jlxh;
    @ApiModelProperty(value = "住院号")
    private Integer zyh;
    @ApiModelProperty(value = "任务分配主键")
    private Integer zlrwfpId;

    public Integer getJlxh() {
        return jlxh;
    }

    public void setJlxh(Integer jlxh) {
        this.jlxh = jlxh;
    }

    public Integer getZyh() {
        return zyh;
    }

    public void setZyh(Integer zyh) {
        this.zyh = zyh;
    }

    public Integer getZlrwfpId() {
        return zlrwfpId;
    }

    public void setZlrwfpId(Integer zlrwfpId) {
        this.zlrwfpId = zlrwfpId;
    }

}
