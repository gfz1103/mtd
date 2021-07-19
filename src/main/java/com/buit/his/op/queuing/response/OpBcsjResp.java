
package com.buit.his.op.queuing.response;

import com.buit.commons.PageQuery;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.math.BigDecimal;
import java.sql.Timestamp;


/**
 * 类名称：OpBcsj<br>
 * 类描述：班次上下班时间字典<br>
 * @author 老花生
 */
@ApiModel(value="班次上下班时间字典")
public class OpBcsjResp  extends  PageQuery{
    @ApiModelProperty(value="唯一ID")
    private Long tid;
    @ApiModelProperty(value="数据版本")
    private Integer sjbb;
    @ApiModelProperty(value="数据创建时间")
    private Timestamp cjsj;
    @ApiModelProperty(value="数据修改时间")
    private Timestamp xgsj;
    @ApiModelProperty(value="医疗机构ID")
    private Integer jgid;
    @ApiModelProperty(value="时段代码")
    private String sddm;
    @ApiModelProperty(value="时段名称")
    private String sdmc;
    @ApiModelProperty(value="上班时间 HH24:MI:SS")
    private String sbsj;
    @ApiModelProperty(value="下班时间 HH24:MI:SS")
    private String xbsj;
    @ApiModelProperty(value="病人平均就诊时长（分钟）")
    private BigDecimal pjsc;
    /**
     * 设置:唯一ID
     */
    public void setTid(Long value) {
        this.tid = value;
    }
    /**
     * 获取:唯一ID
     */
    public Long getTid() {
        return tid;
    }
    /**
     * 设置:数据版本
     */
    public void setSjbb(Integer value) {
        this.sjbb = value;
    }
    /**
     * 获取:数据版本
     */
    public Integer getSjbb() {
        return sjbb;
    }
    /**
     * 设置:数据创建时间
     */
    public void setCjsj(Timestamp value) {
        this.cjsj = value;
    }
    /**
     * 获取:数据创建时间
     */
    public Timestamp getCjsj() {
        return cjsj;
    }
    /**
     * 设置:数据修改时间
     */
    public void setXgsj(Timestamp value) {
        this.xgsj = value;
    }
    /**
     * 获取:数据修改时间
     */
    public Timestamp getXgsj() {
        return xgsj;
    }
    /**
     * 设置:医疗机构ID
     */
    public void setJgid(Integer value) {
        this.jgid = value;
    }
    /**
     * 获取:医疗机构ID
     */
    public Integer getJgid() {
        return jgid;
    }
    /**
     * 设置:时段代码
     */
    public void setSddm(String value) {
        this.sddm = value;
    }
    /**
     * 获取:时段代码
     */
    public String getSddm() {
        return sddm;
    }
    /**
     * 设置:时段名称
     */
    public void setSdmc(String value) {
        this.sdmc = value;
    }
    /**
     * 获取:时段名称
     */
    public String getSdmc() {
        return sdmc;
    }
    /**
     * 设置:上班时间 HH24:MI:SS
     */
    public void setSbsj(String value) {
        this.sbsj = value;
    }
    /**
     * 获取:上班时间 HH24:MI:SS
     */
    public String getSbsj() {
        return sbsj;
    }
    /**
     * 设置:下班时间 HH24:MI:SS
     */
    public void setXbsj(String value) {
        this.xbsj = value;
    }
    /**
     * 获取:下班时间 HH24:MI:SS
     */
    public String getXbsj() {
        return xbsj;
    }
    /**
     * 设置:病人平均就诊时长（分钟）
     */
    public void setPjsc(BigDecimal value) {
        this.pjsc = value;
    }
    /**
     * 获取:病人平均就诊时长（分钟）
     */
    public BigDecimal getPjsc() {
        return pjsc;
    }
}