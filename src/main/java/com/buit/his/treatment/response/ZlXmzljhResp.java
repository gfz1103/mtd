package com.buit.his.treatment.response;

import com.buit.commons.PageQuery;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;


/**
 * 类名称：ZlXmzljh<br>
 * 类描述：治疗项目治疗计划表<br>
 * @author ZHOUHAISHENG
 */
@ApiModel(value="治疗项目治疗计划表")
public class ZlXmzljhResp  extends  PageQuery{
    @ApiModelProperty(value="主键id")
    private Integer jlxh;
    @ApiModelProperty(value="医疗机构代码")
    private Integer jgid;
    @ApiModelProperty(value="治疗科室代码")
    private Integer zlksdm;
    @ApiModelProperty(value="治疗项目名称")
    private String zlxmmc;
    @ApiModelProperty(value="排序号")
    private Integer pxh;
    @ApiModelProperty(value="治疗频次")
    private String zlpc;
    @ApiModelProperty(value="时间")
    private String sj;
    @ApiModelProperty(value="用量")
    private String yl;
    @ApiModelProperty(value="治疗方法")
    private String zlff;
    @ApiModelProperty(value="治疗部位")
    private String zlbw;
    @ApiModelProperty(value="治疗措施")
    private String zlcs;
    @ApiModelProperty(value="备注")
    private String bzxx;
    @ApiModelProperty(value="治疗项目ID")
    private Integer zlxmJlxh;

    public Integer getZlxmJlxh() {
        return zlxmJlxh;
    }

    public void setZlxmJlxh(Integer zlxmJlxh) {
        this.zlxmJlxh = zlxmJlxh;
    }

    public String getBzxx() {
        return bzxx;
    }

    public void setBzxx(String bzxx) {
        this.bzxx = bzxx;
    }

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
     * 设置:治疗项目名称
     */
    public void setZlxmmc(String value) {
        this.zlxmmc = value;
    }
    /**
     * 获取:治疗项目名称
     */
    public String getZlxmmc() {
        return zlxmmc;
    }
    /**
     * 设置:排序号
     */
    public void setPxh(Integer value) {
        this.pxh = value;
    }
    /**
     * 获取:排序号
     */
    public Integer getPxh() {
        return pxh;
    }
    /**
     * 设置:治疗频次
     */
    public void setZlpc(String value) {
        this.zlpc = value;
    }
    /**
     * 获取:治疗频次
     */
    public String getZlpc() {
        return zlpc;
    }
    /**
     * 设置:时间
     */
    public void setSj(String value) {
        this.sj = value;
    }
    /**
     * 获取:时间
     */
    public String getSj() {
        return sj;
    }
    /**
     * 设置:用量
     */
    public void setYl(String value) {
        this.yl = value;
    }
    /**
     * 获取:用量
     */
    public String getYl() {
        return yl;
    }
    /**
     * 设置:治疗方法
     */
    public void setZlff(String value) {
        this.zlff = value;
    }
    /**
     * 获取:治疗方法
     */
    public String getZlff() {
        return zlff;
    }
    /**
     * 设置:治疗部位
     */
    public void setZlbw(String value) {
        this.zlbw = value;
    }
    /**
     * 获取:治疗部位
     */
    public String getZlbw() {
        return zlbw;
    }
    /**
     * 设置:治疗措施
     */
    public void setZlcs(String value) {
        this.zlcs = value;
    }
    /**
     * 获取:治疗措施
     */
    public String getZlcs() {
        return zlcs;
    }
}
