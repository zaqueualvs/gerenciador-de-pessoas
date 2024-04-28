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

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class SavePessoaPersistenceAdapterTest {

    @Mock
    private PessoaRepository pessoaRepository;
    @Mock
    private PessoaPersistenceMapper pessoaPersistenceMapper;

    @InjectMocks
    private SavePessoaPersistenceAdapter savePessoaPersistenceAdapter;

    @Test
    void savePessoa(){
        Pessoa pessoa = Instancio.create(Pessoa.class);
        PessoaEntity pessoaEntity = new PessoaEntity();

        when(pessoaRepository.save(pessoaEntity)).thenReturn(pessoaEntity);
        when(pessoaPersistenceMapper.toDomain(pessoaEntity)).thenReturn(pessoa);
        when(pessoaPersistenceMapper.toEntity(pessoa)).thenReturn(pessoaEntity);

        Pessoa result = savePessoaPersistenceAdapter.save(pessoa);

        verify(pessoaRepository, times(1)).save(any(PessoaEntity.class));
        verify(pessoaPersistenceMapper, times(1)).toDomain(any(PessoaEntity.class));
        verify(pessoaPersistenceMapper, times(1)).toEntity(any(Pessoa.class));
        verifyNoMoreInteractions(pessoaRepository);
        verifyNoMoreInteractions(pessoaPersistenceMapper);

        assertNotNull(result);
    }

}