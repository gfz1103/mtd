package com.buit.his.sams.request;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * 手术麻醉项目统计入参
 * zhouhaisheng
 */
@ApiModel(value = "手术麻醉项目统计入参")
public class SsmzxmReq {

    @ApiModelProperty(value = "手术室")
    private Integer ssj;
    @ApiModelProperty(value = "开始时间")
    private String startDate;
    @ApiModelProperty(value = "结束时间")
    private String endDate;
    @ApiModelProperty(value = "收费项目类别 | 1:材料    2:项目    3:药品")
    private String sfxmlb;
    @ApiModelProperty(value = "收费项目代码")
    private String sfxmdm;

    public Integer getSsj() {
        return ssj;
    }

    public void setSsj(Integer ssj) {
        this.ssj = ssj;
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

    public String getSfxmdm() {
        return sfxmdm;
    }

    public void setSfxmdm(String sfxmdm) {
        this.sfxmdm = sfxmdm;
    }

    public String getSfxmlb() {
        return sfxmlb;
    }

    public void setSfxmlb(String sfxmlb) {
        this.sfxmlb = sfxmlb;
    }
}
