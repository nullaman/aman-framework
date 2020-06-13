package com.aman.user.biz.mapper;

import com.aman.user.biz.entity.User;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;

import java.util.List;

/**
 * 测试用例
 *
 * @author caoxiang
 * @since 2020-06-02
 */
public interface UserMapper extends BaseMapper<User> {
    List<User> mySelectAll();

    IPage<User> mySelectAllByPage(Page page);
}
