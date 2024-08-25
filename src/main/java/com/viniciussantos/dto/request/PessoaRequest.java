package com.viniciussantos.dto.request;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.viniciussantos.model.Tarefa;
import lombok.*;

import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class PessoaRequest {
    Long id;
    String nome;
    String departamento;
    @JsonIgnore
    List<Tarefa> tarefas;


}
