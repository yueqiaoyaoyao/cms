package com.cms.service.interf;

import com.cms.pojo.utils.ResponseResult;

public interface MenuService {
    ResponseResult Jump(String to);

    ResponseResult getAuths();
}
