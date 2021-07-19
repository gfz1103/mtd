package com.buit.his.mtdms.enums;

/**
 * 
 * @author wangyang
 *
 */
public enum YjzxztEnum {
	/**
	 * 未执行
	 */
	WZX("0"),
	/**
	 * 已执行
	 */
	YZX("1"),
	/**
	 * 作废
	 */
	ZF("2"),
	/**
	 * 取消执行
	 */
	QXZX("3"),
	/**
	 * 全部执行
	 */
	QBZX("5");

	private String code;

	YjzxztEnum(String code) {
		this.code = code;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}
}
