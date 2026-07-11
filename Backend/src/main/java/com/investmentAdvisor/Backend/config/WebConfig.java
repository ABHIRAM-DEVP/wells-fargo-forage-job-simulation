package com.investmentAdvisor.Backend.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import com.investmentAdvisor.Backend.interceptor.BusinessHoursInterceptor;

@Configuration
public class WebConfig implements WebMvcConfigurer {

    @Autowired
    private BusinessHoursInterceptor businessHoursInterceptor;

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(businessHoursInterceptor).addPathPatterns("/api/**");
    }
}
