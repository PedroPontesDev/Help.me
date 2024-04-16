CREATE TABLE tb_mesa (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    status VARCHAR(50),
    inicio_ocupacao DATETIME,
    desocupacao DATETIME,
    comanda_id BIGINT,
    FOREIGN KEY (comanda_id) REFERENCES tb_comandas(id)
);

