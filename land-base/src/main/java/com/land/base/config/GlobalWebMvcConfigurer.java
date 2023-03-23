package com.land.base.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Component
public class GlobalWebMvcConfigurer implements WebMvcConfigurer {

    @Autowired
    private MdcInterceptor mdcInterceptor;

    /*
     * traceId 拦截器需要在最开始执行
     */
    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(mdcInterceptor).order(0);
    }

}
