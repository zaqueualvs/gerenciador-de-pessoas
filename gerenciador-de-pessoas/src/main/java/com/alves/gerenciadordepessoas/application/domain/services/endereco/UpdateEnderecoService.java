package com.alves.gerenciadordepessoas.application.domain.services.endereco;

import com.alves.gerenciadordepessoas.application.domain.models.Endereco;
import com.alves.gerenciadordepessoas.application.ports.in.endereco.UpdateEnderecoUseCase;
import com.alves.gerenciadordepessoas.application.ports.out.endereco.UpdateEnderecoPort;
import com.alves.gerenciadordepessoas.common.UseCase;
import lombok.RequiredArgsConstructor;

@UseCase
@RequiredArgsConstructor
public class UpdateEnderecoService implements UpdateEnderecoUseCase {

    private final UpdateEnderecoPort updateEnderecoPort;

    @Override
    public Endereco update(Endereco endereco) {
        return updateEnderecoPort.update(endereco);
    }
}
