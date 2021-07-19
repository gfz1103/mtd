package com.buit.his.treatment.request;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import javax.validation.constraints.NotNull;
import java.sql.Timestamp;


/**
 * 类名称：ZlRwfp<br>
 * 类描述：康复治疗任务分配表<br>
 *
 * @author 韦靖
 */
@ApiModel(value = "康复治疗任务分配表")
public class ZlRwfpReq {
    @NotNull
    @ApiModelProperty(value = "康复治疗任务分配ID")
    private Integer zlrwfpid;
    @NotNull
    @ApiModelProperty(value = "住院号")
    private Integer zyh;
    @ApiModelProperty(value = "分配状态 | 0：未分配    2：已分配", hidden = true)
    private Integer fpzt;
    @NotNull
    @ApiModelProperty(value = "治疗小组ID")
    private Integer zlzid;
    @NotNull
    @ApiModelProperty(value = "治疗师代码")
    private Integer zlsdm;
    @ApiModelProperty(value = "分配时间", hidden = true)
    private Timestamp fpsj;
    /**
     * 设置:康复治疗任务分配ID
     */
    public void setZlrwfpid(Integer value) {
        this.zlrwfpid = value;
    }

    /**
     * 获取:康复治疗任务分配ID
     */
    public Integer getZlrwfpid() {
        return zlrwfpid;
    }

    public Integer getZyh() {
        return zyh;
    }

    public void setZyh(Integer zyh) {
        this.zyh = zyh;
    }

    /**
     * 设置:分配状态 1已分配 0未分配
     */
    public void setFpzt(Integer value) {
        this.fpzt = value;
    }

    /**
     * 获取:分配状态 1已分配 0未分配
     */
    public Integer getFpzt() {
        return fpzt;
    }
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
     * 设置:治疗师代码
     */
    public void setZlsdm(Integer value) {
        this.zlsdm = value;
    }
    /**
     * 获取:治疗师代码
     */
    public Integer getZlsdm() {
        return zlsdm;
    }
    /**
     * 设置:分配时间
     */
    public void setFpsj(Timestamp value) {
        this.fpsj = value;
    }
    /**
     * 获取:分配时间
     */
    public Timestamp getFpsj() {
        return fpsj;
    }
}
