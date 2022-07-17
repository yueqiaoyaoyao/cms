package com.cms.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.cms.pojo.Menu;

import java.util.List;

public interface MenuMapper extends BaseMapper<Menu> {
    List<String> selectPermsByUserUid(int uid);
}
