drop table if exists master;

create table image
(
    id bigint primary key AUTO_INCREMENT not null,
    image_data blob not null,
    blog_id bigint,
    constraint fk_image_blog_id
        foreign key (blog_id) references blog (id)
);