package com.alves.gerenciadordepessoas.adapters.out.persistence.h2.mappers;

import com.alves.gerenciadordepessoas.adapters.out.persistence.h2.entities.EnderecoEntity;
import com.alves.gerenciadordepessoas.application.domain.models.Endereco;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface EnderecoPersistenceMapper {

    EnderecoEntity toEntity(Endereco endereco);

    Endereco toDomain(EnderecoEntity enderecoEntity);

}
