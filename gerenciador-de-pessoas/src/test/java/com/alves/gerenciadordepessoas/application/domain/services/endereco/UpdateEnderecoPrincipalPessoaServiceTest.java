package com.alves.gerenciadordepessoas.application.domain.services.endereco;

import com.alves.gerenciadordepessoas.application.domain.exceptions.EnderecoNotFoundException;
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
import static org.mockito.Mockito.verifyNoMoreInteractions;

@ExtendWith(MockitoExtension.class)
class UpdateEnderecoPrincipalPessoaServiceTest {

    @Mock
    private UpdatePessoaUseCase updatePessoaUseCase;
    @Mock
    private FindPessoaByIdUseCase findPessoaByIdUseCase;

    @InjectMocks
    private UpdateEnderecoPrincipalPessoaService updateEnderecoPrincipalPessoaService;

    @Test
    void updateEnderecoPrincipalInPessoa(){
        Endereco endereco = Instancio.create(Endereco.class);
        Pessoa pessoa = Instancio.create(Pessoa.class);
        pessoa.getEnderecos().add(endereco);

        when(findPessoaByIdUseCase.findById(pessoa.getId())).thenReturn(pessoa);

        when(updatePessoaUseCase.update(pessoa)).thenReturn(pessoa);

        Endereco result = updateEnderecoPrincipalPessoaService.update(endereco.getId(), pessoa.getId());
        verify(findPessoaByIdUseCase, times(1)).findById(pessoa.getId());
        verify(updatePessoaUseCase,times(1)).update(pessoa);
        verifyNoMoreInteractions(findPessoaByIdUseCase);
        verifyNoMoreInteractions(updatePessoaUseCase);

        assertNotNull(result);
        assertEquals(result, pessoa.getEnderecoPrincipal());
    }
    @Test
    void updateEnderecoPrincipalInPessoa_whenDontExistPessoa_throwsException(){
        Endereco endereco = Instancio.create(Endereco.class);

        when(findPessoaByIdUseCase.findById(anyLong())).thenThrow(PessoaNotFoundException.class);

        assertThrows(PessoaNotFoundException.class, () -> updateEnderecoPrincipalPessoaService.update(endereco.getId(), anyLong()));
        verify(findPessoaByIdUseCase, times(1)).findById(anyLong());
        verify(updatePessoaUseCase,times(0)).update(any());
        verifyNoMoreInteractions(findPessoaByIdUseCase);
        verifyNoMoreInteractions(updatePessoaUseCase);
    }
    @Test
    void updateEnderecoPrincipalInPessoa_whenDontExistEndereco_throwsException(){
        Pessoa pessoa = Instancio.create(Pessoa.class);
        when(findPessoaByIdUseCase.findById(pessoa.getId())).thenReturn(pessoa);

        assertThrows(EnderecoNotFoundException.class, () -> updateEnderecoPrincipalPessoaService.update(anyLong(), pessoa.getId()));
        verify(findPessoaByIdUseCase, times(1)).findById(pessoa.getId());
        verify(updatePessoaUseCase,times(0)).update(any());
        verifyNoMoreInteractions(findPessoaByIdUseCase);
        verifyNoMoreInteractions(updatePessoaUseCase);
    }
}