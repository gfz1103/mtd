package com.buit.his.treatment.response;

import com.buit.commons.PageQuery;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.math.BigDecimal;
import java.sql.Timestamp;


/**
 * 类名称：ZlSqdmx<br>
 * 类描述：治疗申请单明细表分页查询<br>
 * @author ZHOUHAISHENG
 */
@ApiModel(value="治疗申请单明细表分页查询")
public class ZlSqdmxResp  extends  PageQuery{
    @ApiModelProperty(value="主键id")
    private Integer jlxh;
    @ApiModelProperty(value="医疗机构代码")
    private Integer jgid;
    @ApiModelProperty(value="治疗申请单号")
    private String zlsqdh;
    @ApiModelProperty(value="序号")
    private Integer xh;
    @ApiModelProperty(value="类别名称")
    private String lbmc;
    @ApiModelProperty(value="单位")
    private String dw;
    @ApiModelProperty(value="治疗项目名称")
    private String zlxmmc;
    @ApiModelProperty(value="执行疗程")
    private Integer zxlc;
    @ApiModelProperty(value="疗程次数")
    private Integer lccs;
    @ApiModelProperty(value="执行间隔")
    private Integer zxjg;
    @ApiModelProperty(value="数量")
    private BigDecimal sl;
    @ApiModelProperty(value="单价")
    private BigDecimal dj;
    @ApiModelProperty(value="金额")
    private BigDecimal je;
    @ApiModelProperty(value="治疗目标")
    private String zlmb;
    @ApiModelProperty(value="注意事项")
    private String zysx;
    @ApiModelProperty(value="状态0 未预约/1 部分预约/2 全部预约/3 部分执行/4 完成")
    private String zt;
    @ApiModelProperty(value="已预约数量")
    private BigDecimal yyycs;
    @ApiModelProperty(value="已执行数量")
    private BigDecimal yzxcs;
    @ApiModelProperty(value="完成人工号")
    private Integer wcgh;
    @ApiModelProperty(value="完成时间")
    private Timestamp wcrsj;
    @ApiModelProperty(value="取消完成人工号")
    private Integer qxwcgh;
    @ApiModelProperty(value="取消完成时间")
    private Timestamp qxwcsj;
    @ApiModelProperty(value="治疗项目的记录序号")
    private Integer zlxmJlxh;
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
     * 设置:治疗申请单号
     */
    public void setZlsqdh(String value) {
        this.zlsqdh = value;
    }
    /**
     * 获取:治疗申请单号
     */
    public String getZlsqdh() {
        return zlsqdh;
    }
    /**
     * 设置:序号
     */
    public void setXh(Integer value) {
        this.xh = value;
    }
    /**
     * 获取:序号
     */
    public Integer getXh() {
        return xh;
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
     * 设置:疗程次数
     */
    public void setZxlc(Integer value) {
        this.zxlc = value;
    }
    /**
     * 获取:疗程次数
     */
    public Integer getZxlc() {
        return zxlc;
    }
    /**
     * 设置:执行间隔
     */
    public void setLccs(Integer value) {
        this.lccs = value;
    }
    /**
     * 获取:执行间隔
     */
    public Integer getLccs() {
        return lccs;
    }
    /**
     * 设置:执行间隔
     */
    public void setZxjg(Integer value) {
        this.zxjg = value;
    }
    /**
     * 获取:执行间隔
     */
    public Integer getZxjg() {
        return zxjg;
    }
    /**
     * 设置:数量
     */
    public void setSl(BigDecimal value) {
        this.sl = value;
    }
    /**
     * 获取:数量
     */
    public BigDecimal getSl() {
        return sl;
    }
    /**
     * 设置:单价
     */
    public void setDj(BigDecimal value) {
        this.dj = value;
    }
    /**
     * 获取:单价
     */
    public BigDecimal getDj() {
        return dj;
    }
    /**
     * 设置:金额
     */
    public void setJe(BigDecimal value) {
        this.je = value;
    }
    /**
     * 获取:金额
     */
    public BigDecimal getJe() {
        return je;
    }
    /**
     * 设置:治疗目标
     */
    public void setZlmb(String value) {
        this.zlmb = value;
    }
    /**
     * 获取:治疗目标
     */
    public String getZlmb() {
        return zlmb;
    }
    /**
     * 设置:注意事项
     */
    public void setZysx(String value) {
        this.zysx = value;
    }
    /**
     * 获取:注意事项
     */
    public String getZysx() {
        return zysx;
    }
    /**
     * 设置:状态0 未预约/1 部分预约/2 全部预约/3 部分执行/4 完成
     */
    public void setZt(String value) {
        this.zt = value;
    }
    /**
     * 获取:状态0 未预约/1 部分预约/2 全部预约/3 部分执行/4 完成
     */
    public String getZt() {
        return zt;
    }
    /**
     * 设置:已预约数量
     */
    public void setYyycs(BigDecimal value) {
        this.yyycs = value;
    }
    /**
     * 获取:已预约数量
     */
    public BigDecimal getYyycs() {
        return yyycs;
    }
    /**
     * 设置:已执行数量
     */
    public void setYzxcs(BigDecimal value) {
        this.yzxcs = value;
    }
    /**
     * 获取:已执行数量
     */
    public BigDecimal getYzxcs() {
        return yzxcs;
    }
    /**
     * 设置:完成人工号
     */
    public void setWcgh(Integer value) {
        this.wcgh = value;
    }
    /**
     * 获取:完成人工号
     */
    public Integer getWcgh() {
        return wcgh;
    }
    /**
     * 设置:完成时间
     */
    public void setWcrsj(Timestamp value) {
        this.wcrsj = value;
    }
    /**
     * 获取:完成时间
     */
    public Timestamp getWcrsj() {
        return wcrsj;
    }
    /**
     * 设置:取消完成人工号
     */
    public void setQxwcgh(Integer value) {
        this.qxwcgh = value;
    }
    /**
     * 获取:取消完成人工号
     */
    public Integer getQxwcgh() {
        return qxwcgh;
    }
    /**
     * 设置:取消完成时间
     */
    public void setQxwcsj(Timestamp value) {
        this.qxwcsj = value;
    }
    /**
     * 获取:取消完成时间
     */
    public Timestamp getQxwcsj() {
        return qxwcsj;
    }

    public String getLbmc() {
        return lbmc;
    }

    public void setLbmc(String lbmc) {
        this.lbmc = lbmc;
    }

    public String getDw() {
        return dw;
    }

    public void setDw(String dw) {
        this.dw = dw;
    }

    public Integer getZlxmJlxh() {
        return zlxmJlxh;
    }

    public void setZlxmJlxh(Integer zlxmJlxh) {
        this.zlxmJlxh = zlxmJlxh;
    }

}