package com.buit.his.treatment.response;

import com.buit.commons.PageQuery;
import com.fasterxml.jackson.annotation.JsonFormat;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.math.BigDecimal;

/**
 * 科室治疗工作量统计出参
 * zhouhaisheng
 */
@ApiModel(value = "科室治疗工作量统计出参")
public class DeptTreatStatisticsResp extends PageQuery {
    @ApiModelProperty(value = "类别名称")
    private String lbmc;
    @ApiModelProperty(value = "治疗项目名称")
    private String zlxmmc;
    @ApiModelProperty(value = "病人类型 1门诊 2住院")
    private String brlx;
    @ApiModelProperty(value = "总人次")
    private Integer persionCount;
    @ApiModelProperty(value = "总金额")
    private String moneyCount;

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

    public Integer getPersionCount() {
        return persionCount;
    }

    public void setPersionCount(Integer persionCount) {
        this.persionCount = persionCount;
    }

    public String getMoneyCount() {
        return moneyCount;
    }

    public void setMoneyCount(String moneyCount) {
        this.moneyCount = moneyCount;
    }
}
