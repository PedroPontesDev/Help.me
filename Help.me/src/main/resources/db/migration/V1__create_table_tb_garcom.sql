CREATE TABLE tb_garcom (
  id BIGINT NOT NULL AUTO_INCREMENT,
  cpf VARCHAR(255),
  nome VARCHAR(255),
  password VARCHAR(255),
  username VARCHAR(255),
  horario_entrada_dia DATETIME,
  horario_saida_dia DATETIME,
  total_horas_trabalhadas_mes DECIMAL(21, 0),
  salario_funcionario DECIMAL(38, 2),
  PRIMARY KEY (id)
) ENGINE=InnoDB;

