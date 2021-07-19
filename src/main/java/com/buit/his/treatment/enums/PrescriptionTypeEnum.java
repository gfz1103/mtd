package com.buit.his.treatment.enums;

/**
 * jiangwei
 * 医嘱类型枚举
 * ZL_RWMB.LSYZ
 */
public enum PrescriptionTypeEnum {
    LONG_TERM(0, "长期医嘱"),
    TEMPORARY(1, "临时医嘱");

    private int value;
    private String text;

    PrescriptionTypeEnum(int value, String text) {
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
