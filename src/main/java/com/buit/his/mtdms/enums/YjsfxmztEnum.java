package com.buit.his.mtdms.enums;

/**
 * 
 * @author wangyang
 *
 */
public enum YjsfxmztEnum {
	/**
	 * 作废
	 */
	ZF("0"),
	/**
	 * 有效
	 */
	YX("1"),
	/**
	 * 取消执行
	 */
	QXZX("2");

	private String code;

	YjsfxmztEnum(String code) {
		this.code = code;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}
}
