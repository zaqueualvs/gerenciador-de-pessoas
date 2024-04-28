package com.alves.gerenciadordepessoas.adapters.out.persistence.h2.adapters.pessoa;

import com.alves.gerenciadordepessoas.adapters.out.persistence.h2.entities.PessoaEntity;
import com.alves.gerenciadordepessoas.application.domain.models.Pessoa;
import com.alves.gerenciadordepessoas.application.ports.out.pessoa.SavePessoaPort;
import org.instancio.Instancio;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class UpdatePessoaPersistenceAdapterTest {

    @Mock
    private SavePessoaPort savePessoaPort;

    @InjectMocks
    private UpdatePessoaPersistenceAdapter updatePessoaPersistenceAdapter;

    @Test
    void updatePessoa() {
        Pessoa pessoa = Instancio.create(Pessoa.class);

        when(savePessoaPort.save(pessoa)).thenReturn(pessoa);

        Pessoa result = updatePessoaPersistenceAdapter.update(pessoa);
        verify(savePessoaPort, times(1)).save(pessoa);
        verifyNoMoreInteractions(savePessoaPort);

        assertNotNull(result);
        assertEquals(result, pessoa);
    }
}