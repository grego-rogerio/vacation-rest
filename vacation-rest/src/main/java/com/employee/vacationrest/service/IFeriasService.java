package com.employee.vacationrest.service;

import java.util.List;
import java.util.Optional;

import com.employee.vacationrest.model.Ferias;

public interface IFeriasService {
	
	Optional<Ferias> getById(Integer id);

	void deleteById(Integer id);

	Ferias save(Ferias ferias);

	List<Ferias> findAll();
	
	List<Ferias> findByMatricula(String matricula);
}
