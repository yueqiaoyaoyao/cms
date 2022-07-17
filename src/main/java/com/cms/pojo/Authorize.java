package com.cms.pojo;

import com.baomidou.mybatisplus.annotation.TableName;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import com.github.jeffreyning.mybatisplus.anno.MppMultiId;

@Data
@AllArgsConstructor
@NoArgsConstructor
@TableName("cms_user_role")
public class Authorize {
    @MppMultiId
    private int uid;
    @MppMultiId
    private int rid;
}
