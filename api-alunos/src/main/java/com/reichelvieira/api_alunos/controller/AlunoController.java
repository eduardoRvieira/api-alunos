package com.reichelvieira.api_alunos.controller;

import com.reichelvieira.api_alunos.model.Aluno;
import com.reichelvieira.api_alunos.service.AlunoService;
import org.springframework.web.bind.annotation.GetMapping;
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
    public List<Aluno> listarAlunos(){
        return service.listarAlunos();
    }
}
