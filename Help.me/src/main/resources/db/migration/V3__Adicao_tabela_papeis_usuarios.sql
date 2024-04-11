CREATE TABLE tb_papeis_usuarios (
  usuario_id BIGINT NOT NULL,
  roles_id BIGINT NOT NULL,
  FOREIGN KEY (usuario_id) REFERENCES tb_usuarios(id),
  FOREIGN KEY (roles_id) REFERENCES tb_roles(id),
  PRIMARY KEY (usuario_id, roles_id)
);

