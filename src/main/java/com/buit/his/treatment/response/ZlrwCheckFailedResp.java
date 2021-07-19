package com.buit.his.treatment.response;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.sql.Timestamp;

/**
 * @Author jiangwei
 * @Date 2021-06-08 16:40
 */
@ApiModel("出院证检查失败返回结果封装")
public class ZlrwCheckFailedResp {
    @ApiModelProperty(value = "记录序号")
    private Integer jlxh;
    @ApiModelProperty(value = "住院号")
    private Integer zyh;
    @ApiModelProperty(value = "任务分配主键")
    private Integer zlrwfpId;
    @ApiModelProperty(value = "治疗科室代码")
    private Integer zlksdm;
    @ApiModelProperty(value = "治疗科室名称")
    private String zlksmc;
    @ApiModelProperty(value = "临时医嘱 | 0：长期医嘱    1：临时医嘱")
    private Integer lsyz;
    @ApiModelProperty(value = "开嘱时间")
    private Timestamp kssj;
    @ApiModelProperty(value = "停嘱时间")
    private Timestamp tzsj;
    @ApiModelProperty(value = "频次")
    private String sypc;
    @ApiModelProperty(value = "收费项目代码")
    private Integer sfxmdm;
    @ApiModelProperty(value = "收费项目名称")
    private String sfxmmc;
    @ApiModelProperty(value = "执行时间")
    private Timestamp zxsj;
    @ApiModelProperty(value = "预约工号")
    private Integer zxgh;
    @ApiModelProperty(value = "治疗师")
    private String zxghName;

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

    public Integer getZlksdm() {
        return zlksdm;
    }

    public void setZlksdm(Integer zlksdm) {
        this.zlksdm = zlksdm;
    }

    public Integer getLsyz() {
        return lsyz;
    }

    public void setLsyz(Integer lsyz) {
        this.lsyz = lsyz;
    }

    public Timestamp getKssj() {
        return kssj;
    }

    public void setKssj(Timestamp kssj) {
        this.kssj = kssj;
    }

    public Timestamp getTzsj() {
        return tzsj;
    }

    public void setTzsj(Timestamp tzsj) {
        this.tzsj = tzsj;
    }

    public String getSypc() {
        return sypc;
    }

    public void setSypc(String sypc) {
        this.sypc = sypc;
    }

    public Integer getSfxmdm() {
        return sfxmdm;
    }

    public void setSfxmdm(Integer sfxmdm) {
        this.sfxmdm = sfxmdm;
    }

    public String getSfxmmc() {
        return sfxmmc;
    }

    public void setSfxmmc(String sfxmmc) {
        this.sfxmmc = sfxmmc;
    }

    public Timestamp getZxsj() {
        return zxsj;
    }

    public void setZxsj(Timestamp zxsj) {
        this.zxsj = zxsj;
    }

    public Integer getZxgh() {
        return zxgh;
    }

    public void setZxgh(Integer zxgh) {
        this.zxgh = zxgh;
    }

    public String getZlksmc() {
        return zlksmc;
    }

    public void setZlksmc(String zlksmc) {
        this.zlksmc = zlksmc;
    }

    public String getZxghName() {
        return zxghName;
    }

    public void setZxghName(String zxghName) {
        this.zxghName = zxghName;
    }
}
