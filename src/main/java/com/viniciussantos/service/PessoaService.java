package com.viniciussantos.service;


import com.viniciussantos.dto.request.PessoaRequest;
import com.viniciussantos.dto.response.PessoaResponse;
import com.viniciussantos.model.Pessoa;

import java.util.List;

public interface PessoaService  {
    PessoaResponse adicionarPessoa(PessoaRequest pessoaRequest);

    public List<PessoaResponse> listar();
    public PessoaResponse buscarPorId(Long id);
    public PessoaResponse atualizar(PessoaRequest pessoaRequest, Long id);
    public void deletar(Long id);
}
