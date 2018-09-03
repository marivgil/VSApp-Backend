

CREATE DATABASE vsdb;

USE vsdb;

select * from ReceptionCenter;
select * from Location;
select * from User;


create table User (
mail varchar(255) not null, 
name varchar(255), 
surname varchar(255), 
location varchar(255), 
phone varchar(255), 
profile tinyblob, 
area tinyblob, 
primary key (mail));

insert User 
values 
('gil.maricruz@gmail.com', 'Maricruz','Gil','Wilde', '42065201', ADMIN,SEDE);


insert 
ReceptionCenter 
values
(1, 'Maricruz', 'Gil', 'wilde', '4251-2748');
commit;

insert 
Location
values
(1, 'wilde', 1),
(1, 'Avellaneda', 2),
(1, 'Don Bosco', 3);