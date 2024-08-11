drop table if exists master;

create table blog_image
(
    id bigint primary key AUTO_INCREMENT not null,
    image_data blob not null,
    blog_id bigint
);