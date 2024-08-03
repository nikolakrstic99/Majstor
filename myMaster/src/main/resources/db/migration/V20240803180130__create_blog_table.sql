drop table if exists blog;

create table blog
(
    id          bigint primary key AUTO_INCREMENT not null,
    heading     varchar(255)  not null,
    sub_heading varchar(255)  not null,
    details     varchar(1000) not null,
    created_at  timestamp     not null default now(),
    user_id     bigint        not null,
    constraint fk_blog_user_id
        foreign key (user_id) references users (id)
);