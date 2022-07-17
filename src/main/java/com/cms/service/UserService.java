package com.cms.service;

import com.cms.pojo.User;

public interface UserService {
    User findByUid(int uid);
}
