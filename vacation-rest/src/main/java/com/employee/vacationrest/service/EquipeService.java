package com.employee.vacationrest.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.employee.vacationrest.model.Equipe;
import com.employee.vacationrest.repository.EquipeRepository;

@Service
public class EquipeService implements IEquipeService{

	@Autowired
    private EquipeRepository equipeRepository;
	
	@Override
	public Optional<Equipe> getById(Integer id) {
		 Optional<Equipe> equipe = equipeRepository.findById(id);
		 return equipe;
	}

	@Override
	public Equipe save(Equipe equipe) {
		return equipeRepository.save(equipe);
	}

	@Override
	public void deleteById(Integer id) {
	     equipeRepository.deleteById(id);
	}
	
	
	public List<Equipe> findAll() {
	    return equipeRepository.findAll();
	}
	
}
