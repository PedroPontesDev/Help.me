CREATE TABLE tb_funcionario (
    id BIGINT NOT NULL AUTO_INCREMENT,
    cpf VARCHAR(255) NOT NULL,
    nome VARCHAR(255),
    password VARCHAR(255) NOT NULL,
    username VARCHAR(255) NOT NULL,
    PRIMARY KEY (id)
) ENGINE=InnoDB;

