package com.viniciussantos.model;


import com.viniciussantos.enums.Status;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
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
@Entity
public class Tarefa {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "O título da tarefa é obrigatório.")
    private String titulo;

    @NotBlank(message = "A descrição da tarefa é obrigatória.")
    private String descricao;


   @NotNull(message = "O prazo da tarefa é obrigatório.")
    private LocalDate prazo;

    @NotBlank(message = "O departamento da tarefa é obrigatório.")
    private String departamento;


    @NotNull(message = "A duração da tarefa é obrigatória.")
    private Integer duracao;

    @ManyToOne()
    @JoinColumn(name = "pessoa_id")
    private Pessoa pessoa;

    private String status = Status.PENDENDTE.getStatus();


}
