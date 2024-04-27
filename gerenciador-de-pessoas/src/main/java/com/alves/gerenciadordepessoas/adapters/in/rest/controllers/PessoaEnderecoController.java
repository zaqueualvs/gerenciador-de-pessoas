package com.alves.gerenciadordepessoas.adapters.in.rest.controllers;

import com.alves.gerenciadordepessoas.adapters.in.rest.data.in.EnderecoRequest;
import com.alves.gerenciadordepessoas.adapters.in.rest.data.out.EnderecoResponse;
import com.alves.gerenciadordepessoas.adapters.in.rest.data.out.PessoaResponse;
import com.alves.gerenciadordepessoas.adapters.in.rest.mappers.EnderecoRestMapper;
import com.alves.gerenciadordepessoas.adapters.in.rest.mappers.PessoaRestMapper;
import com.alves.gerenciadordepessoas.application.domain.models.Endereco;
import com.alves.gerenciadordepessoas.application.domain.models.Pessoa;
import com.alves.gerenciadordepessoas.application.ports.in.endereco.*;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.BeanUtils;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "api/pessoas/{pessoaId}/enderecos")
@RequiredArgsConstructor
public class PessoaEnderecoController {

    private final UpdateEnderecoPrincipalPessoaUseCase updateEnderecoPrincipalPessoaUseCase;
    private final FindEnderecoByIdAndPessoaIdUseCase findEnderecoByIdAndPessoaIdUseCase;
    private final FindAllEnderecoByPessoaIdUseCase findAllEnderecoByPessoaIdUseCase;
    private final UpdateEnderecoUseCase updateEnderecoByIdAndPessoaIdUseCase;
    private final SaveEnderecoInPessoaUseCase saveEnderecoInPessoaUseCase;
    private final EnderecoRestMapper enderecoRestMapper;
    private final PessoaRestMapper pessoaRestMapper;

    @PostMapping()
    public ResponseEntity<PessoaResponse> saveEndereco(
            @PathVariable Long pessoaId,
            @RequestBody @Valid EnderecoRequest enderecoRequest) {
        Endereco endereco = enderecoRestMapper.toDomain(enderecoRequest);
        Pessoa pessoa = saveEnderecoInPessoaUseCase.save(endereco, pessoaId);
        return ResponseEntity.ok().body(pessoaRestMapper.toResponse(pessoa));

    }

    @GetMapping
    public ResponseEntity<List<EnderecoResponse>> findAllEnderecoByPessoaId(
            @PathVariable Long pessoaId) {

        List<EnderecoResponse> enderecoResponseList = findAllEnderecoByPessoaIdUseCase
                .findAll(pessoaId)
                .stream()
                .map(enderecoRestMapper::toResponse)
                .toList();

        return ResponseEntity.ok().body(enderecoResponseList);

    }

    @GetMapping(value = "/{enderecoId}")
    public ResponseEntity<EnderecoResponse> saveEndereco(
            @PathVariable Long pessoaId,
            @PathVariable Long enderecoId) {
        Endereco endereco = findEnderecoByIdAndPessoaIdUseCase.findById(enderecoId, pessoaId);
        EnderecoResponse enderecoResponse = enderecoRestMapper.toResponse(endereco);
        return ResponseEntity.ok().body(enderecoResponse);
    }

    @PutMapping(value = "/{enderecoId}")
    public ResponseEntity<EnderecoResponse> editEndereco(
            @PathVariable Long pessoaId,
            @PathVariable Long enderecoId,
            @RequestBody @Valid EnderecoRequest enderecoRequest) {
        Endereco endereco = findEnderecoByIdAndPessoaIdUseCase.findById(enderecoId, pessoaId);
        BeanUtils.copyProperties(enderecoRequest, endereco, "id");
        endereco = updateEnderecoByIdAndPessoaIdUseCase.update(endereco);
        EnderecoResponse enderecoResponse = enderecoRestMapper.toResponse(endereco);
        return ResponseEntity.ok().body(enderecoResponse);
    }

    @PutMapping(value = "/{enderecoId}/principal")
    public ResponseEntity<EnderecoResponse> editEnderecoPrincipal(
            @PathVariable Long pessoaId,
            @PathVariable Long enderecoId) {
        Endereco endereco = updateEnderecoPrincipalPessoaUseCase.update(enderecoId, pessoaId);
        EnderecoResponse enderecoResponse = enderecoRestMapper.toResponse(endereco);
        return ResponseEntity.ok().body(enderecoResponse);
    }
}
