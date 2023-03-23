package com.land.base.config;

import com.land.base.enums.LandConfig;

import org.apache.commons.lang3.StringUtils;
import org.slf4j.MDC;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import feign.RequestInterceptor;
import feign.RequestTemplate;

/**
 * feign的token拦截器
 */
@Configuration
// @ConditionalOnProperty(prefix ="feign.token", value = "interceptor", havingValue = "true", matchIfMissing = true)
public class FeignTokenInterceptor {

    private static final String ACCESS_TOKEN = "Access-Token";

    @Bean
    public RequestInterceptor requestTokenBearerInterceptor() {

        return new RequestInterceptor() {

            @Override
            public void apply(RequestTemplate requestTemplate) {
                ServletRequestAttributes requestAttributes = (ServletRequestAttributes) RequestContextHolder
                        .currentRequestAttributes();
                RequestContextHolder.setRequestAttributes(requestAttributes, true);//设置子线程共享
                String token = requestAttributes.getRequest().getHeader(ACCESS_TOKEN);
                if (StringUtils.isNotEmpty(token)) {
                    requestTemplate.header(ACCESS_TOKEN, token);
                }
                String reqId = MDC.get(LandConfig.MDF_TRACEID.getDesc());
                if (StringUtils.isNotEmpty(reqId)) {
                    requestTemplate.header(LandConfig.MDF_TRACEID.getDesc(), reqId);
                }
            }

        };
    }

}
