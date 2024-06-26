package com.alves.gerenciadordepessoas.adapters.out.persistence.h2.adapters.pessoa;

import com.alves.gerenciadordepessoas.adapters.out.persistence.h2.entities.PessoaEntity;
import com.alves.gerenciadordepessoas.adapters.out.persistence.h2.mappers.PessoaPersistenceMapper;
import com.alves.gerenciadordepessoas.adapters.out.persistence.h2.repositories.PessoaRepository;
import com.alves.gerenciadordepessoas.application.domain.models.Pessoa;
import com.alves.gerenciadordepessoas.application.ports.out.pessoa.SavePessoaPort;
import com.alves.gerenciadordepessoas.common.PersistenceAdapter;
import lombok.RequiredArgsConstructor;

@PersistenceAdapter
@RequiredArgsConstructor
public class SavePessoaPersistenceAdapter implements SavePessoaPort {

    private final PessoaRepository pessoaRepository;
    private final PessoaPersistenceMapper pessoaPersistenceMapper;

    @Override
    public Pessoa save(Pessoa pessoa) {
        PessoaEntity pessoaEntity = pessoaPersistenceMapper.toEntity(pessoa);
        pessoaEntity = pessoaRepository.save(pessoaEntity);
        pessoa = pessoaPersistenceMapper.toDomain(pessoaEntity);
        return pessoa;
    }
}
