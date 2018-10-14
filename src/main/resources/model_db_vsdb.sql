

CREATE DATABASE vsdb;

USE vsdb;

select * from ReceptionCenter;
select * from Location;
select * from User;
select * from Request;
select * from Clothes;
select * from HospitalProduct;
select * from Hospital;
select * from Round;
select * from WeeklyRound;

insert Round
values
('1', 'Mitre', ''),
('2', 'Houssay', ''),
('3', 'Colon', ''),
('4', 'Yrigoyen', ''),
('5', 'Corrientes', ''),
('6', 'Belgrano', ''),
('7', 'Boedo', ''),
('8', 'San José', ''),
('9', 'Callao', ''),
('10', 'Lima', ''),
('11', 'Alem', ''),
('13', 'Rivadavia', ''),
('B1', 'Base Once', ''),
('B2', 'Base Ramos', ''),
('B4', 'Base Constitución', ''),
('B5', 'Base Obelisco', ''),
('B6', 'Base Miserere', '');

insert Hospital
values
('Posadas', 'Avenida Presidente Arturo U. Illia s/n y Marconi Morón, B1684 El Palomar, Pcia de Buenos Aires', ''),
('Durand', 'Av. Díaz Vélez 5044, C1405DCS CABA', ''),
('Santojanni', 'Pilar 950, Buenos Aires', ''),
('Rivadavia', 'Av. Gral. Las Heras 2670, C1425ASQ CABA', '');


insert User 
values 
('gil.maricruz@gmail.com', 'Mari','Gil','Wilde', '42065201', null, null),
('mari_2748@yahoo.com.ar', 'Cruz','Gil','Avellaneda', '42065201', null, null);

## solo CABA
insert ReceptionCenter 
values
(1,'Romina','Dorza','Caballito','1150365264'),
(2,'Graciela','Nuno','Lugano','1161715621'),
(3,'Giselle','Estrada','Villa del Parque','1157637758'),
(4,'Vanesa','Pajon','Villa Pueyrredon','1162140409'),
(5,'Evelyn','Silva','Paternal','1139042583'),
(6,'Mariana','Astraldi','Villa Crespo','1140573270'),
(7,'Mariana','Parra','Villa Devoto','1151215055'),
(8,'Marcela','Luccarini','Saavedra','1132641824'),
(9,'Viviana','Massara','Liniers','1160223205'),
(10,'María de los Angeles','','Monte Castro','1139473393'),
(11,'Ani','Bazet','Balvanera','2392524383');


-- COSTURERAS
##(10,'Marcela','Sanchez','Villa Urquiza (Esc. Gorriti)','1138337420'),
##(11,'Luciana','Noel','Villa del Parque','1169822121'),
##(13,'Dolores','Lotero','Recoleta','1155851662'),

insert Location
values
(1, 'Almagro', 1, 0),
(2, 'Flores', 1, 1),
(3, 'Caballito', 1, 2),

(4, 'Mataderos-Flores', 2, 0),
(5, 'Bajo Flores-Pompeya', 2, 1),
(6, 'Soldati-Villa Celina', 2, 2),
(7, 'Lomas del Mirador', 2, 3),
(8, 'Lugano', 2, 4),

(9, 'Villa del Parque', 3, 0),
(10, 'Santa Rita', 3, 1),
(11, 'Villa Urquiza', 3, 2),
(12, 'Villa Devoto', 3, 3),
(13, 'Villa Pueyrredón', 3, 4),

(14, 'Villa Pueyrredon', 4, 0),
(15, 'Villa Urquiza', 4, 1),
(16, 'Saavedra', 4, 2),
(17, 'Villa del Parque ', 4, 3),
(18, 'Devoto', 4, 4),

(19, 'Paternal', 5, 0),
(20, 'Floresta', 5, 1),
(21, 'Flores', 5, 2),
(22, 'Villa Mitre', 5, 3),

(23, 'Villa Crespo', 6, 0),
(24, 'Paternal', 6, 1),
(25, 'Palermo', 6, 2),
(26, 'Chacarita', 6, 3),

(27, 'Villa Devoto', 7, 0),
(28, 'Villa del Parque ', 7, 1),
(29, 'Belgrano', 7, 2),
(30, 'Villa Luro - Versalles', 7, 3),
(31, 'Villa Urquiza', 7, 4),

(32, 'Saavedra', 8, 0),
(33, 'Nuñez', 8, 1),
(34, 'Belgrano', 8, 2),
(35, 'Villa Urquiza', 8, 3),

(36, 'Liniers', 9, 0),
(37, 'Mataderos', 9, 1),
(38, 'Villa Luro', 9, 2),
(39, 'Versalles', 9, 3),

(40, 'Monte Castro', 10, 0),
(41, 'Floresta', 10, 1),
(42, 'Devoto', 10, 2),
(43, 'Versalles', 10, 3),
(44, 'Villa Santa Rita', 10, 4),

(45, 'Balvanera', 10, 0),
(46, 'Recoleta', 10, 1),
(47, 'Almagro', 10, 2),
(48, 'Once', 10, 3);

insert HospitalProduct
values
(4, 'Pañales', 'Posadas', 'Insumo', 30),
(5, 'Dentifrico', 'Posadas', 'Insumo', 15),
(6, 'Jabón', 'Posadas', 'Insumo', 3),
(7, 'Pañales', 'Durand', 'Insumo', 10),
(8, 'Juguetes', 'Durand', 'Existencia', 11),
(9, 'Juguetes', 'Posadas', 'Existencia', 12);