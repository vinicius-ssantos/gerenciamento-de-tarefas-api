package com.viniciussantos.repository;


import com.viniciussantos.model.Tarefa;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;


@Repository
public interface TarefaRepository extends JpaRepository<Tarefa, Long> {

    @Query("SELECT t FROM Tarefa t WHERE t.pessoa.nome = :nome AND t.prazo BETWEEN :dataInicial AND :dataFinal")
    List<Tarefa> findByPessoaNomeAndPeriodo(@Param("nome") String nome, @Param("dataInicial") LocalDate dataInicial, @Param("dataFinal") LocalDate dataFinal);

}
