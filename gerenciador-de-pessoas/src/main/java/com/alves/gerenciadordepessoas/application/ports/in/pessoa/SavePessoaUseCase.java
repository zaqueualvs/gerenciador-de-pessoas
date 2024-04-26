package com.alves.gerenciadordepessoas.application.ports.in.pessoa;

import com.alves.gerenciadordepessoas.application.domain.models.Pessoa;

public interface SavePessoaUseCase {

    Pessoa save(Pessoa pessoa);
}
