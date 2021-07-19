package com.buit.his.treatment.response;

import com.buit.commons.PageQuery;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;


/**
 * 类名称：ZlXm<br>
 * 类描述：治疗项目表<br>
 * @author ZHOUHAISHENG
 */
@ApiModel(value="治疗项目表")
public class ZlXmResp  extends  PageQuery{
    @ApiModelProperty(value="主键id")
    private Integer jlxh;
    @ApiModelProperty(value="医疗机构代码")
    private Integer jgid;
    @ApiModelProperty(value="治疗科室代码")
    private Integer zlksdm;
    @ApiModelProperty(value="治疗项目名称")
    private String zlxmmc;
    @ApiModelProperty(value="类别名称")
    private String lbmc;
    @ApiModelProperty(value="单位")
    private String dw;
    @ApiModelProperty(value="执行疗程")
    private Integer zxlc;
    @ApiModelProperty(value="每疗程默认次数")
    private Integer mlcmrcs;
    @ApiModelProperty(value="间隔天数")
    private Integer jgts;
    @ApiModelProperty(value="参考目标")
    private String ckmb;
    @ApiModelProperty(value="注意事项")
    private String zysx;
    @ApiModelProperty(value="0停用/1启用")
    private String zt;
    @ApiModelProperty(value="诊疗类别")
    private Integer zllb;
    @ApiModelProperty(value="执行科室名称")
    private String zlksmc;
    @ApiModelProperty(value="治疗类别名称")
    private String zllbmc;

    public String getZllbmc() {
        return zllbmc;
    }

    public void setZllbmc(String zllbmc) {
        this.zllbmc = zllbmc;
    }

    public String getZlksmc() {
        return zlksmc;
    }

    public void setZlksmc(String zlksmc) {
        this.zlksmc = zlksmc;
    }

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
     * 设置:治疗项目名称
     */
    public void setZlxmmc(String value) {
        this.zlxmmc = value;
    }
    /**
     * 获取:治疗项目名称
     */
    public String getZlxmmc() {
        return zlxmmc;
    }
    /**
     * 设置:类别名称
     */
    public void setLbmc(String value) {
        this.lbmc = value;
    }
    /**
     * 获取:类别名称
     */
    public String getLbmc() {
        return lbmc;
    }
    /**
     * 设置:单位
     */
    public void setDw(String value) {
        this.dw = value;
    }
    /**
     * 获取:单位
     */
    public String getDw() {
        return dw;
    }
    /**
     * 设置:执行疗程
     */
    public void setZxlc(Integer value) {
        this.zxlc = value;
    }
    /**
     * 获取:执行疗程
     */
    public Integer getZxlc() {
        return zxlc;
    }
    /**
     * 设置:每疗程默认次数
     */
    public void setMlcmrcs(Integer value) {
        this.mlcmrcs = value;
    }
    /**
     * 获取:每疗程默认次数
     */
    public Integer getMlcmrcs() {
        return mlcmrcs;
    }
    /**
     * 设置:间隔天数
     */
    public void setJgts(Integer value) {
        this.jgts = value;
    }
    /**
     * 获取:间隔天数
     */
    public Integer getJgts() {
        return jgts;
    }
    /**
     * 设置:参考目标
     */
    public void setCkmb(String value) {
        this.ckmb = value;
    }
    /**
     * 获取:参考目标
     */
    public String getCkmb() {
        return ckmb;
    }
    /**
     * 设置:注意事项
     */
    public void setZysx(String value) {
        this.zysx = value;
    }
    /**
     * 获取:注意事项
     */
    public String getZysx() {
        return zysx;
    }
    /**
     * 设置:0停用/1启用
     */
    public void setZt(String value) {
        this.zt = value;
    }
    /**
     * 获取:0停用/1启用
     */
    public String getZt() {
        return zt;
    }

    public Integer getZllb() {
        return zllb;
    }

    public void setZllb(Integer zllb) {
        this.zllb = zllb;
    }
}
