package com.alves.gerenciadordepessoas.application.domain.services.endereco;

import com.alves.gerenciadordepessoas.application.domain.models.Endereco;
import com.alves.gerenciadordepessoas.application.domain.models.Pessoa;
import com.alves.gerenciadordepessoas.application.ports.in.endereco.FindAllEnderecoByPessoaIdUseCase;
import com.alves.gerenciadordepessoas.application.ports.in.pessoa.FindPessoaByIdUseCase;
import com.alves.gerenciadordepessoas.common.UseCase;
import lombok.RequiredArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@UseCase
@RequiredArgsConstructor
public class FindAllEnderecoByPessoaIdService implements FindAllEnderecoByPessoaIdUseCase {

    private final FindPessoaByIdUseCase findPessoaByIdUseCase;

    @Override
    public List<Endereco> findAll(Long pessoaId) {
        Pessoa pessoa = findPessoaByIdUseCase.findById(pessoaId);

        return new ArrayList<>(pessoa.getEnderecos());
    }
}
