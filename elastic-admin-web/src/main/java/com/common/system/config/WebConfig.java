package com.common.system.config;

import com.common.system.config.xss.XssFilter;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * Created by Mr.biantech on 2017/6/29.
 * Time:9:55
 * ProjectName:elastic-admin
 */
@Configuration
public class WebConfig {
    /**
     * xssFilter注册
     */
    @Bean
    public FilterRegistrationBean xssFilterRegistration() {
        FilterRegistrationBean registration = new FilterRegistrationBean(new XssFilter());
        registration.addUrlPatterns("/*");
        return registration;
    }

}
