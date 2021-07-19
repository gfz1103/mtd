package com.buit.his.treatment.enums;

/**
 * @Description 作废判别
 * @Author jiangwei
 * @Date 2021/03/26
 */
public enum ZfpbEnum {
    ABLE(0, "启用 | 正常"),
    DISABLED(1, "停用 | 作废");

    private int value;
    private String text;

    ZfpbEnum(int value, String text) {
        this.value = value;
        this.text = text;
    }

    //参数类型不能改为int 否则Integer类型入参会调用enum类equals(Object o)方法，而非本方法
    public boolean equals(Integer value) {
        return this.value == value;
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
}
