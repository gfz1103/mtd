package com.buit.his.treatment.response;

import com.buit.commons.PageQuery;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.sql.Timestamp;

/**
 *住院病人治疗预约查询出参
 * zhouhaisheng
 */
@ApiModel(value = "住院病人治疗预约查询出参")
public class ZybrZlyyTjResp extends PageQuery {

    @ApiModelProperty(value = "预约时间")
    private Timestamp yysj;
    @ApiModelProperty(value = "预约序号")
    private  String yyxh;
    @ApiModelProperty(value = "住院号码")
    private String zyhm;
    @ApiModelProperty(value = "病人姓名")
    private String brxm;
    @ApiModelProperty(value = "病人性别")
    private Integer brxb;
    @ApiModelProperty(value = "年龄")
    private String age;
    @ApiModelProperty(value = "治疗项目名称")
    private String zlxmmc;
    @ApiModelProperty(value = "治疗类别")
    private String lbmc;
    @ApiModelProperty(value = "治疗科室代码")
    private Integer zlksbm;
    @ApiModelProperty(value = "病人病区")
    private Integer brbq;
    @ApiModelProperty(value = "病人科室")
    private Integer brks;
    @ApiModelProperty(value = "病人床号")
    private Integer brch;
    @ApiModelProperty(value = "预约医生")
    private Integer yyys;
    @ApiModelProperty(value = "状态")
    private String zt;

    public Timestamp getYysj() {
        return yysj;
    }

    public void setYysj(Timestamp yysj) {
        this.yysj = yysj;
    }

    public String getYyxh() {
        return yyxh;
    }

    public void setYyxh(String yyxh) {
        this.yyxh = yyxh;
    }

    public String getZyhm() {
        return zyhm;
    }

    public void setZyhm(String zyhm) {
        this.zyhm = zyhm;
    }

    public String getBrxm() {
        return brxm;
    }

    public void setBrxm(String brxm) {
        this.brxm = brxm;
    }

    public Integer getBrxb() {
        return brxb;
    }

    public void setBrxb(Integer brxb) {
        this.brxb = brxb;
    }

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }

    public String getZlxmmc() {
        return zlxmmc;
    }

    public void setZlxmmc(String zlxmmc) {
        this.zlxmmc = zlxmmc;
    }

    public String getLbmc() {
        return lbmc;
    }

    public void setLbmc(String lbmc) {
        this.lbmc = lbmc;
    }

    public Integer getZlksbm() {
        return zlksbm;
    }

    public void setZlksbm(Integer zlksbm) {
        this.zlksbm = zlksbm;
    }

    public Integer getBrbq() {
        return brbq;
    }

    public void setBrbq(Integer brbq) {
        this.brbq = brbq;
    }

    public Integer getBrks() {
        return brks;
    }

    public void setBrks(Integer brks) {
        this.brks = brks;
    }

    public Integer getBrch() {
        return brch;
    }

    public void setBrch(Integer brch) {
        this.brch = brch;
    }

    public Integer getYyys() {
        return yyys;
    }

    public void setYyys(Integer yyys) {
        this.yyys = yyys;
    }

    public String getZt() {
        return zt;
    }

    public void setZt(String zt) {
        this.zt = zt;
    }
}
