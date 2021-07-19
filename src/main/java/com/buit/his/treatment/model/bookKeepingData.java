package com.buit.his.treatment.model;

import java.math.BigDecimal;

/**
 * @Author weijing
 * @Date 2021-01-29 13:17
 * @Description
 **/
public class bookKeepingData {
    /**医疗机构代码**/
    private Integer jgid;

    /**住院号**/
    private Integer zyh;

    /**费用序号**/
    private Integer fyxh;

    /**费用名称**/
    private String fymc;

    /**数量**/
    private BigDecimal sl;

    /**费用单价**/
    private BigDecimal fydj;

    /**医生工号**/
    private Integer ysgh;

    /**费用病区**/
    private Integer fybq;

    /**费用科室**/
    private Integer fyks;

    /**执行科室**/
    private Integer zxks;

    /**费用项目**/
    private Integer fyxm;

    /**自负比例**/
    private BigDecimal zfbl;

    public Integer getJgid() {
        return jgid;
    }

    public void setJgid(Integer jgid) {
        this.jgid = jgid;
    }

    public Integer getZyh() {
        return zyh;
    }

    public void setZyh(Integer zyh) {
        this.zyh = zyh;
    }

    public Integer getFyxh() {
        return fyxh;
    }

    public void setFyxh(Integer fyxh) {
        this.fyxh = fyxh;
    }

    public String getFymc() {
        return fymc;
    }

    public void setFymc(String fymc) {
        this.fymc = fymc;
    }

    public BigDecimal getSl() {
        return sl;
    }

    public void setSl(BigDecimal sl) {
        this.sl = sl;
    }

    public BigDecimal getFydj() {
        return fydj;
    }

    public void setFydj(BigDecimal fydj) {
        this.fydj = fydj;
    }

    public Integer getYsgh() {
        return ysgh;
    }

    public void setYsgh(Integer ysgh) {
        this.ysgh = ysgh;
    }

    public Integer getFybq() {
        return fybq;
    }

    public void setFybq(Integer fybq) {
        this.fybq = fybq;
    }

    public Integer getFyks() {
        return fyks;
    }

    public void setFyks(Integer fyks) {
        this.fyks = fyks;
    }

    public Integer getZxks() {
        return zxks;
    }

    public void setZxks(Integer zxks) {
        this.zxks = zxks;
    }

    public Integer getFyxm() {
        return fyxm;
    }

    public void setFyxm(Integer fyxm) {
        this.fyxm = fyxm;
    }

    public BigDecimal getZfbl() {
        return zfbl;
    }

    public void setZfbl(BigDecimal zfbl) {
        this.zfbl = zfbl;
    }
}
