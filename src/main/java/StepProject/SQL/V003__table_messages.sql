create table messages(
id bigserial primary key,
sender varchar(255), receiver varchar(255),
message varchar(600), time varchar(60));