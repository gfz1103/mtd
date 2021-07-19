package com.buit.his.treatment.request;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.math.BigDecimal;
import java.sql.Timestamp;

/**
 * 治疗预约申请单治疗预约主表保存
 * zhouhaisheng
 */
@ApiModel(value = "治疗预约申请单治疗预约主表保存")
public class ZlsqdyySaveOrUpdateReq {
    @ApiModelProperty(value="主键id")
    private Integer jlxh;
    @ApiModelProperty(value="医疗机构代码",hidden = true)
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
    @ApiModelProperty(value="预约操作工号",hidden = true)
    private Integer yyczgh;
    @ApiModelProperty(value="预约操作时间")
    private Timestamp yyczsj;
    @ApiModelProperty(value="状态 1 已预约2 已执行")
    private String zt;
    @ApiModelProperty(value="执行时间",hidden = true)
    private Timestamp zxsj;
    @ApiModelProperty(value="执行医生工号",hidden = true)
    private Integer zxygh;
    @ApiModelProperty(value="治疗总结",hidden = true)
    private String zlzj;
    @ApiModelProperty(value="备注",hidden = true)
    private String bz;
    @ApiModelProperty(value="执行记录时间",hidden = true)
    private Timestamp zxjlsj;
    @ApiModelProperty(value="执行记录人工号",hidden = true)
    private Integer zxjlgh;
    @ApiModelProperty(value="治疗申请单明细主键")
    private Integer zlSqdmxJlxh;

    public Integer getJlxh() {
        return jlxh;
    }

    public void setJlxh(Integer jlxh) {
        this.jlxh = jlxh;
    }

    public Integer getJgid() {
        return jgid;
    }

    public void setJgid(Integer jgid) {
        this.jgid = jgid;
    }

    public String getZlsqdh() {
        return zlsqdh;
    }

    public void setZlsqdh(String zlsqdh) {
        this.zlsqdh = zlsqdh;
    }

    public Integer getXh() {
        return xh;
    }

    public void setXh(Integer xh) {
        this.xh = xh;
    }

    public String getZlxmmc() {
        return zlxmmc;
    }

    public void setZlxmmc(String zlxmmc) {
        this.zlxmmc = zlxmmc;
    }

    public Timestamp getYysj() {
        return yysj;
    }

    public void setYysj(Timestamp yysj) {
        this.yysj = yysj;
    }

    public Integer getYyxh() {
        return yyxh;
    }

    public void setYyxh(Integer yyxh) {
        this.yyxh = yyxh;
    }

    public BigDecimal getBczlsl() {
        return bczlsl;
    }

    public void setBczlsl(BigDecimal bczlsl) {
        this.bczlsl = bczlsl;
    }

    public Integer getYyczgh() {
        return yyczgh;
    }

    public void setYyczgh(Integer yyczgh) {
        this.yyczgh = yyczgh;
    }

    public Timestamp getYyczsj() {
        return yyczsj;
    }

    public void setYyczsj(Timestamp yyczsj) {
        this.yyczsj = yyczsj;
    }

    public String getZt() {
        return zt;
    }

    public void setZt(String zt) {
        this.zt = zt;
    }

    public Timestamp getZxsj() {
        return zxsj;
    }

    public void setZxsj(Timestamp zxsj) {
        this.zxsj = zxsj;
    }

    public Integer getZxygh() {
        return zxygh;
    }

    public void setZxygh(Integer zxygh) {
        this.zxygh = zxygh;
    }

    public String getZlzj() {
        return zlzj;
    }

    public void setZlzj(String zlzj) {
        this.zlzj = zlzj;
    }

    public String getBz() {
        return bz;
    }

    public void setBz(String bz) {
        this.bz = bz;
    }

    public Timestamp getZxjlsj() {
        return zxjlsj;
    }

    public void setZxjlsj(Timestamp zxjlsj) {
        this.zxjlsj = zxjlsj;
    }

    public Integer getZxjlgh() {
        return zxjlgh;
    }

    public void setZxjlgh(Integer zxjlgh) {
        this.zxjlgh = zxjlgh;
    }

    public Integer getZlSqdmxJlxh() {
        return zlSqdmxJlxh;
    }

    public void setZlSqdmxJlxh(Integer zlSqdmxJlxh) {
        this.zlSqdmxJlxh = zlSqdmxJlxh;
    }
}
