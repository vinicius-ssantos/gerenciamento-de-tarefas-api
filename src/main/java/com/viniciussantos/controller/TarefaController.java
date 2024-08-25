package com.viniciussantos.controller;

import com.viniciussantos.dto.request.PessoaRequest;
import com.viniciussantos.dto.request.TarefaRequest;
import com.viniciussantos.dto.response.PessoaResponse;
import com.viniciussantos.dto.response.TarefaResponse;
import com.viniciussantos.service.PessoaService;
import com.viniciussantos.service.TarefaService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController
public class TarefaController {

    public final TarefaService tarefaService;

    public TarefaController(TarefaService tarefaService) {
        this.tarefaService = tarefaService;
    }


    @PostMapping("post/tarefas")
    public ResponseEntity<?> adicionarTarefa(@Valid @RequestBody TarefaRequest tarefaRequest) {
        TarefaResponse tarefaResponse = tarefaService.adicionarTarefa(tarefaRequest);
        return new ResponseEntity<>(tarefaResponse, HttpStatus.CREATED);
    }

    @PutMapping("put/tarefas/alocar/{id}")
    public ResponseEntity<?> alocarPessoa(@Valid @RequestBody TarefaRequest tarefaRequest,
                                          @PathVariable Long id) {
        TarefaResponse tarefaResponse = tarefaService.AlocarPessoa(tarefaRequest, id);
        return new ResponseEntity<>(tarefaResponse, HttpStatus.OK);
    }
}
