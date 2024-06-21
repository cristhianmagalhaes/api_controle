package com.cantinhodoparque.api_controle.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cantinhodoparque.api_controle.aluno.Aluno;
import com.cantinhodoparque.api_controle.aluno.AlunoRepository;
import com.cantinhodoparque.api_controle.aluno.DadosCadastroAluno;

@RestController
@RequestMapping("aluno")
public class AlunoController {
	
	@Autowired
	public AlunoRepository repository;
	
	@PostMapping
	public void cadastrar(@RequestBody DadosCadastroAluno dados) {
		repository.save(new Aluno(dados));
		
	}

}
