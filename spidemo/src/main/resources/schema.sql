CREATE TABLE sucursales (
sucursal smallint not null,
snombre varchar(255) not null,
domicilio1 varchar(255) not null,
domicilio2 varchar(255) not null,
pais varchar(10) not null,
estado varchar(10) not null,
municipio varchar(100) not null,
latitud integer not null,
longitud integer not null,
almacen varchar(3) not null,
PRIMARY KEY (sucursal)
);