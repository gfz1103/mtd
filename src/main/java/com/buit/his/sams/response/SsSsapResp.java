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
public class SsSsapResp  extends  PageQuery{
    @ApiModelProperty(value="主键id")
    private Integer jlxh;
    @ApiModelProperty(value="机构id")
    private Integer jgid;
    @ApiModelProperty(value="手术 科室代码")
    private Integer ssksdm;
    @ApiModelProperty(value="手术申请单号")
    private String sssqdh;
    @ApiModelProperty(value="病人类型 1 门诊2 住院")
    private String brlx;
    @ApiModelProperty(value="门诊号码")
    private Integer mzhm;
    @ApiModelProperty(value="住院号码")
    private String zyhm;
    @ApiModelProperty(value="科室代码")
    private Integer ksdm;
    @ApiModelProperty(value="病区代码")
    private Integer bqdm;
    @ApiModelProperty(value="病人床号")
    private String brch;
    @ApiModelProperty(value="安排手术时间")
    private Timestamp apsssj;
    @ApiModelProperty(value="手术间")
    private Integer ssj;
    @ApiModelProperty(value="台次")
    private Integer tc;
    @ApiModelProperty(value="安排人代码")
    private Integer aprdm;
    @ApiModelProperty(value="麻醉医师代码")
    private Integer mzysdm;
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
    @ApiModelProperty(value="状态 0 申请/1 安排/2作废/3已记账/4已退费")
    private String zt;
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
     * 设置:机构id
     */
    public void setJgid(Integer value) {
        this.jgid = value;
    }
    /**
     * 获取:机构id
     */
    public Integer getJgid() {
        return jgid;
    }
    /**
     * 设置:手术 科室代码
     */
    public void setSsksdm(Integer value) {
        this.ssksdm = value;
    }
    /**
     * 获取:手术 科室代码
     */
    public Integer getSsksdm() {
        return ssksdm;
    }
    /**
     * 设置:手术申请单号
     */
    public void setSssqdh(String value) {
        this.sssqdh = value;
    }
    /**
     * 获取:手术申请单号
     */
    public String getSssqdh() {
        return sssqdh;
    }
    /**
     * 设置:病人类型 1 门诊2 住院
     */
    public void setBrlx(String value) {
        this.brlx = value;
    }
    /**
     * 获取:病人类型 1 门诊2 住院
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
     * 设置:安排手术时间
     */
    public void setApsssj(Timestamp value) {
        this.apsssj = value;
    }
    /**
     * 获取:安排手术时间
     */
    public Timestamp getApsssj() {
        return apsssj;
    }
    /**
     * 设置:手术间
     */
    public void setSsj(Integer value) {
        this.ssj = value;
    }
    /**
     * 获取:手术间
     */
    public Integer getSsj() {
        return ssj;
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
     * 设置:安排人代码
     */
    public void setAprdm(Integer value) {
        this.aprdm = value;
    }
    /**
     * 获取:安排人代码
     */
    public Integer getAprdm() {
        return aprdm;
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
     * 设置:麻醉助手代码
     */
    public void setMzzsdm(Integer value) {
        this.mzzsdm = value;
    }
    /**
     * 获取:麻醉助手代码
     */
    public Integer getMzzsdm() {
        return mzzsdm;
    }
    /**
     * 设置:巡回护士1代码
     */
    public void setXhhsdmy(Integer value) {
        this.xhhsdmy = value;
    }
    /**
     * 获取:巡回护士1代码
     */
    public Integer getXhhsdmy() {
        return xhhsdmy;
    }
    /**
     * 设置:巡回护士2代码
     */
    public void setXhhsdme(Integer value) {
        this.xhhsdme = value;
    }
    /**
     * 获取:巡回护士2代码
     */
    public Integer getXhhsdme() {
        return xhhsdme;
    }
    /**
     * 设置:洗手护士1代码
     */
    public void setXshsdmy(Integer value) {
        this.xshsdmy = value;
    }
    /**
     * 获取:洗手护士1代码
     */
    public Integer getXshsdmy() {
        return xshsdmy;
    }
    /**
     * 设置:洗手护士2代码
     */
    public void setXshsdme(Integer value) {
        this.xshsdme = value;
    }
    /**
     * 获取:洗手护士2代码
     */
    public Integer getXshsdme() {
        return xshsdme;
    }
    /**
     * 设置:操作时间
     */
    public void setCzsj(Timestamp value) {
        this.czsj = value;
    }
    /**
     * 获取:操作时间
     */
    public Timestamp getCzsj() {
        return czsj;
    }

    public String getZt() {
        return zt;
    }

    public void setZt(String zt) {
        this.zt = zt;
    }
}