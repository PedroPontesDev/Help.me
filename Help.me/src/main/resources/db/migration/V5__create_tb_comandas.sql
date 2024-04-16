CREATE TABLE tb_comandas (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    valor_comanda DECIMAL(10,2),
    garcom_id BIGINT,
    FOREIGN KEY (garcom_id) REFERENCES tb_funcionario(id)
);

