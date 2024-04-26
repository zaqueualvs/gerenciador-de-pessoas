package com.alves.gerenciadordepessoas.application.ports.out.pessoa;

import com.alves.gerenciadordepessoas.application.domain.models.Pessoa;

import java.util.Optional;

public interface FindPessoaByIdPort {

    Optional<Pessoa> findById(Long id);
}
