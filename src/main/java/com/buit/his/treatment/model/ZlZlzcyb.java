package com.buit.his.treatment.model;

import java.sql.Timestamp;
import com.buit.commons.PageQuery;

/**
 * 类名称：ZlZlzcyb<br> 
 * 类描述：治疗小组成员表
 * @author 韦靖 
 * @ApiModel(value="治疗小组成员表")
 */
public class ZlZlzcyb  extends  PageQuery{
	//@ApiModelProperty(value="治疗小组成员ID")
    /** 治疗小组成员ID */
    private Integer zlzcyid;
	//@ApiModelProperty(value="医疗机构代码")
    /** 医疗机构代码 */
    private Integer jgid;
	//@ApiModelProperty(value="治疗小组ID")
    /** 治疗小组ID */
    private Integer zlzid;
	//@ApiModelProperty(value="治疗师代码")
    /** 治疗师代码 */
    private Integer zlsdm;
	//@ApiModelProperty(value="治疗师科室代码")
    /** 治疗师科室代码 */
    private Integer zlsks;

    /** 设置:治疗小组成员ID  */
    public void setZlzcyid(Integer value) {
        this.zlzcyid = value;
    }
    /** 获取:治疗小组成员ID */
    public Integer getZlzcyid() {
        return zlzcyid;
    }

    /** 设置:医疗机构代码  */
    public void setJgid(Integer value) {
        this.jgid = value;
    }
    /** 获取:医疗机构代码 */
    public Integer getJgid() {
        return jgid;
    }

    /** 设置:治疗小组ID  */
    public void setZlzid(Integer value) {
        this.zlzid = value;
    }
    /** 获取:治疗小组ID */
    public Integer getZlzid() {
        return zlzid;
    }

    /** 设置:治疗师代码  */
    public void setZlsdm(Integer value) {
        this.zlsdm = value;
    }
    /** 获取:治疗师代码 */
    public Integer getZlsdm() {
        return zlsdm;
    }

    /** 设置:治疗师科室代码  */
    public void setZlsks(Integer value) {
        this.zlsks = value;
    }
    /** 获取:治疗师科室代码 */
    public Integer getZlsks() {
        return zlsks;
    }


}