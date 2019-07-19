package com.employee.vacationrest.service;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.employee.vacationrest.model.Ferias;
import com.employee.vacationrest.model.Funcionario;
import com.employee.vacationrest.repository.FuncionarioRepository;

@Service
public class FuncionarioService implements IFuncionarioService{

	@Autowired
    private FuncionarioRepository funcionarioRepository;
	
	@Override
	public Optional<Funcionario> getById(Integer id) {
		 Optional<Funcionario> funcionario = funcionarioRepository.findById(id);
		 return funcionario;
	}

	@Override
	public Funcionario save(Funcionario funcionario) {
		Random random = new Random(); 
		int n = random.nextInt(6);
		//Gerar a Matricula Automatico.
		funcionario.setMatricula(String.valueOf(n));
		return funcionarioRepository.save(funcionario);
	}

	@Override
	public void deleteById(Integer id) {
	     funcionarioRepository.deleteById(id);
	}
	
	@Override
	public List<Funcionario> findAll() {
	    return funcionarioRepository.findAll();
	}
	
	@Override
	public List<Funcionario> findAllToVacation(Integer qtdDias) {
		List<Funcionario> funcionarios = funcionarioRepository.findAll();
		List<Funcionario> funcionariosFerias = new ArrayList<Funcionario>();
		for(Funcionario funcionario:funcionarios) {
			List<Ferias> ferias = funcionarioRepository.findAllToVacation(CalcularData(qtdDias), funcionario);
			if(ferias != null && ferias.isEmpty()) {
				funcionariosFerias.add(funcionario);
			};
		}
		return funcionariosFerias;
	}

	private Date CalcularData(Integer qtdDias) {
	
		Date dataCalculada = new Date();
		Calendar c = Calendar.getInstance();
		c.setTime(dataCalculada);
		c.add(Calendar.DATE, qtdDias);
		c.add(Calendar.YEAR, -2);
		dataCalculada = c.getTime();
		System.out.println("Data calculada!" + dataCalculada);
		return dataCalculada;
	}

	@Override
	public List<Funcionario> funcionarioByEquipe(Integer idEquipe) {
		List<Funcionario> funcionarios = funcionarioRepository.funcionarioByEquipe(idEquipe);
		return funcionarioRepository.funcionarioByEquipe(idEquipe);
	}
	
}
