ALTER TABLE tb_funcionario 
ADD COLUMN usuario_id BIGINT,
ADD CONSTRAINT fk_tb_funcionario_tb_usuarios FOREIGN KEY (usuario_id) REFERENCES tb_usuarios(id);

