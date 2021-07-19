package com.buit.his.mtdms.enums;

public enum LxEnum {

    /**
     * 门诊
     */
    MZ(1),
    /**
     * 取消执行
     */
    ZY(2);

    private Integer code;

    LxEnum(Integer code) {
        this.code = code;
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

}