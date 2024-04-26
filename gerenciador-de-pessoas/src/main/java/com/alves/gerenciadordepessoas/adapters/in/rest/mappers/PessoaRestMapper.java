package com.alves.gerenciadordepessoas.adapters.in.rest.mappers;

import com.alves.gerenciadordepessoas.adapters.in.rest.data.in.PessoaRequest;
import com.alves.gerenciadordepessoas.adapters.in.rest.data.out.PessoaResponse;
import com.alves.gerenciadordepessoas.application.domain.models.Pessoa;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring", uses = {EnderecoRestMapper.class})
public interface PessoaRestMapper {

    Pessoa toDomain(PessoaRequest pessoaRequest);

    PessoaResponse toResponse(Pessoa pessoa);
}
