package com.buit.his.treatment.request;

import com.buit.commons.PageQuery;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;


/**
 * 类名称：ZlXm<br>
 * 类描述：治疗项目设置分页查询入参<br>
 * @author ZHOUHAISHENG
 */
@ApiModel(value="治疗项目设置分页查询入参")
public class ZlXmPageReq extends  PageQuery{
    @ApiModelProperty(value="医疗机构代码",hidden = true)
    private Integer jgid;
    @ApiModelProperty(value="治疗科室代码")
    private Integer zlksdm;
    @ApiModelProperty(value="治疗项目名称")
    private String zlxmmc;
    @ApiModelProperty(value="类别名称")
    private String lbmc;
    @ApiModelProperty(value="类别")
    private Integer zllb;
    public Integer getZllb() {
        return zllb;
    }

    public void setZllb(Integer zllb) {
        this.zllb = zllb;
    }

    public Integer getJgid() {
        return jgid;
    }

    public void setJgid(Integer jgid) {
        this.jgid = jgid;
    }

    public Integer getZlksdm() {
        return zlksdm;
    }

    public void setZlksdm(Integer zlksdm) {
        this.zlksdm = zlksdm;
    }

    public String getZlxmmc() {
        return zlxmmc;
    }

    public void setZlxmmc(String zlxmmc) {
        this.zlxmmc = zlxmmc;
    }

    public String getLbmc() {
        return lbmc;
    }

    public void setLbmc(String lbmc) {
        this.lbmc = lbmc;
    }
}
