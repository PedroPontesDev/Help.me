CREATE TABLE tb_garcom (
  id BIGINT PRIMARY KEY AUTO_INCREMENT,
  horario_entrada_dia TIMESTAMP NOT NULL,
  horario_saida_dia TIMESTAMP NOT NULL,
  total_horas_trabalhadas_mes TIMESTAMP NOT NULL,
  salario_funcionario DECIMAL(10,2) NOT NULL CHECK (salario_funcionario >= 0),
  FOREIGN KEY (id) REFERENCES tb_usuarios(id)
);

