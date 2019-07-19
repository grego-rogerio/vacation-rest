package com.employee.vacationrest.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.employee.vacationrest.model.Ferias;
import com.employee.vacationrest.model.Funcionario;
import com.employee.vacationrest.repository.FeriasRepository;

@Service
public class FeriasService implements IFeriasService{

	@Autowired
    private FeriasRepository feriasRepository;
	
	@Override
	public Optional<Ferias> getById(Integer id) {
		 Optional<Ferias> ferias = feriasRepository.findById(id);
		 return ferias;
	}

	@Override
	public Ferias save(Ferias ferias) {
		return feriasRepository.save(ferias);
	}

	@Override
	public void deleteById(Integer id) {
	     feriasRepository.deleteById(id);
	}
	
	public List<Ferias> findAll() {
	    return feriasRepository.findAll();
	}
	
	@Override
	public List<Ferias> findByMatricula(String matricula) {
		return feriasRepository.findByMatricula(matricula);
	}
	

}
