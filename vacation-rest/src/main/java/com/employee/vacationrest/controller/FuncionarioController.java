package com.employee.vacationrest.controller;

import java.util.List;
import java.util.Optional;
import java.util.Random;

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

import com.employee.vacationrest.model.Funcionario;
import com.employee.vacationrest.service.IFuncionarioService;

@RestController
@RequestMapping(value = "/funcionario")
public class FuncionarioController {

	@Autowired
	private IFuncionarioService funcionarioService;

	@PostMapping
	public Funcionario create(@RequestBody Funcionario funcionario) {
		return funcionarioService.save(funcionario);
	}

	// Visualização de detalhes de um funcionário (Criar uma tela); 
	@GetMapping(path = { "/{id}" })
	public ResponseEntity findById(@PathVariable("id") int id) {
		return funcionarioService.getById(id).map(record -> ResponseEntity.ok().body(record))
				.orElse(ResponseEntity.notFound().build());

	}

	@PutMapping(value = "/{id}")
	public ResponseEntity update(@PathVariable("id") int id, @RequestBody Funcionario funcionario) {
		return funcionarioService.getById(id).map(record -> {
			record.setNome(funcionario.getNome());
			record.setBairro(funcionario.getBairro());
			record.setCidade(funcionario.getCidade());
			record.setComplemento(funcionario.getComplemento());
			record.setDataContratacao(funcionario.getDataContratacao());
			record.setDataNascimento(funcionario.getDataNascimento());
			record.setEquipe(funcionario.getEquipe());
			record.setNumero(funcionario.getNumero());
			record.setPathImagem(funcionario.getPathImagem());
			record.setRua(funcionario.getRua());
			record.setUf(funcionario.getUf());
			Funcionario updated = funcionarioService.save(record);
			return ResponseEntity.ok().body(updated);
		}).orElse(ResponseEntity.notFound().build());
	}

	@DeleteMapping(path = { "/{id}" })
	public ResponseEntity<?> delete(@PathVariable int id) {
		return funcionarioService.getById(id).map(record -> {
			funcionarioService.deleteById(id);
			return ResponseEntity.ok().build();
		}).orElse(ResponseEntity.notFound().build());
	}

	// Listagem dos funcionários; 
	@GetMapping
	public List<Funcionario> findAll() {
			return funcionarioService.findAll();
	}
	
	// Listagem de funcionários que devem solicitar férias (funcionários que irão completar 2 anos sem
	// solicitar férias em no máximo X meses) ; 
	@GetMapping(value = "listaParaFerias/{qtdDias}")
	public List<Funcionario> findAllToVacation(@PathVariable("qtdDias") int qtdDias) {
			return funcionarioService.findAllToVacation(qtdDias);
	}
	
	// Caso a equipe tenha até 4 pessoas, não é permitido duas pessoas tirarem férias em
	// períodos que tenha ao menos um dia coincidente. 
	@GetMapping(value = "funcionarioPorEquipe/{idEquipe}")
	public List<Funcionario> funcionarioByEquipe(@PathVariable("idEquipe") int idEquipe) {
			return funcionarioService.funcionarioByEquipe(idEquipe);
	}
	
	
}
