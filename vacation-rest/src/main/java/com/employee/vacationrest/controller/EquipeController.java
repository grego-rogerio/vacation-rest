package com.employee.vacationrest.controller;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.employee.vacationrest.model.Equipe;
import com.employee.vacationrest.service.IEquipeService;

@RestController
@RequestMapping(value = "/equipe")
public class EquipeController {

	@Autowired
	private IEquipeService equipeService;

	@PostMapping
	public Equipe create(@RequestBody Equipe equipe) {
		return equipeService.save(equipe);
	}

	@GetMapping(path = { "/{id}" })
	public ResponseEntity findById(@PathVariable("id") int id) {
		Optional<Equipe> equipe = equipeService.getById(id);
		return equipeService.getById(id).map(record -> ResponseEntity.ok().body(record))
				.orElse(ResponseEntity.notFound().build());

	}

	@PutMapping(value = "/{id}")
	public ResponseEntity update(@PathVariable("id") int id, @RequestBody Equipe equipe) {
		return equipeService.getById(id).map(record -> {
			record.setNome(equipe.getNome());
			Equipe updated = equipeService.save(record);
			return ResponseEntity.ok().body(updated);
		}).orElse(ResponseEntity.notFound().build());
	}

	@DeleteMapping(path = { "/{id}" })
	public ResponseEntity<?> delete(@PathVariable int id) {
		return equipeService.getById(id).map(record -> {
			equipeService.deleteById(id);
			return ResponseEntity.ok().build();
		}).orElse(ResponseEntity.notFound().build());
	}

	//Listagem das Equipes; 
	@GetMapping
	public List<Equipe> findAll() {
			return equipeService.findAll();
	}
}
