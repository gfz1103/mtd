package com.buit.his.sams.request;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;


/**
 * 类名称：SsSslx<br>
 * 类描述：新增手术类型入参<br>
 * @author zhouhaisheng
 */
@ApiModel(value="新增手术类型入参")
public class SsSslxAddReq {
    @ApiModelProperty(value="医疗机构id",hidden = true)
    private Integer jgid;
    @ApiModelProperty(value="手术类型")
    private String sslx;
    @ApiModelProperty(value="状态:0 使用/1 停用")
    private String zt;

    public Integer getJgid() {
        return jgid;
    }

    public void setJgid(Integer jgid) {
        this.jgid = jgid;
    }

    public String getSslx() {
        return sslx;
    }

    public void setSslx(String sslx) {
        this.sslx = sslx;
    }

    public String getZt() {
        return zt;
    }

    public void setZt(String zt) {
        this.zt = zt;
    }
}