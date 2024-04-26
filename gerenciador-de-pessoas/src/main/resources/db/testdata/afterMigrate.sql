INSERT INTO endereco(logradouro, cep,numero ,cidade, estado)
VALUES ('Centro', '123654852','453', 'Rio de Janeiro', 'Rio de Janeiro'),
       ('Centro', '123654852','552', 'Rio de Janeiro', 'São Gonçalo');

INSERT INTO pessoa(nome, data_nascimento, endereco_principal_id)
VALUES ('Maria Sousa', '2018-05-05', 1);

INSERT INTO pessoa_endereco(pessoa_id, endereco_id)
VALUES (1, 1),
       (1, 2);