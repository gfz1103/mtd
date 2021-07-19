
package com.buit.his.mtdms.response;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * 类名称：QueryYsdmListResp<br>
 * 类描述：执行科室下的执行医生返回<br>
 * 
 * @author WY
 */
@ApiModel(value = "执行科室下的执行医生返回")
public class QueryYsdmListResp {
	@ApiModelProperty(value = "医生代码")
	private Integer ygdm;
	@ApiModelProperty(value = "医生名称")
	private String personName;

	public Integer getYgdm() {
		return ygdm;
	}

	public void setYgdm(Integer ygdm) {
		this.ygdm = ygdm;
	}

	public String getPersonName() {
		return personName;
	}

	public void setPersonName(String personName) {
		this.personName = personName;
	}

}