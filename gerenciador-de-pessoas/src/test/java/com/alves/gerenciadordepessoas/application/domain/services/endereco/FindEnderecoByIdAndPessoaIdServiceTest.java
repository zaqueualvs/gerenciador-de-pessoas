package com.alves.gerenciadordepessoas.application.domain.services.endereco;

import com.alves.gerenciadordepessoas.application.domain.exceptions.EnderecoNotFoundException;
import com.alves.gerenciadordepessoas.application.domain.exceptions.PessoaNotFoundException;
import com.alves.gerenciadordepessoas.application.domain.models.Endereco;
import com.alves.gerenciadordepessoas.application.domain.models.Pessoa;
import com.alves.gerenciadordepessoas.application.ports.in.pessoa.FindPessoaByIdUseCase;
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
class FindEnderecoByIdAndPessoaIdServiceTest {

    @Mock
    private FindPessoaByIdUseCase findPessoaByIdUseCase;

    @InjectMocks
    private FindEnderecoByIdAndPessoaIdService findEnderecoByIdAndPessoaIdService;

    @Test
    void findEnderecoById_whenExist_returnEndereco() {
        Endereco endereco = Instancio.create(Endereco.class);
        Pessoa pessoa = Instancio.create(Pessoa.class);
        pessoa.getEnderecos().add(endereco);
        when(findPessoaByIdUseCase.findById(pessoa.getId())).thenReturn(pessoa);

        Endereco result = findEnderecoByIdAndPessoaIdService.findById(endereco.getId(), pessoa.getId());

        verify(findPessoaByIdUseCase, times(1)).findById(pessoa.getId());
        verifyNoMoreInteractions(findPessoaByIdUseCase);

        assertEquals(result, endereco);
    }

    @Test
    void findEnderecoById_whenDontExistEndereco_throwsException() {
        Pessoa pessoa = Instancio.create(Pessoa.class);

        when(findPessoaByIdUseCase.findById(pessoa.getId())).thenReturn(pessoa);

        assertThrows(EnderecoNotFoundException.class, () -> findEnderecoByIdAndPessoaIdService.findById(anyLong(), pessoa.getId()));

        verify(findPessoaByIdUseCase, times(1)).findById(pessoa.getId());
        verifyNoMoreInteractions(findPessoaByIdUseCase);
    }
    @Test
    void findEnderecoById_whenDontExistPessoa_throwsException() {

        when(findPessoaByIdUseCase.findById(anyLong())).thenThrow(PessoaNotFoundException.class);

        assertThrows(PessoaNotFoundException.class, () -> findEnderecoByIdAndPessoaIdService.findById(1l, anyLong()));

        verify(findPessoaByIdUseCase, times(1)).findById(anyLong());
        verifyNoMoreInteractions(findPessoaByIdUseCase);
    }

}