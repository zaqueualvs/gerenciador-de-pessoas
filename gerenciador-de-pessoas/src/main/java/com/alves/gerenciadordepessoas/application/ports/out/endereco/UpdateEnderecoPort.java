package com.alves.gerenciadordepessoas.application.ports.out.endereco;

import com.alves.gerenciadordepessoas.application.domain.models.Endereco;

public interface UpdateEnderecoPort {
    Endereco update(Endereco endereco);
}
