package com.one.learn.resttemplate.controller;

import com.one.learn.resttemplate.util.RedisUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Slf4j
public class RedisController {

    @Autowired
    private RedisUtil redisUtil;

    @GetMapping("/testDistributedLock")
    public String testSetIfNotExists(@RequestParam("name") String name,
                                     @RequestParam("value") int age){
        log.info("******testSetIfNotExists******");

        int time = 10;//超时时间写死为10秒
        String ageStr = String.valueOf(age);
        String s = redisUtil.getDistributedLock(name, ageStr, time);

        log.info("******s是否为null:" + (s == null));
        log.info("******s=" + s);

        return s;
    }
}