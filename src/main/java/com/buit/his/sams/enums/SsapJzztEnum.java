package com.buit.his.sams.enums;

/**
 * 手术安排表 记账状态
 * ss_ssap.jzzt
 */
public enum SsapJzztEnum {
    RECORDED(0, "未记账"),
    UNRECORDED(1, "已记账"),
    CHECKED(2, "已审核");

    private int value;
    private String text;

    SsapJzztEnum(int value, String text) {
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
