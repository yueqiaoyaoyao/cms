package com.cms.pojo;

import com.baomidou.mybatisplus.annotation.TableName;
import com.github.jeffreyning.mybatisplus.anno.MppMultiId;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@TableName("cms_role_menu")
public class RoleMenu {
    @MppMultiId
    private int rid;
    @MppMultiId
    private int mid;
}
