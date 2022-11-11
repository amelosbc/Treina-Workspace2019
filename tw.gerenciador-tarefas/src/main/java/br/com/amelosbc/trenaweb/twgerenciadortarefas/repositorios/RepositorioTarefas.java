package br.com.amelosbc.trenaweb.twgerenciadortarefas.repositorios;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.amelosbc.treinaweb.twgerenciadortarefas.modelos.Tarefa;

public interface RepositorioTarefas extends JpaRepository<Tarefa, Long>{

}
