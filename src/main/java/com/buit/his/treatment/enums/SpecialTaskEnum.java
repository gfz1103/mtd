package com.buit.his.treatment.enums;

/**
 * jiangwei
 * 特殊任务状态枚举
 */
public enum SpecialTaskEnum {
    IS_NEW(1, "新病人"),
    IS_NEED_SUMMARY(1, "需要阶段小结");

    private int value;
    private String text;

    SpecialTaskEnum(int value, String text) {
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
