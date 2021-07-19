package com.buit.his.sams.response;

import com.buit.his.sams.model.SsSqdzd;
import com.buit.commons.PageQuery;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.sql.Timestamp;
import java.util.List;


/**
 * 类名称：SsSqdzb<br>
 * 类描述：手术申请单分页查询出参<br>
 * @author zhouhaisheng
 */
@ApiModel(value="手术申请单分页查询出参")
public class SsSqdzbPageQueryResp extends  PageQuery{
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
    @ApiModelProperty(value="紧急类型 1择期/2急诊")
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
    @ApiModelProperty(value="手术申请单诊断集合")
    private List<SsSqdzd> sssqdzdList;
    @ApiModelProperty(value="手术申请单诊断")
    private String sssqdzdStr;

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
     * 设置:医疗机构id
     */
    public void setJgid(Integer value) {
        this.jgid = value;
    }
    /**
     * 获取:医疗机构id
     */
    public Integer getJgid() {
        return jgid;
    }
    /**
     * 设置:申请单号
     */
    public void setSqdh(String value) {
        this.sqdh = value;
    }
    /**
     * 获取:申请单号
     */
    public String getSqdh() {
        return sqdh;
    }
    /**
     * 设置:1 门诊/2 住院
     */
    public void setBrlx(String value) {
        this.brlx = value;
    }
    /**
     * 获取:1 门诊/2 住院
     */
    public String getBrlx() {
        return brlx;
    }
    /**
     * 设置:门诊号码
     */
    public void setMzhm(Integer value) {
        this.mzhm = value;
    }
    /**
     * 获取:门诊号码
     */
    public Integer getMzhm() {
        return mzhm;
    }
    /**
     * 设置:住院号码 
     */
    public void setZyhm(String value) {
        this.zyhm = value;
    }
    /**
     * 获取:住院号码 
     */
    public String getZyhm() {
        return zyhm;
    }
    /**
     * 设置:科室代码
     */
    public void setKsdm(Integer value) {
        this.ksdm = value;
    }
    /**
     * 获取:科室代码
     */
    public Integer getKsdm() {
        return ksdm;
    }
    /**
     * 设置:手术室代码
     */
    public void setSssdm(Integer value) {
        this.sssdm = value;
    }
    /**
     * 获取:手术室代码
     */
    public Integer getSssdm() {
        return sssdm;
    }
    /**
     * 设置:拟行手术科室代码
     */
    public void setNxssksdm(Integer value) {
        this.nxssksdm = value;
    }
    /**
     * 获取:拟行手术科室代码
     */
    public Integer getNxssksdm() {
        return nxssksdm;
    }
    /**
     * 设置:病区代码
     */
    public void setBqdm(Integer value) {
        this.bqdm = value;
    }
    /**
     * 获取:病区代码
     */
    public Integer getBqdm() {
        return bqdm;
    }
    /**
     * 设置:病人床号
     */
    public void setBrch(String value) {
        this.brch = value;
    }
    /**
     * 获取:病人床号
     */
    public String getBrch() {
        return brch;
    }
    /**
     * 设置:经济类型 1择期/2急诊
     */
    public void setJjlx(String value) {
        this.jjlx = value;
    }
    /**
     * 获取:经济类型 1择期/2急诊
     */
    public String getJjlx() {
        return jjlx;
    }
    /**
     * 设置:手术时间
     */
    public void setSssj(Timestamp value) {
        this.sssj = value;
    }
    /**
     * 获取:手术时间
     */
    public Timestamp getSssj() {
        return sssj;
    }
    /**
     * 设置:台次
     */
    public void setTc(Integer value) {
        this.tc = value;
    }
    /**
     * 获取:台次
     */
    public Integer getTc() {
        return tc;
    }
    /**
     * 设置:隔离标志 
     */
    public void setGlbz(String value) {
        this.glbz = value;
    }
    /**
     * 获取:隔离标志 
     */
    public String getGlbz() {
        return glbz;
    }
    /**
     * 设置:特殊手术名称
     */
    public void setTtss(String value) {
        this.ttss = value;
    }
    /**
     * 获取:特殊手术名称
     */
    public String getTtss() {
        return ttss;
    }
    /**
     * 设置:病情
     */
    public void setBq(String value) {
        this.bq = value;
    }
    /**
     * 获取:病情
     */
    public String getBq() {
        return bq;
    }
    /**
     * 设置:手术类型
     */
    public void setSslx(String value) {
        this.sslx = value;
    }
    /**
     * 获取:手术类型
     */
    public String getSslx() {
        return sslx;
    }
    /**
     * 设置:手术医生代码
     */
    public void setSsysdm(Integer value) {
        this.ssysdm = value;
    }
    /**
     * 获取:手术医生代码
     */
    public Integer getSsysdm() {
        return ssysdm;
    }
    /**
     * 设置:一助医生代码
     */
    public void setYzysdm(Integer value) {
        this.yzysdm = value;
    }
    /**
     * 获取:一助医生代码
     */
    public Integer getYzysdm() {
        return yzysdm;
    }
    /**
     * 设置:二助医生代码
     */
    public void setEzysdm(Integer value) {
        this.ezysdm = value;
    }
    /**
     * 获取:二助医生代码
     */
    public Integer getEzysdm() {
        return ezysdm;
    }
    /**
     * 设置:三助医生代码
     */
    public void setSzysdm(Integer value) {
        this.szysdm = value;
    }
    /**
     * 获取:三助医生代码
     */
    public Integer getSzysdm() {
        return szysdm;
    }
    /**
     * 设置:四助医生代码
     */
    public void setSizysdm(Integer value) {
        this.sizysdm = value;
    }
    /**
     * 获取:四助医生代码
     */
    public Integer getSizysdm() {
        return sizysdm;
    }
    /**
     * 设置:麻醉医师代码
     */
    public void setMzysdm(Integer value) {
        this.mzysdm = value;
    }
    /**
     * 获取:麻醉医师代码
     */
    public Integer getMzysdm() {
        return mzysdm;
    }
    /**
     * 设置:麻醉方法代码
     */
    public void setMzffdm(Integer value) {
        this.mzffdm = value;
    }
    /**
     * 获取:麻醉方法代码
     */
    public Integer getMzffdm() {
        return mzffdm;
    }
    /**
     * 设置:术前准备
     */
    public void setSqzb(String value) {
        this.sqzb = value;
    }
    /**
     * 获取:术前准备
     */
    public String getSqzb() {
        return sqzb;
    }
    /**
     * 设置:审批意见
     */
    public void setSpyj(String value) {
        this.spyj = value;
    }
    /**
     * 获取:审批意见
     */
    public String getSpyj() {
        return spyj;
    }
    /**
     * 设置:审批医生代码
     */
    public void setSpysdm(Integer value) {
        this.spysdm = value;
    }
    /**
     * 获取:审批医生代码
     */
    public Integer getSpysdm() {
        return spysdm;
    }
    /**
     * 设置:状态 0 申请/1 安排/2作废
     */
    public void setZt(String value) {
        this.zt = value;
    }
    /**
     * 获取:状态 0 申请/1 安排/2作废
     */
    public String getZt() {
        return zt;
    }
    /**
     * 设置:申请人代码
     */
    public void setSqrdm(Integer value) {
        this.sqrdm = value;
    }
    /**
     * 获取:申请人代码
     */
    public Integer getSqrdm() {
        return sqrdm;
    }
    /**
     * 设置:申请时间
     */
    public void setSqsj(Timestamp value) {
        this.sqsj = value;
    }
    /**
     * 获取:申请时间
     */
    public Timestamp getSqsj() {
        return sqsj;
    }

    public List<SsSqdzd> getSssqdzdList() {
        return sssqdzdList;
    }

    public void setSssqdzdList(List<SsSqdzd> sssqdzdList) {
        this.sssqdzdList = sssqdzdList;
    }

    public String getSssqdzdStr() {
        return sssqdzdStr;
    }

    public void setSssqdzdStr(String sssqdzdStr) {
        this.sssqdzdStr = sssqdzdStr;
    }
}