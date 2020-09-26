package com.example.calendarioEventosManagerApp.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.example.calendarioEventosManagerApp.model.Evento;
import com.example.calendarioEventosManagerApp.model.repository.EventoRepository;

@Controller
public class EventoController {

	@Autowired
	private EventoRepository er;
	
	@RequestMapping(value="/cadastrarEvento", method=RequestMethod.GET)
	public String form() {
		return "evento/eventoForm";
	}
	
	@RequestMapping(value="/cadastrarEvento", method=RequestMethod.POST)
	public String form(Evento evento) {
		
		er.save(evento);
		return "redirect:/cadastrarEvento";
	}
	
	@RequestMapping("/eventos")
	public ModelAndView listaEventos() {
		
		ModelAndView mv = new ModelAndView("index");
		Iterable<Evento> evento = er.findAll();
		
		// a view atribui a lista de eventos recebida acima para o objeto que será usada para segurar 
		// a lista de eventos na página web, abaixo o 1o parametro que é o mesmo que é usado na pagina index.html
		mv.addObject("eventosWeb", evento);
		return mv;
	}
	

}
