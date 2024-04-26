CREATE TABLE endereco
(
    id         BIGINT NOT NULL AUTO_INCREMENT,
    logradouro VARCHAR(40),
    cep        VARCHAR(9),
    numero     VARCHAR(5),
    cidade     VARCHAR(40),
    estado     VARCHAR(18),

    PRIMARY KEY (id)
);

CREATE TABLE pessoa
(
    id                    BIGINT NOT NULL AUTO_INCREMENT,
    nome                  VARCHAR(30),
    data_nascimento       DATE,
    endereco_principal_id BIGINT,

    PRIMARY KEY (id),
    CONSTRAINT fk_pessoa_endereco
        FOREIGN KEY (endereco_principal_id)
            REFERENCES endereco (id)
);
CREATE TABLE pessoa_endereco
(
    endereco_id BIGINT NOT NULL AUTO_INCREMENT,
    pessoa_id   BIGINT NOT NULL AUTO_INCREMENT,

    CONSTRAINT fk_pessoa_endereco_endereco
        FOREIGN KEY (pessoa_id)
            REFERENCES pessoa (id),

    CONSTRAINT fk_pessoa_endereco_pessoa
        FOREIGN KEY (endereco_id)
            REFERENCES endereco (id)
);