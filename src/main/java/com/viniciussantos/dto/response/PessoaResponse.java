package com.viniciussantos.dto.response;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.viniciussantos.model.Tarefa;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.*;

import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class PessoaResponse {
    Long id;
    String nome;
    String departamento;
    @JsonIgnore
    List<Tarefa> tarefas;



}
