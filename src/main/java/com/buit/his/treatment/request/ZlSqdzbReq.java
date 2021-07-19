package com.buit.his.treatment.request;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.sql.Timestamp;
import java.util.List;


/**
 * 类名称：ZlSqdzb<br>
 * 类描述：治疗申请单主表保存入参<br>
 * @author ZHOUHAISHENG
 */
@ApiModel(value="治疗申请单主表保存入参")
public class ZlSqdzbReq {
    @ApiModelProperty(value="主键id",hidden = true)
    private Integer jlxh;
    @ApiModelProperty(value="医疗机构代码",hidden = true)
    private Integer jgid;
    @ApiModelProperty(value="治疗申请单号",hidden = true)
    private String zlsqdh;
    @ApiModelProperty(value="治疗科室代码")
    private Integer zlksdm;
    @ApiModelProperty(value="病人类型  1 门诊/2 住院")
    private String brlx;
    @ApiModelProperty(value="门诊号")
    private Integer mzhm;
    @ApiModelProperty(value="住院号码")
    private String zyhm;
    @ApiModelProperty(value="住院号")
    private Integer zyh;
    @ApiModelProperty(value="病区代码")
    private Integer bqdm;
    @ApiModelProperty(value="科室代码")
    private Integer ksdm;
    @ApiModelProperty(value="病人床号")
    private String brch;
    @ApiModelProperty(value="卡号")
    private String kh;
    @ApiModelProperty(value="发票号码")
    private String fphm;
    @ApiModelProperty(value="申请医生工号")
    private Integer sqysgh;
    @ApiModelProperty(value="申请时间")
    private Timestamp sqsj;
    @ApiModelProperty(value="备注")
    private String bz;
    @ApiModelProperty(value="主要病史")
    private String zybs;
    @ApiModelProperty(value="体检判定")
    private String tjpd;
    @ApiModelProperty(value="状态 0 未预约1 部分预约2 全部预约3 部分执行4 完成")
    private String zt;
    @ApiModelProperty(value="作废标志 0未作废 1已作废")
    private String zf;
    @ApiModelProperty(value="作废人工号")
    private Integer zfgh;
    @ApiModelProperty(value="作废时间")
    private Timestamp zfsj;
    @ApiModelProperty(value="接收人工号")
    private Integer jsgh;
    @ApiModelProperty(value="接收时间")
    private Timestamp jssj;
    @ApiModelProperty(value="就诊流水号")
    private String jzlsh;
    @ApiModelProperty(value="病人id")
    private Integer brid;
    @ApiModelProperty(value="病人姓名")
    private String brxm;
    @ApiModelProperty(value="就诊序号")
    private Integer jzxh;
    @ApiModelProperty(value="病人性质")
    private Integer brxz;
    @ApiModelProperty(value="治疗申请诊断")
    private List<ZlSqdzdReq> zlSqdzdReqList;
    @ApiModelProperty(value="治疗申请项目列表")
    private List<ZlSqdmxReq> zlSqdmxReqList;

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
     * 设置:医疗机构代码
     */
    public void setJgid(Integer value) {
        this.jgid = value;
    }
    /**
     * 获取:医疗机构代码
     */
    public Integer getJgid() {
        return jgid;
    }
    /**
     * 设置:治疗申请单号
     */
    public void setZlsqdh(String value) {
        this.zlsqdh = value;
    }
    /**
     * 获取:治疗申请单号
     */
    public String getZlsqdh() {
        return zlsqdh;
    }
    /**
     * 设置:治疗科室代码
     */
    public void setZlksdm(Integer value) {
        this.zlksdm = value;
    }
    /**
     * 获取:治疗科室代码
     */
    public Integer getZlksdm() {
        return zlksdm;
    }
    /**
     * 设置:病人类型  1 门诊/2 住院
     */
    public void setBrlx(String value) {
        this.brlx = value;
    }
    /**
     * 获取:病人类型  1 门诊/2 住院
     */
    public String getBrlx() {
        return brlx;
    }
    /**
     * 设置:门诊号
     */
    public void setMzhm(Integer value) {
        this.mzhm = value;
    }
    /**
     * 获取:门诊号
     */
    public Integer getMzhm() {
        return mzhm;
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
     * 设置:卡号
     */
    public void setKh(String value) {
        this.kh = value;
    }
    /**
     * 获取:卡号
     */
    public String getKh() {
        return kh;
    }
    /**
     * 设置:发票号码
     */
    public void setFphm(String value) {
        this.fphm = value;
    }
    /**
     * 获取:发票号码
     */
    public String getFphm() {
        return fphm;
    }
    /**
     * 设置:申请医生工号
     */
    public void setSqysgh(Integer value) {
        this.sqysgh = value;
    }
    /**
     * 获取:申请医生工号
     */
    public Integer getSqysgh() {
        return sqysgh;
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
    /**
     * 设置:备注
     */
    public void setBz(String value) {
        this.bz = value;
    }
    /**
     * 获取:备注
     */
    public String getBz() {
        return bz;
    }
    /**
     * 设置:主要病史
     */
    public void setZybs(String value) {
        this.zybs = value;
    }
    /**
     * 获取:主要病史
     */
    public String getZybs() {
        return zybs;
    }
    /**
     * 设置:体检判定
     */
    public void setTjpd(String value) {
        this.tjpd = value;
    }
    /**
     * 获取:体检判定
     */
    public String getTjpd() {
        return tjpd;
    }
    /**
     * 设置:状态 0 未预约1 部分预约2 全部预约3 部分执行4 完成
     */
    public void setZt(String value) {
        this.zt = value;
    }
    /**
     * 获取:状态 0 未预约1 部分预约2 全部预约3 部分执行4 完成
     */
    public String getZt() {
        return zt;
    }
    /**
     * 设置:作废标志 0未作废 1已作废
     */
    public void setZf(String value) {
        this.zf = value;
    }
    /**
     * 获取:作废标志 0未作废 1已作废
     */
    public String getZf() {
        return zf;
    }
    /**
     * 设置:作废人工号
     */
    public void setZfgh(Integer value) {
        this.zfgh = value;
    }
    /**
     * 获取:作废人工号
     */
    public Integer getZfgh() {
        return zfgh;
    }
    /**
     * 设置:作废时间
     */
    public void setZfsj(Timestamp value) {
        this.zfsj = value;
    }
    /**
     * 获取:作废时间
     */
    public Timestamp getZfsj() {
        return zfsj;
    }
    /**
     * 设置:接收人工号
     */
    public void setJsgh(Integer value) {
        this.jsgh = value;
    }
    /**
     * 获取:接收人工号
     */
    public Integer getJsgh() {
        return jsgh;
    }
    /**
     * 设置:接收时间
     */
    public void setJssj(Timestamp value) {
        this.jssj = value;
    }
    /**
     * 获取:接收时间
     */
    public Timestamp getJssj() {
        return jssj;
    }

    public List<ZlSqdmxReq> getZlSqdmxReqList() {
        return zlSqdmxReqList;
    }

    public void setZlSqdmxReqList(List<ZlSqdmxReq> zlSqdmxReqList) {
        this.zlSqdmxReqList = zlSqdmxReqList;
    }

    public List<ZlSqdzdReq> getZlSqdzdReqList() {
        return zlSqdzdReqList;
    }

    public void setZlSqdzdReqList(List<ZlSqdzdReq> zlSqdzdReqList) {
        this.zlSqdzdReqList = zlSqdzdReqList;
    }

    public String getZyhm() {
        return zyhm;
    }

    public void setZyhm(String zyhm) {
        this.zyhm = zyhm;
    }

    public String getJzlsh() {
        return jzlsh;
    }

    public void setJzlsh(String jzlsh) {
        this.jzlsh = jzlsh;
    }

    public Integer getBrid() {
        return brid;
    }

    public void setBrid(Integer brid) {
        this.brid = brid;
    }

    public String getBrxm() {
        return brxm;
    }

    public void setBrxm(String brxm) {
        this.brxm = brxm;
    }

    public Integer getJzxh() {
        return jzxh;
    }

    public void setJzxh(Integer jzxh) {
        this.jzxh = jzxh;
    }

    public Integer getBrxz() {
        return brxz;
    }

    public void setBrxz(Integer brxz) {
        this.brxz = brxz;
    }

    public Integer getZyh() {
        return zyh;
    }

    public void setZyh(Integer zyh) {
        this.zyh = zyh;
    }

}