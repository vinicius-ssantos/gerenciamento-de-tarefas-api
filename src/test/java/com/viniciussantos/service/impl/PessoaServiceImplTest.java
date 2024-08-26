package com.viniciussantos.service.impl;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.viniciussantos.config.ContainersConfig;
import com.viniciussantos.dto.request.PessoaRequest;
import com.viniciussantos.dto.response.PessoaResponse;
import com.viniciussantos.model.Pessoa;
import com.viniciussantos.model.Tarefa;
import com.viniciussantos.repository.PessoaRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.Import;

import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;


@DataJpaTest(properties = {
        "spring.test.database.replace=none",
        "spring.datasource.url=jdbc:tc:postgresql:15-alpine:///"
})
@Import(ContainersConfig.class)
class PessoaServiceImplTest {

    @Mock
    private PessoaRepository pessoaRepository;

    @InjectMocks
    private PessoaServiceImpl pessoaService;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void whenAdicionarPessoa_thenReturnPessoaResponse() {
        PessoaRequest request = new PessoaRequest(
                 1L,
         "nome",
         "departamento",
       null
        );
        Pessoa pessoa = new Pessoa( 1L,
                "nome",
                "departamento",
                null);
        PessoaResponse response = new PessoaResponse( 1L,
                "nome",
                "departamento",
                null);

        when(pessoaRepository.save(any(Pessoa.class))).thenReturn(pessoa);

        PessoaResponse result = pessoaService.adicionarPessoa(request);

        assertNotNull(result);
        assertEquals(response.getNome(), result.getNome());
        verify(pessoaRepository, times(1)).save(any(Pessoa.class));
    }
    @Test
    void whenBuscarPorId_thenReturnPessoaResponse() {
        Pessoa pessoa = new Pessoa( 1L,
                "nome",
                "departamento",
                null);
        PessoaResponse response = new PessoaResponse(1L,
                "nome",
                "departamento",
                null);

        when(pessoaRepository.findById(anyLong())).thenReturn(Optional.of(pessoa));

        PessoaResponse result = pessoaService.buscarPorId(1L);

        assertNotNull(result);
        assertEquals(response.getNome(), result.getNome());
        verify(pessoaRepository, times(1)).findById(1L);
    }


}