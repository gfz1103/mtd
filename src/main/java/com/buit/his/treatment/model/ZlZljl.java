package com.buit.his.treatment.model;

import com.buit.commons.PageQuery;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.sql.Timestamp;

/**
 * @author jiangwei
 * @Description 治疗记录表
 * @Date 2021-03-26
 */
@ApiModel(value = "治疗记录表")
public class ZlZljl extends PageQuery {
    @ApiModelProperty(value = "记录序号")
    private Integer jlxh;
    @ApiModelProperty(value = "住院号")
    private Integer zyh;
    @ApiModelProperty(value = "执行日期")
    private String zxrq;
    @ApiModelProperty(value = "诊疗类别")
    private Integer zllb;
    @ApiModelProperty(value = "执行治疗师工号")
    private Integer zxgh;
    @ApiModelProperty(value = "见习治疗师工号")
    private Integer jxgh;
    @ApiModelProperty(value = "记录工号")
    private Integer jlgh;
    @ApiModelProperty(value = "记录时间")
    private Timestamp jlsj;
    @ApiModelProperty(value = "取消时间")
    private Integer qxgh;
    @ApiModelProperty(value = "取消工号")
    private Timestamp qxsj;
    @ApiModelProperty(value = "取消原因")
    private String qxyy;
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
    @ApiModelProperty(value = "状态 | 0：启用    1：取消执行")
    private Integer zt;


    public void setJlxh(Integer value) {
        this.jlxh = value;
    }

    public Integer getJlxh() {
        return jlxh;
    }


    public void setZyh(Integer value) {
        this.zyh = value;
    }

    public Integer getZyh() {
        return zyh;
    }


    public void setZxrq(String value) {
        this.zxrq = value;
    }

    public String getZxrq() {
        return zxrq;
    }

    public Integer getZllb() {
        return zllb;
    }

    public void setZllb(Integer zllb) {
        this.zllb = zllb;
    }

    public void setZxgh(Integer value) {
        this.zxgh = value;
    }

    public Integer getZxgh() {
        return zxgh;
    }


    public void setJxgh(Integer value) {
        this.jxgh = value;
    }

    public Integer getJxgh() {
        return jxgh;
    }


    public void setJlgh(Integer value) {
        this.jlgh = value;
    }

    public Integer getJlgh() {
        return jlgh;
    }


    public void setJlsj(Timestamp value) {
        this.jlsj = value;
    }

    public Timestamp getJlsj() {
        return jlsj;
    }


    public void setQxgh(Integer value) {
        this.qxgh = value;
    }

    public Integer getQxgh() {
        return qxgh;
    }


    public void setQxsj(Timestamp value) {
        this.qxsj = value;
    }

    public Timestamp getQxsj() {
        return qxsj;
    }

    public String getQxyy() {
        return qxyy;
    }

    public void setQxyy(String qxyy) {
        this.qxyy = qxyy;
    }

    public void setBlfy(String value) {
        this.blfy = value;
    }

    public String getBlfy() {
        return blfy;
    }


    public void setBzxx(String value) {
        this.bzxx = value;
    }

    public String getBzxx() {
        return bzxx;
    }


    public void setJdxj(String value) {
        this.jdxj = value;
    }

    public String getJdxj() {
        return jdxj;
    }


    public void setMqzxcs(Integer value) {
        this.mqzxcs = value;
    }

    public Integer getMqzxcs() {
        return mqzxcs;
    }


    public void setScxjcs(Integer value) {
        this.scxjcs = value;
    }

    public Integer getScxjcs() {
        return scxjcs;
    }


    public void setZt(Integer value) {
        this.zt = value;
    }

    public Integer getZt() {
        return zt;
    }


}