CREATE TABLE tb_mesa (
    id BIGINT NOT NULL AUTO_INCREMENT,
    desocupacao DATETIME(6),
    inicio_ocupacao DATETIME(6),
    numero_ocupantes VARBINARY(255),
    status ENUM('LIVRE', 'OCUPADA', 'RESERVADA'),
    comanda_id BIGINT,
    PRIMARY KEY (id),
    CONSTRAINT FK_tb_mesa_comanda FOREIGN KEY (comanda_id) REFERENCES tb_comandas(id)
) ENGINE=InnoDB;

