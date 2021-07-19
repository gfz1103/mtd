package com.buit.his.sams.request;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;


/**
 * 类名称：SsJzmbzb<br>
 * 类描述：手术麻醉记账模板主表<br>
 * @author zhouhaisheng
 */
@ApiModel(value="手术麻醉记账模板主表")
public class SsJzmbzbAddReq {

    @ApiModelProperty(value="医疗机构id",hidden = true)
    private Integer jgid;
    @ApiModelProperty(value="1 手术记账模板/2 麻醉记账模板")
    private String mblx;
    @ApiModelProperty(value="模板名称")
    private String mbmc;
    @ApiModelProperty(value="1 公用/2 科室/3 个人")
    private String lx;
    @ApiModelProperty(value="创建科室代码")
    private Integer cjksdm;

    public Integer getJgid() {
        return jgid;
    }

    public void setJgid(Integer jgid) {
        this.jgid = jgid;
    }

    public String getMblx() {
        return mblx;
    }

    public void setMblx(String mblx) {
        this.mblx = mblx;
    }

    public String getMbmc() {
        return mbmc;
    }

    public void setMbmc(String mbmc) {
        this.mbmc = mbmc;
    }

    public String getLx() {
        return lx;
    }

    public void setLx(String lx) {
        this.lx = lx;
    }

    public Integer getCjksdm() {
        return cjksdm;
    }

    public void setCjksdm(Integer cjksdm) {
        this.cjksdm = cjksdm;
    }
}