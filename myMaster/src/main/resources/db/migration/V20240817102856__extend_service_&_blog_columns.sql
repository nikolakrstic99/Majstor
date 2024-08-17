alter table blog drop column heading;
alter table blog add column heading varchar(5000) not null;

alter table blog drop column sub_heading;
alter table blog add column sub_heading varchar(5000) not null;

alter table blog drop column details;
alter table blog add column details varchar(5000) not null;

alter table service drop column description;
alter table service add column description varchar(5000) not null;