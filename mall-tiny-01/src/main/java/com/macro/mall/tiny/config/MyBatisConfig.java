package com.macro.mall.tiny.config;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Configurable;

/*
* MyBatis配置类
* */
@Configurable
@MapperScan("com.macro.mall.tiny.mbg.mapper")
public class MyBatisConfig {
}
