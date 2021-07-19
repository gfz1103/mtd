package com.buit.his.sams.request;

import com.buit.commons.PageQuery;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;


/**
 * 类名称：SsJzmbmx<br>
 * 类描述：手术麻醉记账模板明细列表查询入参<br>
 * @author zhouhaisheng
 */
@ApiModel(value="手术麻醉记账模板明细列表查询入参")
public class SsJzmbmxQueryReq  {

    @ApiModelProperty(value="机构id",hidden = true)
    private Integer jgid;
    @ApiModelProperty(value="his手术科室代码")
    private Integer ssksdm;

    @ApiModelProperty(value="记账模板主表记录序号")
    private Integer jzmbzbJlxh;

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

    public Integer getJzmbzbJlxh() {
        return jzmbzbJlxh;
    }

    public void setJzmbzbJlxh(Integer jzmbzbJlxh) {
        this.jzmbzbJlxh = jzmbzbJlxh;
    }
}