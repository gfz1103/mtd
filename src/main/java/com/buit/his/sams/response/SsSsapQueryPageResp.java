package com.buit.his.sams.response;

import com.buit.commons.PageQuery;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.sql.Timestamp;


/**
 * 类名称：SsSsap<br>
 * 类描述：手术安排表<br>
 * @author zhouhaisheng
 */
@ApiModel(value="手术安排表")
public class SsSsapQueryPageResp extends  PageQuery{
    @ApiModelProperty(value="主键id")
    private Integer jlxh;
    @ApiModelProperty(value="医疗机构id")
    private Integer jgid;
    @ApiModelProperty(value="申请单号")
    private String sqdh;
    @ApiModelProperty(value="1 门诊/2 住院")
    private String brlx;
    @ApiModelProperty(value="门诊号码")
    private Integer mzhm;
    @ApiModelProperty(value="住院号码 ")
    private String zyhm;
    @ApiModelProperty(value="住院号")
    private Integer zyh;
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
    private String tsss;
    @ApiModelProperty(value="手术名称")
    private String ssmc;

    @ApiModelProperty(value="病情")
    private String bq;
    @ApiModelProperty(value="手术类型")
    private Integer sslx;
    @ApiModelProperty(value="手术医生代码")
    private Integer ssysdm;
    @ApiModelProperty(value="一助医生代码")
    private Integer yzysdm;
    @ApiModelProperty(value="二助医生代码")
    private Integer ezysdm;
    @ApiModelProperty(value="三助医生代码")
    private Integer szysdm;
    @ApiModelProperty(value="四助医生代码")
    private Integer sizysdm;
    @ApiModelProperty(value="麻醉医师代码")
    private Integer mzysdm;
    @ApiModelProperty(value="麻醉方法代码")
    private Integer mzffdm;
    @ApiModelProperty(value = "麻醉名称")
    private String mzmc;
    @ApiModelProperty(value = "术前准备")
    private String sqzb;
    @ApiModelProperty(value = "审批意见")
    private String spyj;
    @ApiModelProperty(value = "审批医生代码")
    private Integer spysdm;
    @ApiModelProperty(value = "手术状态 | 0：未安排    1：已安排    2：已完成")
    private Integer zt;
    @ApiModelProperty(value = "手术记账状态 | 0：未记账    1：已记账    2：已审核")
    private Integer ssjzzt;
    @ApiModelProperty(value = "麻醉记账状态 | 0：未记账    1：已记账    2：已审核")
    private Integer mzjzzt;
    @ApiModelProperty(value = "申请人代码")
    private Integer sqrdm;
    @ApiModelProperty(value = "申请时间")
    private Timestamp sqsj;
    @ApiModelProperty(value = "安排手术时间")
    private Timestamp apsssj;
    @ApiModelProperty(value = "手术间")
    private String ssj;
    @ApiModelProperty(value = "安排人代码")
    private Integer aprdm;
    @ApiModelProperty(value="麻醉助手代码")
    private Integer mzzsdm;
    @ApiModelProperty(value="巡回护士1代码")
    private Integer xhhsdmy;
    @ApiModelProperty(value="巡回护士2代码")
    private Integer xhhsdme;
    @ApiModelProperty(value="洗手护士1代码")
    private Integer xshsdmy;
    @ApiModelProperty(value="洗手护士2代码")
    private Integer xshsdme;
    @ApiModelProperty(value="操作时间")
    private Timestamp czsj;
    @ApiModelProperty(value = "出生年月")
    private Timestamp csny;
    @ApiModelProperty(value = "年龄")
    private Integer age;
    @ApiModelProperty(value = "就诊流水号")
    private String jzlsh;
    @ApiModelProperty(value = "病人性别")
    private Integer brxb;
    @ApiModelProperty(value = "病人姓名")
    private String brxm;
    @ApiModelProperty(value = "病人性质")
    private Integer brxz;

    public String getMzmc() {
        return mzmc;
    }

    public void setMzmc(String mzmc) {
        this.mzmc = mzmc;
    }

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

    public String getSqdh() {
        return sqdh;
    }

    public void setSqdh(String sqdh) {
        this.sqdh = sqdh;
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

    public String getTsss() {
        return tsss;
    }

    public void setTsss(String tsss) {
        this.tsss = tsss;
    }

    public String getSsmc() {
        return ssmc;
    }

    public void setSsmc(String ssmc) {
        this.ssmc = ssmc;
    }

    public String getBq() {
        return bq;
    }

    public void setBq(String bq) {
        this.bq = bq;
    }

    public Integer getSslx() {
        return sslx;
    }

    public void setSslx(Integer sslx) {
        this.sslx = sslx;
    }

    public Integer getSsysdm() {
        return ssysdm;
    }

    public void setSsysdm(Integer ssysdm) {
        this.ssysdm = ssysdm;
    }

    public Integer getYzysdm() {
        return yzysdm;
    }

    public void setYzysdm(Integer yzysdm) {
        this.yzysdm = yzysdm;
    }

    public Integer getEzysdm() {
        return ezysdm;
    }

    public void setEzysdm(Integer ezysdm) {
        this.ezysdm = ezysdm;
    }

    public Integer getSzysdm() {
        return szysdm;
    }

    public void setSzysdm(Integer szysdm) {
        this.szysdm = szysdm;
    }

    public Integer getSizysdm() {
        return sizysdm;
    }

    public void setSizysdm(Integer sizysdm) {
        this.sizysdm = sizysdm;
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

    public Integer getZt() {
        return zt;
    }

    public void setZt(Integer zt) {
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

    public Integer getAprdm() {
        return aprdm;
    }

    public void setAprdm(Integer aprdm) {
        this.aprdm = aprdm;
    }

    public Integer getMzzsdm() {
        return mzzsdm;
    }

    public void setMzzsdm(Integer mzzsdm) {
        this.mzzsdm = mzzsdm;
    }

    public Integer getXhhsdmy() {
        return xhhsdmy;
    }

    public void setXhhsdmy(Integer xhhsdmy) {
        this.xhhsdmy = xhhsdmy;
    }

    public Integer getXhhsdme() {
        return xhhsdme;
    }

    public void setXhhsdme(Integer xhhsdme) {
        this.xhhsdme = xhhsdme;
    }

    public Integer getXshsdmy() {
        return xshsdmy;
    }

    public void setXshsdmy(Integer xshsdmy) {
        this.xshsdmy = xshsdmy;
    }

    public Integer getXshsdme() {
        return xshsdme;
    }

    public void setXshsdme(Integer xshsdme) {
        this.xshsdme = xshsdme;
    }

    public Timestamp getCzsj() {
        return czsj;
    }

    public void setCzsj(Timestamp czsj) {
        this.czsj = czsj;
    }

    public Timestamp getApsssj() {
        return apsssj;
    }

    public void setApsssj(Timestamp apsssj) {
        this.apsssj = apsssj;
    }

    public String getSsj() {
        return ssj;
    }

    public void setSsj(String ssj) {
        this.ssj = ssj;
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

    public String getJzlsh() {
        return jzlsh;
    }

    public void setJzlsh(String jzlsh) {
        this.jzlsh = jzlsh;
    }

    public Integer getZyh() {
        return zyh;
    }

    public void setZyh(Integer zyh) {
        this.zyh = zyh;
    }

    public Integer getBrxb() {
        return brxb;
    }

    public void setBrxb(Integer brxb) {
        this.brxb = brxb;
    }

    public String getBrxm() {
        return brxm;
    }

    public void setBrxm(String brxm) {
        this.brxm = brxm;
    }

    public Integer getBrxz() {
        return brxz;
    }

    public void setBrxz(Integer brxz) {
        this.brxz = brxz;
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