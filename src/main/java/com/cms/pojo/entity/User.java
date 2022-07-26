package com.cms.pojo.entity;

import com.baomidou.mybatisplus.annotation.IdType;
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
@TableName("cms_user")
public class User implements Serializable {
    private static final long serialVersionUID = -6661282615140772297L;
    @TableId(type = IdType.AUTO)
    private Integer uid;
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
    @TableLogic
    private String delFlag;
    private String remark;

}
