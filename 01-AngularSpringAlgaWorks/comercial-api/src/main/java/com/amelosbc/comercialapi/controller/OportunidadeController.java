package com.amelosbc.comercialapi.controller;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import com.amelosbc.comercialapi.model.Oportunidade;
import com.amelosbc.comercialapi.repository.OportunidadeRepository;

@CrossOrigin
@RestController
@RequestMapping("/oportunidades")
public class OportunidadeController {

	//	@GetMapping
//	public List <Oportunidade> Listar() {
//		Oportunidade oportunidade = new Oportunidade();
//		oportunidade.setId(1L);
//		oportunidade.setDescricao("Oportunidade de venda CRM");
//		oportunidade.setNomeProspecto("Venda CRM");
//		oportunidade.setValor(new BigDecimal(49000));
//		
//		return Arrays.asList(oportunidade);
//}		
	@Autowired
	private OportunidadeRepository oportunidades;
	
	@GetMapping
	public List<Oportunidade> listar(){
		return oportunidades.findAll();
	}
	
	@GetMapping("/{id}")
	public  ResponseEntity<Oportunidade> buscar (@PathVariable Long id) {
		Optional<Oportunidade> oportunidade= oportunidades.findById(id);
		
		if (oportunidade.isPresent()) {
			return ResponseEntity.notFound().build();
		}
		return ResponseEntity.ok(oportunidade.get());
	}
	
	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	public Oportunidade adicionar (@Valid @RequestBody Oportunidade oportunidade) {
		Optional <Oportunidade> oportunidadeExistente = oportunidades.findByDescricaoAndNomeProspecto(oportunidade.getDescricao(), oportunidade.getNomeProspecto());
	
		if (oportunidadeExistente.isPresent()) {
			throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Já existe uma oportunidade para este prospecto com a mesma descrição");
			
		}
		return oportunidades.save(oportunidade);
	}
}
