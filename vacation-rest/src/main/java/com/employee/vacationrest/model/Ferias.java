package com.employee.vacationrest.model;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import com.fasterxml.jackson.annotation.JsonFormat;

@Entity
@Table(name = "ferias")
public class Ferias implements Serializable{
	
    private static final long serialVersionUID = 13678678671L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "id_ferias")
	private Integer id;
	@ManyToOne(fetch = FetchType.EAGER, targetEntity = Funcionario.class)
	@JoinColumn(name = "id_funcionario")
	private Funcionario funcionario;
	
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd/MM/yyyy")
	@Temporal(TemporalType.DATE)
	@Column(name = "dt_inicio")
	private Date dataInicio;
	
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd/MM/yyyy")
	@Temporal(TemporalType.DATE)
	@Column(name = "dt_fim")
	private Date dataFim;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Funcionario getFuncionario() {
		return funcionario;
	}

	public void setFuncionario(Funcionario funcionario) {
		this.funcionario = funcionario;
	}

	public Date getDataInicio() {
		return dataInicio;
	}

	public void setDataInicio(Date dataInicio) {
		this.dataInicio = dataInicio;
	}

	public Date getDataFim() {
		return dataFim;
	}

	public void setDataFim(Date dataFim) {
		this.dataFim = dataFim;
	}

	@Override
	public String toString() {
		return this.funcionario.toString() + " " + this.dataInicio.toString() + " " + this.dataFim.toString();
	}

	@Override
	public boolean equals(Object obj) {
		if (obj == null)
			return false;
		if (obj instanceof Ferias) {
			Ferias ferias = (Ferias) obj;
			if (ferias.funcionario.equals(this.funcionario) && ferias.dataInicio.equals(this.dataInicio)
					&& ferias.dataFim.equals(dataFim)) {
				return true;
			} else {
				return false;
			}
		}

		return super.equals(obj);
	}

	@Override
	public int hashCode() {
		return id * 36;
	}

}
