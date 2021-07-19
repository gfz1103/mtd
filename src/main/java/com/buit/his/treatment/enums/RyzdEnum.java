package com.buit.his.treatment.enums;

/**
 * jiangwei
 * 入院诊断类别枚举
 * IM_RYZD.ZDLB
 */
public enum RyzdEnum {
    CLINIC_DIAGNOSIS(1, "门诊诊断"),
    ADMITTING_MAIN_DIAGNOSIS(2, "入院主诊断"),
    DISCHARGE_MAIN_DIAGNOSIS(3, "出院主诊断"),
    DISCHARGE_SECONDARY_DIAGNOSIS(4, "出院次诊断"),
    NOSOCOMIAL_INFECTION(5, "院内感染"),
    ADMITTING_SECONDARY_DIAGNOSIS(6, "入院次诊断"),
    PATHOLOGICAL_DIAGNOSIS(44, "病理诊断"),
    OTHERS_DIAGNOSIS(45, "损伤中毒的外部原因");

    private int value;
    private String text;

    RyzdEnum(int value, String text) {
        this.value = value;
        this.text = text;
    }

    /**
     * 判断患者物理上是否出院
     */
    public static boolean isDischarge(int cypb) {
        return cypb > 8;
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
