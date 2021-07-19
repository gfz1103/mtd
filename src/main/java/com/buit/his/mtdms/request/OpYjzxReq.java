//   
//package com.buit.his.mtdms.request;
//
//import java.sql.Timestamp;
//
//import com.his.commons.PageQuery;
//import io.swagger.annotations.ApiModel;
//import io.swagger.annotations.ApiModelProperty;
//
//
///**
// * 类名称：OpYjzx<br> 
// * 类描述：<br>
// * @author WY
// */
//@ApiModel(value="")
//public class OpYjzxReq  extends  PageQuery{
//    @ApiModelProperty(value="执行序号")
//    private String zxxh;
//    @ApiModelProperty(value="机构ID")
//    private String jgid;
//    @ApiModelProperty(value="执行科室代码")
//    private Integer ksdm;
//    @ApiModelProperty(value="病人类型  1：门诊   2：住院")
//    private String brlx;
//    @ApiModelProperty(value="病人ID")
//    private Integer brid;
//    @ApiModelProperty(value="住院号码")
//    private String zyhm;
//    @ApiModelProperty(value="病区代码")
//    private Integer bqdm;
//    @ApiModelProperty(value="病人床号")
//    private String brch;
//    @ApiModelProperty(value="申请医生代码")
//    private Integer sqysdm;
//    @ApiModelProperty(value="申请时间")
//    private Timestamp sqsj;
//    @ApiModelProperty(value="计划执行时间")
//    private Timestamp jhzxsj;
//    @ApiModelProperty(value="项目代码")
//    private Integer xmdm;
//    @ApiModelProperty(value="数量")
//    private Double sl;
//    @ApiModelProperty(value="单位")
//    private String dw;
//    @ApiModelProperty(value="状态 0：未执行  1：已执行  2：作废  3：已取消")
//    private String zxzt;
//    @ApiModelProperty(value="执行医生代码")
//    private Integer zxysdm;
//    @ApiModelProperty(value="执行时间")
//    private Timestamp zxsj;
//    @ApiModelProperty(value="取消医生代码")
//    private Integer qxysdm;
//    @ApiModelProperty(value="取消执行时间")
//    private Timestamp qxzxsj;
//    @ApiModelProperty(value="作废医生代码")
//    private Integer zfysdm;
//    @ApiModelProperty(value="作废时间")
//    private Timestamp zfsj;
//    /**
//     * 设置:执行序号
//     */
//    public void setZxxh(String value) {
//        this.zxxh = value;
//    }
//    /**
//     * 获取:执行序号
//     */
//    public String getZxxh() {
//        return zxxh;
//    }
//    /**
//     * 设置:机构ID
//     */
//    public void setJgid(String value) {
//        this.jgid = value;
//    }
//    /**
//     * 获取:机构ID
//     */
//    public String getJgid() {
//        return jgid;
//    }
//    /**
//     * 设置:执行科室代码
//     */
//    public void setKsdm(Integer value) {
//        this.ksdm = value;
//    }
//    /**
//     * 获取:执行科室代码
//     */
//    public Integer getKsdm() {
//        return ksdm;
//    }
//    /**
//     * 设置:病人类型  1：门诊   2：住院
//     */
//    public void setBrlx(String value) {
//        this.brlx = value;
//    }
//    /**
//     * 获取:病人类型  1：门诊   2：住院
//     */
//    public String getBrlx() {
//        return brlx;
//    }
//    /**
//     * 设置:病人ID
//     */
//    public void setBrid(Integer value) {
//        this.brid = value;
//    }
//    /**
//     * 获取:病人ID
//     */
//    public Integer getBrid() {
//        return brid;
//    }
//    /**
//     * 设置:住院号码
//     */
//    public void setZyhm(String value) {
//        this.zyhm = value;
//    }
//    /**
//     * 获取:住院号码
//     */
//    public String getZyhm() {
//        return zyhm;
//    }
//    /**
//     * 设置:病区代码
//     */
//    public void setBqdm(Integer value) {
//        this.bqdm = value;
//    }
//    /**
//     * 获取:病区代码
//     */
//    public Integer getBqdm() {
//        return bqdm;
//    }
//    /**
//     * 设置:病人床号
//     */
//    public void setBrch(String value) {
//        this.brch = value;
//    }
//    /**
//     * 获取:病人床号
//     */
//    public String getBrch() {
//        return brch;
//    }
//    /**
//     * 设置:申请医生代码
//     */
//    public void setSqysdm(Integer value) {
//        this.sqysdm = value;
//    }
//    /**
//     * 获取:申请医生代码
//     */
//    public Integer getSqysdm() {
//        return sqysdm;
//    }
//    /**
//     * 设置:申请时间
//     */
//    public void setSqsj(Timestamp value) {
//        this.sqsj = value;
//    }
//    /**
//     * 获取:申请时间
//     */
//    public Timestamp getSqsj() {
//        return sqsj;
//    }
//    /**
//     * 设置:计划执行时间
//     */
//    public void setJhzxsj(Timestamp value) {
//        this.jhzxsj = value;
//    }
//    /**
//     * 获取:计划执行时间
//     */
//    public Timestamp getJhzxsj() {
//        return jhzxsj;
//    }
//    /**
//     * 设置:项目代码
//     */
//    public void setXmdm(Integer value) {
//        this.xmdm = value;
//    }
//    /**
//     * 获取:项目代码
//     */
//    public Integer getXmdm() {
//        return xmdm;
//    }
//    /**
//     * 设置:数量
//     */
//    public void setSl(Double value) {
//        this.sl = value;
//    }
//    /**
//     * 获取:数量
//     */
//    public Double getSl() {
//        return sl;
//    }
//    /**
//     * 设置:单位
//     */
//    public void setDw(String value) {
//        this.dw = value;
//    }
//    /**
//     * 获取:单位
//     */
//    public String getDw() {
//        return dw;
//    }

//    /**
//     * 设置:执行医生代码
//     */
//    public void setZxysdm(Integer value) {
//        this.zxysdm = value;
//    }
//    /**
//     * 获取:执行医生代码
//     */
//    public Integer getZxysdm() {
//        return zxysdm;
//    }
//    /**
//     * 设置:执行时间
//     */
//    public void setZxsj(Timestamp value) {
//        this.zxsj = value;
//    }
//    /**
//     * 获取:执行时间
//     */
//    public Timestamp getZxsj() {
//        return zxsj;
//    }
//    /**
//     * 设置:取消医生代码
//     */
//    public void setQxysdm(Integer value) {
//        this.qxysdm = value;
//    }
//    /**
//     * 获取:取消医生代码
//     */
//    public Integer getQxysdm() {
//        return qxysdm;
//    }
//    /**
//     * 设置:取消执行时间
//     */
//    public void setQxzxsj(Timestamp value) {
//        this.qxzxsj = value;
//    }
//    /**
//     * 获取:取消执行时间
//     */
//    public Timestamp getQxzxsj() {
//        return qxzxsj;
//    }
//    /**
//     * 设置:作废医生代码
//     */
//    public void setZfysdm(Integer value) {
//        this.zfysdm = value;
//    }
//    /**
//     * 获取:作废医生代码
//     */
//    public Integer getZfysdm() {
//        return zfysdm;
//    }
//    /**
//     * 设置:作废时间
//     */
//    public void setZfsj(Timestamp value) {
//        this.zfsj = value;
//    }
//    /**
//     * 获取:作废时间
//     */
//    public Timestamp getZfsj() {
//        return zfsj;
//    }
//}