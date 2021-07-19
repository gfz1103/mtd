package com.buit.his.treatment.request;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.sql.Timestamp;

/**
 * 新增治疗总结跟治疗小结入参
 * zhouhaisheng
 */
@ApiModel(value = "新增治疗总结跟治疗小结入参")
public class ZlJlxjzjAddReq {

    @ApiModelProperty(value="记录类型 1 记录2小结3总结")
    private String jllx;
    @ApiModelProperty(value="治疗总结")
    private String zlzj;
    @ApiModelProperty(value="备注")
    private String bz;
    @ApiModelProperty(value="预约执行记录序号")
    private Integer yyzxJlxh;
    @ApiModelProperty(value="执行时间")
    private Timestamp zxsj;
    @ApiModelProperty(value="执行医生工号")
    private Integer zxysgh;

    @ApiModelProperty(value="治疗申请单项目明细主键id")
    private Integer zlsqdmxJlxh;

    public String getJllx() {
        return jllx;
    }

    public void setJllx(String jllx) {
        this.jllx = jllx;
    }

    public String getZlzj() {
        return zlzj;
    }

    public void setZlzj(String zlzj) {
        this.zlzj = zlzj;
    }

    public String getBz() {
        return bz;
    }

    public void setBz(String bz) {
        this.bz = bz;
    }

    public Integer getYyzxJlxh() {
        return yyzxJlxh;
    }

    public void setYyzxJlxh(Integer yyzxJlxh) {
        this.yyzxJlxh = yyzxJlxh;
    }

    public Timestamp getZxsj() {
        return zxsj;
    }

    public void setZxsj(Timestamp zxsj) {
        this.zxsj = zxsj;
    }

    public Integer getZxysgh() {
        return zxysgh;
    }

    public void setZxysgh(Integer zxysgh) {
        this.zxysgh = zxysgh;
    }



    public Integer getZlsqdmxJlxh() {
        return zlsqdmxJlxh;
    }

    public void setZlsqdmxJlxh(Integer zlsqdmxJlxh) {
        this.zlsqdmxJlxh = zlsqdmxJlxh;
    }
}
