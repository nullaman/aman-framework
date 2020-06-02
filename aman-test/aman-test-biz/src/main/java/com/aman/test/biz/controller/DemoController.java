package com.aman.test.biz.controller;

import com.aman.test.biz.entity.Demo;
import com.aman.user.api.UserFeignProxy;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 测试用例
 *
 * @author caoxiang
 * @since 2020-06-02
 */
@RestController
@Slf4j
@AllArgsConstructor
public class DemoController {

    //    @Autowired
    private final UserFeignProxy testFeignProxy;

    @GetMapping("/demo")
    public String Demo() {
        Demo demo = new Demo();
        demo.setAge("2341234123");
        log.info(">>>>>>>>>>>>> : " + demo.getAge());
        return "ccccccccccccccccccc231423" + demo.getAge();
    }

    @GetMapping("/demo2")
    public String TestGetFeign() {
        String content = testFeignProxy.feignDemo1();
        log.info(">>>>>>>>> TestGetFeign running ... you are " + content);
        return "payment do feign ------->>>" + content;
    }
}
