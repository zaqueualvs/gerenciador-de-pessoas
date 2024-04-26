package com.alves.gerenciadordepessoas.application.ports.in.pessoa;

import com.alves.gerenciadordepessoas.application.domain.models.Pessoa;

import java.util.List;

public interface FindAllPessoaUseCase {

    List<Pessoa> findAll();
}
