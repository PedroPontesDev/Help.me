CREATE TABLE tb_funcionario (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    horario_entrada_dia DATETIME,
    horario_saida_dia DATETIME,
    total_horas_trabalhadas_mes DECIMAL(10,2),
    salario_funcionario DECIMAL(10,2),
    usuario_id BIGINT,
    FOREIGN KEY (usuario_id) REFERENCES tb_usuario(id)
);
