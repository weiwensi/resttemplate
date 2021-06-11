package com.one.learn.resttemplate.hadler;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class MyMvcConfigure implements WebMvcConfigurer {
    @Autowired
    private LoginInterceptor loginInterceptor;

    @Override
    //在此方法添加自定义拦截器
    public void addInterceptors(InterceptorRegistry registry) {

        //添加自定义拦截器                //拦截器拦截那些路径
        registry.addInterceptor(loginInterceptor).addPathPatterns("/user/*");
        //不拦截的路径
        // .excludePathPatterns("");
    }
}

