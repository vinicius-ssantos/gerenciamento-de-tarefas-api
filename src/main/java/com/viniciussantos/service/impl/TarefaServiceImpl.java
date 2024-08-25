package com.viniciussantos.service.impl;

import com.viniciussantos.dto.request.PessoaRequest;
import com.viniciussantos.dto.request.TarefaRequest;
import com.viniciussantos.dto.response.TarefaResponse;
import com.viniciussantos.enums.Status;
import com.viniciussantos.exception.DepartamentoMismatchException;
import com.viniciussantos.model.Pessoa;
import com.viniciussantos.model.Tarefa;
import com.viniciussantos.repository.PessoaRepository;
import com.viniciussantos.repository.TarefaRepository;
import com.viniciussantos.service.TarefaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class TarefaServiceImpl implements TarefaService {

    @Autowired
    public TarefaRepository tarefaRepository;

    @Autowired
    public PessoaRepository pessoaRepository;


    @Override
    public TarefaResponse adicionarTarefa(TarefaRequest tarefaRequest) {
        Tarefa tarefa = tarefaRequestToTarefa(tarefaRequest);
        return tarefaToTarefaResponse(tarefaRepository.save(tarefa));
    }

    @Override
    public TarefaResponse AlocarPessoa(PessoaRequest pessoaRequest, Long id) {
        var tarefaDB = buscarPorId(id);
        Pessoa pessoaDB = pessoaRepository.getReferenceById(pessoaRequest.getId());
        System.out.println("DEPARTAMENTO TAREFA: " + tarefaDB.getDepartamento());
        System.out.println("##############################################");
        System.out.println("DEPARTAMENTO PESSOA: " + pessoaDB.getDepartamento());
        if (!tarefaDB.getDepartamento().equals(pessoaRequest.getDepartamento())) {
            throw new DepartamentoMismatchException("Departamento da tarefa não corresponde ao departamento da pessoa");
        }
        tarefaDB.setPessoaAlocada(pessoaRequestToPessoa(pessoaRequest));
        Tarefa tarefaSalva = tarefaRepository.save(tarefaResponseToTarefa(tarefaDB));
        return tarefaToTarefaResponse(tarefaSalva);
    }

    @Override
    public TarefaResponse finalizarTarefa(Long id) {
        var tarefaDB = buscarPorId(id);
        tarefaDB.setStatus(Status.COMPLETO.getStatus());
        Tarefa tarefaSalva = tarefaRepository.save(tarefaResponseToTarefa(tarefaDB));
        return tarefaToTarefaResponse(tarefaSalva);
    }


    @Override
    public List<TarefaResponse> listar() {
        return List.of();
    }

    @Override
    public TarefaResponse buscarPorId(Long id) {
        return this.tarefaRepository.findById(id)
                .stream()
                .map(this::tarefaToTarefaResponse)
                .findFirst()
                .orElseThrow(() -> new RuntimeException("Tarefa não encontrada"));
    }

    @Override
    public TarefaResponse atualizar(TarefaRequest tarefaRequest, Long id) {
        return null;
    }

    @Override
    public void deletar(Long id) {

    }


    public Tarefa tarefaRequestToTarefa(TarefaRequest tarefaRequest) {
        Tarefa tarefa = new Tarefa();
        tarefa.setTitulo(tarefaRequest.getTitulo());
        tarefa.setDescricao(tarefaRequest.getDescricao());
        tarefa.setPrazo(tarefaRequest.getPrazo());
        tarefa.setDepartamento(tarefaRequest.getDepartamento());
        tarefa.setDuracao(tarefaRequest.getDuracao());
        tarefa.setPessoa(tarefaRequest.getPessoaAlocada());
        tarefa.setStatus(tarefaRequest.getStatus());
        return tarefa;
    }

    private TarefaResponse tarefaToTarefaResponse(Tarefa tarefa) {
        TarefaResponse tarefaResponse = new TarefaResponse();
        tarefaResponse.setId(tarefa.getId());
        tarefaResponse.setTitulo(tarefa.getTitulo());
        tarefaResponse.setDescricao(tarefa.getDescricao());
        tarefaResponse.setPrazo(tarefa.getPrazo());
        tarefaResponse.setDepartamento(tarefa.getDepartamento());
        tarefaResponse.setDuracao(tarefa.getDuracao());
        tarefaResponse.setPessoaAlocada(tarefa.getPessoa());
        tarefaResponse.setStatus(tarefa.getStatus());
        return tarefaResponse;
    }

    private Tarefa tarefaResponseToTarefa(TarefaResponse tarefaResponse) {
        Tarefa tarefa = new Tarefa();
        tarefa.setId(tarefaResponse.getId());
        tarefa.setTitulo(tarefaResponse.getTitulo());
        tarefa.setDescricao(tarefaResponse.getDescricao());
        tarefa.setPrazo(tarefaResponse.getPrazo());
        tarefa.setDepartamento(tarefaResponse.getDepartamento());
        tarefa.setDuracao(tarefaResponse.getDuracao());
        tarefa.setPessoa(tarefaResponse.getPessoaAlocada());
        tarefa.setStatus(tarefaResponse.getStatus());
        return tarefa;
    }

    public Pessoa pessoaRequestToPessoa(PessoaRequest pessoaRequest) {
        Pessoa pessoa = new Pessoa();
        pessoa.setId(pessoaRequest.getId());
        pessoa.setNome(pessoaRequest.getNome());
        pessoa.setDepartamento(pessoaRequest.getDepartamento());
        pessoa.setTarefas(pessoaRequest.getTarefas());
        return pessoa;
    }
}
