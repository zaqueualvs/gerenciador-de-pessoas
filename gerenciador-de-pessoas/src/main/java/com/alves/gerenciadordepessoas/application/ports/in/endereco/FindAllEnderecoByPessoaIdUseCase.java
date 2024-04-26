package com.alves.gerenciadordepessoas.application.ports.in.endereco;

import com.alves.gerenciadordepessoas.application.domain.models.Endereco;

import java.util.List;

public interface FindAllEnderecoByPessoaIdUseCase {

    List<Endereco> findAll(Long pessoaId);
}
