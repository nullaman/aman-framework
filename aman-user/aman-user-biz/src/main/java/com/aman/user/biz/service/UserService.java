package com.aman.user.biz.service;

import com.aman.user.biz.entity.User;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;

/**
 * 测试用例
 *
 * @author caoxiang
 * @since 2020-06-02
 */
public interface UserService extends IService<User> {
    List<User> mySelectAll();

    IPage<User> mySelectAllByPage(Page page);
}
