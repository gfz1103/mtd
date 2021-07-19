package com.buit.his.treatment.enums;

/**
 * 患者性别枚举
 */
public enum SexEnum {
    MALE(1, "男"),
    FEMALE(2, "女"),
    UNKNOWN(3, "未知");

    private int value;
    private String text;

    SexEnum(int value, String text) {
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

    public static String getText(Integer value) {
        for (SexEnum sex : SexEnum.values()) {
            if (sex.equals(value)) {
                return sex.getText();
            }
        }
        return null;
    }
}
