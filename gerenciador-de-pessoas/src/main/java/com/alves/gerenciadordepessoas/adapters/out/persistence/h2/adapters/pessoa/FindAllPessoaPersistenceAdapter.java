package com.alves.gerenciadordepessoas.adapters.out.persistence.h2.adapters.pessoa;

import com.alves.gerenciadordepessoas.adapters.out.persistence.h2.mappers.PessoaPersistenceMapper;
import com.alves.gerenciadordepessoas.adapters.out.persistence.h2.repositories.PessoaRepositiry;
import com.alves.gerenciadordepessoas.application.domain.models.Pessoa;
import com.alves.gerenciadordepessoas.application.ports.out.pessoa.FindAllPessoaPort;
import com.alves.gerenciadordepessoas.common.PersistenceAdapter;
import lombok.RequiredArgsConstructor;

import java.util.List;

@PersistenceAdapter
@RequiredArgsConstructor
public class FindAllPessoaPersistenceAdapter implements FindAllPessoaPort {

    private final PessoaRepositiry pessoaRepositiry;
    private final PessoaPersistenceMapper pessoaPersistenceMapper;

    @Override
    public List<Pessoa> findAll() {
        return pessoaRepositiry.findAll()
                .stream()
                .map(pessoaPersistenceMapper::toDomain)
                .toList();
    }
}
