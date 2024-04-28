package com.alves.gerenciadordepessoas.application.domain.services.endereco;

import com.alves.gerenciadordepessoas.application.domain.models.Endereco;
import com.alves.gerenciadordepessoas.application.domain.models.Pessoa;
import com.alves.gerenciadordepessoas.application.ports.in.pessoa.FindPessoaByIdUseCase;
import org.instancio.Instancio;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class FindAllEnderecoByPessoaIdServiceTest {

    @Mock
    private FindPessoaByIdUseCase findPessoaByIdUseCase;

    @InjectMocks
    private FindAllEnderecoByPessoaIdService findAllEnderecoByPessoaIdService;

    @Test
    void findAllEnderecoFromPessoa() {
        Pessoa pessoa = Instancio.create(Pessoa.class);
        when(findPessoaByIdUseCase.findById(pessoa.getId())).thenReturn(pessoa);
        List<Endereco> enderecos = findAllEnderecoByPessoaIdService.findAll(pessoa.getId());
        verify(findPessoaByIdUseCase, times(1)).findById(pessoa.getId());
        verifyNoMoreInteractions(findPessoaByIdUseCase);
        assertEquals(enderecos.size(), pessoa.getEnderecos().size());

    }

}