drop table if exists master;

create table master (
                        id bigint not null,
                        name varchar(255)
);

alter table master
    add constraint master_pkey primary key (id);