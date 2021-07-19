package com.buit.his.sams.response;

import com.buit.commons.PageQuery;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;


/**
 * 类名称：SsGlbz<br>
 * 类描述：隔离标志表<br>
 * @author zhouhaisheng
 */
@ApiModel(value="隔离标志表")
public class SsGlbzResp  extends  PageQuery{
    @ApiModelProperty(value="主键id")
    private Integer jlxh;
    @ApiModelProperty(value="医疗机构id")
    private Integer jgid;
    @ApiModelProperty(value="隔离标志")
    private String glbz;
    @ApiModelProperty(value="拼音码")
    private String pym;
    @ApiModelProperty(value="五笔码")
    private String wbm;
    @ApiModelProperty(value="0 使用/1 停用")
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
    /**
     * 设置:医疗机构id
     */
    public void setJgid(Integer value) {
        this.jgid = value;
    }
    /**
     * 获取:医疗机构id
     */
    public Integer getJgid() {
        return jgid;
    }
    /**
     * 设置:隔离标志
     */
    public void setGlbz(String value) {
        this.glbz = value;
    }
    /**
     * 获取:隔离标志
     */
    public String getGlbz() {
        return glbz;
    }
    /**
     * 设置:拼音码
     */
    public void setPym(String value) {
        this.pym = value;
    }
    /**
     * 获取:拼音码
     */
    public String getPym() {
        return pym;
    }
    /**
     * 设置:五笔码
     */
    public void setWbm(String value) {
        this.wbm = value;
    }
    /**
     * 获取:五笔码
     */
    public String getWbm() {
        return wbm;
    }
    /**
     * 设置:0 使用/1 停用
     */
    public void setZt(String value) {
        this.zt = value;
    }
    /**
     * 获取:0 使用/1 停用
     */
    public String getZt() {
        return zt;
    }
}