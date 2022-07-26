package com.cms.controllers;

import com.cms.pojo.entity.Authorize;
import com.cms.pojo.utils.ResponseResult;
import com.cms.service.Impl.RoleServiceImpl;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/role")
@Api("角色管理")
public class RoleController {

    @Autowired
    private RoleServiceImpl roleService;

    @GetMapping("/find")
    public ResponseResult find(){
        return roleService.find();
    }

    @PostMapping("/auth")
    public ResponseResult auth(@RequestBody Authorize authorize){
        return roleService.auth(authorize);
    }

}
