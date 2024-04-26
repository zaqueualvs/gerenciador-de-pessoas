package com.alves.gerenciadordepessoas.application.ports.in.pessoa;

import com.alves.gerenciadordepessoas.application.domain.models.Pessoa;

public interface UpdatePessoaUseCase {

    Pessoa update(Pessoa pessoa);
}
