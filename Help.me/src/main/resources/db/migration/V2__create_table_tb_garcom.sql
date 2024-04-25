CREATE TABLE tb_garcom (
  id BIGINT NOT NULL AUTO_INCREMENT,
  nome VARCHAR(255) NOT NULL,
  username VARCHAR(255) NOT NULL,
  password VARCHAR(255) NOT NULL,
  cpf VARCHAR(14) NOT NULL,
  permissao_id BIGINT NOT NULL,
  horas_trabalhadas_semana DATETIME NOT NULL,
  total_horas_trabalhadas_mes BIGINT NOT NULL,
  salario_funcionario DECIMAL(10, 2) NOT NULL,
  PRIMARY KEY (id),
  FOREIGN KEY (permissao_id) REFERENCES tb_permissao(id)
) ENGINE=InnoDB;

