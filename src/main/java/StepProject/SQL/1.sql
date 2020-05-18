create table users (
id bigserial primary key,
uname varchar(255) unique, pass varchar(255),
image varchar(500), name varchar(255), surname varchar(255));