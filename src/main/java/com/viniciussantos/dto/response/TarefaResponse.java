package com.viniciussantos.dto.response;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.viniciussantos.model.Pessoa;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.Duration;
import java.time.LocalDate;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class TarefaResponse {
    private Long id;
    private String titulo;
    private String descricao;
    private LocalDate prazo;
    private String departamento;
    private Integer duracao;
    @JsonIgnoreProperties(value = {"tarefas"})
    private Pessoa pessoaAlocada;
    private String status ;


}
