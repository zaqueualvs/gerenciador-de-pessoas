package com.alves.gerenciadordepessoas.adapters.out.persistence.h2.repositories;

import com.alves.gerenciadordepessoas.adapters.out.persistence.h2.entities.PessoaEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PessoaRepositiry extends JpaRepository<PessoaEntity, Long> {
}
