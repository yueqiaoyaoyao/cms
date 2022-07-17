package com.cms.service.Impl;

import com.cms.mapper.UserMapper;
import com.cms.pojo.User;
import com.cms.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
@Slf4j
public class UserServiceImpl implements UserService {

    @Resource
    private UserMapper userMapper;

    @Override
    public User findByUid(int aid) {
        return userMapper.selectById(aid);
    }


}
