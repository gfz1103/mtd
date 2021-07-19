package com.buit.his.treatment.enums;

/**
 * @Description 收费状态
 */
public enum JcztEnum {
    FEE(1, "收费"),
    BACK(2, "退费");

    private int value;
    private String text;

    JcztEnum(int value, String text) {
        this.value = value;
        this.text = text;
    }

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
