```mysql
drop table if exists `cms_user`;
create table `cms_user`(
    `uid` int primary key auto_increment comment '主键',
    `user_name` varchar(64) not null unique comment '用户名',
    `nick_name` varchar(64) null comment '昵称',
    `password` varchar(64) not null comment '密码',
    `status` char(1) default '0' comment '账户状态(0正常 1停用)',
    `user_type` char(1) not null comment '用户类型(0管理员 1普通用户)',
    `sex` char(1) null comment '用户性别(0女 1男 2未知)',
    `avatar` varchar(128) null comment '头像',
    `phone` varchar(64) null comment '电话',
    `email` varchar(64) null comment '邮箱',
    `address` varchar(64) null comment '地址',
    `created` timestamp default current_timestamp comment '创建时间',
    `updated` timestamp default current_timestamp on update current_timestamp comment '更新时间',
    `del_flag` char(1) default '0' comment '删除标志(0未删除 1已删除)',
    `remark` varchar(500) default null comment '备注'
)engine=innodb auto_increment=0 default charset=utf8mb4 comment='管理员表';

drop table if exists `cms_menu`;
create table `cms_menu`(
	`mid` int primary key auto_increment comment '主键',
    `menu_name` varchar(64) not null comment '菜单名',
    `path` varchar(200) default null comment '路由地址',
    `component` varchar(225) default null comment '组件路径',
    `visible` char(1) default '0' comment '菜单状态(0显示 1隐藏)',
    `status` char(1) default '0' comment '菜单状态(0正常 1停用)',
    `perms` varchar(100) default null comment '权限标识',
    `icon` varchar(100) default '#' comment '菜单图标',
    `created` timestamp default current_timestamp comment '创建时间',
    `updated` timestamp default current_timestamp on update current_timestamp comment '更新时间',
    `del_flag` char(1) default '0' comment '删除标志(0未删除 1已删除)',
 	`remark` varchar(500) default null comment '备注'
)engine=innodb auto_increment=0 default charset=utf8mb4 comment='菜单表';

drop table if exists `cms_role`;
create table `cms_role`(
    `rid` int primary key auto_increment comment '主键',
    `role_name` varchar(64) not null unique comment '角色名称',
    `role_key` varchar(64) not null unique comment '角色权限',
    `status` char(1) default '0' comment '角色状态(0正常 1停用)',
    `created` timestamp default current_timestamp comment '创建时间',
    `updated` timestamp default current_timestamp on update current_timestamp comment '更新时间',
    `del_flag` char(1) default '0' comment '删除标志(0未删除 1已删除)',
    `remark` varchar(500) default null comment '备注'
)engine=innodb auto_increment=0 default charset=utf8mb4 comment='角色表';


drop table if exists `cms_user_role`;
create table `cms_user_role`(
    `uid` int not null comment '用户id',
    `rid` int not null comment '角色id',
    foreign key(`uid`) references `cms_user`(`uid`) on update cascade on delete cascade,
    foreign key(`rid`) references `cms_role`(`rid`) on update cascade on delete cascade,
    primary key (`uid`,`rid`)
)engine=innodb default charset=utf8mb4 comment='用户角色表';

drop table if exists `cms_role_menu`;
create table `cms_role_menu`(
    `rid` int not null comment '角色id',
    `mid` int not null comment '权限id',
    foreign key(`rid`) references `cms_role`(`rid`) on update cascade on delete cascade,
    foreign key(`mid`) references `cms_menu`(`mid`) on update cascade on delete cascade,
    primary key (`uid`,`rid`)
)engine=innodb default charset=utf8mb4 comment='角色权限表';

--查询权限--
SELECT distinct m.perms 
FROM cms.cms_user_role ur 
left join cms.cms_role r
on ur.rid = r.rid 
left join cms.cms_role_menu rm
on ur.rid = rm.rid
left join cms.cms_menu m
on rm.mid = m.mid
where uid = 1 and r.status = 0
```



