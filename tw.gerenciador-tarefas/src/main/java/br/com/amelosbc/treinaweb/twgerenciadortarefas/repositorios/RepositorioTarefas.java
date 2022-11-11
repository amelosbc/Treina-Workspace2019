package br.com.amelosbc.treinaweb.twgerenciadortarefas.repositorios;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.amelosbc.treinaweb.twgerenciadortarefas.modelos.Tarefa;

public interface RepositorioTarefas extends JpaRepository<Tarefa, Long>{

}
