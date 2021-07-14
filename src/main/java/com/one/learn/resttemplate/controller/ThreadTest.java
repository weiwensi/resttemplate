package com.one.learn.resttemplate.controller;

import com.one.learn.resttemplate.service.ThreadService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ThreadTest {
    @Autowired
    private ThreadService threadService;

    @GetMapping("testThread")
    public String test1() {
        threadService.threadDemo();
        return "ok";
    }
}
