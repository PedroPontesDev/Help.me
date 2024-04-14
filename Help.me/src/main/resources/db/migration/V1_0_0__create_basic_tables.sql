CREATE TABLE tb_usuarios (
    id BIGINT NOT NULL AUTO_INCREMENT,
    nome VARCHAR(255),
    username VARCHAR(255),
    password VARCHAR(255),
    cpf VARCHAR(255),
    PRIMARY KEY (id)
);

CREATE TABLE tb_comandas (
    id BIGINT NOT NULL AUTO_INCREMENT,
    valor_comanda DECIMAL(38,2),
    PRIMARY KEY (id)
);

CREATE TABLE tb_funcionario (
    id BIGINT NOT NULL AUTO_INCREMENT,    
    horario_entrada_dia DATETIME,
    horario_saida_dia DATETIME,
    total_horas_trabalhadas_mes DECIMAL(21,0),
    salario_funcionario DECIMAL(38,2),
    PRIMARY KEY (id)
);

CREATE TABLE tb_mesa (
    id BIGINT NOT NULL AUTO_INCREMENT,
    desocupacao DATETIME(6),
    inicio_ocupacao DATETIME(6),
    status ENUM ('LIVRE','OCUPADA','RESERVADA'),
    PRIMARY KEY (id)
);

CREATE TABLE tb_permissoes (
    id BIGINT NOT NULL AUTO_INCREMENT,
    tipo_de_usuario ENUM ('ADMINISTRADOR','GERENTE','CLIENTE','GARACOM'),
    PRIMARY KEY (id)
);

CREATE TABLE tb_permissao_usuario (
    funcionario_id BIGINT NOT NULL,
    role_id BIGINT NOT NULL,
    PRIMARY KEY (funcionario_id, role_id)
);
