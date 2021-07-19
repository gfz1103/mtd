package com.buit.his.treatment.request;

import com.buit.commons.PageQuery;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * 查询治疗申请单治疗项目分页查询入参
 * zhouhaishenng
 */
@ApiModel(value = "查询治疗申请单治疗项目分页查询入参")
public class QueryPatientZlyyReportDetailReq extends PageQuery {
    @ApiModelProperty(value = "机构id")
    private Integer jgid;
    @ApiModelProperty(value = "治疗申请单号")
    private String zlsqdh;

    public String getZlsqdh() {
        return zlsqdh;
    }

    public void setZlsqdh(String zlsqdh) {
        this.zlsqdh = zlsqdh;
    }

    public Integer getJgid() {
        return jgid;
    }

    public void setJgid(Integer jgid) {
        this.jgid = jgid;
    }
}
