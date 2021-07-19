package com.buit.his.treatment.enums;

/**
 * @Description 门诊治疗申请状态
 * @Author jiangwei
 * @Date 2021/04/14
 */
public enum ZlsqdZtEnum {
    NOT_APPOINTED("0", "未预约"),
    APPOINTED("1", "部分预约"),
    ALL_APPOINTED("2", "全部预约"),
    EXECUTED("3", "部分执行"),
    DONE("4", "完成");

    private String value;
    private String text;

    ZlsqdZtEnum(String value, String text) {
        this.value = value;
        this.text = text;
    }

    public boolean equals(String value) {
        return this.value.equals(value);
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }
}
