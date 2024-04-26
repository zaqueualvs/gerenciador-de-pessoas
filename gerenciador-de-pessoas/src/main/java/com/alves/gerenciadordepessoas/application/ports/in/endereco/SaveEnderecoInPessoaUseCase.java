package com.alves.gerenciadordepessoas.application.ports.in.endereco;

import com.alves.gerenciadordepessoas.application.domain.models.Endereco;
import com.alves.gerenciadordepessoas.application.domain.models.Pessoa;

public interface SaveEnderecoInPessoaUseCase {

    Pessoa save(Endereco endereco, Long pessoaId);
}
