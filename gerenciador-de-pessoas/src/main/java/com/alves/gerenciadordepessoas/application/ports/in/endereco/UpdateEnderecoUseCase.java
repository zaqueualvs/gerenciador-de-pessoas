package com.alves.gerenciadordepessoas.application.ports.in.endereco;

import com.alves.gerenciadordepessoas.application.domain.models.Endereco;

public interface UpdateEnderecoUseCase {

    Endereco update(Endereco endereco);
}
