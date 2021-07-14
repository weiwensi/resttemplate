package com.one.learn.resttemplate.service;

import java.util.List;

public interface UserService {
    void insert();

    String getUserJobDtoByUserId(Integer id);

    List pageQuery(Integer pageNo, Integer pageSize);


    String   testTran();
}
