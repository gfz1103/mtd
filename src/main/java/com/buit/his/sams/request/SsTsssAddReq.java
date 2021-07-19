package com.buit.his.sams.request;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;


/**
 * 类名称：SsTsss<br>
 * 类描述：新增特殊手术入参<br>
 * @author zhouhaisheng
 */
@ApiModel(value="新增特殊手术入参")
public class SsTsssAddReq {

    @ApiModelProperty(value="机构id",hidden = true)
    private Integer jgid;
    @ApiModelProperty(value="特殊手术名称")
    private String tsssmc;

    public Integer getJgid() {
        return jgid;
    }

    public void setJgid(Integer jgid) {
        this.jgid = jgid;
    }

    public String getTsssmc() {
        return tsssmc;
    }

    public void setTsssmc(String tsssmc) {
        this.tsssmc = tsssmc;
    }
}