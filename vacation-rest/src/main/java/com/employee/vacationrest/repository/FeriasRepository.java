package com.employee.vacationrest.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.employee.vacationrest.model.Ferias;

public interface FeriasRepository extends JpaRepository<Ferias, Integer>{

	@Query("select f from Ferias f inner join f.funcionario as d\n" + 
			"  where d.matricula = :matricula")
	List<Ferias> findByMatricula(@Param("matricula") String matricula);

}
