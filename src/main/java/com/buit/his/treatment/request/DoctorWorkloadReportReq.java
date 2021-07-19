package com.buit.his.treatment.request;

import com.buit.commons.PageQuery;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import javax.validation.constraints.NotNull;
import java.util.List;

/**
 * @Author jiangwei
 * @Date 2021-03-31 18:19
 **/
@ApiModel("医生治疗工作量统计报表查询参数封装")
public class DoctorWorkloadReportReq extends PageQuery {
    @ApiModelProperty(value = "医疗机构id", hidden = true)
    private Integer jgid;

    @ApiModelProperty(value = "治疗科室代码")
    private Integer zlksdm;

    @ApiModelProperty(value = "诊疗类别")
    private Integer zllb;

    @ApiModelProperty(value = "收费项目代码")
    private List<Integer> sfxmdm;

    @NotNull
    @ApiModelProperty(value = "开始日期")
    private String ksrq;

    @NotNull
    @ApiModelProperty(value = "结束日期")
    private String jsrq;

    @ApiModelProperty(value = "执行人")
    private Integer zxgh;

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

    public Integer getZllb() {
        return zllb;
    }

    public void setZllb(Integer zllb) {
        this.zllb = zllb;
    }

    public List<Integer> getSfxmdm() {
        return sfxmdm;
    }

    public void setSfxmdm(List<Integer> sfxmdm) {
        this.sfxmdm = sfxmdm;
    }

    public String getKsrq() {
        return ksrq;
    }

    public void setKsrq(String ksrq) {
        this.ksrq = ksrq;
    }

    public String getJsrq() {
        return jsrq;
    }

    public void setJsrq(String jsrq) {
        this.jsrq = jsrq;
    }

    public Integer getZxgh() {
        return zxgh;
    }

    public void setZxgh(Integer zxgh) {
        this.zxgh = zxgh;
    }

}
