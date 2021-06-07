package com.one.learn.resttemplate.controller;

import com.one.learn.resttemplate.bean.GetParam;
import com.one.learn.resttemplate.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;


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
    public String getUserJobDtoByUserId(@RequestBody GetParam param) {
        return userService.getUserJobDtoByUserId(param.getId());
    }
}