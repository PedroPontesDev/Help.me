CREATE TABLE tb_garcom (
    id SERIAL PRIMARY KEY,
    horario_entrada_semana TIMESTAMP,
    horario_saida_semana TIMESTAMP,
    total_horas_trabalhadas_mes INTERVAL,
    salario_funcionario NUMERIC(10, 2)
);
