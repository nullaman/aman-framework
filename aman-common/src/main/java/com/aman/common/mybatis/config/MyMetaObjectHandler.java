package com.aman.common.mybatis.config;

import com.baomidou.mybatisplus.core.handlers.MetaObjectHandler;
import lombok.extern.slf4j.Slf4j;
import org.apache.ibatis.reflection.MetaObject;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;

/**
 * sql 拦截
 *
 * @author caoxiang
 * @since 2020-06-02
 */
@Component
@Slf4j
public class MyMetaObjectHandler implements MetaObjectHandler {

    /**
     * 插入拦截
     *
     * @param metaObject
     * @author caoxiang
     * @date 2020-01-29
     */
    @Override
    public void insertFill(MetaObject metaObject) {
        log.info("start insert fill...开始插入填充...@createTime, @version, @delFlag");

        // 起始版本 3.3.0(推荐使用)
        this.strictInsertFill(metaObject, "createTime", LocalDateTime.class, LocalDateTime.now());
        // 起始版本 3.3.0(推荐使用)
        this.strictInsertFill(metaObject, "version", Integer.class, 1);
        // 起始版本 3.3.0(推荐使用)
        this.strictInsertFill(metaObject, "delFlag", Integer.class, 0);

        /* 上面选其一使用,下面的已过时(注意 strictInsertFill 有多个方法,详细查看源码) */
        //this.setFieldValByName("operator", "Jerry", metaObject);
        //this.setInsertFieldValByName("operator", "Jerry", metaObject);
    }

    /**
     * 修改拦截
     *
     * @param metaObject
     * @author caoxiang
     * @date 2020-01-29
     */
    @Override
    public void updateFill(MetaObject metaObject) {
        log.info("start update fill...开始修改填充...@updateTime");

        // 起始版本 3.3.0(推荐使用)
        this.strictInsertFill(metaObject, "updateTime", LocalDateTime.class, LocalDateTime.now());

//        this.fillStrategy(metaObject, "updateTime", LocalDateTime.now()); // 也可以使用(3.3.0 该方法有bug请升级到之后的版本如`3.3.1.8-SNAPSHOT`)
        /* 上面选其一使用,下面的已过时(注意 strictUpdateFill 有多个方法,详细查看源码) */
        //this.setFieldValByName("operator", "Tom", metaObject);
        //this.setUpdateFieldValByName("operator", "Tom", metaObject);
    }

}
