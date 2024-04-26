package com.alves.gerenciadordepessoas.application.domain.exceptions;

public class EnderecoNotFoundException extends EntityNotFoundException {

    public EnderecoNotFoundException(Long id) {
        super(String.format("Não existe cadastro de endereco com id %d!", id));
    }
}
