package com.cms.controllers;

import com.cms.pojo.utils.ResponseResult;
import com.cms.pojo.entity.User;
import com.cms.service.Impl.LoginServiceImpl;
import io.swagger.annotations.Api;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/user")
@Slf4j
@Api("登录")
public class LoginController {

    @Autowired
    private LoginServiceImpl loginService;

    @PostMapping("/login")
    public ResponseResult login(@RequestBody User user) {
        return loginService.login(user);
    }

    @DeleteMapping("/logout")
    public ResponseResult logout() {
        return loginService.logout();
    }

    @GetMapping("/hello")
    @PreAuthorize("hasAuthority('user:hello')")
    public String login() {
        return "hello";
    }



}
