package com.alves.gerenciadordepessoas.adapters.in.rest.data.in;

import java.util.Date;

public record PessoaRequest(
        String nome,
        Date dataNascimento
) {
}
