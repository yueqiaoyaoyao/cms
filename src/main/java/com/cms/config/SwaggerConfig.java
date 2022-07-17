package com.cms.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.ParameterBuilder;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.schema.ModelRef;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.service.Parameter;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import java.util.ArrayList;
import java.util.List;

@Configuration
@EnableSwagger2
public class SwaggerConfig {
    // http://localhost:8080/swagger-ui.html	原访问路径

    @Bean
    public Docket webApiConfig(){
        //添加head参数
        ParameterBuilder tokenPar = new ParameterBuilder();
        List<Parameter> pars = new ArrayList<Parameter>();
        tokenPar
                .name("token")
                .description("令牌")
                .modelRef(new ModelRef("string"))
                .parameterType("header")
                .required(false)
                .build();
        pars.add(tokenPar.build());

        return new Docket(DocumentationType.SWAGGER_2)
                .groupName("webApi")
                .apiInfo(webApiInfo())
                .select()
                .apis(RequestHandlerSelectors.basePackage("com.cms.controllers"))
                .build()
                .globalOperationParameters(pars);
    }


    private ApiInfo webApiInfo(){
        return new ApiInfoBuilder()
                //文档标题
                .title("内容管理系统-API文档")
                //文档描述
                .description("接口定义")
                //文档版本
                .version("1.0")
                //作者及联系方式
                .contact(new Contact("zgb", "", "yueqiaozgb@163.com"))
                .build();
    }

}
