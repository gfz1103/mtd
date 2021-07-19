package com.buit.his.treatment.response;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;
import java.util.List;

/**
 * @Author jiangwei
 * @Date 2021-04-01 16：03
 * @Description
 **/
@ApiModel("治疗记录单打印 - 治疗记录块状内容")
public class ExecuteLogResp implements Serializable {
    @ApiModelProperty(value = "记录列表")
    private List<ZljlReportDetailResp> list;
    @ApiModelProperty(value = "阶段小结")
    private String jdxj;

    public List<ZljlReportDetailResp> getList() {
        return list;
    }

    public void setList(List<ZljlReportDetailResp> list) {
        this.list = list;
    }

    public String getJdxj() {
        return jdxj;
    }

    public void setJdxj(String jdxj) {
        this.jdxj = jdxj;
    }
}
