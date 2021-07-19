package com.buit.his.treatment.request;

import com.buit.commons.PageQuery;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.math.BigDecimal;
import java.sql.Timestamp;


/**
 * 类名称：ZlSqdyyzx<br>
 * 类描述：治疗申请单预约执行表<br>
 * @author ZHOUHAISHENG
 */
@ApiModel(value="治疗申请单预约执行表")
public class ZlSqdyyzxReq  extends  PageQuery{
    @ApiModelProperty(value="主键id")
    private Integer jlxh;
    @ApiModelProperty(value="医疗机构代码")
    private Integer jgid;
    @ApiModelProperty(value="治疗申请单号")
    private String zlsqdh;
    @ApiModelProperty(value="治疗申请单序号")
    private Integer xh;
    @ApiModelProperty(value="治疗项目名称")
    private String zlxmmc;
    @ApiModelProperty(value="预约时间")
    private Timestamp yysj;
    @ApiModelProperty(value="预约序号")
    private Integer yyxh;
    @ApiModelProperty(value="本次治疗数量")
    private BigDecimal bczlsl;
    @ApiModelProperty(value="预约操作工号")
    private Integer yyczgh;
    @ApiModelProperty(value="预约操作时间")
    private Timestamp yyczsj;
    @ApiModelProperty(value="状态 1 已预约2 已执行")
    private String zt;
    @ApiModelProperty(value="执行时间")
    private Timestamp zxsj;
    @ApiModelProperty(value="执行医生工号")
    private Integer zxygh;
    @ApiModelProperty(value="治疗总结")
    private String zlzj;
    @ApiModelProperty(value="备注")
    private String bz;
    @ApiModelProperty(value="执行记录时间")
    private Timestamp zxjlsj;
    @ApiModelProperty(value="执行记录人工号")
    private Integer zxjlgh;
    @ApiModelProperty(value="治疗申请单明细主键")
    private Integer zlSqdmxJlxh;


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
     * 设置:治疗申请单序号
     */
    public void setXh(Integer value) {
        this.xh = value;
    }
    /**
     * 获取:治疗申请单序号
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
     * 设置:预约时间
     */
    public void setYysj(Timestamp value) {
        this.yysj = value;
    }
    /**
     * 获取:预约时间
     */
    public Timestamp getYysj() {
        return yysj;
    }
    /**
     * 设置:预约序号
     */
    public void setYyxh(Integer value) {
        this.yyxh = value;
    }
    /**
     * 获取:预约序号
     */
    public Integer getYyxh() {
        return yyxh;
    }
    /**
     * 设置:本次治疗数量
     */
    public void setBczlsl(BigDecimal value) {
        this.bczlsl = value;
    }
    /**
     * 获取:本次治疗数量
     */
    public BigDecimal getBczlsl() {
        return bczlsl;
    }
    /**
     * 设置:预约操作工号
     */
    public void setYyczgh(Integer value) {
        this.yyczgh = value;
    }
    /**
     * 获取:预约操作工号
     */
    public Integer getYyczgh() {
        return yyczgh;
    }
    /**
     * 设置:预约操作时间
     */
    public void setYyczsj(Timestamp value) {
        this.yyczsj = value;
    }
    /**
     * 获取:预约操作时间
     */
    public Timestamp getYyczsj() {
        return yyczsj;
    }
    /**
     * 设置:状态 1 已预约2 已执行
     */
    public void setZt(String value) {
        this.zt = value;
    }
    /**
     * 获取:状态 1 已预约2 已执行
     */
    public String getZt() {
        return zt;
    }
    /**
     * 设置:执行时间
     */
    public void setZxsj(Timestamp value) {
        this.zxsj = value;
    }
    /**
     * 获取:执行时间
     */
    public Timestamp getZxsj() {
        return zxsj;
    }
    /**
     * 设置:执行医生工号
     */
    public void setZxygh(Integer value) {
        this.zxygh = value;
    }
    /**
     * 获取:执行医生工号
     */
    public Integer getZxygh() {
        return zxygh;
    }
    /**
     * 设置:治疗总结
     */
    public void setZlzj(String value) {
        this.zlzj = value;
    }
    /**
     * 获取:治疗总结
     */
    public String getZlzj() {
        return zlzj;
    }
    /**
     * 设置:备注
     */
    public void setBz(String value) {
        this.bz = value;
    }
    /**
     * 获取:备注
     */
    public String getBz() {
        return bz;
    }
    /**
     * 设置:执行记录时间
     */
    public void setZxjlsj(Timestamp value) {
        this.zxjlsj = value;
    }
    /**
     * 获取:执行记录时间
     */
    public Timestamp getZxjlsj() {
        return zxjlsj;
    }
    /**
     * 设置:执行记录人工号
     */
    public void setZxjlgh(Integer value) {
        this.zxjlgh = value;
    }
    /**
     * 获取:执行记录人工号
     */
    public Integer getZxjlgh() {
        return zxjlgh;
    }

    public Integer getZlSqdmxJlxh() {
        return zlSqdmxJlxh;
    }

    public void setZlSqdmxJlxh(Integer zlSqdmxJlxh) {
        this.zlSqdmxJlxh = zlSqdmxJlxh;
    }
}