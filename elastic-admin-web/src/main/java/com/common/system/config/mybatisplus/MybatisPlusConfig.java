package com.common.system.config.mybatisplus;

import com.baomidou.mybatisplus.plugins.PaginationInterceptor;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * Created by Mr.biantech on 2017/9/11.
 * Time:20:43
 * ProjectName:elastic-admin
 */
@Configuration
@MapperScan(value ={"com.biantech.elastic.admin.mapper","com.biantech.elastic.department.mapper"})
public class MybatisPlusConfig {
    /**
     * mybatis-plus分页插件<br>
     * 文档：http://mp.baomidou.com<br>
     */
    @Bean
    public PaginationInterceptor paginationInterceptor() {
        return new PaginationInterceptor();
    }
}
