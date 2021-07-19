package com.buit.his.sams.request;

import com.buit.commons.PageQuery;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;


/**
 * 类名称：SsSqdzb<br>
 * 类描述：手术申请单手术申请分页查询<br>
 * @author zhouhaisheng
 */
@ApiModel(value="手术申请单手术申请分页查询")
public class SsSqdzbPageQueryReq extends  PageQuery{


    @ApiModelProperty(value="紧急类型 1择期/2急诊")
    private String jjlx;
    @ApiModelProperty(value="状态 0 申请/1 安排/2作废")
    private String zt;
    @ApiModelProperty(value="机构id",hidden = true)
    private Integer jgid;

    public String getJjlx() {
        return jjlx;
    }

    public void setJjlx(String jjlx) {
        this.jjlx = jjlx;
    }

    public String getZt() {
        return zt;
    }

    public void setZt(String zt) {
        this.zt = zt;
    }

    public Integer getJgid() {
        return jgid;
    }

    public void setJgid(Integer jgid) {
        this.jgid = jgid;
    }
}