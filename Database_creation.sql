drop database test_task;
create database test_task;
use test_task;
create table users(
	name varchar(30) not null,
    login varchar(30) not null,
    password varchar(30) not null,
    primary key (login)
);

create table roles(
	id int auto_increment,
    name varchar(30),
    primary key(id)
);

create table user_role(
	login varchar(30),
    id_role int,
    foreign key (login) references users(login),
    foreign key (id_role) references roles(id)
);
