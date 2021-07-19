package com.buit.his.treatment.request;

import com.buit.commons.PageQuery;
import com.buit.his.treatment.model.ZlZlzcyb;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import javax.validation.constraints.NotNull;
import java.util.List;


/**
 * 类名称：ZlZlzcyb<br>
 * 类描述：治疗小组成员表<br>
 * @author 韦靖
 */
@ApiModel(value = "治疗小组成员表")
public class ZlZlzcybReq extends PageQuery {
    @ApiModelProperty(value = "医疗机构代码", hidden = true)
    private Integer jgid;
    @ApiModelProperty(value = "治疗小组ID")
    @NotNull(message = "治疗小组ID不能为空")
    private Integer zlzid;
    @ApiModelProperty(value = "治疗类别")
    private Integer zllb;

    @ApiModelProperty(value = "治疗小组成员列表")
    private List<ZlZlzcyb> list;

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

    public Integer getZllb() {
        return zllb;
    }

    public void setZllb(Integer zllb) {
        this.zllb = zllb;
    }

    public List<ZlZlzcyb> getList() {
        return list;
    }

    public void setList(List<ZlZlzcyb> list) {
        this.list = list;
    }
}
