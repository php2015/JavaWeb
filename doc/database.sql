drop database if exists `javaweb`;
create database `javaweb`;
use `javaweb`;

set foreign_key_checks = 0;

drop table if exists `sys_ad`;

create table `sys_ad`(
    `id` int(11) primary key auto_increment,
    `create_user` int(11),
    `create_time` timestamp,
    `update_user` int(11),
    `update_time` timestamp,
    `mark` int(11),
    `title` varchar(64),
    `sort_id` int(11),
    `cover` varchar(64),
    `type` int(11),
    `description` varchar(64),
    `content` varchar(64),
    `url` varchar(64),
    `width` int(11),
    `height` int(11),
    `start_time` timestamp,
    `end_time` timestamp,
    `view_num` int(11),
    `status` int(11),
    `sort` int(11)
);

drop table if exists `sys_admin`;

create table `sys_admin`(
    `id` int(11) primary key auto_increment,
    `realname` varchar(64),
    `nickname` varchar(64),
    `gender` int(11),
    `avatar` varchar(64),
    `mobile` varchar(64),
    `email` varchar(64),
    `birthday` timestamp,
    `company_id` int(11),
    `dept_id` int(11),
    `level_id` int(11),
    `position_id` int(11),
    `province_id` int(11),
    `city_id` int(11),
    `district_id` int(11),
    `address` varchar(64),
    `username` varchar(64),
    `password` varchar(64),
    `salt` varchar(64),
    `tags` varchar(64),
    `intro` varchar(64),
    `status` int(11),
    `rules` varchar(64),
    `role_ids` varchar(64),
    `note` varchar(64),
    `sort` int(11),
    `login_num` int(11),
    `login_ip` varchar(64),
    `login_time` timestamp,
    `create_user` int(11),
    `create_time` timestamp,
    `update_user` int(11),
    `update_time` timestamp,
    `mark` int(11)
);

insert into sys_admin(`realname`, `nickname`, `gender`, `avatar`, `mobile`, `email`, `birthday`, `company_id`, `dept_id`, `level_id`, `position_id`, `province_id`, `city_id`, `district_id`, `address`, `username`, `password`, `salt`, `tags`, `intro`, `status`, `rules`, `role_ids`, `note`,  `sort`, `login_num`, `login_ip`, `login_time`, `create_user`, `create_time`, `update_user`, `update_time`, `mark`) values('Kestrel', 'Kestrel', 1, 'static/assets/images/kda.jpg', '12345678901', '123456@gmail.com', now(), 1, 1, 1, 1, 1, 1, 1, 'earth', 'admin', 'ddd056e3116ef3c8972a11c62a770a31', '', '', '', 1, '', '', '', 1, 0, '', now(), 1, now(), 1, now(), 1);

drop table if exists `sys_admin_role`;

create table `sys_admin_role`(
    `id` int(11) primary key auto_increment,
    `create_user` int(11),
    `create_time` timestamp,
    `update_user` int(11),
    `update_time` timestamp,
    `mark` int(11),
    `admin_id` int(11),
    `role_id` int(11)
);

drop table if exists `sys_ad_sort`;

create table `sys_ad_sort`(
    `id` int(11) primary key auto_increment,
    `create_user` int(11),
    `create_time` timestamp,
    `update_user` int(11),
    `update_time` timestamp,
    `mark` int(11),
    `name` varchar(64),
    `note` varchar(64),
    `item_id` int(11),
    `cate_id` int(11),
    `loc_id` int(11),
    `platform` int(11),
    `sort` int(11)
);

drop table if exists `sys_city`;

create table `sys_city`(
    `id` int(11) primary key auto_increment,
    `create_user` int(11),
    `create_time` timestamp,
    `update_user` int(11),
    `update_time` timestamp,
    `mark` int(11),
    `name` varchar(64),
    `level` int(11),
    `pid` int(11),
    `citycode` varchar(64),
    `p_Adcode` varchar(64),
    `adcode` varchar(64),
    `lng` int(11),
    `lat` int(11),
    `sort` int(11)
);

drop table if exists `sys_config`;

create table `sys_config`(
    `id` int(11) primary key auto_increment,
    `create_user` int(11),
    `create_time` timestamp,
    `update_user` int(11),
    `update_time` timestamp,
    `mark` int(11),
    `title` varchar(64),
    `tag` varchar(64),
    `value` varchar(64),
    `options` varchar(64),
    `group_id` int(11),
    `type` varchar(64),
    `status` int(11),
    `sort` int(11),
    `note` varchar(64)
);

drop table if exists `sys_config_group`;

create table `sys_config_group`(
    `id` int(11) primary key auto_increment,
    `create_user` int(11),
    `create_time` timestamp,
    `update_user` int(11),
    `update_time` timestamp,
    `mark` int(11),
    `name` varchar(64),
    `sort` int(11)
);

drop table if exists `sys_crontab`;

create table `sys_crontab`(
    `id` int(11) primary key auto_increment,
    `create_user` int(11),
    `create_time` timestamp,
    `update_user` int(11),
    `update_time` timestamp,
    `mark` int(11),
    `title` varchar(64),
    `cron` varchar(64),
    `delay` int(11),
    `fixed` int(11),
    `execute` int(11),
    `status` int(11),
    `note` varchar(64)
);

drop table if exists `sys_dep`;

create table `sys_dep`(
    `id` int(11) primary key auto_increment,
    `create_user` int(11),
    `create_time` timestamp,
    `update_user` int(11),
    `update_time` timestamp,
    `mark` int(11),
    `name` varchar(64),
    `pid` int(11),
    `type` int(11),
    `has_child` int(11),
    `sort` int(11)
);

drop table if exists `sys_dic`;

create table `sys_dic`(
    `id` int(11) primary key auto_increment,
    `create_user` int(11),
    `create_time` timestamp,
    `update_user` int(11),
    `update_time` timestamp,
    `mark` int(11),
    `title` varchar(64),
    `tag` varchar(64),
    `value` varchar(64),
    `type_id` int(11),
    `status` int(11),
    `note` varchar(64),
    `sort` int(11)
);

drop table if exists `sys_dic_type`;

create table `sys_dic_type`(
    `id` int(11) primary key auto_increment,
    `create_user` int(11),
    `create_time` timestamp,
    `update_user` int(11),
    `update_time` timestamp,
    `mark` int(11),
    `name` varchar(64),
    `tag` varchar(64),
    `sort` int(11)
);

drop table if exists `sys_item`;

create table `sys_item`(
    `id` int(11) primary key auto_increment,
    `create_user` int(11),
    `create_time` timestamp,
    `update_user` int(11),
    `update_time` timestamp,
    `mark` int(11),
    `name` varchar(64),
    `type` int(11),
    `url` varchar(64),
    `image` varchar(64),
    `is_domain` int(11),
    `status` int(11),
    `note` varchar(64),
    `sort` int(11)
);

drop table if exists `sys_item_cate`;

create table `sys_item_cate`(
    `id` int(11) primary key auto_increment,
    `create_user` int(11),
    `create_time` timestamp,
    `update_user` int(11),
    `update_time` timestamp,
    `mark` int(11),
    `name` varchar(64),
    `pid` int(11),
    `item_id` int(11),
    `pinyin` varchar(64),
    `code` varchar(64),
    `is_cover` int(11),
    `cover` varchar(64),
    `status` int(11),
    `note` varchar(64),
    `sort` int(11)
);

drop table if exists `sys_layout`;

create table `sys_layout`(
    `id` int(11) primary key auto_increment,
    `create_user` int(11),
    `create_time` timestamp,
    `update_user` int(11),
    `update_time` timestamp,
    `mark` int(11),
    `item_id` int(11),
    `loc_id` int(11),
    `type` int(11),
    `type_id` int(11),
    `image` varchar(64),
    `sort` int(11)
);

drop table if exists `sys_layout_desc`;

create table `sys_layout_desc`(
    `id` int(11) primary key auto_increment,
    `create_user` int(11),
    `create_time` timestamp,
    `update_user` int(11),
    `update_time` timestamp,
    `mark` int(11),
    `name` varchar(64),
    `item_id` int(11),
    `loc_id` int(11),
    `loc_desc` varchar(64),
    `sort` int(11)
);

drop table if exists `sys_level`;

create table `sys_level`(
    `id` int(11) primary key auto_increment,
    `create_user` int(11),
    `create_time` timestamp,
    `update_user` int(11),
    `update_time` timestamp,
    `mark` int(11),
    `name` varchar(64),
    `status` int(11),
    `sort` int(11)
);

drop table if exists `sys_link`;

create table `sys_link`(
    `id` int(11) primary key auto_increment,
    `create_user` int(11),
    `create_time` timestamp,
    `update_user` int(11),
    `update_time` timestamp,
    `mark` int(11),
    `name` varchar(64),
    `type` int(11),
    `url` varchar(64),
    `item_id` int(11),
    `cate_id` int(11),
    `platform` int(11),
    `form` int(11),
    `image` varchar(64),
    `status` int(11),
    `sort` int(11)
);

drop table if exists `sys_login_log`;

create table `sys_login_log`(
    `id` int(11) primary key auto_increment,
    `create_user` int(11),
    `create_time` timestamp,
    `update_user` int(11),
    `update_time` timestamp,
    `mark` int(11),
    `title` varchar(64),
    `login_name` varchar(64),
    `login_time` timestamp,
    `login_ip` varchar(64),
    `login_location` varchar(64),
    `browser` varchar(64),
    `os` varchar(64),
    `status` int(11),
    `type` int(11),
    `msg` varchar(64)
);

drop table if exists `sys_menu`;

create table `sys_menu`(
    `id` int(11) primary key auto_increment,
    `create_user` int(11),
    `create_time` timestamp,
    `update_user` int(11),
    `update_time` timestamp,
    `mark` int(11),
    `name` varchar(64),
    `icon` varchar(64),
    `url` varchar(64),
    `param` varchar(64),
    `pid` int(11),
    `type` int(11),
    `permission` varchar(64),
    `status` int(11),
    `is_public` int(11),
    `note` varchar(64),
    `sort` int(11)
);

insert into `sys_menu`(`create_user`, `create_time`, `update_user`, `update_time`, `mark`, `name`, `icon`, `url`, `param`, `pid`, `type`, `permission`, `status`, `is_public`, `note`, `sort`) values(1, now(), 1, now(), 1, '系统管理', '', '', '', 0, 3, '', 1, 1, '', 1);
insert into `sys_menu`(`create_user`, `create_time`, `update_user`, `update_time`, `mark`, `name`, `icon`, `url`, `param`, `pid`, `type`, `permission`, `status`, `is_public`, `note`, `sort`) values(1, now(), 1, now(), 1, '店铺管理', '', '', '', 0, 3, '', 1, 1, '', 2);
insert into `sys_menu`(`create_user`, `create_time`, `update_user`, `update_time`, `mark`, `name`, `icon`, `url`, `param`, `pid`, `type`, `permission`, `status`, `is_public`, `note`, `sort`) values(1, now(), 1, now(), 1, '商品管理', '', '', '', 0, 3, '', 1, 1, '', 3);
insert into `sys_menu`(`create_user`, `create_time`, `update_user`, `update_time`, `mark`, `name`, `icon`, `url`, `param`, `pid`, `type`, `permission`, `status`, `is_public`, `note`, `sort`) values(1, now(), 1, now(), 1, 'CMS管理', '', '', '', 0, 3, '', 1, 1, '', 4);
insert into `sys_menu`(`create_user`, `create_time`, `update_user`, `update_time`, `mark`, `name`, `icon`, `url`, `param`, `pid`, `type`, `permission`, `status`, `is_public`, `note`, `sort`) values(1, now(), 1, now(), 1, '用户中心', '', '', '', 0, 3, '', 1, 1, '', 5);

set @id = (select id from sys_menu where name='系统管理');
insert into `sys_menu`(`create_user`, `create_time`, `update_user`, `update_time`, `mark`, `name`, `icon`, `url`, `param`, `pid`, `type`, `permission`, `status`, `is_public`, `note`, `sort`) values(1, now(), 1, now(), 1, '权限管理', '', '', '', @id, 1, '', 1, 1, '', 1);
insert into `sys_menu`(`create_user`, `create_time`, `update_user`, `update_time`, `mark`, `name`, `icon`, `url`, `param`, `pid`, `type`, `permission`, `status`, `is_public`, `note`, `sort`) values(1, now(), 1, now(), 1, '站点管理', '', '', '', @id, 1, '', 1, 1, '', 2);
insert into `sys_menu`(`create_user`, `create_time`, `update_user`, `update_time`, `mark`, `name`, `icon`, `url`, `param`, `pid`, `type`, `permission`, `status`, `is_public`, `note`, `sort`) values(1, now(), 1, now(), 1, '广告管理', '', '', '', @id, 1, '', 1, 1, '', 3);
insert into `sys_menu`(`create_user`, `create_time`, `update_user`, `update_time`, `mark`, `name`, `icon`, `url`, `param`, `pid`, `type`, `permission`, `status`, `is_public`, `note`, `sort`) values(1, now(), 1, now(), 1, '布局管理', '', '', '', @id, 1, '', 1, 1, '', 4);
insert into `sys_menu`(`create_user`, `create_time`, `update_user`, `update_time`, `mark`, `name`, `icon`, `url`, `param`, `pid`, `type`, `permission`, `status`, `is_public`, `note`, `sort`) values(1, now(), 1, now(), 1, '配置管理', '', '', '', @id, 1, '', 1, 1, '', 5);
insert into `sys_menu`(`create_user`, `create_time`, `update_user`, `update_time`, `mark`, `name`, `icon`, `url`, `param`, `pid`, `type`, `permission`, `status`, `is_public`, `note`, `sort`) values(1, now(), 1, now(), 1, '字典管理', '', '', '', @id, 1, '', 1, 1, '', 6);
insert into `sys_menu`(`create_user`, `create_time`, `update_user`, `update_time`, `mark`, `name`, `icon`, `url`, `param`, `pid`, `type`, `permission`, `status`, `is_public`, `note`, `sort`) values(1, now(), 1, now(), 1, '消息管理', '', '', '', @id, 1, '', 1, 1, '', 7);
insert into `sys_menu`(`create_user`, `create_time`, `update_user`, `update_time`, `mark`, `name`, `icon`, `url`, `param`, `pid`, `type`, `permission`, `status`, `is_public`, `note`, `sort`) values(1, now(), 1, now(), 1, '应用中心', '', '', '', @id, 1, '', 1, 1, '', 8);
insert into `sys_menu`(`create_user`, `create_time`, `update_user`, `update_time`, `mark`, `name`, `icon`, `url`, `param`, `pid`, `type`, `permission`, `status`, `is_public`, `note`, `sort`) values(1, now(), 1, now(), 1, '系统工具', '', '', '', @id, 1, '', 1, 1, '', 9);

set @id = (select id from sys_menu where name='权限管理');
insert into `sys_menu`(`create_user`, `create_time`, `update_user`, `update_time`, `mark`, `name`, `icon`, `url`, `param`, `pid`, `type`, `permission`, `status`, `is_public`, `note`, `sort`) values(1, now(), 1, now(), 1, '人员管理', '', '/admin/index', '', @id, 4, '', 1, 1, '', 1);
insert into `sys_menu`(`create_user`, `create_time`, `update_user`, `update_time`, `mark`, `name`, `icon`, `url`, `param`, `pid`, `type`, `permission`, `status`, `is_public`, `note`, `sort`) values(1, now(), 1, now(), 1, '角色管理', '', '/role/index', '', @id, 4, '', 1, 1, '', 2);
insert into `sys_menu`(`create_user`, `create_time`, `update_user`, `update_time`, `mark`, `name`, `icon`, `url`, `param`, `pid`, `type`, `permission`, `status`, `is_public`, `note`, `sort`) values(1, now(), 1, now(), 1, '职级管理', '', '/level/index', '', @id, 4, '', 1, 1, '', 3);
insert into `sys_menu`(`create_user`, `create_time`, `update_user`, `update_time`, `mark`, `name`, `icon`, `url`, `param`, `pid`, `type`, `permission`, `status`, `is_public`, `note`, `sort`) values(1, now(), 1, now(), 1, '岗位管理', '', '/position/index', '', @id, 4, '', 1, 1, '', 4);
insert into `sys_menu`(`create_user`, `create_time`, `update_user`, `update_time`, `mark`, `name`, `icon`, `url`, `param`, `pid`, `type`, `permission`, `status`, `is_public`, `note`, `sort`) values(1, now(), 1, now(), 1, '部门管理', '', '/dep/index', '', @id, 4, '', 1, 1, '', 5);
insert into `sys_menu`(`create_user`, `create_time`, `update_user`, `update_time`, `mark`, `name`, `icon`, `url`, `param`, `pid`, `type`, `permission`, `status`, `is_public`, `note`, `sort`) values(1, now(), 1, now(), 1, '部门管理', '', '/menu/index', '', @id, 4, '', 1, 1, '', 6);
insert into `sys_menu`(`create_user`, `create_time`, `update_user`, `update_time`, `mark`, `name`, `icon`, `url`, `param`, `pid`, `type`, `permission`, `status`, `is_public`, `note`, `sort`) values(1, now(), 1, now(), 1, '操作日志', '', '/operlog/index', '', @id, 4, '', 1, 1, '', 7);
insert into `sys_menu`(`create_user`, `create_time`, `update_user`, `update_time`, `mark`, `name`, `icon`, `url`, `param`, `pid`, `type`, `permission`, `status`, `is_public`, `note`, `sort`) values(1, now(), 1, now(), 1, '登录日志', '', '/loginlog/index', '', @id, 4, '', 1, 1, '', 8);

drop table if exists `sys_message`;

create table `sys_message`(
    `id` int(11) primary key auto_increment,
    `create_user` int(11),
    `create_time` timestamp,
    `update_user` int(11),
    `update_time` timestamp,
    `mark` int(11),
    `title` varchar(64),
    `content` varchar(64),
    `receiver` varchar(64),
    `type` int(11),
    `send_time` timestamp,
    `send_status` int(11),
    `send_num` int(11),
    `note` varchar(64)
);

drop table if exists `sys_message_template`;

create table `sys_message_template`(
    `id` int(11) primary key auto_increment,
    `create_user` int(11),
    `create_time` timestamp,
    `update_user` int(11),
    `update_time` timestamp,
    `mark` int(11),
    `code` varchar(64),
    `title` varchar(64),
    `type` int(11),
    `content` varchar(64),
    `status` int(11)
);

drop table if exists `sys_notice`;

create table `sys_notice`(
    `id` int(11) primary key auto_increment,
    `create_user` int(11),
    `create_time` timestamp,
    `update_user` int(11),
    `update_time` timestamp,
    `mark` int(11),
    `title` varchar(64),
    `content` varchar(64),
    `source` int(11),
    `is_top` int(11),
    `view_num` int(11),
    `status` int(11),
    `public_time` timestamp,
    `is_send` int(11),
    `send_time` timestamp
);

drop table if exists `sys_oper_log`;

create table `sys_oper_log`(
    `id` int(11) primary key auto_increment,
    `create_user` int(11),
    `create_time` timestamp,
    `update_user` int(11),
    `update_time` timestamp,
    `mark` int(11),
    `title` varchar(64),
    `business_type` int(11),
    `method` varchar(64),
    `request_method` varchar(64),
    `operator_type` int(11),
    `oper_name` varchar(64),
    `oper_url` varchar(64),
    `oper_ip` varchar(64),
    `oper_location` varchar(64),
    `oper_param` varchar(64),
    `json_result` varchar(64),
    `status` int(11),
    `error_msg` varchar(64)
);

drop table if exists `sys_position`;

create table `sys_position`(
    `id` int(11) primary key auto_increment,
    `create_user` int(11),
    `create_time` timestamp,
    `update_user` int(11),
    `update_time` timestamp,
    `mark` int(11),
    `name` varchar(64),
    `status` int(11),
    `sort` int(11)
);

drop table if exists `sys_role`;

create table `sys_role`(
    `id` int(11) primary key auto_increment,
    `create_user` int(11),
    `create_time` timestamp,
    `update_user` int(11),
    `update_time` timestamp,
    `mark` int(11),
    `name` varchar(64),
    `rules` varchar(64),
    `status` int(11),
    `sort` int(11)
);

drop table if exists `sys_role_dept`;

create table `sys_role_dept`(
    `id` int(11) primary key auto_increment,
    `create_user` int(11),
    `create_time` timestamp,
    `update_user` int(11),
    `update_time` timestamp,
    `mark` int(11),
    `role_id` int(11),
    `dept_id` int(11)
);

drop table if exists `sys_role_menu`;

create table `sys_role_menu`(
    `id` int(11) primary key auto_increment,
    `create_user` int(11),
    `create_time` timestamp,
    `update_user` int(11),
    `update_time` timestamp,
    `mark` int(11),
    `role_id` int(11),
    `menu_id` int(11)
);

set foreign_key_checks = 1;