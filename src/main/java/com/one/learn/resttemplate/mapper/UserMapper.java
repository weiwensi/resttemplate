package com.one.learn.resttemplate.mapper;

import com.one.learn.resttemplate.bean.User;
import com.one.learn.resttemplate.bean.UserJobDto;
import org.apache.ibatis.session.RowBounds;

import java.util.List;
import java.util.Map;

public interface UserMapper {
    void insert(User user);

    UserJobDto getUserJobDtoByUserId(Integer  id);

    int queryCountUser();

    /**
     * 分页获取用户信息
     * @param rowbounds
     * @return
     */
    List<Map<String, Object>> queryUserList(RowBounds rowbounds);
}
