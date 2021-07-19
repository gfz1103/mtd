package com.buit.his.sams.response;

import com.buit.commons.PageQuery;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.sql.Timestamp;


/**
 * 类名称：SsJzmbzb<br>
 * 类描述：手术/麻醉记账模板主表<br>
 * @author zhouhaisheng
 */
@ApiModel(value="手术麻醉记账模板主表")
public class SsJzmbzbResp  extends  PageQuery{
    @ApiModelProperty(value="主键id")
    private Integer jlxh;
    @ApiModelProperty(value="医疗机构id")
    private Integer jgid;
    @ApiModelProperty(value="1 手术记账模板/2 麻醉记账模板")
    private String mblx;
    @ApiModelProperty(value="模板名称")
    private String mbmc;
    @ApiModelProperty(value="1 公用/2 科室/3 个人")
    private String lx;
    @ApiModelProperty(value="创建时间")
    private Timestamp cjsj;
    @ApiModelProperty(value="创建科室代码")
    private Integer cjksdm;
    @ApiModelProperty(value="创建人id")
    private Integer cjrdm;
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
     * 设置:医疗机构id
     */
    public void setJgid(Integer value) {
        this.jgid = value;
    }
    /**
     * 获取:医疗机构id
     */
    public Integer getJgid() {
        return jgid;
    }
    /**
     * 设置:1 手术记账模板/2 麻醉记账模板
     */
    public void setMblx(String value) {
        this.mblx = value;
    }
    /**
     * 获取:1 手术记账模板/2 麻醉记账模板
     */
    public String getMblx() {
        return mblx;
    }
    /**
     * 设置:模板名称
     */
    public void setMbmc(String value) {
        this.mbmc = value;
    }
    /**
     * 获取:模板名称
     */
    public String getMbmc() {
        return mbmc;
    }
    /**
     * 设置:1 公用/2 科室/3 个人
     */
    public void setLx(String value) {
        this.lx = value;
    }
    /**
     * 获取:1 公用/2 科室/3 个人
     */
    public String getLx() {
        return lx;
    }
    /**
     * 设置:创建时间
     */
    public void setCjsj(Timestamp value) {
        this.cjsj = value;
    }
    /**
     * 获取:创建时间
     */
    public Timestamp getCjsj() {
        return cjsj;
    }
    /**
     * 设置:创建科室代码
     */
    public void setCjksdm(Integer value) {
        this.cjksdm = value;
    }
    /**
     * 获取:创建科室代码
     */
    public Integer getCjksdm() {
        return cjksdm;
    }
    /**
     * 设置:创建人id
     */
    public void setCjrdm(Integer value) {
        this.cjrdm = value;
    }
    /**
     * 获取:创建人id
     */
    public Integer getCjrdm() {
        return cjrdm;
    }
}