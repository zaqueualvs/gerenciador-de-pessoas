package com.alves.gerenciadordepessoas.application.ports.out.pessoa;

import com.alves.gerenciadordepessoas.application.domain.models.Pessoa;

import java.util.List;

public interface FindAllPessoaPort {

    List<Pessoa> findAll();
}
