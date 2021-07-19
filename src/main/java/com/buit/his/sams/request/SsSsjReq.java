package com.buit.his.sams.request;

import com.buit.commons.PageQuery;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;


/**
 * 类名称：SsSsj<br>
 * 类描述：手术间设置表<br>
 * @author zhouhaisheng
 */
@ApiModel(value="手术间设置表")
public class SsSsjReq  extends  PageQuery{
    @ApiModelProperty(value="主键id")
    private Integer jlxh;
    @ApiModelProperty(value="医疗机构id")
    private Integer jgid;
    @ApiModelProperty(value="HIS科室代码")
    private String ssksdm;
    @ApiModelProperty(value="手术间")
    private String ssj;
    @ApiModelProperty(value="位置")
    private String wz;
    @ApiModelProperty(value="0 不可用/1 可用")
    private String zt;
    /**
     * 设置:主键id
     */
    public void setJlxh(Integer value) {
        this.jlxh = value;
    }
    /**
     * 获取:主键id
     */
    public Integer getJlxh() {
        return jlxh;
    }

    public Integer getJgid() {
        return jgid;
    }

    public void setJgid(Integer jgid) {
        this.jgid = jgid;
    }

    /**
     * 设置:HIS科室代码
     */
    public void setSsksdm(String value) {
        this.ssksdm = value;
    }
    /**
     * 获取:HIS科室代码
     */
    public String getSsksdm() {
        return ssksdm;
    }
    /**
     * 设置:手术间
     */
    public void setSsj(String value) {
        this.ssj = value;
    }
    /**
     * 获取:手术间
     */
    public String getSsj() {
        return ssj;
    }
    /**
     * 设置:位置
     */
    public void setWz(String value) {
        this.wz = value;
    }
    /**
     * 获取:位置
     */
    public String getWz() {
        return wz;
    }
    /**
     * 设置:0 不可用/1 可用
     */
    public void setZt(String value) {
        this.zt = value;
    }
    /**
     * 获取:0 不可用/1 可用
     */
    public String getZt() {
        return zt;
    }
}