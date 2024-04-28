package com.alves.gerenciadordepessoas.application.domain.services.endereco;

import com.alves.gerenciadordepessoas.application.domain.models.Endereco;
import com.alves.gerenciadordepessoas.application.ports.out.endereco.UpdateEnderecoPort;
import org.instancio.Instancio;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.test.context.TestExecutionListeners;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class UpdateEnderecoServiceTest {

    @Mock
    private UpdateEnderecoPort updateEnderecoPort;

    @InjectMocks
    private UpdateEnderecoService updateEnderecoService;

    @Test
    void updateEndereco(){
        Endereco endereco = Instancio.create(Endereco.class);

        when(updateEnderecoPort.update(endereco)).thenReturn(endereco);

        Endereco result = updateEnderecoService.update(endereco);
        verify(updateEnderecoPort, times(1)).update(endereco);
        verifyNoMoreInteractions(updateEnderecoPort);
        assertNotNull(result);
        assertEquals(result, endereco);
    }

}