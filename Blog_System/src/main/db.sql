create database blog_system charset utf8;

use blog_system;
create table blog(
    blogId int primary key auto_increment,
    title varchar(1024),
    content varchar(4096),
    postTime datetime,
    userId int
);

create table user(
    userId int primary key ,
    username varchar(50) unique,
    password varchar(50)
);

--插入数据测试--
insert into blog values (1,'这是第一篇博客','从今天开始我要认真写代码',now(),1);
insert into blog values (2,'这是第二篇博客','从昨天开始我要认真写代码',now(),1);
insert into blog values (3,'这是第三篇博客','从前天开始我要认真写代码',now(),1);
insert into user values(1,'zhangsan','123');
insert into user values(2,'lisi','123');