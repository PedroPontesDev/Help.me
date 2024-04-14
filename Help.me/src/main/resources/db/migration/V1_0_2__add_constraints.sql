ALTER TABLE tb_mesa ADD CONSTRAINT UK_tb_mesa UNIQUE (comanda_id);

ALTER TABLE tb_usuarios ADD CONSTRAINT UK_tb_usuarios_cpf UNIQUE (cpf);
ALTER TABLE tb_usuarios ADD CONSTRAINT UK_tb_usuarios_username UNIQUE (username);
