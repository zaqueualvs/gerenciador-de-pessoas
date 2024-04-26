package com.alves.gerenciadordepessoas.application.domain.services.endereco;

import com.alves.gerenciadordepessoas.application.domain.models.Endereco;
import com.alves.gerenciadordepessoas.application.domain.models.Pessoa;
import com.alves.gerenciadordepessoas.application.ports.in.endereco.FindEnderecoByIdAndPessoaIdUseCase;
import com.alves.gerenciadordepessoas.application.ports.in.pessoa.FindPessoaByIdUseCase;
import com.alves.gerenciadordepessoas.common.UseCase;
import lombok.RequiredArgsConstructor;

@UseCase
@RequiredArgsConstructor
public class FindEnderecoByIdAndPessoaIdService implements FindEnderecoByIdAndPessoaIdUseCase {

    private final FindPessoaByIdUseCase findPessoaByIdUseCase;

    @Override
    public Endereco findById(Long enderecoId, Long pessoaId) {
        Pessoa pessoa = findPessoaByIdUseCase.findById(pessoaId);
        return pessoa.procurarEndereco(enderecoId);
    }
}
