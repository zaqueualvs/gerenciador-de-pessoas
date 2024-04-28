package com.alves.gerenciadordepessoas.application.domain.services.pessoa;

import com.alves.gerenciadordepessoas.application.domain.exceptions.PessoaNotFoundException;
import com.alves.gerenciadordepessoas.application.domain.models.Pessoa;
import com.alves.gerenciadordepessoas.application.ports.out.pessoa.FindPessoaByIdPort;
import org.instancio.Instancio;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class FindPessoaByIdServiceTest {

    @Mock
    private FindPessoaByIdPort findPessoaByIdPort;

    @InjectMocks
    private FindPessoaByIdService findPessoaByIdService;

    @Test
    void findPessoaById_whenExistPessoa() {
        Pessoa pessoa = Instancio.create(Pessoa.class);

        when(findPessoaByIdPort.findById(pessoa.getId())).thenReturn(Optional.of(pessoa));
        Pessoa result = findPessoaByIdService.findById(pessoa.getId());

        verify(findPessoaByIdPort, times(1)).findById(pessoa.getId());
        verifyNoMoreInteractions(findPessoaByIdPort);

        assertEquals(result.getNome(), pessoa.getNome());
        assertEquals(result.getDataNascimento(), pessoa.getDataNascimento());
        assertEquals(result, pessoa);

    }

    @Test
    void findPessoaById_whenDontExistPessoa_ThrowsException() {

        when(findPessoaByIdPort.findById(anyLong())).thenThrow(PessoaNotFoundException.class);

        assertThrows(PessoaNotFoundException.class, () -> findPessoaByIdService.findById(anyLong()));

        verify(findPessoaByIdPort, times(1)).findById(anyLong());
        verifyNoMoreInteractions(findPessoaByIdPort);
    }
}