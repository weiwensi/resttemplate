package com.one.learn.resttemplate.mapper;

import com.one.learn.resttemplate.bean.User;
import com.one.learn.resttemplate.bean.UserJobDto;

public interface UserMapper {
    void insert(User user);

    UserJobDto getUserJobDtoByUserId(Integer  id);

}
