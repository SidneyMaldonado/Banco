package com.teste.mark1.banco.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.Pattern;

import org.springframework.beans.factory.annotation.Required;

@Entity
@Table(name="funcionario")
public class Funcionario {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="codigo")
	private Integer codigo;
	
	@Column(name="nome", nullable = false, length = 50)
	@Pattern(regexp="[A-z]{10,50}", message="O Email é inválido!")
	private String nome;
	
	@Min(value=0, message="O valor não pode ser abaixo de zero.")
	@Max(value=1000, message="O valor não pode ser acima de 1000")
	@Column(name="salario", nullable = false, precision=16, scale=2)
	private Double salario;
		
	@Column(name="codigosetor", nullable = false, precision=11, scale=0)
	private Integer codigoSetor;

	public Integer getCodigo() {
		return codigo;
	}
	public void setCodigo(Integer codigo) {
		this.codigo = codigo;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public Double getSalario() {
		return salario;
	}
	public void setSalario(Double salario) {
		this.salario = salario;
	}
	public Integer getCodigoSetor() {
		return codigoSetor;
	}
	public void setCodigoSetor(Integer codigoSetor) {
		this.codigoSetor = codigoSetor;
	}

	
	
	
	
	

}
