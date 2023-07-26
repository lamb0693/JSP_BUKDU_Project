drop table member;

create table member(
	id varchar(20) primary key,
    name varchar(20) not null,
    password varchar(255) not null,
    isadmin boolean default false,
    tel varchar(20),
    join_at timestamp default now()
);
