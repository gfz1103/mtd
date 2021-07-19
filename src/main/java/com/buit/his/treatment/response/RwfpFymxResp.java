package com.buit.his.treatment.response;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.math.BigDecimal;

/**
 * @Author jiangwei
 * @Date 2021-04-09 19:31
 * @Description
 **/
@ApiModel("住院治疗任务执行生成费用明细参数")
public class RwfpFymxResp {
    @ApiModelProperty(value = "治疗任务分配id")
    private Integer zlrwfpid;
    @ApiModelProperty(value = "机构ID")
    private Integer jgid;
    @ApiModelProperty(value = "住院号")
    private Integer zyh;
    @ApiModelProperty(value = "费用序号")
    private Integer fyxh;
    @ApiModelProperty(value = "费用名称")
    private String fymc;
    @ApiModelProperty(value = "费用数量")
    private BigDecimal fysl;
    @ApiModelProperty(value = "费用单价")
    private BigDecimal fydj;
    @ApiModelProperty(value = "总计金额")
    private BigDecimal zjje;
    @ApiModelProperty(value = "医生工号")
    private String ysgh;
    @ApiModelProperty(value = "输入工号")
    private String srgh;
    @ApiModelProperty(value = "确认工号")
    private String qrgh;
    @ApiModelProperty(value = "费用病区 | 费用发生的病区")
    private Integer fybq;
    @ApiModelProperty(value = "费用科室 | 费用输入的科室(记帐,按输入科室核算时要用)")
    private Integer fyks;
    @ApiModelProperty(value = "执行科室 | 费用记帐科室(记帐,按执行科室核算时使用)")
    private Integer zxks;
    @ApiModelProperty(value = "费用项目 | 指定FYXH归并的项目(同GY_SFMX表中SFXM对应)")
    private Integer fyxm;
    @ApiModelProperty(value = "医嘱序号 | 同CIS_HZYZ表中的医嘱序号对应")
    private Integer yzxh;
    @ApiModelProperty(value = "自负比例判断值1 | 若此值不为空，此值即为自负比例")
    private BigDecimal zfbl1;
    @ApiModelProperty(value = "自负比例判断值2 | 若判断值1为空，此值即为自负比例")
    private BigDecimal zfbl2;

    public Integer getZlrwfpid() {
        return zlrwfpid;
    }

    public void setZlrwfpid(Integer zlrwfpid) {
        this.zlrwfpid = zlrwfpid;
    }

    public Integer getJgid() {
        return jgid;
    }

    public void setJgid(Integer jgid) {
        this.jgid = jgid;
    }

    public Integer getZyh() {
        return zyh;
    }

    public void setZyh(Integer zyh) {
        this.zyh = zyh;
    }

    public Integer getFyxh() {
        return fyxh;
    }

    public void setFyxh(Integer fyxh) {
        this.fyxh = fyxh;
    }

    public String getFymc() {
        return fymc;
    }

    public void setFymc(String fymc) {
        this.fymc = fymc;
    }

    public BigDecimal getFysl() {
        return fysl;
    }

    public void setFysl(BigDecimal fysl) {
        this.fysl = fysl;
    }

    public BigDecimal getFydj() {
        return fydj;
    }

    public void setFydj(BigDecimal fydj) {
        this.fydj = fydj;
    }

    public BigDecimal getZjje() {
        return zjje;
    }

    public void setZjje(BigDecimal zjje) {
        this.zjje = zjje;
    }

    public String getYsgh() {
        return ysgh;
    }

    public void setYsgh(String ysgh) {
        this.ysgh = ysgh;
    }

    public String getSrgh() {
        return srgh;
    }

    public void setSrgh(String srgh) {
        this.srgh = srgh;
    }

    public String getQrgh() {
        return qrgh;
    }

    public void setQrgh(String qrgh) {
        this.qrgh = qrgh;
    }

    public Integer getFybq() {
        return fybq;
    }

    public void setFybq(Integer fybq) {
        this.fybq = fybq;
    }

    public Integer getFyks() {
        return fyks;
    }

    public void setFyks(Integer fyks) {
        this.fyks = fyks;
    }

    public Integer getZxks() {
        return zxks;
    }

    public void setZxks(Integer zxks) {
        this.zxks = zxks;
    }


    public Integer getFyxm() {
        return fyxm;
    }

    public void setFyxm(Integer fyxm) {
        this.fyxm = fyxm;
    }

    public Integer getYzxh() {
        return yzxh;
    }

    public void setYzxh(Integer yzxh) {
        this.yzxh = yzxh;
    }

    public BigDecimal getZfbl1() {
        return zfbl1;
    }

    public void setZfbl1(BigDecimal zfbl1) {
        this.zfbl1 = zfbl1;
    }

    public BigDecimal getZfbl2() {
        return zfbl2;
    }

    public void setZfbl2(BigDecimal zfbl2) {
        this.zfbl2 = zfbl2;
    }

    /**
     * 获取自负比例
     */
    public BigDecimal getRealZfbl() {
        if (zfbl1 != null) {
            return zfbl1;
        } else if (zfbl2 != null) {
            return zfbl2;
        } else {
            return BigDecimal.ONE;
        }

    }
}
