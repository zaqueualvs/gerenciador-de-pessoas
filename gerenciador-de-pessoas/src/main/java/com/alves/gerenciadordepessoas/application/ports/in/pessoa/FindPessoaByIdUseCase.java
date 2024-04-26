package com.alves.gerenciadordepessoas.application.ports.in.pessoa;

import com.alves.gerenciadordepessoas.application.domain.models.Pessoa;

public interface FindPessoaByIdUseCase {

    Pessoa findById(Long id);
}
