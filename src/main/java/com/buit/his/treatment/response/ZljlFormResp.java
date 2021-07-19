package com.buit.his.treatment.response;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.sql.Timestamp;
import java.util.List;

/**
 * @Author jiangwei
 * @Date 2021-03-29 10：38
 * @Description
 **/
@ApiModel("查询治疗师-患者当天治疗记录返回结果封装")
public class ZljlFormResp {
    @ApiModelProperty(value = "记录序号")
    private Integer jlxh;
    @ApiModelProperty(value = "住院号")
    private Integer zyh;
    @ApiModelProperty(value = "执行日期")
    private String zxrq;
    @ApiModelProperty(value = "执行治疗师工号")
    private Integer zxgh;
    @ApiModelProperty(value = "见习治疗师工号")
    private Integer jxgh;
    @ApiModelProperty(value = "记录工号")
    private Integer jlgh;
    @ApiModelProperty(value = "记录时间")
    private Timestamp jlsj;
    @ApiModelProperty(value = "不良反应")
    private String blfy;
    @ApiModelProperty(value = "备注信息")
    private String bzxx;
    @ApiModelProperty(value = "阶段小结")
    private String jdxj;
    @ApiModelProperty(value = "目前执行次数")
    private Integer mqzxcs;
    @ApiModelProperty(value = "上次小结次数")
    private Integer scxjcs;
    @ApiModelProperty(value = "执行批次数组")
    private List<ZlZlpcResp> zlpcList;

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

    public String getZxrq() {
        return zxrq;
    }

    public void setZxrq(String zxrq) {
        this.zxrq = zxrq;
    }

    public Integer getZxgh() {
        return zxgh;
    }

    public void setZxgh(Integer zxgh) {
        this.zxgh = zxgh;
    }

    public Integer getJxgh() {
        return jxgh;
    }

    public void setJxgh(Integer jxgh) {
        this.jxgh = jxgh;
    }

    public Integer getJlgh() {
        return jlgh;
    }

    public void setJlgh(Integer jlgh) {
        this.jlgh = jlgh;
    }

    public Timestamp getJlsj() {
        return jlsj;
    }

    public void setJlsj(Timestamp jlsj) {
        this.jlsj = jlsj;
    }

    public String getBlfy() {
        return blfy;
    }

    public void setBlfy(String blfy) {
        this.blfy = blfy;
    }

    public String getBzxx() {
        return bzxx;
    }

    public void setBzxx(String bzxx) {
        this.bzxx = bzxx;
    }

    public String getJdxj() {
        return jdxj;
    }

    public void setJdxj(String jdxj) {
        this.jdxj = jdxj;
    }

    public Integer getMqzxcs() {
        return mqzxcs;
    }

    public void setMqzxcs(Integer mqzxcs) {
        this.mqzxcs = mqzxcs;
    }

    public Integer getScxjcs() {
        return scxjcs;
    }

    public void setScxjcs(Integer scxjcs) {
        this.scxjcs = scxjcs;
    }

    public List<ZlZlpcResp> getZlpcList() {
        return zlpcList;
    }

    public void setZlpcList(List<ZlZlpcResp> zlpcList) {
        this.zlpcList = zlpcList;
    }
}
