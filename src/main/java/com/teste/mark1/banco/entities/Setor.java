package com.teste.mark1.banco.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="setor")
public class Setor {

	@Id
	@GeneratedValue( strategy = GenerationType.AUTO)
	@Column(name= "codigosetor")
	public Integer codigoSetor;
	
	@Column(name= "nome")
	public String nome;
}
