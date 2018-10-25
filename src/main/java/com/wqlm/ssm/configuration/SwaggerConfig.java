package com.wqlm.ssm.configuration;

import io.swagger.annotations.ApiOperation;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

/**
 * swagger配置类
 * 用法
 * @Api() 用于类,表示标识这个类是swagger的资源
 * @ApiOperation() 用于方法；表示一个http请求的操作
 * @ApiParam() 用于方法、参数、字段说明，表示对参数的添加元数据（说明或是否必填等）
 * @ApiModel() 用于类，表示对类进行说明，用于参数用实体类接收
 * @ApiModelProperty() 用于方法、字段，表示对model属性的说明或者数据操作更改
 * @ApiIgnore() 用于类、方法、方法参数，表示这个方法或者类被忽略
 * @ApiImplicitParam() 用于方法表示单独的请求参数
 * @ApiImplicitParams() 用于方法，包含多个 @ApiImplicitParam
 */

@Configuration  //让Spring来加载该类配置
@EnableWebMvc   //启用Mvc，非spring boot框架需要引入注解@EnableWebMvc
@EnableSwagger2 //启用Swagger2
public class SwaggerConfig {

    @Bean
    public Docket api() {
        return new Docket(DocumentationType.SWAGGER_2)
                .apiInfo(apiInfo())
                .select()
                //扫描指定包中的swagger注解
                //.apis(RequestHandlerSelectors.basePackage("com.xia.controller"))
                //扫描所有有注解的api，用这种方式更灵活
                .apis(RequestHandlerSelectors.withMethodAnnotation(ApiOperation.class))
                .paths(PathSelectors.any())
                .build();
    }


    private ApiInfo apiInfo() {
        return new ApiInfoBuilder()
                .title("基础平台 RESTful APIs")
                .description("RESTful风格的接口文档，内容详细，极大的减少了前后端的沟通成本，同时确保代码与文档保持高度一致，极大的减少维护文档的时间。")
                .termsOfServiceUrl("Url的服务条款")
                .version("1.0.0")
                .build();

    }
}

