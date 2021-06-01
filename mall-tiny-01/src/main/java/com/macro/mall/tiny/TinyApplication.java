package com.macro.mall.tiny;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@SpringBootApplication
@MapperScan(value = "com.macro.mall.tiny.mbg.mapper")
@EnableSwagger2
public class TinyApplication {

    public static void main(String[] args) {
        SpringApplication.run(TinyApplication.class, args);
    }

}
