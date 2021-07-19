package com.buit.his.treatment.response;

import com.buit.commons.PageQuery;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.sql.Timestamp;

/**
 * 分页查询病人治疗预约出参
 * zhouhaisheng
 */
@ApiModel(value = "分页查询病人治疗预约出参")
public class ZlyyPageQueryResp extends PageQuery {

    @ApiModelProperty(value="主键id")
    private Integer jlxh;
    @ApiModelProperty(value="治疗申请单号")
    private String zlsqdh;
    @ApiModelProperty(value="就诊类型  1 门诊/2 住院")
    private String brlx;
    @ApiModelProperty(value="病人姓名")
    private String brxm;
    @ApiModelProperty(value="病人性别")
    private Integer brxb;
    @ApiModelProperty(value = "出生年月")
    private Timestamp csny;
    @ApiModelProperty(value = "病人年龄")
    private Integer age;
    @ApiModelProperty(value = "科室代码")
    private Integer ksdm;
    @ApiModelProperty(value = "申请医生工号")
    private Integer sqysgh;
    @ApiModelProperty(value = "申请时间")
    private Timestamp sqsj;
    @ApiModelProperty(value = "状态 0 未预约(新开) 1 部分预约2 全部预约3 部分执行4 完成")
    private Integer zt;

    public Integer getJlxh() {
        return jlxh;
    }

    public void setJlxh(Integer jlxh) {
        this.jlxh = jlxh;
    }

    public String getZlsqdh() {
        return zlsqdh;
    }

    public void setZlsqdh(String zlsqdh) {
        this.zlsqdh = zlsqdh;
    }

    public String getBrlx() {
        return brlx;
    }

    public void setBrlx(String brlx) {
        this.brlx = brlx;
    }

    public String getBrxm() {
        return brxm;
    }

    public void setBrxm(String brxm) {
        this.brxm = brxm;
    }

    public Integer getBrxb() {
        return brxb;
    }

    public void setBrxb(Integer brxb) {
        this.brxb = brxb;
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

    public Integer getKsdm() {
        return ksdm;
    }

    public void setKsdm(Integer ksdm) {
        this.ksdm = ksdm;
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

    public Integer getZt() {
        return zt;
    }

    public void setZt(Integer zt) {
        this.zt = zt;
    }
}
