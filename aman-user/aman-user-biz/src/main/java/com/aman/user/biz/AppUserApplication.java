package com.aman.user.biz;

import lombok.extern.slf4j.Slf4j;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

/**
 * 测试用例 启动类
 *
 * @author caoxiang
 * @since 2020-06-02
 */
@Slf4j
@EnableFeignClients
@SpringBootApplication
@EnableDiscoveryClient
@MapperScan("com.aman.user.biz.mapper") // 设置mapper接口的扫描路径
public class AppUserApplication {
    public static void main(String[] args) {
        SpringApplication.run(AppUserApplication.class, args);
        log.info("======================== Run Success!!! ========================");
    }
}
