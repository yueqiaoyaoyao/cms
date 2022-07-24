package com.cms.pojo.entity;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
@TableName("cms_user")
public class User implements Serializable {
    private static final long serialVersionUID = -4583923676602987684L;
    @TableId
    private int uid;
    private String userName;
    private String nickName;
    private String password;
    private String status;
    private String userType;
    private String sex;
    private String avatar;
    private String phone;
    private String email;
    private String address;
    private Date created;
    private Date updated;
    private String delFlag;
    private String remark;

}
