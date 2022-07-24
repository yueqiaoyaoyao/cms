package com.cms.pojo.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import com.github.jeffreyning.mybatisplus.anno.MppMultiId;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@AllArgsConstructor
@NoArgsConstructor
@TableName("cms_role_menu")
public class RoleMenu implements Serializable {
    private static final long serialVersionUID = -3485372716853602512L;
    @MppMultiId
    private int rid;
    @MppMultiId
    private int mid;
}
