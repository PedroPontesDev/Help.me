ALTER TABLE tb_comandas ADD COLUMN funcionario_id BIGINT;
ALTER TABLE tb_comandas ADD FOREIGN KEY (funcionario_id) REFERENCES tb_funcionario (id);

ALTER TABLE tb_mesa ADD COLUMN comanda_id BIGINT;
ALTER TABLE tb_mesa ADD FOREIGN KEY (comanda_id) REFERENCES tb_comandas (id);

ALTER TABLE tb_permissao_usuario ADD FOREIGN KEY (role_id) REFERENCES tb_permissoes (id);
ALTER TABLE tb_permissao_usuario ADD FOREIGN KEY (funcionario_id) REFERENCES tb_funcionario (id);