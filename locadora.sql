create database locadora;
use locadora;

create table filme (
	id int(10) primary key not null auto_increment,
    titulo varchar(100) not null,
    categoria varchar(256) not null,
    sinopse varchar(500) not null,
    tempo int(10) not null,
    imagem3d boolean not null,
    dublado boolean not null
);

select * from filme;

create table cliente (
	id int(10) primary key not null auto_increment,
    nome varchar(500) not null,
    email varchar(256) unique not null,
	cpf varchar(15) not null unique,
    endereco varchar (100) not null,
    telefone varchar (20) not null 
);
select * from cliente;

