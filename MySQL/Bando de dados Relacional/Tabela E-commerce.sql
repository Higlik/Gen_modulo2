-- criando o banco de dados
create database db_ecommerce;

-- Usa a tabela
use db_ecommerce;

-- criando tabela de produtos
create table tb_produtos (
id bigint auto_increment unique,
nome varchar(255) not null,
quantidade int,
valor decimal(8,2) not null,
descricao varchar(255) not null,
codigoBarras varchar(255) not null,
primary key (id)
);

-- cadastrando produtos
insert into tb_produtos (nome, quantidade, valor, descricao, codigoBarras) values ("Carro Batman", 35, 99.99, "Carrinho de brinquedo do hério batman",  "12312344");
insert into tb_produtos (nome, quantidade, valor, descricao, codigoBarras) values ("Boneca Poliana", 100, 70.00, "Versão barata da boneca Poly",  "1636147348");
insert into tb_produtos (nome, quantidade, valor, descricao, codigoBarras) values ("Cama elastica", 10, 540.00, "Uma cama elastica simples tamanho 10x10m",  "124553440973");
insert into tb_produtos (nome, quantidade, valor, descricao, codigoBarras) values ("Panela de pressão de luxo", 15, 900.00, "Panela banhada a ouro com traços decorados",  "1111234512");
insert into tb_produtos (nome, quantidade, valor, descricao, codigoBarras) values ("Faca de diamante Mr.Jack", 5, 2200.00, "Faca para cortes de carnes linha de luxo",  "56675534543");
insert into tb_produtos (nome, quantidade, valor, descricao, codigoBarras) values ("Guarda chuva de rainha Elizabeth", 1, 999800.00, "Usado pela rainha Elizabeth",  "234235546459879");
insert into tb_produtos (nome, quantidade, valor, descricao, codigoBarras) values ("Camisa", 2000, 60.00, "Camisa simples de todos os tamanhos",  "312312351323");
insert into tb_produtos (nome, quantidade, valor, descricao, codigoBarras) values ("Calça", 5550, 300.00, "Calça para jovens",  "1231235509708986");

-- Mostra tabela

select * from tb_produtos;

select * from tb_produtos where valor >500;

select * from tb_produtos where valor <500;

-- aletração na tabela

update tb_produtos set descricao = "Carrinho do heroi Batman" where id = 1;
