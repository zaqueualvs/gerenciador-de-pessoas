package com.alves.gerenciadordepessoas.application.ports.out.pessoa;

import com.alves.gerenciadordepessoas.application.domain.models.Pessoa;

public interface UpdatePessoaPort {

    Pessoa update(Pessoa pessoa);
}
