package com.viniciussantos.service;

import com.viniciussantos.dto.request.PessoaRequest;
import com.viniciussantos.dto.request.TarefaRequest;
import com.viniciussantos.dto.response.PessoaResponse;
import com.viniciussantos.dto.response.TarefaResponse;

import java.util.List;

public interface TarefaService {
    TarefaResponse adicionarTarefa(TarefaRequest tarefaRequest);

    TarefaResponse AlocarPessoa(PessoaRequest pessoaRequest, Long id);

    TarefaResponse finalizarTarefa(Long id);

    public List<TarefaResponse> listar();

    public TarefaResponse buscarPorId(Long id);

    public TarefaResponse atualizar(TarefaRequest tarefaRequest, Long id);

    public void deletar(Long id);
}
