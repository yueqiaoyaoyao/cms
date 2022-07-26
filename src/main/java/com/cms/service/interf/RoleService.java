package com.cms.service.interf;

import com.cms.pojo.entity.Authorize;
import com.cms.pojo.utils.ResponseResult;

public interface RoleService {
    ResponseResult find();

    ResponseResult auth(Authorize authorize);
}
