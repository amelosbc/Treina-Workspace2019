package br.com.amelosbc.treinaweb.twgerenciadortarefas.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

// controllers faz a ligação de requisições web com a aplicação java
@Controller
public class HomeControllers {
	
	// uma action que vai atender uma requisição
	// mapeia o action e onde ela será envocada
	@GetMapping("/")
	public ModelAndView home() {
		ModelAndView mv = new ModelAndView();
		mv.setViewName("home/home");
		mv.addObject("mensagem","Mensagem do controller");
		return mv;  // a view ou html q será devolvida
	}
}
