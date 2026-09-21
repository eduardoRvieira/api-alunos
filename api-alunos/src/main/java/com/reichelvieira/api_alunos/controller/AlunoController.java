package com.reichelvieira.api_alunos.controller;

import com.reichelvieira.api_alunos.dto.AlunoRequest;
import com.reichelvieira.api_alunos.dto.AlunoResponse;
import com.reichelvieira.api_alunos.model.Aluno;
import com.reichelvieira.api_alunos.service.AlunoService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/alunos")
public class AlunoController {

    private final AlunoService service;

    public AlunoController(AlunoService service) {
        this.service = service;
    }

    @GetMapping
    public ResponseEntity<List<AlunoResponse>> listarAlunos() {
        return ResponseEntity.status(HttpStatus.OK).body(service.listarAlunos());
    }

    @GetMapping("/{id}")
    public ResponseEntity<AlunoResponse> obterAlunoPorId(@PathVariable int id) {
        return ResponseEntity.status(HttpStatus.OK).body(service.obterAlunoPorId(id));
    }

    @PostMapping
    public ResponseEntity<AlunoResponse> cadastrarAluno(@Valid @RequestBody AlunoRequest request) {
        return ResponseEntity.status(HttpStatus.CREATED).body(service.cadastrarAluno(request));
    }

    @PutMapping("/{id}")
    public ResponseEntity<AlunoResponse> atualizarAluno(@PathVariable int id,
                                                        @Valid @RequestBody AlunoRequest request) {
        return ResponseEntity.status(HttpStatus.OK).body(service.atualizarAluno(id, request));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> excluirAluno(@PathVariable int id) {
        service.excluirAluno(id);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }

}