package com.cms.controllers;

import com.cms.pojo.entity.User;
import com.cms.pojo.utils.ResponseResult;
import com.cms.service.Impl.UserServiceImpl;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

@RestController
@RequestMapping("/user")
@Api("用户管理")
public class UserController {

    @Resource
    private UserServiceImpl userService;

    @ApiOperation("新增用户")
    @PostMapping("/add")
    @PreAuthorize("hasAuthority('user')")
    public ResponseResult<?> createUser(@RequestBody User user){
        return userService.createdUser(user);
    }


    @ApiOperation("查询用户")
    @GetMapping("/find")
    @PreAuthorize("hasAuthority('user')")
    public ResponseResult<?> findPage(@RequestParam(defaultValue = "1") Integer pageNum,
                                      @RequestParam(defaultValue = "5") Integer pageSize,
                                      @RequestParam(defaultValue = "") String search){
        return userService.findPage(pageNum,pageSize,search);
    }

    @ApiOperation("修改用户")
    @PutMapping("/update")
    @PreAuthorize("hasAuthority('user')")
    public ResponseResult<?> update(@RequestBody User user){
        return userService.update(user);
    }



    @ApiOperation("删除用户")
    @DeleteMapping("/delete/{uid}")
    @PreAuthorize("hasAuthority('user')")
    public ResponseResult<?> delete(@PathVariable int uid){
        return userService.delete(uid);
    }

}
