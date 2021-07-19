package com.buit.his.sams.response;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.math.BigDecimal;
import java.sql.Timestamp;

/**
 * 手术记账基本信息查询
 * zhouhaisheng
 */
@ApiModel(value = "手术记账基本信息查询")
public class SsjzBaseInfoResp {
    @ApiModelProperty(value = "手术申请单号")
    private Integer sqdh;
    @ApiModelProperty(value = "手术安排记录序号")
    private Integer ssapJlxh;
    @ApiModelProperty(value = "病人卡号")
    private String cardNo;
    @ApiModelProperty(value = "病人姓名")
    private String brxm;
    @ApiModelProperty(value = "病人性别")
    private Integer brxb;
    @ApiModelProperty(value = "年龄")
    private Integer age;
    @ApiModelProperty(value = "出生年月", hidden = true)
    private Timestamp csny;
    @ApiModelProperty(value = "住院号")
    private Integer zyh;
    @ApiModelProperty(value = "住院号码")
    private String zyhm;
    @ApiModelProperty(value = "病人科室")
    private Integer brks;
    @ApiModelProperty(value = "病人病区")
    private Integer brbq;
    @ApiModelProperty(value = "病人床号")
    private String brch;
    @ApiModelProperty(value = "病人性质")
    private Integer brxz;
    @ApiModelProperty(value = "预交金合计")
    private BigDecimal yjhj;
    @ApiModelProperty(value = "费用合计")
    private BigDecimal fyhj;
    @ApiModelProperty(value = "余额合计")
    private BigDecimal yehj;
    @ApiModelProperty(value = "手术记账状态")
    private Integer ssjzzt;
    @ApiModelProperty(value = "麻醉记账状态")
    private Integer mzjzzt;

    public Integer getSqdh() {
        return sqdh;
    }

    public void setSqdh(Integer sqdh) {
        this.sqdh = sqdh;
    }

    public Integer getSsapJlxh() {
        return ssapJlxh;
    }

    public void setSsapJlxh(Integer ssapJlxh) {
        this.ssapJlxh = ssapJlxh;
    }

    public String getCardNo() {
        return cardNo;
    }

    public void setCardNo(String cardNo) {
        this.cardNo = cardNo;
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

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public Integer getZyh() {
        return zyh;
    }

    public void setZyh(Integer zyh) {
        this.zyh = zyh;
    }

    public String getZyhm() {
        return zyhm;
    }

    public void setZyhm(String zyhm) {
        this.zyhm = zyhm;
    }

    public Integer getBrks() {
        return brks;
    }

    public void setBrks(Integer brks) {
        this.brks = brks;
    }

    public Integer getBrbq() {
        return brbq;
    }

    public void setBrbq(Integer brbq) {
        this.brbq = brbq;
    }

    public String getBrch() {
        return brch;
    }

    public void setBrch(String brch) {
        this.brch = brch;
    }

    public Integer getBrxz() {
        return brxz;
    }

    public void setBrxz(Integer brxz) {
        this.brxz = brxz;
    }

    public BigDecimal getYjhj() {
        return yjhj;
    }

    public void setYjhj(BigDecimal yjhj) {
        this.yjhj = yjhj;
    }

    public BigDecimal getFyhj() {
        return fyhj;
    }

    public void setFyhj(BigDecimal fyhj) {
        this.fyhj = fyhj;
    }

    public BigDecimal getYehj() {
        return yehj;
    }

    public void setYehj(BigDecimal yehj) {
        this.yehj = yehj;
    }

    public Timestamp getCsny() {
        return csny;
    }

    public void setCsny(Timestamp csny) {
        this.csny = csny;
    }

    public Integer getSsjzzt() {
        return ssjzzt;
    }

    public void setSsjzzt(Integer ssjzzt) {
        this.ssjzzt = ssjzzt;
    }

    public Integer getMzjzzt() {
        return mzjzzt;
    }

    public void setMzjzzt(Integer mzjzzt) {
        this.mzjzzt = mzjzzt;
    }
}
