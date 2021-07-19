package com.buit.his.treatment.enums;

/**
 * @Description 住院治疗任务数据状态
 * @Author jiangwei
 * @Date 2021/03/26
 */
public enum ZlRwZtEnum {
    //数据的初始状态
    NOT(0, "未分配 | 未预约 | 未执行"),

    //对于集合型的业务数据代表部分数据已操作，部分数据未操作
    //对于持续性的业务数据代表数据已经开始操作，但还未结束
    NOT_ALL(1, "| 部分预约 | 部分执行(开始执行)"),

    //表示数据已经完全操作完毕
    DONE(2, "已分配 | 已预约 | 已执行（执行完毕）"),

    CANCELED(3, " | 取消预约 | |取消执行");

    private int value;
    private String text;

    ZlRwZtEnum(int value, String text) {
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
