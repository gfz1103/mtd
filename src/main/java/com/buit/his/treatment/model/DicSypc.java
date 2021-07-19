package com.buit.his.treatment.model;

import com.buit.commons.PageQuery;
import io.swagger.annotations.ApiModelProperty;

/**
 * 类名称：DicSypc<br>
 * 类描述：公用_使用频次
 *
 * @author GONGFANGZHOU
 * @ApiModel(value="公用_使用频次")
 */
public class DicSypc extends PageQuery {
    @ApiModelProperty(value = "频次编码")
    private String pcbm;
    @ApiModelProperty(value = "频次名称")
    private String pcmc;
    @ApiModelProperty(value = "每日次数")
    private Integer mrcs;
    @ApiModelProperty(value = "最小周期")
    private Integer zxzq;
    @ApiModelProperty(value = "日历周标志")
    private Integer rlz;
    @ApiModelProperty(value = "执行时间")
    private String zxsj;
    @ApiModelProperty(value = "日执行周期")
    private String rzxzq;
    @ApiModelProperty(value = "bzxx")
    private String bzxx;
    @ApiModelProperty(value = "排列顺序")
    private Integer plsx;

    /**
     * 设置:频次编码
     */
    public void setPcbm(String value) {
        this.pcbm = value;
    }

    /**
     * 获取:频次编码
     */
    public String getPcbm() {
        return pcbm;
    }

    /**
     * 设置:频次名称
     */
    public void setPcmc(String value) {
        this.pcmc = value;
    }

    /**
     * 获取:频次名称
     */
    public String getPcmc() {
        return pcmc;
    }

    /**
     * 设置:每日次数
     */
    public void setMrcs(Integer value) {
        this.mrcs = value;
    }

    /**
     * 获取:每日次数
     */
    public Integer getMrcs() {
        return mrcs;
    }

    /**
     * 设置:最小周期
     */
    public void setZxzq(Integer value) {
        this.zxzq = value;
    }

    /**
     * 获取:最小周期
     */
    public Integer getZxzq() {
        return zxzq;
    }

    /**
     * 设置:日历周标志
     */
    public void setRlz(Integer value) {
        this.rlz = value;
    }

    /**
     * 获取:日历周标志
     */
    public Integer getRlz() {
        return rlz;
    }

    /**
     * 设置:执行时间
     */
    public void setZxsj(String value) {
        this.zxsj = value;
    }

    /**
     * 获取:执行时间
     */
    public String getZxsj() {
        return zxsj;
    }

    /**
     * 设置:日执行周期
     */
    public void setRzxzq(String value) {
        this.rzxzq = value;
    }

    /**
     * 获取:日执行周期
     */
    public String getRzxzq() {
        return rzxzq;
    }

    /**
     * 设置:bzxx
     */
    public void setBzxx(String value) {
        this.bzxx = value;
    }

    /**
     * 获取:bzxx
     */
    public String getBzxx() {
        return bzxx;
    }

    /**
     * 设置:排列顺序
     */
    public void setPlsx(Integer value) {
        this.plsx = value;
    }

    /**
     * 获取:排列顺序
     */
    public Integer getPlsx() {
        return plsx;
    }


}
