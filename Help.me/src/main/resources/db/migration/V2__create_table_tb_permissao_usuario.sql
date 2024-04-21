CREATE TABLE tb_permissao (
  id BIGINT NOT NULL AUTO_INCREMENT,
  tipo_de_usuario ENUM('ADMINISTRADOR', 'GERENTE', 'CLIENTE', 'COMUM', 'GARCOM'),
  PRIMARY KEY (id)
) ENGINE=InnoDB;
