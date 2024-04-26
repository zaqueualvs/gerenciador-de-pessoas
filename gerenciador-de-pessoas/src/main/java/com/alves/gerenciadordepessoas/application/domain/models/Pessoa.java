package com.alves.gerenciadordepessoas.application.domain.models;

import com.alves.gerenciadordepessoas.application.domain.exceptions.EnderecoNotFoundException;

import java.time.LocalDate;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

public class Pessoa {
    private Long id;
    private String nome;
    private LocalDate dataNascimento;
    private Endereco enderecoPrincipal;
    private Set<Endereco> enderecos = new HashSet<>();

    public Pessoa() {
    }

    public Pessoa(Long id, String nome, LocalDate dataNascimento, Endereco enderecoPrincipal, Set<Endereco> enderecos) {
        this.id = id;
        this.nome = nome;
        this.dataNascimento = dataNascimento;
        this.enderecoPrincipal = enderecoPrincipal;
        this.enderecos = enderecos;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public LocalDate getDataNascimento() {
        return dataNascimento;
    }

    public void setDataNascimento(LocalDate dataNascimento) {
        this.dataNascimento = dataNascimento;
    }

    public Endereco getEnderecoPrincipal() {
        return enderecoPrincipal;
    }

    public void setEnderecoPrincipal(Endereco enderecoPrincipal) {
        this.enderecoPrincipal = enderecoPrincipal;
    }

    public Set<Endereco> getEnderecos() {
        return enderecos;
    }

    public void setEnderecos(Set<Endereco> enderecos) {
        this.enderecos = enderecos;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Pessoa pessoa = (Pessoa) o;
        return Objects.equals(id, pessoa.id);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(id);
    }

    public Endereco procurarEndereco(Long enderecoId) {
        return this.getEnderecos().stream().filter(endereco -> Objects.equals(endereco.getId(), enderecoId)).findFirst()
                .orElseThrow(
                        () -> new EnderecoNotFoundException(enderecoId)
                );
    }

    public void mudarEnderecoPrincipal(Long enderecoId) {
        Endereco endereco = procurarEndereco(enderecoId);
        this.setEnderecoPrincipal(endereco);
    }
}
