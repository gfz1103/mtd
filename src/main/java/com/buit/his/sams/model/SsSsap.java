package com.buit.his.sams.model;

import com.buit.commons.PageQuery;
import io.swagger.annotations.ApiModelProperty;

import java.sql.Timestamp;

/**
 * 类名称：SsSsap<br> 
 * 类描述：手术安排表
 * @author zhouhaisheng
 * @ApiModel(value="手术安排表")
 */
public class SsSsap  extends  PageQuery{
	@ApiModelProperty(value="主键id")
    private Integer jlxh;
	@ApiModelProperty(value="机构id")
    private Integer jgid;
	@ApiModelProperty(value="手术 科室代码")
    private Integer ssksdm;
	@ApiModelProperty(value="手术申请单号")
    private Integer sqdh;
	@ApiModelProperty(value="安排手术时间")
    private String apsssj;
	@ApiModelProperty(value="手术间")
    private String ssj;
	@ApiModelProperty(value="台次")
    private Integer tc;
	@ApiModelProperty(value="安排人")
    private Integer aprdm;
	@ApiModelProperty(value="麻醉医师")
    private Integer mzysdm;
	@ApiModelProperty(value="麻醉助手")
    private Integer mzzsdm;
    @ApiModelProperty(value = "巡回护士1")
    private Integer xhhsdmy;
    @ApiModelProperty(value = "巡回护士2")
    private Integer xhhsdme;
    @ApiModelProperty(value = "洗手护士1")
    private Integer xshsdmy;
    @ApiModelProperty(value = "洗手护士2")
    private Integer xshsdme;
    @ApiModelProperty(value = "操作时间")
    private Timestamp czsj;
    @ApiModelProperty(value = "安排状态 | 0：未安排    1：已安排    2：已完成")
    private Integer zt;
    @ApiModelProperty(value = "手术记账状态 | 0：未记账    1：已记账    2：已审核")
    private Integer ssjzzt;
    @ApiModelProperty(value = "麻醉记账状态 | 0：未记账    1：已记账    2：已审核")
    private Integer mzjzzt;

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

    public Integer getSsksdm() {
        return ssksdm;
    }

    public void setSsksdm(Integer ssksdm) {
        this.ssksdm = ssksdm;
    }

    public Integer getSqdh() {
        return sqdh;
    }

    public void setSqdh(Integer sqdh) {
        this.sqdh = sqdh;
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

    public Timestamp getCzsj() {
        return czsj;
    }

    public void setCzsj(Timestamp czsj) {
        this.czsj = czsj;
    }

    public void setZt(Integer zt) {
        this.zt = zt;
    }

    public Integer getZt() {
        return zt;
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