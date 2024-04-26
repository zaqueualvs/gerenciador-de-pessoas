package com.alves.gerenciadordepessoas.adapters.in.rest.data.in;

public record EnderecoRequest(
        String logradouro,
        String cep,
        String numero,
        String cidade,
        String estado) {
}
