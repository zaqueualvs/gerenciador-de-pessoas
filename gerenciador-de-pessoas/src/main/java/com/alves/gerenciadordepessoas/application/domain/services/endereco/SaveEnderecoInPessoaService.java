package com.alves.gerenciadordepessoas.application.domain.services.endereco;

import com.alves.gerenciadordepessoas.application.domain.models.Endereco;
import com.alves.gerenciadordepessoas.application.domain.models.Pessoa;
import com.alves.gerenciadordepessoas.application.ports.in.endereco.SaveEnderecoInPessoaUseCase;
import com.alves.gerenciadordepessoas.application.ports.in.pessoa.FindPessoaByIdUseCase;
import com.alves.gerenciadordepessoas.application.ports.in.pessoa.UpdatePessoaUseCase;
import com.alves.gerenciadordepessoas.common.UseCase;
import lombok.RequiredArgsConstructor;

@UseCase
@RequiredArgsConstructor
public class SaveEnderecoInPessoaService implements SaveEnderecoInPessoaUseCase {

    private final UpdatePessoaUseCase updatePessoaUseCase;
    private final FindPessoaByIdUseCase findPessoaByIdUseCase;

    @Override
    public Pessoa save(Endereco endereco, Long pessoaId) {
        Pessoa pessoa = findPessoaByIdUseCase.findById(pessoaId);
        pessoa.getEnderecos().add(endereco);
        pessoa = updatePessoaUseCase.update(pessoa);
        return pessoa;
    }
}
