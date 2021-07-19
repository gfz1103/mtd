package com.buit.his.treatment.model;

import com.buit.commons.PageQuery;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.sql.Timestamp;

/**
 * @author jiangwei
 * @Date 2021-03-22
 */
@ApiModel(value = "治疗任务子任务表")
public class ZlZlzrw extends PageQuery {
    @ApiModelProperty(value = "记录序号")
    private Integer jlxh;
    @ApiModelProperty(value = "治疗任务分配主键")
    private Integer zlrwfpid;
    @ApiModelProperty(value = "治疗任务模板记录序号")
    private Integer rwmbJlxh;
    @ApiModelProperty(value = "治疗批次记录序号")
    private Integer zlpcJlxh;
    @ApiModelProperty(value = "执行状态 | 0：未执行    2：已执行")
    private Integer zxzt;
    @ApiModelProperty(value = "执行时间 | 预约时选择的执行时间")
    private Timestamp zxsj;
    @ApiModelProperty(value = "费用时间")
    private Timestamp fysj;
    @ApiModelProperty(value = "执行工号")
    private Integer zxgh;
    @ApiModelProperty(value = "记账时间 | 点击“执行”按钮服务器时间")
    private Timestamp jzsj;
    @ApiModelProperty(value = "记账工号")
    private Integer jzgh;
    @ApiModelProperty(value = "取消时间")
    private Timestamp qxsj;
    @ApiModelProperty(value = "取消工号")
    private Integer qxgh;
    @ApiModelProperty(value = "补记帐次数 | 开嘱日期远小于预约日期时，补记此段时间内该模板执行的次数")
    private Integer bjzcs;


    public void setJlxh(Integer value) {
        this.jlxh = value;
    }

    public Integer getJlxh() {
        return jlxh;
    }


    public Integer getZlrwfpid() {
        return zlrwfpid;
    }

    public void setZlrwfpid(Integer zlrwfpid) {
        this.zlrwfpid = zlrwfpid;
    }

    public void setRwmbJlxh(Integer value) {
        this.rwmbJlxh = value;
    }

    public Integer getRwmbJlxh() {
        return rwmbJlxh;
    }


    public void setZlpcJlxh(Integer value) {
        this.zlpcJlxh = value;
    }

    public Integer getZlpcJlxh() {
        return zlpcJlxh;
    }


    public void setZxzt(Integer value) {
        this.zxzt = value;
    }

    public Integer getZxzt() {
        return zxzt;
    }


    public void setZxsj(Timestamp value) {
        this.zxsj = value;
    }

    public Timestamp getZxsj() {
        return zxsj;
    }


    public void setZxgh(Integer value) {
        this.zxgh = value;
    }

    public Integer getZxgh() {
        return zxgh;
    }


    public void setJzsj(Timestamp value) {
        this.jzsj = value;
    }

    public Timestamp getJzsj() {
        return jzsj;
    }


    public void setJzgh(Integer value) {
        this.jzgh = value;
    }

    public Integer getJzgh() {
        return jzgh;
    }


    public void setQxsj(Timestamp value) {
        this.qxsj = value;
    }

    public Timestamp getQxsj() {
        return qxsj;
    }


    public void setQxgh(Integer value) {
        this.qxgh = value;
    }

    public Integer getQxgh() {
        return qxgh;
    }

    public Integer getBjzcs() {
        return bjzcs;
    }

    public void setBjzcs(Integer bjzcs) {
        this.bjzcs = bjzcs;
    }

    public Timestamp getFysj() {
        return fysj;
    }

    public void setFysj(Timestamp fysj) {
        this.fysj = fysj;
    }
}