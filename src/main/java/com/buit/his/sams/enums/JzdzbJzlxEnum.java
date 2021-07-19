package com.buit.his.sams.enums;

/**
 * 手术记账主表记账类型枚举
 * ss_ssjzdzb.jzlx
 */
public enum JzdzbJzlxEnum {
    SURGERY(1, "手术系统记帐"),
    ANESTHESIA(2, "麻醉系统记帐");

    private int value;
    private String text;

    JzdzbJzlxEnum(int value, String text) {
        this.value = value;
        this.text = text;
    }

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    //参数类型不能改为int 否则Integer类型入参会调用enum类equals(Object o)方法，而非本方法
    public boolean equals(Integer value) {
        return this.value == value;
    }
}
