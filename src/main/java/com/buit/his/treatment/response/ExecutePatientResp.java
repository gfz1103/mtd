package com.buit.his.treatment.response;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.sql.Date;

/**
 * @Author jiangwei
 * @Date 2021-03-26
 * @Description
 **/
@ApiModel("查询住院康复治疗治疗患者列表返回参数")
public class ExecutePatientResp {
    @ApiModelProperty(value = "住院号（主键）")
    private Integer zyh;

    @ApiModelProperty(value = "住院号码（界面展示用）")
    private String zyhm;

    @ApiModelProperty(value = "病人病区")
    private Integer brbq;

    @ApiModelProperty(value = "病人科室")
    private Integer brks;

    @ApiModelProperty(value = "病人床号")
    private String brch;

    @ApiModelProperty(value = "病人姓名")
    private String brxm;

    @ApiModelProperty(value = "病人性别")
    private Integer brxb;

    @ApiModelProperty(value = "出生日期")
    private Date csrq;

    @ApiModelProperty(value = "患者情况")
    private String hzqk;

    @ApiModelProperty(value = "是否是新病人")
    private boolean isNew;

    @ApiModelProperty(value = "是否需要小结")
    private boolean isNeedSummary;

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

    public Integer getBrks() {
        return brks;
    }

    public void setBrks(Integer brks) {
        this.brks = brks;
    }

    public String getHzqk() {
        return hzqk;
    }

    public void setHzqk(String hzqk) {
        this.hzqk = hzqk;
    }

    public boolean isNew() {
        return isNew;
    }

    public void setNew(boolean aNew) {
        isNew = aNew;
    }

    public boolean isNeedSummary() {
        return isNeedSummary;
    }

    public void setNeedSummary(boolean needSummary) {
        isNeedSummary = needSummary;
    }
}
