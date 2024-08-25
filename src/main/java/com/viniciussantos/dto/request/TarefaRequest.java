package com.viniciussantos.dto.request;

import com.viniciussantos.enums.Status;
import com.viniciussantos.model.Pessoa;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class TarefaRequest {

    private Long id;
    private String titulo;
    private String descricao;
    private String prazo;
    private String departamento;
    private String duracao;
    private Pessoa pessoaAlocada; // TODO  nao é necessario ter no Post da requisicao
    private String status ;


}
