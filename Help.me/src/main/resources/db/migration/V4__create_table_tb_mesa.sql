CREATE TABLE tb_mesa (
  id BIGINT NOT NULL AUTO_INCREMENT,
  desocupacao DATETIME,
  inicio_ocupacao DATETIME,
  numero_ocupantes INT,
  status ENUM('LIVRE', 'OCUPADA', 'RESERVADA'),
  comanda_id BIGINT,
  PRIMARY KEY (id),
  CONSTRAINT fk_mesa_comanda FOREIGN KEY (comanda_id) REFERENCES tb_comandas (id),
  UNIQUE (comanda_id)
) ENGINE=InnoDB;

