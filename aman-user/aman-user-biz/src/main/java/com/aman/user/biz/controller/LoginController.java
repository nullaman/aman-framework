package com.aman.user.biz.controller;

import com.alibaba.fastjson.JSON;
import com.aman.user.biz.entity.User;
import com.aman.user.biz.service.UserService;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.List;

/**
 * 测试用例
 *
 * @author caoxiang
 * @since 2020-06-02
 */
@RestController
@RequestMapping("/login")
@AllArgsConstructor
@Slf4j
public class LoginController {

    private final UserService userService;

    @GetMapping("/getToken/{userId}")
    public Object selectUserList(@PathVariable Integer userId) {
        log.info("getToken success userId ：{} ", userId);
        User byId = userService.getById(userId);
        HashMap hashMap = JSON.parseObject(JSON.toJSONString(byId), HashMap.class);
        hashMap.put("userId", byId.getId());
        return hashMap;
    }

}
