package com.buit.his.treatment.response;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.sql.Date;

/**
 * @Author jiangwei
 * @Date 2021-03-22 11:16
 * @Description
 **/
@ApiModel("查询住院康复治疗预约患者列表返回参数")
public class AppointmentPatientResp {
    @ApiModelProperty(value = "住院号（主键）")
    private Integer zyh;

    @ApiModelProperty(value = "住院号码（界面展示用）")
    private String zyhm;

    @ApiModelProperty(value = "病人病区")
    private Integer brbq;

    @ApiModelProperty(value = "病人床号")
    private String brch;

    @ApiModelProperty(value = "病人姓名")
    private String brxm;

    @ApiModelProperty(value = "病人性别")
    private Integer brxb;

    @ApiModelProperty(value = "出生日期")
    private Date csrq;

    @ApiModelProperty(value = "时间段数据数组 | 前端datepicker控件格式（方便渲染）")
    private String[] sjd = new String[]{"08:30:00", "17:00:00"};

    public Integer getZyh() {
        return zyh;
    }

    public void setZyh(Integer zyh) {
        this.zyh = zyh;
    }

    public String getZyhm() {
        return zyhm;
    }

    public void setZyhm(String zyhm) {
        this.zyhm = zyhm;
    }

    public Integer getBrbq() {
        return brbq;
    }

    public void setBrbq(Integer brbq) {
        this.brbq = brbq;
    }

    public String getBrch() {
        return brch;
    }

    public void setBrch(String brch) {
        this.brch = brch;
    }

    public String getBrxm() {
        return brxm;
    }

    public void setBrxm(String brxm) {
        this.brxm = brxm;
    }

    public Integer getBrxb() {
        return brxb;
    }

    public void setBrxb(Integer brxb) {
        this.brxb = brxb;
    }

    public Date getCsrq() {
        return csrq;
    }

    public void setCsrq(Date csrq) {
        this.csrq = csrq;
    }


    public String[] getSjd() {
        return sjd;
    }

    public void setSjd(String[] sjd) {
        this.sjd = sjd;
    }
}
