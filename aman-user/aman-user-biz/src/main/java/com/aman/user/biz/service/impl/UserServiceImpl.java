package com.aman.user.biz.service.impl;

import com.aman.user.biz.entity.User;
import com.aman.user.biz.mapper.UserMapper;
import com.aman.user.biz.service.UserService;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 测试用例
 *
 * @author caoxiang
 * @since 2020-06-02
 */
@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements UserService {

    @Override
    public List<User> mySelectAll() {
        return baseMapper.mySelectAll();
    }

    @Override
    public IPage<User> mySelectAllByPage(Page page) {
        return baseMapper.mySelectAllByPage(page);
    }
}
