package com.land.base.config;

import java.util.UUID;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.land.base.enums.LandConfig;

import org.slf4j.MDC;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;

@Component
public class MdcInterceptor implements HandlerInterceptor {
    
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        String traceId = getTraceId(request);
        MDC.put(LandConfig.MDF_TRACEID.getDesc(), traceId);
        response.addHeader(LandConfig.MDF_TRACEID.getDesc(),traceId);
        return true;
    }

    private String getTraceId(HttpServletRequest request){
        return String.format("%s", UUID.randomUUID());
    }
}
