package com.alves.gerenciadordepessoas.application.domain.services.pessoa;

import com.alves.gerenciadordepessoas.application.domain.models.Pessoa;
import com.alves.gerenciadordepessoas.application.ports.out.pessoa.FindAllPessoaPort;
import org.instancio.Instancio;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class FindAllPessoaServiceTest {

    @Mock
    private FindAllPessoaPort findAllPessoaPort;

    @InjectMocks
    private FindAllPessoaService findAllPessoaService;

    @Test
    void findAllPessoa_whenHaveObjects() {
        List<Pessoa> pessoaList = Instancio.stream(Pessoa.class).limit(10).toList();
        when(findAllPessoaPort.findAll()).thenReturn(pessoaList);
        List<Pessoa> result = findAllPessoaService.findAll();
        verify(findAllPessoaPort, times(1)).findAll();
        verifyNoMoreInteractions(findAllPessoaPort);
        assertEquals(10, pessoaList.size());
    }

}