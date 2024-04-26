package com.alves.gerenciadordepessoas.adapters.out.persistence.h2.mappers;

import com.alves.gerenciadordepessoas.adapters.out.persistence.h2.entities.PessoaEntity;
import com.alves.gerenciadordepessoas.application.domain.models.Pessoa;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring", uses = {EnderecoPersistenceMapper.class})
public interface PessoaPersistenceMapper {

    PessoaEntity toEntity(Pessoa pessoa);

    Pessoa toDomain(PessoaEntity pessoaEntity);

}
