package com.employee.vacationrest.service;

import java.util.List;
import java.util.Optional;

import com.employee.vacationrest.model.Equipe;

public interface IEquipeService {

	Optional<Equipe> getById(Integer id);

	void deleteById(Integer id);

	Equipe save(Equipe equipe);

	List<Equipe> findAll();

}
