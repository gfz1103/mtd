package com.buit.his.treatment.response;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * @Author weijing
 * @Date 2021-01-25 19:39
 * @Description
 **/
@ApiModel("治疗师信息返回")
public class ZlsMsgResp {
    @ApiModelProperty(value="医疗机构代码")
    private Integer jgid;
    @ApiModelProperty(value="治疗小组ID")
    private Integer zlzid;
    @ApiModelProperty(value="治疗师代码")
    private Integer zlsdm;
    @ApiModelProperty(value="治疗师科室代码")
    private Integer zlsks;

    public Integer getJgid() {
        return jgid;
    }

    public void setJgid(Integer jgid) {
        this.jgid = jgid;
    }

    public Integer getZlzid() {
        return zlzid;
    }

    public void setZlzid(Integer zlzid) {
        this.zlzid = zlzid;
    }

    public Integer getZlsdm() {
        return zlsdm;
    }

    public void setZlsdm(Integer zlsdm) {
        this.zlsdm = zlsdm;
    }

    public Integer getZlsks() {
        return zlsks;
    }

    public void setZlsks(Integer zlsks) {
        this.zlsks = zlsks;
    }
}
