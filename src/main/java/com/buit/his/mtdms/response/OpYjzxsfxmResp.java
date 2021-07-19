//   
//package com.buit.his.mtdms.response;
//
//import java.sql.Timestamp;
//
//import com.his.commons.PageQuery;
//import io.swagger.annotations.ApiModel;
//import io.swagger.annotations.ApiModelProperty;
//
//
///**
// * 类名称：OpYjzxsfxm<br> 
// * 类描述：<br>
// * @author WY
// */
//@ApiModel(value="")
//public class OpYjzxsfxmResp  extends  PageQuery{
//    @ApiModelProperty(value="科室代码")
//    private Integer ksdm;
//    @ApiModelProperty(value="执行序号")
//    private String zxxh;
//    @ApiModelProperty(value="机构ID")
//    private Integer jgid;
//    @ApiModelProperty(value="序号")
//    private Integer xh;
//    @ApiModelProperty(value="收费项目代码")
//    private String sfxmdm;
//    @ApiModelProperty(value="数量")
//    private Double ylsl;
//    @ApiModelProperty(value="单价")
//    private Double yldj;
//    @ApiModelProperty(value="金额")
//    private Double ylje;
//    @ApiModelProperty(value="是否新增   1 新增项目")
//    private String sfxz;
//    @ApiModelProperty(value="状态：0 作废 1 有效")
//    private String zt;
//    @ApiModelProperty(value="执行人代码")
//    private Integer zxrdm;
//    @ApiModelProperty(value="执行时间")
//    private Timestamp zxsj;
//    @ApiModelProperty(value="取消执行人代码")
//    private Integer qxzxrdm;
//    @ApiModelProperty(value="取消执行时间")
//    private Timestamp qxzxsj;
//    @ApiModelProperty(value="作废人代码")
//    private Integer zfrdm;
//    @ApiModelProperty(value="作废时间")
//    private Timestamp zfsj;
//    /**
//     * 设置:科室代码
//     */
//    public void setKsdm(Integer value) {
//        this.ksdm = value;
//    }
//    /**
//     * 获取:科室代码
//     */
//    public Integer getKsdm() {
//        return ksdm;
//    }
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
//    public void setJgid(Integer value) {
//        this.jgid = value;
//    }
//    /**
//     * 获取:机构ID
//     */
//    public Integer getJgid() {
//        return jgid;
//    }
//    /**
//     * 设置:序号
//     */
//    public void setXh(Integer value) {
//        this.xh = value;
//    }
//    /**
//     * 获取:序号
//     */
//    public Integer getXh() {
//        return xh;
//    }
//    /**
//     * 设置:收费项目代码
//     */
//    public void setSfxmdm(String value) {
//        this.sfxmdm = value;
//    }
//    /**
//     * 获取:收费项目代码
//     */
//    public String getSfxmdm() {
//        return sfxmdm;
//    }
//    /**
//     * 设置:数量
//     */
//    public void setYlsl(Double value) {
//        this.ylsl = value;
//    }
//    /**
//     * 获取:数量
//     */
//    public Double getYlsl() {
//        return ylsl;
//    }
//    /**
//     * 设置:单价
//     */
//    public void setYldj(Double value) {
//        this.yldj = value;
//    }
//    /**
//     * 获取:单价
//     */
//    public Double getYldj() {
//        return yldj;
//    }
//    /**
//     * 设置:金额
//     */
//    public void setYlje(Double value) {
//        this.ylje = value;
//    }
//    /**
//     * 获取:金额
//     */
//    public Double getYlje() {
//        return ylje;
//    }
//    /**
//     * 设置:是否新增   1 新增项目
//     */
//    public void setSfxz(String value) {
//        this.sfxz = value;
//    }
//    /**
//     * 获取:是否新增   1 新增项目
//     */
//    public String getSfxz() {
//        return sfxz;
//    }
//    /**
//     * 设置:状态：0 作废 1 有效
//     */
//    public void setZt(String value) {
//        this.zt = value;
//    }
//    /**
//     * 获取:状态：0 作废 1 有效
//     */
//    public String getZt() {
//        return zt;
//    }
//    /**
//     * 设置:执行人代码
//     */
//    public void setZxrdm(Integer value) {
//        this.zxrdm = value;
//    }
//    /**
//     * 获取:执行人代码
//     */
//    public Integer getZxrdm() {
//        return zxrdm;
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
//     * 设置:取消执行人代码
//     */
//    public void setQxzxrdm(Integer value) {
//        this.qxzxrdm = value;
//    }
//    /**
//     * 获取:取消执行人代码
//     */
//    public Integer getQxzxrdm() {
//        return qxzxrdm;
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
//     * 设置:作废人代码
//     */
//    public void setZfrdm(Integer value) {
//        this.zfrdm = value;
//    }
//    /**
//     * 获取:作废人代码
//     */
//    public Integer getZfrdm() {
//        return zfrdm;
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