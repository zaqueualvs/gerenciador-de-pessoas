package com.alves.gerenciadordepessoas.application.ports.out.pessoa;

import com.alves.gerenciadordepessoas.application.domain.models.Pessoa;

public interface SavePessoaPort {

    Pessoa save(Pessoa pessoa);
}
