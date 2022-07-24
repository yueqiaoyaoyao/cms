package com.cms.pojo.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import com.github.jeffreyning.mybatisplus.anno.MppMultiId;

import java.io.Serializable;

@Data
@AllArgsConstructor
@NoArgsConstructor
@TableName("cms_user_role")
public class Authorize implements Serializable {
    private static final long serialVersionUID = -7021059299202750640L;
    @MppMultiId
    private int uid;
    @MppMultiId
    private int rid;
}
