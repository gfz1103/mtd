package com.buit.his.treatment.request;

import com.buit.commons.PageQuery;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.sql.Timestamp;
import java.util.List;


/**
 * 类名称：ZlSqdzb<br>
 * 类描述：治疗申请单主表修改入参<br>
 * @author ZHOUHAISHENG
 */
@ApiModel(value="治疗申请单主表修改入参")
public class ZlSqdzbUpdateReq extends  PageQuery{
    @ApiModelProperty(value="主键id")
    private Integer jlxh;
    @ApiModelProperty(value="医疗机构代码")
    private Integer jgid;
    @ApiModelProperty(value="治疗申请单号")
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

    @ApiModelProperty(value="治疗申请诊断")
    List<ZlSqdzdUpdateReq> zlSqdzdUpdateReqList;

    @ApiModelProperty(value="治疗申请项目列表")
    private List<ZlSqdmxUpdateReq> zlSqdmxUpdateReqList;

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

    public String getZlsqdh() {
        return zlsqdh;
    }

    public void setZlsqdh(String zlsqdh) {
        this.zlsqdh = zlsqdh;
    }

    public Integer getZlksdm() {
        return zlksdm;
    }

    public void setZlksdm(Integer zlksdm) {
        this.zlksdm = zlksdm;
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

    public Integer getBqdm() {
        return bqdm;
    }

    public void setBqdm(Integer bqdm) {
        this.bqdm = bqdm;
    }

    public Integer getKsdm() {
        return ksdm;
    }

    public void setKsdm(Integer ksdm) {
        this.ksdm = ksdm;
    }

    public String getBrch() {
        return brch;
    }

    public void setBrch(String brch) {
        this.brch = brch;
    }

    public String getKh() {
        return kh;
    }

    public void setKh(String kh) {
        this.kh = kh;
    }

    public String getFphm() {
        return fphm;
    }

    public void setFphm(String fphm) {
        this.fphm = fphm;
    }

    public Integer getSqysgh() {
        return sqysgh;
    }

    public void setSqysgh(Integer sqysgh) {
        this.sqysgh = sqysgh;
    }

    public Timestamp getSqsj() {
        return sqsj;
    }

    public void setSqsj(Timestamp sqsj) {
        this.sqsj = sqsj;
    }

    public String getBz() {
        return bz;
    }

    public void setBz(String bz) {
        this.bz = bz;
    }

    public String getZybs() {
        return zybs;
    }

    public void setZybs(String zybs) {
        this.zybs = zybs;
    }

    public String getTjpd() {
        return tjpd;
    }

    public void setTjpd(String tjpd) {
        this.tjpd = tjpd;
    }

    public List<ZlSqdzdUpdateReq> getZlSqdzdUpdateReqList() {
        return zlSqdzdUpdateReqList;
    }

    public void setZlSqdzdUpdateReqList(List<ZlSqdzdUpdateReq> zlSqdzdUpdateReqList) {
        this.zlSqdzdUpdateReqList = zlSqdzdUpdateReqList;
    }

    public List<ZlSqdmxUpdateReq> getZlSqdmxUpdateReqList() {
        return zlSqdmxUpdateReqList;
    }

    public void setZlSqdmxUpdateReqList(List<ZlSqdmxUpdateReq> zlSqdmxUpdateReqList) {
        this.zlSqdmxUpdateReqList = zlSqdmxUpdateReqList;
    }

    public Integer getZyh() {
        return zyh;
    }

    public void setZyh(Integer zyh) {
        this.zyh = zyh;
    }
}