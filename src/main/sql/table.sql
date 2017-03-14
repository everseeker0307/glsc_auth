create table if not exists users(id bigint(11) not null auto_increment primary key, name varchar(16), password varchar(64), unique(name));

create table if not exists roles(id bigint(11) not null auto_increment primary key, name varchar(32), unique(name));

create table if not exists privileges(id bigint(11) not null auto_increment primary key, name varchar(32), unique(name));

create table if not exists users_roles(id bigint(11) not null auto_increment primary key, user_name varchar(16), role_name varchar(32), constraint foreign key(user_name) references users(name) on delete cascade on update cascade, constraint foreign key(role_name) references roles(name) on delete cascade on update cascade);
alter table users_roles add unique index (user_name, role_name);
create table if not exists roles_privileges(id bigint(11) not null auto_increment primary key, role_name varchar(32), privilege_name varchar(32), constraint foreign key(role_name) references roles(name) on delete cascade on update cascade, constraint foreign key(privilege_name) references privileges(name) on delete cascade on update cascade);
alter table roles_privileges add unique index (role_name, privilege_name);
create table if not exists users_privileges(id bigint(11) not null auto_increment primary key, user_name varchar(16), privilege_name varchar(32), constraint foreign key(user_name) references users(name) on delete cascade on update cascade, constraint foreign key(privilege_name) references privileges(name) on delete cascade on update cascade);
alter table users_privileges add unique index (user_name, privilege_name);

# insert into users(name, password) values('wh', '123'), ('zpp', '111'), ('xqq', 'a');
insert into roles(name) values('root'), ('software engineer'), ('securities analyst'), ('stock broker');
insert into privileges(name) values('co_news_r'), ('co_news_w'), ('it_w'), ('sec_report_r'), ('sec_report_w'), ('client_r'), ('client_w');

insert into users_roles(user_name, role_name) values('wh', 'software engineer'), ('zpp', 'root'), ('zpp', 'securities analyst'), ('xqq', 'stock broker');
insert into roles_privileges(role_name, privilege_name) values('root', 'co_news_r'), ('root', 'co_news_w'), ('root', 'sec_report_r'),
  ('software engineer', 'co_news_r'), ('software engineer', 'it_w'), ('software engineer', 'sec_report_r'), ('securities analyst', 'co_news_r'), ('securities analyst', 'sec_report_r'), ('securities analyst', 'sec_report_w'), ('stock broker', 'co_news_r'), ('stock broker', 'sec_report_r'), ('stock broker', 'client_r'), ('stock broker', 'client_w');
insert into users_privileges(user_name, privilege_name) values('wh', 'client_r');