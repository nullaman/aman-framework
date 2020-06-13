package com.aman.user.biz.config;

import com.baomidou.mybatisplus.extension.plugins.OptimisticLockerInterceptor;
import com.baomidou.mybatisplus.extension.plugins.PaginationInterceptor;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.transaction.annotation.EnableTransactionManagement;

/**
 * MyBaits Plus 配置类
 *
 * @author caoxiang
 * @since 2020-06-02
 */
@EnableTransactionManagement
@Configuration
@MapperScan("com.aman.*.mapper")
public class MybatisPlusConfig {
    /**
     * 乐观锁 version
     *
     * @author caoxiang
     * @date 2020-01-29
     */
    @Bean
    public OptimisticLockerInterceptor optimisticLockerInterceptor() {
        return new OptimisticLockerInterceptor();
    }

    /**
     * 分页插件
     */
    @Bean
    public PaginationInterceptor paginationInterceptor() {
        return new PaginationInterceptor();
    }

}
