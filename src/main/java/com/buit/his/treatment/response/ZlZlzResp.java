package com.buit.his.treatment.response;

import java.sql.Timestamp;

import com.buit.commons.PageQuery;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;


/**
 * 类名称：ZlZlz<br>
 * 类描述：治疗小组表<br>
 * @author 韦靖
 */
@ApiModel(value="治疗小组表")
public class ZlZlzResp  extends  PageQuery{
    @ApiModelProperty(value="治疗小组ID")
    private Integer zlzid;
    @ApiModelProperty(value="医疗机构代码")
    private Integer jgid;
    @ApiModelProperty(value="治疗组名称")
    private String zlzmc;
    @ApiModelProperty(value="治疗类别")
    private Integer zllb;
    @ApiModelProperty(value="状态 1启用 0停用")
    private String zt;
    /**
     * 设置:治疗小组ID
     */
    public void setZlzid(Integer value) {
        this.zlzid = value;
    }
    /**
     * 获取:治疗小组ID
     */
    public Integer getZlzid() {
        return zlzid;
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
     * 设置:治疗组名称
     */
    public void setZlzmc(String value) {
        this.zlzmc = value;
    }
    /**
     * 获取:治疗组名称
     */
    public String getZlzmc() {
        return zlzmc;
    }
    /**
     * 设置:治疗类别
     */
    public void setZllb(Integer value) {
        this.zllb = value;
    }
    /**
     * 获取:治疗类别
     */
    public Integer getZllb() {
        return zllb;
    }
    /**
     * 设置:状态 1启用 0停用
     */
    public void setZt(String value) {
        this.zt = value;
    }
    /**
     * 获取:状态 1启用 0停用
     */
    public String getZt() {
        return zt;
    }
}
