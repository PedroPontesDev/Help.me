ALTER TABLE tb_usuario ADD COLUMN funcionario_id BIGINT;
ALTER TABLE tb_usuario ADD CONSTRAINT fk_funcionario_id FOREIGN KEY (funcionario_id) REFERENCES tb_funcionario(id);

