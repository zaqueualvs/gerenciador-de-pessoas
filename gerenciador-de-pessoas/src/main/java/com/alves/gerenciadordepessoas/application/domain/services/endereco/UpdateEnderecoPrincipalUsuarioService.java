package com.alves.gerenciadordepessoas.application.domain.services.endereco;

import com.alves.gerenciadordepessoas.application.domain.models.Endereco;
import com.alves.gerenciadordepessoas.application.domain.models.Pessoa;
import com.alves.gerenciadordepessoas.application.ports.in.endereco.UpdateEnderecoPrincipalUsuarioUseCase;
import com.alves.gerenciadordepessoas.application.ports.in.pessoa.FindPessoaByIdUseCase;
import com.alves.gerenciadordepessoas.application.ports.in.pessoa.UpdatePessoaUseCase;
import com.alves.gerenciadordepessoas.common.UseCase;
import lombok.RequiredArgsConstructor;

@UseCase
@RequiredArgsConstructor
public class UpdateEnderecoPrincipalUsuarioService implements UpdateEnderecoPrincipalUsuarioUseCase {

    private final UpdatePessoaUseCase updatePessoaUseCase;
    private final FindPessoaByIdUseCase findPessoaByIdUseCase;

    @Override
    public Endereco update(Long enderecoId, Long pessoaId) {
        Pessoa pessoa = findPessoaByIdUseCase.findById(pessoaId);
        pessoa.mudarEnderecoPrincipal(enderecoId);

        pessoa = updatePessoaUseCase.update(pessoa);
        return pessoa.getEnderecoPrincipal();
    }
}
