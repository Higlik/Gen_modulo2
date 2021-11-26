create database db_cidade_das_carnes;

use db_cidade_das_carnes;

create table tb_categoria(
id bigint auto_increment,
descricao varchar(255) not null,
ativo boolean not null,
primary key (id)
);

insert into tb_categoria (descricao, ativo) values ("Bovino",true);
insert into tb_categoria (descricao, ativo) values ("Suino",true);
insert into tb_categoria (descricao, ativo) values ("Aves",true);
insert into tb_categoria (descricao, ativo) values ("pertence feijoada",true);
insert into tb_categoria (descricao, ativo) values ("imbutidos",true);
insert into tb_categoria (descricao, ativo) values ("soja",true);
insert into tb_categoria (descricao, ativo) values ("outros",true);

select * from tb_categoria;

create table tb_produtos (
id bigint auto_increment,
nome varchar (255) not null,
preco decimal(6,2) not null,
qtproduto int not null,
dtvalidade date,
categoria_id bigint,
primary key (id),
FOREIGN KEY (categoria_id) REFERENCES tb_categoria (id)
);

insert into tb_produtos (nome, preco, qtProduto, dtvalidade, categoria_id) values ("ASA",40.00,30, "2021-11-07", 3);
insert into tb_produtos (nome, preco, qtProduto, dtvalidade, categoria_id) values ("Picanha",20.00,30, "2021-11-08", 1);
insert into tb_produtos (nome, preco, qtProduto, dtvalidade, categoria_id) values ("coxa de frango",20.00,30, "2021-11-07", 3);
insert into tb_produtos (nome, preco, qtProduto, dtvalidade, categoria_id) values ("Bacon",30.00,30, "2021-11-09", 1);
insert into tb_produtos (nome, preco, qtProduto, dtvalidade, categoria_id) values ("hamburguer",60.00,30, "2021-09-07", 5);
insert into tb_produtos (nome, preco, qtProduto, dtvalidade, categoria_id) values ("Cupim",20.00,30, "2021-11-10", 1);
insert into tb_produtos (nome, preco, qtProduto, dtvalidade, categoria_id) values ("Peito de frango",25.00,30, "2021-11-09", 3);
insert into tb_produtos (nome, preco, qtProduto, dtvalidade, categoria_id) values ("Orelha de porco",20.00,30, "2021-11-07", 4);
insert into tb_produtos (nome, preco, qtProduto, dtvalidade, categoria_id) values ("Salame",18.00,30, "2021-11-21", 5);
insert into tb_produtos (nome, preco, qtProduto, dtvalidade, categoria_id) values ("medalhao",50.00,30, "2021-11-15", 3);
insert into tb_produtos (nome, preco, qtProduto, dtvalidade, categoria_id) values ("mocoto",20.00,30, "2021-10-05", 2);
insert into tb_produtos (nome, preco, qtProduto, dtvalidade, categoria_id) values ("chuleta",20.00,30, "2021-10-07", 1);
insert into tb_produtos (nome, preco, qtProduto) values ("acendedor de churrasqueira",20.00,30);
insert into tb_produtos (nome, preco, qtProduto) values ("soprador de churrasqueira",35.00,30);

-- Consultas

select * from tb_produtos;

-- busca por nome
select * from tb_produtos order by nome;
-- busca por nome
select * from tb_produtos order by nome desc;

select nome, preco from tb_produtos order by preco;

-- operadores lógicos
select * from tb_produtos where preco > 20.00 and preco < 50.00;

select * from tb_produtos where preco > 20.00 or categoria_id = 3;

select * from tb_produtos where not categoria_id = 3;

select * from tb_produtos where nome like "ha%";

select * from tb_produtos where nome like "%ha";

select * from tb_produtos where nome like "%ha%";

-- condicional
select descricao, if(ativo, "Verdadeiro", "Falso") as teste_ativo from tb_categoria;

select * from tb_produtos where preco in (30, 40, 50);

select * from tb_produtos where  preco between 30 and 50;

select * from tb_produtos where dtvalidade between '2021-11-07' and '2021-11-15';

select count(categoria_id) from tb_produtos;

select sum(preco) from tb_produtos;

select avg(preco) from tb_produtos;

select categoria_id, avg(preco) as media_preco from tb_produtos group by categoria_id;
-- traz o maior preco
select max(preco) from tb_produtos;
-- traz o menor preco
select min(preco) from tb_produtos;

select * from tb_produtos where preco = (select max(preco) from tb_produtos);

-- juntado as tabelas

-- codigos Join
select tb_produtos.nome, tb_produtos.preco, tb_produtos.qtProduto, tb_categoria.descricao from tb_produtos inner join tb_categoria on tb_categoria.id = tb_produtos.categoria_id order by tb_categoria.descricao;

select tb_produtos.nome, tb_produtos.preco, tb_produtos.qtProduto, tb_categoria.descricao from tb_produtos left join tb_categoria on tb_categoria.id = tb_produtos.categoria_id;

select tb_produtos.nome, tb_produtos.preco, tb_produtos.qtProduto, tb_categoria.descricao from tb_produtos right join tb_categoria on tb_categoria.id = tb_produtos.categoria_id;

select tb_categoria.descricao, avg(tb_produtos.preco) as preco_medio
 from tb_produtos inner join tb_categoria 
 on tb_categoria.id = tb_produtos.categoria_id 
 group by tb_categoria.descricao
order by tb_categoria.descricao;

select nome, date_format(dtvalidade, "%d/%m/%y") as Data_validade from tb_produtos;