package com.alves.gerenciadordepessoas.adapters.in.rest.data.out;

import java.time.LocalDate;
import java.util.Set;

public record PessoaResponse(
        Long id,
        String nome,
        LocalDate dataNascimento,
        EnderecoResponse enderecoPrincipal,
        Set<EnderecoResponse> enderecos
) {
}
