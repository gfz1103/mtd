package com.buit.his.treatment.model;

import com.buit.commons.PageQuery;

import java.math.BigDecimal;
import java.sql.Timestamp;

/**
 * 类名称：ZlRwfp<br> 
 * 类描述：康复治疗任务分配表
 * @author 韦靖 
 * @ApiModel(value="康复治疗任务分配表")
 */
public class ZlRwfp  extends  PageQuery{
	//@ApiModelProperty(value="康复治疗任务分配ID")
    /** 康复治疗任务分配ID */
    private Integer zlrwfpid;
	//@ApiModelProperty(value="医疗机构代码")
    /**
     * 医疗机构代码
     */
    private Integer jgid;
    //@ApiModelProperty(value="住院号")
    /**
     * 住院号
     */
    private Integer zyh;
    /**
     * 康复医嘱记录序号
     */
    private Integer yzJlxh;
    //@ApiModelProperty(value="治疗类别")
    /**
     * 治疗类别
     */
    private Integer zllb;
    //@ApiModelProperty(value="分配状态 | 0：未分配    2：已分配")
    /**
     * 分配状态 | 0：未分配    2：已分配
     */
    private Integer fpzt;
    //@ApiModelProperty(value="治疗小组ID")
    /**
     * 治疗小组ID
     */
    private Integer zlzid;
    //@ApiModelProperty(value="治疗师代码")
    /**
     * 治疗师代码
     */
    private Integer zlsdm;
    //@ApiModelProperty(value="分配时间")
    /**
     * 分配时间
     */
    private Timestamp fpsj;
    /**
     * 治疗科室代码
     */
    private Integer zlksdm;
    /**
     * 收费项目代码
     */
    private String sfxmdm;
    /**
     * 收费项目名称
     */
    private String sfxmmc;
    /**
     * 数量
     */
    private BigDecimal sl;
    /**
     * 金额
     */
    private BigDecimal je;

    /**
     * 首次执行日期
     */
    private String sczxrq;
    /**
     * 执行状态 | 0：未执行    1：部分执行    2：已执行
     */
    private Integer zxzt;

    /**
     * 下次执行日期 | 定时任务下次启动日期
     */
    private String xczxrq;

    /**
     * 设置:康复治疗任务分配ID
     */
    public void setZlrwfpid(Integer value) {
        this.zlrwfpid = value;
    }

    /**
     * 获取:康复治疗任务分配ID
     */
    public Integer getZlrwfpid() {
        return zlrwfpid;
    }

    /** 设置:医疗机构代码  */
    public void setJgid(Integer value) {
        this.jgid = value;
    }
    /** 获取:医疗机构代码 */
    public Integer getJgid() {
        return jgid;
    }

    /** 设置:住院号  */
    public void setZyh(Integer value) {
        this.zyh = value;
    }
    /** 获取:住院号 */
    public Integer getZyh() {
        return zyh;
    }

    /** 设置:治疗类别  */
    public void setZllb(Integer value) {
        this.zllb = value;
    }
    /** 获取:治疗类别 */
    public Integer getZllb() {
        return zllb;
    }

    public void setFpzt(Integer value) {
        this.fpzt = value;
    }

    public Integer getFpzt() {
        return fpzt;
    }

    /** 设置:治疗小组ID  */
    public void setZlzid(Integer value) {
        this.zlzid = value;
    }
    /** 获取:治疗小组ID */
    public Integer getZlzid() {
        return zlzid;
    }

    /** 设置:治疗师代码  */
    public void setZlsdm(Integer value) {
        this.zlsdm = value;
    }
    /** 获取:治疗师代码 */
    public Integer getZlsdm() {
        return zlsdm;
    }

    /** 设置:分配时间  */
    public void setFpsj(Timestamp value) {
        this.fpsj = value;
    }

    /**
     * 获取:分配时间
     */
    public Timestamp getFpsj() {
        return fpsj;
    }

    public Integer getYzJlxh() {
        return yzJlxh;
    }

    public void setYzJlxh(Integer yzJlxh) {
        this.yzJlxh = yzJlxh;
    }

    public Integer getZlksdm() {
        return zlksdm;
    }

    public void setZlksdm(Integer zlksdm) {
        this.zlksdm = zlksdm;
    }

    public String getSfxmdm() {
        return sfxmdm;
    }

    public void setSfxmdm(String sfxmdm) {
        this.sfxmdm = sfxmdm;
    }

    public String getSfxmmc() {
        return sfxmmc;
    }

    public void setSfxmmc(String sfxmmc) {
        this.sfxmmc = sfxmmc;
    }

    public BigDecimal getSl() {
        return sl;
    }

    public void setSl(BigDecimal sl) {
        this.sl = sl;
    }

    public BigDecimal getJe() {
        return je;
    }

    public void setJe(BigDecimal je) {
        this.je = je;
    }

    public String getSczxrq() {
        return sczxrq;
    }

    public void setSczxrq(String sczxrq) {
        this.sczxrq = sczxrq;
    }

    public Integer getZxzt() {
        return zxzt;
    }

    public void setZxzt(Integer zxzt) {
        this.zxzt = zxzt;
    }

    public String getXczxrq() {
        return xczxrq;
    }

    public void setXczxrq(String xczxrq) {
        this.xczxrq = xczxrq;
    }
}