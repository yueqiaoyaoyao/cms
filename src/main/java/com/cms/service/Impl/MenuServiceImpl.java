package com.cms.service.Impl;

import com.cms.mapper.MenuMapper;
import com.cms.pojo.entity.Menu;
import com.cms.pojo.utils.LoginUser;
import com.cms.pojo.utils.ResponseResult;
import com.cms.service.interf.MenuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Set;

@Service
public class MenuServiceImpl implements MenuService {

    @Autowired
    private MenuMapper menuMapper;

    @Override
    public ResponseResult Jump(String to) {
        UsernamePasswordAuthenticationToken authentication =
                (UsernamePasswordAuthenticationToken) SecurityContextHolder
                        .getContext().getAuthentication();
        LoginUser loginUser = (LoginUser) authentication.getPrincipal();
        int userid = loginUser.getUser().getUid();
        Set<String> set = menuMapper.selectPathsByUserUid(userid);
        if(set.contains(to))
            return new ResponseResult(200,"欢迎");
        else
            return new ResponseResult(400,"权限不足");
    }

    @Override
    public ResponseResult getAuths() {
        UsernamePasswordAuthenticationToken authentication =
                (UsernamePasswordAuthenticationToken) SecurityContextHolder
                        .getContext().getAuthentication();
        LoginUser loginUser = (LoginUser) authentication.getPrincipal();
        int userid = loginUser.getUser().getUid();
        List<Menu> list = menuMapper.selectAuthsByUserUid(userid);
        if (list.isEmpty()){
            Menu menu = new Menu();
            menu.setMid(1);
            menu.setMenuName("主页");
            menu.setPath("/home");
            menu.setIcon("House");
            list.add(menu);
        }
        return new ResponseResult(200,"权限信息查询成功",list);
    }

}
