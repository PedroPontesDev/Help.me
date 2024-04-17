CREATE TABLE tb_permissao (
    id BIGINT NOT NULL AUTO_INCREMENT,
    permissao_usuario VARCHAR(255),
    tipo_de_usuario ENUM('ADMINISTRADOR', 'GERENTE', 'CLIENTE', 'COMUM', 'GARÇOM'),
    PRIMARY KEY (id)
) ENGINE=InnoDB;
