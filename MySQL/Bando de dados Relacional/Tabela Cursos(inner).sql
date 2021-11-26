create database db_cursoDaMinhaVida;

use db_cursoDaMinhaVida;

create table tb_categoria(
id bigint auto_increment,
duracao int,
grauDificuldade varchar(255),
professor varchar(255),
primary key (id)
);

insert into tb_categoria (professor,grauDificuldade,duracao) values ("Joaquim M.","Difícil",80);
insert into tb_categoria (professor,grauDificuldade,duracao) values ("Marcelo R.","Facíl",40);
insert into tb_categoria (professor,grauDificuldade,duracao) values ("Mariana M.","Facíl",50);
insert into tb_categoria (professor,grauDificuldade,duracao) values ("Carlos A.","Difícil",100);
insert into tb_categoria (professor,grauDificuldade,duracao) values ("Romeno F.","Difícil",200);
insert into tb_categoria (professor,grauDificuldade,duracao) values ("Alana G.","Médio",60);
insert into tb_categoria (professor,grauDificuldade,duracao) values ("Fabi S.","Médio",80);

select * from tb_categoria;


create table tb_curso(
id bigint auto_increment,
materia varchar(255),
modulos int,
ferramentaEstudo varchar(255),
carreira varchar(255),
valor decimal (8,2),
professor_id bigint,
primary key (id),
foreign key (professor_id) references tb_categoria(id)
);

insert into tb_curso(materia,modulos,ferramentaEstudo,carreira,valor,professor_id) values ("Medicina",5,"Livro Mão Médica","Medico",2000.00,5);
insert into tb_curso(materia,modulos,ferramentaEstudo,carreira,valor,professor_id) values ("Bio Medicina",3,"Microscopio","Biomedico",1300.00,5);
insert into tb_curso(materia,modulos,ferramentaEstudo,carreira,valor,professor_id) values ("Arte marcial",2,"Kimono","Lutador",500.00,6);
insert into tb_curso(materia,modulos,ferramentaEstudo,carreira,valor,professor_id) values ("Educação fisica",1,"força de vontade","Personal",300.00,3);
insert into tb_curso(materia,modulos,ferramentaEstudo,carreira,valor,professor_id) values ("Programação",100,"Java,Python,SQL,C++,C#...","Dev",0.00,4);
insert into tb_curso(materia,modulos,ferramentaEstudo,carreira,valor,professor_id) values ("Corredor Amador",1,"kit de corrida","Atleta amador",100.00,2);
insert into tb_curso(materia,modulos,ferramentaEstudo,carreira,valor,professor_id) values ("Mecanico",3,"Carro","Mecanico",600.00,1);
insert into tb_curso(materia,modulos,ferramentaEstudo,carreira,valor,professor_id) values ("Jogador de futebol",2,"campo de futebol","Atleta",250.00,7);

select * from tb_curso;

select *from tb_curso where valor >200;
 
select * from tb_curso where valor between 400 and 30000;

select * from tb_curso where materia like 'j%';

select * from tb_curso inner join tb_categoria on tb_curso.professor_id = tb_categoria.id;

select * from tb_curso inner join tb_categoria on tb_curso.professor_id = tb_categoria.id where tb_categoria.id = 5;





