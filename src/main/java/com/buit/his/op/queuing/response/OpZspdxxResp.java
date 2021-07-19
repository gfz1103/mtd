
package com.buit.his.op.queuing.response;

import com.buit.commons.PageQuery;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.math.BigDecimal;
import java.sql.Date;
import java.sql.Timestamp;


/**
 * 类名称：OpZspdxx<br>
 * 类描述：门诊就诊队列<br>
 * @author 老花生
 */
@ApiModel(value="门诊就诊队列")
public class OpZspdxxResp  extends  PageQuery{
    @ApiModelProperty(value="唯一ID,使用描述:新增时不可传递到后台，修改时必须传递到后台")
    private Integer oid;
    @ApiModelProperty(value="数据版本,使用描述:新增时不可传递到后台，修改时必须传递到后台")
    private Integer sjbb;
    @ApiModelProperty(value="数据创建时间")
    private Timestamp cjsj;
    @ApiModelProperty(value="数据修改时间")
    private Timestamp xgsj;
    @ApiModelProperty(value="医疗机构ID,使用描述:创建时不可为空")
    private Integer jgid;
    @ApiModelProperty(value="门诊就诊号")
    private String mzjzh;
    @ApiModelProperty(value="挂号时间，使用描述：格式为yyyy-MM-dd HH:mm:ss")
    private Timestamp ghsj;
    @ApiModelProperty(value="时间段代码(班次)")
    private String sddm;
    @ApiModelProperty(value="科室id")
    private Integer ksid;
    @ApiModelProperty(value="号类字典代码")
    private String hlzddm;
    @ApiModelProperty(value="挂号医生id")
    private Integer ghys;
    @ApiModelProperty(value="挂号科室")
    private Integer ghks;
    @ApiModelProperty(value="就诊序号")
    private Integer jzxh;
    @ApiModelProperty(value="排队序号")
    private Integer pdxh;
    @ApiModelProperty(value="叫号时间，使用描述：格式为yyyy-MM-dd HH:mm:ss")
    private Timestamp jhsj;
    @ApiModelProperty(value="叫号科室ID")
    private Integer jhks;
    @ApiModelProperty(value="叫号医生ID")
    private Integer jhys;
    @ApiModelProperty(value="叫号诊室代码")
    private String jhksdm;
    @ApiModelProperty(value="就诊标志，使用描述：FD 0-第一次,1-二次就诊,2-转诊")
    private String jzbz;
    @ApiModelProperty(value="就诊状态，使用描述：FD 0-待诊,1-诊中,2-诊毕")
    private String jzzt;
    @ApiModelProperty(value="叫号诊台代码")
    private String jhtdm;
    @ApiModelProperty(value="指定医生(护士操作)ID")
    private Integer zdys;
    @ApiModelProperty(value="叫号次数,适用描述：超过指定次数则叫号序号变为当前队列最后")
    private Integer jhcs;
    @ApiModelProperty(value="调整标志,适用描述：1-急，2-过号重排，0-正常，-1-后移，3-叫号不应")
    private Integer tzbz;
    @ApiModelProperty(value="指定诊室(护士操作)代码")
    private String zdksdm;
    @ApiModelProperty(value="号失效时间，挂号时间+号类的有效时长")
    private Timestamp sxsj;
    @ApiModelProperty(value="病人分级")
    private String brfj;
    @ApiModelProperty(value="病人id")
    private Integer brid;
    @ApiModelProperty(value="就诊流水号")
    private String jzlsh;
    @ApiModelProperty(value="病人姓名")
    private String brxm;
    @ApiModelProperty(value="病人卡号")
    private String brkh;
    @ApiModelProperty(value="出生日期")
    private Date csrq;
    @ApiModelProperty(value="年龄")
    private Integer nl;
    @ApiModelProperty(value="性别")
    private String xb;
    @ApiModelProperty(value="收费性质")
    private String sfxz;
    @ApiModelProperty(value="病人类型 1：预约")
    private String brlx;
    @ApiModelProperty(value="预计等候时间（分钟）")
    private BigDecimal dhsj;
    /**
     * 设置:唯一ID,使用描述:新增时不可传递到后台，修改时必须传递到后台
     */
    public void setOid(Integer value) {
        this.oid = value;
    }
    /**
     * 获取:唯一ID,使用描述:新增时不可传递到后台，修改时必须传递到后台
     */
    public Integer getOid() {
        return oid;
    }
    /**
     * 设置:数据版本,使用描述:新增时不可传递到后台，修改时必须传递到后台
     */
    public void setSjbb(Integer value) {
        this.sjbb = value;
    }
    /**
     * 获取:数据版本,使用描述:新增时不可传递到后台，修改时必须传递到后台
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
     * 设置:医疗机构ID,使用描述:创建时不可为空
     */
    public void setJgid(Integer value) {
        this.jgid = value;
    }
    /**
     * 获取:医疗机构ID,使用描述:创建时不可为空
     */
    public Integer getJgid() {
        return jgid;
    }
    /**
     * 设置:门诊就诊号
     */
    public void setMzjzh(String value) {
        this.mzjzh = value;
    }
    /**
     * 获取:门诊就诊号
     */
    public String getMzjzh() {
        return mzjzh;
    }
    /**
     * 设置:挂号时间，使用描述：格式为yyyy-MM-dd HH:mm:ss
     */
    public void setGhsj(Timestamp value) {
        this.ghsj = value;
    }
    /**
     * 获取:挂号时间，使用描述：格式为yyyy-MM-dd HH:mm:ss
     */
    public Timestamp getGhsj() {
        return ghsj;
    }
    /**
     * 设置:时间段代码(班次)
     */
    public void setSddm(String value) {
        this.sddm = value;
    }
    /**
     * 获取:时间段代码(班次)
     */
    public String getSddm() {
        return sddm;
    }
    /**
     * 设置:科室id
     */
    public void setKsid(Integer value) {
        this.ksid = value;
    }
    /**
     * 获取:科室id
     */
    public Integer getKsid() {
        return ksid;
    }
    /**
     * 设置:号类字典代码
     */
    public void setHlzddm(String value) {
        this.hlzddm = value;
    }
    /**
     * 获取:号类字典代码
     */
    public String getHlzddm() {
        return hlzddm;
    }
    /**
     * 设置:挂号医生id
     */
    public void setGhys(Integer value) {
        this.ghys = value;
    }
    /**
     * 获取:挂号医生id
     */
    public Integer getGhys() {
        return ghys;
    }
    /**
     * 设置:挂号科室
     */
    public void setGhks(Integer value) {
        this.ghks = value;
    }
    /**
     * 获取:挂号科室
     */
    public Integer getGhks() {
        return ghks;
    }
    /**
     * 设置:就诊序号
     */
    public void setJzxh(Integer value) {
        this.jzxh = value;
    }
    /**
     * 获取:就诊序号
     */
    public Integer getJzxh() {
        return jzxh;
    }
    /**
     * 设置:排队序号
     */
    public void setPdxh(Integer value) {
        this.pdxh = value;
    }
    /**
     * 获取:排队序号
     */
    public Integer getPdxh() {
        return pdxh;
    }
    /**
     * 设置:叫号时间，使用描述：格式为yyyy-MM-dd HH:mm:ss
     */
    public void setJhsj(Timestamp value) {
        this.jhsj = value;
    }
    /**
     * 获取:叫号时间，使用描述：格式为yyyy-MM-dd HH:mm:ss
     */
    public Timestamp getJhsj() {
        return jhsj;
    }
    /**
     * 设置:叫号科室ID
     */
    public void setJhks(Integer value) {
        this.jhks = value;
    }
    /**
     * 获取:叫号科室ID
     */
    public Integer getJhks() {
        return jhks;
    }
    /**
     * 设置:叫号医生ID
     */
    public void setJhys(Integer value) {
        this.jhys = value;
    }
    /**
     * 获取:叫号医生ID
     */
    public Integer getJhys() {
        return jhys;
    }
    /**
     * 设置:叫号诊室代码
     */
    public void setJhksdm(String value) {
        this.jhksdm = value;
    }
    /**
     * 获取:叫号诊室代码
     */
    public String getJhksdm() {
        return jhksdm;
    }
    /**
     * 设置:就诊标志，使用描述：FD 0-第一次,1-二次就诊,2-转诊
     */
    public void setJzbz(String value) {
        this.jzbz = value;
    }
    /**
     * 获取:就诊标志，使用描述：FD 0-第一次,1-二次就诊,2-转诊
     */
    public String getJzbz() {
        return jzbz;
    }
    /**
     * 设置:就诊状态，使用描述：FD 0-待诊,1-诊中,2-诊毕
     */
    public void setJzzt(String value) {
        this.jzzt = value;
    }
    /**
     * 获取:就诊状态，使用描述：FD 0-待诊,1-诊中,2-诊毕
     */
    public String getJzzt() {
        return jzzt;
    }
    /**
     * 设置:叫号诊台代码
     */
    public void setJhtdm(String value) {
        this.jhtdm = value;
    }
    /**
     * 获取:叫号诊台代码
     */
    public String getJhtdm() {
        return jhtdm;
    }
    /**
     * 设置:指定医生(护士操作)ID
     */
    public void setZdys(Integer value) {
        this.zdys = value;
    }
    /**
     * 获取:指定医生(护士操作)ID
     */
    public Integer getZdys() {
        return zdys;
    }
    /**
     * 设置:叫号次数,适用描述：超过指定次数则叫号序号变为当前队列最后
     */
    public void setJhcs(Integer value) {
        this.jhcs = value;
    }
    /**
     * 获取:叫号次数,适用描述：超过指定次数则叫号序号变为当前队列最后
     */
    public Integer getJhcs() {
        return jhcs;
    }
    /**
     * 设置:调整标志,适用描述：1-急，2-过号重排，0-正常，-1-后移，3-叫号不应
     */
    public void setTzbz(Integer value) {
        this.tzbz = value;
    }
    /**
     * 获取:调整标志,适用描述：1-急，2-过号重排，0-正常，-1-后移，3-叫号不应
     */
    public Integer getTzbz() {
        return tzbz;
    }
    /**
     * 设置:指定诊室(护士操作)代码
     */
    public void setZdksdm(String value) {
        this.zdksdm = value;
    }
    /**
     * 获取:指定诊室(护士操作)代码
     */
    public String getZdksdm() {
        return zdksdm;
    }
    /**
     * 设置:号失效时间，挂号时间+号类的有效时长
     */
    public void setSxsj(Timestamp value) {
        this.sxsj = value;
    }
    /**
     * 获取:号失效时间，挂号时间+号类的有效时长
     */
    public Timestamp getSxsj() {
        return sxsj;
    }
    /**
     * 设置:病人分级
     */
    public void setBrfj(String value) {
        this.brfj = value;
    }
    /**
     * 获取:病人分级
     */
    public String getBrfj() {
        return brfj;
    }
    /**
     * 设置:病人id
     */
    public void setBrid(Integer value) {
        this.brid = value;
    }
    /**
     * 获取:病人id
     */
    public Integer getBrid() {
        return brid;
    }
    /**
     * 设置:就诊流水号
     */
    public void setJzlsh(String value) {
        this.jzlsh = value;
    }
    /**
     * 获取:就诊流水号
     */
    public String getJzlsh() {
        return jzlsh;
    }
    /**
     * 设置:病人姓名
     */
    public void setBrxm(String value) {
        this.brxm = value;
    }
    /**
     * 获取:病人姓名
     */
    public String getBrxm() {
        return brxm;
    }
    /**
     * 设置:病人卡号
     */
    public void setBrkh(String value) {
        this.brkh = value;
    }
    /**
     * 获取:病人卡号
     */
    public String getBrkh() {
        return brkh;
    }
    /**
     * 设置:出生日期
     */
    public void setCsrq(Date value) {
        this.csrq = value;
    }
    /**
     * 获取:出生日期
     */
    public Date getCsrq() {
        return csrq;
    }
    /**
     * 设置:性别
     */
    public void setXb(String value) {
        this.xb = value;
    }
    /**
     * 获取:性别
     */
    public String getXb() {
        return xb;
    }
    /**
     * 设置:收费性质
     */
    public void setSfxz(String value) {
        this.sfxz = value;
    }
    /**
     * 获取:收费性质
     */
    public String getSfxz() {
        return sfxz;
    }
    /**
     * 设置:病人类型 1：预约
     */
    public void setBrlx(String value) {
        this.brlx = value;
    }
    /**
     * 获取:病人类型 1：预约
     */
    public String getBrlx() {
        return brlx;
    }

    public Integer getNl() {
        return nl;
    }

    public void setNl(Integer nl) {
        this.nl = nl;
    }

    public BigDecimal getDhsj() {
        return dhsj;
    }

    public void setDhsj(BigDecimal dhsj) {
        this.dhsj = dhsj;
    }
}