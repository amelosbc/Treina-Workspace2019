package com.example.calendarioEventosManagerApp.model.repository;

import org.springframework.data.repository.CrudRepository;

import com.example.calendarioEventosManagerApp.model.Evento;

public interface EventoRepository extends CrudRepository<Evento, String>{

}
