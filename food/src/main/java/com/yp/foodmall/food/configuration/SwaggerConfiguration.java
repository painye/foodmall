package com.yp.foodmall.food.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@Configuration
@EnableSwagger2
public class SwaggerConfiguration {

    @Bean
    public Docket createRestApi(){
        return new Docket(DocumentationType.SWAGGER_2)
                .apiInfo(apiInfo("美食商城-商品模块",
                        "美食商城的商品接口模块测试",
                        "http://localhost:8099/swagger-ui.html",
                        "v2.0"))
                .select()
                .apis(RequestHandlerSelectors.basePackage("com.yp.foodmall.food.controller"))
                .paths(PathSelectors.any())
                .build();

    }


    protected ApiInfo apiInfo(String title, String desc, String url, String version){
        return new ApiInfoBuilder()
                .title("美食商城-商品模块")
                .description("美食商城的商品接口模块测试")
                .termsOfServiceUrl("http://localhost:8099/swagger-ui.html")
                .version("v2.0")
                .build();
    }
}
