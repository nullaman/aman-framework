package com.aman.user.api;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;


/**
 * 测试用例
 *
 * <p>
 * 远程调用
 * </p>
 *
 * @author caoxiang
 * @since 2020-06-02
 */
@FeignClient(contextId = "userFeignProxy", value = "aman-user-biz")
public interface UserFeignProxy {
    @GetMapping("/feign1")
    String feignDemo1();
}