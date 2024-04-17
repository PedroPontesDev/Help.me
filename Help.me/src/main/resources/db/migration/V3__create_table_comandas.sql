CREATE TABLE tb_comandas (
    id BIGINT NOT NULL AUTO_INCREMENT,
    valor_comanda DECIMAL(38,2),
    garcom_id BIGINT,
    PRIMARY KEY (id),
    CONSTRAINT FK_tb_comandas_garcom FOREIGN KEY (garcom_id) REFERENCES tb_funcionario(id)
) ENGINE=InnoDB;

