package com.amelosbc.base.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.amelosbc.base.model.Donor;
import com.amelosbc.base.service.DonorService;

@RestController
public class DonorController {

	@Autowired
	DonorService donorService;

	@GetMapping
	public String index() {
		return "index";
	}

	@GetMapping("/donor")
	public Iterable<Donor> view() {
		return donorService.findAll();
	}

	@PostMapping("/donor")
	public Donor create(@RequestBody Donor donor) {
		return donorService.save(donor);
	}

	@PutMapping("/donor")
	public Donor update(@RequestBody Donor donor) {
		return donorService.save(donor);
	}

	@DeleteMapping("/donor/{id}")
	public void delete(@PathVariable Integer id) {
		donorService.deleteById(id);
	}
}
