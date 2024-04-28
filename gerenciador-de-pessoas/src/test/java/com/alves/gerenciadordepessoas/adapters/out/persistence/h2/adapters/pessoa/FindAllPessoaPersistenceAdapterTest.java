package com.alves.gerenciadordepessoas.adapters.out.persistence.h2.adapters.pessoa;

import com.alves.gerenciadordepessoas.adapters.out.persistence.h2.entities.PessoaEntity;
import com.alves.gerenciadordepessoas.adapters.out.persistence.h2.mappers.PessoaPersistenceMapper;
import com.alves.gerenciadordepessoas.adapters.out.persistence.h2.repositories.PessoaRepositiry;
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
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class FindAllPessoaPersistenceAdapterTest {

    @Mock
    private PessoaRepositiry pessoaRepositiry;
    @Mock
    private PessoaPersistenceMapper pessoaPersistenceMapper;

    @InjectMocks
    private FindAllPessoaPersistenceAdapter findAllPessoaPersistenceAdapter;

    @Test
    void findAllPessoa(){
        List<PessoaEntity> pessoaEntities = Instancio.stream(PessoaEntity.class).limit(12).toList();

        when(pessoaRepositiry.findAll()).thenReturn(pessoaEntities);
        List<Pessoa> result = findAllPessoaPersistenceAdapter.findAll();

        assertNotNull(result);
    }
}