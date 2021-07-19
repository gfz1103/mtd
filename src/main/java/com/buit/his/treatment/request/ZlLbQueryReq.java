package com.buit.his.treatment.request;

import com.buit.commons.PageQuery;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * 类名称：ZlLb<br>
 * 类描述：治疗类别表
 *
 * @author ZHOUHAISHENG
 * @ApiModel(value="治疗类别表")
 */
@ApiModel(value = "治疗类别查询入参")
public class ZlLbQueryReq extends PageQuery {
    @ApiModelProperty(value = "医疗机构代码", hidden = true)
    private Integer jgid;
    @ApiModelProperty(value = "治疗科室代码")
    private Integer zlksdm;
    @ApiModelProperty(value = "类别名称")
    private String lbmc;

    /**
     * 设置:医疗机构代码
     */
    public void setJgid(Integer value) {
        this.jgid = value;
    }

    /**
     * 获取:医疗机构代码
     */
    public Integer getJgid() {
        return jgid;
    }

    /**
     * 设置:治疗科室代码
     */
    public void setZlksdm(Integer value) {
        this.zlksdm = value;
    }

    /**
     * 获取:治疗科室代码
     */
    public Integer getZlksdm() {
        return zlksdm;
    }

    /**
     * 设置:类别名称
     */
    public void setLbmc(String value) {
        this.lbmc = value;
    }

    /**
     * 获取:类别名称
     */
    public String getLbmc() {
        return lbmc;
    }

}