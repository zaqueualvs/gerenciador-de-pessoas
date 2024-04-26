package com.alves.gerenciadordepessoas.application.domain.exceptions;

public class PessoaNotFoundException extends EntityNotFoundException {

    public PessoaNotFoundException(Long id) {
        super(String.format("Não existe cadastro de pessoa com id %d!", id));
    }
}
