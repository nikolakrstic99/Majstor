create table service_image
(
    id bigint primary key AUTO_INCREMENT not null,
    image_data mediumblob not null,
    service_id bigint
);

create table service
(
    id bigint primary key AUTO_INCREMENT not null,
    l1Category varchar(255) not null,
    l2Category varchar(255) not null,
    description     varchar(1000) not null,
    user_id     bigint        ,
    constraint fk_service_user_id
        foreign key (user_id) references users (id)
);