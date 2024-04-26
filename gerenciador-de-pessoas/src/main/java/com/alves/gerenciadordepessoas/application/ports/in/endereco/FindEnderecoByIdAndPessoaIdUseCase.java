package com.alves.gerenciadordepessoas.application.ports.in.endereco;

import com.alves.gerenciadordepessoas.application.domain.models.Endereco;

public interface FindEnderecoByIdAndPessoaIdUseCase {

    Endereco findById(Long enderecoId, Long pessoaId);
}
