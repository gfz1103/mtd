package com.buit.his.sams.request;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;


/**
 * 类名称：SsGlbz<br>
 * 类描述：隔离标志新增入参<br>
 * @author zhouhaisheng
 */
@ApiModel(value="隔离标志新增入参")
public class SsGlbzAddReq {

    @ApiModelProperty(value="医疗机构id",hidden = true)
    private Integer jgid;
    @ApiModelProperty(value="隔离标志")
    private String glbz;

    public Integer getJgid() {
        return jgid;
    }

    public void setJgid(Integer jgid) {
        this.jgid = jgid;
    }

    public String getGlbz() {
        return glbz;
    }

    public void setGlbz(String glbz) {
        this.glbz = glbz;
    }
}