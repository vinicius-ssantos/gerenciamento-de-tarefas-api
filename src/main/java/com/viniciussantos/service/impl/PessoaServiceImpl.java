package com.viniciussantos.service.impl;

import com.viniciussantos.dto.request.PessoaRequest;
import com.viniciussantos.dto.response.PessoaResponse;
import com.viniciussantos.exception.RecursoNaoEncontradoException;
import com.viniciussantos.model.Pessoa;
import com.viniciussantos.repository.PessoaRepository;
import com.viniciussantos.service.PessoaService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PessoaServiceImpl implements PessoaService {
    public PessoaRepository pessoaRepository;

    public PessoaServiceImpl(PessoaRepository pessoaRepository) {
        this.pessoaRepository = pessoaRepository;
    }

    @Override
    public PessoaResponse adicionarPessoa(PessoaRequest pessoaRequest) {
        Pessoa pessoa = pessoaRequestToPessoa(pessoaRequest);
        return pessoaToPessoaResponse(pessoaRepository.save(pessoa));

    }

    @Override
    public PessoaResponse buscarPorId(Long id) {
        return this.pessoaRepository.findById(id)
                .stream()
                .map(this::pessoaToPessoaResponse)
                .findFirst()
                .orElseThrow(() -> new RuntimeException("Pessoa não encontrada"));
    }

    @Override
    public List<PessoaResponse> listar() {
        return this.pessoaRepository.findAll()
                .stream()
                .map(this::pessoaToPessoaResponse)
                .toList();
    }

    @Override
    public PessoaResponse atualizar(PessoaRequest pessoaRequest, Long id) {

        Pessoa pessoa = pessoaRepository.findById(id)
                .orElseThrow(() -> new RecursoNaoEncontradoException("Pessoa não encontrada"));

        pessoa.setNome(pessoaRequest.getNome());
        pessoa.setDepartamento(pessoaRequest.getDepartamento());
        pessoa.setTarefas(pessoaRequest.getTarefas());

        Pessoa pessoaAtualizada = pessoaRepository.save(pessoa);
        return pessoaToPessoaResponse(pessoaAtualizada);

    }

    @Override
    public void deletar(Long id) {
        this.pessoaRepository.deleteById(id);
    }


//        public Pessoa pessoaRequestToPessoa(PessoaRequest pessoaRequest) {
//            Pessoa pessoa = new Pessoa();
//            Field[] fields = PessoaRequest.class.getDeclaredFields();
//
//            for (Field field : fields) {
//                field.setAccessible(true);
//                try {
//                    Field pessoaField = Pessoa.class.getDeclaredField(field.getName());
//                    pessoaField.setAccessible(true);
//                    pessoaField.set(pessoa, field.get(pessoaRequest));
//                } catch (NoSuchFieldException | IllegalAccessException e) {
//                    e.printStackTrace();
//                }
//            }
//            return pessoa;
//    }

    public Pessoa pessoaRequestToPessoa(PessoaRequest pessoaRequest) {
        Pessoa pessoa = new Pessoa();
        pessoa.setId(pessoaRequest.getId());
        pessoa.setNome(pessoaRequest.getNome());
        pessoa.setDepartamento(pessoaRequest.getDepartamento());
        pessoa.setTarefas(pessoaRequest.getTarefas());
        return pessoa;
    }


    private PessoaResponse pessoaToPessoaResponse(Pessoa pessoa) {
        return new PessoaResponse
                (pessoa.getId(),
                        pessoa.getNome(),
                        pessoa.getDepartamento(),
                        pessoa.getTarefas());
    }

}
