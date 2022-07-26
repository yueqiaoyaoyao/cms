package com.cms.service.Impl;

import com.cms.mapper.AuthorizeMapper;
import com.cms.mapper.RoleMapper;
import com.cms.pojo.entity.Authorize;
import com.cms.pojo.utils.ResponseResult;
import com.cms.service.interf.RoleService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class RoleServiceImpl implements RoleService {

    @Autowired
    private RoleMapper roleMapper;

    @Autowired
    private AuthorizeMapper authorizeMapper;

    @Override
    public ResponseResult find() {
        try {
            return new ResponseResult(200,"查询成功",roleMapper.selectList(null));
        }catch (Exception e){
            log.info("查询所有角色错误");
            return new ResponseResult(400,"查询失败",null);
        }

    }

    @Override
    public ResponseResult auth(Authorize authorize) {
        try {
            authorizeMapper.save(authorize);
            return new ResponseResult(200,"授权成功");
        }catch (Exception e){
            log.info("授权错误");
            return new ResponseResult(400,"授权失败");
        }
    }

}
