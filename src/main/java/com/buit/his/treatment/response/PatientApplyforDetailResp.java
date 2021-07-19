package com.buit.his.treatment.response;

import com.buit.commons.PageQuery;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * 病人申请单治疗项目详情出参
 * zhouhaisheng
 */
@ApiModel(value = "病人申请单治疗项目详情出参")
public class PatientApplyforDetailResp extends PageQuery {

    @ApiModelProperty(value = "治疗类别")
    private String lbmc;
    @ApiModelProperty(value = "治疗项目")
    private String zlxmmc;
    @ApiModelProperty(value = "数量")
    private String sl;
    @ApiModelProperty(value = "执行疗程")
    private Integer zxlc;
    @ApiModelProperty(value = "疗程次数")
    private Integer lccs;
    @ApiModelProperty(value = "执行间隔")
    private String zxjg;
    @ApiModelProperty(value = "治疗结果")
    private String zlmb;
    @ApiModelProperty(value = "注意事项")
    private String zysx;
    @ApiModelProperty(value = "已预约次数")
    private Integer  yyycs;
    @ApiModelProperty(value = "已执行次数")
    private Integer yzxcs;

    public String getLbmc() {
        return lbmc;
    }

    public void setLbmc(String lbmc) {
        this.lbmc = lbmc;
    }

    public String getZlxmmc() {
        return zlxmmc;
    }

    public void setZlxmmc(String zlxmmc) {
        this.zlxmmc = zlxmmc;
    }

    public String getSl() {
        return sl;
    }

    public void setSl(String sl) {
        this.sl = sl;
    }

    public Integer getZxlc() {
        return zxlc;
    }

    public void setZxlc(Integer zxlc) {
        this.zxlc = zxlc;
    }

    public Integer getLccs() {
        return lccs;
    }

    public void setLccs(Integer lccs) {
        this.lccs = lccs;
    }

    public String getZxjg() {
        return zxjg;
    }

    public void setZxjg(String zxjg) {
        this.zxjg = zxjg;
    }

    public String getZlmb() {
        return zlmb;
    }

    public void setZlmb(String zlmb) {
        this.zlmb = zlmb;
    }

    public String getZysx() {
        return zysx;
    }

    public void setZysx(String zysx) {
        this.zysx = zysx;
    }

    public Integer getYyycs() {
        return yyycs;
    }

    public void setYyycs(Integer yyycs) {
        this.yyycs = yyycs;
    }

    public Integer getYzxcs() {
        return yzxcs;
    }

    public void setYzxcs(Integer yzxcs) {
        this.yzxcs = yzxcs;
    }
}
