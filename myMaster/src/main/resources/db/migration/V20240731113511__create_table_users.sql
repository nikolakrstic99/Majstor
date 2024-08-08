drop table if exists users;

create table users (
    id bigint primary key AUTO_INCREMENT not null,
    first_name varchar(255) not null,
    last_name varchar(255) not null,
    email varchar(255) not null,
    password varchar(255) not null
);
