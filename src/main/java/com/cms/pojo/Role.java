package com.cms.pojo;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
@TableName("cms_role")
public class Role {
    @TableId
    private int rid;
    private String roleName;
    private String authorities;
    private String status;
    private Date created;
    private Date updated;
    private String delFlag;
    private String remark;
}
