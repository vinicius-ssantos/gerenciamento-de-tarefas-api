package com.viniciussantos.controller;


import com.viniciussantos.dto.request.PessoaRequest;
import com.viniciussantos.dto.response.PessoaResponse;
import com.viniciussantos.model.Pessoa;
import com.viniciussantos.service.PessoaService;
import com.viniciussantos.service.impl.PessoaServiceImpl;
import jakarta.validation.Valid;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;


@RestController
public class PessoaController {

    public final PessoaService pessoaService;


    public PessoaController(PessoaService pessoaService) {
        this.pessoaService = pessoaService;

    }

    @PostMapping("post/pessoas")
    public ResponseEntity<?> adicionar(@Valid @RequestBody PessoaRequest pessoaRequest) {
        PessoaResponse pessoaSalva = pessoaService.adicionarPessoa(pessoaRequest);
        return new ResponseEntity<>(pessoaSalva, HttpStatus.CREATED);
    }
    @PutMapping("put/pessoas/{id}")
    public ResponseEntity<?> alterar(@Valid @RequestBody PessoaRequest pessoaRequest, @PathVariable Long id) {
        PessoaResponse pessoaAtualizada = pessoaService.atualizar(pessoaRequest, id);
        return new ResponseEntity<>(pessoaAtualizada, HttpStatus.OK);
    }

    @GetMapping("get/pessoas")
    public ResponseEntity<?> listar() {
        List<PessoaResponse> pessoas = pessoaService.listar();
        return new ResponseEntity<>(pessoas, HttpStatus.OK);
    }

    @DeleteMapping("delete/pessoas/{id}")
    public ResponseEntity<?> deletar(@PathVariable Long id) {
        pessoaService.deletar(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @GetMapping("get/pessoas/gastos")
    public ResponseEntity<Double> getMediaHorasGastas(
            @RequestParam String nome,
            @RequestParam @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate dataInicial,
            @RequestParam @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate dataFinal) {
        double mediaHoras = pessoaService.calcularMediaHoras(nome, dataInicial, dataFinal);
        return ResponseEntity.ok(mediaHoras);
    }


}
