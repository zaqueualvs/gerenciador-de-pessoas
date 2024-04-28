package com.alves.gerenciadordepessoas.application.domain.services.pessoa;

import com.alves.gerenciadordepessoas.application.domain.models.Pessoa;
import com.alves.gerenciadordepessoas.application.ports.out.pessoa.SavePessoaPort;
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
class SavePessoaServiceTest {

    @Mock
    private SavePessoaPort savePessoaPort;

    @InjectMocks
    SavePessoaService savePessoaService;

    @Test
    void savePessoa() {
        Pessoa pessoa = Instancio.create(Pessoa.class);

        when(savePessoaPort.save(pessoa)).thenReturn(pessoa);

        Pessoa result = savePessoaService.save(pessoa);
        verify(savePessoaPort, times(1)).save(pessoa);
        verifyNoMoreInteractions(savePessoaPort);
        assertNotNull(result);
        assertEquals(result, pessoa);
    }

}