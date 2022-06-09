package com.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import java.util.ArrayList;

@Configuration
@EnableSwagger2  //开启swagger
public class SwaggerConfig {
    /**
     * 配置了Swagger 的Docket的bean实例,扫描接口的位�?
     * .apis
     *   RequestHandlerSelectors 配置swagger扫描接口的方�?
     *      basePackage() 指定要扫描哪些包
     *      any() 全部都扫�?
     *      none() 全部不扫�?
     *      withClassAnnotation() 扫描类上的注�?参数是一个注解的反射对象
     *      withMethodAnnotation() 扫描包上的注�?
     * .paths
     *   PathSelectors 路径扫描接口
     *      ant 配置以xxx 开头的路径
     * @return
     */
    @Bean
    public Docket docket( ){

        return  new Docket(DocumentationType.SWAGGER_2)
                .apiInfo(apiInfo())
                .groupName("zzw")
                .select()
                .apis(RequestHandlerSelectors.basePackage("com.controller"))
                .build();//构建者模�?
    }
    /**
     * 配置Swagger信息 apiinfo
     * @return
     */
    private ApiInfo apiInfo(){
        //配置作者信�?
        Contact DEFAULT_CONTACT = new Contact("zzw", "https://deimos.magi-verse.com/", "15889951171@163.com");
        return  new ApiInfo(
                "zzw 的Swagger API文档",
                "Swagger API文档",
                "v1.0",
                "https://deimos.magi-verse.com/",
                DEFAULT_CONTACT,
                "Apache 2.0",
                "http://www.apache.org/licenses/LICENSE-2.0",
                new ArrayList());
    }

}
