package com.alves.gerenciadordepessoas.application.domain.services.pessoa;

import com.alves.gerenciadordepessoas.application.domain.models.Pessoa;
import com.alves.gerenciadordepessoas.application.ports.out.pessoa.UpdatePessoaPort;
import org.instancio.Instancio;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class UpdatePessoaServiceTest {

    @Mock
    private UpdatePessoaPort updatePessoaPort;

    @InjectMocks
    private UpdatePessoaService updatePessoaService;

    @Test
    void updatePessoa() {
        Pessoa pessoa = Instancio.create(Pessoa.class);

        when(updatePessoaPort.update(pessoa)).thenReturn(pessoa);

        Pessoa result = updatePessoaService.update(pessoa);
        verify(updatePessoaPort, times(1)).update(pessoa);
        verifyNoMoreInteractions(updatePessoaPort);
        assertNotNull(result);
        assertEquals(result, pessoa);
    }

}