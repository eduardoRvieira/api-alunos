package com.reichelvieira.api_alunos.service;

import com.reichelvieira.api_alunos.model.Aluno;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Service
public class AlunoService {
    private final List<Aluno> alunos;

    public AlunoService(){
        alunos = new ArrayList<>();
        alunos.add(new Aluno(1, "Eduardo", "eduardo@gmail.com", "senha", LocalDate.of(2000, 8, 20), 8.7));
        alunos.add(new Aluno(2, "Ana", "ana@gmail.com", "senha2", LocalDate.of(2001, 9, 11), 10));
        alunos.add(new Aluno(3, "Maria", "maria@gmail.com", "senha3", LocalDate.of(1999, 2, 2), 7));
    }

    public List<Aluno> listarAlunos(){
        return alunos;
    }

    
}
