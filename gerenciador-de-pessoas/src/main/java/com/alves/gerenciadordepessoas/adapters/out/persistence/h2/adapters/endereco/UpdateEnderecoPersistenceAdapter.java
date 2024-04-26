package com.alves.gerenciadordepessoas.adapters.out.persistence.h2.adapters.endereco;

import com.alves.gerenciadordepessoas.adapters.out.persistence.h2.entities.EnderecoEntity;
import com.alves.gerenciadordepessoas.adapters.out.persistence.h2.mappers.EnderecoPersistenceMapper;
import com.alves.gerenciadordepessoas.adapters.out.persistence.h2.repositories.EnderecoRepository;
import com.alves.gerenciadordepessoas.application.domain.models.Endereco;
import com.alves.gerenciadordepessoas.application.ports.out.endereco.UpdateEnderecoPort;
import com.alves.gerenciadordepessoas.common.PersistenceAdapter;
import lombok.RequiredArgsConstructor;

@PersistenceAdapter
@RequiredArgsConstructor
public class UpdateEnderecoPersistenceAdapter implements UpdateEnderecoPort {

    private final EnderecoPersistenceMapper enderecoPersistenceMapper;
    private final EnderecoRepository enderecoRepository;

    @Override
    public Endereco update(Endereco endereco) {
        EnderecoEntity enderecoEntity = enderecoPersistenceMapper.toEntity(endereco);
        enderecoEntity = enderecoRepository.save(enderecoEntity);
        endereco = enderecoPersistenceMapper.toDomain(enderecoEntity);
        return endereco;
    }
}
