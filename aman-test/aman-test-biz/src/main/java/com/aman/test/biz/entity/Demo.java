package com.aman.test.biz.entity;

import lombok.Data;

import java.io.Serializable;


/**
 * 测试用例
 *
 * @author caoxiang
 * @since 2020-06-02
 */
@Data
public class Demo implements Serializable {
    private String name;
    private String age;
    private String sex;
}
