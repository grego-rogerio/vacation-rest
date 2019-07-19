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

import com.employee.vacationrest.model.Ferias;
import com.employee.vacationrest.model.Funcionario;
import com.employee.vacationrest.service.IFeriasService;

@RestController
@RequestMapping(value = "/ferias")
public class FeriasController {
	
	@Autowired
	private IFeriasService feriasService;

	@PostMapping
	public Ferias create(@RequestBody Ferias ferias) {
		return feriasService.save(ferias);
	}

	@GetMapping(path = { "/{id}" })
	public ResponseEntity findById(@PathVariable("id") int id) {
		Optional<Ferias> ferias = feriasService.getById(id);
		return feriasService.getById(id).map(record -> ResponseEntity.ok().body(record))
				.orElse(ResponseEntity.notFound().build());

	}

	@PutMapping(value = "/{id}")
	public ResponseEntity update(@PathVariable("id") int id, @RequestBody Ferias ferias) {
		return feriasService.getById(id).map(record -> {
			record.setFuncionario(ferias.getFuncionario());
			record.setDataInicio(ferias.getDataInicio());
			record.setDataFim(ferias.getDataFim());
			Ferias updated = feriasService.save(record);
			return ResponseEntity.ok().body(updated);
		}).orElse(ResponseEntity.notFound().build());
	}

	@DeleteMapping(path = { "/{id}" })
	public ResponseEntity<?> delete(@PathVariable int id) {
		return feriasService.getById(id).map(record -> {
			feriasService.deleteById(id);
			return ResponseEntity.ok().build();
		}).orElse(ResponseEntity.notFound().build());
	}

	// Listagem das férias;
	@GetMapping
	public List<Ferias> findAll() {
			return feriasService.findAll();
	}
	
	// Busca de férias por matrícula do funcionário. 
	@GetMapping(value = "listaPorMatricula/{matricula}")
	public List<Ferias> findByMatricula(@PathVariable("matricula") String matricula) {
			return feriasService.findByMatricula(matricula);
	}
	
}
