package com.buit.his.treatment.model;

import com.buit.commons.PageQuery;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.sql.Timestamp;

/**
 * @author jiangwei
 * @Date 2021-03-22
 */
@ApiModel(value = "治疗任务模板")
public class ZlRwmb extends PageQuery {
    @ApiModelProperty(value = "记录序号")
    private Integer jlxh;
    @ApiModelProperty(value = "康复治疗任务分配ID | 关联ZL_RWFP.ZLRWFPID")
    private Integer zlrwfpid;
    @ApiModelProperty(value = "执行时间 | 由频次决定的每日默认执行时间点")
    private String zxsj;
    @ApiModelProperty(value = "执行工号 | 任务所分配的治疗师代码")
    private Integer zxgh;
    @ApiModelProperty(value = "住院号")
    private Integer zyh;
    @ApiModelProperty(value = "预约状态 |  1：未预约    2：已预约    3：已开始执行    4：执行完毕")
    private Integer yyzt;
    @ApiModelProperty(value = "预约时间段开始时间")
    private String kssj;
    @ApiModelProperty(value = "预约时间段结束时间")
    private String jssj;
    @ApiModelProperty(value = "临时医嘱 | 0：长期医嘱    1：临时医嘱")
    private Integer lsyz;
    @ApiModelProperty(value = "单位")
    private String dw;
    @ApiModelProperty(value = "频次")
    private String pc;
    @ApiModelProperty(value = "开嘱时间")
    private Timestamp kzsj;
    @ApiModelProperty(value = "医嘱备注信息")
    private String bzxx;
    @ApiModelProperty(value = "首次执行日期")
    private String sczxrq;
    @ApiModelProperty(value = "作废判别 | 0：启用    1：作废")
    private Integer zfpb;
    @ApiModelProperty(value = "执行状态 | 0：未执行    1：已开始执行    2：已执行")
    private Integer zxzt;

    public void setJlxh(Integer value) {
        this.jlxh = value;
    }

    public Integer getJlxh() {
        return jlxh;
    }

    public void setZlrwfpid(Integer value) {
        this.zlrwfpid = value;
    }

    public Integer getZlrwfpid() {
        return zlrwfpid;
    }

    public void setZxsj(String value) {
        this.zxsj = value;
    }

    public String getZxsj() {
        return zxsj;
    }

    public Integer getZyh() {
        return zyh;
    }

    public void setZyh(Integer zyh) {
        this.zyh = zyh;
    }

    public void setZxgh(Integer value) {
        this.zxgh = value;
    }

    public Integer getZxgh() {
        return zxgh;
    }

    public Integer getYyzt() {
        return yyzt;
    }

    public void setYyzt(Integer yyzt) {
        this.yyzt = yyzt;
    }

    public void setKssj(String value) {
        this.kssj = value;
    }

    public String getKssj() {
        return kssj;
    }


    public void setJssj(String value) {
        this.jssj = value;
    }

    public String getJssj() {
        return jssj;
    }


    public void setLsyz(Integer value) {
        this.lsyz = value;
    }

    public Integer getLsyz() {
        return lsyz;
    }

    public void setDw(String value) {
        this.dw = value;
    }

    public String getDw() {
        return dw;
    }


    public void setPc(String value) {
        this.pc = value;
    }

    public String getPc() {
        return pc;
    }


    public void setBzxx(String value) {
        this.bzxx = value;
    }

    public String getBzxx() {
        return bzxx;
    }

    public Timestamp getKzsj() {
        return kzsj;
    }

    public void setKzsj(Timestamp kzsj) {
        this.kzsj = kzsj;
    }

    public String getSczxrq() {
        return sczxrq;
    }

    public void setSczxrq(String sczxrq) {
        this.sczxrq = sczxrq;
    }

    public Integer getZfpb() {
        return zfpb;
    }

    public void setZfpb(Integer zfpb) {
        this.zfpb = zfpb;
    }

    public Integer getZxzt() {
        return zxzt;
    }

    public void setZxzt(Integer zxzt) {
        this.zxzt = zxzt;
    }
}