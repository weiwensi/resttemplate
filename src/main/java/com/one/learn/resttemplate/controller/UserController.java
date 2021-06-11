package com.one.learn.resttemplate.controller;

import com.one.learn.resttemplate.bean.GetParam;
import com.one.learn.resttemplate.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("user")
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping("insert")
    @ResponseBody
    public String index() {

        userService.insert();

        return "hello spring boot";
    }

    @PostMapping("getUserJobDtoByUserId")
    public String getUserJobDtoByUserId(GetParam param) {
        System.out.println("进入了Controller，参数"+param.getId());
        return userService.getUserJobDtoByUserId(param.getId());
    }

    @GetMapping("pageQuery")
    public List pageQuery(@RequestParam Integer pageNo, @RequestParam Integer pageSize) {
        return userService.pageQuery(pageNo, pageSize);

    }
}