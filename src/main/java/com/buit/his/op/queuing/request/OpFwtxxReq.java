
package com.buit.his.op.queuing.request;

import com.buit.commons.PageQuery;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import javax.validation.constraints.NotNull;
import java.sql.Timestamp;


/**
 * 类名称：OpFwtxx<br>
 * 类描述：服务台信息<br>
 * @author 老花生
 */
@ApiModel(value="服务台信息-请求")
public class OpFwtxxReq  extends  PageQuery{
    @NotNull(message = "rid 不能为空")
    @ApiModelProperty(value="数据ID", hidden = true)
    private Integer rid;
    @ApiModelProperty(value="版本号", hidden = true)
    private Integer bbh;
    @ApiModelProperty(value="创建时间", hidden = true)
    private Timestamp cjsj;
    @ApiModelProperty(value="最后更新时间", hidden = true)
    private Timestamp gxsj;
    @ApiModelProperty(value="医疗机构ID", hidden = true)
    private Integer jgid;
    @ApiModelProperty(value="类型 1 服务台 2 诊室 3 节点", hidden = true)
    private String lx = "1";
    @ApiModelProperty(value="服务台/诊室代码", hidden = true)
    private String zsdm;
    @ApiModelProperty(value="服务台/诊室名称")
    private String zsmc;
    @ApiModelProperty(value="地址", hidden = true)
    private String dz;
    @ApiModelProperty(value="排序号", hidden = true)
    private Integer pxh;
    @ApiModelProperty(value="可用 0 可用 1 停用")
    private String sfky;
    @ApiModelProperty(value="院区代码", hidden = true)
    private String yqdm;
    @ApiModelProperty(value="拼音码", hidden = true)
    private String pydm;
    @ApiModelProperty(value="五笔码", hidden = true)
    private String wbdm;
    /**
     * 设置:数据ID
     */
    public void setRid(Integer value) {
        this.rid = value;
    }
    /**
     * 获取:数据ID
     */
    public Integer getRid() {
        return rid;
    }
    /**
     * 设置:版本号
     */
    public void setBbh(Integer value) {
        this.bbh = value;
    }
    /**
     * 获取:版本号
     */
    public Integer getBbh() {
        return bbh;
    }
    /**
     * 设置:创建时间
     */
    public void setCjsj(Timestamp value) {
        this.cjsj = value;
    }
    /**
     * 获取:创建时间
     */
    public Timestamp getCjsj() {
        return cjsj;
    }
    /**
     * 设置:最后更新时间
     */
    public void setGxsj(Timestamp value) {
        this.gxsj = value;
    }
    /**
     * 获取:最后更新时间
     */
    public Timestamp getGxsj() {
        return gxsj;
    }
    /**
     * 设置:医疗机构ID
     */
    public void setJgid(Integer value) {
        this.jgid = value;
    }
    /**
     * 获取:医疗机构ID
     */
    public Integer getJgid() {
        return jgid;
    }
    /**
     * 设置:类型 1 服务台 2 诊室 3 节点
     */
    public void setLx(String value) {
        this.lx = value;
    }
    /**
     * 获取:类型 1 服务台 2 诊室 3 节点
     */
    public String getLx() {
        return lx;
    }
    /**
     * 设置:服务台/诊室代码
     */
    public void setZsdm(String value) {
        this.zsdm = value;
    }
    /**
     * 获取:服务台/诊室代码
     */
    public String getZsdm() {
        return zsdm;
    }
    /**
     * 设置:服务台/诊室名称
     */
    public void setZsmc(String value) {
        this.zsmc = value;
    }
    /**
     * 获取:服务台/诊室名称
     */
    public String getZsmc() {
        return zsmc;
    }
    /**
     * 设置:地址
     */
    public void setDz(String value) {
        this.dz = value;
    }
    /**
     * 获取:地址
     */
    public String getDz() {
        return dz;
    }
    /**
     * 设置:排序号
     */
    public void setPxh(Integer value) {
        this.pxh = value;
    }
    /**
     * 获取:排序号
     */
    public Integer getPxh() {
        return pxh;
    }
    /**
     * 设置:可用 0 可用 1 停用
     */
    public void setSfky(String value) {
        this.sfky = value;
    }
    /**
     * 获取:可用 0 可用 1 停用
     */
    public String getSfky() {
        return sfky;
    }
    /**
     * 设置:院区代码
     */
    public void setYqdm(String value) {
        this.yqdm = value;
    }
    /**
     * 获取:院区代码
     */
    public String getYqdm() {
        return yqdm;
    }
    /**
     * 设置:拼音码
     */
    public void setPydm(String value) {
        this.pydm = value;
    }
    /**
     * 获取:拼音码
     */
    public String getPydm() {
        return pydm;
    }
    /**
     * 设置:五笔码
     */
    public void setWbdm(String value) {
        this.wbdm = value;
    }
    /**
     * 获取:五笔码
     */
    public String getWbdm() {
        return wbdm;
    }
}