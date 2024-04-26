package com.alves.gerenciadordepessoas.adapters.in.rest.data.out;

public record EnderecoResponse(
        Long id,
        String logradouro,
        String cep,
        String numero,
        String cidade,
        String estado
) {
}
