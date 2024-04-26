package com.alves.gerenciadordepessoas.application.ports.in.endereco;

import com.alves.gerenciadordepessoas.application.domain.models.Endereco;

public interface UpdateEnderecoPrincipalUsuarioUseCase {

    Endereco update(Long enderecoId, Long pessoaId);
}
