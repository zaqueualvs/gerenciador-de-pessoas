package com.alves.gerenciadordepessoas.application.domain.services.endereco;

import com.alves.gerenciadordepessoas.application.domain.exceptions.PessoaNotFoundException;
import com.alves.gerenciadordepessoas.application.domain.models.Endereco;
import com.alves.gerenciadordepessoas.application.domain.models.Pessoa;
import com.alves.gerenciadordepessoas.application.ports.in.pessoa.FindPessoaByIdUseCase;
import com.alves.gerenciadordepessoas.application.ports.in.pessoa.UpdatePessoaUseCase;
import org.instancio.Instancio;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class SaveEnderecoInPessoaServiceTest {

    @Mock
    private FindPessoaByIdUseCase findPessoaByIdUseCase;
    @Mock
    private UpdatePessoaUseCase updatePessoaUseCase;

    @InjectMocks
    private SaveEnderecoInPessoaService saveEnderecoInPessoaService;

    @Test
    void saveEnderecoInPessoa() {
        Endereco endereco = Instancio.create(Endereco.class);
        Pessoa pessoa = Instancio.create(Pessoa.class);

        when(findPessoaByIdUseCase.findById(pessoa.getId())).thenReturn(pessoa);

        when(updatePessoaUseCase.update(pessoa)).thenReturn(pessoa);

        Pessoa result = saveEnderecoInPessoaService.save(endereco, pessoa.getId());
        verify(findPessoaByIdUseCase, times(1)).findById(pessoa.getId());
        verify(updatePessoaUseCase,times(1)).update(pessoa);
        verifyNoMoreInteractions(findPessoaByIdUseCase);
        verifyNoMoreInteractions(updatePessoaUseCase);

        assertNotNull(endereco);
        assertNotNull(result.procurarEndereco(endereco.getId()));
        assertEquals(result.procurarEndereco(endereco.getId()), endereco);
    }

    @Test
    void saveEnderecoInPessoa_whenDontExistPessoa_throwsException() {

        Endereco endereco = Instancio.create(Endereco.class);
        when(findPessoaByIdUseCase.findById(anyLong())).thenThrow(PessoaNotFoundException.class);

        assertThrows(PessoaNotFoundException.class, () -> saveEnderecoInPessoaService.save(endereco, anyLong()));

        verify(findPessoaByIdUseCase, times(1)).findById(anyLong());
        verifyNoMoreInteractions(findPessoaByIdUseCase);
    }

}