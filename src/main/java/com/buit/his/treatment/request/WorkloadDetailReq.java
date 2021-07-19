package com.buit.his.treatment.request;

import com.buit.commons.PageQuery;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import javax.validation.constraints.NotNull;

/**
 * @Author jiangwei
 * @Date 2021-04-2 10:17
 **/
@ApiModel("工作量统计报表明细查询入参")
public class WorkloadDetailReq extends PageQuery {
    @ApiModelProperty(value = "医疗机构id", hidden = true)
    private Integer jgid;

    @NotNull
    @ApiModelProperty(value = "治疗类别")
    private Integer zllb;

    @NotNull
    @ApiModelProperty(value = "开始日期")
    private String ksrq;

    @NotNull
    @ApiModelProperty(value = "结束日期")
    private String jsrq;

    @NotNull
    @ApiModelProperty(value = "收费项目代码")
    private Integer sfxmdm;

    @ApiModelProperty(value = "执行工号")
    private Integer zxgh;

    public Integer getJgid() {
        return jgid;
    }

    public void setJgid(Integer jgid) {
        this.jgid = jgid;
    }

    public String getKsrq() {
        return ksrq;
    }

    public void setKsrq(String ksrq) {
        this.ksrq = ksrq;
    }

    public String getJsrq() {
        return jsrq;
    }

    public void setJsrq(String jsrq) {
        this.jsrq = jsrq;
    }

    public Integer getSfxmdm() {
        return sfxmdm;
    }

    public void setSfxmdm(Integer sfxmdm) {
        this.sfxmdm = sfxmdm;
    }

    public Integer getZxgh() {
        return zxgh;
    }

    public void setZxgh(Integer zxgh) {
        this.zxgh = zxgh;
    }

    public Integer getZllb() {
        return zllb;
    }

    public void setZllb(Integer zllb) {
        this.zllb = zllb;
    }
}
