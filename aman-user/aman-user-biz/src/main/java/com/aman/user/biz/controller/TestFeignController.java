package com.aman.user.biz.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 测试用例
 *
 * @author caoxiang
 * @since 2020-06-02
 */
@RestController
public class TestFeignController {
    @GetMapping("/feign1")
    public String feignDemo1() {
        return "get class feignDemo1 success!;";
    }
}
