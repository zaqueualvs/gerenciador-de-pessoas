package com.alves.gerenciadordepessoas.adapters.out.persistence.h2.repositories;

import com.alves.gerenciadordepessoas.adapters.out.persistence.h2.entities.EnderecoEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EnderecoRepository extends JpaRepository<EnderecoEntity, Long> {
}
