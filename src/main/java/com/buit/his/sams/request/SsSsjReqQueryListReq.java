package com.buit.his.sams.request;

import com.buit.commons.PageQuery;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;


/**
 * 手术间列表查询
 * zhouhaisheng
 */
@ApiModel(value="手术间列表查询")
public class SsSsjReqQueryListReq {

    @ApiModelProperty(value="医疗机构id",hidden = true)
    private Integer jgid;
    @ApiModelProperty(value="HIS科室代码")
    private String ssksdm;

    public Integer getJgid() {
        return jgid;
    }

    public void setJgid(Integer jgid) {
        this.jgid = jgid;
    }

    public String getSsksdm() {
        return ssksdm;
    }

    public void setSsksdm(String ssksdm) {
        this.ssksdm = ssksdm;
    }
}