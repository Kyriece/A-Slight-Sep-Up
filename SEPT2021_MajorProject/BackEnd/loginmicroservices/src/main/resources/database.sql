drop table if exists user;

create table user (
id int NOT NULL AUTO_INCREMENT,
account_enabled boolean not null, 
account_non_locked boolean not null, 
create_at timestamp, 
full_name varchar(255), 
lock_time timestamp,  
password varchar(19), 
update_at timestamp, 
username varchar(255) unique, 
userstatus varchar(255), 
primary key (id))