package com.yp.foodmall.common.configuration;


import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.PropertyAccessor;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.convert.converter.Converter;
import org.springframework.format.FormatterRegistry;
import org.springframework.http.MediaType;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Configuration
public class PbipConfiguration  implements WebMvcConfigurer {

    /**
     * 解決日期转换问题
     * @param registry
     */
    @Override
    public void addFormatters(FormatterRegistry registry) {
        registry.addConverter(new Converter<String, Date>() {
            @Override
            public Date convert(String s) {
                Date d = null;
                try {
                    d = new SimpleDateFormat("yyyy-MM-dd").parse(s);
                } catch (ParseException e) {
                    e.printStackTrace();
                }
                return d;
            }
        });

    }
    /**
     * 跨域问题
     */
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

    /**
     * restTemplate的配置
     * @param builder
     * @return
     */
    @Bean
    public RestTemplate restTemplate(RestTemplateBuilder builder) {
        //先获取到converter列表
        List<HttpMessageConverter<?>> converters = builder.build().getMessageConverters();
        for(HttpMessageConverter<?> converter : converters){
            //因为我们只想要jsonConverter支持对text/html的解析
            if(converter instanceof MappingJackson2HttpMessageConverter){
                try{
                    //先将原先支持的MediaType列表拷出
                    List<MediaType> mediaTypeList = new ArrayList<>(converter.getSupportedMediaTypes());
                    //加入对MIME的支持
                    mediaTypeList.add(MediaType.ALL);
                    //将已经加入了text/html的MediaType支持列表设置为其支持的媒体类型列表
                    ((MappingJackson2HttpMessageConverter) converter).setSupportedMediaTypes(mediaTypeList);
                }catch(Exception e){
                    e.printStackTrace();
                }
            }
        }
        return builder.build();
    }

}
