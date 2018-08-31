
CREATE DATABASE vsdb;

USE vsdb;

select * from ReceptionCenter;
select * from Location;
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