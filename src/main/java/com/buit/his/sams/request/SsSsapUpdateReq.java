package com.buit.his.sams.request;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.sql.Timestamp;


/**
 * 类名称：SsSsap<br>
 * 类描述：手术申请安排表<br>
 * @author zhouhaisheng
 */
@ApiModel(value="手术申请安排表")
public class SsSsapUpdateReq {
    @ApiModelProperty(value="主键id")
    private Integer jlxh;
    @ApiModelProperty(value="申请单号")
    private Integer sqdh;
    @ApiModelProperty(value="安排手术时间")
    private String apsssj;
    @ApiModelProperty(value="手术间")
    private String ssj;
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

    @ApiModelProperty(value="手术 科室代码")
    private Integer ssksdm;

    public Integer getJlxh() {
        return jlxh;
    }

    public void setJlxh(Integer jlxh) {
        this.jlxh = jlxh;
    }

    public String getApsssj() {
        return apsssj;
    }

    public void setApsssj(String apsssj) {
        this.apsssj = apsssj;
    }

    public String getSsj() {
        return ssj;
    }

    public void setSsj(String ssj) {
        this.ssj = ssj;
    }

    public Integer getTc() {
        return tc;
    }

    public void setTc(Integer tc) {
        this.tc = tc;
    }

    public Integer getAprdm() {
        return aprdm;
    }

    public void setAprdm(Integer aprdm) {
        this.aprdm = aprdm;
    }

    public Integer getMzysdm() {
        return mzysdm;
    }

    public void setMzysdm(Integer mzysdm) {
        this.mzysdm = mzysdm;
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

    public Integer getSqdh() {
        return sqdh;
    }

    public void setSqdh(Integer sqdh) {
        this.sqdh = sqdh;
    }

    public Integer getSsksdm() {
        return ssksdm;
    }

    public void setSsksdm(Integer ssksdm) {
        this.ssksdm = ssksdm;
    }
}