package com.alves.gerenciadordepessoas.adapters.out.persistence.h2.adapters.endereco;

import com.alves.gerenciadordepessoas.adapters.out.persistence.h2.entities.EnderecoEntity;
import com.alves.gerenciadordepessoas.adapters.out.persistence.h2.mappers.EnderecoPersistenceMapper;
import com.alves.gerenciadordepessoas.adapters.out.persistence.h2.repositories.EnderecoRepository;
import com.alves.gerenciadordepessoas.application.domain.models.Endereco;
import org.instancio.Instancio;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class UpdateEnderecoPersistenceAdapterTest {

    @Mock
    private EnderecoPersistenceMapper enderecoPersistenceMapper;
    @Mock
    private EnderecoRepository enderecoRepository;

    @InjectMocks
    private UpdateEnderecoPersistenceAdapter updateEnderecoPersistenceAdapter;

    @Test
    void updateEndereco() {
        Endereco endereco = Instancio.create(Endereco.class);
        EnderecoEntity enderecoEntity = new EnderecoEntity(
                endereco.getId(),
                endereco.getLogradouro(),
                endereco.getCep(),
                endereco.getNumero(),
                endereco.getCidade(),
                endereco.getEstado());

        when(enderecoPersistenceMapper.toEntity(endereco)).thenReturn(enderecoEntity);
        when(enderecoRepository.save(enderecoEntity)).thenReturn(enderecoEntity);
        when(enderecoPersistenceMapper.toDomain(enderecoEntity)).thenReturn(endereco);

        Endereco result = updateEnderecoPersistenceAdapter.update(endereco);

        assertNotNull(result);
    }

}