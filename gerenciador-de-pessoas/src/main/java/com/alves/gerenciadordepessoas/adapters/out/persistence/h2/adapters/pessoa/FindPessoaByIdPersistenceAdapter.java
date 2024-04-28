package com.alves.gerenciadordepessoas.adapters.out.persistence.h2.adapters.pessoa;

import com.alves.gerenciadordepessoas.adapters.out.persistence.h2.entities.PessoaEntity;
import com.alves.gerenciadordepessoas.adapters.out.persistence.h2.mappers.PessoaPersistenceMapper;
import com.alves.gerenciadordepessoas.adapters.out.persistence.h2.repositories.PessoaRepository;
import com.alves.gerenciadordepessoas.application.domain.models.Pessoa;
import com.alves.gerenciadordepessoas.application.ports.out.pessoa.FindPessoaByIdPort;
import com.alves.gerenciadordepessoas.common.PersistenceAdapter;
import lombok.RequiredArgsConstructor;

import java.util.Optional;

@PersistenceAdapter
@RequiredArgsConstructor
public class FindPessoaByIdPersistenceAdapter implements FindPessoaByIdPort {

    private final PessoaRepository pessoaRepository;
    private final PessoaPersistenceMapper pessoaPersistenceMapper;

    @Override
    public Optional<Pessoa> findById(Long id) {
        Optional<PessoaEntity> pessoaEntityOptional = pessoaRepository.findById(id);

        if (pessoaEntityOptional.isEmpty()) {
            return Optional.empty();
        }
        Pessoa pessoa = pessoaPersistenceMapper.toDomain(pessoaEntityOptional.get());

        return Optional.of(pessoa);
    }
}
