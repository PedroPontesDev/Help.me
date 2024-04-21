CREATE TABLE tb_comandas (
  id BIGINT NOT NULL AUTO_INCREMENT,
  em_aberto BOOLEAN,
  valor_comanda DECIMAL(38, 2),
  garcom_id BIGINT,
  PRIMARY KEY (id),
  CONSTRAINT fk_comandas_garcom FOREIGN KEY (garcom_id) REFERENCES tb_garcom (id)
) ENGINE=InnoDB;

