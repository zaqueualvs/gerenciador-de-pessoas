package com.alves.gerenciadordepessoas.adapters.out.persistence.h2.adapters.endereco;

import com.alves.gerenciadordepessoas.adapters.out.persistence.h2.entities.EnderecoEntity;
import com.alves.gerenciadordepessoas.adapters.out.persistence.h2.mappers.EnderecoPersistenceMapper;
import com.alves.gerenciadordepessoas.adapters.out.persistence.h2.mappers.EnderecoPersistenceMapperImpl;
import com.alves.gerenciadordepessoas.adapters.out.persistence.h2.repositories.EnderecoRepository;
import com.alves.gerenciadordepessoas.application.domain.models.Endereco;
import org.instancio.Instancio;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Spy;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

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
        EnderecoEntity enderecoEntity = Instancio.create(EnderecoEntity.class);

        when(enderecoPersistenceMapper.toDomain(enderecoEntity)).thenReturn(endereco);
        when(enderecoPersistenceMapper.toEntity(endereco)).thenReturn(enderecoEntity);
        when(enderecoRepository.save(enderecoEntity)).thenReturn(enderecoEntity);

        Endereco result = updateEnderecoPersistenceAdapter.update(endereco);
        verify(enderecoPersistenceMapper, times(1)).toDomain(enderecoEntity);
        verify(enderecoPersistenceMapper, times(1)).toEntity(endereco);
        verify(enderecoRepository, times(1)).save(enderecoEntity);
        verifyNoMoreInteractions(enderecoPersistenceMapper);
        verifyNoMoreInteractions(enderecoRepository);

        assertNotNull(result);
    }
}