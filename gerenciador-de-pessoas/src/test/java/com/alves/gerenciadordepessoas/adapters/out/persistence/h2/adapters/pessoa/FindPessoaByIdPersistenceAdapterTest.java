package com.alves.gerenciadordepessoas.adapters.out.persistence.h2.adapters.pessoa;

import com.alves.gerenciadordepessoas.adapters.out.persistence.h2.entities.PessoaEntity;
import com.alves.gerenciadordepessoas.adapters.out.persistence.h2.mappers.PessoaPersistenceMapper;
import com.alves.gerenciadordepessoas.adapters.out.persistence.h2.repositories.PessoaRepository;
import com.alves.gerenciadordepessoas.application.domain.models.Pessoa;
import org.instancio.Instancio;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class FindPessoaByIdPersistenceAdapterTest {

    @Mock
    private PessoaRepository pessoaRepository;
    @Mock
    private PessoaPersistenceMapper pessoaPersistenceMapper;

    @InjectMocks
    private FindPessoaByIdPersistenceAdapter findPessoaByIdPersistenceAdapter;

    @Test
    void findPessoaById_whenItExits_returnPessoa() {
        PessoaEntity pessoaEntity = Instancio.create(PessoaEntity.class);

        when(pessoaRepository.findById(pessoaEntity.getId())).thenReturn(Optional.of(pessoaEntity));
        when(pessoaPersistenceMapper.toDomain(pessoaEntity)).thenReturn(new Pessoa());

        Optional<Pessoa> result = findPessoaByIdPersistenceAdapter.findById(pessoaEntity.getId());
        verify(pessoaRepository, times(1)).findById(anyLong());
        verify(pessoaPersistenceMapper, times(1)).toDomain(any(PessoaEntity.class));
        verifyNoMoreInteractions(pessoaRepository);
        verifyNoMoreInteractions(pessoaPersistenceMapper);

        assertTrue(result.isPresent());
    }
    @Test
    void findPessoaById_whenItDoesntExit_returnNull() {

        when(pessoaRepository.findById(anyLong())).thenReturn(Optional.empty());

        Optional<Pessoa> result = findPessoaByIdPersistenceAdapter.findById(anyLong());
        verify(pessoaRepository, times(1)).findById(anyLong());
        verify(pessoaPersistenceMapper, times(0)).toDomain(any(PessoaEntity.class));
        verifyNoMoreInteractions(pessoaRepository);
        verifyNoMoreInteractions(pessoaPersistenceMapper);

        assertTrue(result.isEmpty());
    }


}