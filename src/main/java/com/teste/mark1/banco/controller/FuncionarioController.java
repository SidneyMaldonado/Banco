package com.teste.mark1.banco.controller;

import java.util.List;
import java.util.Set;

import javax.validation.ConstraintViolation;
import javax.validation.Valid;
import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.ValidatorFactory;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.teste.mark1.banco.Mensagem;
import com.teste.mark1.banco.biz.FuncionarioBiz;
import com.teste.mark1.banco.entities.Funcionario;
import com.teste.mark1.banco.repositories.FuncionarioRepository;
import com.teste.mark1.banco.repositories.SetorRepository;

@RestController
@RequestMapping("funcionario")
public class FuncionarioController {

	
	@Autowired
	private FuncionarioRepository funcionarioRepositorio;
	
	@Autowired
	private SetorRepository setorRepositorio;
	
	
	@GetMapping("listar")
	public List<Funcionario> listar(){
		
		List<Funcionario> lista = funcionarioRepositorio.findAll();
		return lista;
		
	}
	
	@PostMapping("incluir")
	public Mensagem salvar(@Valid @RequestBody Funcionario funcionario ) {
		
		FuncionarioBiz funcionarioBiz = new FuncionarioBiz(setorRepositorio);
/*
		ValidatorFactory vf = Validation.buildDefaultValidatorFactory();
		Validator validator = vf.getValidator();
		Set<ConstraintViolation<Funcionario>> violacoes = validator.validate(funcionario);
		
		for(ConstraintViolation<Funcionario> v: violacoes) {
			funcionarioBiz.msg.mensagens.add(v.getMessage());
		}
		*/
		try {
			
			if (funcionarioBiz.Validade(funcionario)) {
				this.funcionarioRepositorio.save(funcionario);
				this.funcionarioRepositorio.flush();
			} else {
				return funcionarioBiz.msg; 
			}
		} catch (Exception e) {
			funcionarioBiz.msg.mensagens.add(e.getMessage());
			return funcionarioBiz.msg;
		}
		funcionarioBiz.msg.mensagens.add("OK");
		
		return funcionarioBiz.msg;
		
	}
	
}
