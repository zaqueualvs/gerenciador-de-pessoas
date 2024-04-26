package com.alves.gerenciadordepessoas.application.domain.services.pessoa;

import com.alves.gerenciadordepessoas.application.domain.models.Pessoa;
import com.alves.gerenciadordepessoas.application.ports.in.pessoa.UpdatePessoaUseCase;
import com.alves.gerenciadordepessoas.application.ports.out.pessoa.UpdatePessoaPort;
import com.alves.gerenciadordepessoas.common.UseCase;
import lombok.RequiredArgsConstructor;

@UseCase
@RequiredArgsConstructor
public class UpdatePessoaService implements UpdatePessoaUseCase {

    private final UpdatePessoaPort updatePessoaPort;

    @Override
    public Pessoa update(Pessoa pessoa) {
        return updatePessoaPort.update(pessoa);
    }
}
