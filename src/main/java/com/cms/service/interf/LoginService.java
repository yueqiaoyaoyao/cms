package com.cms.service.interf;

import com.cms.pojo.utils.ResponseResult;
import com.cms.pojo.entity.User;

public interface LoginService {
    ResponseResult login(User user);

    ResponseResult logout();
}
