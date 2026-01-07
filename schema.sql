create table usuarios (
	email varchar(100) primary key,
	password varchar(255)
);

create table notas(
	id serial primary key,
	texto varchar(255),
	timestamp timestamp,
	usuario varchar(100),
	foreign key (usuario) references usuarios(email)
);