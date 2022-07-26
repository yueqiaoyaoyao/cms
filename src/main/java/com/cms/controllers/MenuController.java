package com.cms.controllers;

import com.cms.pojo.utils.ResponseResult;
import com.cms.service.Impl.MenuServiceImpl;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/menu")
@Api("菜单管理")
public class MenuController {

    @Autowired
    private MenuServiceImpl menuService;

    @PostMapping("/Jump")
    public ResponseResult Jump(@RequestBody String to){
        return menuService.Jump(to);
    }

    @GetMapping("/auths")
    public ResponseResult getAuths(){
        return menuService.getAuths();
    }

}
