package com.buit.his.treatment.request;

import com.buit.commons.PageQuery;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * 病人治疗申请单查询入参
 * zhouhaisheng
 */
@ApiModel(value = "病人治疗申请单查询入参")
public class PatientTreatFromQueryReq extends PageQuery {
    @ApiModelProperty(value = "医疗机构id",hidden = true)
    private Integer jgid;
    @ApiModelProperty(value = "治疗科室代码")
    private Integer zlksdm;
    @ApiModelProperty(value = "开始时间")
    private String startDate;
    @ApiModelProperty(value = "结束时间")
    private String endDate;
    @ApiModelProperty(value = "住院号、病人姓名")
    private String queryParam;
    @ApiModelProperty(value="状态 1未完成 2：已完成")
    private String zt;
    @ApiModelProperty(value="作废标志 0未作废 1已作废")
    private String zf;


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

    public String getQueryParam() {
        return queryParam;
    }

    public void setQueryParam(String queryParam) {
        this.queryParam = queryParam;
    }

    public String getZt() {
        return zt;
    }

    public void setZt(String zt) {
        this.zt = zt;
    }

    public String getZf() {
        return zf;
    }

    public void setZf(String zf) {
        this.zf = zf;
    }

}
