package com.yp.foodmall.front.configuration;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * 继承了WebMvc接口完成跨域的配置，一次请求跨域两次，两个模块都要配置跨域
 */
@Configuration
public class FrontConfiguration implements WebMvcConfigurer {
    @Override
    public void addCorsMappings(CorsRegistry registry) {
        WebMvcConfigurer.super.addCorsMappings(registry);
        registry.addMapping("/**")//跨域路径
                .allowedHeaders("Content-Type","X-Requested-With","accept,Origin","Access-Control-Request-Method","Access-Control-Request-Headers","token")
                .allowedOrigins("*")//跨域请求的域名
                .allowCredentials(true)//是否允许证书
                .allowedMethods("GET","POST","PUT","DELETE")//允许的方法
                .maxAge(3600);//跨域时间
    }
}
