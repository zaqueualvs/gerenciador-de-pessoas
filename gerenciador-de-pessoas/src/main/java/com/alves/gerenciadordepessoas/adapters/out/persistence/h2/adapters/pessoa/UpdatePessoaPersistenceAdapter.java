package com.alves.gerenciadordepessoas.adapters.out.persistence.h2.adapters.pessoa;

import com.alves.gerenciadordepessoas.application.domain.models.Pessoa;
import com.alves.gerenciadordepessoas.application.ports.out.pessoa.SavePessoaPort;
import com.alves.gerenciadordepessoas.application.ports.out.pessoa.UpdatePessoaPort;
import com.alves.gerenciadordepessoas.common.PersistenceAdapter;
import lombok.RequiredArgsConstructor;

@PersistenceAdapter
@RequiredArgsConstructor
public class UpdatePessoaPersistenceAdapter implements UpdatePessoaPort {

    private final SavePessoaPort savePessoaPort;

    @Override
    public Pessoa update(Pessoa pessoa) {
        return savePessoaPort.save(pessoa);
    }
}
