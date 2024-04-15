INSERT INTO `db_helpme_test`.`tb_usuarios` (`nome`, `username`, `password`, `cpf`)
VALUES ('João Silva', 'joao.silva', 'senha123', '123.456.789-10');

SET @id_usuario := LAST_INSERT_ID();

INSERT INTO `db_helpme_test`.`tb_funcionario` 
    (`horario_entrada_dia`, `horario_saida_dia`, `total_horas_trabalhadas_mes`, `salario_funcionario`, `usuario_id`)
VALUES 
    ('2024-04-15 08:00:00', '2024-04-15 17:00:00', 160, 3000.00, @id_usuario);
