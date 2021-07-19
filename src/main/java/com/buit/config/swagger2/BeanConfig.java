package com.buit.config.swagger2;

import com.github.xiaoymin.knife4j.spring.annotations.EnableKnife4j;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import springfox.bean.validators.configuration.BeanValidatorPluginsConfiguration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.ParameterBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.schema.ModelRef;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Parameter;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import java.sql.Date;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

/**
* @ClassName: BeanConfig
* @Description: 接口文档配置
* @author 神算子
* @date 2020年4月26日 下午4:09:06
 */
@Configuration
@EnableSwagger2
@EnableKnife4j
@Import(BeanValidatorPluginsConfiguration.class)
public class BeanConfig {
	
	
	private ApiInfo apiInfo() {
		return new ApiInfoBuilder().title("云his系统").description("敢不敢做一个能上生产的系统，没有撤退可言。。兽人永不为奴。。")
				.termsOfServiceUrl("http://hisdev.51app.com/api").version("1.0").build();
	}

	@Bean(value = "defaultApi22")
	public Docket defaultApi22() {
		Docket docket=new Docket(DocumentationType.SWAGGER_2)
				.directModelSubstitute(Timestamp.class, String.class)
				.directModelSubstitute(Date.class, String.class)
				.apiInfo(apiInfo())
				.groupName("治疗管理")
				.select()
				.apis(RequestHandlerSelectors.basePackage("com.buit.his.treatment.controller"))
				.paths(PathSelectors.any())
				.build();
		return docket;
	}
	@Bean(value = "defaultApi23")
	public Docket defaultApi23() {
		Docket docket=new Docket(DocumentationType.SWAGGER_2)
				.directModelSubstitute(Timestamp.class, String.class)
				.directModelSubstitute(Date.class, String.class)
				.apiInfo(apiInfo())
				.groupName("手麻管理")
				.select()
				.apis(RequestHandlerSelectors.basePackage("com.buit.his.sams.controller"))
				.paths(PathSelectors.any())
				.build();
		return docket;
	}
	@Bean(value = "defaultApi21")
	public Docket defaultApi21() {
		ParameterBuilder ticketPar = new ParameterBuilder();
		List<Parameter> pars = new ArrayList<Parameter>();
		ticketPar.name("token").description("token")//name表示名称，description表示描述
				.modelRef(new ModelRef("string")).parameterType("header")
				.required(false).defaultValue("").build();//required表示是否必填，defaultvalue表示默认值
		pars.add(ticketPar.build());//添加完此处一定要把下边的带***的也加上否则不生效
		Docket docket=new Docket(DocumentationType.SWAGGER_2)
				.directModelSubstitute(Timestamp.class, String.class)
				.directModelSubstitute(Date.class, String.class)
				.apiInfo(apiInfo())
				.groupName("医技确费")
				.select()
				.apis(RequestHandlerSelectors.basePackage("com.buit.his.mtdms.controller"))
				.paths(PathSelectors.any())
				.build().globalOperationParameters(pars);
		return docket;
	}
	@Bean(value = "defaultApi24")
	public Docket defaultApi24() {
		Docket docket=new Docket(DocumentationType.SWAGGER_2)
				.directModelSubstitute(Timestamp.class, String.class)
				.directModelSubstitute(Date.class, String.class)
				.apiInfo(apiInfo())
				.groupName("分诊管理")
				.select()
				.apis(RequestHandlerSelectors.basePackage("com.buit.his.op.queuing.controller"))
				.paths(PathSelectors.any())
				.build();
		return docket;
	}

}
