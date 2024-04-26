package com.alves.gerenciadordepessoas.adapters.out.persistence.h2.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "pessoa")
public class PessoaEntity{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nome;
    private LocalDate dataNascimento;
    @ManyToOne
    private EnderecoEntity enderecoPrincipal;
    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(name = "pessoa_endereco",
            joinColumns = @JoinColumn(name = "pessoa_id"),
            inverseJoinColumns = @JoinColumn(name = "endereco_id"))
    private Set<EnderecoEntity> enderecos = new HashSet<>();
}
