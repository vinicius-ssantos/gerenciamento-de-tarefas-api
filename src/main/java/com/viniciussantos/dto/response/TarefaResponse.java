package com.viniciussantos.dto.response;

import com.viniciussantos.model.Pessoa;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class TarefaResponse {
    private Long id;
    private String titulo;
    private String descricao;
    private String prazo;
    private String departamento;
    private String duracao;
    private Pessoa pessoaAlocada;
    private String status ;


}
