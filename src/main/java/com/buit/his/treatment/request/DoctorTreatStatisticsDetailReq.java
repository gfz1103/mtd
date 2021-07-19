package com.buit.his.treatment.request;

import com.buit.commons.PageQuery;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * 医生治疗工作量统计出参
 * zhouhaisheng
 */
@ApiModel(value = "医生治疗工作量统计出参")
public class DoctorTreatStatisticsDetailReq extends PageQuery {

    @ApiModelProperty(value = "机构id",hidden = true)
    private  Integer jgid;
    @ApiModelProperty(value = "执行医生")
    private String zxys;
    @ApiModelProperty(value = "类别名称")
    private String lbmc;
    @ApiModelProperty(value = "治疗项目名称")
    private String zlxmmc;
    @ApiModelProperty(value = "病人类型 1门诊 2住院")
    private String brlx;
    @ApiModelProperty(value = "治疗科室代码")
    private  Integer zlksdm;
    @ApiModelProperty(value = "开始时间")
    private String startDate;
    @ApiModelProperty(value = "结束时间")
    private String endDate;

    public String getLbmc() {
        return lbmc;
    }

    public void setLbmc(String lbmc) {
        this.lbmc = lbmc;
    }

    public String getZlxmmc() {
        return zlxmmc;
    }

    public void setZlxmmc(String zlxmmc) {
        this.zlxmmc = zlxmmc;
    }

    public String getBrlx() {
        return brlx;
    }

    public void setBrlx(String brlx) {
        this.brlx = brlx;
    }


    public String getZxys() {
        return zxys;
    }

    public void setZxys(String zxys) {
        this.zxys = zxys;
    }

    public Integer getJgid() {
        return jgid;
    }

    public void setJgid(Integer jgid) {
        this.jgid = jgid;
    }

    public Integer getZlksdm() {
        return zlksdm;
    }

    public void setZlksdm(Integer zlksdm) {
        this.zlksdm = zlksdm;
    }

    public String getStartDate() {
        return startDate;
    }

    public void setStartDate(String startDate) {
        this.startDate = startDate;
    }

    public String getEndDate() {
        return endDate;
    }

    public void setEndDate(String endDate) {
        this.endDate = endDate;
    }
}
