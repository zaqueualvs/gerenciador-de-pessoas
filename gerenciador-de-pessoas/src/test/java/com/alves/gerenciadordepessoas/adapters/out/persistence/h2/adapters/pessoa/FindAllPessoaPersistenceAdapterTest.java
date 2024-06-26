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

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class FindAllPessoaPersistenceAdapterTest {

    @Mock
    private PessoaRepository pessoaRepository;
    @Mock
    private PessoaPersistenceMapper pessoaPersistenceMapper;

    @InjectMocks
    private FindAllPessoaPersistenceAdapter findAllPessoaPersistenceAdapter;

    @Test
    void findAllPessoa(){
        int totalElement = 21;
        List<PessoaEntity> pessoaEntities =  Instancio.stream(PessoaEntity.class).limit(totalElement).toList();

        when(pessoaRepository.findAll()).thenReturn(pessoaEntities);
        when(pessoaPersistenceMapper.toDomain(any(PessoaEntity.class))).thenReturn(new Pessoa());
        List<Pessoa> result = findAllPessoaPersistenceAdapter.findAll();

        verify(pessoaPersistenceMapper, times(totalElement)).toDomain(any(PessoaEntity.class));
        verify(pessoaRepository, times(1)).findAll();
        verifyNoMoreInteractions(pessoaPersistenceMapper);
        verifyNoMoreInteractions(pessoaRepository);

        assertNotNull(result);
        assertEquals(totalElement, result.size());
    }
}