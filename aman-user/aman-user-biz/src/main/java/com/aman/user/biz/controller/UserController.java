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

import java.util.List;

/**
 * 测试用例
 *
 * @author caoxiang
 * @since 2020-06-02
 */
@RestController
@RequestMapping("/user")
@AllArgsConstructor
@Slf4j
public class UserController {

    private final UserService userService;

//    private final UserMapper userMapper;

    @GetMapping("/list")
    public Object selectUserList() {
//        List<User> list = userService.list();
//        Object userList = JSON.toJSONString(list);
//        log.info(">>>>>>>>>>>> userList:" + userList);

        List<User> users = userService.MySelectAll();
        Object userList = JSON.toJSONString(users);
        log.info(">>>>>>>>>>>> userList:" + userList);
        return userList;

    }


    @GetMapping("/list/page")
    public Object selectUserListByPage(Page page) {
//        List<User> list = userService.list();
//        Object userList = JSON.toJSONString(list);
//        log.info(">>>>>>>>>>>> userList:" + userList);
        log.info(">>>>>>>>>> Page ,: " + JSON.toJSONString(page));

        IPage<User> users = userService.MySelectAllByPage(page);
        Object userList = JSON.toJSONString(users);
        log.info(">>>>>>>>>>>> userList:" + userList);
        return userList;

    }


    @GetMapping("/save/{name}")
    public Boolean saveUser(@PathVariable String name) {
        log.info(">>>>>>>>>>>>>>>>>>> : name : {}", name);
        User user = new User();
//        user.setId(34);
        user.setAge(22);
        user.setName(name);
//        user.setVersion(20);
        user.setEmail("41565@qq.com");
        boolean save = userService.save(user);
        log.info(">>>>>>>>> save : {} , Id={} ,version={}", save, user.getId(), user.getVersion());
        return save;
    }

    @GetMapping("/del/{name}")
    public Boolean delUser(@PathVariable String name) {
        boolean remove = userService.remove(Wrappers.<User>query().lambda().eq(User::getName, name));
        log.info(">>>>>>>>> remove : {}", remove);
        return remove;
    }

    @GetMapping("/update/{id}/{name}")
    public String updateUser(@PathVariable Integer id, @PathVariable String name) {
        User leguan = userService.getById(id);
        leguan.setName(name);
        log.info(">>>>>>>>>>> update->leguan =" + JSON.toJSONString(leguan));
        boolean update = userService.updateById(leguan);
        log.info(">>>>>>>>>>> update->leguan =" + leguan.getVersion());

        User user = new User();
        user.setId(id);
        user.setName(name);
        boolean b = userService.updateById(user);
        log.info(">>>>>>>>>>> update->user =" + user.getVersion());

        return "乐观：" + update + ", 直接：" + b;
    }

}
