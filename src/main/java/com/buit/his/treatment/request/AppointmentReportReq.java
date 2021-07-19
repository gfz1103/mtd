package com.buit.his.treatment.request;

import com.buit.commons.PageQuery;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import javax.validation.constraints.NotNull;

/**
 * @Author jiangwei
 * @Date 2021-03-31 16:16
 **/
@ApiModel("住院病人治疗预约查询")
public class AppointmentReportReq extends PageQuery {
    @ApiModelProperty(value = "医疗机构id", hidden = true)
    private Integer jgid;

    @NotNull
    @ApiModelProperty(value = "诊疗类别")
    private Integer zllb;

    @ApiModelProperty(value = "病人病区")
    private Integer brbq;

    @ApiModelProperty(value = "住院号码")
    private String zyhm;

    @ApiModelProperty(value = "出院判别 | 1：在院    2：出院")
    private Integer cypb;

    public Integer getJgid() {
        return jgid;
    }

    public void setJgid(Integer jgid) {
        this.jgid = jgid;
    }

    public Integer getZllb() {
        return zllb;
    }

    public void setZllb(Integer zllb) {
        this.zllb = zllb;
    }

    public Integer getBrbq() {
        return brbq;
    }

    public void setBrbq(Integer brbq) {
        this.brbq = brbq;
    }

    public String getZyhm() {
        return zyhm;
    }

    public void setZyhm(String zyhm) {
        this.zyhm = zyhm;
    }

    public Integer getCypb() {
        return cypb;
    }

    public void setCypb(Integer cypb) {
        this.cypb = cypb;
    }
}
