package com.buit.his.sams.enums;

/**
 * 手术记账明细 记账类型枚举
 * ss_ssjzdmx.zt
 */
public enum SsjzdmxZtEnum {
    NORMAL("0", "正常记账"),
    REFUND("1", "退费记账");

    private String value;
    private String text;

    SsjzdmxZtEnum(String value, String text) {
        this.value = value;
        this.text = text;
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

    public boolean equals(Integer value) {
        return this.value.equals(value);
    }
}
