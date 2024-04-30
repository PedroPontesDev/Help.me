ALTER TABLE tb_comandas
ADD CONSTRAINT FKcomadas_sistema FOREIGN KEY (garcom_id) REFERENCES tb_garcom (id);

ALTER TABLE tb_garcom
ADD CONSTRAINT Fkgarcoms_sistema FOREIGN KEY (role_id) REFERENCES tb_role (id);

ALTER TABLE tb_mesa
ADD CONSTRAINT FKmesas_sistema FOREIGN KEY (comanda_id) REFERENCES tb_comandas (id);
