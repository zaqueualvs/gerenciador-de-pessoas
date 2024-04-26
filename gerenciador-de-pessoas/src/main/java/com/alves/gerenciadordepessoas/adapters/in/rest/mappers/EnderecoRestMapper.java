package com.alves.gerenciadordepessoas.adapters.in.rest.mappers;

import com.alves.gerenciadordepessoas.adapters.in.rest.data.in.EnderecoRequest;
import com.alves.gerenciadordepessoas.adapters.in.rest.data.out.EnderecoResponse;
import com.alves.gerenciadordepessoas.application.domain.models.Endereco;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface EnderecoRestMapper {

    Endereco toDomain(EnderecoRequest enderecoRequest);

    EnderecoResponse toResponse(Endereco endereco);
}
