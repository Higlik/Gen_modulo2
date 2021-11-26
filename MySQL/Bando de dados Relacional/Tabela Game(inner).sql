create database db_game_online;

use db_game_online;

create table tb_classes(
id bigint auto_increment,
nome varchar(255),
skill varchar(255),
hp int,
arma varchar(255),
primary key (id)
);

insert into tb_classes(nome, skill, hp, arma) values ("Clerigo", "Cura divina", 800, "Semblante abençoado");
insert into tb_classes(nome, skill, hp, arma) values ("Berserk", "Furia por sangue", 1300, "machados duplos");
insert into tb_classes(nome, skill, hp, arma) values ("Caçador", "Armadilha de espinhos", 600, "Arco e flecha");
insert into tb_classes(nome, skill, hp, arma) values ("Paladino ateu", "Reza sem fé", 1900, "Martelo e escudo");
insert into tb_classes(nome, skill, hp, arma) values ("Mago", "missel magico", 650, "Varinha e livro");

select * from tb_classes;

create table tb_personagem(
id bigint auto_increment,
nome varchar(255) not null,
nivel int,
ataque int,
defesa int,
classe_id bigint,
primary key (id),
foreign key (classe_id) references tb_classes(id)
);

insert into tb_personagem(nome, nivel, ataque, defesa, classe_id) values ("Roger", 55, 700, 900, 5);
INSERT INTO tb_personagem (nome, nivel, ataque, defesa, classe_id) VALUES ("Santino", 1000, 8000, 7000, 4);
INSERT INTO tb_personagem (nome, nivel, ataque, defesa, classe_id) VALUES ("Jota", 600, 4000, 2000, 2);
INSERT INTO tb_personagem (nome, nivel, ataque, defesa, classe_id) VALUES ("Fabi", 60, 500, 500, 1);
INSERT INTO tb_personagem (nome, nivel, ataque, defesa, classe_id) VALUES ("Jon", 5, 150, 150, 2);
INSERT INTO tb_personagem (nome, nivel, ataque, defesa, classe_id) VALUES ("Carlos", 99, 900, 500, 3);
INSERT INTO tb_personagem (nome, nivel, ataque, defesa, classe_id) VALUES ("Camila", 50, 500, 900, 4);
INSERT INTO tb_personagem (nome, nivel, ataque, defesa, classe_id) VALUES ("Jorgin", 300, 900, 850, 3);
INSERT INTO tb_personagem (nome, nivel, ataque, defesa, classe_id) VALUES ("Mark", 01, 50, 10, 3);

select * from tb_personagem;

select * from tb_personagem where ataque > 2000;

select * from tb_personagem where defesa between 1000 and 2000;

select * from tb_personagem where nome like 'c%';

select * from tb_personagem inner join tb_classes on tb_personagem.classe_id = tb_classes.id;

select * from tb_personagem inner join tb_classes on tb_personagem.classe_id = tb_classes.id where tb_classes.id = 2;


