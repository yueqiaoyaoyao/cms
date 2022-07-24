package com.cms.service.interf;

import com.cms.pojo.entity.User;

public interface UserService {
    User findByUid(int uid);
}
