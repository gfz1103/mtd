package com.buit.his.treatment.request;

/**
 * 治疗申请单验证参数
 * zhouhaisheng
 */
public class ZlsqdMxCheckReq {
    //记录序号
    private Integer jlxh;
    //住院号码
    private String zyhm;
    //机构id
    private Integer jgid;
    //治疗申请单号
    private String zlsqdh;
    //治疗项目名称
    private String zlxmmc;
    //门诊号码
    private Integer mzhm;
    //卡号
    private String kh;
    //就诊流水号
    private String jzlsh;

    public String getJzlsh() {
        return jzlsh;
    }

    public void setJzlsh(String jzlsh) {
        this.jzlsh = jzlsh;
    }

    public Integer getJlxh() {
        return jlxh;
    }

    public void setJlxh(Integer jlxh) {
        this.jlxh = jlxh;
    }

    public String getZyhm() {
        return zyhm;
    }

    public void setZyhm(String zyhm) {
        this.zyhm = zyhm;
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

    public String getZlxmmc() {
        return zlxmmc;
    }

    public void setZlxmmc(String zlxmmc) {
        this.zlxmmc = zlxmmc;
    }

    public Integer getMzhm() {
        return mzhm;
    }

    public void setMzhm(Integer mzhm) {
        this.mzhm = mzhm;
    }

    public String getKh() {
        return kh;
    }

    public void setKh(String kh) {
        this.kh = kh;
    }
}
