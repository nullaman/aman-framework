package com.aman.user.biz.entity;

import com.aman.common.entity.BaseEntity;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * 测试用例
 *
 * @author caoxiang
 * @since 2020-06-02
 */
@Data
@EqualsAndHashCode(callSuper = true)
public class User extends BaseEntity<User> {

    private String name;

    private Integer age;

    private String email;

}
