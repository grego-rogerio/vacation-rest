package com.employee.vacationrest.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "equipe")
public class Equipe implements Serializable{
	
    private static final long serialVersionUID = 14352312L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "id_equipe")
	private Integer id;
	private String nome;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	@Override
	public String toString() {
		return this.nome;
	}

	@Override
	public boolean equals(Object obj) {
		if (obj == null)
			return false;
		if (obj instanceof Equipe) {
			if (((Equipe) obj).nome.equals(this.nome)) {
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
