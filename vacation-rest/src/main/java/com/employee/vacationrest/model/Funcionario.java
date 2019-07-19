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
@Table(name = "funcionario")
public class Funcionario implements Serializable{
	
    private static final long serialVersionUID = 113231231231L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "id_funcionario")
	private Integer id;
	private String nome;
	
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd/MM/yyyy")
	@Temporal(TemporalType.DATE)
	@Column(name = "dt_nascimento")
	private Date dataNascimento;
	private String rua;
	private String numero;
	private String complemento;
	private String bairro;
	private String cidade;
	private String uf;
	
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd/MM/yyyy")
	@Temporal(TemporalType.DATE)
	@Column(name="dt_contratacao")
	private Date dataContratacao;
	
	@Column(name = "path_imagem")
	private String pathImagem;
	
	@ManyToOne(fetch = FetchType.EAGER, targetEntity = Equipe.class)
	@JoinColumn(name = "id_equipe")
	private Equipe equipe;
	private String matricula;

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

	public Date getDataNascimento() {
		return dataNascimento;
	}

	public void setDataNascimento(Date dataNascimento) {
		this.dataNascimento = dataNascimento;
	}

	public String getRua() {
		return rua;
	}

	public void setRua(String rua) {
		this.rua = rua;
	}

	public String getNumero() {
		return numero;
	}

	public void setNumero(String numero) {
		this.numero = numero;
	}

	public String getComplemento() {
		return complemento;
	}

	public void setComplemento(String complemento) {
		this.complemento = complemento;
	}

	public String getBairro() {
		return bairro;
	}

	public void setBairro(String bairro) {
		this.bairro = bairro;
	}

	public String getCidade() {
		return cidade;
	}

	public void setCidade(String cidade) {
		this.cidade = cidade;
	}

	public String getUf() {
		return uf;
	}

	public void setUf(String uf) {
		this.uf = uf;
	}

	public Date getDataContratacao() {
		return dataContratacao;
	}

	public void setDataContratacao(Date dataContratacao) {
		this.dataContratacao = dataContratacao;
	}

	public String getPathImagem() {
		return pathImagem;
	}

	public void setPathImagem(String pathImagem) {
		this.pathImagem = pathImagem;
	}

	public Equipe getEquipe() {
		return equipe;
	}

	public void setEquipe(Equipe equipe) {
		this.equipe = equipe;
	}

	public String getMatricula() {
		return matricula;
	}

	public void setMatricula(String matricula) {
		this.matricula = matricula;
	}

	@Override
	public String toString() {
		return this.nome;
	}

	@Override
	public boolean equals(Object obj) {
		if (obj == null)
			return false;
		if (obj instanceof Funcionario) {
			if (((Funcionario) obj).nome.equals(this.nome)) {
				return true;
			} else {
				return false;
			}
		}

		return super.equals(obj);
	}

	@Override
	public int hashCode() {
		return id * 56;
	}
}
