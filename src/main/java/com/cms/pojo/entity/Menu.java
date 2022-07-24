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
@TableName("cms_menu")
public class Menu implements Serializable {
    private static final long serialVersionUID = -1663274841893342721L;
    @TableId
    private int mid;
    private String menuName;
    private String path;
    private String component;
    private String visible;
    private String status;
    private String perms;
    private String icon;
    private Date created;
    private Date updated;
    private String delFlag;
    private String remark;
}
