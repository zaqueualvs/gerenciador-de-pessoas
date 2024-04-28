package com.alves.gerenciadordepessoas.application.domain.services.pessoa;

import com.alves.gerenciadordepessoas.application.domain.exceptions.PessoaNotFoundException;
import com.alves.gerenciadordepessoas.application.domain.models.Pessoa;
import com.alves.gerenciadordepessoas.application.ports.in.pessoa.FindPessoaByIdUseCase;
import com.alves.gerenciadordepessoas.application.ports.out.pessoa.FindPessoaByIdPort;
import com.alves.gerenciadordepessoas.common.UseCase;
import lombok.RequiredArgsConstructor;

@UseCase
@RequiredArgsConstructor
public class FindPessoaByIdService implements FindPessoaByIdUseCase {


    private final FindPessoaByIdPort findPessoaByIdPort;

    @Override
    public Pessoa findById(Long id) {
        return findPessoaByIdPort.findById(id)
                .orElseThrow(() -> new PessoaNotFoundException(id)
                );
    }
}
