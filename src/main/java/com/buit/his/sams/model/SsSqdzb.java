package com.buit.his.sams.model;

import com.buit.commons.PageQuery;
import io.swagger.annotations.ApiModelProperty;

import java.sql.Timestamp;

/**
 * 类名称：SsSqdzb<br> 
 * 类描述：手术申请单主表
 * @author zhouhaisheng
 * @ApiModel(value="手术申请单主表")
 */
public class SsSqdzb  extends  PageQuery{
	@ApiModelProperty(value="主键id")
    private Integer jlxh;
	@ApiModelProperty(value="医疗机构id")
    private Integer jgid;
	@ApiModelProperty(value="申请单号")
    private Integer sqdh;
	@ApiModelProperty(value="1 门诊/2 住院")
    private String brlx;
	@ApiModelProperty(value="门诊号码")
    private String mzhm;
	@ApiModelProperty(value="住院号码 ")
    private String zyhm;
	@ApiModelProperty(value="科室代码")
    private Integer ksdm;
	@ApiModelProperty(value="手术室代码")
    private Integer sssdm;
	@ApiModelProperty(value="拟行手术科室代码")
    private Integer nxssksdm;
	@ApiModelProperty(value="病区代码")
    private Integer bqdm;
	@ApiModelProperty(value="病人床号")
    private String brch;
	@ApiModelProperty(value="经济类型 1择期/2急诊")
    private String jjlx;
	@ApiModelProperty(value="手术时间")
    private Timestamp sssj;
	@ApiModelProperty(value="台次")
    private Integer tc;
	@ApiModelProperty(value="隔离标志 ")
    private String glbz;
	@ApiModelProperty(value="特殊手术名称")
    private String ttss;
	@ApiModelProperty(value="病情")
    private String bq;
	@ApiModelProperty(value="手术类型")
    private String sslx;
	@ApiModelProperty(value="手术医生")
    private String ssys;
	@ApiModelProperty(value="一助医生")
    private String yzys;
	@ApiModelProperty(value="二助医生")
    private String ezys;
	@ApiModelProperty(value="三助医生")
    private String szys;
	@ApiModelProperty(value="四助医生")
    private String sizys;
	@ApiModelProperty(value="麻醉医师代码")
    private Integer mzysdm;
	@ApiModelProperty(value="麻醉方法代码")
    private Integer mzffdm;
	@ApiModelProperty(value="术前准备")
    private String sqzb;
	@ApiModelProperty(value="审批意见")
    private String spyj;
	@ApiModelProperty(value="审批医生代码")
    private Integer spysdm;
	@ApiModelProperty(value="状态 0 申请/1 安排/2作废")
    private String zt;
	@ApiModelProperty(value="申请人代码")
    private Integer sqrdm;
	@ApiModelProperty(value="申请时间")
    private Timestamp sqsj;
    @ApiModelProperty(value="就诊流水号")
	private String jzlsh;

    @ApiModelProperty(value="出生年月")
    private Timestamp csny;
    @ApiModelProperty(value="年龄")
    private Integer age;
    @ApiModelProperty(value="病人姓名")
    private String brxm;
    @ApiModelProperty(value="病人性别")
    private Integer brxb;

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

    public Integer getSqdh() {
        return sqdh;
    }

    public void setSqdh(Integer sqdh) {
        this.sqdh = sqdh;
    }

    public String getBrlx() {
        return brlx;
    }

    public void setBrlx(String brlx) {
        this.brlx = brlx;
    }

    public String getMzhm() {
        return mzhm;
    }

    public void setMzhm(String mzhm) {
        this.mzhm = mzhm;
    }

    public String getZyhm() {
        return zyhm;
    }

    public void setZyhm(String zyhm) {
        this.zyhm = zyhm;
    }

    public Integer getKsdm() {
        return ksdm;
    }

    public void setKsdm(Integer ksdm) {
        this.ksdm = ksdm;
    }

    public Integer getSssdm() {
        return sssdm;
    }

    public void setSssdm(Integer sssdm) {
        this.sssdm = sssdm;
    }

    public Integer getNxssksdm() {
        return nxssksdm;
    }

    public void setNxssksdm(Integer nxssksdm) {
        this.nxssksdm = nxssksdm;
    }

    public Integer getBqdm() {
        return bqdm;
    }

    public void setBqdm(Integer bqdm) {
        this.bqdm = bqdm;
    }

    public String getBrch() {
        return brch;
    }

    public void setBrch(String brch) {
        this.brch = brch;
    }

    public String getJjlx() {
        return jjlx;
    }

    public void setJjlx(String jjlx) {
        this.jjlx = jjlx;
    }

    public Timestamp getSssj() {
        return sssj;
    }

    public void setSssj(Timestamp sssj) {
        this.sssj = sssj;
    }

    public Integer getTc() {
        return tc;
    }

    public void setTc(Integer tc) {
        this.tc = tc;
    }

    public String getGlbz() {
        return glbz;
    }

    public void setGlbz(String glbz) {
        this.glbz = glbz;
    }

    public String getTtss() {
        return ttss;
    }

    public void setTtss(String ttss) {
        this.ttss = ttss;
    }

    public String getBq() {
        return bq;
    }

    public void setBq(String bq) {
        this.bq = bq;
    }

    public String getSslx() {
        return sslx;
    }

    public void setSslx(String sslx) {
        this.sslx = sslx;
    }

    public String getSsys() {
        return ssys;
    }

    public void setSsys(String ssys) {
        this.ssys = ssys;
    }

    public String getYzys() {
        return yzys;
    }

    public void setYzys(String yzys) {
        this.yzys = yzys;
    }

    public String getEzys() {
        return ezys;
    }

    public void setEzys(String ezys) {
        this.ezys = ezys;
    }

    public String getSzys() {
        return szys;
    }

    public void setSzys(String szys) {
        this.szys = szys;
    }

    public String getSizys() {
        return sizys;
    }

    public void setSizys(String sizys) {
        this.sizys = sizys;
    }

    public Integer getMzysdm() {
        return mzysdm;
    }

    public void setMzysdm(Integer mzysdm) {
        this.mzysdm = mzysdm;
    }

    public Integer getMzffdm() {
        return mzffdm;
    }

    public void setMzffdm(Integer mzffdm) {
        this.mzffdm = mzffdm;
    }

    public String getSqzb() {
        return sqzb;
    }

    public void setSqzb(String sqzb) {
        this.sqzb = sqzb;
    }

    public String getSpyj() {
        return spyj;
    }

    public void setSpyj(String spyj) {
        this.spyj = spyj;
    }

    public Integer getSpysdm() {
        return spysdm;
    }

    public void setSpysdm(Integer spysdm) {
        this.spysdm = spysdm;
    }

    public String getZt() {
        return zt;
    }

    public void setZt(String zt) {
        this.zt = zt;
    }

    public Integer getSqrdm() {
        return sqrdm;
    }

    public void setSqrdm(Integer sqrdm) {
        this.sqrdm = sqrdm;
    }

    public Timestamp getSqsj() {
        return sqsj;
    }

    public void setSqsj(Timestamp sqsj) {
        this.sqsj = sqsj;
    }

    public String getJzlsh() {
        return jzlsh;
    }

    public void setJzlsh(String jzlsh) {
        this.jzlsh = jzlsh;
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
}