package com.buit.his.treatment.response;

import com.buit.commons.PageQuery;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.sql.Timestamp;

/**
 * 病人治疗预约查询出参
 * zhouhaisheng
 */
@ApiModel(value = "病人治疗预约查询出参")
public class PatientZlyyQueryResp extends PageQuery {
    @ApiModelProperty(value="治疗项目明细id")
    private Integer jlxh;
    @ApiModelProperty(value="治疗申请单号")
    private String zlsqdh;
    @ApiModelProperty(value="就诊类型  1 门诊/2 住院")
    private String brlx;
    @ApiModelProperty(value="门诊号")
    private Integer mzhm;
    @ApiModelProperty(value="住院号")
    private String zyhm;
    @ApiModelProperty(value="病人姓名")
    private String brxm;
    @ApiModelProperty(value="病人性别")
    private Integer brxb;
    @ApiModelProperty(value="项目名称")
    private String zlxmmc;

    @ApiModelProperty(value="出生年月")
    private Timestamp csny;

    @ApiModelProperty(value="病人年龄")
    private Integer age;
    @ApiModelProperty(value="科室代码")
    private Integer ksdm;
    @ApiModelProperty(value="申请医生工号")
    private Integer sqysgh;
    @ApiModelProperty(value="申请时间")
    private Timestamp sqsj;
    @ApiModelProperty(value="状态 0 未预约(新开) 1 部分预约2 全部预约3 部分执行4 完成")
    private String zt;
    @ApiModelProperty(value="接收人工号")
    private Integer jsgh;
    @ApiModelProperty(value="接收时间")
    private Timestamp jssj;
    @ApiModelProperty(value="接收医生")
    private String jsys;
    @ApiModelProperty(value="申请医生")
    private String sqys;
    @ApiModelProperty(value="治疗类别名称")
    private String lbmc;
    @ApiModelProperty(value="治疗科室代码")
    private Integer zlksdm;
    @ApiModelProperty(value="完成人工号")
    private Integer wcgh;
    @ApiModelProperty(value="完成时间")
    private Timestamp wcrsj;
    @ApiModelProperty(value="取消完成人工号")
    private Integer qxwcgh;
    @ApiModelProperty(value="取消完成时间")
    private Timestamp qxwcsj;
    @ApiModelProperty(value="病人床号")
    private String brch;
    @ApiModelProperty(value="疗程次数")
    private Integer lccs;
    @ApiModelProperty(value="病人病区")
    private Integer bqdm;

    public Integer getJlxh() {
        return jlxh;
    }

    public void setJlxh(Integer jlxh) {
        this.jlxh = jlxh;
    }

    public String getZlsqdh() {
        return zlsqdh;
    }

    public void setZlsqdh(String zlsqdh) {
        this.zlsqdh = zlsqdh;
    }

    public String getBrlx() {
        return brlx;
    }

    public void setBrlx(String brlx) {
        this.brlx = brlx;
    }

    public Integer getMzhm() {
        return mzhm;
    }

    public void setMzhm(Integer mzhm) {
        this.mzhm = mzhm;
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

    public String getZlxmmc() {
        return zlxmmc;
    }

    public void setZlxmmc(String zlxmmc) {
        this.zlxmmc = zlxmmc;
    }

    public Timestamp getCsny() {
        return csny;
    }

    public void setCsny(Timestamp csny) {
        this.csny = csny;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public Integer getKsdm() {
        return ksdm;
    }

    public void setKsdm(Integer ksdm) {
        this.ksdm = ksdm;
    }

    public Integer getSqysgh() {
        return sqysgh;
    }

    public void setSqysgh(Integer sqysgh) {
        this.sqysgh = sqysgh;
    }

    public Timestamp getSqsj() {
        return sqsj;
    }

    public void setSqsj(Timestamp sqsj) {
        this.sqsj = sqsj;
    }

    public String getZt() {
        return zt;
    }

    public void setZt(String zt) {
        this.zt = zt;
    }



    public Integer getJsgh() {
        return jsgh;
    }

    public void setJsgh(Integer jsgh) {
        this.jsgh = jsgh;
    }

    public Timestamp getJssj() {
        return jssj;
    }

    public void setJssj(Timestamp jssj) {
        this.jssj = jssj;
    }

    public String getJsys() {
        return jsys;
    }

    public void setJsys(String jsys) {
        this.jsys = jsys;
    }

    public String getSqys() {
        return sqys;
    }

    public void setSqys(String sqys) {
        this.sqys = sqys;
    }

    public String getLbmc() {
        return lbmc;
    }

    public void setLbmc(String lbmc) {
        this.lbmc = lbmc;
    }

    public Integer getZlksdm() {
        return zlksdm;
    }

    public void setZlksdm(Integer zlksdm) {
        this.zlksdm = zlksdm;
    }

    public String getBrch() {
        return brch;
    }

    public void setBrch(String brch) {
        this.brch = brch;
    }

    public Integer getLccs() {
        return lccs;
    }

    public void setLccs(Integer lccs) {
        this.lccs = lccs;
    }

    public Integer getBqdm() {
        return bqdm;
    }

    public void setBqdm(Integer bqdm) {
        this.bqdm = bqdm;
    }

    public Integer getWcgh() {
        return wcgh;
    }

    public void setWcgh(Integer wcgh) {
        this.wcgh = wcgh;
    }

    public Timestamp getWcrsj() {
        return wcrsj;
    }

    public void setWcrsj(Timestamp wcrsj) {
        this.wcrsj = wcrsj;
    }

    public Integer getQxwcgh() {
        return qxwcgh;
    }

    public void setQxwcgh(Integer qxwcgh) {
        this.qxwcgh = qxwcgh;
    }

    public Timestamp getQxwcsj() {
        return qxwcsj;
    }

    public void setQxwcsj(Timestamp qxwcsj) {
        this.qxwcsj = qxwcsj;
    }
}
