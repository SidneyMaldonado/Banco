package com.teste.mark1.banco.biz;

import org.springframework.beans.factory.annotation.Autowired;

import com.teste.mark1.banco.Mensagem;
import com.teste.mark1.banco.entities.Funcionario;
import com.teste.mark1.banco.repositories.SetorRepository;

public class FuncionarioBiz {
	
	public Mensagem msg;
	
	@Autowired
	public SetorRepository setorRepositorio;
	
	public FuncionarioBiz(SetorRepository setorRepo) {
		this.setorRepositorio = setorRepo;
		msg = new Mensagem();
	}

	public Boolean Validade(Funcionario funcionario) {
	
		Boolean result = true;
		if (funcionario.getNome().isEmpty()) {
			msg.mensagens.add("O nome do funcionario não pode ser vazio");
			result = false;
		}
		if (funcionario.getNome().startsWith("PP")) {
			msg.mensagens.add("O nome do funcionario é inválido");
			result = false;
		}
		
		if (setorRepositorio.findById( funcionario.getCodigoSetor() ).isEmpty()) {
			msg.mensagens.add( "O setor escolhido não é válido");
			result = false;
		}
		
		if (funcionario.getSalario() < 0) {
			msg.mensagens.add( "O salario não pode ser negativo");
			result = false;
		}
		
		if (funcionario.getSalario() > 10000) {
			msg.mensagens.add("O salario não pode exceder 10000");
			result = false;
		}
		
		return result;
		
	}

}
