package com.buit.his.op.queuing.model;

import com.buit.commons.PageQuery;

import java.sql.Timestamp;

/**
 * 类名称：OpFwtxx<br> 
 * 类描述：服务台信息
 * @author 老花生 
 * @ApiModel(value="服务台信息")
 */
public class OpFwtxx  extends  PageQuery{
	//@ApiModelProperty(value="数据ID")
    /** 数据ID */
    private Integer rid;
	//@ApiModelProperty(value="版本号")
    /** 版本号 */
    private Integer bbh;
	//@ApiModelProperty(value="创建时间")
    /** 创建时间 */
    private Timestamp cjsj;
	//@ApiModelProperty(value="最后更新时间")
    /** 最后更新时间 */
    private Timestamp gxsj;
	//@ApiModelProperty(value="医疗机构ID")
    /** 医疗机构ID */
    private Integer jgid;
	//@ApiModelProperty(value="类型 1 服务台 2 诊室 3 节点")
    /** 类型 1 服务台 2 诊室 3 节点 */
    private String lx;
	//@ApiModelProperty(value="服务台/诊室代码")
    /** 服务台/诊室代码 */
    private String zsdm;
	//@ApiModelProperty(value="服务台/诊室名称")
    /** 服务台/诊室名称 */
    private String zsmc;
	//@ApiModelProperty(value="地址")
    /** 地址 */
    private String dz;
	//@ApiModelProperty(value="父类ID")
    /** 父类ID */
    private Integer fid;
	//@ApiModelProperty(value="排序号")
    /** 排序号 */
    private Integer pxh;
	//@ApiModelProperty(value="可用 0 可用 1 停用")
    /** 可用 0 可用 1 停用 */
    private String sfky;
	//@ApiModelProperty(value="院区代码")
    /** 院区代码 */
    private String yqdm;
	//@ApiModelProperty(value="拼音码")
    /** 拼音码 */
    private String pydm;
	//@ApiModelProperty(value="五笔码")
    /** 五笔码 */
    private String wbdm;
    //@ApiModelProperty(value="挂号科室集合")
    /** 挂号科室集合 */
    private String ghksjh;

    /** 设置:数据ID  */
    public void setRid(Integer value) {
        this.rid = value;
    }
    /** 获取:数据ID */
    public Integer getRid() {
        return rid;
    }

    /** 设置:版本号  */
    public void setBbh(Integer value) {
        this.bbh = value;
    }
    /** 获取:版本号 */
    public Integer getBbh() {
        return bbh;
    }

    /** 设置:创建时间  */
    public void setCjsj(Timestamp value) {
        this.cjsj = value;
    }
    /** 获取:创建时间 */
    public Timestamp getCjsj() {
        return cjsj;
    }

    /** 设置:最后更新时间  */
    public void setGxsj(Timestamp value) {
        this.gxsj = value;
    }
    /** 获取:最后更新时间 */
    public Timestamp getGxsj() {
        return gxsj;
    }

    /** 设置:医疗机构ID  */
    public void setJgid(Integer value) {
        this.jgid = value;
    }
    /** 获取:医疗机构ID */
    public Integer getJgid() {
        return jgid;
    }

    /** 设置:类型 1 服务台 2 诊室 3 节点  */
    public void setLx(String value) {
        this.lx = value;
    }
    /** 获取:类型 1 服务台 2 诊室 3 节点 */
    public String getLx() {
        return lx;
    }

    /** 设置:服务台/诊室代码  */
    public void setZsdm(String value) {
        this.zsdm = value;
    }
    /** 获取:服务台/诊室代码 */
    public String getZsdm() {
        return zsdm;
    }

    /** 设置:服务台/诊室名称  */
    public void setZsmc(String value) {
        this.zsmc = value;
    }
    /** 获取:服务台/诊室名称 */
    public String getZsmc() {
        return zsmc;
    }

    /** 设置:地址  */
    public void setDz(String value) {
        this.dz = value;
    }
    /** 获取:地址 */
    public String getDz() {
        return dz;
    }

    /** 设置:父类ID  */
    public void setFid(Integer value) {
        this.fid = value;
    }
    /** 获取:父类ID */
    public Integer getFid() {
        return fid;
    }

    /** 设置:排序号  */
    public void setPxh(Integer value) {
        this.pxh = value;
    }
    /** 获取:排序号 */
    public Integer getPxh() {
        return pxh;
    }

    /** 设置:可用 0 可用 1 停用  */
    public void setSfky(String value) {
        this.sfky = value;
    }
    /** 获取:可用 0 可用 1 停用 */
    public String getSfky() {
        return sfky;
    }

    /** 设置:院区代码  */
    public void setYqdm(String value) {
        this.yqdm = value;
    }
    /** 获取:院区代码 */
    public String getYqdm() {
        return yqdm;
    }

    /** 设置:拼音码  */
    public void setPydm(String value) {
        this.pydm = value;
    }
    /** 获取:拼音码 */
    public String getPydm() {
        return pydm;
    }

    /** 设置:五笔码  */
    public void setWbdm(String value) {
        this.wbdm = value;
    }
    /** 获取:五笔码 */
    public String getWbdm() {
        return wbdm;
    }

    public String getGhksjh() {
        return ghksjh;
    }

    public void setGhksjh(String ghksjh) {
        this.ghksjh = ghksjh;
    }
}