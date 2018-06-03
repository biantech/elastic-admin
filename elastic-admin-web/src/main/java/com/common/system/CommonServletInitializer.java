package com.common.system;

import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.support.SpringBootServletInitializer;

/**
 * Created by Mr.biantech on 2017/6/15.
 * Time:15:44
 * ProjectName:elastic-admin
 */
public class CommonServletInitializer extends SpringBootServletInitializer {
    @Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder builder) {
        return builder.sources(CommonAdminApplication.class);
    }
}
