package com.alves.gerenciadordepessoas.application.domain.services.pessoa;

import com.alves.gerenciadordepessoas.application.domain.models.Pessoa;
import com.alves.gerenciadordepessoas.application.ports.in.pessoa.SavePessoaUseCase;
import com.alves.gerenciadordepessoas.application.ports.out.pessoa.SavePessoaPort;
import com.alves.gerenciadordepessoas.common.UseCase;
import lombok.RequiredArgsConstructor;

@UseCase
@RequiredArgsConstructor
public class SavePessoaService implements SavePessoaUseCase {

    private final SavePessoaPort savePessoaPort;

    @Override
    public Pessoa save(Pessoa pessoa) {
        return savePessoaPort.save(pessoa);
    }
}
