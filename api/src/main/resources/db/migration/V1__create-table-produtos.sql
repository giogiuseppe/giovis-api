create table produtos(

    id bigint not null auto_increment,
    nome varchar(100) not null,
    preco_unitario double not null,
    categoria enum("manual","eletrico","combustivel") not null,
    descricao longtext not null,
    status enum("disponivel","indisponivel","obsoleto") not null,

    primary key(id)

);