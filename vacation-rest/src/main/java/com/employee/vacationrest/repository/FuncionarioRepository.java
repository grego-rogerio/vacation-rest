package com.employee.vacationrest.repository;

import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.employee.vacationrest.model.Ferias;
import com.employee.vacationrest.model.Funcionario;

public interface FuncionarioRepository extends JpaRepository<Funcionario, Integer>{

	@Query("select f from Ferias f where f.dataFim >= :dataCalculada and f.funcionario = :funcionario")
	List<Ferias> findAllToVacation(@Param("dataCalculada") Date dataCalculada, @Param("funcionario") Funcionario funcionario);

	@Query("select f from Funcionario f inner join f.equipe as d where d.id = :id")
	List<Funcionario> funcionarioByEquipe(@Param("id") int id);
}
