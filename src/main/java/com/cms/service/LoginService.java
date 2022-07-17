package com.cms.service;

import com.cms.pojo.ResponseResult;
import com.cms.pojo.User;

public interface LoginService {
    ResponseResult login(User user);

    ResponseResult logout();
}
