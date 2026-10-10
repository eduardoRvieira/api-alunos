package com.reichelvieira.api_alunos.service;

import com.reichelvieira.api_alunos.dto.AlunoRequest;
import com.reichelvieira.api_alunos.dto.AlunoResponse;
import com.reichelvieira.api_alunos.exception.EmailJaCadastradoException;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;

public class AlunoServiceTest {

    private AlunoService service;

    @BeforeEach
    void setUp(){
        service = new AlunoService();
    }

    @Test
    void deveCadastrarAlunoQuandoDadosForemValidos(){

        // Arrange
        //service = new AlunoService();
        AlunoRequest request = new AlunoRequest("Eduardo", "eduardo@gmail.com", "1234", LocalDate.of(2005, 7, 5), 8);

        // Act
        AlunoResponse response = service.cadastrarAluno(request);

        //Assert
        Assertions.assertThat(response).isNotNull();
        Assertions.assertThat(response.getId()).isGreaterThan(0);

    }

    @Test
    void deveRetornarExcecaoQuandoReceberEmailRepetidoNaRequisicao(){
        //service = new AlunoService();
        AlunoRequest request1 = new AlunoRequest("Eduardo", "eduardo@gmail.com", "1234", LocalDate.of(2005, 7, 5), 8);
        AlunoRequest request2 = new AlunoRequest("Eduardo", "eduardo@gmail.com", "1234", LocalDate.of(2005, 7, 5), 10);

        service.cadastrarAluno(request1);

        Assertions.assertThatThrownBy(() -> service.cadastrarAluno(request2))
                .isInstanceOf(EmailJaCadastradoException.class);
    }
}
