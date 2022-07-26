package com.cms.service.Impl;

import cn.hutool.core.util.StrUtil;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.cms.mapper.UserMapper;
import com.cms.pojo.entity.User;
import com.cms.pojo.utils.ResponseResult;
import com.cms.service.interf.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class UserServiceImpl implements UserService {

    @Autowired
    private UserMapper userMapper;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Override
    public ResponseResult<?> findPage(Integer pageNum, Integer pageSize, String search) {
        try {
            LambdaQueryWrapper<User> userWrapper = Wrappers.<User>lambdaQuery();
            if(StrUtil.isNotBlank(search)){
                userWrapper.like(User::getUserName,search);
            }
            Page<User> userPage = userMapper.selectPage(new Page<>(pageNum,pageSize), userWrapper);
            return new ResponseResult(200,"查询成功",userPage);
        } catch (Exception e) {
            return new ResponseResult(400,"查询失败");
        }
    }

    /**
     *
     * @param user
     * @return 新增结果
     */
    @Override
    public ResponseResult<?> createdUser(User user) {
        try {
            user.setPassword(passwordEncoder.encode(user.getPassword()));
            userMapper.insert(user);
            return new ResponseResult(200,"用户新增成功");
        }catch (Exception e){
            log.info("数据库插入错误");
            return new ResponseResult(400,"用户新增失败");
        }
    }

    @Override
    public ResponseResult<?> update(User user) {
        try {
            userMapper.updateById(user);
            return new ResponseResult(200,"更新成功");
        } catch (Exception e) {
            return new ResponseResult(201,"更新失败");
        }
    }

    @Override
    public ResponseResult<?> delete(int uid) {
        try {
            userMapper.deleteById(uid);
            return new ResponseResult(200,"删除成功");
        } catch (Exception e) {
            return new ResponseResult(201,"删除失败");
        }
    }

}
