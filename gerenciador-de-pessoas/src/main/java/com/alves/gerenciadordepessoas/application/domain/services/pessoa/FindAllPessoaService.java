package com.alves.gerenciadordepessoas.application.domain.services.pessoa;

import com.alves.gerenciadordepessoas.application.domain.models.Pessoa;
import com.alves.gerenciadordepessoas.application.ports.in.pessoa.FindAllPessoaUseCase;
import com.alves.gerenciadordepessoas.application.ports.out.pessoa.FindAllPessoaPort;
import com.alves.gerenciadordepessoas.common.UseCase;
import lombok.RequiredArgsConstructor;

import java.util.List;

@UseCase
@RequiredArgsConstructor
public class FindAllPessoaService implements FindAllPessoaUseCase {
    private final FindAllPessoaPort findAllPessoaPort;

    @Override
    public List<Pessoa> findAll() {
        return findAllPessoaPort.findAll();
    }
}
