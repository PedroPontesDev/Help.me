
ALTER TABLE tb_funcionario
DROP INDEX UK_h483q8xwbxkhk56ceeww2pvhw,
ADD CONSTRAINT UK_cpf_unique_funcionario UNIQUE (cpf),
DROP INDEX UK_f0a74abfcyow0hdbgaofuxlpu,
ADD CONSTRAINT UK_username_unique_funcionario UNIQUE (username),
DROP INDEX UK_lpn4w0g3s2r5btitx2kldndsg,
ADD CONSTRAINT FK_permissao_funcionario FOREIGN KEY (permissao_id) REFERENCES tb_permissao(id);

