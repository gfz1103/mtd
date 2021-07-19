package com.buit.his.sams.request;

import com.buit.commons.PageQuery;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.util.List;


/**
 * 类名称：SsSsap<br>
 * 类描述：手术安排一览表分页查询入参<br>
 * @author zhouhaisheng
 */
@ApiModel(value="手术安排一览表分页查询入参")
public class SsapViewQueryPageReq extends  PageQuery{

    @ApiModelProperty(value="机构id",hidden = true)
    private Integer jgid;
    @ApiModelProperty(value="手术 科室代码")
    private Integer ssksdm;
    @ApiModelProperty(value="开始时间")
    private  String startDate;
    @ApiModelProperty(value="结束时间")
    private String endDate;
    @ApiModelProperty(value="手术安排时间")
    private String ssapsj;
    @ApiModelProperty(value = "手术间")
    private Integer ssj;
    @ApiModelProperty(value = "手术状态 | 0：未安排    1：已安排    2：已完成")
    private List<Integer> zt;

    public Integer getJgid() {
        return jgid;
    }

    public void setJgid(Integer jgid) {
        this.jgid = jgid;
    }

    public Integer getSsksdm() {
        return ssksdm;
    }

    public void setSsksdm(Integer ssksdm) {
        this.ssksdm = ssksdm;
    }

    public String getStartDate() {
        return startDate;
    }

    public void setStartDate(String startDate) {
        this.startDate = startDate;
    }

    public String getEndDate() {
        return endDate;
    }

    public void setEndDate(String endDate) {
        this.endDate = endDate;
    }

    public String getSsapsj() {
        return ssapsj;
    }

    public void setSsapsj(String ssapsj) {
        this.ssapsj = ssapsj;
    }

    public Integer getSsj() {
        return ssj;
    }

    public void setSsj(Integer ssj) {
        this.ssj = ssj;
    }

    public List<Integer> getZt() {
        return zt;
    }

    public void setZt(List<Integer> zt) {
        this.zt = zt;
    }
}