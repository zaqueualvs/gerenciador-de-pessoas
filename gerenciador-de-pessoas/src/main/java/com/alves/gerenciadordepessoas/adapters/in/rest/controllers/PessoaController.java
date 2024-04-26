package com.alves.gerenciadordepessoas.adapters.in.rest.controllers;

import com.alves.gerenciadordepessoas.adapters.in.rest.data.in.PessoaRequest;
import com.alves.gerenciadordepessoas.adapters.in.rest.data.out.PessoaResponse;
import com.alves.gerenciadordepessoas.adapters.in.rest.mappers.PessoaRestMapper;
import com.alves.gerenciadordepessoas.application.domain.models.Pessoa;
import com.alves.gerenciadordepessoas.application.ports.in.pessoa.FindAllPessoaUseCase;
import com.alves.gerenciadordepessoas.application.ports.in.pessoa.FindPessoaByIdUseCase;
import com.alves.gerenciadordepessoas.application.ports.in.pessoa.SavePessoaUseCase;
import com.alves.gerenciadordepessoas.application.ports.in.pessoa.UpdatePessoaUseCase;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.BeanUtils;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "api/pessoas")
@RequiredArgsConstructor
public class PessoaController {

    private final FindAllPessoaUseCase findAllPessoaUseCase;
    private final FindPessoaByIdUseCase findPessoaByIdUseCase;
    private final SavePessoaUseCase savePessoaUseCase;
    private final UpdatePessoaUseCase updatePessoaUseCase;
    private final PessoaRestMapper pessoaRestMapper;

    @GetMapping
    public ResponseEntity<List<PessoaResponse>> findAll() {

        List<PessoaResponse> pessoaResponseList = findAllPessoaUseCase.findAll()
                .stream()
                .map(pessoaRestMapper::toResponse)
                .toList();

        return ResponseEntity.status(HttpStatus.OK).body(pessoaResponseList);
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<PessoaResponse> findById(@PathVariable Long id) {
        Pessoa pessoa = findPessoaByIdUseCase.findById(id);
        PessoaResponse pessoaResponse = pessoaRestMapper.toResponse(pessoa);

        return ResponseEntity.status(HttpStatus.OK).body(pessoaResponse);
    }

    @PostMapping
    public ResponseEntity<PessoaResponse> save(@RequestBody @Valid PessoaRequest pessoaRequest) {
        Pessoa pessoa = pessoaRestMapper.toDomain(pessoaRequest);
        pessoa = savePessoaUseCase.save(pessoa);
        PessoaResponse pessoaResponse = pessoaRestMapper.toResponse(pessoa);
        return ResponseEntity.status(HttpStatus.OK).body(pessoaResponse);
    }

    @PutMapping(value = "/{id}")
    public ResponseEntity<PessoaResponse> update(@PathVariable Long id,
                                                 @RequestBody @Valid PessoaRequest pessoaRequest) {
        Pessoa pessoa = findPessoaByIdUseCase.findById(id);
        BeanUtils.copyProperties(pessoaRequest, pessoa, "id");
        pessoa = updatePessoaUseCase.update(pessoa);
        PessoaResponse pessoaResponse = pessoaRestMapper.toResponse(pessoa);
        return ResponseEntity.status(HttpStatus.OK).body(pessoaResponse);
    }
}
