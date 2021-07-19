package com.buit.his.mtdms.enums;

public enum DoEnum {
    /**
     * 确认
     */
    QR("1"),
    /**
     * 取消
     */
    QX("0");

    private String code;

    DoEnum(String code) {
        this.code = code;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }
}
