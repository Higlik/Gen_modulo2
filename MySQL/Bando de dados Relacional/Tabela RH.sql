-- criando o banco de dados
create database db_RH;

-- Entra no db_RH
use db_rh;

-- Cria a tabela de funcionários
create table tb_funcionarios(
id bigint auto_increment unique,
nome varchar(255) not null,
idade int not null,
sexo varchar(255) not null,
cargo varchar(255) not null,
salario decimal(8,2) not null,
primary key (id)
);

-- Cadastrando dados dos funcionários
insert into tb_funcionarios(nome,idade,sexo,cargo,salario) values ("Marcos",55,"Homem","Gerente",10000.00);
insert into tb_funcionarios(nome,idade,sexo,cargo,salario) values ("Miriam",32,"Outros","Analista de qualidade", 6000.00);
insert into tb_funcionarios(nome,idade,sexo,cargo,salario) values ("Joaquim",29,"Homem","Controlador de acesso", 1900.40);
insert into tb_funcionarios(nome,idade,sexo,cargo,salario) values ("Fabiana",19,"Mulher","Auxiliar adminstrativa JR",1350.34);
insert into tb_funcionarios(nome,idade,sexo,cargo,salario) values ("Rodrigo",22,"Homem","Atendente",1240.00);


-- Visualiza os dados da tabela
select * from tb_funcionarios;

-- Visualiza salários maior que 2000
select * from tb_funcionarios where salario >2000; 

-- Visualiza salarios menor que 2000
select * from tb_funcionarios where salario <2000;

SET sql_safe_updates = 0;

-- Atualiza tabela funcionários
update tb_funcionarios set salario = 2900.88 where id = 4;
