package com.cms.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.cms.pojo.entity.Menu;

import java.util.List;
import java.util.Map;
import java.util.Set;

public interface MenuMapper extends BaseMapper<Menu> {
    List<String> selectPermsByUserUid(int uid);
    Set<String> selectPathsByUserUid(int uid);
    List<Menu> selectAuthsByUserUid(int uid);
}
