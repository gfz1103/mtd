package com.buit.his.treatment.model;

import com.buit.commons.PageQuery;
import io.swagger.annotations.ApiModelProperty;

import java.math.BigDecimal;
import java.sql.Timestamp;

/**
 * 类名称：ZlJlxjzj<br>
 * 类描述：治疗记录小结总结表
 * @author ZHOUHAISHENG
 * @ApiModel(value="治疗记录小结总结表)
 */
public class ZlJlxjzj  extends  PageQuery{
	@ApiModelProperty(value="主键id")
    private Integer jlxh;
	@ApiModelProperty(value="医疗机构代码")
    private Integer jgid;
	@ApiModelProperty(value="治疗申请单号")
    private String zlsqdh;
	@ApiModelProperty(value="治疗申请单序号")
    private Integer zlsqdxh;
	@ApiModelProperty(value="治疗项目名称")
    private String zlxmmc;
	@ApiModelProperty(value="记录时间")
    private Timestamp jlsj;
	@ApiModelProperty(value="记录类型 1 记录2小结3总结")
    private String jllx;
	@ApiModelProperty(value="预约时间")
    private Timestamp yysj;
	@ApiModelProperty(value="预约序号")
    private Integer yyxh;
	@ApiModelProperty(value="本次治疗数量")
    private BigDecimal bczlsl;
	@ApiModelProperty(value="预约操作工号")
    private Integer yyczgh;
	@ApiModelProperty(value="预约操作时间")
    private Timestamp yyczsj;
	@ApiModelProperty(value="状态 1 已预约 2 已执行")
    private String zt;
	@ApiModelProperty(value="执行时间")
    private Timestamp zxsj;
	@ApiModelProperty(value="执行医生工号")
    private Integer zxysgh;
	@ApiModelProperty(value="治疗总结")
    private String zlzj;
	@ApiModelProperty(value="备注")
    private String bz;
	@ApiModelProperty(value="执行记录时间")
    private Timestamp zxjlsj;
	@ApiModelProperty(value="执行记录人工号")
    private Integer zxjlgh;
    @ApiModelProperty(value="预约执行主键id")
    private Integer yyzxJlxh;
    @ApiModelProperty(value="治疗申请单项目明细主键id")
    private Integer zlsqdmxJlxh;

    @ApiModelProperty(value="住院号")
    private Integer zyh;
    @ApiModelProperty(value="诊疗类别")
    private Integer zllb;
    @ApiModelProperty(value="有无不良反应（1有 0无）")
    private Integer ywblfy;
    @ApiModelProperty(value="不良反应")
    private String blfy;
    @ApiModelProperty(value="见习治疗师")
    private Integer jxzlsgh;
    @ApiModelProperty(value="执行时间段开始（格式：2020-07-20 12:00）")
    private String zxsjdks;
    @ApiModelProperty(value="执行时间段结束（格式：2020-07-20 12:00）")
    private String zxsjdjs;
    @ApiModelProperty(value="取消执行时间")
    private Timestamp qxzxsj;
    @ApiModelProperty(value="取消人工号")
    private Integer qxrgh;

    public Timestamp getQxzxsj() {
        return qxzxsj;
    }

    public void setQxzxsj(Timestamp qxzxsj) {
        this.qxzxsj = qxzxsj;
    }

    public Integer getQxrgh() {
        return qxrgh;
    }

    public void setQxrgh(Integer qxrgh) {
        this.qxrgh = qxrgh;
    }

    public Integer getZyh() {
        return zyh;
    }

    public void setZyh(Integer zyh) {
        this.zyh = zyh;
    }

    public Integer getZllb() {
        return zllb;
    }

    public void setZllb(Integer zllb) {
        this.zllb = zllb;
    }

    public Integer getYwblfy() {
        return ywblfy;
    }

    public void setYwblfy(Integer ywblfy) {
        this.ywblfy = ywblfy;
    }

    public String getBlfy() {
        return blfy;
    }

    public void setBlfy(String blfy) {
        this.blfy = blfy;
    }

    public Integer getJxzlsgh() {
        return jxzlsgh;
    }

    public void setJxzlsgh(Integer jxzlsgh) {
        this.jxzlsgh = jxzlsgh;
    }

    public String getZxsjdks() {
        return zxsjdks;
    }

    public void setZxsjdks(String zxsjdks) {
        this.zxsjdks = zxsjdks;
    }

    public String getZxsjdjs() {
        return zxsjdjs;
    }

    public void setZxsjdjs(String zxsjdjs) {
        this.zxsjdjs = zxsjdjs;
    }

    /** 设置:主键id  */
    public void setJlxh(Integer value) {
        this.jlxh = value;
    }
    /** 获取:主键id */
    public Integer getJlxh() {
        return jlxh;
    }

    /** 设置:医疗机构代码  */
    public void setJgid(Integer value) {
        this.jgid = value;
    }
    /** 获取:医疗机构代码 */
    public Integer getJgid() {
        return jgid;
    }

    /** 设置:治疗申请单号  */
    public void setZlsqdh(String value) {
        this.zlsqdh = value;
    }
    /** 获取:治疗申请单号 */
    public String getZlsqdh() {
        return zlsqdh;
    }

    /** 设置:治疗申请单序号  */
    public void setZlsqdxh(Integer value) {
        this.zlsqdxh = value;
    }
    /** 获取:治疗申请单序号 */
    public Integer getZlsqdxh() {
        return zlsqdxh;
    }

    /** 设置:治疗项目名称  */
    public void setZlxmmc(String value) {
        this.zlxmmc = value;
    }
    /** 获取:治疗项目名称 */
    public String getZlxmmc() {
        return zlxmmc;
    }

    /** 设置:记录时间  */
    public void setJlsj(Timestamp value) {
        this.jlsj = value;
    }
    /** 获取:记录时间 */
    public Timestamp getJlsj() {
        return jlsj;
    }

    /** 设置:记录类型 1 记录2小结3总结  */
    public void setJllx(String value) {
        this.jllx = value;
    }
    /** 获取:记录类型 1 记录2小结3总结 */
    public String getJllx() {
        return jllx;
    }

    /** 设置:预约时间  */
    public void setYysj(Timestamp value) {
        this.yysj = value;
    }
    /** 获取:预约时间 */
    public Timestamp getYysj() {
        return yysj;
    }

    /** 设置:预约序号  */
    public void setYyxh(Integer value) {
        this.yyxh = value;
    }
    /** 获取:预约序号 */
    public Integer getYyxh() {
        return yyxh;
    }

    /** 设置:本次治疗数量  */
    public void setBczlsl(BigDecimal value) {
        this.bczlsl = value;
    }
    /** 获取:本次治疗数量 */
    public BigDecimal getBczlsl() {
        return bczlsl;
    }

    /** 设置:预约操作工号  */
    public void setYyczgh(Integer value) {
        this.yyczgh = value;
    }
    /** 获取:预约操作工号 */
    public Integer getYyczgh() {
        return yyczgh;
    }

    /** 设置:预约操作时间  */
    public void setYyczsj(Timestamp value) {
        this.yyczsj = value;
    }
    /** 获取:预约操作时间 */
    public Timestamp getYyczsj() {
        return yyczsj;
    }

    /** 设置:状态 1 已预约 2 已执行  */
    public void setZt(String value) {
        this.zt = value;
    }
    /** 获取:状态 1 已预约 2 已执行 */
    public String getZt() {
        return zt;
    }

    /** 设置:执行时间  */
    public void setZxsj(Timestamp value) {
        this.zxsj = value;
    }
    /** 获取:执行时间 */
    public Timestamp getZxsj() {
        return zxsj;
    }

    /** 设置:执行医生工号  */
    public void setZxysgh(Integer value) {
        this.zxysgh = value;
    }
    /** 获取:执行医生工号 */
    public Integer getZxysgh() {
        return zxysgh;
    }

    /** 设置:治疗总结  */
    public void setZlzj(String value) {
        this.zlzj = value;
    }
    /** 获取:治疗总结 */
    public String getZlzj() {
        return zlzj;
    }

    /** 设置:备注  */
    public void setBz(String value) {
        this.bz = value;
    }
    /** 获取:备注 */
    public String getBz() {
        return bz;
    }

    /** 设置:执行记录时间  */
    public void setZxjlsj(Timestamp value) {
        this.zxjlsj = value;
    }
    /** 获取:执行记录时间 */
    public Timestamp getZxjlsj() {
        return zxjlsj;
    }

    /** 设置:执行记录人工号  */
    public void setZxjlgh(Integer value) {
        this.zxjlgh = value;
    }
    /** 获取:执行记录人工号 */
    public Integer getZxjlgh() {
        return zxjlgh;
    }

    public Integer getYyzxJlxh() {
        return yyzxJlxh;
    }

    public void setYyzxJlxh(Integer yyzxJlxh) {
        this.yyzxJlxh = yyzxJlxh;
    }

    public Integer getZlsqdmxJlxh() {
        return zlsqdmxJlxh;
    }

    public void setZlsqdmxJlxh(Integer zlsqdmxJlxh) {
        this.zlsqdmxJlxh = zlsqdmxJlxh;
    }
}
