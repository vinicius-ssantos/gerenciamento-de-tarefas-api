package com.viniciussantos.service;


import com.viniciussantos.dto.request.PessoaRequest;
import com.viniciussantos.dto.response.PessoaListaTarefaResponse;
import com.viniciussantos.dto.response.PessoaResponse;
import com.viniciussantos.dto.response.TarefaResponse;
import com.viniciussantos.model.Pessoa;

import java.time.LocalDate;
import java.util.List;

public interface PessoaService  {
    PessoaResponse adicionarPessoa(PessoaRequest pessoaRequest);

    public List<PessoaResponse> listar();
    public double calcularMediaHoras(String nome, LocalDate dataInicial, LocalDate dataFinal);
    public PessoaResponse buscarPorId(Long id);
    public PessoaResponse atualizar(PessoaRequest pessoaRequest, Long id);
    public void deletar(Long id);
    List<PessoaListaTarefaResponse> listarTarefas(Long id);
}
