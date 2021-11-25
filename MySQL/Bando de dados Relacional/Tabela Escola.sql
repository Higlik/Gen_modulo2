create database db_notas;

use db_notas;

-- criando tabela
create table tb_registroNotas(
id bigint auto_increment unique,
nome varchar(255) not null,
turma int,
turno varchar(255) not null,
serie int,
nota int,
primary key (id)
);

-- cadastrando dados dos alunos

insert into tb_registroNotas (nome, turma,turno,serie,nota) values ("João",23,"manhã",7,4);
insert into tb_registroNotas (nome, turma,turno,serie,nota) values ("Camila",21,"manhã",7,8);
insert into tb_registroNotas (nome, turma,turno,serie,nota) values ("Francisco",14,"tarde",9,6);
insert into tb_registroNotas (nome, turma,turno,serie,nota) values ("Narian",66,"noite",9,10);
insert into tb_registroNotas (nome, turma,turno,serie,nota) values ("Lidia",10,"manhã",3,7);
insert into tb_registroNotas (nome, turma,turno,serie,nota) values ("Joaquin",76,"manhã",4,2);
insert into tb_registroNotas (nome, turma,turno,serie,nota) values ("Kaio",100,"noite",9,1);
insert into tb_registroNotas (nome, turma,turno,serie,nota) values ("Tamires",93,"tarde",5,10);


-- mostra tabela 

select * from tb_registroNotas;

select * from tb_registroNotas where nota > 7;

select * from tb_registroNotas where nota < 7;

-- alteração de tabela

update tb_registroNotas set nota = 10 where id = 8;
