package com.buit.his.treatment.model;

import com.buit.commons.PageQuery;
import io.swagger.annotations.ApiModelProperty;

/**
 * 类名称：ZlLb<br> 
 * 类描述：治疗类别表
 * @author ZHOUHAISHENG 
 * @ApiModel(value="治疗类别表")
 */
public class ZlLb  extends  PageQuery{
	@ApiModelProperty(value="主键")
    private Integer jlxh;
	@ApiModelProperty(value="医疗机构代码")
    private Integer jgid;
	@ApiModelProperty(value="治疗科室代码")
    private Integer zlksdm;
	@ApiModelProperty(value="类别名称")
    private String lbmc;
	@ApiModelProperty(value="排序号")
    private Integer pxh;

    /** 设置:主键  */
    public void setJlxh(Integer value) {
        this.jlxh = value;
    }
    /** 获取:主键 */
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

    /** 设置:治疗科室代码  */
    public void setZlksdm(Integer value) {
        this.zlksdm = value;
    }
    /** 获取:治疗科室代码 */
    public Integer getZlksdm() {
        return zlksdm;
    }

    /** 设置:类别名称  */
    public void setLbmc(String value) {
        this.lbmc = value;
    }
    /** 获取:类别名称 */
    public String getLbmc() {
        return lbmc;
    }

    /** 设置:排序号  */
    public void setPxh(Integer value) {
        this.pxh = value;
    }
    /** 获取:排序号 */
    public Integer getPxh() {
        return pxh;
    }


}