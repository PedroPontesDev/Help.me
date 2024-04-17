ALTER TABLE tb_mesa
DROP INDEX UK_euuay0b4nnugsrpy8j2mn22ru,
ADD CONSTRAINT FK_comanda_tb_mesa FOREIGN KEY (comanda_id) REFERENCES tb_comandas(id);

