package com.Config;

import com.baomidou.mybatisplus.extension.plugins.MybatisPlusInterceptor;
import com.baomidou.mybatisplus.extension.plugins.inner.PaginationInnerInterceptor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;


@Configuration
public class MPConfig {
    @Bean
    public MybatisPlusInterceptor mbi(){
        MybatisPlusInterceptor Interceptor=new MybatisPlusInterceptor();
        Interceptor.addInnerInterceptor(new PaginationInnerInterceptor());
        return  Interceptor;
    }
}
