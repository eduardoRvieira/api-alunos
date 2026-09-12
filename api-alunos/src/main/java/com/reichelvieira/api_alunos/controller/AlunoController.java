package com.reichelvieira.api_alunos.controller;

import com.reichelvieira.api_alunos.dto.AlunoResponse;
import com.reichelvieira.api_alunos.model.Aluno;
import com.reichelvieira.api_alunos.service.AlunoService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.List;

@RestController
@RequestMapping("/alunos")
public class AlunoController {

    private final AlunoService service;

    public AlunoController(AlunoService service){
        this.service = service;
    }

    @GetMapping
    public List<AlunoResponse> listarAlunos(){
        return service.listarAlunos();
    }

    @GetMapping("/{id}")
    public Aluno obterAlunoPorId(@PathVariable int id){
        return service.obterAlunoPorId(id);
    }
}
