package com.buit.his.treatment.request;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * 科室治疗工作量统计入参
 *
 */
@ApiModel(value = "科室治疗工作量统计入参")
public class DeptTreatStatisticsDetailReq extends DeptTreatStatisticsReq{
    @ApiModelProperty(value = "类别名称")
    private String lbmc;
    @ApiModelProperty(value = "治疗项目名称")
    private String zlxmmc;

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
}
