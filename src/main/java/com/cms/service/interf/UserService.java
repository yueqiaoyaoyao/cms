package com.cms.service.interf;

import com.cms.pojo.entity.User;
import com.cms.pojo.utils.ResponseResult;

public interface UserService {
    ResponseResult<?> findPage(Integer pageNum,
                            Integer pageSize,
                            String search);
    ResponseResult<?> createdUser(User user);

    ResponseResult<?> update(User user);

    ResponseResult<?> delete(int uid);
}
