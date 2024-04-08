CREATE TABLE tb_users (
    id SERIAL PRIMARY KEY,
    nome_pessoal VARCHAR(255) NOT NULL,
    username VARCHAR(100) UNIQUE NOT NULL,
    password VARCHAR(255) NOT NULL,
    cpf_pessoal FLOAT UNIQUE NOT NULL
);

