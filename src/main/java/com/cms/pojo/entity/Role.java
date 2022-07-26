package com.cms.pojo.entity;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableLogic;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
@TableName("cms_role")
public class Role implements Serializable {
    private static final long serialVersionUID = -6326489691963700467L;
    @TableId
    private int rid;
    private String roleName;
    private String authorities;
    private String status;
    private Date created;
    private Date updated;
    @TableLogic
    private String delFlag;
    private String remark;
}
