package com.buit.his.treatment.request;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import javax.validation.constraints.NotNull;
import java.util.List;

/**
 * @Author jiangwei
 * @Date 2021-03-29 20：14
 * @Description
 **/
@ApiModel("修改治疗记录入参")
public class ZljlFormReq {
    @NotNull
    @ApiModelProperty(value = "记录序号")
    private Integer jlxh;
    @NotNull
    @ApiModelProperty(value = "住院号")
    private Integer zyh;
    @NotNull
    @ApiModelProperty(value = "执行治疗师工号")
    private Integer zxgh;
    @ApiModelProperty(value = "见习治疗师工号")
    private Integer jxgh;
    @ApiModelProperty(value = "不良反应")
    private String blfy;
    @ApiModelProperty(value = "备注信息")
    private String bzxx;
    @ApiModelProperty(value = "阶段小结")
    private String jdxj;
    @NotNull
    @ApiModelProperty(value = "执行批次数组")
    private List<ZlZlpcReq> zlpcList;

    public Integer getJlxh() {
        return jlxh;
    }

    public void setJlxh(Integer jlxh) {
        this.jlxh = jlxh;
    }

    public Integer getZyh() {
        return zyh;
    }

    public void setZyh(Integer zyh) {
        this.zyh = zyh;
    }

    public Integer getZxgh() {
        return zxgh;
    }

    public void setZxgh(Integer zxgh) {
        this.zxgh = zxgh;
    }

    public Integer getJxgh() {
        return jxgh;
    }

    public void setJxgh(Integer jxgh) {
        this.jxgh = jxgh;
    }

    public String getBlfy() {
        return blfy;
    }

    public void setBlfy(String blfy) {
        this.blfy = blfy;
    }

    public String getBzxx() {
        return bzxx;
    }

    public void setBzxx(String bzxx) {
        this.bzxx = bzxx;
    }

    public String getJdxj() {
        return jdxj;
    }

    public void setJdxj(String jdxj) {
        this.jdxj = jdxj;
    }

    public List<ZlZlpcReq> getZlpcList() {
        return zlpcList;
    }

    public void setZlpcList(List<ZlZlpcReq> zlpcList) {
        this.zlpcList = zlpcList;
    }
}
