package com.buit.his.sams.enums;

/**
 * 手术记账/退费项目 项目类型枚举
 * ss_ssjzdmx.SFXMLB/ss_zytfsqmx.TFXMLB
 */
public enum SsjzdmxXmlxEnum {
    MATERIALS("1", "材料"),
    PROJECT("2", "项目"),
    DRUG("3", "药品");

    private String value;
    private String text;

    SsjzdmxXmlxEnum(String value, String text) {
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

    //参数类型不能改为int 否则Integer类型入参会调用enum类equals(Object o)方法，而非本方法
    public boolean equals(String value) {
        return this.value.equals(value);
    }
}
