ALTER TABLE tb_garcom
ADD COLUMN permissao_usuario_id BIGINT,
ADD CONSTRAINT fk_garcom_permissao_usuario
FOREIGN KEY (permissao_usuario_id) REFERENCES tb_permissao (id);

