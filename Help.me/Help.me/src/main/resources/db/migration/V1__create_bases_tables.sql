CREATE TABLE tb_comandas (
    id BIGINT NOT NULL AUTO_INCREMENT,
    em_aberto BIT,
    valor_comanda DECIMAL(38,2),
    garcom_id BIGINT,
    PRIMARY KEY (id)
);

CREATE TABLE tb_garcom (
    id BIGINT NOT NULL AUTO_INCREMENT,
    cpf VARCHAR(255),
    nome VARCHAR(255),
    password VARCHAR(255),
    username VARCHAR(255),
    total_horas_trabalhadas_mes DECIMAL(21,0),
    salario_funcionario DECIMAL(38,2),
    role_id BIGINT,
    PRIMARY KEY (id)
);

CREATE TABLE tb_mesa (
    id BIGINT NOT NULL AUTO_INCREMENT,
    desocupacao DATETIME(6),
    inicio_ocupacao DATETIME(6),
    numero_ocupantes VARBINARY(255),
    status ENUM ('LIVRE','OCUPADA','RESERVADA'),
    comanda_id BIGINT,
    PRIMARY KEY (id)
);

CREATE TABLE tb_role (
    id BIGINT NOT NULL AUTO_INCREMENT,
    tipo_de_usuario ENUM ('ADMINISTRADOR','GERENTE','CLIENTE','COMUM','GARCOM'),
    PRIMARY KEY (id)
);

