package com.employee.vacationrest.service;

import java.util.List;
import java.util.Optional;

import com.employee.vacationrest.model.Funcionario;

public interface IFuncionarioService {
	Optional<Funcionario> getById(Integer id);

	void deleteById(Integer id);

	Funcionario save(Funcionario funcionario);

	List<Funcionario> findAll();

	List<Funcionario> findAllToVacation(Integer qtdDias);
	
	List<Funcionario> funcionarioByEquipe(Integer idEquipe);

}
