package com.one.learn.resttemplate;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @author One
 */
@SpringBootApplication
@MapperScan("com.one.learn.resttemplate.mapper")//使用MapperScan批量扫描所有的Mapper接口；
public class ResttemplateApplication {

    public static void main(String[] args) {
        SpringApplication.run(ResttemplateApplication.class, args);
    }

}
